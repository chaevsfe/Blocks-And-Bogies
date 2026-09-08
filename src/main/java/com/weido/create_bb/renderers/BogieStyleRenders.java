package com.weido.create_bb.renderers;

import com.weido.create_bb.BlocksBogies;
import com.weido.create_bb.renderers.gearless.GearlessStyleRenders;
import com.weido.create_bb.renderers.pistonless.PistonlessStyleRenders;
import com.weido.create_bb.renderers.rodless.RodlessStyleRenders;
import com.weido.create_bb.renderers.scotchyoke.ScotchYokeStyleRenders;
import com.weido.create_bb.renderers.standard.StandardStyleRenders;
import com.weido.create_bb.renderers.trailing.TrailingStyleRenders;
import com.weido.create_bb.renderers.walschaerts.WalschaertsStyleRenders;
import com.weido.create_bb.renderers.unified.BogeyDisplay;
import com.zurrtum.create.AllBogeyStyles;
import com.zurrtum.create.client.AllBogeyStyleRenders;
import com.zurrtum.create.client.content.trains.bogey.SizeRenderer;
import com.zurrtum.create.content.trains.bogey.BogeySize;
import com.zurrtum.create.content.trains.bogey.BogeyStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public final class BogieStyleRenders {
    private BogieStyleRenders() {}

    public static void register() {
        StandardStyleRenders.register();
        TrailingStyleRenders.register();
        PistonlessStyleRenders.register();
        RodlessStyleRenders.register();
        ScotchYokeStyleRenders.register();
        GearlessStyleRenders.register();
        WalschaertsStyleRenders.register();
        reportCoverage();
    }

    public static Supplier<SizeRenderer> simple(BogeyDisplay.SimpleFactory factory) {
        return () -> BogeyDisplay.createSizeRenderer(factory);
    }

    private static void reportCoverage() {
        List<String> missing = new ArrayList<>();
        int total = 0;
        for (BogeyStyle style : AllBogeyStyles.BOGEY_STYLES.values()) {
            if (!style.id.getNamespace().equals(BlocksBogies.MOD_ID))
                continue;
            Map<BogeySize, SizeRenderer> sizes = AllBogeyStyleRenders.ALL.get(style.id);
            for (BogeySize size : style.validSizes()) {
                total++;
                if (sizes == null || !sizes.containsKey(size))
                    missing.add(style.id.getPath() + "@" + size.id().getPath());
            }
        }
        if (missing.isEmpty())
            BlocksBogies.LOGGER.info("Bogey style renders registered for all {} style sizes", total);
        else
            BlocksBogies.LOGGER.warn("{} of {} bogey style sizes have no render registered; assembled trains using them will crash Flywheel clients: {}", missing.size(), total, missing);
    }
}
