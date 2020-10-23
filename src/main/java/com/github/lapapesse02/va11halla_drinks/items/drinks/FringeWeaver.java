package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class FringeWeaver extends BaseDrinkItem {
    public FringeWeaver(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.FRINGE_WEAVER.ingredients,
                DrinkInfos.CraftableDrinks.FRINGE_WEAVER.name,
                DrinkInfos.CraftableDrinks.FRINGE_WEAVER.tags.toList()
        );
    }
}
