package jiraiyah.uio.block.machine;

import jiraiyah.uio.util.block.AbstractActivatableMachineBlock;
import net.minecraft.block.Block;

//TODO : Create Model
//TODO : Create Block Recipe
//TODO : Handle Block Entity
//TODO : Add GUI
//TODO : Add Custom Recipe
//TODO : Add Custom Recipe Datagen

// Ideas :
// - Uses casts to convert Ingots / gems into different items
// - Uses either lava or energy
// - Priority is energy usage. If there is no energy, it uses lava.
// - Can accept upgrades to increase lava / energy capacity
// - Default lava capacity : 10 buckets
// - Default energy capacity : 1000 unites
public class Smelter extends AbstractActivatableMachineBlock
{
    public Smelter(Settings settings)
    {
        super(settings);
    }
}