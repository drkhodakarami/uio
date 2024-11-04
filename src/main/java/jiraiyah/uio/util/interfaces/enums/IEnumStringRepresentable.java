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

package jiraiyah.uio.util.interfaces.enums;

import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;

import java.util.Objects;

/**
 * An interface for enums that can be represented as a string.
 *
 * @author TurtyWurty
 */
public interface IEnumStringRepresentable
{
    /**
     * Returns the enum object represented by the string.
     *
     * @param enumClass      The class of the enum.
     * @param serializedName The string representation of the enum.
     * @param <T>            The type of the enum.
     *
     * @return The enum object represented by the string.
     */
    static <T extends Enum<?> & IEnumStringRepresentable> T getEnumByName(Class<T> enumClass, String serializedName)
    {
        return getEnumByName(enumClass.getEnumConstants(), serializedName);
    }

    /**
     * Returns the enum object represented by the string.
     *
     * @param enumConstants  The array of enum constants.
     * @param serializedName The string representation of the enum.
     * @param <T>            The type of the enum.
     *
     * @return The enum object represented by the string.
     */
    static <T extends Enum<?> & IEnumStringRepresentable> T getEnumByName(T[] enumConstants, String serializedName)
    {
        for (T value : enumConstants)
            if (Objects.equals(value.getSerializedName(), serializedName))
                return value;
        return null;
    }

    /**
     * @return The string representation of the enum.
     */
    String getSerializedName();
}