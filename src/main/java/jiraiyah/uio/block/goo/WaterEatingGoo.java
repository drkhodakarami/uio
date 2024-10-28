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

public class WaterEatingGoo extends GooBase
{
    public WaterEatingGoo(Settings settings)
    {
        super(settings);
        CODEC = createCodec(WaterEatingGoo::new);
    }

    //region Block Entity Provider
    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state)
    {
        //return new WaterEatingGooBE(pos, state);
        return ModBlockEntities.WATER_EATING_GOO.instantiate(pos, state);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type)
    {
        //return validateTicker(type, ModBlockEntities.WATER_EATING_GOO, WaterEatingGooBE::tick);
        return ITickBE.createTicker(world);
    }
    //endregion
}