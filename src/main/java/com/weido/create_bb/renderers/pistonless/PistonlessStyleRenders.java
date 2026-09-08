package com.weido.create_bb.renderers.pistonless;

import com.weido.create_bb.registry.BogieStyles;
import com.zurrtum.create.client.AllBogeyStyleRenders;

import static com.weido.create_bb.renderers.BogieStyleRenders.simple;

public final class PistonlessStyleRenders {
    private PistonlessStyleRenders() {}

    public static void register() {
        AllBogeyStyleRenders.register(BogieStyles.SINGLE_AXLE_PISTONLESS,
            simple(SingleAxlePistonlessDisplay.SingleAxleExtraLargePistonless::new),
            simple(SingleAxlePistonlessDisplay.SingleAxleLargePistonless::new));
        AllBogeyStyleRenders.register(BogieStyles.DOUBLE_AXLE_PISTONLESS,
            simple(DoubleAxlePistonlessDisplay.DoubleAxleExtraLargePistonless::new),
            simple(DoubleAxlePistonlessDisplay.DoubleAxleLargePistonless::new));
        AllBogeyStyleRenders.register(BogieStyles.TRIPLE_AXLE_EXTENDED_PISTONLESS,
            simple(TripleAxleExtendedPistonlessDisplay.TripleAxleExtraLargeExtendedPistonless::new),
            simple(TripleAxleExtendedPistonlessDisplay.TripleAxleLargeExtendedPistonless::new));
        AllBogeyStyleRenders.register(BogieStyles.TRIPLE_AXLE_PISTONLESS,
            simple(TripleAxlePistonlessDisplay.TripleAxleExtraLargePistonless::new),
            simple(TripleAxlePistonlessDisplay.TripleAxleLargePistonless::new));
        AllBogeyStyleRenders.register(BogieStyles.QUADRUPLE_AXLE_PISTONLESS,
            simple(QuadrupleAxlePistonlessDisplay.QuadrupleAxleExtraLargePistonless::new),
            simple(QuadrupleAxlePistonlessDisplay.QuadrupleAxleLargePistonless::new));
        AllBogeyStyleRenders.register(BogieStyles.QUINTUPLE_AXLE_PISTONLESS,
            simple(QuintupleAxlePistonlessDisplay.QuintupleAxleExtraLargePistonless::new),
            simple(QuintupleAxlePistonlessDisplay.QuintupleAxleLargePistonless::new));
        AllBogeyStyleRenders.register(BogieStyles.SEXTUPLE_AXLE_PISTONLESS,
            simple(SextupleAxlePistonlessDisplay.SextupleAxleLargePistonless::new));
    }
}
