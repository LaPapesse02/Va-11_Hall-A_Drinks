package com.github.lapapesse02.va11halla_drinks;

import net.minecraft.client.resource.language.I18n;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class DrinkInfos {
    public enum CraftableDrinks {
        BAD_TOUCH("bad_touch", new int[] {0, 2, 2, 2, 4}, Tags.BAD_TOUCH),
        BEER("beer", new int[] {1, 2, 1, 2, 4}, Tags.BEER),
        BLEEDING_JANE("bleeding_jane", new int[] {0, 1, 3, 3, 0}, Tags.BLEEDING_JANE),
        BLOOM_LIGHT("bloom_light", new int[] {4, 0, 1, 2, 3}, Tags.BLOOM_LIGHT),
        BLUE_FAIRY("blue_fairy", new int[] {4, 0, 0, 1, 0}, Tags.BLUE_FAIRY),
        BRANDTINI("brandtini", new int[] {6, 0, 3, 0, 1}, Tags.BRANDTINI),
        COBALT_VELVET("cobalt_velvet", new int[] {2, 0, 0, 3, 5}, Tags.COBALT_VELVET),
        CREVICE_SPIKE("crevice_spike", new int[] {0, 0, 2, 4, 0}, Tags.CREVICE_SPIKE),
        FLUFFY_DREAM("fluffy_dream", new int[] {3, 0, 3, 0, 0}, Tags.FLUFFY_DREAM),
        FRINGE_WEAVER("fringe_weaver", new int[] {1, 0, 0, 0, 9}, Tags.FRINGE_WEAVER),
        FROTHY_WATER("frothy_water", new int[] {1, 1, 1, 1, 0}, Tags.FROTHY_WATER),
        GRIZZLY_TEMPLE("grizzly_temple", new int[] {3, 3, 3, 0, 1}, Tags.GRIZZLY_TEMPLE),
        GUT_PUNCH("gut_punch", new int[] {0, 5, 0, 1, 0}, Tags.GUT_PUNCH),
        MARSBLAST("marsblast", new int[] {0, 6, 1, 4, 2}, Tags.MARSBLAST),
        MERCURYBLAST("mercuryblast", new int[] {1, 1, 3, 3, 2}, Tags.MERCURYBLAST),
        MOONBLAST("moonblast", new int[] {6, 0, 1, 1, 2}, Tags.MOONBLAST),
        PIANO_MAN("piano_man", new int[] {2, 3, 5, 5, 3}, Tags.PIANO_MAN),
        PIANO_WOMAN("piano_woman", new int[] {5, 5, 2, 3, 3}, Tags.PIANO_WOMAN),
        PILE_DRIVER("pile_driver", new int[] {0, 3, 0, 3, 4}, Tags.PILE_DRIVER),
        SPARKLE_STAR("sparkle_star", new int[] {2, 0, 1, 0, 0}, Tags.SPARKLE_STAR),
        SUGAR_RUSH("sugar_rush", new int[] {2, 0, 1, 0, 0}, Tags.SUGAR_RUSH),
        SUNSHINE_CLOUD("sunshine_cloud", new int[] {2, 2, 0, 0, 0}, Tags.SUNSHINE_CLOUD),
        SUPLEX("suplex", new int[] {0, 4, 0, 3, 3}, Tags.SUPLEX),
        ZEN_STAR("zen_star", new int[] {4, 4, 4, 4, 4}, Tags.ZEN_STAR),
        FAILED_DRINK("failed_drink", new int[] {0, 0, 0, 0, 0}, Tags.FAILED_DRINK),
        FLAMING_MOAI("flaming_moai", new int[] {1, 1, 2, 3, 5}, Tags.FLAMING_MOAI);


        public static String NAME_PATH = "item." + ModStarter.MOD_ID + ".";
        public static String TOOLTIP_PATH = "tooltip." + ModStarter.MOD_ID + ".info.";
        public static String CRAFTING_PATH = "recipe_info." + ModStarter.MOD_ID + ".";
        public String name;
        public int[] ingredients;
        public Tags tags;

        CraftableDrinks (String name, int[] ingredients, Tags tags) {
            this.name = name;
            this.ingredients = ingredients;
            this.tags = tags;
        }

        @Override
        public String toString() {
            return this.name;
        }

        public String[] toList() {
            String[] list = new String[1 + this.tags.toList().length];
            list[0] = this.name;
            for (int i = 0; i <= this.tags.toList().length; i++) {
                list[i+1] = this.tags.toList()[i];
            }

            return list;
        }

        public Text[] translatedTexts() {
            Text[] list = new Text[4];
            list[0] = new TranslatableText(NAME_PATH + this.name);
            list[1] = new LiteralText(I18n.translate(CRAFTING_PATH + this.name));
            list[2] = new LiteralText(I18n.translate(TOOLTIP_PATH + this.name));

            String str = "";
            for (int i = 0; i < this.tags.toList().length; i++) {
                str += new TranslatableText(Tags.PATH + this.tags.toList()[i]).getString() + (i+1 == this.tags.toList().length ? "." : ", ");
            }
            list[3] = new LiteralText(str);
            return list;
        }
    }

    public enum Tags {
        BAD_TOUCH(new String[] {"sour", "classy", "vintage"}),
        BEER(new String[] {"bubbly", "classic", "vintage"}),
        BLEEDING_JANE(new String[] {"spicy", "classic", "sobering"}),
        BLOOM_LIGHT(new String[] {"spicy", "promo", "bland"}),
        BLUE_FAIRY(new String[] {"sweet", "girly", "soft"}),
        BRANDTINI(new String[] {"sweet", "classy", "happy"}),
        COBALT_VELVET(new String[] {"bubbly", "classy", "burning"}),
        CREVICE_SPIKE(new String[] {"sour", "manly", "sobering"}),
        FLUFFY_DREAM(new String[] {"sweet", "girly", "soft"}),
        FRINGE_WEAVER(new String[] {"bubbly", "classy", "strong"}),
        FROTHY_WATER(new String[] {"bubbly", "bland", "classic"}),
        GRIZZLY_TEMPLE(new String[] {"bitter", "bland", "promo"}),
        GUT_PUNCH(new String[] {"bitter", "manly", "strong"}),
        MARSBLAST(new String[] {"spicy", "manly", "strong"}),
        MERCURYBLAST(new String[] {"sour", "burning", "classy"}),
        MOONBLAST(new String[] {"sweet", "girly", "happy"}),
        PIANO_MAN(new String[] {"sour", "promo", "strong"}),
        PIANO_WOMAN(new String[] {"sweet", "happy", "promo"}),
        PILE_DRIVER(new String[] {"bitter", "burning", "manly"}),
        SPARKLE_STAR(new String[] {"sweet", "girly", "happy"}),
        SUGAR_RUSH(new String[] {"sweet", "girly", "happy"}),
        SUNSHINE_CLOUD(new String[] {"bitter", "girly", "soft"}),
        SUPLEX(new String[] {"bitter", "burning", "manly"}),
        ZEN_STAR(new String[] {"sour", "bland", "promo"}),
        FAILED_DRINK(new String[] {}),
        FLAMING_MOAI(new String[] {"sour", "classy"});


        public static final String PATH = "tags." + ModStarter.MOD_ID + "."; // path used for translation
        public final String[] tags;

        Tags (String[] str) {
            this.tags = str;
        }

        @Override
        public String toString() {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < this.tags.length; i++) {
                str.append(new TranslatableText(PATH + this.tags[i]))
                        .append(i + 1 >= this.tags.length ? "." : ", ");
            }
            return str.toString();
        }

        public String[] toList() {
            return this.tags;
        }
    }
}
