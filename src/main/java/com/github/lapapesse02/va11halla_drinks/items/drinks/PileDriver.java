package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class PileDriver extends BaseDrinkItem {
    public PileDriver(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.PILE_DRIVER.ingredients,
                DrinkInfos.CraftableDrinks.PILE_DRIVER.name,
                DrinkInfos.CraftableDrinks.PILE_DRIVER.tags.toList()
        );
    }
}
