package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class CobaltVelvet extends BaseDrinkItem {
    public CobaltVelvet(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.COBALT_VELVET.ingredients,
                DrinkInfos.CraftableDrinks.COBALT_VELVET.name,
                DrinkInfos.CraftableDrinks.COBALT_VELVET.tags.toList()
        );
    }
}
