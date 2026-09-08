package com.weido.create_bb.renderers.gearless;

import com.weido.create_bb.data.math.RodCalculations;
import com.weido.create_bb.data.math.RodRenderer;
import com.weido.create_bb.data.rotation.BlocksBogiesBogieDisplay;
import com.weido.create_bb.registry.BogiePartials;
import com.weido.create_bb.renderers.unified.ElementProvider;
import com.weido.create_bb.renderers.unified.ScrollHandle;
import com.zurrtum.create.client.AllPartialModels;
import com.zurrtum.create.client.AllSpriteShifts;
import com.zurrtum.create.client.flywheel.lib.transform.Affine;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;

import static com.weido.create_bb.data.Constants.*;

public abstract class QuintupleAxleLongDisplay extends BlocksBogiesBogieDisplay {
    public static class QuintupleAxleLargeLong extends QuintupleAxleLongDisplay {
        private static final RodCalculations.WalschaertsParameters PARAMS = new RodCalculations.WalschaertsParameters(
                LARGE_10L_ECCENTRIC_ROD,
                LARGE_EXPANSION_LINK,
                LARGE_ECCENTRIC_CRANK_RADIUS,
                LARGE_10L_EXPANSION_LINK_X,
                LARGE_EXPANSION_LINK_Y,
                LARGE_E_LINK_R_BAR_CONNECTION,
                LARGE_MAIN_CRANK_RADIUS,
                LARGE_10L_MAIN_ROD_LENGTH,
                LARGE_10L_RADIUS_ROD,
                LARGE_COMBINATION_LEVER,
                LARGE_COMBINATION_UPPER,
                LARGE_COMBINATION_LOWER,
                LARGE_UNION_LINK,
                LARGE_DROP_LINK,
                LARGE_VALVE_Y,
                LARGE_10L_PISTON_DISTANCE,
                LARGE_CENTER_HEIGHT,
                LARGE_10L_OFFSET
        );

        private final Affine<?> frame;
        private final Affine<?> belt;
        private final ScrollHandle beltScroll;
        private final Affine<?> r_c_rod;
        private final Affine<?> l_c_rod;
        private final Affine<?> r_m_rod;
        private final Affine<?> l_m_rod;
        private final Affine<?> r_p_rod;
        private final Affine<?> l_p_rod;
        private final Affine<?>[] wheels;
        private final Affine<?>[] wheelsSemiBlind;
        private final Affine<?> wheelBlind;
        private final Affine<?>[] shafts;

        public QuintupleAxleLargeLong(ElementProvider<?> prov) {
            frame = prov.create(BogiePartials.LARGE_10L_FRAME);
            var scrolling = prov.createScrolling(BogiePartials.LARGE_10P_BELTS, AllSpriteShifts.BOGEY_BELT);
            belt = scrolling.getFirst();
            beltScroll = scrolling.getSecond();
            r_c_rod = prov.create(BogiePartials.LARGE_10L_R_C_ROD);
            l_c_rod = prov.create(BogiePartials.LARGE_10L_L_C_ROD);
            r_m_rod = prov.create(BogiePartials.LARGE_10LW_R_M_ROD);
            l_m_rod = prov.create(BogiePartials.LARGE_10LW_L_M_ROD);
            r_p_rod = prov.create(BogiePartials.LARGE_R_P_ROD_GEARLESS);
            l_p_rod = prov.create(BogiePartials.LARGE_L_P_ROD_GEARLESS);
            wheels = prov.create(BogiePartials.LARGE_SHARED_WHEELS, 2);
            wheelsSemiBlind = prov.create(BogiePartials.LARGE_SHARED_WHEELS_SEMI_BLIND, 2);
            wheelBlind = prov.create(BogiePartials.LARGE_SHARED_WHEELS_BLIND);
            shafts = prov.create(AllPartialModels.SHAFT, 8);
        }

