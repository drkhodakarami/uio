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

import jiraiyah.uio.util.record.CoordinateData;
import net.minecraft.component.ComponentType;

import static jiraiyah.jiregister.Registers.ComponentType.register;
import static jiraiyah.uio.Main.LOGGER;

/**
 * This class is responsible for managing and registering custom data component types
 * used within the mod. It provides a static method to initialize and register these
 * component types, ensuring they are available for use throughout the application.
 */
public class ModDataComponentTypes
{
    /**
     * Private constructor to prevent instantiation of this utility class.
     * This class is not meant to be instantiated, as it only contains static methods
     * and fields for managing component types.
     *
     * @throws AssertionError if this constructor is ever called.
     */
    ModDataComponentTypes()
    {
        throw new AssertionError();
    }

    public static ComponentType<CoordinateData> COORDINATE;

    /**
     * Initializes and registers custom data component types.
     * This method logs the registration process and sets up the `COORDINATE` component type
     * using the `CoordinateData` codec. It should be called during the mod's initialization
     * phase to ensure all custom component types are properly registered.
     */
    public static void init()
    {
        LOGGER.log("Registering custom data component types");

        COORDINATE = register("coordinates", builder -> builder.codec(CoordinateData.CODEC));
    }
}