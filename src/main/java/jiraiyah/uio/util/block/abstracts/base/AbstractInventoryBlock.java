package jiraiyah.uio.util.block.abstracts.base;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;

public abstract class AbstractInventoryBlock extends Block implements BlockEntityProvider
{
    protected MapCodec<? extends AbstractInventoryBlock> CODEC;

    public AbstractInventoryBlock(Settings settings)
    {
        super(settings);
    }

    @Override
    protected MapCodec<? extends Block> getCodec()
    {
        return CODEC;
    }
}