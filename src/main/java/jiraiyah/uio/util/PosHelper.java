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

package jiraiyah.uio.util;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

/**
 * This class provides helper methods for working with block positions.
 *
 * @author Jiraiyah
 */
public class PosHelper
{
    /**
     * Returns the position that is one block in the given direction from the given position.
     *
     * @param pos       The position to move from.
     * @param direction The direction to move in.
     *
     * @return The new position.
     */
    public static BlockPos getPositionDirectionTo(BlockPos pos, Direction direction)
    {
        return pos.offset(direction);
    }

    /**
     * Returns an array of positions that are one block in each direction from the given position.
     *
     * @param pos The position to move from.
     *
     * @return An array of new positions.
     */
    public static BlockPos[] getPositionNextTo(BlockPos pos)
    {
        return new BlockPos[]{pos.up(), pos.down(), pos.east(), pos.west(), pos.north(), pos.south()};
    }

    /**
     * Returns an array of positions that are one block in each direction from the given position, excluding top and bottom..
     *
     * @param pos The position to move from.
     *
     * @return An array of new positions.
     */
    public static BlockPos[] getPositionSideTo(BlockPos pos)
    {
        return new BlockPos[]{pos.east(), pos.west(), pos.north(), pos.south()};
    }

    /**
     * Returns an array of positions that are one block in each direction from the given position, excluding top.
     *
     * @param pos The position to move from.
     *
     * @return An array of new positions.
     */
    public static BlockPos[] getPositionSideBottomTo(BlockPos pos)
    {
        return new BlockPos[]{pos.down(), pos.east(), pos.west(), pos.north(), pos.south()};
    }

    /**
     * Returns the position that is one block to the left of the given position with the given block facing..
     *
     * @param pos    The position to move from.
     * @param facing The direction the block is facing.
     *
     * @return The new position.
     */
    public static BlockPos getLeft(BlockPos pos, Direction facing)
    {
        switch (facing)
        {
            case NORTH ->
            {
                return pos.west();
            }
            case SOUTH ->
            {
                return pos.east();
            }
            case WEST ->
            {
                return pos.south();
            }
            case EAST ->
            {
                return pos.north();
            }
            default ->
            {
                return pos;
            }
        }
    }

    /**
     * Returns the position that is one block to the right of the given position with the given block facing..
     *
     * @param pos    The position to move from.
     * @param facing The direction the block is facing.
     *
     * @return The new position.
     */
    public static BlockPos getRight(BlockPos pos, Direction facing)
    {
        switch (facing)
        {
            case NORTH ->
            {
                return pos.east();
            }
            case SOUTH ->
            {
                return pos.west();
            }
            case WEST ->
            {
                return pos.north();
            }
            case EAST ->
            {
                return pos.south();
            }
            default ->
            {
                return pos;
            }
        }
    }

    /**
     * Returns the position that is one block to the back of the given position with the given block facing..
     *
     * @param pos    The position to move from.
     * @param facing The direction the block is facing.
     *
     * @return The new position.
     */
    public static BlockPos getBack(BlockPos pos, Direction facing)
    {
        switch (facing)
        {
            case NORTH ->
            {
                return pos.north();
            }
            case SOUTH ->
            {
                return pos.south();
            }
            case WEST ->
            {
                return pos.west();
            }
            case EAST ->
            {
                return pos.east();
            }
            default ->
            {
                return pos;
            }
        }
    }

    /**
     * Returns the position that is one block in front of the given position with the given block facing..
     *
     * @param pos    The position to move from.
     * @param facing The direction the block is facing.
     *
     * @return The new position.
     */
    public static BlockPos getFront(BlockPos pos, Direction facing)
    {
        switch (facing)
        {
            case NORTH ->
            {
                return pos.south();
            }
            case SOUTH ->
            {
                return pos.north();
            }
            case WEST ->
            {
                return pos.east();
            }
            case EAST ->
            {
                return pos.west();
            }
            default ->
            {
                return pos;
            }
        }
    }

    /**
     * Returns the position that is one block to the top of the given position with the given block facing..
     *
     * @param pos The position to move from.
     *
     * @return The new position.
     */
    public static BlockPos getTop(BlockPos pos)
    {
        return pos.up();
    }

    /**
     * Returns the position that is one block to the bottom of the given position with the given block facing..
     *
     * @param pos The position to move from.
     *
     * @return The new position.
     */
    public static BlockPos getBottom(BlockPos pos)
    {
        return pos.down();
    }
}