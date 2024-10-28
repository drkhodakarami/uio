package jiraiyah.uio.block.energy;

import jiraiyah.uio.util.block.abstracts.machine.AbstractEnergyMachineBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SolarPanel extends AbstractEnergyMachineBlock
{
    private static VoxelShape SHAPE;

    public SolarPanel(Settings settings)
    {
        super(settings.nonOpaque());
        SHAPE = VoxelShapes.union(
                                   VoxelShapes.cuboid(0.0625, 0.4375, 0.19375, 0.9375, 0.9868125, 0.7625),
                                   VoxelShapes.cuboid(0.125, 0, 0.1875, 0.875, 0.0625, 0.8125),
                                   VoxelShapes.cuboid(0.2500625, 0.616272553118655, 0.48640973553180533, 0.7500625, 0.741272553118655, 0.6114097355318053),
                                   VoxelShapes.cuboid(0.4375, 0.0625, 0.4375, 0.5625, 0.64375, 0.5625),
                                   VoxelShapes.cuboid(0.40625, 0.40625, 0.96875, 0.59375, 0.59375, 1),
                                   VoxelShapes.cuboid(0.46875, 0.46875, 0.559375, 0.53125, 0.53125, 0.9968125),
                                   VoxelShapes.cuboid(0.00125, 0.46875, 0.46875, 0.4386875, 0.53125, 0.53125),
                                   VoxelShapes.cuboid(0, 0.40625, 0.40625, 0.03125, 0.59375, 0.59375),
                                   VoxelShapes.cuboid(0.559375, 0.46875, 0.46875, 0.9968125, 0.53125, 0.53125),
                                   VoxelShapes.cuboid(0.96875, 0.40625, 0.40625, 1, 0.59375, 0.59375))
                           .simplify();
        CODEC = createCodec(SolarPanel::new);
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

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context)
    {
        return SHAPE;
    }
}