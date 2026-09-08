package com.weido.create_bb.mixin;

import com.zurrtum.create.content.trains.entity.CarriageContraptionEntity;
import com.zurrtum.create.client.content.trains.entity.CarriageContraptionVisual;
import com.zurrtum.create.client.flywheel.api.visualization.VisualizationContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CarriageContraptionVisual.class)
public class CarriageContraptionVisualMixin {
    @Inject(method = "<init>", at = @At("RETURN"))
    private void onConstruct(VisualizationContext context, CarriageContraptionEntity entity, float partialTick, CallbackInfo ci) {
        ContraptionVisualAccessor accessor = (ContraptionVisualAccessor) this;
        int current = accessor.getLightPaddingBlocks();
        accessor.setLightPaddingBlocks(current + 3);
    }
}