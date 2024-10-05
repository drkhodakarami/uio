package jiraiyah.uio.block;

import net.minecraft.block.Block;

//TODO : Create Model
//TODO : Create Block Recipe
//TODO : Handle Block Entity
//TODO : Add GUI

// Ideas :
// - A miner that uses energy to mine blocks.
// - The default radius is 0 blocks (mines only the block under itself)
// - Can accept upgrades to increase the radius up to 64 blocks (129 * 129 area)
// - The default speed is 1 block per second
// - Can accept upgrades to increase speed up to 1 block per tick (10 upgrades)
// ==> 20 ==> 18 ==> 16 ==> 14 ==> 12 ==> 10 ==> 8 ==> 6 ==> 4 ==> 2 ==> 1 block per tick
// - If there is no inventory on top, it will fill internal inventory and then stop
// - It will put items in the inventory sitting on top
// - It will use 10 energy units per block mined
// - The default internal energy storage is 100 units
// - It can accept upgrades to increase internal energy storage up to 6_500 units
// ==> 100 units per upgrade (64 item stack)
// - It can accept upgrade for fortune and / or silk touch
// - It can accept upgrade destroy fluid blocks
// - It will draw nice glowing border tape around the perimeter of the mining area
public class Miner extends Block
{
    public Miner(Settings settings)
    {
        super(settings);
    }
}