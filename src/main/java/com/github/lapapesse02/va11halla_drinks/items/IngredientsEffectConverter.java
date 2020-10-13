package com.github.lapapesse02.va11halla_drinks.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;


public class IngredientsEffectConverter {
    static final private int MAX_POSITIVE_LEVEL = 5;

    public static int getDurationFromLevel (int ingredientLevel, boolean isFailed, boolean isInvariable) {
        int duration = 0;
        int level = ingredientLevel <= MAX_POSITIVE_LEVEL  || isFailed ? ingredientLevel : ingredientLevel-MAX_POSITIVE_LEVEL;

        if (level >= 0) {
            for (int i = 1; i <= level; i++) {
                if (i % 2 != 0 || isInvariable) {
                    duration += 100;
                }
            }
        }

        return duration;
    }

    public static int getEffectLevelFromLevel (int ingredientLevel, boolean isFailed) {
        int effectLevel = 0;
        int level = ingredientLevel <= MAX_POSITIVE_LEVEL || isFailed ? ingredientLevel: ingredientLevel-MAX_POSITIVE_LEVEL;


        if (level >= 0) {
            for (int i = 1; i <= level; i++) {
                if (i % 2 == 0) {
                    effectLevel += 1;
                }
            }
        }

        return effectLevel;
    }

    public static void giveEffect(int ingredient, int ingredientLevel, boolean isFailed, LivingEntity user) {
        boolean isPositive = ingredientLevel <= MAX_POSITIVE_LEVEL && !isFailed;

        switch (ingredient) {
            case 0:
                // sweet -- adelhyde
                if (isPositive) {
                    int duration = getDurationFromLevel(ingredientLevel, isFailed, false);
                    int level = getEffectLevelFromLevel(ingredientLevel, isFailed);
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, duration, level));
                } else {
                    int duration = getDurationFromLevel(ingredientLevel, isFailed, false);
                    int level = getEffectLevelFromLevel(ingredientLevel, isFailed);
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, duration, level));
                }
                break;

            case 1:
                // bitter -- bronson extract
                if (isPositive) {
                    int duration = getDurationFromLevel(ingredientLevel, isFailed, false);
                    int level = getEffectLevelFromLevel(ingredientLevel, isFailed);
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, duration, level));
                } else {
                    int duration = getDurationFromLevel(ingredientLevel, isFailed, false);
                    int level = getEffectLevelFromLevel(ingredientLevel, isFailed);
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, duration, level));
                }
                break;

            case 2:
                // sour -- powdered delta
                if (isPositive) {
                    int duration = getDurationFromLevel(ingredientLevel, isFailed, true);
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, duration));
                } else {
                    int duration = getDurationFromLevel(ingredientLevel, isFailed, false);
                    int level = getEffectLevelFromLevel(ingredientLevel, isFailed);
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, duration, level));
                }
                break;

            case 3:
                // spicy -- flanergide
                if (isPositive) {
                    int duration = getDurationFromLevel(ingredientLevel, isFailed, true);
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, duration));
                } else {
                    int duration = getDurationFromLevel(ingredientLevel, isFailed, true);
                    user.setOnFireFor(duration);
                }
                break;

            case 4:
                // alcohol -- karmotrine
                if (isPositive) {
                    int duration = getDurationFromLevel(ingredientLevel, isFailed, false);
                    int level = getEffectLevelFromLevel(ingredientLevel, isFailed);
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, duration, level));
                } else {
                    int duration = getDurationFromLevel(ingredientLevel, isFailed, true);
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, duration));
                }
                break;
        }
    }

}
