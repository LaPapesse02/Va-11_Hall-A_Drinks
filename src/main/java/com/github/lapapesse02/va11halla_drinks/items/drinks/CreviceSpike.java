package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class CreviceSpike extends BaseDrinkItem {
    public CreviceSpike(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.CREVICE_SPIKE.ingredients,
                DrinkInfos.CraftableDrinks.CREVICE_SPIKE.name,
                DrinkInfos.CraftableDrinks.CREVICE_SPIKE.tags.toList()
        );
    }
}
