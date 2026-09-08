package com.weido.create_bb;

import com.weido.create_bb.registry.BogieBlockEntities;
import com.weido.create_bb.registry.BogiePackets;
import com.weido.create_bb.registry.BogieStyles;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlocksBogies implements ModInitializer {
    public static final String MOD_ID = "create_bb";
    public static final String MOD_NAME = "Create: Blocks & Bogies";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        BlocksBogiesPlugin.verifyEarlyRegistrationComplete();
        BogieBlockEntities.register();
        BogieStyles.register();
        BogiePackets.register();
        LOGGER.info("{} initializing...", MOD_NAME);
    }

    public static Identifier asResource(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
