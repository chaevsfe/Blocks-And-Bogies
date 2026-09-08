package com.weido.create_bb.mixin;

import com.zurrtum.create.content.trains.bogey.AbstractBogeyBlockEntity;
import com.zurrtum.create.content.trains.bogey.BogeySize;
import com.zurrtum.create.content.trains.bogey.BogeyStyle;
import com.zurrtum.create.content.trains.station.StationBlockEntity;
import com.zurrtum.create.content.trains.track.ITrackBlock;
import com.zurrtum.create.foundation.blockEntity.SmartBlockEntity;
import com.llamalad7.mixinextras.sugar.Local;
import com.zurrtum.create.catnip.data.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.fabricmc.loader.api.FabricLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import com.weido.create_bb.data.menu.Entry.StyleMenuHandler;

@Mixin(StationBlockEntity.class)
public abstract class StationBlockEntityMixin extends SmartBlockEntity {

    private StationBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Inject(method = "trackClicked", at = @At("HEAD"))
    private void storePlayer(Player player, InteractionHand hand, ITrackBlock track, BlockState state, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (!FabricLoader.getInstance().isModLoaded("railways")) {
            StyleMenuHandler.setCurrentPlayer(player.getUUID());
        }
    }

    @Inject(method = "trackClicked", at = @At("RETURN"))
    private void clearPlayer(Player player, InteractionHand hand, ITrackBlock track, BlockState state, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (!FabricLoader.getInstance().isModLoaded("railways")) {
            StyleMenuHandler.setCurrentPlayer(null);
        }
    }

    @Inject(
            method = "trackClicked",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Level;playSound(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V"
            ))
    private void create_bb$setBogeyData(Player player, InteractionHand hand, ITrackBlock track, BlockState state, BlockPos pos, CallbackInfoReturnable<Boolean> cir, @Local(name = "targetPos") BlockPos targetPos) {
        if (!FabricLoader.getInstance().isModLoaded("railways")) {
            Pair<BogeyStyle, BogeySize> styleData = StyleMenuHandler.getStyle(player.getUUID());
            BogeyStyle style = styleData.getFirst();

            if (level != null && level.getBlockEntity(targetPos) instanceof AbstractBogeyBlockEntity bogeyBE) {
                bogeyBE.setBogeyStyle(style);
            }
        }
    }
}
