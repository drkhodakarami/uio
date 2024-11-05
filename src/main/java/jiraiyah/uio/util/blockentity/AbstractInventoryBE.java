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

import jiraiyah.uio.util.inventory.IWrappedInventoryProvider;
import jiraiyah.uio.util.inventory.WrappedInventoryStorage;
import jiraiyah.uio.util.network.BlockPosPayload;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import static jiraiyah.uio.Reference.Keys.BlockEntities.*;

/**
 * Abstract class that represents an advanced block entity with
 * functionalities like a screen handler, ticking, and inventory management.
 *
 * @author jiraiyah
 */
public abstract class AbstractInventoryBE extends UpdatableBE implements ExtendedScreenHandlerFactory<BlockPosPayload>, ITickBE, IWrappedInventoryProvider
{
    /**
     * The wrapped inventory storage for this block entity.
     * This instance of WrappedInventoryStorage is responsible for managing
     * the inventories associated with the block entity, allowing various
     * inventory operations such as adding, retrieving, and managing items.
     *
     * <p>The inventory is initialized as an empty storage and can be used
     * to facilitate item transfer and interaction with neighboring blocks
     * or entities.</p>
     *
     * <p>This is a shared instance, and its state should be managed
     * carefully to ensure thread safety and consistency across different
     * operations.</p>
     */
    private final WrappedInventoryStorage<SimpleInventory> inventory = new WrappedInventoryStorage<>();

    /**
     * Constructs a new instance of the AbstractInventoryBE block entity.
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
    public AbstractInventoryBE(BlockEntityType type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
    }

    /**
     * Adds an output inventory to this block entity.
     * <p>
     * This method initializes an output inventory of the specified size, allowing
     * items to be extracted or transferred from the block entity in the specified
     * direction. The output inventory facilitates item management and interactions
     * with neighboring blocks or entities.
     * </p>
     *
     * @param size     The size (capacity) of the output inventory. This determines
     *                 how many items the inventory can hold.
     * @param direction The direction from which items can be extracted from the
     *                  output inventory. This parameter can restrict access to the
     *                  inventory from a specific direction (e.g., NORTH, SOUTH).
     *                  If set to null, the inventory may be accessible from all
     *                  directions.
     */
    @Override
    public void addOutputInventory(int size, Direction direction)
    {
        inventory.addDefaultOutputInventory(this, size, direction);
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
        return inventory.getStorage(direction);
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
            return this.inventory.getInventory(DEFAULT_OUTPUT_INDEX);
        else
            return null;
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
        if (nbt.contains(HAS_INVENTORY, NbtElement.COMPOUND_TYPE))
            inventory.readNbt(nbt.getList(HAS_INVENTORY, NbtElement.COMPOUND_TYPE), registries);
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
        nbt.put(HAS_INVENTORY, inventory.writeNbt(registries));
    }

    /**
     * Retrieves the data necessary for opening a screen on the client side.
     * This method is used to provide the client with the position of the block entity
     * when a screen associated with this block entity is opened. The position is
     * encapsulated in a {@link BlockPosPayload} object, which is sent to the client
     * to ensure that the correct block entity is referenced.
     *
     * @param player The server-side player entity requesting the screen opening data.
     *               This parameter represents the player who is interacting with the
     *               block entity and is used to determine the context of the interaction.
     *
     * @return A {@link BlockPosPayload} containing the position of this block entity.
     *         This payload is used to synchronize the client with the server, ensuring
     *         that the correct block entity's screen is opened.
     */
    @Override
    public BlockPosPayload getScreenOpeningData(ServerPlayerEntity player)
    {
        return new BlockPosPayload(this.pos);
    }

    /**
     * Retrieves the display name of this block entity. This name is used to
     * represent the block entity in the user interface, such as in the title
     * of a screen or in tooltips. By default, this method returns null, indicating
     * that no specific display name is set for this block entity.
     * <p>
     * Subclasses can override this method to provide a custom display name
     * that is more descriptive or context-specific, enhancing the user experience
     * by providing meaningful information about the block entity.
     *
     * @return A {@link Text} object representing the display name of this block entity,
     *         or null if no display name is set.
     */
    @Override
    public Text getDisplayName()
    {
        return null;
    }

    /**
     * Creates a screen handler for the block entity, which is used to manage
     * the interaction between the player's inventory and the block entity's inventory.
     * This method is called when a player opens the block entity's screen, allowing
     * for the synchronization of inventory data between the client and server.
     * <p>
     * By default, this method returns null, indicating that no specific menu is
     * created for this block entity. Subclasses can override this method to provide
     * a custom screen handler that facilitates interaction with the block entity's
     * inventory or other functionalities.
     * <p>
     * Example usage:
     * <pre>
     * {@code
     * @Override
     * public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
     *     return new SomeScreenHandler(syncId, playerInventory, this);
     * }
     * }
     * </pre>
     *
     * @param syncId           The synchronization ID for the screen handler. This ID is used
     *                         to ensure that the client and server are synchronized when
     *                         interacting with the block entity's inventory.
     * @param playerInventory  The player's inventory, which is used to manage the items
     *                         that the player is carrying. This parameter allows the screen
     *                         handler to interact with the player's inventory.
     * @param player           The player entity interacting with the block entity. This
     *                         parameter provides context for the interaction, such as
     *                         the player's position and state.
     *
     * @return A {@link ScreenHandler} instance representing the menu for the block entity,
     *         or null if no menu is created.
     */
    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player)
    {
        return null;
    }
}