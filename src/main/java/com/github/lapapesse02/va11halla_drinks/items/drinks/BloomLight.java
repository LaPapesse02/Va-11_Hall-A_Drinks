package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;
import com.github.lapapesse02.va11halla_drinks.DrinkInfos.CraftableDrinks;

public class BloomLight extends BaseDrinkItem {
    public BloomLight(Settings settings) {
        super(settings,
                CraftableDrinks.BLOOM_LIGHT.ingredients,
                CraftableDrinks.BLOOM_LIGHT.name,
                CraftableDrinks.BLOOM_LIGHT.tags.toList()
        );
    }
}
