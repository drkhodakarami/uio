package jiraiyah.uio.block.base;

import com.mojang.serialization.MapCodec;
import jiraiyah.uio.registry.ModItems;
import jiraiyah.uio.util.block.abstracts.base.AbstractActivatableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class GooBase extends AbstractActivatableBlock implements BlockEntityProvider
{
    public static MapCodec<? extends GooBase> CODEC;

    public GooBase(Settings settings)
    {
        super(settings);
    }

    @Override
    protected MapCodec<? extends Block> getCodec()
    {
        return CODEC;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit)
    {
        return ActionResult.SUCCESS;
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit)
    {
        if(!stack.isOf(ModItems.ROD_COPPER))
            return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
        world.setBlockState(pos, state.with(ACTIVATED, true), Block.NOTIFY_ALL);
        player.incrementStat(Stats.USED.getOrCreateStat(stack.getItem()));
        world.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.2F, world.getRandom().nextFloat() * 0.6F + 0.8F);
        if(!player.isCreative())
            stack.decrement(1);
        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }

    @Override
    protected boolean onSyncedBlockEvent(BlockState state, World world, BlockPos pos, int type, int data) {
        super.onSyncedBlockEvent(state, world, pos, type, data);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity != null && blockEntity.onSyncedBlockEvent(type, data);
    }

    @Nullable
    protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> validateTicker(
            BlockEntityType<A> givenType, BlockEntityType<E> expectedType, BlockEntityTicker<A> ticker)
    {
        return expectedType == givenType ? ticker : null;
    }
}