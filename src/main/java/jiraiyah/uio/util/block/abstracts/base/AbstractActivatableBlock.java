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
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * An abstract block that can be activated by right-clicking with an empty hand.
 * You should override onUse and change the functionality to activate the block.
 * This class provides a basic implementation for blocks that have an activated state.
 *
 * <p>Subclasses should provide specific behavior for what happens when the block is activated.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * public class MyActivatableBlock extends AbstractActivatableBlock {
 *     public MyActivatableBlock(Settings settings) {
 *         super(settings);
 *     }
 *
 *     @Override
 *     protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
 *         // Custom activation logic
 *         return ActionResult.SUCCESS;
 *     }
 * }
 * }
 * </pre>
 *
 * @see net.minecraft.block.Block
 * @see net.minecraft.state.property.BooleanProperty
 * @see net.minecraft.util.ActionResult
 * @see net.minecraft.util.hit.BlockHitResult
 * @see net.minecraft.world.World
 *
 * @author Jiraiyah
 */
public abstract class AbstractActivatableBlock extends Block
{
    /**
     * The property that determines whether the block is activated or not.
     */
    public static final BooleanProperty ACTIVATED = BooleanProperty.of("activated");

    /**
     * Constructs a new AbstractActivatableBlock with the specified settings.
     *
     * @param settings the settings for the block, such as material and hardness
     */
    public AbstractActivatableBlock(Settings settings)
    {
        super(settings);

        setDefaultState(this.getDefaultState().with(ACTIVATED, false));
    }

    /**
     * Appends the properties of the block to the state manager.
     * This method is used to add the ACTIVATED property to the block's state.
     *
     * @param builder the state manager builder used to define block properties
     */
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        super.appendProperties(builder);
        builder.add(ACTIVATED);
    }

    /**
     * Called when the block is used by a player.
     * Toggles the ACTIVATED state of the block when right-clicked.
     *
     * @param state the current state of the block
     * @param world the world in which the block is located
     * @param pos the position of the block in the world
     * @param player the player who used the block
     * @param hit the result of the block hit
     * @return the result of the action, indicating success or failure
     */
    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit)
    {
        if (!world.isClient)
            world.setBlockState(pos, state.cycle(ACTIVATED));
        return super.onUse(state, world, pos, player, hit);
    }
}