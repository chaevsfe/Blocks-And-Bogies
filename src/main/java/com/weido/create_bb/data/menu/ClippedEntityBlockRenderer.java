package com.weido.create_bb.data.menu;

import com.mojang.blaze3d.vertex.PoseStack;
import com.zurrtum.create.client.catnip.gui.render.EntityBlockRenderer;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.client.gui.render.pip.PictureInPictureRenderer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.feature.FeatureRenderDispatcher;
import net.minecraft.client.renderer.state.gui.BlitRenderState;
import net.minecraft.client.renderer.state.gui.GuiRenderState;

public class ClippedEntityBlockRenderer extends PictureInPictureRenderer<ClippedEntityBlockRenderState> {
    private final EntityBlockRenderer delegate = new EntityBlockRenderer();
    private final ScissorRelay relay = new ScissorRelay();

    @Override
    public void prepare(ClippedEntityBlockRenderState state, GuiRenderState guiRenderState, FeatureRenderDispatcher dispatcher, int windowScaleFactor) {
        relay.target = guiRenderState;
        relay.scissorArea = state.scissorArea();
        delegate.prepare(state.inner(), relay, dispatcher, windowScaleFactor);
        relay.target = null;
        relay.scissorArea = null;
    }

    @Override
    protected void renderToTexture(ClippedEntityBlockRenderState state, PoseStack poseStack, SubmitNodeCollector collector) {
    }

    @Override
    protected String getTextureLabel() {
        return "create_bb bogey preview";
    }

    @Override
    public Class<ClippedEntityBlockRenderState> getRenderStateClass() {
        return ClippedEntityBlockRenderState.class;
    }

    @Override
    public void close() {
        delegate.close();
        super.close();
    }

    private static final class ScissorRelay extends GuiRenderState {
        private GuiRenderState target;
        private ScreenRectangle scissorArea;

        @Override
        public void addBlitToCurrentLayer(BlitRenderState blit) {
            target.addBlitToCurrentLayer(new BlitRenderState(
                blit.pipeline(), blit.textureSetup(), blit.pose(),
                blit.x0(), blit.y0(), blit.x1(), blit.y1(),
                blit.u0(), blit.u1(), blit.v0(), blit.v1(),
                blit.color(), scissorArea, blit.bounds()
            ));
        }
    }
}
