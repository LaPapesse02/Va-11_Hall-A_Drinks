package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class FluffyDream extends BaseDrinkItem {
    public FluffyDream(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.FLUFFY_DREAM.ingredients,
                DrinkInfos.CraftableDrinks.FLUFFY_DREAM.name,
                DrinkInfos.CraftableDrinks.FLUFFY_DREAM.tags.toList()
        );
    }
}
