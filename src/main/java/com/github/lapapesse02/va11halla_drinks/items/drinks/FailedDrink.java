package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class FailedDrink extends BaseDrinkItem {
    public FailedDrink(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.FAILED_DRINK.ingredients,
                DrinkInfos.CraftableDrinks.FAILED_DRINK.name,
                DrinkInfos.CraftableDrinks.FAILED_DRINK.tags.toList()
        );
    }
}
