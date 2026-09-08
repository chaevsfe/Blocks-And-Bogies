package com.weido.create_bb.renderers.walschaerts;

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

public abstract class SextupleAxleWalschaertsLongDisplay extends BlocksBogiesBogieDisplay {
    public static class SextupleAxleLargeWalschaertsLong extends SextupleAxleWalschaertsLongDisplay {
        private static final RodCalculations.WalschaertsParameters PARAMS = new RodCalculations.WalschaertsParameters(
                LARGE_12L_ECCENTRIC_ROD,
                LARGE_EXPANSION_LINK,
                LARGE_ECCENTRIC_CRANK_RADIUS,
                LARGE_12L_EXPANSION_LINK_X,
                LARGE_EXPANSION_LINK_Y,
                LARGE_E_LINK_R_BAR_CONNECTION,
                LARGE_MAIN_CRANK_RADIUS,
                LARGE_12L_MAIN_ROD_LENGTH,
                LARGE_12L_RADIUS_ROD,
                LARGE_COMBINATION_LEVER,
                LARGE_COMBINATION_UPPER,
                LARGE_COMBINATION_LOWER,
                LARGE_UNION_LINK,
                LARGE_DROP_LINK,
                LARGE_VALVE_Y,
                LARGE_12L_PISTON_DISTANCE,
                LARGE_CENTER_HEIGHT,
                LARGE_12L_OFFSET
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
        private final Affine<?> r_r_rod;
        private final Affine<?> l_r_rod;
        private final Affine<?> r_e_link;
        private final Affine<?> l_e_link;
        private final Affine<?> r_e_rod;
        private final Affine<?> l_e_rod;
        private final Affine<?> r_c_lever;
        private final Affine<?> l_c_lever;
        private final Affine<?> r_u_link;
        private final Affine<?> l_u_link;
        private final Affine<?> r_v_stem;
        private final Affine<?> l_v_stem;
        private final Affine<?> e_crank;
        private final Affine<?>[] wheels;
        private final Affine<?>[] wheelsBlind;
        private final Affine<?>[] wheelsSemiBlind;
        private final Affine<?>[] shafts;

        public SextupleAxleLargeWalschaertsLong(ElementProvider<?> prov) {
            frame = prov.create(BogiePartials.LARGE_12LW_FRAME);
            var scrolling = prov.createScrolling(BogiePartials.LARGE_12LW_BELTS, AllSpriteShifts.BOGEY_BELT);
            belt = scrolling.getFirst();
            beltScroll = scrolling.getSecond();
            r_c_rod = prov.create(BogiePartials.LARGE_12LW_R_C_ROD);
            l_c_rod = prov.create(BogiePartials.LARGE_12LW_L_C_ROD);
            r_m_rod = prov.create(BogiePartials.LARGE_12LW_R_M_ROD);
            l_m_rod = prov.create(BogiePartials.LARGE_12LW_L_M_ROD);
            r_p_rod = prov.create(BogiePartials.LARGE_R_P_ROD_WALSCHAERTS);
            l_p_rod = prov.create(BogiePartials.LARGE_L_P_ROD_WALSCHAERTS);
            r_r_rod = prov.create(BogiePartials.LARGE_12LW_R_R_ROD);
            l_r_rod = prov.create(BogiePartials.LARGE_12LW_L_R_ROD);
            r_e_link = prov.create(BogiePartials.LARGE_R_E_LINK);
            l_e_link = prov.create(BogiePartials.LARGE_L_E_LINK);
            r_e_rod = prov.create(BogiePartials.LARGE_12LW_R_E_ROD);
            l_e_rod = prov.create(BogiePartials.LARGE_12LW_L_E_ROD);
            r_c_lever = prov.create(BogiePartials.LARGE_R_C_LEVER);
            l_c_lever = prov.create(BogiePartials.LARGE_L_C_LEVER);
            r_u_link = prov.create(BogiePartials.LARGE_R_U_LINK);
            l_u_link = prov.create(BogiePartials.LARGE_L_U_LINK);
            r_v_stem = prov.create(BogiePartials.LARGE_R_V_STEM);
            l_v_stem = prov.create(BogiePartials.LARGE_L_V_STEM);
            e_crank = prov.create(BogiePartials.LARGE_SHARED_ECCENTRIC_CRANK);
            wheels = prov.create(BogiePartials.LARGE_SHARED_WHEELS, 2);
            wheelsBlind = prov.create(BogiePartials.LARGE_SHARED_WHEELS_BLIND, 2);
            wheelsSemiBlind = prov.create(BogiePartials.LARGE_SHARED_WHEELS_SEMI_BLIND, 2);
            shafts = prov.create(AllPartialModels.SHAFT, 8);
        }

        @Override
        public void update(boolean forwards, float wheelAngle) {
            frame.scale(1 - 1 / 512f)
                    .rotateYDegrees(forwards ? 0 : 180);

            for (int i = 0; i < 2; i++) {
                RodRenderer.VisualResults visualResults = new RodRenderer.VisualResults(i, wheelAngle, forwards, PARAMS);

                RodRenderer.visualizeConnectingRod(i == 0 ? r_c_rod : l_c_rod, visualResults);
                RodRenderer.visualizeMainRod(i == 0 ? r_m_rod : l_m_rod, visualResults);
                RodRenderer.visualizePistonRod(i == 0 ? r_p_rod : l_p_rod, visualResults);
                RodRenderer.visualizeRadiusRod(i == 0 ? r_r_rod : l_r_rod, visualResults);
                RodRenderer.visualizeExpansionLink(i == 0 ? r_e_link : l_e_link, visualResults);
                RodRenderer.visualizeEccentricRod(i == 0 ? r_e_rod : l_e_rod, visualResults);
                RodRenderer.visualizeCombinationLever(i == 0 ? r_c_lever : l_c_lever, visualResults);
                RodRenderer.visualizeUnionLink(i == 0 ?  r_u_link : l_u_link, visualResults);
                RodRenderer.visualizeValveStem(i == 0 ?  r_v_stem : l_v_stem, visualResults);
            }

            beltScroll.scroll(BELT_RADIUS_IN_UV_SPACE * Mth.DEG_TO_RAD * (forwards ? wheelAngle : -wheelAngle));
            belt.scale(1 - 1 / 512f)
                    .rotateYDegrees(forwards ? 0 : 180);

            wheels[0].translate(0, 1, -4.375f)
                    .rotateYDegrees(forwards ? 0 : 180)
                    .rotateXDegrees(forwards ? wheelAngle : -wheelAngle);

            wheels[1].translate(0, 1, 4.375f)
                    .rotateYDegrees(forwards ? 0 : 180)
                    .rotateXDegrees(forwards ? wheelAngle : -wheelAngle);

            wheelsSemiBlind[0].translate(0, 1, -2.625f)
                    .rotateYDegrees(forwards ? 0 : 180)
                    .rotateXDegrees(forwards ? wheelAngle : -wheelAngle);

            wheelsSemiBlind[1].translate(0, 1, 2.625f)
                    .rotateYDegrees(forwards ? 0 : 180)
                    .rotateXDegrees(forwards ? wheelAngle : -wheelAngle);

            wheelsBlind[0].translate(0, 1, .875)
                    .rotateYDegrees(forwards ? 0 : 180)
                    .rotateXDegrees(forwards ? wheelAngle : -wheelAngle);

            wheelsBlind[1].translate(0, 1, -.875)
                    .rotateYDegrees(forwards ? 0 : 180)
                    .rotateXDegrees(forwards ? wheelAngle : -wheelAngle);

            e_crank.translate(0, 1, forwards ? LARGE_12L_OFFSET : -LARGE_12L_OFFSET)
                    .rotateYDegrees(forwards ? 0 : 180)
                    .rotateXDegrees(forwards ? wheelAngle : -wheelAngle);

            shafts[0].translate(-.5f, .25f, -5.875f)
                    .center()
                    .rotateTo(Direction.UP, Direction.EAST)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[1].translate(-.5f, .25f, 4.875f)
                    .center()
                    .rotateTo(Direction.UP, Direction.EAST)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[2].translate(-.5f, .25f, -5.5f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[3].translate(-.5f, .25f, 4.5f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[4].translate(-.5f, .25f, -4f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[5].translate(-.5f, .25f, 3)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[6].translate(-.5f, .25f, -2.25f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();

            shafts[7].translate(-.5f, .25f, 1.25f)
                    .center()
                    .rotateTo(Direction.UP, Direction.SOUTH)
                    .rotateYDegrees(wheelAngle)
                    .uncenter();
        }
    }
}
