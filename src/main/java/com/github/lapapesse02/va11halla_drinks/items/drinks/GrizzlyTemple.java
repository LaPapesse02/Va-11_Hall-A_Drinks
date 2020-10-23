package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class GrizzlyTemple extends BaseDrinkItem {
    public GrizzlyTemple(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.GRIZZLY_TEMPLE.ingredients,
                DrinkInfos.CraftableDrinks.GRIZZLY_TEMPLE.name,
                DrinkInfos.CraftableDrinks.GRIZZLY_TEMPLE.tags.toList()
        );
    }
}
