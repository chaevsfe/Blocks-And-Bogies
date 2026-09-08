package com.weido.create_bb.mixin;

import com.zurrtum.create.catnip.data.Pair;
import com.zurrtum.create.content.trains.bogey.AllBogeySizes;
import com.zurrtum.create.content.trains.bogey.BogeySize;
import com.zurrtum.create.content.trains.bogey.BogeyStyle;
import com.zurrtum.create.content.trains.track.TrackBlock;
import com.zurrtum.create.content.trains.track.TrackShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.fabricmc.loader.api.FabricLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.weido.create_bb.data.menu.Entry.StyleMenuHandler;
@Mixin(TrackBlock.class)
public class TrackBlockMixin {
    @Inject(method = "getBogeyAnchor", at = @At("HEAD"), cancellable = true)
    private void placeCustomStyle(BlockGetter world, BlockPos pos, BlockState state, CallbackInfoReturnable<BlockState> cir) {
        if (!FabricLoader.getInstance().isModLoaded("railways")) {
            if (StyleMenuHandler.getCurrentPlayer() == null)
                return;
            Pair<BogeyStyle, BogeySize> styleData = StyleMenuHandler.getStyle(StyleMenuHandler.getCurrentPlayer());
            BogeyStyle style = styleData.getFirst();


            BogeySize size = styleData.getSecond();
            int escape = AllBogeySizes.all().size();
            while (!style.validSizes().contains(size)) {
                if (escape < 0)
                    return;
                size = size.nextBySize();
                escape--;
            }
            Block block = style.getBlockForSize(size);
            cir.setReturnValue(
                    block.defaultBlockState()
                            .setValue(BlockStateProperties.HORIZONTAL_AXIS,
                                    state.getValue(TrackBlock.SHAPE) == TrackShape.XO ? Direction.Axis.X : Direction.Axis.Z)
            );
        }
    }
}
