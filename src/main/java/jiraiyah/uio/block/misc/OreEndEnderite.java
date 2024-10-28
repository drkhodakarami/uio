package jiraiyah.uio.block.misc;

import jiraiyah.uio.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.explosion.Explosion;

public class OreEndEnderite extends Block
{
    public OreEndEnderite(Settings settings)
    {
        super(settings);
    }

    @Override
    public void onDestroyedByExplosion(ServerWorld world, BlockPos pos, Explosion explosion)
    {
        world.setBlockState(pos, ModBlocks.ORE_END_ENDERITE_CRACKED.getDefaultState());
    }
}