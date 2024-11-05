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

import jiraiyah.uio.util.energy.IWrappedEnergyProvider;
import jiraiyah.uio.util.energy.SyncedEnergyStorage;
import jiraiyah.uio.util.energy.WrappedEnergyStorage;
import jiraiyah.uio.util.network.BlockPosPayload;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import static jiraiyah.uio.Reference.Keys.BlockEntities.*;

/**
 * The abstract extension of Activatable Machine Block. This class handles energy related logic.
 *
 * @author jiraiyah
 */
public abstract class AbstractEnergyBE extends UpdatableBE implements ExtendedScreenHandlerFactory<BlockPosPayload>, ITickBE, IWrappedEnergyProvider
{
    /**
     * The {@link WrappedEnergyStorage} instance that holds the current energy storage.
     * This instance is shared across implementations of the {@code IWrappedEnergyProvider}
     * and provides methods for managing energy within the storage units.
     *
     * <p>
     * It is initialized as an empty storage and can be configured using the
     * {@link #AddEnergyStorage(int, int, int, Direction)} method to add new
     * energy storage units with specified parameters.
     * </p>
     */
    private final WrappedEnergyStorage<SyncedEnergyStorage> energyStorage = new WrappedEnergyStorage<>();

    /**
     * Constructor for the AbstractEnergyBE class. Initializes a new block entity with the specified
     * type, position, and state.
     *
     * @param type  The type of the block entity.
     * @param pos   The position of the block entity in the world.
     * @param state The current state of the block.
     */
    public AbstractEnergyBE(BlockEntityType<?> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
    }

    /**
     * Adds a new energy storage to this block entity with the specified capacity,
     * maximum insertion rate, maximum extraction rate, and direction.
     * <p>
     * This method allows the block entity to manage energy storage by adding a
     * new {@link SyncedEnergyStorage} instance to the internal {@link WrappedEnergyStorage}.
     * The energy storage can be configured to accept energy from a specific direction
     * or from all directions if no direction is specified.
     * <p>
     * Example usage:
     * <pre>
     * {@code
     * addEnergyStorage(10000, 100, 100, Direction.NORTH);
     * }
     * </pre>
     *
     * @param capacity  The maximum amount of energy that the storage can hold.
     *                  This parameter defines the total energy capacity of the storage.
     * @param maxInsert The maximum amount of energy that can be inserted into the storage per tick.
     *                  This parameter limits the rate at which energy can be added to the storage.
     * @param maxExtract The maximum amount of energy that can be extracted from the storage per tick.
     *                   This parameter limits the rate at which energy can be removed from the storage.
     * @param direction The direction from which energy can be inserted or extracted.
     *                  If null, energy can be inserted or extracted from all directions.
     */
    @Override
    public void AddEnergyStorage(int capacity, int maxInsert, int maxExtract, Direction direction)
    {
        energyStorage.addStorage(this, capacity, maxInsert, maxExtract, direction);
    }

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
    @Override
    public WrappedEnergyStorage<SyncedEnergyStorage> getEnergyStorage()
    {
        return this.energyStorage;
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
     * block entity, including its energy storage, from the NBT format into memory. It
     * extends the base behavior to ensure that the energy storage is correctly restored
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
        if(nbt.contains(HAS_ENERGY, NbtElement.COMPOUND_TYPE))
            energyStorage.readNbt(nbt.getList(HAS_ENERGY, NbtElement.COMPOUND_TYPE), registries);
    }

    /**
     * Serializes the state of this block entity to an NBT compound for storage or
     * transmission. This method is responsible for converting essential data of the
     * block entity, including its energy storage, into a format that can be saved in the
     * game's NBT format. It extends the base behavior by adding the energy storage data
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
        nbt.put(HAS_ENERGY, energyStorage.writeNbt(registries));
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