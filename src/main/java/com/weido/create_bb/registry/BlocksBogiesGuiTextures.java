package com.weido.create_bb.registry;

import com.weido.create_bb.BlocksBogies;
import com.zurrtum.create.client.catnip.gui.TextureSheetSegment;
import com.zurrtum.create.client.catnip.gui.UIRenderHelper;
import com.zurrtum.create.client.catnip.gui.element.ScreenElement;
import com.zurrtum.create.catnip.theme.Color;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.jetbrains.annotations.NotNull;

public enum BlocksBogiesGuiTextures implements ScreenElement, TextureSheetSegment {
    BOGIE_MENU("bogiemenu",0, 0, 302, 227 , 512, 512),
    WIDE_BUTTON("bogiemenu", 302, 0, 87, 18, 512, 512),
    WIDE_BUTTON_HOVER("bogiemenu", 302, 18, 87, 18, 512, 512),
    WIDE_BUTTON_DOWN("bogiemenu", 302, 36, 87, 18, 512, 512),
    WIDE_BUTTON_DISABLED("bogiemenu", 302, 54, 87, 18, 512, 512),
    NUMBER_BACKGROUND("bogiemenu", 302, 72, 31, 15, 512, 512);

    public final Identifier location;
    private final int width;
    private final int height;
    private final int startX;
    private final int startY;
    private final int textureHeight;
    private final int textureWidth;

    BlocksBogiesGuiTextures(String location, int startX, int startY, int width, int height, int textureHeight, int textureWidth) {
        this(BlocksBogies.MOD_ID, location, startX, startY, width, height, textureHeight, textureWidth);
    }

    BlocksBogiesGuiTextures(String namespace, String location, int startX, int startY, int width, int height, int textureHeight, int textureWidth) {
        this.location = Identifier.fromNamespaceAndPath(namespace, "textures/gui/" + location + ".png");
        this.width = width;
        this.height = height;
        this.startX = startX;
        this.startY = startY;
        this.textureHeight = textureHeight;
        this.textureWidth = textureWidth;
    }

    @Override
    public @NotNull Identifier getLocation() {
        return location;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void render(GuiGraphicsExtractor graphics, int x, int y) {
        graphics.blit(RenderPipelines.GUI_TEXTURED, location, x, y, startX, startY, width, height, textureWidth, textureHeight);
    }

    @Environment(EnvType.CLIENT)
    public void render(GuiGraphicsExtractor graphics, int x, int y, Color c) {
        UIRenderHelper.drawColoredTexture(graphics, bind(), c, x, y, startX, startY, width, height);
    }

    @Override
    public int getStartX() {
        return startX;
    }

    @Override
    public int getStartY() {
        return startY;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public int getTextureHeight() {
        return textureHeight;
    }
    public int getTextureWidth() {
        return textureWidth;
    }
}
