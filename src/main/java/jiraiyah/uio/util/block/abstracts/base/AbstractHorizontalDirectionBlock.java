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

package jiraiyah.uio.util.block.abstracts.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

/**
 * This is an abstract class for blocks that can face in any horizontal direction.
 * It sets the facing property to NORTH by default. The constructor takes a boolean
 * parameter to determine whether the block should face opposite to the player's
 * direction or not.
 *
 * <p>This class extends {@link HorizontalFacingBlock} and provides additional
 * functionality for determining the block's facing direction upon placement.</p>
 *
 * <p>Usage example:</p>
 * <pre>
 * {@code
 * public class MyConcreteBlock extends AbstractHorizontalDirectionBlock
 * }
 * </pre>
 *
 * <p>Note: This class is abstract and should be extended by concrete block classes.</p>
 *
 * @see HorizontalFacingBlock
 * @see Direction
 * @see ItemPlacementContext
 * @see BlockState
 * @see StateManager
 *
 * @author Jiraiyah
 */
public abstract class AbstractHorizontalDirectionBlock extends HorizontalFacingBlock
{
    /**
     * A flag indicating whether the block should face opposite to the player's look direction when placed.
     *
     * <p>If `true`, the block will face the direction opposite to where the player is looking during placement.
     * If `false`, the block will face the same direction as the player's look direction.
     *
     * <p>This property is used in the `getPlacementState` method to determine the block's facing direction
     * upon placement in the world.
     */
    private final boolean faceOpposite;

    /**
     * Constructor for AbstractHorizontalDirectionBlock.
     *
     * @param settings     the block settings
     * @param faceOpposite whether the block should face opposite to the player's direction or not.
     */
    public AbstractHorizontalDirectionBlock(Settings settings, boolean faceOpposite)
    {
        super(settings);
        this.faceOpposite = faceOpposite;
        setDefaultState(getDefaultState().with(FACING, Direction.NORTH));
    }

    /**
     * Appends the properties for the block state. This method adds the FACING property
     * to the block state, allowing the block to have a direction.
     *
     * @param builder the state manager builder used to define block properties
     */
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        super.appendProperties(builder);
        builder.add(FACING);
    }

    /**
     * Determines the block state upon placement. This method calculates the facing
     * direction based on the player's orientation and the `faceOpposite` flag.
     *
     * @param ctx the item placement context providing information about the placement
     * @return the block state with the appropriate facing direction, or null if the state cannot be determined
     */
    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx)
    {
        Direction finalFacing = this.faceOpposite
                                ? ctx.getHorizontalPlayerFacing().getOpposite()
                                : ctx.getHorizontalPlayerFacing();
        return this.getDefaultState().with(FACING, finalFacing);
    }
}