package jiraiyah.uio.block.machine;

import jiraiyah.uio.util.block.AbstractMachineBlock;
import net.minecraft.block.Block;

//TODO : Accepts and Transfers Energy
//TODO : Create Model
//TODO : Create Block Recipe
//TODO : Handle Block Entity
//TODO : Add GUI

// Ideas :
// - It can store generated energy
// - It can transfer energy around if needed
// - It will have upgrade slots to increase the capacity
// - It will draw the capacity and stored amount in world
// - It will have enabled / disabled slots for directions in/out
public class BatteryBank extends AbstractMachineBlock
{
    public BatteryBank(Settings settings)
    {
        super(settings);
    }
}