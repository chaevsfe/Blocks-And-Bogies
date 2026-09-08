package com.weido.create_bb.registry;

import com.zurrtum.create.AllBogeyStyles;
import com.zurrtum.create.content.trains.bogey.AllBogeySizes;
import com.zurrtum.create.content.trains.bogey.BogeyStyle;
import com.weido.create_bb.BlocksBogies;
import com.weido.create_bb.data.menu.Entry.*;
import net.minecraft.network.chat.Component;

import static com.weido.create_bb.data.menu.Entry.StyleEntry.*;

public class BogieStyles {
    public static final BogeyStyle SINGLE_AXLE_TRAILING
        = builder("single_axle_trailing").displayName(Component.translatable("create_bb.bogies.style.single_axle_trailing"))
        .size(AllBogeySizes.SMALL, BogieBlocks.S_020_TRAILING)
        .build();

    public static final BogeyStyle DOUBLE_AXLE_TRAILING
        = builder("double_axle_trailing").displayName(Component.translatable("create_bb.bogies.style.double_axle_trailing"))
        .size(AllBogeySizes.SMALL, BogieBlocks.S_040_TRAILING)
        .build();

    public static final BogeyStyle TRIPLE_AXLE_TRAILING
        = builder("triple_axle_trailing").displayName(Component.translatable("create_bb.bogies.style.triple_axle_trailing"))
        .size(AllBogeySizes.SMALL, BogieBlocks.S_060_TRAILING)
        .build();

    public static final BogeyStyle QUADRUPLE_AXLE_TRAILING
        = builder("quadruple_axle_trailing").displayName(Component.translatable("create_bb.bogies.style.quadruple_axle_trailing"))
        .size(AllBogeySizes.SMALL, BogieBlocks.S_080_TRAILING)
        .build();

    public static final BogeyStyle SINGLE_AXLE_OFFSET
        = builder("single_axle_offset").displayName(Component.translatable("create_bb.bogies.style.single_axle_offset"))
        .size(AllBogeySizes.SMALL, BogieBlocks.S_020_OFFSET)
        .build();

    public static final BogeyStyle SINGLE_AXLE_BOGIE
        = builder("single_axle_bogie").displayName(Component.translatable("create_bb.bogies.style.single_axle_bogie"))
        .size(AllBogeySizes.SMALL, BogieBlocks.S_020_STANDARD)
        .build();

    public static final BogeyStyle TRIPLE_AXLE_BOGIE
        = builder("triple_axle_bogie").displayName(Component.translatable("create_bb.bogies.style.triple_axle_bogie"))
        .size(AllBogeySizes.SMALL, BogieBlocks.S_060_STANDARD)
        .build();

    public static final BogeyStyle QUADRUPLE_AXLE_BOGIE
        = builder("quadruple_axle_bogie").displayName(Component.translatable("create_bb.bogies.style.quadruple_axle_bogie"))
        .size(AllBogeySizes.SMALL, BogieBlocks.S_080_STANDARD)
        .build();

    public static final BogeyStyle QUINTUPLE_AXLE_BOGIE
        = builder("quintuple_axle_bogie").displayName(Component.translatable("create_bb.bogies.style.quintuple_axle_bogie"))
        .size(AllBogeySizes.SMALL, BogieBlocks.S_0100_STANDARD)
        .build();

//Pistonless
    public static final BogeyStyle SINGLE_AXLE_PISTONLESS
        = builder("single_axle_pistonless").displayName(Component.translatable("create_bb.bogies.style.single_axle_pistonless"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_020)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_020)
        .build();

    public static final BogeyStyle DOUBLE_AXLE_PISTONLESS
        = builder("double_axle_pistonless").displayName(Component.translatable("create_bb.bogies.style.double_axle_pistonless"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_040)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_040)
        .build();

