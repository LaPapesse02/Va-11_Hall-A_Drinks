package com.github.lapapesse02.va11halla_drinks.guis;

import com.github.lapapesse02.va11halla_drinks.DrinkInfos;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class RecipeBookGuiDescription extends LightweightGuiDescription {
    // main panel
    private final WGridPanel root;
    private final WTabPanel tabPanel;
    private final WGridPanel drinkPage;

    // button stuff
    private final WGridPanel list;  // contains the buttons for the drinks
    private WButton[] listDrinks;   // stores the buttons added to this.list so that they can be removed

    // drink page stuff
    private final WLabel title;     // name of the drink

    private final WLabel info1;     // first line of recipe
    private final WLabel info2;     // second line of recipe (used if the first line can't conatain everything)
    private final WLabel info3;     // third line of recipe (used if the second line can't contain everything)

    private final WLabel desc1;     // first line of description
    private final WLabel desc2;     // second line of description (used if the first line can't conatain everything)
    private final WLabel desc3;     // third line of description (used if the second line can't conatain everything)

    private final WLabel tags;      // flavor and types of the shown drink

    // buttons all loaded on opening
    private final WButton badTouch;
    private final WButton beer;
    private final WButton bleedingJane;
    private final WButton bloomLight;
    private final WButton blueFairy;
    private final WButton brandtini;

    private final WButton cobaltVelvet;
    private final WButton creviceSpike;

    private final WButton fluffyDream;
    private final WButton fringeWeaver;
    private final WButton frothyWater;

    private final WButton grizzlyTemple;
    private final WButton gutPunch;

    private final WButton marsblast;
    private final WButton mercuryblast;
    private final WButton moonblast;

    private final WButton pianoMan;
    private final WButton pianoWoman;
    private final WButton pileDriver;

    private final WButton sparkleStar;
    private final WButton sugarRush;
    private final WButton sunshineCloud;
    private final WButton suplex;

    private final WButton zenStar;


    public RecipeBookGuiDescription() {
        // loads buttons
        badTouch = new WButton(new TranslatableText("item.va11halla_drinks.bad_touch")).setOnClick(() -> setDrinkPage(0));
        beer = new WButton(new TranslatableText("item.va11halla_drinks.beer")).setOnClick(() -> setDrinkPage(1));
        bleedingJane = new WButton(new TranslatableText("item.va11halla_drinks.bleeding_jane")).setOnClick(() -> setDrinkPage(2));
        bloomLight = new WButton(new TranslatableText("item.va11halla_drinks.bloom_light")).setOnClick(() -> setDrinkPage(3));
        blueFairy = new WButton(new TranslatableText("item.va11halla_drinks.blue_fairy")).setOnClick(() -> setDrinkPage(4));
        brandtini = new WButton(new TranslatableText("item.va11halla_drinks.brandtini")).setOnClick(() -> setDrinkPage(5));

        cobaltVelvet = new WButton(new TranslatableText("item.va11halla_drinks.cobalt_velvet")).setOnClick(() -> setDrinkPage(6));
        creviceSpike = new WButton(new TranslatableText("item.va11halla_drinks.crevice_spike")).setOnClick(() -> setDrinkPage(7));

        fluffyDream = new WButton(new TranslatableText("item.va11halla_drinks.fluffy_dream")).setOnClick(() -> setDrinkPage(8));
        fringeWeaver = new WButton(new TranslatableText("item.va11halla_drinks.fringe_weaver")).setOnClick(() -> setDrinkPage(9));
        frothyWater = new WButton(new TranslatableText("item.va11halla_drinks.frothy_water")).setOnClick(() -> setDrinkPage(10));

        grizzlyTemple = new WButton(new TranslatableText("item.va11halla_drinks.grizzly_temple")).setOnClick(() -> setDrinkPage(11));
        gutPunch = new WButton(new TranslatableText("item.va11halla_drinks.gut_punch")).setOnClick(() -> setDrinkPage(12));

        marsblast = new WButton(new TranslatableText("item.va11halla_drinks.marsblast")).setOnClick(() -> setDrinkPage(13));
        mercuryblast = new WButton(new TranslatableText("item.va11halla_drinks.mercuryblast")).setOnClick(() -> setDrinkPage(14));
        moonblast = new WButton(new TranslatableText("item.va11halla_drinks.moonblast")).setOnClick(() -> setDrinkPage(15));

        pianoMan = new WButton(new TranslatableText("item.va11halla_drinks.piano_man")).setOnClick(() -> setDrinkPage(16));
        pianoWoman = new WButton(new TranslatableText("item.va11halla_drinks.piano_woman")).setOnClick(() -> setDrinkPage(17));
        pileDriver = new WButton(new TranslatableText("item.va11halla_drinks.pile_driver")).setOnClick(() -> setDrinkPage(18));

        sparkleStar = new WButton(new TranslatableText("item.va11halla_drinks.sparkle_star")).setOnClick(() -> setDrinkPage(19));
        sugarRush = new WButton(new TranslatableText("item.va11halla_drinks.sugar_rush")).setOnClick(() -> setDrinkPage(20));
        sunshineCloud = new WButton(new TranslatableText("item.va11halla_drinks.sunshine_cloud")).setOnClick(() -> setDrinkPage(21));
        suplex = new WButton(new TranslatableText("item.va11halla_drinks.suplex")).setOnClick(() -> setDrinkPage(22));

        zenStar = new WButton(new TranslatableText("item.va11halla_drinks.zen_star")).setOnClick(() -> setDrinkPage(23));

        this.listDrinks = new WButton[] {};     // creates the list that stores the drink buttons

        // root panel
        this.root = new WGridPanel();
        setRootPanel(this.root);
        this.root.setSize(260, 210);

        /* ------------ TAB PAGE ------------ */
        tabPanel = new WTabPanel();
        this.root.add(tabPanel, 0, 0, 10, 10);

        // name search
        WGridPanel nameSearch = new WGridPanel(); // allows to search in alphabetical order
        // creating button for each letter
        WButton b = new WButton(new TranslatableText("tabs.va11halla_drinks.b")).setOnClick(() -> setButtons(0, 0));
        WButton c = new WButton(new TranslatableText("tabs.va11halla_drinks.c")).setOnClick(() -> setButtons(1, 0));
        WButton f = new WButton(new TranslatableText("tabs.va11halla_drinks.f")).setOnClick(() -> setButtons(2, 0));
        WButton g = new WButton(new TranslatableText("tabs.va11halla_drinks.g")).setOnClick(() -> setButtons(3, 0));
        WButton m = new WButton(new TranslatableText("tabs.va11halla_drinks.m")).setOnClick(() -> setButtons(4, 0));
        WButton p = new WButton(new TranslatableText("tabs.va11halla_drinks.p")).setOnClick(() -> setButtons(5, 0));
        WButton s = new WButton(new TranslatableText("tabs.va11halla_drinks.s")).setOnClick(() -> setButtons(6, 0));
        WButton z = new WButton(new TranslatableText("tabs.va11halla_drinks.z")).setOnClick(() -> setButtons(7, 0));
        // putting buttons in the nameSearch tab
        nameSearch.add(b, 1, 0);
        nameSearch.add(c, 1, 2);
        nameSearch.add(f, 1, 4);
        nameSearch.add(g, 1, 6);
        nameSearch.add(m, 3, 0);
        nameSearch.add(p, 3, 2);
        nameSearch.add(s, 3, 4);
        nameSearch.add(z, 3, 6);
        nameSearch.add(new WPlainPanel(), 10, 8);   // allows for a big panel without having to add other labels or buttons


        // flavor search
        WGridPanel flavorSearch = new WGridPanel();
        // creating buttons for each flavor
        WButton bitter = new WButton(new TranslatableText("tags.va11halla_drinks.bitter")).setOnClick(() -> setButtons(0, 1));
        WButton bubbly = new WButton(new TranslatableText("tags.va11halla_drinks.bubbly")).setOnClick(() -> setButtons(1, 1));
        WButton sour = new WButton(new TranslatableText("tags.va11halla_drinks.sour")).setOnClick(() -> setButtons(2, 1));
        WButton spicy = new WButton(new TranslatableText("tags.va11halla_drinks.spicy")).setOnClick(() -> setButtons(3, 1));
        WButton sweet = new WButton(new TranslatableText("tags.va11halla_drinks.sweet")).setOnClick(() -> setButtons(4, 1));
        // putting buttons in the flavorSearch tab
        flavorSearch.add(bitter, 1, 0, 3, 1);
        flavorSearch.add(bubbly, 1, 1, 3, 1);
        flavorSearch.add(sour, 1, 2, 3, 1);
        flavorSearch.add(spicy, 1, 3, 3, 1);
        flavorSearch.add(sweet, 1, 4, 3, 1);
        flavorSearch.add(new WPlainPanel(), 10, 8); // allows for a big panel without having to add other labels or buttons


        // type search
        WGridPanel typeSearch = new WGridPanel();
        // creating buttons for each type
        WButton classic = new WButton(new TranslatableText("tags.va11halla_drinks.classic")).setOnClick(() -> setButtons(0, 2));
        WButton classy = new WButton(new TranslatableText("tags.va11halla_drinks.classy")).setOnClick(() -> setButtons(1, 2));
        WButton girly = new WButton(new TranslatableText("tags.va11halla_drinks.girly")).setOnClick(() -> setButtons(2, 2));
        WButton manly = new WButton(new TranslatableText("tags.va11halla_drinks.manly")).setOnClick(() -> setButtons(3, 2));
        WButton promo = new WButton(new TranslatableText("tags.va11halla_drinks.promo")).setOnClick(() -> setButtons(4, 2));
        // putting buttons in the typeSearch tab
        typeSearch.add(classic, 1, 0, 3, 1);
        typeSearch.add(classy, 1, 1, 3, 1);
        typeSearch.add(girly, 1, 2, 3, 1);
        typeSearch.add(manly, 1, 3, 3, 1);
        typeSearch.add(promo, 1, 4, 3, 1);
        typeSearch.add(new WPlainPanel(), 10, 8);   // allows for a big panel without having to add other labels or buttons


        // panel where the drink buttons are shown
        this.list = new WGridPanel();
        nameSearch.add(this.list, 5, 0);
        flavorSearch.add(this.list, 5, 0);
        typeSearch.add(this.list, 5, 0);

        // adds each tab to the tab panel
        tabPanel.add(nameSearch, tab -> tab.title(new TranslatableText("tabs.va11halla_drinks.name_search")));
        tabPanel.add(flavorSearch, tab -> tab.title(new TranslatableText("tabs.va11halla_drinks.flavor_search")));
        tabPanel.add(typeSearch, tab -> tab.title(new TranslatableText("tabs.va11halla_drinks.type_search")));
        /* ------------ END TAB PAGE ------------ */


        /* ------------ DRINK PAGE ------------ */
        this.drinkPage = new WGridPanel();

        // button to the top left of the drink page to go back to searching
        WButton backButton = new WButton(new LiteralText("X")).setOnClick(() -> {
            this.root.remove(this.drinkPage);
            this.root.add(tabPanel, 0, 0, 10, 10);
        });
        this.drinkPage.add(backButton, 0, 0);

        // name of the drink, 0x0 is black
        this.title = new WLabel("").setColor(0x0);
        this.drinkPage.add(this.title, 2, 1);

        // recipe information for the drink, 0x8 is dark gray
        this.info1 = new WLabel("").setColor(0x8);
        this.info2 = new WLabel("").setColor(0x8);
        this.info3 = new WLabel("").setColor(0x8);
        this.drinkPage.add(this.info1, 1, 3);
        this.drinkPage.add(this.info2, 1, 4);
        this.drinkPage.add(this.info3, 1, 5);

        // description for the drink, not using .setColor() defaults to gray
        this.desc1 = new WLabel("");
        this.desc2 = new WLabel("");
        this.desc3 = new WLabel("");
        this.drinkPage.add(this.desc1, 1, 6);
        this.drinkPage.add(this.desc2, 1, 7);
        this.drinkPage.add(this.desc3, 1, 8);

        // flavor and types of the drink, not using .setColor() defaults to gray
        this.tags = new WLabel("");
        this.drinkPage.add(this.tags, 1, 10);
        /* ------------ END DRINK PAGE ------------ */

    }

    private WButton[] switchCases(int i, int type) {
        if (type == 0) {    // by name
            switch (i) {
                case 0:     // B
                    return new WButton[] {badTouch, beer, bleedingJane, bloomLight, blueFairy, brandtini};
                case 1:     // C
                    return new WButton[] {cobaltVelvet, creviceSpike};
                case 2:     // F
                    return new WButton[] {fluffyDream, fringeWeaver, frothyWater};
                case 3:     // G
                    return new WButton[] {grizzlyTemple, gutPunch};
                case 4:     // M
                    return new WButton[] {marsblast, mercuryblast, moonblast};
                case 5:     // P
                    return new WButton[] {pianoMan, pianoWoman, pileDriver};
                case 6:     // S
                    return new WButton[] {sparkleStar, sugarRush, sunshineCloud, suplex};
                case 7:     // Z
                    return new WButton[] {zenStar};
                default:
                    return new WButton[] {};
            }
        } else if (type == 1) { // by flavor
            switch (i) {
                case 0:     // bitter
                    return new WButton[] {grizzlyTemple, gutPunch, pileDriver, sunshineCloud, suplex};
                case 1:     // bubbly
                    return new WButton[] {beer, cobaltVelvet, fringeWeaver, frothyWater};
                case 2:     // sour
                    return new WButton[] {badTouch, creviceSpike, mercuryblast, pianoMan, zenStar};
                case 3:     // spicy
                    return new WButton[] {bleedingJane, bloomLight, marsblast};
                case 4:     // sweet
                    return new WButton[] {blueFairy, brandtini, fluffyDream, moonblast, pianoWoman, sparkleStar, sugarRush};
                default:
                    return new WButton[] {};
            }
        } else {            // by type
            switch (i) {
                case 0:     // classic
                    return new WButton[] {beer, bleedingJane, frothyWater, bloomLight};
                case 1:     // classy
                    return new WButton[] {badTouch, brandtini, cobaltVelvet, fringeWeaver, mercuryblast};
                case 2:     // girly
                    return new WButton[] {blueFairy, fluffyDream, moonblast, sparkleStar, sugarRush, sunshineCloud};
                case 3:     // manly
                    return new WButton[] {creviceSpike, gutPunch, marsblast, pileDriver, suplex};
                case 4:     // promo
                    return new WButton[] {bloomLight, grizzlyTemple, pianoMan, pianoWoman, zenStar};
                default:
                    return new WButton[] {};
            }
        }
    }

    private void setButtons(int i, int type) {
        // takes all the saved buttons in this.listDrinks and removes them from this.list
        for (WButton button : this.listDrinks) {
            this.list.remove(button);
        }

        WButton[] buttons = this.switchCases(i, type);  // gets the buttons that should be added
        this.listDrinks = new WButton[buttons.length];  // prepares this.listDrinks to store the buttons that'll be added
        for (int y = 0; y < buttons.length; y++) {
            this.listDrinks[y] = buttons[y];            // saves button
            this.list.add(this.listDrinks[y], 0, y, 5, 1); // shows button
        }
    }

    private void textWrap(WLabel[] textLabels, String[] text, boolean betweenQuotationMarks) {
        StringBuilder newText = new StringBuilder(); // text that will be set
        if (betweenQuotationMarks) {
            newText.append("\"");
        }
        int usedColorCodes; // color codes still influence the length of the string even though they aren't shown in game
        int i = 0;

        for (int y = 0; y < text.length; y++) {
            newText.append(text[y]).append(y + 1 >= text.length ? "" : " ");
            usedColorCodes = 0;
            for (int x = 0; x < newText.length(); x++) {
                if (newText.charAt(x) == '§') {
                    // § is always followed by a letter or a number
                    // and we do not want to count either in the string length
                    usedColorCodes += 2;
                }
            }

            if (newText.length()-usedColorCodes >= 35 || y+1 >= text.length) {
                // if the text is longer than the max allowed length it will
                // be set for one of the lines and then emptied
                newText.append(y+1 >= text.length && betweenQuotationMarks ? "\"" : "");
                switch (i) {
                    case 0:
                        textLabels[0].setText(new LiteralText(newText.toString()));
                        newText = new StringBuilder();
                        i++;
                        break;
                    case 1:
                        textLabels[1].setText(new LiteralText(newText.toString()));
                        newText = new StringBuilder();
                        i++;
                        break;
                    default:
                        // this does not reset the line so that if the text
                        // is longer than the max allowed length it will still all
                        // be shown on this line as it is the
                        // missing information
                        textLabels[2].setText(new LiteralText(newText.toString()));
                        break;
                }
            }
        }
    }

    private void setDrinkPage(int page) {
        Text[] drinkInfo = DrinkInfos.CraftableDrinks.values()[page].translatedTexts();

        this.title.setText(new LiteralText("§l" + drinkInfo[0].getString())); // name of the drink

        // reset the text
        this.info1.setText(new LiteralText(""));
        this.info2.setText(new LiteralText(""));
        this.info3.setText(new LiteralText(""));
        // sets recipe information
        String[] info = drinkInfo[1].getString().split(" ");
        this.textWrap(new WLabel[] {this.info1, this.info2, this.info3}, info, false);

        // reset the text
        this.desc1.setText(new LiteralText(""));
        this.desc2.setText(new LiteralText(""));
        this.desc3.setText(new LiteralText(""));
        // sets drink description
        String[] desc = drinkInfo[2].getString().split(" ");
        this.textWrap(new WLabel[] {this.desc1, this.desc2, this.desc3}, desc, true);

        this.tags.setText(drinkInfo[3]); // tags of the drink

        // changes the panel from the search panel to the drink panel
        this.root.remove(this.tabPanel);
        this.root.add(this.drinkPage, 0, 0);
    }
}
