package com.weido.create_bb.renderers.rodless;

import com.weido.create_bb.registry.BogieStyles;
import com.zurrtum.create.client.AllBogeyStyleRenders;

import static com.weido.create_bb.renderers.BogieStyleRenders.simple;

public final class RodlessStyleRenders {
    private RodlessStyleRenders() {}

    public static void register() {
        AllBogeyStyleRenders.register(BogieStyles.DOUBLE_AXLE_RODLESS,
            simple(DoubleAxleRodlessDisplay.DoubleAxleExtraLargeRodless::new),
            simple(DoubleAxleRodlessDisplay.DoubleAxleLargeRodless::new));
        AllBogeyStyleRenders.register(BogieStyles.TRIPLE_AXLE_EXTENDED_RODLESS,
            simple(TripleAxleExtendedRodlessDisplay.TripleAxleExtraLargeExtendedRodless::new),
            simple(TripleAxleExtendedRodlessDisplay.TripleAxleLargeExtendedRodless::new));
        AllBogeyStyleRenders.register(BogieStyles.TRIPLE_AXLE_RODLESS,
            simple(TripleAxleRodlessDisplay.TripleAxleExtraLargeRodless::new),
            simple(TripleAxleRodlessDisplay.TripleAxleLargeRodless::new));
        AllBogeyStyleRenders.register(BogieStyles.QUADRUPLE_AXLE_RODLESS,
            simple(QuadrupleAxleRodlessDisplay.QuadrupleAxleExtraLargeRodless::new),
            simple(QuadrupleAxleRodlessDisplay.QuadrupleAxleLargeRodless::new));
        AllBogeyStyleRenders.register(BogieStyles.QUINTUPLE_AXLE_RODLESS,
            simple(QuintupleAxleRodlessDisplay.QuintupleAxleExtraLargeRodless::new),
            simple(QuintupleAxleRodlessDisplay.QuintupleAxleLargeRodless::new));
        AllBogeyStyleRenders.register(BogieStyles.SEXTUPLE_AXLE_RODLESS,
            simple(SextupleAxleRodlessDisplay.SextupleAxleLargeRodless::new));
    }
}
