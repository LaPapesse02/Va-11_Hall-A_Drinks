package com.github.lapapesse02.va11halla_drinks;

import com.github.lapapesse02.va11halla_drinks.ingredients.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterItems {
    // ingredients
    public static final Adelhyde ADELHYDE;
    public static final PowderedDelta POWDERED_DELTA;
    public static final BronsonExtract BRONSON_EXTRACT;
    public static final Flanergide FLANERGIDE;
    public static final Karmotrine KARMOTRINE;

    static {
        // ingredients
        ADELHYDE = new Adelhyde(new Adelhyde.Settings().group(ModStarter.MOD_GROUP));
        POWDERED_DELTA = new PowderedDelta(new PowderedDelta.Settings().group(ModStarter.MOD_GROUP));
        BRONSON_EXTRACT = new BronsonExtract(new BronsonExtract.Settings().group(ModStarter.MOD_GROUP));
        FLANERGIDE = new Flanergide(new Flanergide.Settings().group(ModStarter.MOD_GROUP));
        KARMOTRINE = new Karmotrine(new Karmotrine.Settings().group(ModStarter.MOD_GROUP));
    }

    public static void register () {
        // ingredients
        Registry.register(Registry.ITEM, new Identifier("va11halla_drinks", "adelhyde"), ADELHYDE);
        Registry.register(Registry.ITEM, new Identifier("va11halla_drinks", "powdered_delta"), POWDERED_DELTA);
        Registry.register(Registry.ITEM, new Identifier("va11halla_drinks", "bronson_extract"), BRONSON_EXTRACT);
        Registry.register(Registry.ITEM, new Identifier("va11halla_drinks", "flanergide"), FLANERGIDE);
        Registry.register(Registry.ITEM, new Identifier("va11halla_drinks", "karmotrine"), KARMOTRINE);
    }

}
