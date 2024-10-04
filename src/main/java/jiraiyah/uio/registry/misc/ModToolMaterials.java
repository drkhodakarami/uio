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

import com.google.common.base.Suppliers;
import jiraiyah.uio.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

import static jiraiyah.uio.Reference.Tags.Block.INCORRECT_FOR_ENDERITE_TOOL;

public enum ModToolMaterials implements ToolMaterial
{
    CITRINE(BlockTags.INCORRECT_FOR_IRON_TOOL, 1000, 10.0f, 3.0f, 0,
            () -> Ingredient.ofItems(ModItems.PLATE_CITRINE)),
    COPPER(BlockTags.INCORRECT_FOR_IRON_TOOL, 500, 6.0f, 1.0f, 0,
           () -> Ingredient.ofItems(ModItems.PLATE_COPPER)),
    ENDERITE(INCORRECT_FOR_ENDERITE_TOOL, 3000, 24.0f, 15.0f, 0,
             () -> Ingredient.ofItems(ModItems.PLATE_ENDERITE)),
    RUBY(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2000, 12.0f, 4.0f, 0,
         () -> Ingredient.ofItems(ModItems.PLATE_RUBY)),
    SAPPHIRE(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2000, 12.0f, 4.0f, 0,
             () -> Ingredient.ofItems(ModItems.PLATE_SAPPHIRE));

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(TagKey<Block> inverseTag, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient)
    {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurability()
    {
        return itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier()
    {
        return miningSpeed;
    }

    @Override
    public float getAttackDamage()
    {
        return attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag()
    {
        return inverseTag;
    }

    @Override
    public int getEnchantability()
    {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return repairIngredient.get();
    }
}