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

public abstract class SingleAxleLongDisplay extends BlocksBogiesBogieDisplay {
    public static class SingleAxleLargeLong extends SingleAxleLongDisplay {
        private static final RodCalculations.WalschaertsParameters PARAMS = new RodCalculations.WalschaertsParameters(
                LARGE_6S_ECCENTRIC_ROD,
                LARGE_EXPANSION_LINK,
                LARGE_ECCENTRIC_CRANK_RADIUS,
                LARGE_6S_EXPANSION_LINK_X,
                LARGE_EXPANSION_LINK_Y,
                LARGE_E_LINK_R_BAR_CONNECTION,
                LARGE_MAIN_CRANK_RADIUS,
                LARGE_6S_MAIN_ROD_LENGTH,
                LARGE_6S_RADIUS_ROD,
                LARGE_COMBINATION_LEVER,
                LARGE_COMBINATION_UPPER,
                LARGE_COMBINATION_LOWER,
                LARGE_UNION_LINK,
                LARGE_DROP_LINK,
                LARGE_VALVE_Y,
                LARGE_6S_PISTON_DISTANCE,
                LARGE_CENTER_HEIGHT,
                LARGE_6S_OFFSET
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
        private final Affine<?> wheel;
        private final Affine<?>[] shafts;

        public SingleAxleLargeLong(ElementProvider<?> prov) {
            frame = prov.create(BogiePartials.LARGE_2L_FRAME);
            var scrolling = prov.createScrolling(BogiePartials.LARGE_2P_BELTS, AllSpriteShifts.BOGEY_BELT);
            belt = scrolling.getFirst();
            beltScroll = scrolling.getSecond();
            r_c_rod = prov.create(BogiePartials.LARGE_2L_R_C_ROD);
            l_c_rod = prov.create(BogiePartials.LARGE_2L_L_C_ROD);
            r_m_rod = prov.create(BogiePartials.LARGE_6SW_R_M_ROD);
            l_m_rod = prov.create(BogiePartials.LARGE_6SW_L_M_ROD);
            r_p_rod = prov.create(BogiePartials.LARGE_R_P_ROD_GEARLESS);
            l_p_rod = prov.create(BogiePartials.LARGE_L_P_ROD_GEARLESS);
            wheel = prov.create(BogiePartials.LARGE_SHARED_WHEELS);
            shafts = prov.create(AllPartialModels.SHAFT, 4);
        }

        @Override
        public void update(boolean forwards, float wheelAngle) {
            frame.scale(1 - 1 / 512f)
                    .rotateYDegrees(forwards ? 0 : 180);

            beltScroll.scroll(BELT_RADIUS_IN_UV_SPACE * Mth.DEG_TO_RAD * wheelAngle);
            belt.scale(1 - 1 / 512f);

            for (int i = 0; i < 2; i++) {
                RodRenderer.VisualResults visualResults = new RodRenderer.VisualResults(i, wheelAngle, forwards, PARAMS);
                RodRenderer.visualizeConnectingRod(i == 0 ? r_c_rod : l_c_rod, visualResults);
                RodRenderer.visualizeMainRod(i == 0 ? r_m_rod : l_m_rod, visualResults);
                RodRenderer.visualizePistonRod(i == 0 ? r_p_rod : l_p_rod, visualResults);
            }

            wheel.rotateYDegrees(forwards ? 0 : 180)
                    .translate(0, 1, 0)
                    .rotateXDegrees(forwards ? wheelAngle : -wheelAngle);

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

            shafts[2].translate(-.5f, .25f, 0.5f)
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

    public static class SingleAxleExtraLargeLong extends SingleAxleLongDisplay {
        private static final RodCalculations.WalschaertsParameters PARAMS = new RodCalculations.WalschaertsParameters(
                EXTRA_LARGE_6S_ECCENTRIC_ROD,
                EXTRA_LARGE_EXPANSION_LINK,
                EXTRA_LARGE_ECCENTRIC_CRANK_RADIUS,
                EXTRA_LARGE_6S_EXPANSION_LINK_X,
                EXTRA_LARGE_EXPANSION_LINK_Y,
                EXTRA_LARGE_E_LINK_R_BAR_CONNECTION,
                EXTRA_LARGE_MAIN_CRANK_RADIUS,
                EXTRA_LARGE_6S_MAIN_ROD_LENGTH,
                EXTRA_LARGE_6S_RADIUS_ROD,
                EXTRA_LARGE_COMBINATION_LEVER,
                EXTRA_LARGE_COMBINATION_UPPER,
                EXTRA_LARGE_COMBINATION_LOWER,
                EXTRA_LARGE_UNION_LINK,
                EXTRA_LARGE_DROP_LINK,
                EXTRA_LARGE_VALVE_Y,
                EXTRA_LARGE_6S_PISTON_DISTANCE,
                EXTRA_LARGE_CENTER_HEIGHT,
                EXTRA_LARGE_6S_OFFSET
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
        private final Affine<?> wheel;
        private final Affine<?>[] shafts;

        public SingleAxleExtraLargeLong(ElementProvider<?> prov) {
            frame = prov.create(BogiePartials.EXTRA_LARGE_2L_FRAME);
            var scrolling = prov.createScrolling(BogiePartials.EXTRA_LARGE_2P_BELTS, AllSpriteShifts.BOGEY_BELT);
            belt = scrolling.getFirst();
            beltScroll = scrolling.getSecond();
            r_c_rod = prov.create(BogiePartials.LARGE_2L_R_C_ROD);
            l_c_rod = prov.create(BogiePartials.LARGE_2L_L_C_ROD);
            r_m_rod = prov.create(BogiePartials.EXTRA_LARGE_6SW_R_M_ROD);
            l_m_rod = prov.create(BogiePartials.EXTRA_LARGE_6SW_L_M_ROD);
            r_p_rod = prov.create(BogiePartials.EXTRA_LARGE_R_P_ROD_GEARLESS);
            l_p_rod = prov.create(BogiePartials.EXTRA_LARGE_L_P_ROD_GEARLESS);
            wheel = prov.create(BogiePartials.EXTRA_LARGE_SHARED_WHEELS);
            shafts = prov.create(AllPartialModels.SHAFT, 4);
        }

        @Override
        public void update(boolean forwards, float wheelAngle) {
            frame.scale(1 - 1 / 512f)
                    .rotateYDegrees(forwards ? 0 : 180);

            beltScroll.scroll(BELT_RADIUS_IN_UV_SPACE * Mth.DEG_TO_RAD * wheelAngle);
            belt.scale(1 - 1 / 512f);

            for (int i = 0; i < 2; i++) {
                RodRenderer.VisualResults visualResults = new RodRenderer.VisualResults(i, wheelAngle, forwards, PARAMS);
                RodRenderer.visualizeConnectingRod(i == 0 ? r_c_rod : l_c_rod, visualResults);
                RodRenderer.visualizeMainRod(i == 0 ? r_m_rod : l_m_rod, visualResults);
                RodRenderer.visualizePistonRod(i == 0 ? r_p_rod : l_p_rod, visualResults);
            }

            wheel.rotateYDegrees(forwards ? 0 : 180)
                    .translate(0, 1.25f, 0)
                    .rotateXDegrees(forwards ? wheelAngle : -wheelAngle);

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

            shafts[2].translate(-.5f, .25f, 0.5f)
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
