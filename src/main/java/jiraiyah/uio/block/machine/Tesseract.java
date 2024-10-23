package jiraiyah.uio.block.machine;

import jiraiyah.uio.util.block.AbstractMachineBlock;
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
// - Can transfer energy / item / fluid remotely on channels
// - Can accept upgrade for making it work between dimensions
// - Can accept upgrade for increase distance
// - Default distance is 2 Chunks
// - Each upgrade adds 2 extra chunk
// - Max distance is 130 Chunks ( 64 Upgrades * 2 chunks per upgrade + 2 chunks for base)
// - Max distance will be 2080 blocks ( 130 chunks * 16 blocks per chunk)
public class Tesseract extends AbstractMachineBlock
{
    private static final VoxelShape SHAPE = VoxelShapes.cuboid(0, 0, 0, 1, 1, 1);

    public Tesseract(Settings settings)
    {
        super(settings.nonOpaque());
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context)
    {
        return SHAPE;
    }
}