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
// - Pulverizes ingots into dusts
// - Uses energy per tick for pulverizing
// - Can accept upgrades for speed / energy
// - Speed changes based on the ingot type
public class Pulverizer extends AbstractActivatableMachineBlock
{
    public Pulverizer(Settings settings)
    {
        super(settings);
    }
}