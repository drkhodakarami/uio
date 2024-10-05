package jiraiyah.uio.block;

import net.minecraft.block.Block;

//TODO : Create Model
//TODO : Create Block Recipe
//TODO : Handle Block Entity
//TODO : Add GUI

// Ideas :
// - It breaks blocks sitting in front of it
// - Internal inventory is 3 * 9 slots
// - It uses energy for breaking each block
// - It can accept speed upgrades
// - The default speed is 1 break per 10 seconds
// - It can speed up to 1 break per tick (total of 16 upgrades)
// ==> 10 Sec => 9 Sec => 8 Sec => 7 Sec => 6 Sec => 5 Sec => 4 Sec => 3 Sec => 2 Sec => 1 Sec
// ==> 16 Ticks => 12 Tick => 8 Tick => 4 Tick => 2 Tick => 1 Tick
public class BlockBreaker extends Block
{
    public BlockBreaker(Settings settings)
    {
        super(settings);
    }
}