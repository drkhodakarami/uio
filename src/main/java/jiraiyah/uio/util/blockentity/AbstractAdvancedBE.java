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

package jiraiyah.uio.util.blockentity;

import jiraiyah.uio.util.inventory.IWrappedInventory;
import jiraiyah.uio.util.inventory.OutputSimpleInventory;
import jiraiyah.uio.util.inventory.WrappedInventoryStorage;
import jiraiyah.uio.util.network.BlockPosPayload;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import static jiraiyah.uio.Reference.Keys.BlockEntities.*;

/**
 * Abstract class that represents an advanced block entity with
 * functionalities like a screen handler, ticking, and inventory, energy, fluid management.
 *
 * @author jiraiyah
 */
public abstract class AbstractAdvancedBE extends UpdatableBE implements ExtendedScreenHandlerFactory<BlockPosPayload>, ITickBE, IWrappedInventory<SimpleInventory>
{

    /**
     * The wrapped inventory of type Simple Inventory for the block entity.
     */
    private final WrappedInventoryStorage<SimpleInventory> inventory;


    /**
     * The index of output inventory. This constant is always the same
     * because we are registering the output inventory as index zero all the time.
     */
    public static final int OUTPUT_INV_INDEX = 0;

    /**
     * The size of the output inventory, representing the maximum number of items
     * that can be held in this inventory. This constant can be overridden in
     * subclasses to accommodate different output capacities as needed. By default,
     * the output inventory is set to allow only one item, making it suitable for
     * scenarios where a single item output is required.
     */
    protected static final int OUTPUT_INV_SIZE = 1;

    /**
     * The direction in which the output inventory is oriented. This constant
     * defines the default direction for item extraction from the output inventory.
     * Subclasses can override this value if a different output direction is needed
     * for more specialized behavior. By default, the output direction is set to
     * Direction.DOWN, indicating that items are extracted downward from the block
     * entity.
     */
    protected static final Direction OUTPUT_INV_DIRECTION = Direction.DOWN;

    /**
     * Constructs a new instance of the AbstractAdvancedBE block entity.
     * This constructor initializes the block entity's inventory and sets up
     * the output inventory as the first inventory, making it ready for
     * item transfers. The constructor takes the necessary parameters to define
     * the type, position, and state of the block entity.
     *
     * @param type  The type of the block entity, used for identifying the block entity
     *              in the game.
     * @param pos   The position of the block entity in the world, represented as a
     *              BlockPos object.
     * @param state The block state of the block entity, indicating its current
     *              properties and behavior.
     */
    public AbstractAdvancedBE(BlockEntityType<?> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
        inventory = new WrappedInventoryStorage<>();
        addOutputInventory();
    }

    /**
     * Adds an output inventory to the block entity. This method is responsible
     * for initializing the output inventory, allowing items to be extracted or
     * transferred out of the block entity. It may be overridden in subclasses to
     * customize the direction, size, or behavior of the output inventory.
     * <p>
     * By default, this method adds an instance of OutputSimpleInventory with a
     * specified size and direction configured in the class. If modifications to
     * the inventory setup are needed, this method can be overridden accordingly.
     */
    protected void addOutputInventory()
    {
        this.inventory.addInventory(new OutputSimpleInventory(this, OUTPUT_INV_SIZE), OUTPUT_INV_DIRECTION);
    }

    /**
     * Executes the logic for the block entity on each tick. This method is called
     * every game tick (20 times per second) and can be overridden to implement
     * custom behavior that should occur regularly, such as processing inventory
     * updates, energy management, or other periodic actions.
     * <p>
     * This base implementation is empty and can be extended by subclasses to provide
     * specific functionality as needed.
     */
    @Override
    public void tick()
    {

    }

    /**
     * Deserializes the state of this block entity from an NBT compound. This method
     * is responsible for retrieving and reconstructing the essential data of the
     * block entity, including its inventory, from the NBT format into memory. It
     * extends the base behavior to ensure that the inventory is correctly restored
     * when the block entity is loaded or initialized.
     *
     * @param nbt        The NbtCompound containing the data to be read and restored to
     *                   the block entity.
     * @param registries The wrapper lookup registries used for deserialization
     *                   of associated data.
     */
    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries)
    {
        super.readNbt(nbt, registries);
        if (nbt.contains(INVENTORY_KEY, NbtElement.LIST_TYPE))
            this.inventory.readNbt(nbt.getList(INVENTORY_KEY, NbtElement.COMPOUND_TYPE), registries);
    }

    /**
     * Serializes the state of this block entity to an NBT compound for storage or
     * transmission. This method is responsible for converting essential data of the
     * block entity, including its inventory, into a format that can be saved in the
     * game's NBT format. It extends the base behavior by adding the inventory data
     * for later retrieval.
     *
     * @param nbt        The NbtCompound where the block entity's data will be written to.
     * @param registries The wrapper lookup registries used for serialization of
     *                   associated data.
     */
    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries)
    {
        super.writeNbt(nbt, registries);
        nbt.put(INVENTORY_KEY, this.inventory.writeNbt(registries));
    }

    /**
     * Creates a packet that is sent to the client to update the block entity's state.
     * This packet includes all necessary data to synchronize the client with the current
     * state of the block entity on the server.
     *
     * @return A packet containing the block entity update or null if there is no update.
     */
    @Override
    public @Nullable Packet<ClientPlayPacketListener> toUpdatePacket()
    {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    /**
     * Converts the initial chunk data of this block entity into an NBT compound.
     * This allows the block entity to serialize its initial state for sending
     * to clients when the chunk is loaded. This includes the inventory and any
     * other relevant data necessary for the client to replicate the block entity's
     * state accurately.
     *
     * @param registries The wrapper lookup registries used for serialization.
     *
     * @return An NbtCompound containing the initial chunk data of the block entity.
     */
    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registries)
    {
        NbtCompound nbt = super.toInitialChunkDataNbt(registries);
        writeNbt(nbt, registries);
        return nbt;
    }

    /**
     * Retrieves the wrapped inventory storage of this block entity.
     * The inventory storage contains all inventories associated with the
     * block entity and allows for various inventory operations.
     *
     * @return The WrappedInventoryStorage instance containing the block entity's inventory.
     */
    @Override
    public WrappedInventoryStorage<SimpleInventory> getInventory()
    {
        return this.inventory;
    }

    /**
     * Retrieves the storage for the inventory associated with this block entity
     * in the specified direction. This method allows for accessing the inventory
     * storage in relation to the block entity's orientation, enabling proper
     * interactions with neighboring blocks or entities.
     *
     * @param direction The direction from which the inventory storage is being accessed.
     *                  If null, the storage for all directions may be considered.
     *
     * @return The InventoryStorage instance for the specified direction, or null if
     * no inventory storage exists in that direction.
     */
    @Override
    public InventoryStorage getInventoryStorage(@Nullable Direction direction)
    {
        return this.inventory.getStorage(direction);
    }

    /**
     * Retrieves the output inventory of this block entity. The output inventory is
     * specifically designated for holding items that can be extracted or transferred
     * from the block entity. If the inventory has been initialized and contains output
     * storage, this method returns the corresponding SimpleInventory; otherwise,
     * it returns null.
     *
     * @return The SimpleInventory instance representing the output inventory, or
     * null if no output inventory exists or is initialized.
     */
    @Override
    public SimpleInventory getOutputInventory()
    {
        if (!this.inventory.getStorages().isEmpty())
            return this.inventory.getInventory(OUTPUT_INV_INDEX);
        else
            return null;
    }
}