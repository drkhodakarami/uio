package jiraiyah.uio.block;

import net.minecraft.block.Block;

//TODO : Create Model
//TODO : Create Block Recipe
//TODO : Handle Block Entity
//TODO : Add GUI

// Ideas :
// - It should have inventory that stores animal food
// - It should have many feeding slots one per food type
// - Every tick, it will find animals around itself and feed them if there is proper food in the feeding slot
// - If there is food stored in the inventory slots, it will refill the feeding slots
// - It will have upgrade slots that will increase the distance it can feed animals
// - The default distance is one block around itself.
// - The biggest possible distance is 8 blocks radius (makes 17 * 17 square)
public class AnimalFeed extends Block
{
    public AnimalFeed(Settings settings)
    {
        super(settings);
    }
}