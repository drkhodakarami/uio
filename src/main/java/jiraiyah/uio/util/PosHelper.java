package jiraiyah.uio.util;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class PosHelper
{
    public static BlockPos getPositionDirectionTo(BlockPos pos, Direction direction)
    {
        return pos.offset(direction);
    }

    public static BlockPos[] getPositionNextTo(BlockPos pos)
    {
        return new BlockPos[]{pos.up(), pos.down(), pos.east(), pos.west(), pos.north(), pos.south()};
    }

    public static BlockPos[] getPositionSideTo(BlockPos pos)
    {
        return new BlockPos[]{pos.east(), pos.west(), pos.north(), pos.south()};
    }

    public static BlockPos[] getPositionSideBottomTo(BlockPos pos)
    {
        return new BlockPos[]{pos.down(), pos.east(), pos.west(), pos.north(), pos.south()};
    }

    public static BlockPos getLeft(BlockPos pos, Direction facing)
    {
        switch (facing)
        {
            case NORTH -> { return pos.west(); }
            case SOUTH -> { return pos.east(); }
            case WEST -> { return pos.south(); }
            case EAST -> { return pos.north(); }
            default -> { return pos; }
        }
    }

    public static BlockPos getRight(BlockPos pos, Direction facing)
    {
        switch (facing)
        {
            case NORTH -> { return pos.east(); }
            case SOUTH -> { return pos.west(); }
            case WEST -> { return pos.north(); }
            case EAST -> { return pos.south(); }
            default -> { return pos; }
        }
    }

    public static BlockPos getBack(BlockPos pos, Direction facing)
    {
        switch (facing)
        {
            case NORTH -> { return pos.north(); }
            case SOUTH -> { return pos.south(); }
            case WEST -> { return pos.west(); }
            case EAST -> { return pos.east(); }
            default -> { return pos; }
        }
    }

    public static BlockPos getFront(BlockPos pos, Direction facing)
    {
        switch (facing)
        {
            case NORTH -> { return pos.south(); }
            case SOUTH -> { return pos.north(); }
            case WEST -> { return pos.east(); }
            case EAST -> { return pos.west(); }
            default -> { return pos; }
        }
    }

    public static BlockPos getTop(BlockPos pos)
    {
        return pos.up();
    }

    public static BlockPos getBottom(BlockPos pos)
    {
        return pos.down();
    }
}