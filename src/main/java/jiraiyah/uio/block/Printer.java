package jiraiyah.uio.block;

import net.minecraft.block.Block;

//TODO : Create Model
//TODO : Create Block Recipe
//TODO : Handle Block Entity
//TODO : Add GUI

// Ideas :
// - It will read and list all the available schemas from game folder
// - You will choose a schema from the list (maybe)
// - It will print the schema on an empty blueprint to get the printed one
// - You can use the printed blueprint in builders to build your structure
// - The process is slow (takes 1 minute per print)
public class Printer extends Block
{
    public Printer(Settings settings)
    {
        super(settings);
    }
}