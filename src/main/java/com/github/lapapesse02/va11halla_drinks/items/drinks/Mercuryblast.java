package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class Mercuryblast extends BaseDrinkItem {
    public Mercuryblast(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.MERCURYBLAST.ingredients,
                DrinkInfos.CraftableDrinks.MERCURYBLAST.name,
                DrinkInfos.CraftableDrinks.MERCURYBLAST.tags.toList()
        );
    }
}
