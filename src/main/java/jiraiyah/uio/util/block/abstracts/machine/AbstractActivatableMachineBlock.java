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

package jiraiyah.uio.util.block.abstracts.machine;

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
 * The {@code AbstractActivatableMachineBlock} class represents a block that can be activated
 * within the game world. This class extends the {@code AbstractMachineBlock} and provides
 * additional functionality for blocks that have an activatable state.
 * <p>
 * This class is intended to be subclassed by specific machine block implementations that
 * require activation behavior. It provides a framework for handling activation events
 * and managing the block's state.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * public class MyCustomMachineBlock extends AbstractActivatableMachineBlock {
 *     // Implementation details
 * }
 * </pre>
 * </p>
 *
 * <p>
 * Note: This class relies on the Minecraft game engine's block and world mechanics.
 * </p>
 *
 * @see AbstractMachineBlock
 * @author jiraiyah
 */
public abstract class AbstractActivatableMachineBlock extends AbstractMachineBlock
{
    /**
     * The property that determines whether the block is activated or not.
     */
    public static final BooleanProperty ACTIVATED = BooleanProperty.of("activated");

    /**
     * Constructs a new {@code AbstractActivatableMachineBlock} with the specified settings.
     * <p>
     * This constructor initializes the block with the given settings, which define various
     * properties and behaviors of the block within the game world.
     * </p>
     *
     * @param settings the settings used to configure the block's properties and behavior.
     *                 This parameter must not be null and should be configured according
     *                 to the specific requirements of the block.
     */
    public AbstractActivatableMachineBlock(Settings settings)
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