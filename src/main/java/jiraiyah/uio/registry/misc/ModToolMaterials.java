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

import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

import static jiraiyah.uio.Main.REFERENCE;

/**
 * The {@code ModToolMaterials} class is responsible for defining custom tool materials
 * used within the mod. It initializes various tool materials with specific properties
 * such as durability, mining speed, attack damage, and enchantability.
 * <p>
 * This class is not meant to be instantiated, as indicated by the private constructor
 * that throws an {@code AssertionError}.
 */
public class ModToolMaterials
{
    /**
     * Private constructor to prevent instantiation of the {@code ModToolMaterials} class.
     * <p>
     * This constructor throws an {@code AssertionError} to ensure that the class is used
     * only in a static context.
     */
    ModToolMaterials()
    {
        throw new AssertionError();
    }

    public static ToolMaterial CITRINE, COPPER, ENDERITE, RUBY, SAPPHIRE;

    //I: Durability : Wood: 59, Stone: 131, Iron: 250, Diamond: 1561, Gold: 32, Netherite: 2031
    //F: Mining Speed: Wood: 2.0f, Stone: 4.0f, Iron: 6.0f, Diamond: 8.0f, Gold: 12.0f, Netherite: 9.0f
    //G: Attack Damage: Wood: 0.0f, Stone: 1.0f, Iron: 2.0f, Diamond: 3.0f, Gold: 0.0f, Netherite: 4.0f
    //J: Enchantability: Wood: 15, Stone: 5, Iron: 14, Diamond: 10, Gold: 22, Netherite: 15
    //Enchantability can't be 0 any more, take a look at Item Tag Provider Datagen
    /**
     * Initializes the custom tool materials with predefined properties.
     * <p>
     * Each tool material is defined with specific attributes:
     * <ul>
     *   <li>Durability: The number of uses before the tool breaks.</li>
     *   <li>Mining Speed: The speed at which the tool can mine blocks.</li>
     *   <li>Attack Damage: The damage dealt by the tool when used as a weapon.</li>
     *   <li>Enchantability: The likelihood of receiving better enchantments.</li>
     * </ul>
     * The tool materials are associated with specific repair items using tags.
     */
    public static void init()
    {
        CITRINE = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 1000, 10.0f, 3.0f, 22,
                                   REFERENCE.REPAIRS_CITRINE_TOOL);
        COPPER = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 500, 6.0f, 1.0f, 14,
                                  REFERENCE.REPAIRS_COPPER_TOOL);
        ENDERITE = new ToolMaterial(REFERENCE.INCORRECT_FOR_ENDERITE_TOOL, 3000, 24.0f, 15.0f, 32,
                                    REFERENCE.REPAIRS_ENDERITE_TOOL);
        RUBY = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2000, 12.0f, 4.0f, 22,
                                REFERENCE.REPAIRS_RUBY_TOOL);
        SAPPHIRE = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2000, 12.0f, 4.0f, 22,
                                    REFERENCE.REPAIRS_SAPPHIRE_TOOL);
    }
}