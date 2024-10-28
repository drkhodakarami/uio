package jiraiyah.uio.block.misc;

import jiraiyah.uio.util.block.abstracts.base.AbstractInventoryBlock;
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
// - It will simply strip the wooden planks from the block and leave the stripped logs behind.
// - It only has one input slot and one output slot
// - No energy / item / fluid usage
public class WoodStripper extends AbstractInventoryBlock
{
    public WoodStripper(Settings settings)
    {
        super(settings);
        CODEC = createCodec(WoodStripper::new);
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