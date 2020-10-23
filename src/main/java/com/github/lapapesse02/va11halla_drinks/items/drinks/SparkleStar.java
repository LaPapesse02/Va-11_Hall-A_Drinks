package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class SparkleStar extends BaseDrinkItem {
    public SparkleStar(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.SPARKLE_STAR.ingredients,
                DrinkInfos.CraftableDrinks.SPARKLE_STAR.name,
                DrinkInfos.CraftableDrinks.SPARKLE_STAR.tags.toList()
        );
    }
}
