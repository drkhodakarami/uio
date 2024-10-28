package jiraiyah.uio.blockentity;

import jiraiyah.uio.registry.ModBlockEntities;
import jiraiyah.uio.util.blockentity.ITickBE;
import jiraiyah.uio.util.blockentity.UpdatableBE;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class StoneGooBombBE extends UpdatableBE implements ITickBE
{
    public StoneGooBombBE(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.STONE_GOO_BOMB, pos, state);
    }

    //TODO : Add Functionality
    @Override
    public void tick()
    {

    }
}