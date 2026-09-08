package com.weido.create_bb.renderers.walschaerts;

import com.weido.create_bb.registry.BogieStyles;
import com.zurrtum.create.client.AllBogeyStyleRenders;

import static com.weido.create_bb.renderers.BogieStyleRenders.simple;

public final class WalschaertsStyleRenders {
    private WalschaertsStyleRenders() {}

    public static void register() {
        AllBogeyStyleRenders.register(BogieStyles.SINGLE_AXLE_WALSCHAERTS_LONG,
            simple(SingleAxleWalschaertsLongDisplay.SingleAxleExtraLargeWalschaertsLong::new),
            simple(SingleAxleWalschaertsLongDisplay.SingleAxleLargeWalschaertsLong::new));
        AllBogeyStyleRenders.register(BogieStyles.DOUBLE_AXLE_WALSCHAERTS_LONG,
            simple(DoubleAxleWalschaertsLongDisplay.DoubleAxleExtraLargeWalschaertsLong::new),
            simple(DoubleAxleWalschaertsLongDisplay.DoubleAxleLargeWalschaertsLong::new));
        AllBogeyStyleRenders.register(BogieStyles.DOUBLE_AXLE_WALSCHAERTS_EXTRA_LONG,
            simple(DoubleAxleWalschaertsExtraLongDisplay.DoubleAxleExtraLargeWalschaertsExtraLong::new),
            simple(DoubleAxleWalschaertsExtraLongDisplay.DoubleAxleLargeWalschaertsExtraLong::new));
        AllBogeyStyleRenders.register(BogieStyles.TRIPLE_AXLE_WALSCHAERTS_EXTENDED_LONG,
            simple(TripleAxleExtendedWalschaertsLongDisplay.TripleAxleExtraLargeExtendedWalschaertsLong::new),
            simple(TripleAxleExtendedWalschaertsLongDisplay.TripleAxleLargeExtendedWalschaertsLong::new));
        AllBogeyStyleRenders.register(BogieStyles.TRIPLE_AXLE_WALSCHAERTS_LONG,
            simple(TripleAxleWalschaertsLongDisplay.TripleAxleExtraLargeWalschaertsLong::new),
            simple(TripleAxleWalschaertsLongDisplay.TripleAxleLargeWalschaertsLong::new));
        AllBogeyStyleRenders.register(BogieStyles.QUADRUPLE_AXLE_WALSCHAERTS_LONG,
            simple(QuadrupleAxleWalschaertsLongDisplay.QuadrupleAxleExtraLargeWalschaertsLong::new),
            simple(QuadrupleAxleWalschaertsLongDisplay.QuadrupleAxleLargeWalschaertsLong::new));
        AllBogeyStyleRenders.register(BogieStyles.QUINTUPLE_AXLE_WALSCHAERTS_LONG,
            simple(QuintupleAxleWalschaertsLongDisplay.QuintupleAxleExtraLargeWalschaertsLong::new),
            simple(QuintupleAxleWalschaertsLongDisplay.QuintupleAxleLargeWalschaertsLong::new));
        AllBogeyStyleRenders.register(BogieStyles.SEXTUPLE_AXLE_WALSCHAERTS_LONG,
            simple(SextupleAxleWalschaertsLongDisplay.SextupleAxleLargeWalschaertsLong::new));
        AllBogeyStyleRenders.register(BogieStyles.DOUBLE_AXLE_WALSCHAERTS_SHORT,
            simple(DoubleAxleWalschaertsShortDisplay.DoubleAxleExtraLargeWalschaertsShort::new),
            simple(DoubleAxleWalschaertsShortDisplay.DoubleAxleLargeWalschaertsShort::new));
        AllBogeyStyleRenders.register(BogieStyles.TRIPLE_AXLE_WALSCHAERTS_EXTENDED_SHORT,
            simple(TripleAxleExtendedWalschaertsShortDisplay.TripleAxleExtraLargeExtendedWalschaertsShort::new),
            simple(TripleAxleExtendedWalschaertsShortDisplay.TripleAxleLargeExtendedWalschaertsShort::new));
        AllBogeyStyleRenders.register(BogieStyles.TRIPLE_AXLE_WALSCHAERTS_SHORT,
            simple(TripleAxleWalschaertsShortDisplay.TripleAxleExtraLargeWalschaertsShort::new),
            simple(TripleAxleWalschaertsShortDisplay.TripleAxleLargeWalschaertsShort::new));
        AllBogeyStyleRenders.register(BogieStyles.QUADRUPLE_AXLE_WALSCHAERTS_SHORT,
            simple(QuadrupleAxleWalschaertsShortDisplay.QuadrupleAxleExtraLargeWalschaertsShort::new),
            simple(QuadrupleAxleWalschaertsShortDisplay.QuadrupleAxleLargeWalschaertsShort::new));
        AllBogeyStyleRenders.register(BogieStyles.QUINTUPLE_AXLE_WALSCHAERTS_SHORT,
            simple(QuintupleAxleWalschaertsShortDisplay.QuintupleAxleExtraLargeWalschaertsShort::new),
            simple(QuintupleAxleWalschaertsShortDisplay.QuintupleAxleLargeWalschaertsShort::new));
        AllBogeyStyleRenders.register(BogieStyles.SEXTUPLE_AXLE_WALSCHAERTS_SHORT,
            simple(SextupleAxleWalschaertsShortDisplay.SextupleAxleLargeWalschaertsShort::new));
    }
}
