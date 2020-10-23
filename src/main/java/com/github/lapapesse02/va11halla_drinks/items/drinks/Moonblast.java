package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class Moonblast extends BaseDrinkItem {
    public Moonblast(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.MOONBLAST.ingredients,
                DrinkInfos.CraftableDrinks.MOONBLAST.name,
                DrinkInfos.CraftableDrinks.MOONBLAST.tags.toList()
        );
    }
}
