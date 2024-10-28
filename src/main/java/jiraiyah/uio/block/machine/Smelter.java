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
// - Uses casts to convert Ingots / gems into different items
// - Uses either lava or energy
// - Priority is energy usage. If there is no energy, it uses lava.
// - Can accept upgrades to increase lava / energy capacity
// - Default lava capacity : 10 buckets
// - Default energy capacity : 1000 unites
public class Smelter extends MachineBase
{
    public Smelter(Settings settings)
    {
        super(settings);
        CODEC = createCodec(Smelter::new);
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