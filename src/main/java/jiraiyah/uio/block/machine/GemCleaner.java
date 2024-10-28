package jiraiyah.uio.block.machine;

import jiraiyah.uio.block.base.MachineBase;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

//TODO : Create Model
//TODO : Create Block Recipe
//TODO : Handle Block Entity
//TODO : Add GUI
//TODO : Add Custom Recipe
//TODO : Add Custom Recipe Datagen

// Ideas :
// - It uses water
// - It will clean raw gem and give 3 gems per raw item
// - It will use different amount of water to clean different types of gems
// - It can accept upgrades for water / speed
// - Default water capacity is 10 buckets
// - Default speed changed for gems but the smallest time is 10 seconds
public class GemCleaner extends MachineBase
{
    public GemCleaner(Settings settings)
    {
        super(settings);
        CODEC = createCodec(GemCleaner::new);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state)
    {
        return null;
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type)
    {
        return super.getTicker(world, state, type);
    }
}