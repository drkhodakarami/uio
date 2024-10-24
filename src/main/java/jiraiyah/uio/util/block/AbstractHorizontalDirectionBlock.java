package jiraiyah.uio.util.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public class AbstractHorizontalDirectionBlock extends Block
{
    //TODO: DirectionProperty -> EnumProperty<Direction>
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    private final boolean faceOpposite;

    public AbstractHorizontalDirectionBlock(Settings settings, boolean faceOpposite)
    {
        super(settings);
        this.faceOpposite = faceOpposite;
        setDefaultState(getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        super.appendProperties(builder);
        builder.add(FACING);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx)
    {
        Direction finalFacing = this.faceOpposite
                                ? ctx.getHorizontalPlayerFacing().getOpposite()
                                : ctx.getHorizontalPlayerFacing();
        return this.getDefaultState().with(FACING, finalFacing);
    }

    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation)
    {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, BlockMirror mirror)
    {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }
}