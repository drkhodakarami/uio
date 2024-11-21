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
 * The {@code ModWorldGeneration} class is responsible for coordinating the registration
 * of various world generation features, such as geodes, ores, trees, flowers, and entity spawns.
 * <p>
 * This class is designed as a utility class and cannot be instantiated.
 */
public class ModWorldGeneration
{
    /**
     * Private constructor to prevent instantiation of this utility class.
     * <p>
     * Throws an {@code AssertionError} if called, ensuring that the class
     * is used only in a static context.
     */
    ModWorldGeneration()
    {
        throw new AssertionError();
    }

    /**
     * Initializes and registers all world generation features.
     * <p>
     * This method logs the registration process and invokes the generation
     * methods from other classes to set up geodes, ores, trees, flowers,
     * and entity spawns. It should be called during the initialization phase
     * of the mod to ensure all features are properly registered.
     */
    public static void init()
    {
        LOGGER.log("Registering World Generation");

        ModGeodeGeneration.init();
        ModOreGeneration.init();
        ModTreeGeneration.init();
        ModFlowerGeneration.init();
        ModEntitySpawns.addSpawns();
    }
}