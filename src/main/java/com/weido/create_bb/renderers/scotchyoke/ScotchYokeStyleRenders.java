package com.weido.create_bb.renderers.scotchyoke;

import com.weido.create_bb.registry.BogieStyles;
import com.zurrtum.create.client.AllBogeyStyleRenders;
import com.zurrtum.create.client.content.trains.bogey.SizeRenderer;

import static com.weido.create_bb.renderers.BogieStyleRenders.simple;

public final class ScotchYokeStyleRenders {
    private ScotchYokeStyleRenders() {}

    public static void register() {
        AllBogeyStyleRenders.register(BogieStyles.SINGLE_AXLE_SCOTCH_YOKE,
            simple(SingleAxleScotchYokeDisplay.SingleAxleExtraLargeScotchYoke::new),
            SizeRenderer::large);
        AllBogeyStyleRenders.register(BogieStyles.DOUBLE_AXLE_SCOTCH_YOKE,
            simple(DoubleAxleScotchYokeDisplay.DoubleAxleExtraLargeScotchYoke::new),
            simple(DoubleAxleScotchYokeDisplay.DoubleAxleLargeScotchYoke::new));
        AllBogeyStyleRenders.register(BogieStyles.TRIPLE_AXLE_SCOTCH_YOKE,
            simple(TripleAxleScotchYokeDisplay.TripleAxleExtraLargeScotchYoke::new),
            simple(TripleAxleScotchYokeDisplay.TripleAxleLargeScotchYoke::new));
        AllBogeyStyleRenders.register(BogieStyles.QUADRUPLE_AXLE_SCOTCH_YOKE,
            simple(QuadrupleAxleScotchYokeDisplay.QuadrupleAxleExtraLargeScotchYoke::new),
            simple(QuadrupleAxleScotchYokeDisplay.QuadrupleAxleLargeScotchYoke::new));
        AllBogeyStyleRenders.register(BogieStyles.QUINTUPLE_AXLE_SCOTCH_YOKE,
            simple(QuintupleAxleScotchYokeDisplay.QuintupleAxleExtraLargeScotchYoke::new),
            simple(QuintupleAxleScotchYokeDisplay.QuintupleAxleLargeScotchYoke::new));
        AllBogeyStyleRenders.register(BogieStyles.SEXTUPLE_AXLE_SCOTCH_YOKE,
            simple(SextupleAxleScotchYokeDisplay.SextupleAxleLargeScotchYoke::new));
    }
}
