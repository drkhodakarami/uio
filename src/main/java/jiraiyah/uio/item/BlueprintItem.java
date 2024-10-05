package jiraiyah.uio.item;

import net.minecraft.item.Item;

//TODO : Add Functionality

// Ideas :
// - It's the printed version of blueprint. The empty one is a simple item without class
// - It's responsible for carrying around the nbt data of the chosen schema structure
// - It can be used in builder to build the structure
// - It can't be cleaned after printing
public class BlueprintItem extends Item
{
    public BlueprintItem(Settings settings)
    {
        super(settings);
    }
}