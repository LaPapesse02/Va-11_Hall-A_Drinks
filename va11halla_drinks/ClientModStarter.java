package com.github.lapapesse02.va11halla_drinks;

import com.github.lapapesse02.va11halla_drinks.blocks.ResourceProvider;
import com.github.lapapesse02.va11halla_drinks.guis.DrinkMakerGuiDescription;
import com.github.lapapesse02.va11halla_drinks.guis.DrinkMakerScreen;
import com.github.lapapesse02.va11halla_drinks.register.RegisterMiscellaneous;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

public class ClientModStarter implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
    
        ModelLoadingRegistry.INSTANCE.registerResourceProvider(rm -> new ResourceProvider());

        ScreenRegistry.<DrinkMakerGuiDescription, DrinkMakerScreen>register(RegisterMiscellaneous.SCREEN_HANDLER_TYPE, (gui, inventory, title) -> new DrinkMakerScreen(gui, inventory.player, title));
        
    }
}
