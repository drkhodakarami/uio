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

import jiraiyah.uio.Reference.Tags;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

public class ModToolMaterials
{
    public ModToolMaterials()
    {
        throw new AssertionError();
    }

    public static ToolMaterial CITRINE, COPPER, ENDERITE, RUBY, SAPPHIRE;

    //TODO: Tool Materials Changed to Record in 1.21.2
    //I: Durability : Wood: 59, Stone: 131, Iron: 250, Diamond: 1561, Gold: 32, Netherite: 2031
    //F: Mining Speed: Wood: 2.0f, Stone: 4.0f, Iron: 6.0f, Diamond: 8.0f, Gold: 12.0f, Netherite: 9.0f
    //G: Attack Damage: Wood: 0.0f, Stone: 1.0f, Iron: 2.0f, Diamond: 3.0f, Gold: 0.0f, Netherite: 4.0f
    //J: Enchantability: Wood: 15, Stone: 5, Iron: 14, Diamond: 10, Gold: 22, Netherite: 15
    //Enchantability can't be 0 any more, take a look at Item Tag Provider Datagen
    //TODO: Repair Item now works using tags!
    public static void init()
    {
        CITRINE = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 1000, 10.0f, 3.0f, 22,
                                   Tags.Item.REPAIRS_CITRINE_TOOL);
        COPPER = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 500, 6.0f, 1.0f, 14,
                                  Tags.Item.REPAIRS_COPPER_TOOL);
        ENDERITE = new ToolMaterial(Tags.Block.INCORRECT_FOR_ENDERITE_TOOL, 3000, 24.0f, 15.0f, 32,
                                    Tags.Item.REPAIRS_ENDERITE_TOOL);
        RUBY = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2000, 12.0f, 4.0f, 22,
                                Tags.Item.REPAIRS_RUBY_TOOL);
        SAPPHIRE = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2000, 12.0f, 4.0f, 22,
                                    Tags.Item.REPAIRS_SAPPHIRE_TOOL);
    }
}