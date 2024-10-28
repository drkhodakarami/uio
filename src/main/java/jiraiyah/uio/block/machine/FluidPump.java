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
// - It's a combo of pump goo and the concept of bucket filler
// - It will use energy
// - It can accept upgrades to increase: internal energy / fluid capacity / range / speed
// - The default fluid capacity is 1 bucket
// - The default range is 1 block
// - The default speed is 20 tick cooldown
// - The internal energy is used to power the pump and fill the bucket
// - Pump uses 1 energy unit per block pumped
// - The internal energy capacity is 10 units
public class FluidPump extends MachineBase
{
    public FluidPump(Settings settings)
    {
        super(settings);
        CODEC = createCodec(FluidPump::new);
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