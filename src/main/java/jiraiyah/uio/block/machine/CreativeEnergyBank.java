package jiraiyah.uio.block.machine;

import jiraiyah.uio.util.block.AbstractMachineBlock;
import net.minecraft.block.Block;

//TODO : Create Model
//TODO : Create Block Recipe
//TODO : Handle Block Entity
//TODO : Add GUI
//TODO : Add Custom Recipe
//TODO : Add Custom Recipe Datagen

// Ideas :
// - Just a creative energy bank without recipe
// - Transfers up to 10_000 energy units per tick
public class CreativeEnergyBank extends AbstractMachineBlock
{
    public CreativeEnergyBank(Settings settings)
    {
        super(settings);
    }
}