/***********************************************************************************
 * Copyright (c) 2024 Alireza Khodakarami (Jiraiyah)                               *
 * ------------------------------------------------------------------------------- *
 * MIT License                                                                     *
 * =============================================================================== *
 * Permission is hereby granted, free of charge, to any person obtaining a copy    *
 * of this software and associated documentation files (the "Software"), to deal   *
 * in the Software without restriction, including without limitation the rights    *
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell       *
 * copies of the Software, and to permit persons to whom the Software is           *
 * furnished to do so, subject to the following conditions:                        *
 * ------------------------------------------------------------------------------- *
 * The above copyright notice and this permission notice shall be included in all  *
 * copies or substantial portions of the Software.                                 *
 * ------------------------------------------------------------------------------- *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR      *
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,        *
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE     *
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER          *
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,   *
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE   *
 * SOFTWARE.                                                                       *
 ***********************************************************************************/

package jiraiyah.uio.block.machine;

import jiraiyah.jimachina.block.AbstractMachineBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

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
public class Miner extends AbstractMachineBlock
{
    public Miner(Settings settings)
    {
        super(settings);
        CODEC = createCodec(Miner::new);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state)
    {
        return null;
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type)
    {
        return super.getTicker(world, state, type);
    }
}