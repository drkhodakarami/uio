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

import jiraiyah.uio.util.block.abstracts.machine.AbstractActivatableMachineBlock;
import jiraiyah.uio.util.energy.IWrappedEnergyProvider;
import jiraiyah.uio.util.fluid.IWrappedFluidProvider;
import jiraiyah.uio.util.fluid.SyncedFluidStorage;
import jiraiyah.uio.util.fluid.WrappedFluidStorage;
import jiraiyah.uio.util.network.BlockPosPayload;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
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
import org.jetbrains.annotations.Nullable;

import static jiraiyah.uio.Reference.Keys.BlockEntities.HAS_FLUID;
import static jiraiyah.uio.Reference.Keys.BlockEntities.HAS_INVENTORY;

/**
 * The abstract extension of Activatable Machine Block. This class handles fluid storage related logic.
 *
 * @author jiraiyah
 */
public abstract class AbstractFluidBE extends UpdatableBE implements ExtendedScreenHandlerFactory<BlockPosPayload>, ITickBE, IWrappedFluidProvider
{
    /**
     * The wrapped fluid storage instance used by this provider.
     *
     * <p>
     * This instance manages multiple {@link SyncedFluidStorage} instances and
     * provides methods to interact with them.
     * </p>
     */
    private final WrappedFluidStorage<SyncedFluidStorage> fluidStorage = new WrappedFluidStorage<>();

    /**
     * Constructs a new instance of the AbstractFluidBE block entity.
     * The constructor takes the necessary parameters to define
     * the type, position, and state of the block entity.
     *
     * @param type  The type of the block entity, used for identifying the block entity
     *              in the game.
     * @param pos   The position of the block entity in the world, represented as a
     *              BlockPos object.
     * @param state The block state of the block entity, indicating its current
     *              properties and behavior.
     */
    public AbstractFluidBE(BlockEntityType<?> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
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
     * Adds a fluid storage to the block entity with the specified capacity.
     * This method initializes a new fluid storage for the block entity,
     * allowing it to store and manage fluids up to the given capacity.
     *
     * @param capacity The maximum capacity of the fluid storage in terms of fluid units.
     *                 This value determines how much fluid the storage can hold.
     *                 It should be a positive long value representing the fluid capacity.
     */
    @Override
    public void addFluidStorage(long capacity)
    {
        fluidStorage.addStorage(this, capacity);
    }

    /**
     * Retrieves the wrapped fluid storage instance.
     *
     * @return The wrapped fluid storage instance.
     */
    @Override
    public WrappedFluidStorage<SyncedFluidStorage> getFluidStorage()
    {
        return this.fluidStorage;
    }

    /**
     * Reads the block entity's data from an NBT compound.
     * This method is responsible for deserializing the block entity's state,
     * including its fluid storage, from the provided NBT data.
     *
     * @param nbt        The NBT compound containing the serialized data of the block entity.
     *                   This compound includes all necessary information to reconstruct
     *                   the block entity's state.
     * @param registries The registry lookup used for deserialization. This parameter
     *                   provides access to the necessary registries for decoding
     *                   the block entity's data.
     */
    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries)
    {
        super.readNbt(nbt, registries);
        if (nbt.contains(HAS_FLUID, NbtElement.COMPOUND_TYPE))
            this.fluidStorage.readNbt(nbt.getList(HAS_FLUID, NbtElement.COMPOUND_TYPE), registries);
    }

    /**
     * Writes the block entity's data to an NBT compound.
     * This method is responsible for serializing the block entity's state,
     * including its fluid storage, into the provided NBT compound.
     *
     * @param nbt        The NBT compound to which the block entity's data will be written.
     *                   This compound will be populated with all necessary information
     *                   to reconstruct the block entity's state.
     * @param registries The registry lookup used for serialization. This parameter
     *                   provides access to the necessary registries for encoding
     *                   the block entity's data.
     */
    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries)
    {
        super.writeNbt(nbt, registries);
        nbt.put(HAS_FLUID, this.fluidStorage.writeNbt(registries));
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