package com.github.lapapesse02.va11halla_drinks.guis;

import com.github.lapapesse02.va11halla_drinks.block_entities.DrinkMakerEntity;
import com.github.lapapesse02.va11halla_drinks.custom_recipes.CustomRecipe;
import com.github.lapapesse02.va11halla_drinks.register.RegisterBlocks;
import com.github.lapapesse02.va11halla_drinks.register.RegisterItems;
import com.github.lapapesse02.va11halla_drinks.register.RegisterMiscellaneous;
import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.data.VerticalAlignment;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.TranslatableText;

import java.util.Optional;

public class DrinkMakerGuiDescription extends SyncedGuiDescription {
    public boolean isResultBlended = false;
    public boolean onTheRocks = false;
    public boolean aged = false;


    public DrinkMakerGuiDescription(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(RegisterMiscellaneous.SCREEN_HANDLER_TYPE, syncId, playerInventory, getBlockInventory(context, 9), getBlockPropertyDelegate(context));

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(150, 150);
        this.setTitleAlignment(HorizontalAlignment.CENTER);

        // buttons
        WToggleButton onTheRocks = new WToggleButton().setOnToggle(ice -> this.onTheRocks = ice)
                .setLabel(new TranslatableText("label.va11halla_drinks.ontherocks"));
        root.add(onTheRocks, 2, 1);

        WToggleButton aged = new WToggleButton().setOnToggle(age -> this.aged = age)
                .setLabel(new TranslatableText("label.va11halla_drinks.aged"));
        root.add(aged, 2, 2);

        WToggleButton blended = new WToggleButton().setOnToggle(blend -> this.isResultBlended = blend)
                .setLabel(new TranslatableText("label.va11halla_drinks.blend"));
        root.add(blended, 2, 3);

        WButton mixButton = new WButton().setOnClick(this::mix);
        root.add(mixButton, 2, 5);
        WLabel mixStatusLabel = new WLabel(" " + new TranslatableText("status.va11halla_drinks.make").getString()).setVerticalAlignment(VerticalAlignment.BOTTOM);
        root.add(mixStatusLabel, 3, 5);

        // images
        WItem adelhydeImage = new WItem(new ItemStack(RegisterItems.ADELHYDE));
        root.add(adelhydeImage, 6, 1);
        WItem powderedDeltaImage = new WItem(new ItemStack(RegisterItems.POWDERED_DELTA));
        root.add(powderedDeltaImage, 10, 1);
        WItem bronsonExtractImage = new WItem(new ItemStack(RegisterItems.BRONSON_EXTRACT));
        root.add(bronsonExtractImage, 8, 1);
        WItem flanergideImage = new WItem(new ItemStack(RegisterItems.FLANERGIDE));
        root.add(flanergideImage, 6, 3);
        WItem karmotrineImage = new WItem(new ItemStack(RegisterItems.KARMOTRINE));
        root.add(karmotrineImage, 10, 3);

        // slots
        WItemSlot adelhydeSlot = WItemSlot.of(blockInventory, 0).setFilter((stack) -> stack.getItem().equals(RegisterItems.ADELHYDE));
        root.add(adelhydeSlot, 6, 2);
        WItemSlot bronsonExtractSlot = WItemSlot.of(blockInventory, 1).setFilter((stack) -> stack.getItem().equals(RegisterItems.BRONSON_EXTRACT));
        root.add(bronsonExtractSlot, 8, 2);
        WItemSlot powderedDeltaSlot = WItemSlot.of(blockInventory, 2).setFilter((stack) -> stack.getItem().equals(RegisterItems.POWDERED_DELTA));
        root.add(powderedDeltaSlot, 10, 2);
        WItemSlot flanergideSlot = WItemSlot.of(blockInventory, 3).setFilter((stack) -> stack.getItem().equals(RegisterItems.FLANERGIDE));
        root.add(flanergideSlot, 6, 4);
        WItemSlot karmotrineSlot = WItemSlot.of(blockInventory, 4).setFilter((stack) -> stack.getItem().equals(RegisterItems.KARMOTRINE));
        root.add(karmotrineSlot, 10, 4);

        WItemSlot result = WItemSlot.of(blockInventory, 5).setInsertingAllowed(false);
        root.add(result, 8, 5);

        root.add(new WPlainPanel(), 12, 0);

        root.add(this.createPlayerInventoryPanel(), 2, 7);

        root.validate(this);

    }

    private void mix() {
        if (blockInventory.getStack(0).isEmpty() && blockInventory.getStack(1).isEmpty() && blockInventory.getStack(2).isEmpty() && blockInventory.getStack(3).isEmpty() && blockInventory.getStack(4).isEmpty()) {
            return;
        }
        convertSlot();
        makeDrink();
    }

    private void convertSlot() {
        // OH MY GOD PLEASE DONT ASK ABOUT THIS I DONT KNOW HOW TO PASS THE STATE OF THE
        // WIDGETS AND IF THE DRINK IS MIXED OR BLENDED PLEASE HELP

        for (int i = 6; i <= 8; i++) {
            if (blockInventory.getStack(i).isEmpty()) {
                blockInventory.setStack(i, new ItemStack(RegisterBlocks.DRINK_MAKER));
                blockInventory.getStack(i).setCount(1);
            }
        }

        if (this.onTheRocks) {
            blockInventory.getStack(6).setCount(2);
        } else {
            blockInventory.getStack(6).setCount(1);
        }
        if (this.aged) {
            blockInventory.getStack(7).setCount(2);
        } else {
            blockInventory.getStack(7).setCount(1);
        }
        if (this.isResultBlended) {
            blockInventory.getStack(8).setCount(2);
        } else {
            blockInventory.getStack(8).setCount(1);
        }
    }

    private void makeDrink() {
        if (world.isClient()) {
            DrinkMakerEntity inventory = new DrinkMakerEntity(blockInventory);

            Optional<CustomRecipe> match = world.getRecipeManager()
                    .getFirstMatch(CustomRecipe.Type.INSTANCE, inventory, world);

            ItemStack output;
            if (match.isPresent()) {
                output = match.get().getOutput().copy();
            } else {
                output = new ItemStack(RegisterItems.FAILED_DRINK);
            }

            PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());
            passedData.writeItemStack(output);

            ClientSidePacketRegistry.INSTANCE.sendToServer(RegisterMiscellaneous.DRINK_CRAFT_PACKET, passedData);

        }
    }
}
