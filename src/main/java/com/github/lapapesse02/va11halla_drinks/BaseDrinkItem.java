package com.github.lapapesse02.va11halla_drinks;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
    public int size;


    public BaseDrinkItem(Settings settings, int[] elements) {
        super(settings);
        this.ingredients = elements;
        int sum = 0;
        int i;

        /* in the game a drink is considered big if it has double the ingredients
         * it normally requires or if the base drink has more than 10 ingredients
         */
        for (i = 0; i < this.ingredients.length; i++) {
            sum += this.ingredients[i];
        }
        this.size = sum >= 10 ? 2 : 1;
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
        if (user instanceof PlayerEntity){
            if ( !((( PlayerEntity ) user).isCreative()) ) {
                // only reduce the item count if the player is not in creative
                stack.decrement(1);
            }
        }
        if (stack.getCount() == 0) {
            user.setStackInHand(user.getActiveHand(), new ItemStack(Items.AIR));
        }
        if (!world.isClient()) {
            for (int i = 0; i < this.ingredients.length; i++) {
                if (this.ingredients[i] == 0) {
                    // doesn't try to give an effect if the duration is 0
                    continue;
                }
                user.addStatusEffect(new StatusEffectInstance(
                    IngredientsEffectConverter.getEffectFromIngredients(i, this.ingredients[i]),
                    IngredientsEffectConverter.getDurationFromLevel(this.ingredients[i]),
                    IngredientsEffectConverter.getEffectLevelFromLevel(this.ingredients[i])
                ));
            }
        }
        return stack;
    }


    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {

        // displays drink size
        tooltip.add(new LiteralText(
                "§8" // gray
                + new TranslatableText("tooltip.va11halla.size").getString()

                // normal text if drink size is normal, else bold italic underlined
                + String.format(" : %s", this.size > 1 ? "§n§o§l" : "")

                + new TranslatableText(String.format(
                        "tooltip.va11halla.%s",
                        this.size > 1 ? "big" : "normal"
                )).getString()
        ));

        for (int i = 0; i < this.ingredients.length; i++) {
            // displays level for each ingredient with the associated color
            tooltip.add(new LiteralText(
                "§8" // gray
                + new TranslatableText(
                    String.format("tooltip.va11halla.%s", ingredientNames[i])
                ).getString()
                + String.format(" : %s%d", colorCodes[i], this.ingredients[i])
            ));
        }
        // leaves space between ingredients and identifier
        tooltip.add(new LiteralText(""));
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return TypedActionResult.consume(user.getStackInHand(hand));
    }
}