    public static final BogeyStyle TRIPLE_AXLE_EXTENDED_PISTONLESS
            = builder("triple_axle_extended_pistonless").displayName(Component.translatable("create_bb.bogies.style.triple_axle_extended_pistonless"))
            .size(AllBogeySizes.LARGE, BogieBlocks.XL_060_ROT)
            .size(AllBogeySizes.SMALL, BogieBlocks.L_060_ROT)
            .build();

    public static final BogeyStyle TRIPLE_AXLE_PISTONLESS
        = builder("triple_axle_pistonless").displayName(Component.translatable("create_bb.bogies.style.triple_axle_pistonless"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_060)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_060)
        .build();

    public static final BogeyStyle QUADRUPLE_AXLE_PISTONLESS
        = builder("quadruple_axle_pistonless").displayName(Component.translatable("create_bb.bogies.style.quadruple_axle_pistonless"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_080)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_080)
        .build();

    public static final BogeyStyle QUINTUPLE_AXLE_PISTONLESS
        = builder("quintuple_axle_pistonless").displayName(Component.translatable("create_bb.bogies.style.quintuple_axle_pistonless"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_0100)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_0100)
        .build();

    public static final BogeyStyle SEXTUPLE_AXLE_PISTONLESS
        = builder("sextuple_axle_pistonless").displayName(Component.translatable("create_bb.bogies.style.sextuple_axle_pistonless"))
        .size(AllBogeySizes.SMALL, BogieBlocks.L_0120)
        .build();

    //Rodless
    public static final BogeyStyle DOUBLE_AXLE_RODLESS
            = builder("double_axle_rodless").displayName(Component.translatable("create_bb.bogies.style.double_axle_rodless"))
            .size(AllBogeySizes.LARGE, BogieBlocks.XL_040)
            .size(AllBogeySizes.SMALL, BogieBlocks.L_040)
            .build();

    public static final BogeyStyle TRIPLE_AXLE_EXTENDED_RODLESS
            = builder("triple_axle_extended_rodless").displayName(Component.translatable("create_bb.bogies.style.triple_axle_extended_rodless"))
            .size(AllBogeySizes.LARGE, BogieBlocks.XL_060_ROT)
            .size(AllBogeySizes.SMALL, BogieBlocks.L_060_ROT)
            .build();

    public static final BogeyStyle TRIPLE_AXLE_RODLESS
            = builder("triple_axle_rodless").displayName(Component.translatable("create_bb.bogies.style.triple_axle_rodless"))
            .size(AllBogeySizes.LARGE, BogieBlocks.XL_060)
            .size(AllBogeySizes.SMALL, BogieBlocks.L_060)
            .build();

    public static final BogeyStyle QUADRUPLE_AXLE_RODLESS
            = builder("quadruple_axle_rodless").displayName(Component.translatable("create_bb.bogies.style.quadruple_axle_rodless"))
            .size(AllBogeySizes.LARGE, BogieBlocks.XL_080)
            .size(AllBogeySizes.SMALL, BogieBlocks.L_080)
            .build();

    public static final BogeyStyle QUINTUPLE_AXLE_RODLESS
            = builder("quintuple_axle_rodless").displayName(Component.translatable("create_bb.bogies.style.quintuple_axle_rodless"))
            .size(AllBogeySizes.LARGE, BogieBlocks.XL_0100)
            .size(AllBogeySizes.SMALL, BogieBlocks.L_0100)
            .build();

    public static final BogeyStyle SEXTUPLE_AXLE_RODLESS
            = builder("sextuple_axle_rodless").displayName(Component.translatable("create_bb.bogies.style.sextuple_axle_rodless"))
            .size(AllBogeySizes.SMALL, BogieBlocks.L_0120)
            .build();

//Scotch Yoke
    public static final BogeyStyle SINGLE_AXLE_SCOTCH_YOKE
        = builder("single_axle_scotch_yoke").displayName(Component.translatable("create_bb.bogies.style.single_axle_scotch_yoke"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_020)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_020)
        .build();

