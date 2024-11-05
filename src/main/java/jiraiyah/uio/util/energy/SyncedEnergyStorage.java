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

package jiraiyah.uio.util.energy;

import jiraiyah.uio.util.blockentity.UpdatableBE;
import net.minecraft.block.entity.BlockEntity;
import team.reborn.energy.api.base.SimpleEnergyStorage;

/**
 * The {@code SyncingEnergyStorage} class extends {@code SimpleEnergyStorage} to provide
 * energy storage capabilities with synchronization between server and client.
 * It utilizes an {@code UpdatableBE} block entity to ensure that any changes
 * in energy storage are properly updated across the network.
 * @author TurtyWurty
 */
public class SyncedEnergyStorage extends SimpleEnergyStorage
{
    private final BlockEntity blockEntity;

    /**
     * Constructs a new {@code SyncingEnergyStorage} instance.
     *
     * @param blockEntity The {@link BlockEntity} associated with this energy storage.
     * @param capacity The total capacity of the energy storage.
     * @param maxInsert The maximum amount of energy that can be inserted per operation.
     * @param maxExtract The maximum amount of energy that can be extracted per operation.
     */
    public SyncedEnergyStorage(BlockEntity blockEntity, long capacity, long maxInsert, long maxExtract)
    {
        super(capacity, maxInsert, maxExtract);
        this.blockEntity = blockEntity;
    }

    /**
     * This method is called when the changes to the energy storage are finalized.
     * It is responsible for performing necessary actions after energy storage
     * modifications are committed.
     *
     * <p>
     * The method first invokes the parent class's {@link SimpleEnergyStorage#onFinalCommit()}
     * to ensure that any inherited finalization logic is executed. After that, it checks if the
     * associated {@link BlockEntity} is an instance of {@code UpdatableBE}. If it is, the method
     * calls the {@link UpdatableBE#update()} method to synchronize the state. If it is not an
     * {@code UpdatableBE}, it calls {@link BlockEntity#markDirty()} to indicate that the block entity
     * requires an update in the game state.
     * </p>
     *
     * @see SimpleEnergyStorage#onFinalCommit()
     * @see UpdatableBE#update()
     * @see BlockEntity#markDirty()
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
     * Returns the {@link BlockEntity} associated with this energy storage.
     *
     * @return The block entity associated with this energy storage.
     */
    public BlockEntity getBlockEntity()
    {
        return this.blockEntity;
    }
}