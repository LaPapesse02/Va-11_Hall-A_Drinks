package com.github.lapapesse02.va11halla_drinks.items.drinks;

import com.github.lapapesse02.va11halla_drinks.items.BaseDrinkItem;

public class Beer extends BaseDrinkItem {
    public Beer(Settings settings) {
        super(settings, new int[] {1, 2, 1, 2, 4}, "drink", "beer");
    }
}