    public static final BogeyStyle DOUBLE_AXLE_SCOTCH_YOKE
        = builder("double_axle_scotch_yoke").displayName(Component.translatable("create_bb.bogies.style.double_axle_scotch_yoke"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_040)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_040)
        .build();

    public static final BogeyStyle TRIPLE_AXLE_SCOTCH_YOKE
        = builder("triple_axle_scotch_yoke").displayName(Component.translatable("create_bb.bogies.style.triple_axle_scotch_yoke"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_060)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_060)
        .build();

    public static final BogeyStyle QUADRUPLE_AXLE_SCOTCH_YOKE
        = builder("quadruple_axle_scotch_yoke").displayName(Component.translatable("create_bb.bogies.style.quadruple_axle_scotch_yoke"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_080)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_080)
        .build();

    public static final BogeyStyle QUINTUPLE_AXLE_SCOTCH_YOKE
        = builder("quintuple_axle_scotch_yoke").displayName(Component.translatable("create_bb.bogies.style.quintuple_axle_scotch_yoke"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_0100)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_0100)
        .build();

    public static final BogeyStyle SEXTUPLE_AXLE_SCOTCH_YOKE
        = builder("sextuple_axle_scotch_yoke").displayName(Component.translatable("create_bb.bogies.style.sextuple_axle_scotch_yoke"))
        .size(AllBogeySizes.SMALL, BogieBlocks.L_0120)
        .build();
//Long Gearless
    public static final BogeyStyle SINGLE_AXLE_LONG
        = builder("single_axle_long").displayName(Component.translatable("create_bb.bogies.style.single_axle_long"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_020_ROT)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_020_ROT)
        .build();

    public static final BogeyStyle DOUBLE_AXLE_LONG
        = builder("double_axle_long").displayName(Component.translatable("create_bb.bogies.style.double_axle_long"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_040_ROT)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_040_ROT)
        .build();

    public static final BogeyStyle DOUBLE_AXLE_EXTRA_LONG
        = builder("double_axle_extra_long").displayName(Component.translatable("create_bb.bogies.style.double_axle_extra_long"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_040_ROT)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_040_ROT)
        .build();

    public static final BogeyStyle TRIPLE_AXLE_EXTENDED_LONG
        = builder("triple_axle_extended_long").displayName(Component.translatable("create_bb.bogies.style.triple_axle_extended_long"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_060_ROT)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_060_ROT)
        .build();

    public static final BogeyStyle TRIPLE_AXLE_LONG
        = builder("triple_axle_long").displayName(Component.translatable("create_bb.bogies.style.triple_axle_long"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_060_ROT)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_060_ROT)
        .build();

    public static final BogeyStyle QUADRUPLE_AXLE_LONG
        = builder("quadruple_axle_long").displayName(Component.translatable("create_bb.bogies.style.quadruple_axle_long"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_080_ROT)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_080_ROT)
        .build();

    public static final BogeyStyle QUINTUPLE_AXLE_LONG
        = builder("quintuple_axle_long").displayName(Component.translatable("create_bb.bogies.style.quintuple_axle_long"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_0100_ROT)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_0100_ROT)
        .build();

    public static final BogeyStyle SEXTUPLE_AXLE_LONG
        = builder("sextuple_axle_long").displayName(Component.translatable("create_bb.bogies.style.sextuple_axle_long"))
        .size(AllBogeySizes.SMALL, BogieBlocks.L_0120_ROT)
        .build();
    //Short Gearless
    public static final BogeyStyle DOUBLE_AXLE_SHORT
        = builder("double_axle_short").displayName(Component.translatable("create_bb.bogies.style.double_axle_short"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_040_ROT)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_040_ROT)
        .build();

    public static final BogeyStyle TRIPLE_AXLE_EXTENDED_SHORT
        = builder("triple_axle_extended_short").displayName(Component.translatable("create_bb.bogies.style.triple_axle_extended_short"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_060_ROT)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_060_ROT)
        .build();

