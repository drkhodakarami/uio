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

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;

/**
 * Interface for providing wrapped fluid storage capabilities.
 *
 * <p>
 * This interface defines methods and constants for managing fluid storage
 * within a wrapped context. Implementations of this interface can add fluid
 * storages and retrieve the wrapped fluid storage instance.
 * </p>
 *
 * <p>
 * The default fluid capacity is defined as ten times the standard bucket
 * capacity.
 * </p>
 *
 * @see WrappedFluidStorage
 * @see SyncedFluidStorage
 */
public interface IWrappedFluidProvider
{
    /**
     * The default fluid capacity, set to ten times the standard bucket capacity.
     */
    long DEFAULT_FLUID_CAPACITY = FluidConstants.BUCKET * 10;

    /**
     * Adds a new fluid storage with the specified capacity.
     *
     * @param capacity The capacity of the new fluid storage.
     */
    void addFluidStorage(long capacity);

    /**
     * Retrieves the wrapped fluid storage instance.
     *
     * @return The wrapped fluid storage instance.
     */
    WrappedFluidStorage<SyncedFluidStorage> getFluidStorage();
}