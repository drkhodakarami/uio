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

package jiraiyah.uio.util.interfaces;

import net.minecraft.nbt.NbtElement;
import net.minecraft.registry.RegistryWrapper;

/**
 * An interface that allows for easy serialization and deserialization of objects to NBT.
 *
 * @param <T> The type of NBT element that will be used to serialize and deserialize the object.
 *
 *            <br>
 *            <h4>Example usage:
 *            <pre>{@code
 *                                            public class Example implements NBTSerializable<NbtCompound> {
 *                                               private int exampleInt;
 *                                               private String exampleString;
 *
 *                                               public Example(int exampleInt, String exampleString) {
 *                                                   this.exampleInt = exampleInt;
 *                                                   this.exampleString = exampleString;
 *                                               }
 *
 *                                               @Override
 *                                               public NbtCompound writeNbt(RegistryWrapper.WrapperLookup registryLookup) {
 *                                                   NbtCompound nbt = new NbtCompound();
 *                                                   nbt.putInt("exampleInt", this.exampleInt);
 *                                                   nbt.putString("exampleString", this.exampleString);
 *                                                   return nbt;
 *                                               }
 *
 *                                               @Override
 *                                               public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
 *                                                   this.exampleInt = nbt.getInt("exampleInt");
 *                                                   this.exampleString = nbt.getString("exampleString");
 *                                               }
 *                                            }
 *                                        }</pre>
 *
 * @author TurtyWurty
 */
public interface NBTSerializable<T extends NbtElement>
{
    /**
     * Writes the object to an NBT element.
     *
     * @param registryLookup The registry lookup to use when serializing the object.
     *
     * @return The NBT element that represents the object.
     */
    T writeNbt(RegistryWrapper.WrapperLookup registryLookup);

    /**
     * Reads the object from an NBT element.
     *
     * @param nbt            The NBT element to read the object from.
     * @param registryLookup The registry lookup to use when deserializing the object.
     */
    void readNbt(T nbt, RegistryWrapper.WrapperLookup registryLookup);
}