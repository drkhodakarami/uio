package jiraiyah.uio.block.machine;

import jiraiyah.uio.block.base.MachineBase;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

//TODO : Create Model
//TODO : Create Block Recipe
//TODO : Handle Block Entity
//TODO : Add GUI

// Ideas :
// - It's opposite concept of block breaker. It just puts a block from inventory, in front of itself
// - The inventory size, energy usage, and upgrades are the same as block breaker.
public class BlockPlacer extends MachineBase
{
    public BlockPlacer(Settings settings)
    {
        super(settings);
        CODEC = createCodec(BlockPlacer::new);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state)
    {
        return null;
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type)
    {
        return super.getTicker(world, state, type);
    }
}