package com.weido.create_bb.mixin;

import com.zurrtum.create.client.model.obj.ObjMaterialLibrary;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "com.zurrtum.create.client.model.obj.ObjGeometry$ModelMesh", remap = false)
public abstract class ObjGeometryModelMeshMixin {
    @Shadow
    public ObjMaterialLibrary.Material mat;

    @Inject(method = "addQuads", at = @At("HEAD"), cancellable = true, remap = false)
    private void create_bb$skipUntexturedFaces(CallbackInfo ci) {
        if (mat != null && mat.diffuseColorMap == null)
            ci.cancel();
    }
}
