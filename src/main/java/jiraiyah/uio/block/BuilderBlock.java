package jiraiyah.uio.block;

import net.minecraft.block.Block;
//TODO : Create Model
//TODO : Create Block Recipe
//TODO : Handle Block Entity
//TODO : Add GUI
//TODO : Add Custom Recipe
//TODO : Add Custom Recipe Datagen

// Ideas :
// - It reads a printed blueprint.
// - It has 3 * 9 inventory slots for building materials.
// - It will put the blocks in the world based on the schema
// - It uses energy
// - It can use upgrades
// - The base speed is 1 block per second. It can go up to 1 block every 2 ticks.
// 20 Ticks => 16 Ticks => 12 Ticks => 8 Ticks => 4 Ticks => 2 Ticks

public class BuilderBlock extends Block
{
    public BuilderBlock(Settings settings)
    {
        super(settings);
    }
}