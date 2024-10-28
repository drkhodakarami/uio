package jiraiyah.uio.blockentity;

import jiraiyah.uio.registry.ModBlockEntities;
import jiraiyah.uio.util.blockentity.ITickBE;
import jiraiyah.uio.util.blockentity.UpdatableBE;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class TunnelingGooBE extends UpdatableBE implements ITickBE
{
    public TunnelingGooBE(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.TUNNELING_GOO, pos, state);
    }

    //TODO : Add Functionality
    @Override
    public void tick()
    {

    }
}