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

// Ideas :
// - This is an old concept from red power mod
// - It's a crafting table that remembers the recipe
// - Has internal inventory of 2 * 9 slots
// - Can't be automated with redstone, only manual for repetitive recipes you want
public class ProjectTable extends AbstractInventoryBlock
{
    public ProjectTable(Settings settings)
    {
        super(settings.nonOpaque());
        CODEC = createCodec(Printer::new);
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