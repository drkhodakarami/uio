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

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

/**
 * This interface is used to mark block entities that need to be updated between server and client..
 *
 * @author TurtyWurty
 */
public class UpdatableBE extends BlockEntity
{
    public UpdatableBE(BlockEntityType<?> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
    }

    /**
     * The update method is called whenever there is a change that needs to be synced between server and client.
     * This method already handles the sync process, so you don't need to worry about that.
     */
    public void update()
    {
        markDirty();

        if (this.world != null)
            this.world.updateListeners(this.pos, getCachedState(), getCachedState(), Block.NOTIFY_ALL);
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
}