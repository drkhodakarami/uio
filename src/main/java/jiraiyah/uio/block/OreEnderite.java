package jiraiyah.uio.block;

import jiraiyah.uio.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class OreEnderite extends Block
{
    public OreEnderite(Settings settings)
    {
        super(settings);
    }

    @Override
    public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion)
    {
        world.setBlockState(pos, ModBlocks.ORE_END_ENDERITE_CRACKED.getDefaultState());
    }
}