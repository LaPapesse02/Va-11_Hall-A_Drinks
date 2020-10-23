package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class ZenStar extends BaseDrinkItem {
    public ZenStar(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.ZEN_STAR.ingredients,
                DrinkInfos.CraftableDrinks.ZEN_STAR.name,
                DrinkInfos.CraftableDrinks.ZEN_STAR.tags.toList()
        );
    }
}
