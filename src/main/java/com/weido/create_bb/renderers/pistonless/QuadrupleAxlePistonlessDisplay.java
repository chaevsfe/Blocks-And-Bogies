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

public abstract class QuadrupleAxlePistonlessDisplay implements BogeyDisplay {
    public static class QuadrupleAxleLargePistonless extends QuadrupleAxlePistonlessDisplay {
        private final Affine<?> frame;
        private final Affine<?> belt;
        private final ScrollHandle beltScroll;
        private final Affine<?> r_c_rod;
        private final Affine<?> l_c_rod;
        private final Affine<?>[] wheels;
        private final Affine<?>[] wheelsSemiBlind;
        private final Affine<?>[] shafts;

        public QuadrupleAxleLargePistonless(ElementProvider<?> prov) {
            frame = prov.create(BogiePartials.LARGE_8P_FRAME);
            var scrolling = prov.createScrolling(BogiePartials.LARGE_8P_BELTS, AllSpriteShifts.BOGEY_BELT);
            belt = scrolling.getFirst();
            beltScroll = scrolling.getSecond();
            r_c_rod = prov.create(BogiePartials.LARGE_8P_R_C_ROD);
            l_c_rod = prov.create(BogiePartials.LARGE_8P_L_C_ROD);
            wheels = prov.create(BogiePartials.LARGE_SHARED_WHEELS, 2);
            wheelsSemiBlind = prov.create(BogiePartials.LARGE_SHARED_WHEELS_SEMI_BLIND, 2);
            shafts = prov.create(AllPartialModels.SHAFT, 6);
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

            wheels[0].translate(0, 1, -2.625f)
                    .rotateXDegrees(wheelAngle);

            wheels[1].translate(0, 1, 2.625f)
                    .rotateXDegrees(wheelAngle);

            wheelsSemiBlind[0].translate(0, 1, -.875f)
                    .rotateXDegrees(wheelAngle);

            wheelsSemiBlind[1].translate(0, 1, .875f)
                    .rotateXDegrees(wheelAngle);

            shafts[0].translate(-.5f, .25f, -4.125f)
                    .center()
                    .rotateTo(Direction.UP, Direction.EAST)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[1].translate(-.5f, .25f, 3.125f)
                    .center()
                    .rotateTo(Direction.UP, Direction.EAST)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[2].translate(-.5f, .25f, 2.75f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[3].translate(-.5f, .25f, -3.75f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[4].translate(-.5f, .25f, 1.25f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[5].translate(-.5f, .25f, -2.25f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();
        }
    }

    public static class QuadrupleAxleExtraLargePistonless extends QuadrupleAxlePistonlessDisplay {
        private final Affine<?> frame;
        private final Affine<?> belt;
        private final ScrollHandle beltScroll;
        private final Affine<?> r_c_rod;
        private final Affine<?> l_c_rod;
        private final Affine<?>[] wheels;
        private final Affine<?>[] wheelsSemiBlind;
        private final Affine<?>[] shafts;

        public QuadrupleAxleExtraLargePistonless(ElementProvider<?> prov) {
            frame = prov.create(BogiePartials.EXTRA_LARGE_8P_FRAME);
            var scrolling = prov.createScrolling(BogiePartials.EXTRA_LARGE_8P_BELTS, AllSpriteShifts.BOGEY_BELT);
            belt = scrolling.getFirst();
            beltScroll = scrolling.getSecond();
            r_c_rod = prov.create(BogiePartials.EXTRA_LARGE_8P_R_C_ROD);
            l_c_rod = prov.create(BogiePartials.EXTRA_LARGE_8P_L_C_ROD);
            wheels = prov.create(BogiePartials.EXTRA_LARGE_SHARED_WHEELS, 2);
            wheelsSemiBlind = prov.create(BogiePartials.EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND, 2);
            shafts = prov.create(AllPartialModels.SHAFT, 10);
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

            wheels[0].translate(0, 1.25f, -3.375f)
                    .rotateXDegrees(wheelAngle);

            wheels[1].translate(0, 1.25f, 3.375f)
                    .rotateXDegrees(wheelAngle);

            wheelsSemiBlind[0].translate(0, 1.25f, -1.125f)
                    .rotateXDegrees(wheelAngle);

            wheelsSemiBlind[1].translate(0, 1.25f, 1.125f)
                    .rotateXDegrees(wheelAngle);

            shafts[0].translate(-.5f, .25f, -4.875f)
                    .center()
                    .rotateTo(Direction.UP, Direction.EAST)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[1].translate(-.5f, .25f, 3.875f)
                    .center()
                    .rotateTo(Direction.UP, Direction.EAST)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[2].translate(-.5f, .25f, 3.4375f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[3].translate(-.5f, .25f, -4.4375f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[4].translate(-.5f, .25f, 2.3125f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[5].translate(-.5f, .25f, -3.3125f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[6].translate(-.5f, .25f, 1.1875f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[7].translate(-.5f, .25f, -2.1875f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[8].translate(-.5f, .25f, .0625f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[9].translate(-.5f, .25f, -1.0625f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();
        }
    }
}
