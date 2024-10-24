package jiraiyah.uio.util.interfaces;

import net.minecraft.block.Block;

public interface BlockItemRegisterFunction<U, R>
{
    R apply(Block block, U settings);
}