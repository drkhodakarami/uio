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

import com.mojang.serialization.MapCodec;
import jiraiyah.uio.util.block.abstracts.base.AbstractHorizontalDirectionBlock;
import jiraiyah.uio.util.blockentity.ITickBE;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

/**
 * The abstract class for machine blocks, providing block entity functionality and handling base operations.
 * This class extends {@link AbstractHorizontalDirectionBlock} and implements {@link BlockEntityProvider}.
 * It is designed to be extended by specific machine block implementations.
 *
 * <p>It provides methods for handling block events, creating tickers, and screen handler factories.</p>
 *
 * @see AbstractHorizontalDirectionBlock
 * @see BlockEntityProvider
 * @see ITickBE
 * @see BlockEntityTicker
 * @see NamedScreenHandlerFactory
 * @see BlockState
 * @see World
 * @see BlockPos
 * @see BlockEntity
 * @see BlockEntityType
 * @see MapCodec
 * @see HorizontalFacingBlock
 *
 * @param <T> The type of block entity associated with this block.
 * @param <E> The expected type of block entity for ticker validation.
 * @param <A> The actual type of block entity for ticker validation.
 *
 * @author jiraiyah
 */
public abstract class AbstractMachineBlock extends AbstractHorizontalDirectionBlock implements BlockEntityProvider
{
    /**
     * The codec for serializing and deserializing this block.
     */
    protected MapCodec<? extends AbstractMachineBlock> CODEC;

    /**
     * Constructs an AbstractMachineBlock with the specified settings.
     *
     * @param settings The settings for the block.
     */
    public AbstractMachineBlock(Settings settings)
    {
        super(settings, true);
    }

    /**
     * Returns the codec used for this block.
     *
     * @return The codec for this block.
     */
    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec()
    {
        return CODEC;
    }

    /**
     * Handles synchronized block events. This method is called when a block event is triggered.
     *
     * @param state The block state.
     * @param world The world in which the block is located.
     * @param pos   The position of the block.
     * @param type  The type of the event.
     * @param data  The data associated with the event.
     * @return True if the event was handled successfully, false otherwise.
     */
    @Override
    protected boolean onSyncedBlockEvent(BlockState state, World world, BlockPos pos, int type, int data)
    {
        super.onSyncedBlockEvent(state, world, pos, type, data);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity != null && blockEntity.onSyncedBlockEvent(type, data);
    }

    /**
     * Returns a ticker for the block entity. This method is used to create a ticker for the block entity.
     *
     * @param world The world in which the block is located.
     * @param state The block state.
     * @param type  The type of the block entity.
     * @return A ticker for the block entity, or null if no ticker is available.
     */
    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type)
    {
        return ITickBE.createTicker(world);
    }

    /**
     * Validates the ticker for the block entity. This method checks if the given type matches the expected type.
     *
     * @param givenType   The given block entity type.
     * @param expectedType The expected block entity type.
     * @param ticker      The ticker to validate.
     * @return The validated ticker, or null if the types do not match.
     */
    @Nullable
    protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> validateTicker(
            BlockEntityType<A> givenType, BlockEntityType<E> expectedType, BlockEntityTicker<A> ticker)
    {
        return expectedType == givenType ? ticker : null;
    }

    /**
     * Creates a screen handler factory for the block entity. This method is used to create a screen handler factory.
     *
     * @param state The block state.
     * @param world The world in which the block is located.
     * @param pos   The position of the block.
     * @return A screen handler factory, or null if no factory is available.
     */
    @Nullable
    @Override
    protected NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity instanceof NamedScreenHandlerFactory ? (NamedScreenHandlerFactory)blockEntity : null;
    }
}