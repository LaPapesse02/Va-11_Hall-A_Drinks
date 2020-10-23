package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class PianoWoman extends BaseDrinkItem {
    public PianoWoman(Settings settings) {
        super(settings,
                DrinkInfos.CraftableDrinks.PIANO_WOMAN.ingredients,
                DrinkInfos.CraftableDrinks.PIANO_WOMAN.name,
                DrinkInfos.CraftableDrinks.PIANO_WOMAN.tags.toList()
        );
    }
}
