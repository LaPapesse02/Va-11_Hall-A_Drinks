package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class PianoMan extends BaseDrinkItem {
    public PianoMan(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.PIANO_MAN.ingredients,
                DrinkInfos.CraftableDrinks.PIANO_MAN.name,
                DrinkInfos.CraftableDrinks.PIANO_MAN.tags.toList()
        );
    }
}
