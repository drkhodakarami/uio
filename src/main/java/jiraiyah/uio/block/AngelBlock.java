package jiraiyah.uio.block;

import jiraiyah.uio.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AngelBlock extends Block
{
    public AngelBlock(Settings settings)
    {
        super(settings);
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player)
    {
        if(!player.isCreative())
            player.getInventory().insertStack(ModItems.ANGEL_BLOCK_ITEM.getDefaultStack());
        return super.onBreak(world, pos, state, player);
    }
}