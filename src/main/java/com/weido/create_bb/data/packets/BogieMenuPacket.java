package com.weido.create_bb.data.packets;

import com.weido.create_bb.BlocksBogies;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;

public final class BogieMenuPacket {
    private BogieMenuPacket() {
    }

    public record Clientbound(BlockPos pos) implements CustomPacketPayload {
        public static final Type<Clientbound> TYPE = new Type<>(BlocksBogies.asResource("s_bogie_menu"));

        public static final StreamCodec<FriendlyByteBuf, Clientbound> STREAM_CODEC = StreamCodec.ofMember(
                (packet, buf) -> buf.writeBlockPos(packet.pos),
                buf -> new Clientbound(buf.readBlockPos())
        );

        @Override
        public Type<? extends CustomPacketPayload> type() {
            return TYPE;
        }
    }

    public record Serverbound(BlockPos pos) implements CustomPacketPayload {
        public static final Type<Serverbound> TYPE = new Type<>(BlocksBogies.asResource("c_bogie_menu"));

        public static final StreamCodec<FriendlyByteBuf, Serverbound> STREAM_CODEC = StreamCodec.ofMember(
                (packet, buf) -> buf.writeBlockPos(packet.pos),
                buf -> new Serverbound(buf.readBlockPos())
        );

        @Override
        public Type<? extends CustomPacketPayload> type() {
            return TYPE;
        }

        public void handle(ServerPlayer player) {
            ServerPlayNetworking.send(player, new Clientbound(pos));
        }
    }
}
