package com.github.lapapesse02.va11halla_drinks.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import java.util.List;

public class BaseDrinkItem extends Item {
    public static String[] ingredientNames = {
            "adelhyde",
            "powdered_delta",
            "bronson_extract",
            "flanergide",
            "karmotrine"
    };
    public static String[] colorCodes = {
            "§4", // dark red
            "§9", // blue
            "§6", // gold
            "§2", // dark green
            "§3"  // dark aqua
    };
    public int[] ingredients;
    public boolean isBig;
    public String name;
    public String type;


    public BaseDrinkItem(Settings settings, int[] ingredients, String type, String name) {
        super(settings);
        this.ingredients = ingredients;
        this.name = name;
        this.type = type;
        int sum = 0;

        /* in the game a drink is considered big if it has double the ingredients
         * it normally requires or if the base drink has more than 10 ingredients
         */
        for (int ingredient : this.ingredients) {
            sum += ingredient;
        }
        this.isBig = sum > 10;
    }


    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }


    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 32;
    }


    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        int[] ingredients;

        if (user instanceof PlayerEntity){
            if ( !(((PlayerEntity) user).isCreative()) ) {
                // only reduce the item count if the player is not in creative
                stack.decrement(1);
            }
        }

        // if item has been crafted it will have 2 subtags: isBig and ingredients
        CompoundTag tags = stack.getOrCreateTag();
        if (!tags.isEmpty()) {
            ingredients = tags.getIntArray("ingredients");
        } else {
            ingredients = this.ingredients;
        }

        if (stack.getCount() == 0) {
            user.setStackInHand(user.getActiveHand(), new ItemStack(Items.AIR));
        }
        if (!world.isClient()) {
            for (int i = 0; i < ingredients.length; i++) {
                if (ingredients[i] == 0) {
                    // doesn't try to give an effect if the duration is 0
                    continue;
                }
                user.addStatusEffect(new StatusEffectInstance(
                        IngredientsEffectConverter.getEffectFromIngredients(i, ingredients[i]),
                        IngredientsEffectConverter.getDurationFromLevel(ingredients[i]),
                        IngredientsEffectConverter.getEffectLevelFromLevel(ingredients[i])
                ));
            }
        }
        return stack;
    }


    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        boolean isBig;
        int[] ingredients;

        // if item has been crafted it will have 2 subtags: isBig and ingredients
        CompoundTag tags = stack.getOrCreateTag();
        if (!tags.isEmpty()) {
            isBig = tags.getBoolean("isBig");
            ingredients = tags.getIntArray("ingredients");

        } else {
            isBig = this.isBig;
            ingredients = this.ingredients;
        }

        // displays drink size
        tooltip.add(new LiteralText(
                "§8" // gray

                        + new TranslatableText("tooltip.va11halla_drinks.size").getString()

                        // normal text if drink size is normal, else bold italic underlined
                        + String.format(" : %s", isBig ? "§n§o§l" : "")

                        + new TranslatableText(String.format(
                        "tooltip.va11halla_drinks.%s",
                        isBig ? "big" : "normal"
                )).getString()
        ));

        for (int i = 0; i < this.ingredients.length; i++) {
            // displays level for each ingredient with the associated color
            tooltip.add(new LiteralText(
                    "§8" // gray

                            + new TranslatableText(
                                    // element added
                            String.format("tooltip.va11halla_drinks.%s", ingredientNames[i])
                    ).getString()

                                    // element level
                            + String.format(" : %s%d", colorCodes[i], ingredients[i])
            ));
        }
        tooltip.add(new LiteralText(""));

        // additional info on the drink
        // added text wrapping because minecraft bad and doesn't support \n
        // text wrap only works for languages that use spaces

        String[] info = new TranslatableText(String.format("tooltip.va11halla_drinks.%s.%s", this.type, this.name)).getString().split(" ");
        String infoPart = "\"";

        for (int i = 0; i < info.length; i++) {
            infoPart = infoPart + info[i] + (i+1 != info.length ? " " : "\"");
            if (infoPart.length() > 35 || i+1 == info.length) {
                tooltip.add(new LiteralText("§7§o" + infoPart));
                infoPart = "";
            }
        }

        tooltip.add(new LiteralText(""));
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return TypedActionResult.consume(user.getStackInHand(hand));
    }
}
