package jiraiyah.uio.registry;

import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

public enum ModToolMaterials implements ToolMaterial
{
    ;

    @Override
    public int getDurability()
    {
        return 0;
    }

    @Override
    public float getMiningSpeedMultiplier()
    {
        return 0;
    }

    @Override
    public float getAttackDamage()
    {
        return 0;
    }

    @Override
    public TagKey<Block> getInverseTag()
    {
        return null;
    }

    @Override
    public int getEnchantability()
    {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return null;
    }
}