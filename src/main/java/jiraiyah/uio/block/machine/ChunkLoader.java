package jiraiyah.uio.block.machine;

import jiraiyah.uio.util.block.AbstractActivatableMachineBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

//TODO : Create Model
//TODO : Create Block Recipe
//TODO : Handle Block Entity
//TODO : Add GUI

// Ideas :
// - The name says everything. It's advance chunk loader
// - It can accept Upgrades to expand the distance chunks
// - The default is just current chunk
// - Each upgrade unlocks and loads one chunk
// - The grid is 9 * 9 chunks (total of 80 Upgrades)
public class ChunkLoader extends AbstractActivatableMachineBlock
{
    private static final VoxelShape SHAPE = VoxelShapes.union(
            VoxelShapes.cuboid(0.0625, 0, 0.0625, 0.9375, 0.125, 0.875),
            VoxelShapes.cuboid(0.1875, 0.125, 0.1875, 0.8125, 0.3125, 0.8125),
            VoxelShapes.cuboid(0.29374999999999996, 0.3125, 0.29374999999999984, 0.6999999999999996, 1, 0.6999999999999998))
                        .simplify();

    public ChunkLoader(Settings settings)
    {
        super(settings.nonOpaque());
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context)
    {
        return SHAPE;
    }
}