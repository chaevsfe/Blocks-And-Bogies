package com.weido.create_bb.renderers.pistonless;

import com.weido.create_bb.registry.BogiePartials;
import com.weido.create_bb.renderers.unified.BogeyDisplay;
import com.weido.create_bb.renderers.unified.ElementProvider;
import com.weido.create_bb.renderers.unified.ScrollHandle;
import com.zurrtum.create.client.AllPartialModels;
import com.zurrtum.create.client.AllSpriteShifts;
import com.zurrtum.create.client.flywheel.lib.transform.Affine;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;

import static com.weido.create_bb.data.Constants.BELT_RADIUS_IN_UV_SPACE;

public abstract class SingleAxlePistonlessDisplay implements BogeyDisplay {
    public static class SingleAxleLargePistonless extends SingleAxlePistonlessDisplay {
        private final Affine<?> frame;
        private final Affine<?> belt;
        private final ScrollHandle beltScroll;
        private final Affine<?> wheel;
        private final Affine<?>[] shafts;

        public SingleAxleLargePistonless(ElementProvider<?> prov) {
            frame = prov.create(BogiePartials.LARGE_2P_FRAME);
            var scrolling = prov.createScrolling(BogiePartials.LARGE_2P_BELTS, AllSpriteShifts.BOGEY_BELT);
            belt = scrolling.getFirst();
            beltScroll = scrolling.getSecond();
            wheel = prov.create(BogiePartials.LARGE_SHARED_WHEELS_SINGLE);
            shafts = prov.create(AllPartialModels.SHAFT, 4);
        }

        @Override
        public void update(CompoundTag bogeyData, float wheelAngle) {
            frame.scale(1 - 1 / 512f);

            beltScroll.scroll(BELT_RADIUS_IN_UV_SPACE * Mth.DEG_TO_RAD * wheelAngle);
            belt.scale(1 - 1 / 512f);

            wheel.translate(0, 1, 0)
                    .rotateXDegrees(wheelAngle);

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

            shafts[2].translate(-.5f, .25f, .5f)
                    .center()
                    .rotateTo(Direction.UP, Direction.EAST)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[3].translate(-.5f, .25f, -1.5f)
                    .center()
                    .rotateTo(Direction.UP, Direction.EAST)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();
        }
    }

    public static class SingleAxleExtraLargePistonless extends SingleAxlePistonlessDisplay {
        private final Affine<?> frame;
        private final Affine<?> belt;
        private final ScrollHandle beltScroll;
        private final Affine<?> wheel;
        private final Affine<?>[] shafts;

        public SingleAxleExtraLargePistonless(ElementProvider<?> prov) {
            frame = prov.create(BogiePartials.EXTRA_LARGE_2P_FRAME);
            var scrolling = prov.createScrolling(BogiePartials.EXTRA_LARGE_2P_BELTS, AllSpriteShifts.BOGEY_BELT);
            belt = scrolling.getFirst();
            beltScroll = scrolling.getSecond();
            wheel = prov.create(BogiePartials.EXTRA_LARGE_SHARED_WHEELS_SINGLE);
            shafts = prov.create(AllPartialModels.SHAFT, 4);
        }

        @Override
        public void update(CompoundTag bogeyData, float wheelAngle) {
            frame.scale(1 - 1 / 512f);

            beltScroll.scroll(BELT_RADIUS_IN_UV_SPACE * Mth.DEG_TO_RAD * wheelAngle);
            belt.scale(1 - 1 / 512f);

            wheel.translate(0, 1.25f, 0)
                    .rotateXDegrees(wheelAngle);

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

            shafts[2].translate(-.5f, .25f, .5f)
                    .center()
                    .rotateTo(Direction.UP, Direction.EAST)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[3].translate(-.5f, .25f, -1.5f)
                    .center()
                    .rotateTo(Direction.UP, Direction.EAST)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();
        }
    }
}
