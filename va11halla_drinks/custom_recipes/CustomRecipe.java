package com.github.lapapesse02.va11halla_drinks.custom_recipes;

import com.github.lapapesse02.va11halla_drinks.block_entities.DrinkMakerEntity;
import com.github.lapapesse02.va11halla_drinks.register.RegisterItems;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class CustomRecipe implements Recipe<DrinkMakerEntity> {
    private final int ADELHYDE;
    private final int POWDERED_DELTA;
    private final int BRONSON_EXTRACT;
    private final int FLANERGIDE;
    private final int KARMOTRINE;
    private final boolean IS_BLENDED;
    private final boolean IS_ON_THE_ROCKS;
    private final boolean IS_AGED;

    private final ItemStack outputStack;
    private final Identifier id;

    public CustomRecipe(int adelhyde, int powdered_delta, int bronson_extract, int flanergide, int karmotrine, boolean isBlended, boolean isOnTheRocks, boolean isAged, ItemStack outputStack, Identifier id) {
        this.ADELHYDE = adelhyde;
        this.POWDERED_DELTA = powdered_delta;
        this.BRONSON_EXTRACT = bronson_extract;
        this.FLANERGIDE = flanergide;
        this.KARMOTRINE = karmotrine;
        this.IS_BLENDED = isBlended;
        this.IS_ON_THE_ROCKS = isOnTheRocks;
        this.IS_AGED = isAged;

        this.outputStack = outputStack;
        this.id = id;
    }

    public static class Type implements RecipeType<CustomRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "drink_recipe";
    }

    @Override
    public boolean matches(DrinkMakerEntity inventory, World world) {

        if (inventory.count(RegisterItems.ADELHYDE) != this.ADELHYDE) {
            return false;
        } else if (inventory.count(RegisterItems.POWDERED_DELTA) != this.POWDERED_DELTA) {
            return false;
        } else if (inventory.count(RegisterItems.BRONSON_EXTRACT) != this.BRONSON_EXTRACT) {
            return false;
        } else if (inventory.count(RegisterItems.FLANERGIDE) != this.FLANERGIDE) {
            return false;
        } else if (this.KARMOTRINE >= 0) { // -1 is used for optional karmotrine
            if (inventory.count(RegisterItems.KARMOTRINE) != this.KARMOTRINE) {
                return false;
            }
        }
        if ((this.IS_ON_THE_ROCKS ? 2 : 1) != inventory.getStack(6).getCount()) { // seriously, don't ask
            return false;
        } else if ((this.IS_AGED ? 2 : 1) != inventory.getStack(7).getCount()) {
            return false;
        } else if ((this.IS_BLENDED ? 2 : 1) != inventory.getStack(8).getCount()) {
            return false;
        }

        return true;
    }

    @Override
    public ItemStack craft(DrinkMakerEntity inv) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean fits(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getOutput() {
        return this.outputStack;
    }

    @Override
    public Identifier getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CustomRecipeSerializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public int getAdelhyde() {
        return this.ADELHYDE;
    }
    public int getPowderedDelta() {
        return this.POWDERED_DELTA;
    }
    public int getBronsonExtract() {
        return this.BRONSON_EXTRACT;
    }
    public int getFlanergide() {
        return this.FLANERGIDE;
    }
    public int getKarmotrine() {
        return this.KARMOTRINE;
    }
    public boolean getBlended() {
        return this.IS_BLENDED;
    }
    public boolean getOnTheRocks() {
        return this.IS_ON_THE_ROCKS;
    }
    public boolean getAged() {
        return this.IS_AGED;
    }
}
