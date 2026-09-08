package com.weido.create_bb.mixin;

import com.railwayteam.railways.api.bogeymenu.v0.entry.BogeyEntry;
import com.railwayteam.railways.content.bogey_menu.BogeyMenuScreen;
import com.railwayteam.railways.content.bogey_menu.handler.BogeyMenuHandlerClient;
import com.zurrtum.create.content.trains.bogey.BogeySize;
import com.zurrtum.create.content.trains.bogey.BogeyStyle;
import com.zurrtum.create.client.foundation.gui.AllIcons;
import com.zurrtum.create.client.foundation.gui.widget.IconButton;
import com.weido.create_bb.data.compat.steamnrails.MenuSwitchButton;
import com.weido.create_bb.data.menu.BogieStyleSelectionScreen;
import com.weido.create_bb.data.packets.BogieStylePacket;
import com.zurrtum.create.client.catnip.gui.AbstractSimiScreen;
import com.zurrtum.create.client.catnip.gui.ScreenOpener;
import com.zurrtum.create.client.catnip.gui.widget.AbstractSimiWidget;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BogeyMenuScreen.class)
public abstract class BogeyMenuScreenMixin extends AbstractSimiScreen {

    @Unique
    private BlockPos create_bb$targetPos;

    @Inject(method = "init", at = @At("TAIL"))
    private void create_bb$injectSwitchButton(CallbackInfo ci) {
        BlockPos handoff = MenuSwitchButton.getTargetPos();
        if (handoff != null) {
            create_bb$targetPos = handoff;
            MenuSwitchButton.clearTargetPos();
        }

        var background = ((BogeyMenuScreenAccessor) this).getBackground();
        if (background != null) {
            BlockPos targetPos = create_bb$targetPos;
            IconButton switchButton = new IconButton(
                    guiLeft + background.width - 62,
                    guiTop + background.height - 24,
                    AllIcons.I_DICE
            );
            switchButton.withCallback(() -> ScreenOpener.open(new BogieStyleSelectionScreen(targetPos)));
            switchButton.setToolTip(Component.translatable("create_bb.tooltips.switch_to_bb_menu").withStyle(s -> s.withColor(AbstractSimiWidget.HEADER_RGB.getRGB())));

            addRenderableWidget(switchButton);
        }
    }

    @Inject(method = "onMenuClose", at = @At("TAIL"))
    private void create_bb$onMenuClose(CallbackInfo ci) {
        BlockPos targetPos = create_bb$targetPos;
        create_bb$targetPos = null;
        if (targetPos == null)
            return;

        BogeyEntry selectedBogey = ((BogeyMenuScreenAccessor) this).getSelectedBogey();
        if (selectedBogey == null)
            return;

        BogeyStyle style = selectedBogey.bogeyStyle();
        BogeySize size = BogeyMenuHandlerClient.getSize(style);
        ClientPlayNetworking.send(new BogieStylePacket.Serverbound(style, size, targetPos));
    }
}
