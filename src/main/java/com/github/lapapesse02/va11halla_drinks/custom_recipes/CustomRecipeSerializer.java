package com.github.lapapesse02.va11halla_drinks.custom_recipes;

import com.github.lapapesse02.va11halla_drinks.ModStarter;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CustomRecipeSerializer implements RecipeSerializer<CustomRecipe> {
    private CustomRecipeSerializer() {}
    public static final CustomRecipeSerializer INSTANCE = new CustomRecipeSerializer();
    public static final Identifier ID = new Identifier(ModStarter.MOD_ID, "drink");

    @Override
    public CustomRecipe read(Identifier id, JsonObject json) {
        CustomRecipeJsonFormat recipeJson = new Gson().fromJson(json, CustomRecipeJsonFormat.class);
        int adelhyde = recipeJson.levels.get("adelhyde").getAsInt();
        int powdered_delta = recipeJson.levels.get("powdered_delta").getAsInt();
        int bronson_extract = recipeJson.levels.get("bronson_extract").getAsInt();
        int flanergide = recipeJson.levels.get("flanergide").getAsInt();
        int karmotrine = recipeJson.levels.get("karmotrine").getAsInt();

        boolean isBlended = recipeJson.isBlended;
        boolean isOnTheRocks = recipeJson.isOnTheRocks;
        boolean isAged = recipeJson.isAged;
        Item outputItem = Registry.ITEM.getOrEmpty(new Identifier(recipeJson.outputItem)).get();
        ItemStack output = new ItemStack(outputItem);

        return new CustomRecipe(adelhyde, powdered_delta, bronson_extract, flanergide, karmotrine, isBlended, isOnTheRocks, isAged, output, id);
    }

    @Override
    public CustomRecipe read(Identifier id, PacketByteBuf buf) {
        int adelhyde = buf.readIntArray()[0];
        int powdered_delta = buf.readIntArray()[1];
        int bronson_extract = buf.readIntArray()[2];
        int flanergide = buf.readIntArray()[3];
        int karmotrine = buf.readIntArray()[4];

        boolean isBlended = buf.readIntArray()[5] == 2;
        boolean isAged = buf.readIntArray()[6] == 2;
        boolean isOnTheRocks = buf.readIntArray()[7] == 2;

        ItemStack output = buf.readItemStack();

        return new CustomRecipe(adelhyde, powdered_delta, bronson_extract, flanergide, karmotrine, isBlended, isOnTheRocks, isAged, output, id);
    }

    @Override
    public void write(PacketByteBuf buf, CustomRecipe recipe) {
        buf.writeIntArray(new int[] {
                recipe.getAdelhyde(),
                recipe.getPowderedDelta(),
                recipe.getBronsonExtract(),
                recipe.getFlanergide(),
                recipe.getKarmotrine(),
                recipe.getBlended() ? 1 : 0,
                recipe.getAged() ? 1 : 0,
                recipe.getOnTheRocks() ? 1 : 0
        });

        buf.writeItemStack(recipe.getOutput());

    }
}
