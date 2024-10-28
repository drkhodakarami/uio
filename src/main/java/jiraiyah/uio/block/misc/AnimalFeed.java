package jiraiyah.uio.block.misc;

import jiraiyah.uio.util.block.abstracts.base.AbstractInventoryBlock;
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

//TODO : Create Model
//TODO : Create Block Recipe
//TODO : Handle Block Entity
//TODO : Add GUI

// Ideas :
// - It should have inventory that stores animal food
// - It should have many feeding slots one per food type
// - Every tick, it will find animals around itself and feed them if there is proper food in the feeding slot
// - If there is food stored in the inventory slots, it will refill the feeding slots
// - It will have upgrade slots that will increase the distance it can feed animals
// - The default distance is one block around itself.
// - The biggest possible distance is 8 blocks radius (makes 17 * 17 square)
public class AnimalFeed extends AbstractInventoryBlock
{
    private static VoxelShape SHAPE;

    public AnimalFeed(Settings settings)
    {
        super(settings.nonOpaque());
        SHAPE = VoxelShapes.union(
                                   VoxelShapes.cuboid(0.0003125, 0, 0.0003125, 0.9996875000000001, 0.0625, 0.9996875000000001),
                                   VoxelShapes.cuboid(0, 0.375, 0.9375, 1, 0.5, 1),
                                   VoxelShapes.cuboid(0, 0.375, 0, 1, 0.5, 0.0625),
                                   VoxelShapes.cuboid(0.9375, 0.375, 0.0625, 1, 0.5, 0.9375),
                                   VoxelShapes.cuboid(0, 0.375, 0.0625, 0.0625, 0.5, 0.9375),
                                   VoxelShapes.cuboid(0.0625, 0.125, 0.0624375, 0.9375, 0.1875, 0.06249999999999999),
                                   VoxelShapes.cuboid(0.0624375, 0.125, 0.0625, 0.06249999999999999, 0.1875, 0.9375),
                                   VoxelShapes.cuboid(0.0625, 0.125, 0.9375625, 0.9375, 0.1875, 0.9376249999999999),
                                   VoxelShapes.cuboid(0.9375625, 0.125, 0.0625, 0.9376249999999999, 0.1875, 0.9375),
                                   VoxelShapes.cuboid(0.0624375, 0.3125, 0.0625, 0.06249999999999999, 0.375, 0.9375),
                                   VoxelShapes.cuboid(0.0625, 0.3125, 0.9375625, 0.9375, 0.375, 0.9376249999999999),
                                   VoxelShapes.cuboid(0.0625, 0.3125, 0.0624375, 0.9375, 0.375, 0.0624375),
                                   VoxelShapes.cuboid(0.9375625, 0.3125, 0.0625, 0.9376249999999999, 0.375, 0.9375),
                                   VoxelShapes.cuboid(0, 0.0003125, 0, 0.0625, 0.1253125, 1),
                                   VoxelShapes.cuboid(0.9375, 0.0003125, 0, 1, 0.1253125, 1),
                                   VoxelShapes.cuboid(0.0625, 0.0003125, 0.9375, 0.9375, 0.1253125, 1),
                                   VoxelShapes.cuboid(0.0625, 0.0003125, 0, 0.9375, 0.1253125, 0.0625),
                                   VoxelShapes.cuboid(0.0625, 0.1875, 0, 0.9375, 0.3125, 0.0625),
                                   VoxelShapes.cuboid(0.0625, 0.1875, 0.9375, 0.9375, 0.3125, 1),
                                   VoxelShapes.cuboid(0, 0.1875, 0.0625, 0.0625, 0.3125, 0.9375),
                                   VoxelShapes.cuboid(0.9375, 0.1875, 0.0625, 1, 0.3125, 0.9375),
                                   VoxelShapes.cuboid(0, 0.125, 0, 0.0625, 0.375, 0.0625),
                                   VoxelShapes.cuboid(0, 0.125, 0.9375, 0.0625, 0.375, 1),
                                   VoxelShapes.cuboid(0.9375, 0.125, 0.9375, 1, 0.375, 1),
                                   VoxelShapes.cuboid(0.9375, 0.125, 0, 1, 0.375, 0.0625),
                                   VoxelShapes.cuboid(0.0628125, 0.3125, 0.0628125, 0.9371875000000001, 0.375, 0.9371875000000001))
                           .simplify();
        CODEC = createCodec(AnimalFeed::new);
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