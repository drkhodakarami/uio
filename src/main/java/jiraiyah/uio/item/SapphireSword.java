package jiraiyah.uio.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class SapphireSword extends SwordItem
{
    public SapphireSword(ToolMaterial toolMaterial, Settings settings)
    {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 3), attacker);

        var vector = target.getPos().subtract(attacker.getPos()).normalize().multiply(5, 1, 5);
        target.setVelocity(vector);

        return super.postHit(stack, target, attacker);
    }
}