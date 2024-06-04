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

package jiraiyah.uio.block;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ElevatorBlock extends Block
{
    public ElevatorBlock(Settings settings)
    {
        super(settings.sounds(BlockSoundGroup.HONEY));
    }

    // TODO : Use Mixin for Cool Down Timer on Inputs for Sneaking
    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity)
    {
        teleportDown(world, pos, entity);
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance)
    {
        teleportUp(world, pos, entity);
    }

    public void teleportDown(World world, BlockPos pos, Entity entity)
    {
        if (!entity.isPlayer())
            return;
        if (world.isClient())
            return;
        if (entity.isSneaking())
        {
            BlockPos lookingPos = pos;
            BlockState found = null;

            while (lookingPos.getY() > world.getBottomY())
            {
                lookingPos = lookingPos.add(0, -1, 0);

                BlockState blockState = world.getBlockState(lookingPos);
                if (blockState.getBlock() instanceof ElevatorBlock)
                {
                    found = blockState;
                    break;
                }
            }

            if (found == null)
                return;

            entity.teleport(entity.getX(), lookingPos.getY() + 1, entity.getZ());
            world.playSound(null, entity.getSteppingPos(), SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, SoundCategory.PLAYERS,
                            0.5f, world.random.nextFloat() * 0.6f + 0.9f);
        }
    }

    public void teleportUp(World world, BlockPos pos, Entity entity)
    {
        if (!entity.isPlayer())
            return;
        if (world.isClient())
            return;

        BlockPos lookingPos = pos;
        BlockState found = null;

        while (lookingPos.getY() < world.getTopY())
        {
            lookingPos = lookingPos.add(0, 1, 0);

            BlockState blockState = world.getBlockState(lookingPos);
            if (blockState.getBlock() == this)
            {
                found = blockState;
                break;
            }
        }

        if (found == null)
            return;

        entity.teleport(entity.getX(), lookingPos.getY() + 1, entity.getZ());
        world.playSound(null, entity.getSteppingPos(), SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, SoundCategory.PLAYERS,
                        0.5f, world.random.nextFloat() * 0.6f + 0.9f);
    }
}