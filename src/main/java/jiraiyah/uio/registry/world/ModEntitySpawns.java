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

package jiraiyah.uio.registry.world;

import static jiraiyah.uio.Main.LOGGER;

/**
 * The `ModEntitySpawns` class is responsible for managing the registration
 * of entity spawn data within the game world. This class is designed to
 * handle the setup and configuration of entity spawning behavior.
 * <p>
 * Note: This class cannot be instantiated as it is intended to be used
 * statically.
 */
public class ModEntitySpawns
{
    /**
     * Private constructor to prevent instantiation of the `ModEntitySpawns` class.
     * <p>
     * This constructor throws an `AssertionError` to ensure that the class
     * is used only in a static context.
     */
    ModEntitySpawns()
    {
        throw new AssertionError();
    }

    /**
     * Registers the entity spawn data for the game world.
     * <p>
     * This method logs a message indicating that the entity spawn data
     * registration process has begun. It is intended to be called during
     * the initialization phase of the game to set up entity spawning.
     */
    public static void addSpawns()
    {
        LOGGER.log("Registering Entity Spawn Data");
    }
}