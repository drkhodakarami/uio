package jiraiyah.uio.block.machine;

import jiraiyah.uio.util.block.AbstractActivatableMachineBlock;

//TODO : Create Model
//TODO : Create Block Recipe
//TODO : Handle Block Entity
//TODO : Add GUI

// Ideas :
// - It's a combo of pump goo and the concept of bucket filler
// - It will use energy
// - It can accept upgrades to increase: internal energy / fluid capacity / range / speed
// - The default fluid capacity is 1 bucket
// - The default range is 1 block
// - The default speed is 20 tick cooldown
// - The internal energy is used to power the pump and fill the bucket
// - Pump uses 1 energy unit per block pumped
// - The internal energy capacity is 10 units
public class FluidPump extends AbstractActivatableMachineBlock
{
    public FluidPump(Settings settings)
    {
        super(settings);
    }
}