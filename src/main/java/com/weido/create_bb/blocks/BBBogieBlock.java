package com.weido.create_bb.blocks;

import com.zurrtum.create.AllBlocks;
import com.zurrtum.create.AllTrackMaterials;
import com.zurrtum.create.api.schematic.requirement.SpecialBlockItemRequirement;
import com.zurrtum.create.content.trains.bogey.AbstractBogeyBlock;
import com.zurrtum.create.content.trains.bogey.BogeySize;
import com.zurrtum.create.content.trains.bogey.BogeyStyle;
import com.zurrtum.create.foundation.block.IBE;
import com.zurrtum.create.foundation.block.ProperWaterloggedBlock;

import com.weido.create_bb.data.BogieFunctionality;
import com.weido.create_bb.registry.BogieBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class BBBogieBlock extends AbstractBogeyBlock <BBBogieBlockEntity>
    implements IBE<BBBogieBlockEntity>, ProperWaterloggedBlock, SpecialBlockItemRequirement {

    private final Supplier<BogeyStyle> defaultStyle;

    protected BBBogieBlock(Properties props, Supplier<BogeyStyle> defaultStyle, BogeySize size) {
        super(props, size);
        this.defaultStyle = defaultStyle;
        registerDefaultState(defaultBlockState().setValue(WATERLOGGED, false));
    }

    @Override
    protected InteractionResult onInteractWithBogey(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        return BogieFunctionality.BogeyMenuInteraction(level, pos, player, hand);
    }

    @Override
    public Identifier getTrackType(BogeyStyle style) {
        return AllTrackMaterials.ANDESITE.getId();
    }

    @Override
    public double getWheelPointSpacing() {
        return 2;
    }

    @Override
    public double getWheelRadius() {
        return 6.5 / 16d;
    }

    @Override
    public Vec3 getConnectorAnchorOffset() {
        return new Vec3(0, 7 / 32f, 1);
    }

    @Override
    public BogeyStyle getDefaultStyle() {
        return defaultStyle.get();
    }

    @Override
    protected @NotNull ItemStack getCloneItemStack(@NotNull LevelReader level, @NotNull BlockPos pos, @NotNull BlockState state, boolean includeData) {
        return new ItemStack(AllBlocks.RAILWAY_CASING);
    }

    @Override
    public Class<BBBogieBlockEntity> getBlockEntityClass() {
        return BBBogieBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends BBBogieBlockEntity> getBlockEntityType() {
        return BogieBlockEntities.BOGEY;
    }
}
