package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class Beer extends BaseDrinkItem {
    public Beer(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.BEER.ingredients,
                DrinkInfos.CraftableDrinks.BEER.name,
                DrinkInfos.CraftableDrinks.BEER.tags.toList()
        );
    }
}
