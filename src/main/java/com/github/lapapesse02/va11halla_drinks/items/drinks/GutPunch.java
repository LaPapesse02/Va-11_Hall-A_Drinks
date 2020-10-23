package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class GutPunch extends BaseDrinkItem {
    public GutPunch(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.GUT_PUNCH.ingredients,
                DrinkInfos.CraftableDrinks.GUT_PUNCH.name,
                DrinkInfos.CraftableDrinks.GUT_PUNCH.tags.toList()
        );
    }
}
