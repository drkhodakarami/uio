package jiraiyah.uio.event;

import jiraiyah.uio.item.ExcavatorItem;
import jiraiyah.uio.item.HammerItem;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class BeforePlayerBlockBreakListener implements PlayerBlockBreakEvents.Before
{
    private static final Set<BlockPos> HARVESTED_BLOCK = new HashSet<>();

    @Override
    public boolean beforeBlockBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity)
    {
        ItemStack stack = player.getMainHandStack();
        if(player instanceof ServerPlayerEntity sp)
        {
            if (stack.getItem() instanceof HammerItem hammer)
            {
                if (HARVESTED_BLOCK.contains(pos))
                    return true;

                int radius = hammer.getRadius();
                int depth = hammer.getDepth();

                for (BlockPos position : HammerItem.getAreaBlocks(pos, depth, radius, sp))
                {
                    if (pos == position || !hammer.isCorrectForDrops(stack, world.getBlockState(position)))
                        continue;

                    HARVESTED_BLOCK.add(position);
                    sp.interactionManager.tryBreakBlock(position);
                    HARVESTED_BLOCK.remove(position);
                }
            }
            else if(stack.getItem() instanceof ExcavatorItem excavator)
            {
                if(HARVESTED_BLOCK.contains(pos))
                    return true;

                int radius = excavator.getRadius();
                int depth = excavator.getDepth();

                for(BlockPos position : ExcavatorItem.getAreaBlocks(pos, depth, radius, sp))
                {
                    if(pos == position || !excavator.isCorrectForDrops(stack, world.getBlockState(position)))
                        continue;

                    HARVESTED_BLOCK.add(position);
                    sp.interactionManager.tryBreakBlock(position);
                    HARVESTED_BLOCK.remove(position);
                }
            }
        }
        return true;
    }
}