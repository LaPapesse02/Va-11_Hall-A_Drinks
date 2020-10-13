package com.github.lapapesse02.va11halla_drinks.blocks;

import com.github.lapapesse02.va11halla_drinks.ModStarter;
import net.fabricmc.fabric.api.client.model.ModelProviderContext;
import net.fabricmc.fabric.api.client.model.ModelProviderException;
import net.fabricmc.fabric.api.client.model.ModelResourceProvider;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.util.Identifier;

public class ResourceProvider implements ModelResourceProvider {
    public static final Identifier DRINK_MAKER = new Identifier(ModStarter.MOD_ID, "drink_maker");
    @Override
    public UnbakedModel loadModelResource(Identifier identifier, ModelProviderContext modelProviderContext) throws ModelProviderException {
        if (identifier.equals(DRINK_MAKER)) {
            return new DrinkMakerModel();
        } else {
            return null;
        }
    }
}
