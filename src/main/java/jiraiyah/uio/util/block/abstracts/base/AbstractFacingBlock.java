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
import net.minecraft.block.FacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

/**
 * AbstractFacingBlock is an abstract class that extends the FacingBlock class.
 * It provides a base implementation for blocks that have a directional facing property.
 * The facing direction can be set to either match or oppose the player's look direction
 * when the block is placed.
 *
 * <p>This class is part of the 'jiraiyah.uio.util.block.abstracts.base' package and
 * utilizes Minecraft's block state management system to handle block rotation and mirroring.
 *
 * <p>By default, the facing direction is set to NORTH.
 *
 * <p>Usage of this class requires specifying block settings and whether the block should
 * face opposite to the player's look direction upon placement.
 *
 * <p>Usage example:</p>
 * <pre>
 * {@code
 * public class MyConcreteFacingBlock extends AbstractFacingBlock
 * }
 * </pre>
 *
 * <p>Note: This class is abstract and must be subclassed to be used.</p>
 *
 * @see net.minecraft.block.FacingBlock
 * @see net.minecraft.state.StateManager
 * @see net.minecraft.util.BlockRotation
 * @see net.minecraft.util.BlockMirror
 * @see net.minecraft.util.math.Direction
 *
 * @author Jiraiyah
 */
public abstract class AbstractFacingBlock extends FacingBlock
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
     * Constructs an AbstractFacingBlock with the specified settings and facing behavior.
     *
     * @param settings     the block settings, which define the block's properties such as material and hardness.
     * @param faceOpposite a boolean indicating whether the block should face opposite to the player's look direction when placed.
     */
    public AbstractFacingBlock(Settings settings, boolean faceOpposite)
    {
        super(settings);
        this.faceOpposite = faceOpposite;
        setDefaultState(getDefaultState().with(FACING, Direction.NORTH));
    }

    /**
     * Appends the facing property to the block's state manager.
     * This method is called during the block's initialization to ensure the facing property is included in the block's state.
     *
     * @param builder the state manager builder used to define the block's state properties.
     */
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        super.appendProperties(builder);
        builder.add(FACING);
    }

    /**
     * Determines the block state when the block is placed in the world.
     * The facing direction is set based on the player's look direction and the `faceOpposite` flag.
     *
     * @param ctx the item placement context, which provides information about the placement event.
     * @return the block state with the appropriate facing direction, or null if the placement is invalid.
     */
    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx)
    {
        return this.getDefaultState().with(FACING, this.faceOpposite
                                                   ? ctx.getPlayerLookDirection().getOpposite()
                                                   : ctx.getPlayerLookDirection());
    }

    /**
     * Rotates the block state based on the specified block rotation.
     * This method is used to handle block rotation logic when the block is rotated in the world.
     *
     * @param state    the current block state.
     * @param rotation the block rotation to apply.
     * @return the rotated block state.
     */
    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation)
    {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    /**
     * Mirrors the block state based on the specified block mirror.
     * This method is used to handle block mirroring logic when the block is mirrored in the world.
     *
     * @param state  the current block state.
     * @param mirror the block mirror to apply.
     * @return the mirrored block state.
     */
    @Override
    protected BlockState mirror(BlockState state, BlockMirror mirror)
    {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }
}