package com.weido.create_bb;

import com.weido.create_bb.registry.BogieBlocks;
import com.zurrtum.create.api.registry.CreateRegisterPlugin;

public final class BlocksBogiesPlugin implements CreateRegisterPlugin {
    private static boolean blocksRegistered;

    @Override
    public void onBlockRegister() {
        if (blocksRegistered) {
            throw new IllegalStateException("Create Fly invoked Blocks & Bogies block registration more than once");
        }
        BogieBlocks.register();
        blocksRegistered = true;
    }

    public static void verifyEarlyRegistrationComplete() {
        if (!blocksRegistered) {
            throw new IllegalStateException("Create Fly did not invoke Blocks & Bogies early block registration");
        }
    }
}
