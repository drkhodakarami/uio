package jiraiyah.uio.block.machine;

import jiraiyah.uio.util.block.AbstractMachineBlock;

//TODO : Create Model
//TODO : Create Block Recipe
//TODO : Handle Block Entity
//TODO : Add GUI

// Ideas :
// - If you put any enchanted item, it will learn the enchantment
// - It will not extract enchantments from items
// - After learning the enchantment, put an empty book and choose the enchantment to apply to the item
// - Enchantments can be shown inside a sliding list (maybe)
// - You should select the enchantment, and hit a button to apply it to the book
public class EnderChanter extends AbstractMachineBlock
{
    public EnderChanter(Settings settings)
    {
        super(settings.nonOpaque());
    }
}