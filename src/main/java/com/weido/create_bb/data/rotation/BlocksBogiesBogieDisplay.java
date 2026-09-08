package com.weido.create_bb.data.rotation;

import com.weido.create_bb.data.Constants;
import com.weido.create_bb.renderers.unified.BogeyDisplay;
import com.zurrtum.create.catnip.nbt.NBTHelper;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;

public abstract class BlocksBogiesBogieDisplay implements BogeyDisplay {
    public abstract void update(boolean forwards, float wheelAngle);

    @Override
    public void update(CompoundTag bogeyData, float wheelAngle) {
        update(isForwards(bogeyData), wheelAngle);
    }

    public static boolean isForwards(CompoundTag bogeyData) {
        boolean isForwards = bogeyData.getBooleanOr(Constants.BOGIE_DIRECTION_KEY, false);

        Direction direction = bogeyData.contains(Constants.BOGIE_ASSEMBLY_DIRECTION_KEY)
            ? NBTHelper.readEnum(bogeyData, Constants.BOGIE_ASSEMBLY_DIRECTION_KEY, Direction.class)
            : Direction.NORTH;

        return isDirectionPositive(direction) != isForwards;
    }

    public static boolean isDirectionPositive(Direction direction) {
        return switch (direction) {
            case NORTH, WEST, UP -> true;
            case SOUTH, DOWN, EAST -> false;
        };
    }
}
