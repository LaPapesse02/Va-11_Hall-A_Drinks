package com.github.lapapesse02.va11halla_drinks.items.miscellaneous;

import com.github.lapapesse02.va11halla_drinks.guis.RecipeBookGuiDescription;
import com.github.lapapesse02.va11halla_drinks.guis.RecipeBookScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class RecipeBook extends Item {
    public RecipeBook(Settings settings) {
        super(settings);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient()) {
            MinecraftClient.getInstance().openScreen(new RecipeBookScreen(new RecipeBookGuiDescription()));
        }
        return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
    }
}
