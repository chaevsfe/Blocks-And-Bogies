package com.weido.create_bb.renderers.trailing;

import com.weido.create_bb.registry.BogieStyles;
import com.zurrtum.create.client.AllBogeyStyleRenders;

import static com.weido.create_bb.renderers.BogieStyleRenders.simple;

public final class TrailingStyleRenders {
    private TrailingStyleRenders() {}

    public static void register() {
        AllBogeyStyleRenders.register(BogieStyles.SINGLE_AXLE_TRAILING,
            simple(SingleAxleTrailingDisplay.SingleAxleSmallTrailing::new));
        AllBogeyStyleRenders.register(BogieStyles.DOUBLE_AXLE_TRAILING,
            simple(DoubleAxleTrailingDisplay.DoubleAxleSmallTrailing::new));
        AllBogeyStyleRenders.register(BogieStyles.TRIPLE_AXLE_TRAILING,
            simple(TripleAxleTrailingDisplay.TripleAxleSmallTrailing::new));
        AllBogeyStyleRenders.register(BogieStyles.QUADRUPLE_AXLE_TRAILING,
            simple(QuadrupleAxleTrailingDisplay.QuadrupleAxleSmallTrailing::new));
    }
}
