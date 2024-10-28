package jiraiyah.uio.block.energy;

import jiraiyah.uio.block.base.EnergyBankBase;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

//TODO : Accepts and Transfers Energy
//TODO : Create Model
//TODO : Create Block Recipe
//TODO : Handle Block Entity
//TODO : Add GUI

// Ideas :
// - It can store generated energy
// - It can transfer energy around if needed
// - It will have upgrade slots to increase the capacity
// - It will draw the capacity and stored amount in world
// - It will have enabled / disabled slots for directions in/out
public class BatteryBank extends EnergyBankBase
{
    public BatteryBank(Settings settings)
    {
        super(settings);
        CODEC = createCodec(BatteryBank::new);
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