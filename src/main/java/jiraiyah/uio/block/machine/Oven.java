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
// - It will make Alloys from Alloy Dusts
// - It will use Lava to heat up the Alloys
// - It can accept upgrade for internal lava tank capacity
public class Oven extends AbstractActivatableMachineBlock
{
    public Oven(Settings settings)
    {
        super(settings);
    }
}