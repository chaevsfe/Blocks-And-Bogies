package com.weido.create_bb.data.menu.Input;

import com.weido.create_bb.registry.BlocksBogiesGuiTextures;
import com.zurrtum.create.client.catnip.gui.widget.AbstractSimiWidget;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.input.MouseButtonEvent;
import org.jetbrains.annotations.NotNull;

public class TypeButton extends AbstractSimiWidget {
    private boolean down;

    public TypeButton(int x, int y) {
        super(x, y, BlocksBogiesGuiTextures.WIDE_BUTTON.getWidth(), BlocksBogiesGuiTextures.WIDE_BUTTON.getHeight());
    }

    @Override
    public void onClick(@NotNull MouseButtonEvent event, boolean doubleClick) {
        super.onClick(event, doubleClick);
        down = true;
    }

    @Override
    public void onRelease(@NotNull MouseButtonEvent event) {
        super.onRelease(event);
        down = false;
    }

    @Override
    protected void doRender(@NotNull GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTicks) {
        if (!visible)
            return;
        isHovered = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;

        BlocksBogiesGuiTextures button = !active ? BlocksBogiesGuiTextures.WIDE_BUTTON_DISABLED
            : isHovered && down ? BlocksBogiesGuiTextures.WIDE_BUTTON_DOWN
            : isHovered ? BlocksBogiesGuiTextures.WIDE_BUTTON_HOVER
            : BlocksBogiesGuiTextures.WIDE_BUTTON;

        button.render(graphics, getX(), getY());
    }
}
