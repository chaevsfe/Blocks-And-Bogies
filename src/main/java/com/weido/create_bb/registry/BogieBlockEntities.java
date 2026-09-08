package com.weido.create_bb.registry;

import com.weido.create_bb.BlocksBogies;
import com.weido.create_bb.blocks.BBBogieBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Set;

public class BogieBlockEntities {
    public static final BlockEntityType<BBBogieBlockEntity> BOGEY = Registry.register(
        BuiltInRegistries.BLOCK_ENTITY_TYPE,
        BlocksBogies.asResource("bogey"),
        new BlockEntityType<>((pos, state) -> new BBBogieBlockEntity(BogieBlockEntities.BOGEY, pos, state), Set.of(
            BogieBlocks.L_020_ROT, BogieBlocks.XL_020_ROT,
            BogieBlocks.L_040_ROT, BogieBlocks.XL_040_ROT,
            BogieBlocks.L_060_ROT, BogieBlocks.XL_060_ROT,
            BogieBlocks.L_080_ROT, BogieBlocks.XL_080_ROT,
            BogieBlocks.L_0100_ROT, BogieBlocks.XL_0100_ROT,
            BogieBlocks.L_0120_ROT,

            BogieBlocks.L_020, BogieBlocks.XL_020,
            BogieBlocks.L_040, BogieBlocks.XL_040,
            BogieBlocks.L_060, BogieBlocks.XL_060,
            BogieBlocks.L_080, BogieBlocks.XL_080,
            BogieBlocks.L_0100, BogieBlocks.XL_0100,
            BogieBlocks.L_0120,

            BogieBlocks.S_020_TRAILING, BogieBlocks.S_040_TRAILING, BogieBlocks.S_060_TRAILING, BogieBlocks.S_080_TRAILING, BogieBlocks.S_0100_STANDARD,
            BogieBlocks.S_020_OFFSET, BogieBlocks.S_020_STANDARD, BogieBlocks.S_060_STANDARD, BogieBlocks.S_080_STANDARD)));

    public static void register() {
        BlocksBogies.LOGGER.info("Registered block entities for " + BlocksBogies.MOD_NAME);
    }
}
