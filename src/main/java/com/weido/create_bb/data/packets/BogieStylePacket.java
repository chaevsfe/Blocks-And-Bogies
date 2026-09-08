package com.weido.create_bb.data.packets;

import com.weido.create_bb.BlocksBogies;
import com.weido.create_bb.data.compat.steamnrails.RailwaysSelectionOverride;
import com.weido.create_bb.data.menu.Entry.StyleMenuHandler;
import com.zurrtum.create.AllBogeyStyles;
import com.zurrtum.create.catnip.data.Pair;
import com.zurrtum.create.content.trains.bogey.AbstractBogeyBlock;
import com.zurrtum.create.content.trains.bogey.AbstractBogeyBlockEntity;
import com.zurrtum.create.content.trains.bogey.AllBogeySizes;
import com.zurrtum.create.content.trains.bogey.BogeySize;
import com.zurrtum.create.content.trains.bogey.BogeyStyle;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public final class BogieStylePacket {
    private BogieStylePacket() {
    }

    public record Serverbound(@Nullable BogeyStyle style, @Nullable BogeySize size, @Nullable BlockPos pos) implements CustomPacketPayload {
        public static final Type<Serverbound> TYPE = new Type<>(BlocksBogies.asResource("c_bogie_style"));

        private static final int MAX_DISTANCE = 20;

        public static final StreamCodec<FriendlyByteBuf, Serverbound> STREAM_CODEC = StreamCodec.ofMember(
            (Serverbound packet, FriendlyByteBuf buf) -> {
                buf.writeIdentifier((packet.style == null ? AllBogeyStyles.STANDARD : packet.style).id);
                buf.writeBoolean(packet.size != null);
                if (packet.size != null) {
                    buf.writeIdentifier(packet.size.id());
                }
                buf.writeBoolean(packet.pos != null);
                if (packet.pos != null) {
                    buf.writeBlockPos(packet.pos);
                }
            },
            (FriendlyByteBuf buf) -> {
                Identifier loc = buf.readIdentifier();
                BogeyStyle style = AllBogeyStyles.BOGEY_STYLES.get(loc);
                BogeySize size = null;
                if (buf.readBoolean()) {
                    Identifier sizeLoc = buf.readIdentifier();
                    size = AllBogeySizes.all().get(sizeLoc);
                }
                BlockPos pos = null;
                if (buf.readBoolean()) {
                    pos = buf.readBlockPos();
                }
                return new Serverbound(style, size, pos);
            }
        );

        @Override
        public Type<? extends CustomPacketPayload> type() {
            return TYPE;
        }

        public void handle(ServerPlayer player) {
            if (style == null || size == null)
                return;

            Level level = player.level();
            if (mayEdit(player, level, pos) && level.getBlockEntity(pos) instanceof AbstractBogeyBlockEntity oldBe) {
                AbstractBogeyBlock<?> newBlock = style.getBlockForSize(size);
                BlockState oldState = level.getBlockState(pos);
                if (newBlock != null && (!isUpsideDown(oldState) || newBlock.canBeUpsideDown())) {
                    CompoundTag oldData = oldBe.getBogeyData();

                    BlockState newState = newBlock.defaultBlockState();
                    for (Property<?> property : propertiesToCopy(oldState))
                        newState = copyProperty(oldState, newState, property);
                    newState = newBlock.getVersion(newState, isUpsideDown(oldState));

                    level.setBlock(pos, newState, 3);
                    if (level.getBlockEntity(pos) instanceof AbstractBogeyBlockEntity newBe) {
                        if (oldData != null && !oldData.isEmpty())
                            newBe.setBogeyData(oldData);
                        newBe.setBogeyStyle(style);
                    }
                }
            }

            if (FabricLoader.getInstance().isModLoaded("railways")) {
                RailwaysSelectionOverride.addStyle(player.getUUID(), Pair.of(style, size));
            } else {
                StyleMenuHandler.addStyle(player.getUUID(), Pair.of(style, size));
            }
        }

        private static boolean mayEdit(ServerPlayer player, Level level, @Nullable BlockPos pos) {
            return pos != null && !player.isSpectator() && player.mayBuild() && level.isLoaded(pos) && pos.closerThan(
                player.blockPosition(),
                MAX_DISTANCE
            );
        }

        private static boolean isUpsideDown(BlockState state) {
            return state.getBlock() instanceof AbstractBogeyBlock<?> bogey && bogey.isUpsideDown(state);
        }

        private static List<Property<?>> propertiesToCopy(BlockState state) {
            if (state.getBlock() instanceof AbstractBogeyBlock<?> bogey)
                return bogey.propertiesToCopy();
            return List.of(BlockStateProperties.HORIZONTAL_AXIS, BlockStateProperties.WATERLOGGED);
        }

        private static <T extends Comparable<T>> BlockState copyProperty(BlockState from, BlockState to, Property<T> property) {
            if (!from.hasProperty(property) || !to.hasProperty(property))
                return to;
            return to.setValue(property, from.getValue(property));
        }
    }
}
