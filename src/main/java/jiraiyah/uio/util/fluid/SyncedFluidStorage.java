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

package jiraiyah.uio.util.fluid;

import jiraiyah.uio.util.blockentity.UpdatableBE;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.SingleFluidStorage;
import net.minecraft.block.entity.BlockEntity;

/**
 * Represents a synchronized fluid storage system that is associated with a specific block entity.
 * This class extends the functionality of {@link SingleFluidStorage} to manage fluid storage
 * with a defined capacity while ensuring synchronization with the associated block entity.
 *
 * <p>
 * The fluid storage has a specified capacity, and upon committing changes to the storage,
 * it informs the associated block entity to update its state. If the block entity implements
 * the {@link UpdatableBE} interface, it will call the update method; otherwise, it will
 * mark the block entity as dirty to prompt a save.
 * </p>
 *
 * <p>
 * Usage Example:
 * <pre>
 * BlockEntity blockEntity = ...; // your block entity instance
 * long storageCapacity = 1000L; // desired capacity
 * SyncedFluidStorage fluidStorage = new SyncedFluidStorage(blockEntity, storageCapacity);
 * </pre>
 * </p>
 *
 * @see SingleFluidStorage
 * @see UpdatableBE
 */
public class SyncedFluidStorage extends SingleFluidStorage
{
    /**
     * The {@code BlockEntity} associated with this fluid storage.
     *
     * <p>
     * This field holds a reference to the block entity that this fluid storage is linked to.
     * It allows the storage to interact with the block's state and provides a means
     * to notify the block entity when fluid storage operations are finalized, ensuring
     * proper synchronization and state management.
     * </p>
     *
     * <p>
     * The block entity can be any instance of a class that extends {@link BlockEntity},
     * allowing the fluid storage to work with a variety of block types, including custom
     * implementations that may require additional behaviors when fluid is added or removed.
     * </p>
     */
    private final BlockEntity blockEntity;

    /**
     * The maximum capacity of the fluid storage in volume.
     *
     * <p>
     * This field defines the upper limit of fluid that can be stored in the fluid storage.
     * It is represented as a {@code long} value and is used to ensure that the fluid
     * storage does not exceed its defined storage capacity during fluid transfer operations.
     * </p>
     *
     * <p>
     * The capacity is set during the initialization of the {@code SyncedFluidStorage}
     * instance and can be adjusted according to the needs of the specific block entity
     * it is associated with. This allows for flexible configurations of fluid storage
     * for various block types in the game.
     * </p>
     */
    private final long capacity;

    /**
     * Constructs a {@code SyncedFluidStorage} instance with the specified block entity
     * and storage capacity.
     *
     * @param blockEntity the {@link BlockEntity} associated with this fluid storage,
     *                    which will be notified of any updates to the fluid storage state.
     * @param capacity    the maximum capacity of the fluid storage, expressed in volume,
     *                    which defines how much fluid can be stored.
     *
     * <p>
     * This constructor initializes the fluid storage system, linking it to a specific
     * block entity and setting the storage capacity. The storage will manage fluid
     * operations and ensure that changes are synchronized with the provided block entity.
     * </p>
     */
    public SyncedFluidStorage(BlockEntity blockEntity, long capacity)
    {
        this.blockEntity = blockEntity;
        this.capacity = capacity;
    }

    /**
     * Returns the maximum capacity of the fluid storage for the specified fluid variant.
     *
     * @param fluidVariant the {@link FluidVariant} for which to retrieve the capacity.
     *                     The capacity may vary depending on the type of fluid.
     * @return the maximum capacity of the fluid storage as a {@code long}, indicating
     *         the maximum volume of the specified fluid that can be stored.
     *
     * <p>
     * This method overrides the default behavior of the parent class {@link SingleFluidStorage}
     * to provide a custom capacity based on the given fluid variant. It ensures that the
     * fluid storage can handle different fluid types with potentially different capacities.
     * </p>
     */
    @Override
    protected long getCapacity(FluidVariant fluidVariant)
    {
        return this.capacity;
    }

    /**
     * Called when the final commit has been made to the fluid storage.
     *
     * <p>
     * This method overrides the default implementation in {@link SingleFluidStorage}
     * to provide additional behavior upon finalizing fluid storage operations. When
     * the fluid storage is modified and the changes are committed, this method
     * will be invoked to notify the associated block entity.
     * </p>
     *
     * <p>
     * If the block entity extends {@link UpdatableBE}, its
     * {@link UpdatableBE#update()} method will be called to perform any necessary
     * updates. If the block entity does not implement this interface,
     * {@link BlockEntity#markDirty()} will be called to indicate that the block
     * entity's state has changed and needs to be saved.
     * </p>
     *
     * <p>
     * This ensures that the associated block entity correctly reflects the
     * changes made in the fluid storage and maintains consistent state across
     * the game world.
     * </p>
     */
    @Override
    protected void onFinalCommit()
    {
        super.onFinalCommit();
        if(this.blockEntity instanceof UpdatableBE updatableBE)
            updatableBE.update();
        else
            this.blockEntity.markDirty();
    }

    /**
     * Retrieves the block entity associated with this fluid storage.
     *
     * @return the {@link BlockEntity} linked to this {@code SyncedFluidStorage} instance,
     *         which represents the block that owns this fluid storage.
     *
     * <p>
     * This method provides access to the block entity for any operations or checks
     * that may need to be performed in relation to the fluid storage. Users can
     * utilize this method to interact with the block entity directly, allowing
     * for further customization or interaction beyond the fluid storage functionality.
     * </p>
     */
    public BlockEntity getBlockEntity()
    {
        return blockEntity;
    }
}