    public static final BogeyStyle TRIPLE_AXLE_SHORT
        = builder("triple_axle_short").displayName(Component.translatable("create_bb.bogies.style.triple_axle_short"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_060_ROT)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_060_ROT)
        .build();

    public static final BogeyStyle QUADRUPLE_AXLE_SHORT
        = builder("quadruple_axle_short").displayName(Component.translatable("create_bb.bogies.style.quadruple_axle_short"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_080_ROT)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_080_ROT)
        .build();

    public static final BogeyStyle QUINTUPLE_AXLE_SHORT
        = builder("quintuple_axle_short").displayName(Component.translatable("create_bb.bogies.style.quintuple_axle_short"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_0100_ROT)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_0100_ROT)
        .build();

    public static final BogeyStyle SEXTUPLE_AXLE_SHORT
        = builder("sextuple_axle_short").displayName(Component.translatable("create_bb.bogies.style.sextuple_axle_short"))
        .size(AllBogeySizes.SMALL, BogieBlocks.L_0120_ROT)
        .build();

    public static final BogeyStyle SINGLE_AXLE_WALSCHAERTS_LONG
        = builder("single_axle_walschaerts_long").displayName(Component.translatable("create_bb.bogies.style.single_axle_walschaerts_long"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_020_ROT)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_020_ROT)
        .build();

    public static final BogeyStyle DOUBLE_AXLE_WALSCHAERTS_LONG
        = builder("double_axle_walschaerts_long").displayName(Component.translatable("create_bb.bogies.style.double_axle_walschaerts_long"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_040_ROT)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_040_ROT)
        .build();

    public static final BogeyStyle DOUBLE_AXLE_WALSCHAERTS_EXTRA_LONG
            = builder("double_axle_walschaerts_extra_long").displayName(Component.translatable("create_bb.bogies.style.double_axle_walschaerts_extra_long"))
            .size(AllBogeySizes.LARGE, BogieBlocks.XL_040_ROT)
            .size(AllBogeySizes.SMALL, BogieBlocks.L_040_ROT)
            .build();

    public static final BogeyStyle TRIPLE_AXLE_WALSCHAERTS_EXTENDED_LONG
        = builder("triple_axle_walschaerts_extended_long").displayName(Component.translatable("create_bb.bogies.style.triple_axle_walschaerts_extended_long"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_060_ROT)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_060_ROT)
        .build();

    public static final BogeyStyle TRIPLE_AXLE_WALSCHAERTS_LONG
        = builder("triple_axle_walschaerts_long").displayName(Component.translatable("create_bb.bogies.style.triple_axle_walschaerts_long"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_060_ROT)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_060_ROT)
        .build();

    public static final BogeyStyle QUADRUPLE_AXLE_WALSCHAERTS_LONG
        = builder("quadruple_axle_walschaerts_long").displayName(Component.translatable("create_bb.bogies.style.quadruple_axle_walschaerts_long"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_080_ROT)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_080_ROT)
        .build();

    public static final BogeyStyle QUINTUPLE_AXLE_WALSCHAERTS_LONG
        = builder("quintuple_axle_walschaerts_long").displayName(Component.translatable("create_bb.bogies.style.quintuple_axle_walschaerts_long"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_0100_ROT)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_0100_ROT)
        .build();

    public static final BogeyStyle SEXTUPLE_AXLE_WALSCHAERTS_LONG
        = builder("sextuple_axle_walschaerts_long").displayName(Component.translatable("create_bb.bogies.style.sextuple_axle_walschaerts_long"))
        .size(AllBogeySizes.SMALL, BogieBlocks.L_0120_ROT)
        .build();

    public static final BogeyStyle DOUBLE_AXLE_WALSCHAERTS_SHORT
        = builder("double_axle_walschaerts_short").displayName(Component.translatable("create_bb.bogies.style.double_axle_walschaerts_short"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_040_ROT)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_040_ROT)
        .build();

