package jiraiyah.uio.blockentity;

import jiraiyah.uio.registry.ModBlockEntities;
import jiraiyah.uio.util.blockentity.ITickBE;
import jiraiyah.uio.util.blockentity.UpdatableBE;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class WaterEatingGooBE extends UpdatableBE implements ITickBE
{
    public WaterEatingGooBE(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.WATER_EATING_GOO, pos, state);
    }

    //TODO : Add Functionality
    @Override
    public void tick()
    {

    }
}