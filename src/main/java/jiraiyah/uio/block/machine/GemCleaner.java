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
// - It uses water
// - It will clean raw gem and give 3 gems per raw item
// - It will use different amount of water to clean different types of gems
// - It can accept upgrades for water / speed
// - Default water capacity is 10 buckets
// - Default speed changed for gems but the smallest time is 10 seconds
public class GemCleaner extends AbstractActivatableMachineBlock
{
    public GemCleaner(Settings settings)
    {
        super(settings);
    }
}