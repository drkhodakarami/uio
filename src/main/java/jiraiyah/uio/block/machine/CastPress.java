package jiraiyah.uio.block.machine;

import jiraiyah.uio.util.block.abstracts.base.AbstractInventoryBlock;
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
// - It simply presses gold into cast items
// - We have total of 18 casts available
// - One input slot for gold / wood ingot
// - one output slot for cast item
public class CastPress extends AbstractInventoryBlock
{
    public CastPress(Settings settings)
    {
        super(settings);
        CODEC = createCodec(CastPress::new);
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