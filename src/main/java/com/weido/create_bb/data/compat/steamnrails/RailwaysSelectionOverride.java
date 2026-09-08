package com.weido.create_bb.data.compat.steamnrails;

import com.railwayteam.railways.content.bogey_menu.handler.BogeyMenuHandlerServer;
import com.zurrtum.create.content.trains.bogey.BogeySize;
import com.zurrtum.create.content.trains.bogey.BogeyStyle;
import com.zurrtum.create.catnip.data.Pair;

import java.util.UUID;

public class RailwaysSelectionOverride {
    public static void addStyle(UUID playerId, Pair<?, ?> styleSizePair) {
        Pair<BogeyStyle, BogeySize> typedPair = (Pair<BogeyStyle, BogeySize>) styleSizePair;
        BogeyMenuHandlerServer.addStyle(playerId, typedPair);
    }
}
