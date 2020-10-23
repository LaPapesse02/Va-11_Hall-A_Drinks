package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class FlamingMoai extends BaseDrinkItem {
    public FlamingMoai(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.FLAMING_MOAI.ingredients,
                DrinkInfos.CraftableDrinks.FLAMING_MOAI.name,
                DrinkInfos.CraftableDrinks.FLAMING_MOAI.tags.toList()
        );
    }
}
