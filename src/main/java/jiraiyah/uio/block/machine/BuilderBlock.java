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
// - It reads a printed blueprint.
// - It has 3 * 9 inventory slots for building materials.
// - It will put the blocks in the world based on the schema
// - It uses energy
// - It can use upgrades
// - The base speed is 1 block per second. It can go up to 1 block every 2 ticks.
// 20 Ticks => 16 Ticks => 12 Ticks => 8 Ticks => 4 Ticks => 2 Ticks

public class BuilderBlock extends MachineBase
{
    public BuilderBlock(Settings settings)
    {
        super(settings);
        CODEC = createCodec(BuilderBlock::new);
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