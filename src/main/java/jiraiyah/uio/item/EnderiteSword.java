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
import static jiraiyah.uio.Reference.logN;

public class EnderiteSword extends SwordItem
{
    public EnderiteSword(ToolMaterial toolMaterial, Settings settings)
    {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        World world = attacker.getWorld();
        if(world.isClient || target.getType().isIn(ENDERITE_SWORD_BLACKLIST))
            return false;
        List<LivingEntity> targets = world.getNonSpectatingEntities(LivingEntity.class, target.getBoundingBox().expand(2.0, 0.25, 2.0));
        for(LivingEntity entity : targets)
        {
            entity.kill();
            ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY
                    .invoker().afterKilledOtherEntity((ServerWorld) world,attacker, entity);
        }
        return true;
    }
}