package jiraiyah.uio.blockentity;

import jiraiyah.uio.registry.ModBlockEntities;
import jiraiyah.uio.util.blockentity.ITickBE;
import jiraiyah.uio.util.blockentity.UpdatableBE;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class AirGooBombBE extends UpdatableBE implements ITickBE
{
    public AirGooBombBE(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.AIR_GOO_BOMB, pos, state);
    }

    //TODO : Add Functionality
    @Override
    public void tick()
    {

    }
}