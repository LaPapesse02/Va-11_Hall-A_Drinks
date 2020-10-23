package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class Suplex extends BaseDrinkItem {
    public Suplex(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.SUPLEX.ingredients,
                DrinkInfos.CraftableDrinks.SUPLEX.name,
                DrinkInfos.CraftableDrinks.SUPLEX.tags.toList()
        );
    }
}
