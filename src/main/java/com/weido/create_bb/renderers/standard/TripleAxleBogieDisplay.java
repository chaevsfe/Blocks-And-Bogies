package com.weido.create_bb.renderers.standard;

import com.weido.create_bb.registry.BogiePartials;
import com.weido.create_bb.renderers.unified.BogeyDisplay;
import com.weido.create_bb.renderers.unified.ElementProvider;
import com.zurrtum.create.client.AllPartialModels;
import com.zurrtum.create.client.flywheel.lib.transform.Affine;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;

public abstract class TripleAxleBogieDisplay implements BogeyDisplay {
    public static class TripleAxleSmallBogie extends TripleAxleBogieDisplay {
        private final Affine<?> frame;
        private final Affine<?>[] shafts;
        private final Affine<?>[] wheels;

        public TripleAxleSmallBogie(ElementProvider<?> prov) {
            frame = prov.create(BogiePartials.SMALL_BOGIE_6_FRAME);
            shafts = prov.create(AllPartialModels.SHAFT, 2);
            wheels = prov.create(AllPartialModels.SMALL_BOGEY_WHEELS, 3);
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

            wheels[0].translate(0, .75f, -1)
                    .rotateXDegrees(wheelAngle);

            wheels[1].translate(0, .75f, 1)
                    .rotateXDegrees(wheelAngle);

            wheels[2].translate(0, .75f, 0)
                    .rotateXDegrees(wheelAngle);
        }
    }
}
