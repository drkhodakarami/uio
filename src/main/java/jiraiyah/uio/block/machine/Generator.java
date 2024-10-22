package jiraiyah.uio.block.machine;

import jiraiyah.uio.util.block.AbstractActivatableMachineBlock;
//TODO : Create Model
//TODO : Create Block Recipe
//TODO : Handle Block Entity
//TODO : Add GUI
//TODO : Add Custom Recipe
//TODO : Add Custom Recipe Datagen

// Ideas :
// - It produces energy
// - For producing energy we can use different resources:
// - Lava can produce energy
// - Coal / Charcoal / Hot coal / Wood can produce energy
// - Stars can produce energy
// - If it's inside river biome surrounded by water can produce energy
// - If it's inside desert / mountain biome it can produce energy by wind (increases based on height)
// - Snowy biomes have negative effect on energy production
// - Nether has positive effect on energy production

public class Generator extends AbstractActivatableMachineBlock
{
    public Generator(Settings settings)
    {
        super(settings);
    }
}