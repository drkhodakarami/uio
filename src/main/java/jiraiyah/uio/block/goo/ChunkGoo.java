package jiraiyah.uio.block.goo;

import jiraiyah.uio.block.base.GooBase;
import jiraiyah.uio.registry.ModBlockEntities;
import jiraiyah.uio.util.blockentity.ITickBE;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

//TODO : Make goo blocks functional

//idea: Destroy a chunk and empty it from blocks, leave behind only valuable blocks.
public class ChunkGoo extends GooBase
{
    public ChunkGoo(Settings settings)
    {
        super(settings);
        CODEC = createCodec(ChunkGoo::new);
    }

    //region Block Entity Provider
    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state)
    {
        return ModBlockEntities.CHUNK_GOO.instantiate(pos, state);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type)
    {
        return ITickBE.createTicker(world);
    }
    //endregion
}