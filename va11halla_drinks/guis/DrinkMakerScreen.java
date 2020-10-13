package com.github.lapapesse02.va11halla_drinks.guis;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class DrinkMakerScreen extends CottonInventoryScreen<DrinkMakerGuiDescription> {
    public DrinkMakerScreen(DrinkMakerGuiDescription description, PlayerEntity player, Text title) {
        super(description, player, title);
    }
}
