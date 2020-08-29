package com.github.lapapesse02.va11halla_drinks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModStarter implements ModInitializer {
    public static final ItemGroup MOD_GROUP = FabricItemGroupBuilder.create(
        new Identifier("va11halla_drinks", "group"))
            .icon(() -> new ItemStack(RegisterItems.ADELHYDE))
            .appendItems(stacks -> {
                // ingredients
                stacks.add(new ItemStack(RegisterItems.ADELHYDE));
                stacks.add(new ItemStack(RegisterItems.POWDERED_DELTA));
                stacks.add(new ItemStack(RegisterItems.BRONSON_EXTRACT));
                stacks.add(new ItemStack(RegisterItems.FLANERGIDE));
                stacks.add(new ItemStack(RegisterItems.KARMOTRINE));
            })
            .build();


    @Override
    public void onInitialize() {
        RegisterItems.register();
    }
}
