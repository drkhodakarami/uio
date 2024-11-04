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

package jiraiyah.uio.event;

import jiraiyah.uio.item.ExcavatorItem;
import jiraiyah.uio.item.HammerItem;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class BeforePlayerBlockBreakListener implements PlayerBlockBreakEvents.Before
{
    private static final Set<BlockPos> HARVESTED_BLOCK = new HashSet<>();

    @Override
    public boolean beforeBlockBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity)
    {
        ItemStack stack = player.getMainHandStack();
        if (player instanceof ServerPlayerEntity sp)
        {
            if (stack.getItem() instanceof HammerItem hammer)
            {
                if (HARVESTED_BLOCK.contains(pos))
                    return true;

                int radius = hammer.getRadius();
                int depth = hammer.getDepth();

                for (BlockPos position : HammerItem.getAreaBlocks(pos, depth, radius, sp))
                {
                    if (pos == position || !hammer.isCorrectForDrops(stack, world.getBlockState(position)))
                        continue;

                    HARVESTED_BLOCK.add(position);
                    sp.interactionManager.tryBreakBlock(position);
                    HARVESTED_BLOCK.remove(position);
                }
            }
            else if (stack.getItem() instanceof ExcavatorItem excavator)
            {
                if (HARVESTED_BLOCK.contains(pos))
                    return true;

                int radius = excavator.getRadius();
                int depth = excavator.getDepth();

                for (BlockPos position : ExcavatorItem.getAreaBlocks(pos, depth, radius, sp))
                {
                    if (pos == position || !excavator.isCorrectForDrops(stack, world.getBlockState(position)))
                        continue;

                    HARVESTED_BLOCK.add(position);
                    sp.interactionManager.tryBreakBlock(position);
                    HARVESTED_BLOCK.remove(position);
                }
            }
        }
        return true;
    }
}