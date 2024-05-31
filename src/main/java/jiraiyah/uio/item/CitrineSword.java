package jiraiyah.uio.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class CitrineSword extends SwordItem
{
    public CitrineSword(ToolMaterial toolMaterial, Settings settings)
    {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 3), attacker);
        return super.postHit(stack, target, attacker);
    }
}