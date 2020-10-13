package com.github.lapapesse02.va11halla_drinks;

import com.github.lapapesse02.va11halla_drinks.register.RegisterBlocks;
import com.github.lapapesse02.va11halla_drinks.register.RegisterItems;
import com.github.lapapesse02.va11halla_drinks.register.RegisterMiscellaneous;
import net.fabricmc.api.ModInitializer;


public class ModStarter implements ModInitializer {
    public static final String MOD_ID = "va11halla_drinks";

    @Override
    public void onInitialize() {
        RegisterMiscellaneous.register();
        RegisterItems.register();
        RegisterBlocks.register();
    }
}
