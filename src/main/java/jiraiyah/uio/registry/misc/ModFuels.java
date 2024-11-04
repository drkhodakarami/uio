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

import jiraiyah.uio.registry.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;

import static jiraiyah.uio.Reference.log;

/**
 * The `ModFuels` class is responsible for registering custom fuel items
 * within the mod. It utilizes the `FuelRegistryEvents` to add new fuels
 * and their respective burn times. This class is not intended to be instantiated.
 */
public class ModFuels
{
    /**
     * Private constructor to prevent instantiation of the `ModFuels` class.
     * This class is designed to be used statically and should not be instantiated.
     * An `AssertionError` is thrown if an attempt is made to create an instance.
     */
    ModFuels()
    {
        throw new AssertionError();
    }

    /**
     * Initializes the fuel registration process. This method logs the registration
     * action and registers the custom fuel items with their burn times using the
     * `FuelRegistryEvents.BUILD` event. The `HOT_COAL` item is registered with a
     * burn time calculated as 32 times the base smelt time.
     */
    public static void init()
    {
        log("Registering Fuel");

        FuelRegistryEvents.BUILD.register((builder, context) ->
                                          {
                                              builder.add(ModItems.HOT_COAL, context.baseSmeltTime() * 32); //6400
                                          });
    }
}