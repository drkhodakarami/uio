package jiraiyah.uio.block.machine;

import jiraiyah.uio.util.block.AbstractMachineBlock;
import net.minecraft.block.Block;

//TODO : Create Model
//TODO : Create Block Recipe
//TODO : Handle Block Entity
//TODO : Add GUI

// Ideas :
// - It simply presses gold into cast items
// - We have total of 18 casts available
// - One input slot for gold / wood ingot
// - one output slot for cast item
public class CastPress extends AbstractMachineBlock
{
    public CastPress(Settings settings)
    {
        super(settings);
    }
}