package com.weido.create_bb.data.packets;

import com.weido.create_bb.data.menu.BogieStyleSelectionScreen;
import com.zurrtum.create.client.catnip.gui.ScreenOpener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

@Environment(EnvType.CLIENT)
public class BogieClientPackets {
    public static void register() {
        ClientPlayNetworking.registerGlobalReceiver(BogieMenuPacket.Clientbound.TYPE, (packet, context) -> {
            if (context.player().isSpectator())
                return;
            ScreenOpener.open(new BogieStyleSelectionScreen(packet.pos()));
        });
    }
}
