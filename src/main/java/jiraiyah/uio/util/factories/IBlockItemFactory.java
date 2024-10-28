package jiraiyah.uio.util.factories;

import net.minecraft.block.Block;

@FunctionalInterface
public interface IBlockItemFactory<U, R>
{
    R apply(Block block, U settings);
}