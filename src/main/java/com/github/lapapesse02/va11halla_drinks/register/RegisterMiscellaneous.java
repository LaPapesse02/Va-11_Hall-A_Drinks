package com.github.lapapesse02.va11halla_drinks.register;

import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;
import com.github.lapapesse02.va11halla_drinks.ModStarter;
import com.github.lapapesse02.va11halla_drinks.custom_recipes.CustomRecipe;
import com.github.lapapesse02.va11halla_drinks.custom_recipes.CustomRecipeSerializer;
import com.github.lapapesse02.va11halla_drinks.guis.DrinkMakerGuiDescription;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Arrays;

public class RegisterMiscellaneous {
    public static final ItemGroup MOD_GROUP;
    public static final Identifier DRINK_CRAFT_PACKET;
    public static ScreenHandlerType<DrinkMakerGuiDescription> SCREEN_HANDLER_TYPE;

    static {
        MOD_GROUP = FabricItemGroupBuilder.create(new Identifier(ModStarter.MOD_ID, "mod_group"))
                .icon(() -> new ItemStack(RegisterItems.COBALT_VELVET))
                .appendItems(stacks -> {
                    // blocks
                    stacks.add(new ItemStack(RegisterBlocks.DRINK_MAKER));

                    // recipe book
                    stacks.add(new ItemStack(RegisterItems.RECIPE_BOOK));

                    // ingredients
                    stacks.add(new ItemStack(RegisterItems.ADELHYDE));
                    stacks.add(new ItemStack(RegisterItems.BRONSON_EXTRACT));
                    stacks.add(new ItemStack(RegisterItems.POWDERED_DELTA));
                    stacks.add(new ItemStack(RegisterItems.FLANERGIDE));
                    stacks.add(new ItemStack(RegisterItems.KARMOTRINE));

                    // craftable drinks
                    stacks.add(new ItemStack(RegisterItems.BAD_TOUCH));
                    stacks.add(new ItemStack(RegisterItems.BEER));
                    stacks.add(new ItemStack(RegisterItems.BLEEDING_JANE));
                    stacks.add(new ItemStack(RegisterItems.BLOOM_LIGHT));
                    stacks.add(new ItemStack(RegisterItems.BLUE_FAIRY));
                    stacks.add(new ItemStack(RegisterItems.BRANDTINI));
                    stacks.add(new ItemStack(RegisterItems.COBALT_VELVET));
                    stacks.add(new ItemStack(RegisterItems.CREVICE_SPIKE));
                    stacks.add(new ItemStack(RegisterItems.FLAMING_MOAI));
                    stacks.add(new ItemStack(RegisterItems.FLUFFY_DREAM));
                    stacks.add(new ItemStack(RegisterItems.FRINGE_WEAVER));
                    stacks.add(new ItemStack(RegisterItems.FROTHY_WATER));
                    stacks.add(new ItemStack(RegisterItems.GRIZZLY_TEMPLE));
                    stacks.add(new ItemStack(RegisterItems.GUT_PUNCH));
                    stacks.add(new ItemStack(RegisterItems.MARSBLAST));
                    stacks.add(new ItemStack(RegisterItems.MERCURYBLAST));
                    stacks.add(new ItemStack(RegisterItems.MOONBLAST));
                    stacks.add(new ItemStack(RegisterItems.PIANO_MAN));
                    stacks.add(new ItemStack(RegisterItems.PIANO_WOMAN));
                    stacks.add(new ItemStack(RegisterItems.PILE_DRIVER));
                    stacks.add(new ItemStack(RegisterItems.SPARKLE_STAR));
                    stacks.add(new ItemStack(RegisterItems.SUGAR_RUSH));
                    stacks.add(new ItemStack(RegisterItems.SUNSHINE_CLOUD));
                    stacks.add(new ItemStack(RegisterItems.SUPLEX));
                    stacks.add(new ItemStack(RegisterItems.ZEN_STAR));

                    stacks.add(new ItemStack(RegisterItems.FAILED_DRINK));
                })
                .build();

        DRINK_CRAFT_PACKET = new Identifier(ModStarter.MOD_ID, "craft_drink");

        SCREEN_HANDLER_TYPE = ScreenHandlerRegistry.registerSimple(
                new Identifier(ModStarter.MOD_ID, "drink_maker_craft"),
                (syncId, inventory) -> new DrinkMakerGuiDescription(syncId, inventory, ScreenHandlerContext.EMPTY)
        );
    }

    public static void register() {
        Registry.register(Registry.RECIPE_SERIALIZER, CustomRecipeSerializer.ID, CustomRecipeSerializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(ModStarter.MOD_ID, CustomRecipe.Type.ID), CustomRecipe.Type.INSTANCE);

        ServerSidePacketRegistry.INSTANCE.register(DRINK_CRAFT_PACKET, ((packetContext, packetByteBuf) -> {
            ScreenHandler screenHandler = packetContext.getPlayer().currentScreenHandler;
            ItemStack item = packetByteBuf.readItemStack().copy();


            packetContext.getTaskQueue().execute(() -> {
                CompoundTag tag = new CompoundTag();
                tag.putIntArray("ingredients",
                        new int[] {
                                screenHandler.getStacks().get(0).getCount(),
                                screenHandler.getStacks().get(1).getCount(),
                                screenHandler.getStacks().get(2).getCount(),
                                screenHandler.getStacks().get(3).getCount(),
                                screenHandler.getStacks().get(4).getCount()
                        });
                for (int i = 0; i <= 5; i++) {
                    // removes every item and places the result in the last slot
                    screenHandler.setStackInSlot(i, i == 5 ? item : ItemStack.EMPTY);
                }

                int[] ingredientsShortened = Arrays.copyOf(((BaseDrinkItem) screenHandler.getStacks().get(5).getItem()).ingredients, 4);
                int[] newIngredientsShortened = Arrays.copyOf(tag.getIntArray("ingredients"), 4);
                // removes karmotrine so that drinks with optional karmotrine are not
                // automatically considered big
                // also failed drinks are always considered regular sized
                tag.putBoolean(
                        "isBig",
                        !Arrays.equals(ingredientsShortened, newIngredientsShortened)
                                && !screenHandler.getStacks().get(5).isItemEqual(new ItemStack(RegisterItems.FAILED_DRINK))
                        );

                screenHandler.getStacks().get(5).setTag(tag);
            });
        }));
    }
}
