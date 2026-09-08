package com.weido.create_bb.data.compat.steamnrails;

import com.railwayteam.railways.content.bogey_menu.BogeyMenuScreen;
import com.zurrtum.create.client.foundation.gui.AllIcons;
import com.zurrtum.create.client.foundation.gui.widget.IconButton;
import com.zurrtum.create.client.catnip.gui.ScreenOpener;
import com.zurrtum.create.client.catnip.gui.widget.AbstractSimiWidget;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class MenuSwitchButton {
    private static BlockPos targetPos;
    private static ResourceKey<Level> targetLevel;

    public static @Nullable BlockPos getTargetPos() {
        if (targetPos != null && !Objects.equals(currentLevel(), targetLevel))
            clearTargetPos();
        return targetPos;
    }

    public static void setTargetPos(@Nullable BlockPos pos) {
        if (pos == null) {
            clearTargetPos();
            return;
        }
        targetPos = pos;
        targetLevel = currentLevel();
    }

    public static void clearTargetPos() {
        targetPos = null;
        targetLevel = null;
    }

    private static @Nullable ResourceKey<Level> currentLevel() {
        Minecraft minecraft = Minecraft.getInstance();
        return minecraft.level == null ? null : minecraft.level.dimension();
    }

    public static IconButton create(int x, int y, BlockPos targetPos, Runnable onMenuSwitch) {
        IconButton menuSwitchButton = new IconButton(x, y, AllIcons.I_DICE)
                .withCallback(() -> {
                    BogeyMenuScreen screen = new BogeyMenuScreen();
                    setTargetPos(targetPos);
                    ScreenOpener.open(screen);
                    onMenuSwitch.run();
                });
        menuSwitchButton.setToolTip(Component.translatable("create_bb.tooltips.switch_to_bogey_menu").withStyle(s -> s.withColor(AbstractSimiWidget.HEADER_RGB.getRGB())));
        return menuSwitchButton;
    }
}
