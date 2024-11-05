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
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import team.reborn.energy.api.EnergyStorage;
import team.reborn.energy.api.base.SimpleEnergyStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * The `IEnergySpreader` interface provides methods for managing energy transfer between different energy storage systems.
 * It includes functionality to simulate energy insertion and to spread energy across multiple connected energy storages.
 *
 * <p>This interface is designed to be implemented by classes that handle energy distribution in a Minecraft modding context,
 * utilizing the Fabric API and Team Reborn Energy API.</p>
 *
 * <p>Author: TurtyWurty</p>
 */
@SuppressWarnings("unused")
public interface IEnergySpreader
{
    /**
     * Simulates the insertion of a specified amount of energy into an `EnergyStorage`.
     * This method opens a nested transaction to determine the maximum amount of energy
     * that can be inserted without actually committing the transaction.
     *
     * @param storage The `EnergyStorage` into which energy is to be inserted.
     * @param amount The amount of energy to attempt to insert.
     * @param outer The outer transaction within which this simulation occurs.
     * @return The maximum amount of energy that can be inserted.
     */
    static long simulateInsertion(EnergyStorage storage, long amount, Transaction outer)
    {
        try(Transaction inner = outer.openNested())
        {
            long max = storage.insert(amount, inner);
            inner.abort();
            return max;
        }
    }

    /**
     * Spreads energy from a `SimpleEnergyStorage` to adjacent `EnergyStorage` instances in the world.
     * It checks each direction for available energy storage and attempts to distribute energy evenly.
     * If the energy amount changes, it updates the block entity state accordingly.
     *
     * @param world The `World` in which the energy spreading occurs.
     * @param pos The `BlockPos` of the `SimpleEnergyStorage`.
     * @param storage The `SimpleEnergyStorage` from which energy is spread.
     */
    default void spread(World world, BlockPos pos, SimpleEnergyStorage storage)
    {
        spread(world, pos, null, storage);
    }

    /**
     * Spreads energy from a `SimpleEnergyStorage` to adjacent `EnergyStorage` instances in the world,
     * excluding specific positions defined in the exceptions set. It checks each direction for available
     * energy storage and attempts to distribute energy evenly. If the energy amount changes, it updates
     * the block entity state accordingly.
     *
     * @param world The `World` in which the energy spreading occurs.
     * @param pos The `BlockPos` of the `SimpleEnergyStorage`.
     * @param exceptions A set of `BlockPos` that should be excluded from energy spreading.
     * @param storage The `SimpleEnergyStorage` from which energy is spread.
     * @author Modified by Jiraiyah
     */
    default void spread(World world, BlockPos pos, Set<BlockPos> exceptions, SimpleEnergyStorage storage)
    {
        List<EnergyStorage> storages = new ArrayList<>();
        for(Direction direction : Direction.values())
        {
            BlockPos adjacentPos = pos.offset(direction);
            if(exceptions != null && exceptions.contains(adjacentPos))
                continue;

            EnergyStorage energyStorage = EnergyStorage.SIDED.find(world, adjacentPos, direction.getOpposite());
            if(energyStorage == null || !energyStorage.supportsInsertion() || energyStorage.getAmount() >= energyStorage.getCapacity())
                continue;
            storages.add(energyStorage);
        }

        if(storages.isEmpty())
            return;

        try(Transaction transaction = Transaction.openOuter())
        {
            long current = storage.getAmount();
            long totalExtractable = storage.extract(Long.MAX_VALUE, transaction);
            long totalInserted = 0;

            for(EnergyStorage energyStorage : storages)
            {
                long insertable = simulateInsertion(energyStorage, totalExtractable, transaction);
                long inserted = energyStorage.insert(insertable, transaction);
                totalInserted += inserted;
            }

            if(totalInserted < totalExtractable)
                storage.amount += totalExtractable - totalInserted;

            transaction.commit();

            if(current != storage.getAmount())
            {
                if(this instanceof UpdatableBE updatableBE)
                    updatableBE.update();
                else if(this instanceof BlockEntity blockEntity)
                    blockEntity.markDirty();
            }
        }
    }
}