        @Override
        public void update(boolean forwards, float wheelAngle) {
            frame.scale(1 - 1 / 512f)
                    .rotateYDegrees(forwards ? 0 : 180);

            beltScroll.scroll(BELT_RADIUS_IN_UV_SPACE * Mth.DEG_TO_RAD * (forwards ? wheelAngle : -wheelAngle));
            belt.scale(1 - 1 / 512f)
                    .rotateYDegrees(forwards ? 0 : 180);

            for (int i = 0; i < 2; i++) {
                RodRenderer.VisualResults visualResults = new RodRenderer.VisualResults(i, wheelAngle, forwards, PARAMS);
                RodRenderer.visualizeConnectingRod(i == 0 ? r_c_rod : l_c_rod, visualResults);
                RodRenderer.visualizeMainRod(i == 0 ? r_m_rod : l_m_rod, visualResults);
                RodRenderer.visualizePistonRod(i == 0 ? r_p_rod : l_p_rod, visualResults);
            }

            wheels[0].translate(0, 1, -3.375f)
                    .rotateYDegrees(forwards ? 0 : 180)
                    .rotateXDegrees(forwards ? wheelAngle : -wheelAngle);

            wheels[1].translate(0, 1, 3.375f)
                    .rotateYDegrees(forwards ? 0 : 180)
                    .rotateXDegrees(forwards ? wheelAngle : -wheelAngle);

            wheelsSemiBlind[0].translate(0, 1, -1.6875f)
                    .rotateYDegrees(forwards ? 0 : 180)
                    .rotateXDegrees(forwards ? wheelAngle : -wheelAngle);

            wheelsSemiBlind[1].translate(0, 1, 1.6875f)
                    .rotateYDegrees(forwards ? 0 : 180)
                    .rotateXDegrees(forwards ? wheelAngle : -wheelAngle);

            wheelBlind.translate(0, 1, 0)
                    .rotateYDegrees(forwards ? 0 : 180)
                    .rotateXDegrees(forwards ? wheelAngle : -wheelAngle);

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

            shafts[2].translate(-.5f, .25f, -4.5f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[3].translate(-.5f, .25f, 3.5f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[4].translate(-.5f, .25f, -3.0625f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[5].translate(-.5f, .25f, 2)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[6].translate(-.5f, .25f, -1.375f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[7].translate(-.5f, .25f, 0.3125)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();
        }
    }

    public static class QuintupleAxleExtraLargeLong extends QuintupleAxleLongDisplay {
        private static final RodCalculations.WalschaertsParameters PARAMS = new RodCalculations.WalschaertsParameters(
                EXTRA_LARGE_10L_ECCENTRIC_ROD,
                EXTRA_LARGE_EXPANSION_LINK,
                EXTRA_LARGE_ECCENTRIC_CRANK_RADIUS,
                EXTRA_LARGE_10L_EXPANSION_LINK_X,
                EXTRA_LARGE_EXPANSION_LINK_Y,
                EXTRA_LARGE_E_LINK_R_BAR_CONNECTION,
                EXTRA_LARGE_MAIN_CRANK_RADIUS,
                EXTRA_LARGE_10L_MAIN_ROD_LENGTH,
                EXTRA_LARGE_10L_RADIUS_ROD,
                EXTRA_LARGE_COMBINATION_LEVER,
                EXTRA_LARGE_COMBINATION_UPPER,
                EXTRA_LARGE_COMBINATION_LOWER,
                EXTRA_LARGE_UNION_LINK,
                EXTRA_LARGE_DROP_LINK,
                EXTRA_LARGE_VALVE_Y,
                EXTRA_LARGE_10L_PISTON_DISTANCE,
                EXTRA_LARGE_CENTER_HEIGHT,
                EXTRA_LARGE_10L_OFFSET
        );

        private final Affine<?> frame;
        private final Affine<?> belt;
        private final ScrollHandle beltScroll;
        private final Affine<?> r_c_rod;
        private final Affine<?> l_c_rod;
        private final Affine<?> r_m_rod;
        private final Affine<?> l_m_rod;
        private final Affine<?> r_p_rod;
        private final Affine<?> l_p_rod;
        private final Affine<?>[] wheels;
        private final Affine<?>[] wheelsSemiBlind;
        private final Affine<?> wheelBlind;
        private final Affine<?>[] shafts;

        public QuintupleAxleExtraLargeLong(ElementProvider<?> prov) {
            frame = prov.create(BogiePartials.EXTRA_LARGE_10L_FRAME);
            var scrolling = prov.createScrolling(BogiePartials.EXTRA_LARGE_10P_BELTS, AllSpriteShifts.BOGEY_BELT);
            belt = scrolling.getFirst();
            beltScroll = scrolling.getSecond();
            r_c_rod = prov.create(BogiePartials.EXTRA_LARGE_10L_R_C_ROD);
            l_c_rod = prov.create(BogiePartials.EXTRA_LARGE_10L_L_C_ROD);
            r_m_rod = prov.create(BogiePartials.EXTRA_LARGE_10LW_R_M_ROD);
            l_m_rod = prov.create(BogiePartials.EXTRA_LARGE_10LW_L_M_ROD);
            r_p_rod = prov.create(BogiePartials.EXTRA_LARGE_R_P_ROD_GEARLESS);
            l_p_rod = prov.create(BogiePartials.EXTRA_LARGE_L_P_ROD_GEARLESS);
            wheels = prov.create(BogiePartials.EXTRA_LARGE_SHARED_WHEELS, 2);
            wheelsSemiBlind = prov.create(BogiePartials.EXTRA_LARGE_SHARED_WHEELS_SEMI_BLIND, 2);
            wheelBlind = prov.create(BogiePartials.EXTRA_LARGE_SHARED_WHEELS_BLIND);
            shafts = prov.create(AllPartialModels.SHAFT, 12);
        }

        @Override
        public void update(boolean forwards, float wheelAngle) {
            frame.scale(1 - 1 / 512f)
                    .rotateYDegrees(forwards ? 0 : 180);

            beltScroll.scroll(BELT_RADIUS_IN_UV_SPACE * Mth.DEG_TO_RAD * (forwards ? wheelAngle : -wheelAngle));
            belt.scale(1 - 1 / 512f)
                    .rotateYDegrees(forwards ? 0 : 180);

            for (int i = 0; i < 2; i++) {
                RodRenderer.VisualResults visualResults = new RodRenderer.VisualResults(i, wheelAngle, forwards, PARAMS);
                RodRenderer.visualizeConnectingRod(i == 0 ? r_c_rod : l_c_rod, visualResults);
                RodRenderer.visualizeMainRod(i == 0 ? r_m_rod : l_m_rod, visualResults);
                RodRenderer.visualizePistonRod(i == 0 ? r_p_rod : l_p_rod, visualResults);
            }

            wheels[0].translate(0, 1.25f, -4.5f)
                    .rotateYDegrees(forwards ? 0 : 180)
                    .rotateXDegrees(forwards ? wheelAngle : -wheelAngle);

            wheels[1].translate(0, 1.25f, 4.5f)
                    .rotateYDegrees(forwards ? 0 : 180)
                    .rotateXDegrees(forwards ? wheelAngle : -wheelAngle);

            wheelsSemiBlind[0].translate(0, 1.25f, -2.25f)
                    .rotateYDegrees(forwards ? 0 : 180)
                    .rotateXDegrees(forwards ? wheelAngle : -wheelAngle);

            wheelsSemiBlind[1].translate(0, 1.25f, 2.25f)
                    .rotateYDegrees(forwards ? 0 : 180)
                    .rotateXDegrees(forwards ? wheelAngle : -wheelAngle);

            wheelBlind.translate(0, 1.25f, 0)
                    .rotateYDegrees(forwards ? 0 : 180)
                    .rotateXDegrees(forwards ? wheelAngle : -wheelAngle);

            shafts[0].translate(-.5f, .25f, -6)
                    .center()
                    .rotateTo(Direction.UP, Direction.EAST)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[1].translate(-.5f, .25f, 5)
                    .center()
                    .rotateTo(Direction.UP, Direction.EAST)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[2].translate(-.5f, .25f, -5.5625f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[3].translate(-.5f, .25f, 4.5625f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[4].translate(-.5f, .25f, -4.4375f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[5].translate(-.5f, .25f, 3.4375f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[6].translate(-.5f, .25f, -3.3125f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[7].translate(-.5f, .25f, 2.3125f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[8].translate(-.5f, .25f, -2.1875f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[9].translate(-.5f, .25f, 1.1875f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[10].translate(-.5f, .25f, -1.0625f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[11].translate(-.5f, .25f, .0625f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();
        }
    }
}
