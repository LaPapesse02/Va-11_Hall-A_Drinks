package com.github.lapapesse02.va11halla_drinks.register;

import com.github.lapapesse02.va11halla_drinks.ModStarter;
import com.github.lapapesse02.va11halla_drinks.items.drinks.*;
import com.github.lapapesse02.va11halla_drinks.items.ingredients.*;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterItems {
    // ingredients
    public static final Adelhyde ADELHYDE;
    public static final PowderedDelta POWDERED_DELTA;
    public static final BronsonExtract BRONSON_EXTRACT;
    public static final Flanergide FLANERGIDE;
    public static final Karmotrine KARMOTRINE;

    // craftable drinks
    public static final BadTouch BAD_TOUCH;
    public static final Beer BEER;
    public static final BleedingJane BLEEDING_JANE;
    public static final BloomLight BLOOM_LIGHT;
    public static final BlueFairy BLUE_FAIRY;
    public static final Brandtini BRANDTINI;
    public static final CobaltVelvet COBALT_VELVET;
    public static final CreviceSpike CREVICE_SPIKE;
    public static final FluffyDream FLUFFY_DREAM;
    public static final FringeWeaver FRINGE_WEAVER;
    public static final FrothyWater FROTHY_WATER;
    public static final GrizzlyTemple GRIZZLY_TEMPLE;
    public static final GutPunch GUT_PUNCH;
    public static final Marsblast MARSBLAST;
    public static final Mercuryblast MERCURYBLAST;
    public static final Moonblast MOONBLAST;
    public static final PianoMan PIANO_MAN;
    public static final PianoWoman PIANO_WOMAN;
    public static final PileDriver PILE_DRIVER;
    public static final SparkleStar SPARKLE_STAR;
    public static final SugarRush SUGAR_RUSH;
    public static final SunshineCloud SUNSHINE_CLOUD;
    public static final Suplex SUPLEX;
    public static final ZenStar ZEN_STAR;

    public static final FailedDrink FAILED_DRINK;


    static {
        // ingredients
        ADELHYDE = new Adelhyde(new Adelhyde.Settings().group(RegisterMiscellaneous.MOD_GROUP));
        POWDERED_DELTA = new PowderedDelta(new PowderedDelta.Settings().group(RegisterMiscellaneous.MOD_GROUP));
        BRONSON_EXTRACT = new BronsonExtract(new BronsonExtract.Settings().group(RegisterMiscellaneous.MOD_GROUP));
        FLANERGIDE = new Flanergide(new Flanergide.Settings().group(RegisterMiscellaneous.MOD_GROUP));
        KARMOTRINE = new Karmotrine(new Karmotrine.Settings().group(RegisterMiscellaneous.MOD_GROUP));

        // craftable drinks
        BAD_TOUCH = new BadTouch(new BadTouch.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));
        BEER = new Beer(new Beer.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));
        BLEEDING_JANE = new BleedingJane(new BleedingJane.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));
        BLOOM_LIGHT = new BloomLight(new BloomLight.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));
        BLUE_FAIRY = new BlueFairy(new BlueFairy.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));
        BRANDTINI = new Brandtini(new Brandtini.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));
        COBALT_VELVET = new CobaltVelvet(new CobaltVelvet.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));
        CREVICE_SPIKE = new CreviceSpike(new CreviceSpike.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));
        FLUFFY_DREAM = new FluffyDream(new FluffyDream.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));
        FRINGE_WEAVER = new FringeWeaver(new FringeWeaver.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));
        FROTHY_WATER = new FrothyWater(new FrothyWater.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));
        GRIZZLY_TEMPLE = new GrizzlyTemple(new GrizzlyTemple.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));
        GUT_PUNCH = new GutPunch(new GutPunch.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));
        MARSBLAST = new Marsblast(new Marsblast.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));
        MERCURYBLAST = new Mercuryblast(new Mercuryblast.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));
        MOONBLAST = new Moonblast(new Moonblast.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));
        PIANO_MAN = new PianoMan(new PianoMan.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));
        PIANO_WOMAN = new PianoWoman(new PianoWoman.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));
        PILE_DRIVER = new PileDriver(new PileDriver.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));
        SPARKLE_STAR = new SparkleStar(new SparkleStar.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));
        SUGAR_RUSH = new SugarRush(new SugarRush.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));
        SUNSHINE_CLOUD = new SunshineCloud(new SunshineCloud.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));
        SUPLEX = new Suplex(new Suplex.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));
        ZEN_STAR = new ZenStar(new ZenStar.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));

        FAILED_DRINK = new FailedDrink(new FailedDrink.Settings().group(RegisterMiscellaneous.MOD_GROUP).maxCount(1));
    }


    public static void register() {
        // ingredients
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "adelhyde"), ADELHYDE);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "powdered_delta"), POWDERED_DELTA);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "bronson_extract"), BRONSON_EXTRACT);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "flanergide"), FLANERGIDE);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "karmotrine"), KARMOTRINE);

        // craftable drinks
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "bad_touch"), BAD_TOUCH);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "beer"), BEER);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "bleeding_jane"), BLEEDING_JANE);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "bloom_light"), BLOOM_LIGHT);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "blue_fairy"), BLUE_FAIRY);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "brandtini"), BRANDTINI);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "cobalt_velvet"), COBALT_VELVET);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "crevice_spike"), CREVICE_SPIKE);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "fluffy_dream"), FLUFFY_DREAM);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "fringe_weaver"), FRINGE_WEAVER);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "frothy_water"), FROTHY_WATER);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "grizzly_temple"), GRIZZLY_TEMPLE);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "gut_punch"), GUT_PUNCH);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "marsblast"), MARSBLAST);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "mercuryblast"), MERCURYBLAST);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "moonblast"), MOONBLAST);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "piano_man"), PIANO_MAN);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "piano_woman"), PIANO_WOMAN);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "pile_driver"), PILE_DRIVER);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "sparkle_star"), SPARKLE_STAR);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "sugar_rush"), SUGAR_RUSH);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "sunshine_cloud"), SUNSHINE_CLOUD);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "suplex"), SUPLEX);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "zen_star"), ZEN_STAR);

        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "failed_drink"), FAILED_DRINK);
    }
}
