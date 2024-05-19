package jiraiyah.uio.registry;

import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial
{
    CITRINE(BlockTags.INCORRECT_FOR_IRON_TOOL, 1000, 10.0f, 3.0f, 0,
            () -> Ingredient.ofItems(ModItems.PLATE_CITRINE)),
    COPPER(BlockTags.INCORRECT_FOR_IRON_TOOL, 500, 6.0f, 1.0f, 0,
           () -> Ingredient.ofItems(ModItems.PLATE_COPPER)),
    // TODO : ADD Enderite Tier Tag
    ENDERITE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3000, 24.0f, 5.0f, 0,
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