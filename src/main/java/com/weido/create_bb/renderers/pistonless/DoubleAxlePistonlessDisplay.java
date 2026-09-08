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

public abstract class DoubleAxlePistonlessDisplay implements BogeyDisplay {
    public static class DoubleAxleLargePistonless extends DoubleAxlePistonlessDisplay {
        private final Affine<?> frame;
        private final Affine<?> belt;
        private final ScrollHandle beltScroll;
        private final Affine<?> r_c_rod;
        private final Affine<?> l_c_rod;
        private final Affine<?>[] wheels;
        private final Affine<?>[] shafts;

        public DoubleAxleLargePistonless(ElementProvider<?> prov) {
            frame = prov.create(BogiePartials.LARGE_4P_FRAME);
            var scrolling = prov.createScrolling(BogiePartials.LARGE_4P_BELTS, AllSpriteShifts.BOGEY_BELT);
            belt = scrolling.getFirst();
            beltScroll = scrolling.getSecond();
            r_c_rod = prov.create(BogiePartials.LARGE_4P_R_C_ROD);
            l_c_rod = prov.create(BogiePartials.LARGE_4P_L_C_ROD);
            wheels = prov.create(BogiePartials.LARGE_SHARED_WHEELS, 2);
            shafts = prov.create(AllPartialModels.SHAFT, 4);
        }

        @Override
        public void update(CompoundTag bogeyData, float wheelAngle) {
            frame.scale(1 - 1 / 512f);

            r_c_rod.translate(0, 1, 0)
                    .rotateXDegrees(wheelAngle)
                    .translate(0, .25f, 0)
                    .rotateXDegrees(-wheelAngle);

            l_c_rod.translate(0, 1, 0)
                    .rotateXDegrees(wheelAngle + 90)
                    .translate(0, .25f, 0)
                    .rotateXDegrees(-(wheelAngle + 90));

            beltScroll.scroll(BELT_RADIUS_IN_UV_SPACE * Mth.DEG_TO_RAD * wheelAngle);
            belt.scale(1 - 1 / 512f);

            wheels[0].translate(0, 1, -0.875f)
                    .rotateXDegrees(wheelAngle);

            wheels[1].translate(0, 1, 0.875f)
                    .rotateXDegrees(wheelAngle);

            shafts[0].translate(-.5f, .25f, 1)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[1].translate(-.5f, .25f, -2)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[2].translate(-.5f, .25f, 1.375f)
                    .center()
                    .rotateTo(Direction.UP, Direction.EAST)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[3].translate(-.5f, .25f, -2.375f)
                    .center()
                    .rotateTo(Direction.UP, Direction.EAST)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();
        }
    }

    public static class DoubleAxleExtraLargePistonless extends DoubleAxlePistonlessDisplay {
        private final Affine<?> frame;
        private final Affine<?> belt;
        private final ScrollHandle beltScroll;
        private final Affine<?> r_c_rod;
        private final Affine<?> l_c_rod;
        private final Affine<?>[] wheels;
        private final Affine<?>[] shafts;

        public DoubleAxleExtraLargePistonless(ElementProvider<?> prov) {
            frame = prov.create(BogiePartials.EXTRA_LARGE_4P_FRAME);
            var scrolling = prov.createScrolling(BogiePartials.EXTRA_LARGE_4P_BELTS, AllSpriteShifts.BOGEY_BELT);
            belt = scrolling.getFirst();
            beltScroll = scrolling.getSecond();
            r_c_rod = prov.create(BogiePartials.EXTRA_LARGE_4P_R_C_ROD);
            l_c_rod = prov.create(BogiePartials.EXTRA_LARGE_4P_L_C_ROD);
            wheels = prov.create(BogiePartials.EXTRA_LARGE_SHARED_WHEELS, 2);
            shafts = prov.create(AllPartialModels.SHAFT, 6);
        }

        @Override
        public void update(CompoundTag bogeyData, float wheelAngle) {
            frame.scale(1 - 1 / 512f);

            r_c_rod.translate(0, 1.25f, 0)
                    .rotateXDegrees(wheelAngle)
                    .translate(0, .375f, 0)
                    .rotateXDegrees(-wheelAngle);

            l_c_rod.translate(0, 1.25f, 0)
                    .rotateXDegrees(wheelAngle + 90)
                    .translate(0, .375f, 0)
                    .rotateXDegrees(-(wheelAngle + 90));

            beltScroll.scroll(BELT_RADIUS_IN_UV_SPACE * Mth.DEG_TO_RAD * wheelAngle);
            belt.scale(1 - 1 / 512f);

            wheels[0].translate(0, 1.25f, -1.125f)
                    .rotateXDegrees(wheelAngle);

            wheels[1].translate(0, 1.25f, 1.125f)
                    .rotateXDegrees(wheelAngle);

            shafts[0].translate(-.5f, .25f, .0625f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[1].translate(-.5f, .25f, -1.0625f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[2].translate(-.5f, .25f, 1.25f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[3].translate(-.5f, .25f, -2.25f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[4].translate(-.5f, .25f, 1.625f)
                    .center()
                    .rotateTo(Direction.UP, Direction.EAST)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[5].translate(-.5f, .25f, -2.625f)
                    .center()
                    .rotateTo(Direction.UP, Direction.EAST)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();
        }
    }
}
