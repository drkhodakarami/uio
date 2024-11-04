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
        if (entity == null || world.isClient)
            return;

        if (killedEntity instanceof EndermanEntity && entity.isPlayer())
        {
            if (((PlayerEntity) entity).getStackInHand(Hand.MAIN_HAND).isOf(ModItems.TOOL_CITRINE_SWORD))
            {
                world.spawnEntity(new ItemEntity(world,
                                                 killedEntity.getPos().x,
                                                 killedEntity.getPos().y,
                                                 killedEntity.getPos().z,
                                                 new ItemStack(Items.ENDER_PEARL, Random.create().nextBetween(1, 2))));
                return;
            }

            if (((PlayerEntity) entity).getStackInHand(Hand.MAIN_HAND).isOf(ModItems.TOOL_ENDERITE_SWORD))
            {
                world.spawnEntity(new ItemEntity(world,
                                                 killedEntity.getPos().x,
                                                 killedEntity.getPos().y,
                                                 killedEntity.getPos().z,
                                                 new ItemStack(Items.ENDER_PEARL, Random.create().nextBetween(2, 4))));
                return;
            }
        }

        if (killedEntity instanceof WitherSkeletonEntity && entity.isPlayer())
        {
            if (((PlayerEntity) entity).getStackInHand(Hand.MAIN_HAND).isOf(ModItems.TOOL_CITRINE_SWORD))
            {
                world.spawnEntity(new ItemEntity(world,
                                                 killedEntity.getPos().x,
                                                 killedEntity.getPos().y,
                                                 killedEntity.getPos().z,
                                                 new ItemStack(Items.WITHER_SKELETON_SKULL, 1)));
                return;
            }

            if (((PlayerEntity) entity).getStackInHand(Hand.MAIN_HAND).isOf(ModItems.TOOL_ENDERITE_SWORD))
            {
                world.spawnEntity(new ItemEntity(world,
                                                 killedEntity.getPos().x,
                                                 killedEntity.getPos().y,
                                                 killedEntity.getPos().z,
                                                 new ItemStack(Items.WITHER_SKELETON_SKULL, 3)));
            }
        }
    }
}