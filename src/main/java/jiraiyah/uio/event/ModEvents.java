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
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.network.packet.s2c.play.PositionFlag;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import static jiraiyah.uio.Reference.log;
import static jiraiyah.uio.Reference.Tags.Entity.TUNER_BLACKLIST;
import static jiraiyah.uio.Reference.translate;

public class ModEvents
{
    public ModEvents() { throw new AssertionError(); }

    public static void addListeners()
    {
        log("Registering Items");

        addVillagerClickListener();
    }

    private static void addVillagerClickListener()
    {
        UseEntityCallback.EVENT.register(((player, world, hand, entity, hitResult) ->
        {
            ItemStack stack = player.getStackInHand(hand);
            if(stack.isOf(ModItems.TOOL_TUNER))
            {
                @Nullable var data = stack.get(DataComponentTypes.CUSTOM_DATA);
                if (data != null)
                {
                    NbtCompound nbt = data.copyNbt();
                    if(nbt == null)
                        return ActionResult.PASS;
                    if(entity.getType().isIn(TUNER_BLACKLIST))
                        return ActionResult.PASS;
                    if( entity.getType() == EntityType.VILLAGER)
                    {
                        BlockPos pos = NbtHelper.toBlockPos(nbt, "uio.tuner.pos").get();
                        if(!player.getWorld().isClient)
                        {
                            var dimension = nbt.getString("uio.tuner.dimension");
                            var userDimension = player.getWorld().getRegistryKey().getValue().toString();
                            if (dimension.equalsIgnoreCase(userDimension))
                            {
                                entity.teleport((ServerWorld) entity.getWorld(), entity.getX(), pos.getY() + 1, entity.getZ(),
                                                PositionFlag.VALUES, entity.getYaw(), entity.getPitch());
                                entity.refreshPositionAfterTeleport(pos.getX(), pos.getY() + 1, pos.getZ());
                                return ActionResult.SUCCESS;
                            }
                            return ActionResult.FAIL;
                        }
                        var dimension = nbt.getString("uio.tuner.dimension");
                        var userDimension = player.getWorld().getRegistryKey().getValue().toString();
                        var dimensionName = dimension.substring(dimension.indexOf(':') + 1).replace('_', ' ');
                        if (dimension.equalsIgnoreCase(userDimension))
                        {
                            player.sendMessage(translate("tuner.teleported", pos.getX(), pos.getY(), pos.getZ(), dimensionName), false);
                            return ActionResult.SUCCESS;
                        }
                        else
                        {
                            player.sendMessage(translate("tuner.error", dimensionName), false);
                            return ActionResult.FAIL;
                        }
                    }
                }
            }
            return ActionResult.PASS;
        }));
    }
}