package com.weido.create_bb.renderers.standard;

import com.weido.create_bb.registry.BogieStyles;
import com.zurrtum.create.client.AllBogeyStyleRenders;

import static com.weido.create_bb.renderers.BogieStyleRenders.simple;

public final class StandardStyleRenders {
    private StandardStyleRenders() {}

    public static void register() {
        AllBogeyStyleRenders.register(BogieStyles.SINGLE_AXLE_OFFSET,
            simple(SingleAxleBogieDisplay.SingleAxleSmallOffset::new));
        AllBogeyStyleRenders.register(BogieStyles.SINGLE_AXLE_BOGIE,
            simple(SingleAxleBogieDisplay.SingleAxleSmallBogie::new));
        AllBogeyStyleRenders.register(BogieStyles.TRIPLE_AXLE_BOGIE,
            simple(TripleAxleBogieDisplay.TripleAxleSmallBogie::new));
        AllBogeyStyleRenders.register(BogieStyles.QUADRUPLE_AXLE_BOGIE,
            simple(QuadrupleAxleBogieDisplay.QuadrupleAxleSmallBogie::new));
        AllBogeyStyleRenders.register(BogieStyles.QUINTUPLE_AXLE_BOGIE,
            simple(QuintupleAxleBogieDisplay.SmallQuintupleAxleBogie::new));
    }
}
