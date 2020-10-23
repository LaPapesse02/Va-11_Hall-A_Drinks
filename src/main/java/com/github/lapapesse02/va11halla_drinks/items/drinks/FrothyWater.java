package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class FrothyWater extends BaseDrinkItem {
    public FrothyWater(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.FROTHY_WATER.ingredients,
                DrinkInfos.CraftableDrinks.FROTHY_WATER.name,
                DrinkInfos.CraftableDrinks.FROTHY_WATER.tags.toList()
        );
    }
}
