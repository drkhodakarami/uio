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

import net.minecraft.util.math.Direction;

/**
 * The {@code IWrappedEnergyProvider} interface defines the contract for classes
 * that provide energy storage capabilities using a {@link WrappedEnergyStorage}.
 * It includes methods to add energy storage with specified parameters and to
 * retrieve the current energy storage.
 * <p>
 * Implementations of this interface are expected to manage energy storage
 * configurations and provide access to the underlying {@link WrappedEnergyStorage}.
 * </p>
 */
public interface IWrappedEnergyProvider
{
    /**
     * The default energy capacity for new energy storage units.
     */
    int DEFAULT_ENERGY_CAPACITY = 100_000;

    /**
     * The default maximum amount of energy that can be inserted into the storage per operation.
     */
    int DEFAULT_MAX_INSERT = 100;

    /**
     * The default maximum amount of energy that can be extracted from the storage per operation.
     */
    int DEFAULT_MAX_EXTRACT = 100;

    /**
     * Adds a new energy storage unit with the specified capacity, maximum insertion rate,
     * maximum extraction rate, and direction.
     *
     * @param capacity   the total energy capacity of the storage unit
     * @param maxInsert  the maximum amount of energy that can be inserted per operation
     * @param maxExtract the maximum amount of energy that can be extracted per operation
     * @param direction  the direction associated with the energy storage unit
     */
    void AddEnergyStorage(int capacity, int maxInsert, int maxExtract, Direction direction);

    /**
     * Retrieves the current energy storage associated with this block entity.
     *
     * This method allows other components of the system to access the energy
     * storage configuration defined for this block entity. It returns an instance
     * of {@link WrappedEnergyStorage} containing synchronized energy storage units,
     * which can be used for operations related to energy management, such as
     * checking current energy levels or manipulating energy within the storage.
     *
     * @return A {@link WrappedEnergyStorage<SyncedEnergyStorage>} instance
     *         representing the energy storage for this block entity.
     */
    WrappedEnergyStorage<SyncedEnergyStorage> getEnergyStorage();
}