package jiraiyah.uio.block;

import net.minecraft.block.Block;

//TODO : Create Model
//TODO : Handle Block Entity
//TODO : Add GUI

// Ideas :
// - Will pulse redstone signal with the 15 power
// - The default speed is 1 pulse per second
// - Can be set to go as fast as 1 pulse per tick or as slow as 1 pulse per minute
// - The interface provides buttons to increase / decrease the speed
// ==> 1 / 5 / 10 / 100 tick buttons
public class RedstoneClock extends Block
{
    public RedstoneClock(Settings settings)
    {
        super(settings);
    }
}