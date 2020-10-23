package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class BadTouch extends BaseDrinkItem {
    public BadTouch(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.BAD_TOUCH.ingredients,
                DrinkInfos.CraftableDrinks.BAD_TOUCH.name,
                DrinkInfos.CraftableDrinks.BAD_TOUCH.tags.toList()
        );
    }
}
