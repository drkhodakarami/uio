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
 * The `ModFlowerGeneration` class is responsible for managing the registration
 * and generation of custom flower data within the game world. This class
 * utilizes the mod's logging system to provide feedback during the
 * initialization process.
 * <p>
 * Note: This class cannot be instantiated as it is designed to be used
 * statically.
 */
public class ModFlowerGeneration
{
    /**
     * Private constructor to prevent instantiation of the `ModFlowerGeneration` class.
     * <p>
     * This constructor throws an `AssertionError` if called, ensuring that the
     * class is used only in a static context.
     */
    ModFlowerGeneration()
    {
        throw new AssertionError();
    }

    /**
     * Initializes the flower generation process by registering the necessary
     * flower data. This method logs the registration activity to the console
     * if debugging is enabled.
     * <p>
     * This method should be called during the mod's initialization phase to
     * ensure that all custom flower data is properly registered.
     */
    public static void init()
    {
        LOGGER.log("Registering Flower Data");
    }
}