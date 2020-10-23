package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class Marsblast extends BaseDrinkItem {
    public Marsblast(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.MARSBLAST.ingredients,
                DrinkInfos.CraftableDrinks.MARSBLAST.name,
                DrinkInfos.CraftableDrinks.MARSBLAST.tags.toList()
        );
    }
}
