package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class BleedingJane extends BaseDrinkItem {
    public BleedingJane(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.BLEEDING_JANE.ingredients,
                DrinkInfos.CraftableDrinks.BLEEDING_JANE.name,
                DrinkInfos.CraftableDrinks.BLEEDING_JANE.tags.toList()
        );
    }
}
