package jiraiyah.uio.blockentity;

import jiraiyah.uio.registry.ModBlockEntities;
import jiraiyah.uio.util.blockentity.ITickBE;
import jiraiyah.uio.util.blockentity.UpdatableBE;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class WaterGeneratingGooBE extends UpdatableBE implements ITickBE
{
    public WaterGeneratingGooBE(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.WATER_GENERATING_GOO, pos, state);
    }

    //TODO : Add Functionality
    @Override
    public void tick()
    {

    }
}