package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class SugarRush extends BaseDrinkItem {
    public SugarRush(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.SUGAR_RUSH.ingredients,
                DrinkInfos.CraftableDrinks.SUGAR_RUSH.name,
                DrinkInfos.CraftableDrinks.SUGAR_RUSH.tags.toList()
        );
    }
}
