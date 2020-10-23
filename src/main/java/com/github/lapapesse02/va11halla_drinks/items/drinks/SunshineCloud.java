package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class SunshineCloud extends BaseDrinkItem {
    public SunshineCloud(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.SUNSHINE_CLOUD.ingredients,
                DrinkInfos.CraftableDrinks.SUNSHINE_CLOUD.name,
                DrinkInfos.CraftableDrinks.SUNSHINE_CLOUD.tags.toList()
        );
    }
}
