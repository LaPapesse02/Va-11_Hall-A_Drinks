package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class Brandtini extends BaseDrinkItem {
    public Brandtini(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.BRANDTINI.ingredients,
                DrinkInfos.CraftableDrinks.BRANDTINI.name,
                DrinkInfos.CraftableDrinks.BRANDTINI.tags.toList()
        );
    }
}
