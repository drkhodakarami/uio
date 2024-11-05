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

import com.mojang.datafixers.util.Pair;
import jiraiyah.uio.util.blockentity.UpdatableBE;
import jiraiyah.uio.util.interfaces.NBTSerializable;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.CombinedStorage;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtOps;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jiraiyah.uio.Reference.Keys.BlockEntities.FLUID_AMOUNT;
import static jiraiyah.uio.Reference.Keys.BlockEntities.HAS_FLUID;

/**
 * A wrapper class for managing multiple {@link SyncedFluidStorage} instances.
 * This class provides methods to add, retrieve, and manage fluid storages
 * associated with different directions or indices.
 *
 * @param <T> The type of fluid storage being wrapped, extending {@link SyncedFluidStorage}.
 * @author TurtyWurty
 */
@SuppressWarnings("unused")
public class WrappedFluidStorage<T extends SyncedFluidStorage> implements NBTSerializable<NbtList>
{
    /**
     * A list of fluid storages managed by this wrapper.
     *
     * <p>
     * This list holds all the {@link SyncedFluidStorage} instances that are
     * managed by this wrapper. Each storage in the list can be accessed
     * individually or through associated directions.
     * </p>
     */
    private final List<T> storages = new ArrayList<>();

    /**
     * A map associating directions with their corresponding fluid storages.
     *
     * <p>
     * This map allows for quick retrieval of a {@link SyncedFluidStorage} based
     * on a specific {@link Direction}. It is used to manage storages that are
     * directionally dependent, enabling fluid operations to be performed
     * directionally.
     * </p>
     */
    private final Map<Direction, T> sidedStorageMap = new HashMap<>();

    /**
     * A combined storage that aggregates all fluid storages in this wrapper.
     *
     * <p>
     * This {@link CombinedStorage} instance provides a unified interface to
     * interact with all the fluid storages managed by this wrapper. It allows
     * for operations that span multiple storages, treating them as a single
     * entity.
     * </p>
     */
    private final CombinedStorage<FluidVariant, T> combinedStorage = new CombinedStorage<>(this.storages);

    /**
     * Adds a storage to the list without associating it with a specific direction.
     *
     * @param storage The storage to be added.
     */
    public void addStorage(T storage)
    {
        addStorage(storage, null);
    }

    /**
     * Adds a storage associated with a block entity and capacity.
     *
     * @param blockEntity The block entity associated with the storage.
     * @param capacity    The capacity of the storage.
     */
    public void addStorage(UpdatableBE blockEntity, long capacity)
    {
        addStorage(blockEntity, capacity, null);
    }

    /**
     * Adds a storage associated with a block entity, capacity, and direction.
     *
     * @param blockEntity The block entity associated with the storage.
     * @param capacity    The capacity of the storage.
     * @param direction   The direction associated with the storage.
     */
    @SuppressWarnings("unchecked")
    public void addStorage(UpdatableBE blockEntity, long capacity, Direction direction)
    {
        addStorage((T) new SyncedFluidStorage(blockEntity, capacity), direction);
    }

    /**
     * Adds a storage to the list and associates it with a specific direction.
     *
     * @param storage   The storage to be added.
     * @param direction The direction to associate with the storage.
     */
    public void addStorage(T storage, Direction direction)
    {
        this.storages.add(storage);

        if(direction == null)
        {
            for(Direction dir : Direction.values())
                this.sidedStorageMap.put(dir, storage);
        }
        else
            this.sidedStorageMap.put(direction, storage);
    }

    /**
     * Retrieves the list of all storages.
     *
     * @return A list of storages.
     */
    public List<T> getStorages()
    {
        return storages;
    }

    /**
     * Retrieves the map of storages associated with directions.
     *
     * @return A map of storages by direction.
     */
    public Map<Direction, T> getSidedStorageMap()
    {
        return sidedStorageMap;
    }

    /**
     * Retrieves the amount of fluid in the storage associated with a direction.
     *
     * @param direction The direction of the storage.
     * @return The amount of fluid.
     */
    public long getAmount(Direction direction)
    {
        return getStorage(direction).getAmount();
    }

    /**
     * Retrieves the capacity of the storage associated with a direction.
     *
     * @param direction The direction of the storage.
     * @return The capacity of the storage.
     */
    public long getCapacity(Direction direction)
    {
        return getStorage(direction).getCapacity();
    }

    /**
     * Retrieves the fluid type in the storage associated with a direction.
     *
     * @param direction The direction of the storage.
     * @return The fluid type.
     */
    public FluidVariant getType(Direction direction)
    {
        return getStorage(direction).getResource();
    }

    /**
     * Retrieves the amount of fluid in the storage at a specific index.
     *
     * @param index The index of the storage.
     * @return The amount of fluid.
     */
    public long getAmount(int index)
    {
        return getStorage(index).getAmount();
    }

    /**
     * Retrieves the capacity of the storage at a specific index.
     *
     * @param index The index of the storage.
     * @return The capacity of the storage.
     */
    public long getCapacity(int index)
    {
        return getStorage(index).getCapacity();
    }

    /**
     * Retrieves the fluid type in the storage at a specific index.
     *
     * @param index The index of the storage.
     * @return The fluid type.
     */
    public FluidVariant getType(int index)
    {
        return getStorage(index).getResource();
    }

    /**
     * Retrieves the storage associated with a direction.
     *
     * @param direction The direction of the storage.
     * @return The storage associated with the direction.
     */
    public T getStorage(Direction direction)
    {
        if(direction == null)
            return this.storages.getFirst();
        return this.sidedStorageMap.get(direction);
    }

    /**
     * Retrieves the storage at a specific index.
     *
     * @param index The index of the storage.
     * @return The storage at the index.
     */
    public T getStorage(int index)
    {
        return this.storages.get(index);
    }

    /**
     * Retrieves a list of fluid stacks representing the fluids in all storages.
     *
     * @return A list of fluid stacks.
     */
    public List<FluidStack> getFluids()
    {
        List<FluidStack> fluids = new ArrayList<>();
        for (T storage : this.storages)
            fluids.add(new FluidStack(storage.getResource(), storage.getAmount()));
        return fluids;
    }

    /**
     * Serializes the fluid storages to an NBT list.
     *
     * @param registryLookup The registry lookup for serialization.
     * @return An NBT list representing the fluid storages.
     */
    @Override
    public NbtList writeNbt(RegistryWrapper.WrapperLookup registryLookup)
    {
        NbtList list = new NbtList();
        for(T storage : this.storages)
        {
            NbtCompound nbt = new NbtCompound();
            nbt.putLong(FLUID_AMOUNT, storage.getAmount());
            nbt.put(HAS_FLUID,
                    FluidVariant.CODEC.encode(storage.getResource(),
                                              NbtOps.INSTANCE, new NbtCompound())
                                      .getOrThrow());
            list.add(nbt);
        }
        return list;
    }

    /**
     * Deserializes the fluid storages from an NBT list.
     *
     * @param nbt            The NBT list to read from.
     * @param registryLookup The registry lookup for deserialization.
     */
    @Override
    public void readNbt(NbtList nbt, RegistryWrapper.WrapperLookup registryLookup)
    {
        for (int index = 0; index < nbt.size(); index++)
        {
            NbtCompound compound = nbt.getCompound(index);
            if(!compound.contains(HAS_FLUID))
                continue;
            this.storages.get(index).amount = compound.getLong(FLUID_AMOUNT);
            this.storages.get(index).variant = FluidVariant.CODEC.decode(NbtOps.INSTANCE, compound.get(HAS_FLUID))
                    .map(Pair::getFirst)
                    .getOrThrow();
        }
    }
}