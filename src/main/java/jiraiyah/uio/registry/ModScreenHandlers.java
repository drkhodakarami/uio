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

import static jiraiyah.uio.Main.LOGGER;

/**
 * The ModScreenHandlers class is responsible for managing the screen handlers
 * for the mod. It provides initialization functionality to register screen
 * handlers necessary for user interface interactions within the mod.
 */
public class ModScreenHandlers
{
    /**
     * Private constructor for the ModScreenHandlers class. This constructor
     * is intended to prevent instantiation of the class, as it is designed
     * to be a utility class that only provides static methods. Attempting to
     * create an instance will result in an AssertionError.
     */
    ModScreenHandlers()
    {
        throw new AssertionError();
    }

    /**
     * Initializes the mod's screen handlers. This method is called during the
     * mod's setup phase to register all necessary screen handlers.
     */
    public static void init()
    {
        LOGGER.log("Registering Screen Handlers");
    }
}