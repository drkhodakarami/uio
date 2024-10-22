package jiraiyah.uio.block.machine;

import jiraiyah.uio.util.block.AbstractActivatableMachineBlock;

//TODO : Create Model
//TODO : Create Block Recipe
//TODO : Handle Block Entity
//TODO : Add GUI

// Ideas :
// - The name says everything. It's advance chunk loader
// - It can accept Upgrades to expand the distance chunks
// - The default is just current chunk
// - Each upgrade unlocks and loads one chunk
// - The grid is 9 * 9 chunks (total of 80 Upgrades)
public class ChunkLoader extends AbstractActivatableMachineBlock
{
    public ChunkLoader(Settings settings)
    {
        super(settings.nonOpaque());
    }
}