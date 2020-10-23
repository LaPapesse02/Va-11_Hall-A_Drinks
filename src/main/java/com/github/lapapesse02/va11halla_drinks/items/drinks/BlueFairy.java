package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class BlueFairy extends BaseDrinkItem {
    public BlueFairy(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.BLUE_FAIRY.ingredients,
                DrinkInfos.CraftableDrinks.BLUE_FAIRY.name,
                DrinkInfos.CraftableDrinks.BLUE_FAIRY.tags.toList()
        );
    }
}
