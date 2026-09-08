package com.weido.create_bb.data.math;

import com.zurrtum.create.client.flywheel.lib.transform.Affine;

public class RodRenderer {
    public record VisualResults(
            int side,
            float wheelAngle,
            boolean forwards,
            RodCalculations.WalschaertsParameters params
    ) {}

    private static float[] getVisualResults(VisualResults visualResults) {
        float wheelAngleCheck = (visualResults.forwards() ? visualResults.wheelAngle() : -visualResults.wheelAngle()) + (visualResults.side() * 90);
        return RodCalculations.calculateGear(wheelAngleCheck, visualResults.params());
    }

    private static void setupBasicTransform(Affine<?> element, VisualResults visualResults) {
        element.rotateYDegrees(visualResults.forwards() ? 0 : 180);
    }

    public static void visualizeMainRod(Affine<?> element, VisualResults visualResults) {
        float[] results = getVisualResults(visualResults);
        setupBasicTransform(element, visualResults);
        element.translateZ(results[0] + visualResults.params().xOffset())
                .translateY(visualResults.params().yOffset())
                .rotateX(results[7]);
    }

    public static void visualizePistonRod(Affine<?> element, VisualResults visualResults) {
        float[] results = getVisualResults(visualResults);
        setupBasicTransform(element, visualResults);
        element.translateZ(results[0] + visualResults.params().xOffset());
    }

    public static void visualizeConnectingRod(Affine<?> element, VisualResults visualResults) {
        float angle = (visualResults.forwards() ? visualResults.wheelAngle() : -visualResults.wheelAngle()) + (visualResults.side() * 90);
        setupBasicTransform(element, visualResults);
        element.translate(0, visualResults.params().yOffset(), 0)
                .rotateXDegrees(angle)
                .translate(0, visualResults.params().mainCrankRadius(), 0)
                .rotateXDegrees(-angle);
    }

    public static void visualizeExpansionLink(Affine<?> element, VisualResults visualResults) {
        float[] results = getVisualResults(visualResults);
        setupBasicTransform(element, visualResults);
        element.translate(0, visualResults.params().expansionLinkY() + visualResults.params().yOffset(), -visualResults.params().expansionLinkX() + visualResults.params().xOffset())
                .rotateX(results[9]);
    }

    public static void visualizeEccentricRod(Affine<?> element, VisualResults visualResults) {
        float[] results = getVisualResults(visualResults);
        setupBasicTransform(element, visualResults);
        element.translate(0, results[2] + visualResults.params().yOffset(), -results[1] + visualResults.params().xOffset())
                .rotateX(results[8]);
    }

    public static void visualizeRadiusRod(Affine<?> element, VisualResults visualResults) {
        float[] results = getVisualResults(visualResults);
        setupBasicTransform(element, visualResults);
        element.translate(0, results[4] + visualResults.params().yOffset(), -results[3] + visualResults.params().xOffset())
                .rotateX(results[11]);
    }

    public static void visualizeUnionLink(Affine<?> element, VisualResults visualResults) {
        float[] results = getVisualResults(visualResults);
        setupBasicTransform(element, visualResults);
        element.translate(0, visualResults.params().yOffset() - visualResults.params().dropLink(), -results[5] + visualResults.params().xOffset())
                .rotateX(results[10]);
    }

    public static void visualizeCombinationLever(Affine<?> element, VisualResults visualResults) {
        float[] results = getVisualResults(visualResults);
        setupBasicTransform(element, visualResults);
        element.translate(0, visualResults.params().valveY() + visualResults.params().yOffset(), -results[6] + visualResults.params().xOffset())
                .rotateX(results[12]);
    }

    public static void visualizeValveStem(Affine<?> element, VisualResults visualResults) {
        float[] results = getVisualResults(visualResults);
        setupBasicTransform(element, visualResults);
        element.translate(0, 0, -results[6] + visualResults.params().xOffset());
    }
}
