package jiraiyah.uio.block.machine;

import jiraiyah.uio.util.block.AbstractActivatableMachineBlock;

//TODO : Create Model
//TODO : Create Block Recipe
//TODO : Handle Block Entity
//TODO : Add GUI

// Ideas :
// - It's opposite concept of block breaker. It just puts a block from inventory, in front of itself
// - The inventory size, energy usage, and upgrades are the same as block breaker.
public class BlockPlacer extends AbstractActivatableMachineBlock
{
    public BlockPlacer(Settings settings)
    {
        super(settings);
    }
}