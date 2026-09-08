package com.weido.create_bb.registry;

import com.weido.create_bb.BlocksBogies;
import com.weido.create_bb.blocks.BBBogieBlock;
import com.weido.create_bb.blocks.bogies.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Function;

public class BogieBlocks {
    public static final LargeSingleAxleRot L_020_ROT = register("l_020_rot", LargeSingleAxleRot::new);
    public static final LargeDoubleAxleRot L_040_ROT = register("l_040_rot", LargeDoubleAxleRot::new);
    public static final LargeTripleAxleRot L_060_ROT = register("l_060_rot", LargeTripleAxleRot::new);
    public static final LargeQuadrupleAxleRot L_080_ROT = register("l_080_rot", LargeQuadrupleAxleRot::new);
    public static final LargeQuintupleAxleRot L_0100_ROT = register("l_0100_rot", LargeQuintupleAxleRot::new);
    public static final LargeSextupleAxleRot L_0120_ROT = register("l_0120_rot", LargeSextupleAxleRot::new);
    public static final ExtraLargeSingleAxleRot XL_020_ROT = register("xl_020_rot", ExtraLargeSingleAxleRot::new);
    public static final ExtraLargeDoubleAxleRot XL_040_ROT = register("xl_040_rot", ExtraLargeDoubleAxleRot::new);
    public static final ExtraLargeTripleAxleRot XL_060_ROT = register("xl_060_rot", ExtraLargeTripleAxleRot::new);
    public static final ExtraLargeQuadrupleAxleRot XL_080_ROT = register("xl_080_rot", ExtraLargeQuadrupleAxleRot::new);
    public static final ExtraLargeQuintupleAxleRot XL_0100_ROT = register("xl_0100_rot", ExtraLargeQuintupleAxleRot::new);
    public static final LargeSingleAxle L_020 = register("l_020", LargeSingleAxle::new);
    public static final LargeDoubleAxle L_040 = register("l_040", LargeDoubleAxle::new);
    public static final LargeTripleAxle L_060 = register("l_060", LargeTripleAxle::new);
    public static final LargeQuadrupleAxle L_080 = register("l_080", LargeQuadrupleAxle::new);
    public static final LargeQuintupleAxle L_0100 = register("l_0100", LargeQuintupleAxle::new);
    public static final LargeSextupleAxle L_0120 = register("l_0120", LargeSextupleAxle::new);
    public static final ExtraLargeSingleAxle XL_020 = register("xl_020", ExtraLargeSingleAxle::new);
    public static final ExtraLargeDoubleAxle XL_040 = register("xl_040", ExtraLargeDoubleAxle::new);
    public static final ExtraLargeTripleAxle XL_060 = register("xl_060", ExtraLargeTripleAxle::new);
    public static final ExtraLargeQuadrupleAxle XL_080 = register("xl_080", ExtraLargeQuadrupleAxle::new);
    public static final ExtraLargeQuintupleAxle XL_0100 = register("xl_0100", ExtraLargeQuintupleAxle::new);
    public static final SmallSingleAxleTrailing S_020_TRAILING = register("s_020_trailing", SmallSingleAxleTrailing::new);
    public static final SmallDoubleAxleTrailing S_040_TRAILING = register("s_040_trailing", SmallDoubleAxleTrailing::new);
    public static final SmallTripleAxleTrailing S_060_TRAILING = register("s_060_trailing", SmallTripleAxleTrailing::new);
    public static final SmallQuadrupleAxleTrailing S_080_TRAILING = register("s_080_trailing", SmallQuadrupleAxleTrailing::new);
    public static final SmallSingleAxleBogie S_020_STANDARD = register("s_020_standard", SmallSingleAxleBogie::new);
    public static final SmallTripleAxleStandard S_060_STANDARD = register("s_060_standard", SmallTripleAxleStandard::new);
    public static final SmallQuadrupleAxleStandard S_080_STANDARD = register("s_080_standard", SmallQuadrupleAxleStandard::new);
    public static final SmallQuintupleAxleStandard S_0100_STANDARD = register("s_0100_standard", SmallQuintupleAxleStandard::new);
    public static final SmallSingleAxleOffset S_020_OFFSET = register("s_020_offset", SmallSingleAxleOffset::new);

    private static Properties bogieProperties() {
        return Properties.ofFullCopy(Blocks.GOLD_BLOCK)
            .mapColor(MapColor.PODZOL)
            .sound(SoundType.NETHERITE_BLOCK)
            .noOcclusion()
            .requiresCorrectToolForDrops();
    }

    private static <T extends BBBogieBlock> T register(String name, Function<Properties, T> factory) {
        Identifier id = BlocksBogies.asResource(name);
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, id);
        T block = factory.apply(bogieProperties().setId(key));
        Registry.register(BuiltInRegistries.BLOCK, id, block);
        return block;
    }

    public static void register() {
        BlocksBogies.LOGGER.info("Registered bogie blocks for " + BlocksBogies.MOD_NAME);
    }
}
