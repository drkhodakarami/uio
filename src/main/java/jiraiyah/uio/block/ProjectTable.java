package jiraiyah.uio.block;

import net.minecraft.block.Block;

//TODO : Create Model
//TODO : Create Block Recipe
//TODO : Handle Block Entity
//TODO : Add GUI

// Ideas :
// - This is an old concept from red power mod
// - It's a crafting table that remembers the recipe
// - Has internal inventory of 2 * 9 slots
// - Can't be automated with redstone, only manual for repetitive recipes you want
public class ProjectTable extends Block
{
    public ProjectTable(Settings settings)
    {
        super(settings);
    }
}