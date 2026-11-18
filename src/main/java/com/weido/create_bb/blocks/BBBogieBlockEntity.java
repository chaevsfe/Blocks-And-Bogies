package com.weido.create_bb.blocks;

import com.zurrtum.create.AllBogeyStyles;
import com.zurrtum.create.content.trains.bogey.AbstractBogeyBlockEntity;
import com.zurrtum.create.content.trains.bogey.BogeyStyle;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;

public class BBBogieBlockEntity extends AbstractBogeyBlockEntity {
    public BBBogieBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public BogeyStyle getDefaultStyle() {
        if (getBlockState().getBlock() instanceof BBBogieBlock bogieBlock)
            return bogieBlock.getDefaultStyle();
        return AllBogeyStyles.STANDARD;
    }

    @Override
    protected void loadAdditional(ValueInput view) {
        super.loadAdditional(view);
        CompoundTag data = getBogeyData();
        if (data.getString(BOGEY_STYLE_KEY).map(Identifier::tryParse).isEmpty())
            data.store(BOGEY_STYLE_KEY, Identifier.CODEC, getDefaultStyle().id);
    }

}
