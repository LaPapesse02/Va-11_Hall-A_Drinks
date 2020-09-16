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

    // drinks
    public static final BadTouch BAD_TOUCH;
    public static final Beer BEER;
    public static final BleedingJane BLEEDING_JANE;
    public static final BloomLight BLOOM_LIGHT;
    public static final BlueFairy BLUE_FAIRY;
    public static final Brandtini BRANDTINI;
    public static final CobaltVelvet COBALT_VELVET;


    static {
        // ingredients
        ADELHYDE = new Adelhyde(new Adelhyde.Settings().group(RegisterMiscellaneous.MOD_GROUP));
        POWDERED_DELTA = new PowderedDelta(new PowderedDelta.Settings().group(RegisterMiscellaneous.MOD_GROUP));
        BRONSON_EXTRACT = new BronsonExtract(new BronsonExtract.Settings().group(RegisterMiscellaneous.MOD_GROUP));
        FLANERGIDE = new Flanergide(new Flanergide.Settings().group(RegisterMiscellaneous.MOD_GROUP));
        KARMOTRINE = new Karmotrine(new Karmotrine.Settings().group(RegisterMiscellaneous.MOD_GROUP));

        // drinks
        BAD_TOUCH = new BadTouch(new BadTouch.Settings().group(RegisterMiscellaneous.MOD_GROUP));
        BEER = new Beer(new Beer.Settings().group(RegisterMiscellaneous.MOD_GROUP));
        BLEEDING_JANE = new BleedingJane(new BleedingJane.Settings().group(RegisterMiscellaneous.MOD_GROUP));
        BLOOM_LIGHT = new BloomLight(new BloomLight.Settings().group(RegisterMiscellaneous.MOD_GROUP));
        BLUE_FAIRY = new BlueFairy(new BlueFairy.Settings().group(RegisterMiscellaneous.MOD_GROUP));
        BRANDTINI = new Brandtini(new Brandtini.Settings().group(RegisterMiscellaneous.MOD_GROUP));
        COBALT_VELVET = new CobaltVelvet(new CobaltVelvet.Settings().group(RegisterMiscellaneous.MOD_GROUP));
    }


    public static void register() {
        // ingredients
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "adelhyde"), ADELHYDE);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "powdered_delta"), POWDERED_DELTA);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "bronson_extract"), BRONSON_EXTRACT);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "flanergide"), FLANERGIDE);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "karmotrine"), KARMOTRINE);

        // drinks
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "bad_touch"), BAD_TOUCH);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "beer"), BEER);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "bleeding_jane"), BLEEDING_JANE);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "bloom_light"), BLOOM_LIGHT);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "blue_fairy"), BLUE_FAIRY);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "brandtini"), BRANDTINI);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "cobalt_velvet"), COBALT_VELVET);
    }
}
