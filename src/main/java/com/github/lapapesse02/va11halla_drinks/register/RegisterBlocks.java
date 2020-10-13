package com.github.lapapesse02.va11halla_drinks.register;

import com.github.lapapesse02.va11halla_drinks.ModStarter;
import com.github.lapapesse02.va11halla_drinks.block_entities.DrinkMakerEntity;
import com.github.lapapesse02.va11halla_drinks.blocks.DrinkMaker;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterBlocks {
    public static final DrinkMaker DRINK_MAKER;
    public static BlockEntityType<DrinkMakerEntity> DRINK_MAKER_ENTITY_TYPE;

    static {
        DRINK_MAKER = new DrinkMaker(FabricBlockSettings.of(Material.METAL).hardness(5F).breakByTool(FabricToolTags.PICKAXES, 2).breakByHand(false));
        DRINK_MAKER_ENTITY_TYPE = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(ModStarter.MOD_ID, "block_entity"), BlockEntityType.Builder.create(DrinkMakerEntity::new, DRINK_MAKER).build(null));
    }

    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier(ModStarter.MOD_ID, "drink_maker"), DRINK_MAKER);
        Registry.register(Registry.ITEM, new Identifier(ModStarter.MOD_ID, "drink_maker"), new BlockItem(DRINK_MAKER, new Item.Settings().group(RegisterMiscellaneous.MOD_GROUP)));
    }
}
