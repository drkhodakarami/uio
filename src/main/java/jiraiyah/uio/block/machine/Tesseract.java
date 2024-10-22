package jiraiyah.uio.block.machine;

import jiraiyah.uio.util.block.AbstractMachineBlock;

//TODO : Create Model
//TODO : Create Block Recipe
//TODO : Handle Block Entity
//TODO : Add GUI

// Ideas :
// - Can transfer energy / item / fluid remotely on channels
// - Can accept upgrade for making it work between dimensions
// - Can accept upgrade for increase distance
// - Default distance is 2 Chunks
// - Each upgrade adds 2 extra chunk
// - Max distance is 130 Chunks ( 64 Upgrades * 2 chunks per upgrade + 2 chunks for base)
// - Max distance will be 2080 blocks ( 130 chunks * 16 blocks per chunk)
public class Tesseract extends AbstractMachineBlock
{
    public Tesseract(Settings settings)
    {
        super(settings.nonOpaque());
    }
}