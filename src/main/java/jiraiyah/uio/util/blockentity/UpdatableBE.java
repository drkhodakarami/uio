package jiraiyah.uio.util.blockentity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

//Credits for this interface goes to TurtyWurty
public class UpdatableBE extends BlockEntity
{
    public UpdatableBE(BlockEntityType<?> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
    }

    public void update()
    {
        markDirty();

        if(this.world != null)
            this.world.updateListeners(this.pos, getCachedState(), getCachedState(), Block.NOTIFY_ALL);
    }
}