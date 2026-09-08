package com.weido.create_bb.renderers.standard;

import com.weido.create_bb.data.rotation.BlocksBogiesBogieDisplay;
import com.weido.create_bb.registry.BogiePartials;
import com.weido.create_bb.renderers.unified.ElementProvider;
import com.zurrtum.create.client.AllPartialModels;
import com.zurrtum.create.client.flywheel.lib.transform.Affine;
import net.minecraft.core.Direction;

public abstract class SingleAxleBogieDisplay extends BlocksBogiesBogieDisplay {
    public static class SingleAxleSmallOffset extends SingleAxleBogieDisplay {
        private final Affine<?> frame;
        private final Affine<?> shaft;
        private final Affine<?> wheel;

        public SingleAxleSmallOffset(ElementProvider<?> prov) {
            frame = prov.create(BogiePartials.SMALL_OFFSET_2_FRAME);
            shaft = prov.create(AllPartialModels.SHAFT);
            wheel = prov.create(AllPartialModels.SMALL_BOGEY_WHEELS);
        }

        @Override
        public void update(boolean forwards, float wheelAngle) {
            frame.scale(1 - 1 / 512f)
                    .rotateYDegrees(forwards ? 0 : 180);

            shaft.translate(-.5f, .25f, forwards ? -1 : 0)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            wheel.translate(0, .75f, forwards ? -1 : 1)
                    .rotateXDegrees(wheelAngle);
        }
    }

    public static class SingleAxleSmallBogie extends SingleAxleBogieDisplay {
        private final Affine<?> frame;
        private final Affine<?>[] shafts;
        private final Affine<?> wheel;

        public SingleAxleSmallBogie(ElementProvider<?> prov) {
            frame = prov.create(BogiePartials.SMALL_BOGIE_2_FRAME);
            shafts = prov.create(AllPartialModels.SHAFT, 2);
            wheel = prov.create(AllPartialModels.SMALL_BOGEY_WHEELS);
        }

        @Override
        public void update(boolean forwards, float wheelAngle) {
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

            wheel.translate(0, .75f, 0)
                    .rotateXDegrees(wheelAngle);
        }
    }
}