    public static final BogeyStyle TRIPLE_AXLE_WALSCHAERTS_EXTENDED_SHORT
        = builder("triple_axle_walschaerts_extended_short").displayName(Component.translatable("create_bb.bogies.style.triple_axle_walschaerts_extended_short"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_060_ROT)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_060_ROT)
        .build();

    public static final BogeyStyle TRIPLE_AXLE_WALSCHAERTS_SHORT
        = builder("triple_axle_walschaerts_short").displayName(Component.translatable("create_bb.bogies.style.triple_axle_walschaerts_short"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_060_ROT)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_060_ROT)
        .build();

    public static final BogeyStyle QUADRUPLE_AXLE_WALSCHAERTS_SHORT
        = builder("quadruple_axle_walschaerts_short").displayName(Component.translatable("create_bb.bogies.style.quadruple_axle_walschaerts_short"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_080_ROT)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_080_ROT)
        .build();

    public static final BogeyStyle QUINTUPLE_AXLE_WALSCHAERTS_SHORT
        = builder("quintuple_axle_walschaerts_short").displayName(Component.translatable("create_bb.bogies.style.quintuple_axle_walschaerts_short"))
        .size(AllBogeySizes.LARGE, BogieBlocks.XL_0100_ROT)
        .size(AllBogeySizes.SMALL, BogieBlocks.L_0100_ROT)
        .build();

    public static final BogeyStyle SEXTUPLE_AXLE_WALSCHAERTS_SHORT
        = builder("sextuple_axle_walschaerts_short").displayName(Component.translatable("create_bb.bogies.style.sextuple_axle_walschaerts_short"))
        .size(AllBogeySizes.SMALL, BogieBlocks.L_0120_ROT)
        .build();

    private static BogeyStyle.Builder builder(String name) {
        return new BogeyStyle.Builder(BlocksBogies.asResource(name), AllBogeyStyles.STANDARD_CYCLE_GROUP);
    }

    public static final StyleEntryManager MANAGER = new StyleEntryManager();

