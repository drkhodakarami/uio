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

package jiraiyah.uio.registry;

import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static jiraiyah.uio.Main.LOGGER;

/**
 * The ModMessages class is responsible for handling network communication
 * between the server and clients within the mod.
 *
 * <p>
 * This class includes methods to register client-to-server (C2S) and
 * server-to-client (S2C) packets, as well as sending custom payloads
 * to players based on their tracking status in the game world.
 * The logging functionality integrated within these methods helps
 * monitor the registration and transmission of network messages,
 * which is essential for debugging and performance evaluation.
 * </p>
 */
public class ModMessages
{
    /**
     * Private constructor to prevent instantiation of the ModMessages class.
     * This class is intended to be a static utility class.
     */
    ModMessages()
    {
        throw new AssertionError();
    }

    /**
     * Registers client-to-server (C2S) packets for the mod.
     * <p>
     * This method establishes the communication protocol
     * for client-to-server messages by registering the
     * necessary C2S packets. It logs the registration
     * process to a designated log file, which aids in
     * monitoring and debugging the interaction
     * between clients and the server.
     * </p>
     */
    public static void registerC2SPackets()
    {
        LOGGER.log("Registering C2S Messages");
    }

    /**
     * Registers server-to-client (S2C) packets for the mod.
     * <p>
     * This method is responsible for setting up the necessary
     * communication between the server and the client by
     * registering the S2C messages. It logs the registration
     * process to the designated log file to help with debugging
     * and tracking the packet registration flow.
     * </p>
     */
    public static void registerS2CPackets()
    {
        LOGGER.log("Registering S2C Messages");
    }

    /**
     * Sends a custom payload to all players tracking a specific entity in the world.
     *
     * @param world   The world in which the players are located.
     * @param pos     The position of the entity to track.
     * @param payload The custom payload to be sent to the players.
     *                <p>
     *                This method identifies all players within the tracking area of the specified
     *                entity's position and sends the provided custom payload to each of them.
     *                This is useful for updating players with information related to entities
     *                they are interacting with or observing.
     *                </p>
     */
    public static void sendToClientPlayerEntities(World world, BlockPos pos, CustomPayload payload)
    {
        LOGGER.log("Sending a message to client player entities.");

        PlayerLookup.tracking((ServerWorld) world, pos).forEach(player ->
                                                                        ServerPlayNetworking.send(player, payload));
    }
}