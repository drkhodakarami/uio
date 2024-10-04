package jiraiyah.uio.event;

import jiraiyah.uio.registry.ModItems;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.math.random.Random;

public class KillingEntityListener implements ServerEntityCombatEvents.AfterKilledOtherEntity
{
    @Override
    public void afterKilledOtherEntity(ServerWorld world, Entity entity, LivingEntity killedEntity)
    {
        if(entity == null || world.isClient)
            return;

        if(killedEntity instanceof EndermanEntity && entity.isPlayer())
        {
            if(((PlayerEntity)entity).getStackInHand(Hand.MAIN_HAND).isOf(ModItems.TOOL_CITRINE_SWORD))
            {
                world.spawnEntity(new ItemEntity(world,
                                                 killedEntity.getPos().x,
                                                 killedEntity.getPos().y,
                                                 killedEntity.getPos().z,
                new ItemStack(Items.ENDER_PEARL, Random.create().nextBetween(1, 2))));
                return;
            }

            if(((PlayerEntity)entity).getStackInHand(Hand.MAIN_HAND).isOf(ModItems.TOOL_ENDERITE_SWORD))
            {
                world.spawnEntity(new ItemEntity(world,
                                                 killedEntity.getPos().x,
                                                 killedEntity.getPos().y,
                                                 killedEntity.getPos().z,
                                                 new ItemStack(Items.ENDER_PEARL, Random.create().nextBetween(2, 4))));
                return;
            }
        }

        if(killedEntity instanceof WitherSkeletonEntity && entity.isPlayer())
        {
            if(((PlayerEntity)entity).getStackInHand(Hand.MAIN_HAND).isOf(ModItems.TOOL_CITRINE_SWORD))
            {
                world.spawnEntity(new ItemEntity(world,
                                                 killedEntity.getPos().x,
                                                 killedEntity.getPos().y,
                                                 killedEntity.getPos().z,
                                                 new ItemStack(Items.WITHER_SKELETON_SKULL, 1)));
                return;
            }

            if(((PlayerEntity)entity).getStackInHand(Hand.MAIN_HAND).isOf(ModItems.TOOL_ENDERITE_SWORD))
            {
                world.spawnEntity(new ItemEntity(world,
                                                 killedEntity.getPos().x,
                                                 killedEntity.getPos().y,
                                                 killedEntity.getPos().z,
                                                 new ItemStack(Items.WITHER_SKELETON_SKULL, 3)));
                return;
            }
        }
    }
}