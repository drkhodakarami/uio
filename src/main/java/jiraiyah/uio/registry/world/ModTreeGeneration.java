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
 * The `ModTreeGeneration` class is responsible for managing the registration
 * and initialization of tree-related data within the mod. This class is part
 * of the world generation registry and ensures that tree data is properly
 * set up during the mod's initialization phase.
 *
 * <p>Note: This class cannot be instantiated as it is designed to be used
 * statically.</p>
 */
public class ModTreeGeneration
{
    /**
     * Constructs a new instance of `ModTreeGeneration`.
     *
     * <p>This constructor is package-private and throws an `AssertionError`
     * to prevent instantiation of the class, as all functionality is intended
     * to be accessed statically.</p>
     *
     * @throws AssertionError Always thrown to prevent instantiation.
     */
    ModTreeGeneration()
    {
        throw new AssertionError();
    }

    /**
     * Initializes the tree data registration process.
     *
     * <p>This method logs a message indicating the start of the tree data
     * registration. It should be called during the mod's initialization
     * phase to ensure that all necessary tree data is registered correctly.</p>
     */
    public static void init()
    {
        LOGGER.log("Registering Tree Data");
    }
}