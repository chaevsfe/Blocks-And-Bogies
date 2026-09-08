package com.weido.create_bb.registry;

import com.weido.create_bb.BlocksBogies;
import com.weido.create_bb.data.packets.BogieMenuPacket;
import com.weido.create_bb.data.packets.BogieStylePacket;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class BogiePackets {
    public static void register() {
        PayloadTypeRegistry.clientboundPlay().register(BogieMenuPacket.Clientbound.TYPE, BogieMenuPacket.Clientbound.STREAM_CODEC);
        PayloadTypeRegistry.serverboundPlay().register(BogieMenuPacket.Serverbound.TYPE, BogieMenuPacket.Serverbound.STREAM_CODEC);
        PayloadTypeRegistry.serverboundPlay().register(BogieStylePacket.Serverbound.TYPE, BogieStylePacket.Serverbound.STREAM_CODEC);

        ServerPlayNetworking.registerGlobalReceiver(BogieMenuPacket.Serverbound.TYPE, (packet, context) -> packet.handle(context.player()));
        ServerPlayNetworking.registerGlobalReceiver(BogieStylePacket.Serverbound.TYPE, (packet, context) -> packet.handle(context.player()));
        BlocksBogies.LOGGER.info("Registered packets for " + BlocksBogies.MOD_NAME);
    }
}