    public static void registerBogeyStyles() {
        if (StyleEntryManager.getBogeyEntryList().isEmpty()) {
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(AllBogeyStyles.STANDARD, Variant.STANDARD, ValveGear.NONE, Type.TRUCK, 2, Length.NORMAL));

            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.SINGLE_AXLE_TRAILING, Variant.TRAILING, ValveGear.NONE, Type.TRUCK, 1, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.DOUBLE_AXLE_TRAILING, Variant.TRAILING, ValveGear.NONE, Type.TRUCK, 2, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.TRIPLE_AXLE_TRAILING, Variant.TRAILING, ValveGear.NONE, Type.TRUCK, 3, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.QUADRUPLE_AXLE_TRAILING, Variant.TRAILING, ValveGear.NONE, Type.TRUCK, 4, Length.NORMAL));

            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.SINGLE_AXLE_OFFSET, Variant.STANDARD, ValveGear.NONE, Type.TRUCK, 1, Length.OFFSET));

            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.SINGLE_AXLE_BOGIE, Variant.STANDARD, ValveGear.NONE, Type.TRUCK, 1, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.TRIPLE_AXLE_BOGIE, Variant.STANDARD, ValveGear.NONE, Type.TRUCK, 3, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.QUADRUPLE_AXLE_BOGIE, Variant.STANDARD, ValveGear.NONE, Type.TRUCK, 4, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.QUINTUPLE_AXLE_BOGIE, Variant.STANDARD, ValveGear.NONE, Type.TRUCK, 5, Length.NORMAL));

            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.SINGLE_AXLE_PISTONLESS, Variant.STANDARD, ValveGear.PISTONLESS, Type.DRIVER, 1, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.DOUBLE_AXLE_PISTONLESS, Variant.STANDARD, ValveGear.PISTONLESS, Type.DRIVER, 2, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.TRIPLE_AXLE_EXTENDED_PISTONLESS, Variant.STANDARD, ValveGear.PISTONLESS, Type.DRIVER, 3, Length.SPACED));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.TRIPLE_AXLE_PISTONLESS, Variant.STANDARD, ValveGear.PISTONLESS, Type.DRIVER, 3, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.QUADRUPLE_AXLE_PISTONLESS, Variant.STANDARD, ValveGear.PISTONLESS, Type.DRIVER, 4, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.QUINTUPLE_AXLE_PISTONLESS, Variant.STANDARD, ValveGear.PISTONLESS, Type.DRIVER, 5, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.SEXTUPLE_AXLE_PISTONLESS, Variant.STANDARD, ValveGear.PISTONLESS, Type.DRIVER, 6, Length.NORMAL));

            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.SINGLE_AXLE_PISTONLESS, Variant.STANDARD, ValveGear.RODLESS, Type.DRIVER, 1, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.DOUBLE_AXLE_RODLESS, Variant.STANDARD, ValveGear.RODLESS, Type.DRIVER, 2, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.TRIPLE_AXLE_EXTENDED_RODLESS, Variant.STANDARD, ValveGear.RODLESS, Type.DRIVER, 3, Length.SPACED));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.TRIPLE_AXLE_RODLESS, Variant.STANDARD, ValveGear.RODLESS, Type.DRIVER, 3, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.QUADRUPLE_AXLE_RODLESS, Variant.STANDARD, ValveGear.RODLESS, Type.DRIVER, 4, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.QUINTUPLE_AXLE_RODLESS, Variant.STANDARD, ValveGear.RODLESS, Type.DRIVER, 5, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.SEXTUPLE_AXLE_RODLESS, Variant.STANDARD, ValveGear.RODLESS, Type.DRIVER, 6, Length.NORMAL));

            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.SINGLE_AXLE_SCOTCH_YOKE, Variant.STANDARD, ValveGear.SCOTCH_YOKE, Type.DRIVER, 1, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.DOUBLE_AXLE_SCOTCH_YOKE, Variant.STANDARD, ValveGear.SCOTCH_YOKE, Type.DRIVER, 2, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.TRIPLE_AXLE_SCOTCH_YOKE, Variant.STANDARD, ValveGear.SCOTCH_YOKE, Type.DRIVER, 3, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.QUADRUPLE_AXLE_SCOTCH_YOKE, Variant.STANDARD, ValveGear.SCOTCH_YOKE, Type.DRIVER, 4, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.QUINTUPLE_AXLE_SCOTCH_YOKE, Variant.STANDARD, ValveGear.SCOTCH_YOKE, Type.DRIVER, 5, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.SEXTUPLE_AXLE_SCOTCH_YOKE, Variant.STANDARD, ValveGear.SCOTCH_YOKE, Type.DRIVER, 6, Length.NORMAL));

            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.SINGLE_AXLE_LONG, Variant.LONG, ValveGear.GEARLESS, Type.DRIVER, 1, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.DOUBLE_AXLE_LONG, Variant.LONG, ValveGear.GEARLESS, Type.DRIVER, 2, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.DOUBLE_AXLE_EXTRA_LONG, Variant.LONG, ValveGear.GEARLESS, Type.DRIVER, 2, Length.EXTENDED));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.TRIPLE_AXLE_EXTENDED_LONG, Variant.LONG, ValveGear.GEARLESS, Type.DRIVER, 3, Length.SPACED));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.TRIPLE_AXLE_LONG, Variant.LONG, ValveGear.GEARLESS, Type.DRIVER, 3, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.QUADRUPLE_AXLE_LONG, Variant.LONG, ValveGear.GEARLESS, Type.DRIVER, 4, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.QUINTUPLE_AXLE_LONG, Variant.LONG, ValveGear.GEARLESS, Type.DRIVER, 5, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.SEXTUPLE_AXLE_LONG, Variant.LONG, ValveGear.GEARLESS, Type.DRIVER, 6, Length.NORMAL));

            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.DOUBLE_AXLE_SHORT, Variant.SHORT, ValveGear.GEARLESS, Type.DRIVER, 2, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.TRIPLE_AXLE_EXTENDED_SHORT, Variant.SHORT, ValveGear.GEARLESS, Type.DRIVER, 3, Length.SPACED));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.TRIPLE_AXLE_SHORT, Variant.SHORT, ValveGear.GEARLESS, Type.DRIVER, 3,Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.QUADRUPLE_AXLE_SHORT, Variant.SHORT, ValveGear.GEARLESS, Type.DRIVER, 4, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.QUINTUPLE_AXLE_SHORT, Variant.SHORT, ValveGear.GEARLESS, Type.DRIVER, 5, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.SEXTUPLE_AXLE_SHORT, Variant.SHORT, ValveGear.GEARLESS, Type.DRIVER, 6, Length.NORMAL));

            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.SINGLE_AXLE_WALSCHAERTS_LONG, Variant.LONG, ValveGear.WALSCHAERTS, Type.DRIVER, 1, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.DOUBLE_AXLE_WALSCHAERTS_LONG, Variant.LONG, ValveGear.WALSCHAERTS, Type.DRIVER, 2, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.DOUBLE_AXLE_WALSCHAERTS_EXTRA_LONG, Variant.LONG, ValveGear.WALSCHAERTS, Type.DRIVER, 2, Length.EXTENDED));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.TRIPLE_AXLE_WALSCHAERTS_EXTENDED_LONG, Variant.LONG, ValveGear.WALSCHAERTS, Type.DRIVER, 3, Length.SPACED));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.TRIPLE_AXLE_WALSCHAERTS_LONG, Variant.LONG, ValveGear.WALSCHAERTS, Type.DRIVER, 3, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.QUADRUPLE_AXLE_WALSCHAERTS_LONG, Variant.LONG, ValveGear.WALSCHAERTS, Type.DRIVER, 4, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.QUINTUPLE_AXLE_WALSCHAERTS_LONG, Variant.LONG, ValveGear.WALSCHAERTS, Type.DRIVER, 5, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.SEXTUPLE_AXLE_WALSCHAERTS_LONG, Variant.LONG, ValveGear.WALSCHAERTS, Type.DRIVER, 6, Length.NORMAL));

            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.DOUBLE_AXLE_WALSCHAERTS_SHORT, Variant.SHORT, ValveGear.WALSCHAERTS, Type.DRIVER, 2, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.TRIPLE_AXLE_WALSCHAERTS_EXTENDED_SHORT, Variant.SHORT, ValveGear.WALSCHAERTS, Type.DRIVER, 3, Length.SPACED));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.TRIPLE_AXLE_WALSCHAERTS_SHORT, Variant.SHORT, ValveGear.WALSCHAERTS, Type.DRIVER, 3, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.QUADRUPLE_AXLE_WALSCHAERTS_SHORT, Variant.SHORT, ValveGear.WALSCHAERTS, Type.DRIVER, 4, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.QUINTUPLE_AXLE_WALSCHAERTS_SHORT, Variant.SHORT, ValveGear.WALSCHAERTS, Type.DRIVER, 5, Length.NORMAL));
            MANAGER.addToBogeyEntryList(StyleEntry.getOrCreate(BogieStyles.SEXTUPLE_AXLE_WALSCHAERTS_SHORT, Variant.SHORT, ValveGear.WALSCHAERTS, Type.DRIVER, 6, Length.NORMAL));
        }
    }

    public static void register() {
        BlocksBogies.LOGGER.info("Registered styles/menu selections for " + BlocksBogies.MOD_NAME);
        registerBogeyStyles();
    }
}