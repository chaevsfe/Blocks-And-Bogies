package com.weido.create_bb.blocks.bogies;

import com.zurrtum.create.content.trains.bogey.AllBogeySizes;

import com.weido.create_bb.blocks.sizes.LargeBogieBlock;
import com.weido.create_bb.registry.BogieStyles;

import net.minecraft.world.phys.Vec3;

public class LargeDoubleAxle extends LargeBogieBlock {
    public LargeDoubleAxle(Properties props) {
        super(props, () -> BogieStyles.DOUBLE_AXLE_PISTONLESS, AllBogeySizes.SMALL);
    }

    @Override
    public Vec3 getConnectorAnchorOffset() {
        return new Vec3(0, 7/32f, 60/32f);
    }
}
