package com.weido.create_bb.renderers.gearless;

import com.weido.create_bb.registry.BogieStyles;
import com.zurrtum.create.client.AllBogeyStyleRenders;

import static com.weido.create_bb.renderers.BogieStyleRenders.simple;

public final class GearlessStyleRenders {
    private GearlessStyleRenders() {}

    public static void register() {
        AllBogeyStyleRenders.register(BogieStyles.SINGLE_AXLE_LONG,
            simple(SingleAxleLongDisplay.SingleAxleExtraLargeLong::new),
            simple(SingleAxleLongDisplay.SingleAxleLargeLong::new));
        AllBogeyStyleRenders.register(BogieStyles.DOUBLE_AXLE_LONG,
            simple(DoubleAxleLongDisplay.DoubleAxleExtraLargeLong::new),
            simple(DoubleAxleLongDisplay.DoubleAxleLargeLong::new));
        AllBogeyStyleRenders.register(BogieStyles.DOUBLE_AXLE_EXTRA_LONG,
            simple(DoubleAxleExtraLongDisplay.DoubleAxleExtraLargeExtraLong::new),
            simple(DoubleAxleExtraLongDisplay.DoubleAxleLargeExtraLong::new));
        AllBogeyStyleRenders.register(BogieStyles.TRIPLE_AXLE_EXTENDED_LONG,
            simple(TripleAxleExtendedLongDisplay.TripleAxleExtraLargeExtendedLong::new),
            simple(TripleAxleExtendedLongDisplay.TripleAxleLargeExtendedLong::new));
        AllBogeyStyleRenders.register(BogieStyles.TRIPLE_AXLE_LONG,
            simple(TripleAxleLongDisplay.TripleAxleExtraLargeLong::new),
            simple(TripleAxleLongDisplay.TripleAxleLargeLong::new));
        AllBogeyStyleRenders.register(BogieStyles.QUADRUPLE_AXLE_LONG,
            simple(QuadrupleAxleLongDisplay.QuadrupleAxleExtraLargeLong::new),
            simple(QuadrupleAxleLongDisplay.QuadrupleAxleLargeLong::new));
        AllBogeyStyleRenders.register(BogieStyles.QUINTUPLE_AXLE_LONG,
            simple(QuintupleAxleLongDisplay.QuintupleAxleExtraLargeLong::new),
            simple(QuintupleAxleLongDisplay.QuintupleAxleLargeLong::new));
        AllBogeyStyleRenders.register(BogieStyles.SEXTUPLE_AXLE_LONG,
            simple(SextupleAxleLongDisplay.SextupleAxleLargeLong::new));
        AllBogeyStyleRenders.register(BogieStyles.DOUBLE_AXLE_SHORT,
            simple(DoubleAxleShortDisplay.DoubleAxleExtraLargeShort::new),
            simple(DoubleAxleShortDisplay.DoubleAxleLargeShort::new));
        AllBogeyStyleRenders.register(BogieStyles.TRIPLE_AXLE_EXTENDED_SHORT,
            simple(TripleAxleExtendedShortDisplay.TripleAxleExtraLargeExtendedShort::new),
            simple(TripleAxleExtendedShortDisplay.TripleAxleLargeExtendedShort::new));
        AllBogeyStyleRenders.register(BogieStyles.TRIPLE_AXLE_SHORT,
            simple(TripleAxleShortDisplay.TripleAxleExtraLargeShort::new),
            simple(TripleAxleShortDisplay.TripleAxleLargeShort::new));
        AllBogeyStyleRenders.register(BogieStyles.QUADRUPLE_AXLE_SHORT,
            simple(QuadrupleAxleShortDisplay.QuadrupleAxleExtraLargeShort::new),
            simple(QuadrupleAxleShortDisplay.QuadrupleAxleLargeShort::new));
        AllBogeyStyleRenders.register(BogieStyles.QUINTUPLE_AXLE_SHORT,
            simple(QuintupleAxleShortDisplay.QuintupleAxleExtraLargeShort::new),
            simple(QuintupleAxleShortDisplay.QuintupleAxleLargeShort::new));
        AllBogeyStyleRenders.register(BogieStyles.SEXTUPLE_AXLE_SHORT,
            simple(SextupleAxleShortDisplay.SextupleAxleLargeShort::new));
    }
}
