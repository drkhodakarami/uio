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
import jiraiyah.uio.util.interfaces.NBTSerializable;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jiraiyah.uio.Reference.Keys;

/**
 * The {@code WrappedEnergyStorage} class is a generic wrapper for managing multiple
 * {@link SyncedEnergyStorage} instances. It provides methods to add, retrieve, and
 * manage energy storages, including direction-specific storages. It also implements
 * the {@link NBTSerializable} interface for serialization and deserialization of
 * energy storage data to and from NBT format.
 *
 * @param <T> The type of {@link SyncedEnergyStorage} managed by this wrapper.
 */
@SuppressWarnings("unused")
public class WrappedEnergyStorage<T extends SyncedEnergyStorage> implements NBTSerializable<NbtList>
{
    /**
     * A list holding all {@link SyncedEnergyStorage} instances.
     */
    private final List<T> storages = new ArrayList<>();

    /**
     * A map associating {@link Direction} with specific {@link SyncedEnergyStorage} instances.
     */
    private final Map<Direction, T> sidedStorageMap = new HashMap<>();

    /**
     * Adds a new energy storage without specifying a direction.
     *
     * @param storage The energy storage to be added.
     */
     public void addStorage(T storage)
    {
        addStorage(storage, null);
    }

    /**
     * Adds a new energy storage to the specified block entity with the given parameters.
     *
     * @param blockEntity The block entity to which the energy storage will be added.
     * @param capacity    The total capacity of the energy storage.
     * @param maxInsert   The maximum amount of energy that can be inserted per operation.
     * @param maxExtract  The maximum amount of energy that can be extracted per operation.
     */
    public void addStorage(UpdatableBE blockEntity, int capacity, int maxInsert, int maxExtract)
    {
        addStorage(blockEntity, capacity, maxInsert, maxExtract, null);
    }

    /**
     * Adds a new energy storage to the specified block entity with the given parameters
     * and associates it with a specific direction.
     *
     * @param blockEntity The block entity to which the energy storage will be added.
     * @param capacity    The total capacity of the energy storage.
     * @param maxInsert   The maximum amount of energy that can be inserted per operation.
     * @param maxExtract  The maximum amount of energy that can be extracted per operation.
     * @param direction   The direction associated with this energy storage.
     */
    @SuppressWarnings("unchecked")
    public void addStorage(UpdatableBE blockEntity, int capacity, int maxInsert, int maxExtract, Direction direction)
    {
        addStorage((T) new SyncedEnergyStorage(blockEntity, capacity, maxInsert, maxExtract), direction);
    }

    /**
     * Adds a new energy storage and associates it with a specific direction.
     *
     * @param storage   The energy storage to be added.
     * @param direction The direction associated with this energy storage.
     */
    public void addStorage(T storage, Direction direction)
    {
        this.storages.add(storage);

        if(direction == null)
        {
            for(Direction dir : Direction.values())
                this. sidedStorageMap.put(dir, storage);
        }
        else
            this. sidedStorageMap.put(direction, storage);
    }

    /**
     * Returns a list of all energy storages.
     *
     * @return A list of all energy storages.
     */
    public List<T> getStorages()
    {
        return this.storages;
    }

    /**
     * Returns a map of direction-specific storages.
     *
     * @return A map of direction-specific storages.
     */
    public Map<Direction, T> getSidedStorageMap()
    {
        return this.sidedStorageMap;
    }

    /**
     * Retrieves the amount of energy stored in the storage associated with the specified direction.
     *
     * @param direction The direction of the storage.
     * @return The amount of energy stored.
     */
    public long getAmount(Direction direction)
    {
        return getStorage(direction).getAmount();
    }

    /**
     * Retrieves the capacity of the storage associated with the specified direction.
     *
     * @param direction The direction of the storage.
     * @return The capacity of the storage.
     */
    public long getCapacity(Direction direction)
    {
        return getStorage(direction).getCapacity();
    }

    /**
     * Retrieves the maximum amount of energy that can be inserted into the storage associated with the specified direction.
     *
     * @param direction The direction of the storage.
     * @return The maximum insert rate.
     */
    public long getMaxInsert(Direction direction)
    {
        return getStorage(direction).maxInsert;
    }

    /**
     * Retrieves the maximum amount of energy that can be extracted from the storage associated with the specified direction.
     *
     * @param direction The direction of the storage.
     * @return The maximum extract rate.
     */
    public long getMaxExtract(Direction direction)
    {
        return getStorage(direction).maxExtract;
    }

    /**
     * Retrieves the amount of energy stored in the storage at the specified index.
     *
     * @param index The index of the storage.
     * @return The amount of energy stored.
     */
    public long getAmount(int index)
    {
        return getStorage(index).getAmount();
    }

    /**
     * Retrieves the capacity of the storage at the specified index.
     *
     * @param index The index of the storage.
     * @return The capacity of the storage.
     */
    public long getCapacity(int index)
    {
        return getStorage(index).getCapacity();
    }

    /**
     * Retrieves the maximum amount of energy that can be inserted into the storage at the specified index.
     *
     * @param index The index of the storage.
     * @return The maximum insert rate.
     */
    public long getMaxInsert(int index)
    {
        return getStorage(index).maxInsert;
    }

    /**
     * Retrieves the maximum amount of energy that can be extracted from the storage at the specified index.
     *
     * @param index The index of the storage.
     * @return The maximum extract rate.
     */
    public long getMaxExtract(int index)
    {
        return getStorage(index).maxExtract;
    }

    /**
     * Retrieves the storage associated with the specified direction.
     *
     * @param direction The direction of the storage.
     * @return The storage associated with the direction.
     */
    public T getStorage(@Nullable Direction direction)
    {
        if(direction == null)
            return this.storages.getFirst();
        return this.sidedStorageMap.get(direction);
    }

    /**
     * Retrieves the storage at the specified index.
     *
     * @param index The index of the storage.
     * @return The storage at the specified index.
     */
    public T getStorage(int index)
    {
        return this.storages.get(index);
    }

    //region Serialization
    /**
     * Serializes the energy storage data to an NBT list.
     * This method is used to save the current state of the energy storages
     * so that it can be restored later.
     *
     * @param registryLookup The registry lookup to use when serializing the object.
     * @return An NbtList containing the serialized energy storage data.
     */
    @Override
    public NbtList writeNbt(RegistryWrapper.WrapperLookup registryLookup)
    {
        NbtList nbtList = new NbtList();
        for( T storage : this.storages)
        {
            NbtCompound nbt = new NbtCompound();
            nbt.putLong(Keys.BlockEntities.ENERGY_AMOUNT, storage.getAmount());
            nbtList.add(nbt);
        }
        return nbtList;
    }

    /**
     * Deserializes the energy storage data from an NBT list.
     * This method is used to restore the energy storage state from saved data.
     *
     * @param nbt            The NbtList containing the serialized energy storage data.
     * @param registryLookup The registry lookup to use when deserializing the object.
     */
    @Override
    public void readNbt(NbtList nbt, RegistryWrapper.WrapperLookup registryLookup)
    {
        for(int index = 0; index < nbt.size(); index++)
        {
            NbtCompound compound = nbt.getCompound(index);
            this.storages.get(index).amount = compound.getLong(Keys.BlockEntities.ENERGY_AMOUNT);
        }
    }
    //endregion
}