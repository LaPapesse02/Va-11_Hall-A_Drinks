package com.github.lapapesse02.va11halla_drinks;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;


public class IngredientsEffectConverter {
    static final private int MAX_POSITIVE_LEVEL = 6;

    static final private StatusEffect[][] effects = new StatusEffect[][] {
        {StatusEffects.SPEED, StatusEffects.SLOWNESS},      // Adelhyde
        {StatusEffects.RESISTANCE, StatusEffects.NAUSEA},    // Karmotrine
        {StatusEffects.RESISTANCE, StatusEffects.NAUSEA},    // Karmotrine
        {StatusEffects.RESISTANCE, StatusEffects.NAUSEA},    // Karmotrine
        {StatusEffects.RESISTANCE, StatusEffects.NAUSEA}    // Karmotrine
    };

    public static StatusEffect getEffectFromIngredients (int ingredient, int ingredientLevel) {
        StatusEffect[] possibleEffects = effects[ingredient];

        return ingredientLevel < MAX_POSITIVE_LEVEL ? possibleEffects[0] : possibleEffects[1];
    }

    public static int getDurationFromLevel (int ingredientLevel) {
        int duration = 0;
        int level = ingredientLevel < MAX_POSITIVE_LEVEL ? ingredientLevel : ingredientLevel-(MAX_POSITIVE_LEVEL-1);

        if (level >= 0) {
            for (int i = 1; i <= level; i++) {
                if (i % 2 != 0) {
                    duration += 100;
                }
            }
        }

        return duration;
    }

    public static int getEffectLevelFromLevel (int ingredientLevel) {
        int effectLevel = 0;
        int level = ingredientLevel < MAX_POSITIVE_LEVEL ? ingredientLevel: ingredientLevel-(MAX_POSITIVE_LEVEL-1);


        if (level >= 0) {
            for (int i = 1; i <= level; i++) {
                if (i % 2 == 0) {
                    effectLevel += 1;
                }
            }
        }

        return effectLevel;
    }

}
