package com.weido.create_bb.renderers.trailing;

import com.weido.create_bb.registry.BogiePartials;
import com.weido.create_bb.renderers.unified.BogeyDisplay;
import com.weido.create_bb.renderers.unified.ElementProvider;
import com.zurrtum.create.client.AllPartialModels;
import com.zurrtum.create.client.flywheel.lib.transform.Affine;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;

public abstract class SingleAxleTrailingDisplay implements BogeyDisplay {
    public static class SingleAxleSmallTrailing extends SingleAxleTrailingDisplay {
        private final Affine<?> frame;
        private final Affine<?>[] shafts;
        private final Affine<?> wheel;

        public SingleAxleSmallTrailing(ElementProvider<?> prov) {
            frame = prov.create(BogiePartials.SMALL_TRAILING_2_FRAME);
            shafts = prov.create(AllPartialModels.SHAFT, 3);
            wheel = prov.create(BogiePartials.SMALL_SHARED_WHEELS);
        }

        @Override
        public void update(CompoundTag bogeyData, float wheelAngle) {
            frame.scale(1 - 1 / 512f);

            shafts[0].translate(-.5f, .25f, 0)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[1].translate(-.5f, .25f, -1)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[2].translate(-.5f, .25f, -.5f)
                    .center()
                    .rotateTo(Direction.UP, Direction.EAST)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            wheel.translate(0, .75f, 0)
                    .rotateXDegrees(wheelAngle);
        }
    }
}
