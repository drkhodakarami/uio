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

//idea: This will create a closed wall, safe tunnel to walk inside it.
public class BridgeGoo extends GooBase
{
    public BridgeGoo(Settings settings)
    {
        super(settings);
        CODEC = createCodec(BridgeGoo::new);
    }

    //region Block Entity Provider
    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state)
    {
        return ModBlockEntities.BRIDGE_GOO.instantiate(pos, state);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type)
    {
        return ITickBE.createTicker(world);
    }
    //endregion
}