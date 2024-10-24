package jiraiyah.uio.item;

import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

import java.util.List;

import static jiraiyah.uio.Reference.Tags.Entity.ENDERITE_SWORD_BLACKLIST;

public class EnderiteSword extends SwordItem
{
    public EnderiteSword(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Settings settings)
    {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        World world = attacker.getWorld();
        if(world.isClient || target.getType().isIn(ENDERITE_SWORD_BLACKLIST))
            return false;
        List<LivingEntity> targets = world.getNonSpectatingEntities(LivingEntity.class,
                                                                    target.getBoundingBox().expand(2.0, 0.25, 2.0));
        for(LivingEntity entity : targets)
        {
            //TODO: Usage of server world in new version
            if(target.getWorld() instanceof ServerWorld sw)
            {
                entity.kill(sw);
                ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY
                        .invoker().afterKilledOtherEntity(sw, attacker, entity);
            }
        }
        return true;
    }
}