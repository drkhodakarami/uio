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

package jiraiyah.uio.util.inventory;

import jiraiyah.uio.util.blockentity.UpdatableBE;
import jiraiyah.uio.util.interfaces.NBTSerializable;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.CombinedStorage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleSlotStorage;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.*;

/**
 * A wrapper for multiple, sided, inventories that implements the {@link InventoryStorage} interface.
 *
 * @author TurtyWurty
 */
@SuppressWarnings("unused")
public class WrappedInventoryStorage<T extends SimpleInventory> implements NBTSerializable<NbtList>
{
    private final List<T> inventories = new ArrayList<>();
    private final List<InventoryStorage> storages = new ArrayList<>();
    private final Map<Direction, InventoryStorage> sidedStorageMap = new HashMap<>();
    private final CombinedStorage<ItemVariant, InventoryStorage> combinedStorage = new CombinedStorage<>(this.storages);

    /**
     * Creates a new WrappedInventoryStorage with the given inventories.
     * The inventory will be assigned to all directions because we didn't set a specific direction for the inventory.
     *
     * @param inventory the inventory to wrap
     */
    public void addInventory(@NotNull T inventory)
    {
        addInventory(inventory, null);
    }

    /**
     * Creates a new WrappedInventoryStorage with the given inventory and direction.
     *
     * @param inventory the inventory to wrap
     * @param direction the direction to assign the inventory to. If null, the inventory will be assigned to all directions.
     */
    public void addInventory(@NotNull T inventory, Direction direction)
    {
        this.inventories.add(inventory);
        InventoryStorage storage = InventoryStorage.of(inventory, direction);
        this.storages.add(storage);
        this.sidedStorageMap.put(direction, storage);
    }

    //region Getter

    /**
     * @return the list of inventories wrapped by this storage.
     */
    public List<T> getInventories()
    {
        return inventories;
    }

    /**
     * @return the list of storages used by this storage.
     */
    public List<InventoryStorage> getStorages()
    {
        return storages;
    }

    /**
     * @return the map of direction to storage used by this storage.
     */
    public Map<Direction, InventoryStorage> getSidedStorageMap()
    {
        return sidedStorageMap;
    }

    /**
     * @return the combined storage used by this storage.
     */
    public CombinedStorage<ItemVariant, InventoryStorage> getCombinedStorage()
    {
        return combinedStorage;
    }

    public @Nullable SingleSlotStorage<ItemVariant> getSlot(int slot, Direction direction)
    {
        InventoryStorage storage = this.getStorage(direction);
        if (storage == null)
            return null;
        return storage.getSlot(slot);
    }

    public @Nullable List<SingleSlotStorage<ItemVariant>> getSlots(Direction direction)
    {
        InventoryStorage storage = this.getStorage(direction);
        if (storage == null)
            return null;
        return storage.getSlots();
    }

    /**
     * @param direction the direction to get the storage for.
     *
     * @return the storage for the given direction, or null if no storage is assigned to that direction.
     */
    public @Nullable InventoryStorage getStorage(Direction direction)
    {
        return this.sidedStorageMap.get(direction);
    }

    /**
     * @param index the index of the inventory to get.
     *
     * @return the inventory at the given index, or null if the index is out of bounds.
     */
    public @Nullable T getInventory(int index)
    {
        return this.inventories.get(index);
    }

    /**
     * @return the list of all stacks in the wrapped inventories.
     */
    public @NotNull List<ItemStack> getStacks()
    {
        List<ItemStack> stacks = new ArrayList<>();
        for (T inventory : this.inventories)
            for (int i = 0; i < inventory.size(); i++)
                stacks.add(inventory.getStack(i));
        return stacks;
    }

    /**
     * @param index the index of the inventory to get the stacks for.
     *
     * @return the list of all stacks in the inventory at the given index.
     *
     * @author Jiraiyah
     */
    public @NotNull List<ItemStack> getStacks(int index)
    {
        List<ItemStack> stacks = new ArrayList<>();
        T inventory = getInventory(index);
        if (inventory == null)
            return stacks;
        for (int i = 0; i < inventory.size(); i++)
            stacks.add(inventory.getStack(i));
        return stacks;
    }

    /**
     * @return a new {@link RecipeSimpleInventory} with all stacks in the wrapped inventories.
     */
    public RecipeSimpleInventory getRecipeInventory()
    {
        return new RecipeSimpleInventory(getStacks().toArray(new ItemStack[0]));
    }
    //endregion

    /**
     * Checks if the size of the wrapped inventories matches the given size.
     *
     * @param size the size to check against the wrapped inventories.
     */
    public void checkSize(int size)
    {
        if (this.inventories.stream().map(Inventory::size).reduce(9, Integer::sum) != size)
            throw new IllegalArgumentException("Size of inventories does not match the provided size: " + size);
    }

    /**
     * Called when the wrapped inventories are opened by a player.
     *
     * @param player the player to open the wrapped inventories for.
     */
    public void onOpen(@NotNull PlayerEntity player)
    {
        for (T inventory : this.inventories)
            inventory.onOpen(player);
    }

    /**
     * Called when the wrapped inventories are closed by a player.
     *
     * @param player the player to close the wrapped inventories for.
     */
    public void onClose(@NotNull PlayerEntity player)
    {
        for (T inventory : this.inventories)
            inventory.onClose(player);
    }

    /**
     * Drops the contents of the wrapped inventories at the given position.
     *
     * @param world the world to drop the contents in.
     * @param pos   the position to drop the contents at.
     */
    public void dropContents(@NotNull World world, @NotNull BlockPos pos)
    {
        for (T inventory : this.inventories)
            ItemScatterer.spawn(world, pos, inventory);
    }

    @SuppressWarnings("unchecked")
    public void addDefaultOutputInventory(UpdatableBE blockEntity, int size, Direction direction)
    {
        OutputSimpleInventory out = new OutputSimpleInventory(blockEntity, size);
        this.inventories.add((T) out);
        InventoryStorage storage = InventoryStorage.of(out, direction);
        this.storages.add(storage);
        this.sidedStorageMap.put(direction, storage);
    }

    //region Serialization

    /**
     * Serializes the wrapped inventories to NBT.
     *
     * @param registryLookup The registry lookup to use when serializing the object.
     *
     * @return the serialized NBT.
     */
    @Override
    public NbtList writeNbt(RegistryWrapper.WrapperLookup registryLookup)
    {
        NbtList nbt = new NbtList();
        for (T inventory : this.inventories)
        {
            NbtCompound inventoryNbt = new NbtCompound();
            nbt.add(Inventories.writeNbt(inventoryNbt, inventory.getHeldStacks(), registryLookup));
        }
        return nbt;
    }

    /**
     * Deserializes the wrapped inventories from NBT.
     *
     * @param nbt            The NBT element to read the object from.
     * @param registryLookup The registry lookup to use when deserializing the object.
     */
    @Override
    public void readNbt(NbtList nbt, RegistryWrapper.WrapperLookup registryLookup)
    {
        for (int index = 0; index < nbt.size(); index++)
        {
            NbtCompound inventoryNbt = nbt.getCompound(index);
            SimpleInventory inventory = this.inventories.get(index);
            Inventories.readNbt(inventoryNbt, inventory.getHeldStacks(), registryLookup);
        }
    }
    //endregion
}