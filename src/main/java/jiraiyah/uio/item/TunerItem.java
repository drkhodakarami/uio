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

package jiraiyah.uio.item;

import net.minecraft.client.item.TooltipType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static jiraiyah.uio.Reference.Tags.Entity.TUNER_BLACKLIST;
import static jiraiyah.uio.Reference.translate;

// TODO : Use Custom DataComponentType
// TODO : Use Events for Villager Teleportation
public class TunerItem extends Item
{
    public TunerItem(Settings settings)
    {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context)
    {
        @Nullable var data = context.getStack().get(DataComponentTypes.CUSTOM_DATA);

        if (data != null)
            return super.useOnBlock(context);

        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();

        if (player != null)
        {
            if (!player.isSneaking())
            {
                if (!context.getWorld().isClient())
                {
                    NbtCompound nbt = new NbtCompound();
                    nbt.put("uio.tuner.pos", NbtHelper.fromBlockPos(pos));
                    nbt.putString("uio.tuner.dimension", player.getWorld().getRegistryKey().getValue().toString());
                    NbtComponent component = NbtComponent.of(nbt);
                    context.getStack().set(DataComponentTypes.CUSTOM_DATA, component);
                }
                else
                {
                    var dimension = player.getWorld().getRegistryKey().getValue().toString();
                    dimension = dimension.substring(dimension.indexOf(':') + 1).replace('_', ' ');
                    outputCoordinatesToChat(pos, dimension, player);
                }
            }
        }

        return super.useOnBlock(context);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        if (!world.isClient())
        {
            @Nullable var data = user.getStackInHand(hand).get(DataComponentTypes.CUSTOM_DATA);

            if (user.isSneaking() && data != null)
                user.getStackInHand(hand).set(DataComponentTypes.CUSTOM_DATA, null);
        }
        return super.use(world, user, hand);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand)
    {
        @Nullable var data = stack.get(DataComponentTypes.CUSTOM_DATA);

        if (entity.isPlayer() ||
            data == null ||
            entity.getType().isIn(TUNER_BLACKLIST))
            return ActionResult.FAIL;

        if (!user.isSneaking())
        {
            NbtCompound nbt = data.copyNbt();
            BlockPos pos = NbtHelper.toBlockPos(nbt, "uio.tuner.pos").get();

            if (!user.getWorld().isClient())
            {
                var dimension = nbt.getString("uio.tuner.dimension");
                var userDimension = user.getWorld().getRegistryKey().getValue().toString();
                if (dimension.equalsIgnoreCase(userDimension))
                {
                    entity.teleport(pos.getX(), pos.getY(), pos.getZ());
                    entity.refreshPositionAfterTeleport(pos.getX(), pos.getY() + 1, pos.getZ());
                    return ActionResult.SUCCESS;
                }
                return ActionResult.FAIL;
            }

            var dimension = nbt.getString("uio.tuner.dimension");
            var userDimension = user.getWorld().getRegistryKey().getValue().toString();
            var dimensionName = dimension.substring(dimension.indexOf(':') + 1).replace('_', ' ');
            if (dimension.equalsIgnoreCase(userDimension))
            {
                user.sendMessage(translate("tuner.teleported", pos.getX(), pos.getY(), pos.getZ(), dimensionName), false);
                return ActionResult.SUCCESS;
            }
            else
            {
                user.sendMessage(translate("tuner.error", dimensionName), false);
                return ActionResult.FAIL;
            }
        }

        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type)
    {
        @Nullable var data = stack.get(DataComponentTypes.CUSTOM_DATA);
        if (data != null)
        {
            NbtCompound nbt = data.copyNbt();
            BlockPos pos = NbtHelper.toBlockPos(nbt, "uio.tuner.pos").get();

            var dimension = nbt.getString("uio.tuner.dimension");
            var dimensionName = dimension.substring(dimension.indexOf(':') + 1).replace('_', ' ');
            tooltip.add(translate("tuner.tooltip", pos.getX(), pos.getY(), pos.getZ(), dimensionName));
        }
    }

    @Override
    public boolean hasGlint(ItemStack stack)
    {
        @Nullable var data = stack.get(DataComponentTypes.CUSTOM_DATA);
        return data != null;
    }

    private void outputCoordinatesToChat(BlockPos pos, String dimension, PlayerEntity player)
    {
        player.sendMessage(translate("tuner.tooltip", pos.getX(), pos.getY(), pos.getZ(), dimension), false);
    }
}