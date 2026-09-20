package com.weido.create_bb.data.menu;

import com.zurrtum.create.client.catnip.gui.render.EntityBlockRenderState;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.client.renderer.state.gui.pip.PictureInPictureRenderState;
import org.joml.Matrix3x2f;

public record ClippedEntityBlockRenderState(EntityBlockRenderState inner, ScreenRectangle scissorArea, ScreenRectangle bounds) implements PictureInPictureRenderState {
    public static ClippedEntityBlockRenderState of(EntityBlockRenderState inner, ScreenRectangle scissorArea) {
        ScreenRectangle bounds = inner.bounds();
        return new ClippedEntityBlockRenderState(inner, scissorArea, bounds == null ? null : bounds.intersection(scissorArea));
    }

    @Override
    public int x0() {
        return inner.x0();
    }

    @Override
    public int x1() {
        return inner.x1();
    }

    @Override
    public int y0() {
        return inner.y0();
    }

    @Override
    public int y1() {
        return inner.y1();
    }

    @Override
    public float scale() {
        return inner.scale();
    }

    @Override
    public Matrix3x2f pose() {
        return inner.pose();
    }
}
