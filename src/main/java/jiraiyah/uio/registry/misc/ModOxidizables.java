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

package jiraiyah.uio.registry.misc;

import static jiraiyah.uio.Main.LOGGER;

/**
 * The `ModOxidizables` class is responsible for managing the registration
 * of oxidizable items within the application. This class is not intended
 * to be instantiated, as it serves a static utility purpose.
 */
public class ModOxidizables
{
    /**
     * Constructs a new `ModOxidizables` instance. This constructor is private
     * to prevent instantiation of this utility class. Attempting to instantiate
     * this class will result in an `AssertionError`.
     */
    ModOxidizables()
    {
        throw new AssertionError();
    }

    /**
     * Initializes the registration process for oxidizable items. This method
     * logs a message indicating the start of the registration process. It is
     * intended to be called during the application's setup phase.
     */
    public static void init()
    {
        LOGGER.log("Registering Oxidizables");
    }
}