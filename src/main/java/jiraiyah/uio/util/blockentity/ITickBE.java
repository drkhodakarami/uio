package jiraiyah.uio.util.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public interface ITickBE
{
    //Credits for this interface goes to TurtyWurty
    void tick();

    //Credits for this interface goes to TurtyWurty
    static <T extends BlockEntity> BlockEntityTicker<T> createTicker(World world)
    {
        return !world.isClient ? (pworld, pos, state, entity) -> ((ITickBE) entity).tick() : null;
    }

    //Added by Jiraiyah
    @Nullable
    default BlockState getState(World world, BlockPos pos)
    {
        return world != null ? world.getBlockState(pos) : null;
    }
}