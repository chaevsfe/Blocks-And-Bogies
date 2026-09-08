package com.weido.create_bb;

import com.weido.create_bb.data.menu.ClippedEntityBlockRenderer;
import com.weido.create_bb.data.packets.BogieClientPackets;
import com.weido.create_bb.registry.BogieBlockEntities;
import com.weido.create_bb.registry.BogiePartials;
import com.weido.create_bb.renderers.BogieStyleRenders;
import com.zurrtum.create.client.AllBlockEntityRenders;
import com.zurrtum.create.client.content.trains.bogey.BogeyBlockEntityRenderer;
import com.zurrtum.create.client.content.trains.bogey.BogeyBlockEntityVisual;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.PictureInPictureRendererRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.network.chat.Component;

public class BlocksBogiesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BogiePartials.init();
        BogieStyleRenders.register();
        AllBlockEntityRenders.visual(BogieBlockEntities.BOGEY, BogeyBlockEntityRenderer::new, BogeyBlockEntityVisual::new);
        BogieClientPackets.register();
        PictureInPictureRendererRegistry.register(context -> new ClippedEntityBlockRenderer());
        registerBuiltinPack("brassless_bogies", "Blocks & Bogies: Brassless Bogies");
    }

    private static void registerBuiltinPack(String id, String name) {
        ModContainer mod = FabricLoader.getInstance().getModContainer(BlocksBogies.MOD_ID).orElseThrow();
        ResourceManagerHelper.registerBuiltinResourcePack(BlocksBogies.asResource(id), mod, Component.literal(name), ResourcePackActivationType.NORMAL);
    }
}
