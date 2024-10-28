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
// - It will read and list all the available schemas from game folder
// - You will choose a schema from the list (maybe)
// - It will print the schema on an empty blueprint to get the printed one
// - You can use the printed blueprint in builders to build your structure
// - The process is slow (takes 1 minute per print)
public class Printer extends AbstractInventoryBlock
{
    public Printer(Settings settings)
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