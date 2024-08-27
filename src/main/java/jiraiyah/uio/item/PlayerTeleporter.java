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

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static jiraiyah.uio.Reference.identifier;
import static jiraiyah.uio.Reference.translate;

public class PlayerTeleporter extends Item
{
    public PlayerTeleporter(Settings settings)
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
                    nbt.put("uio.teleporter.pos", NbtHelper.fromBlockPos(pos));
                    nbt.putString("uio.teleporter.dimension", player.getWorld().getRegistryKey().getValue().toString());
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

        return ActionResult.SUCCESS;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        @Nullable var data = user.getStackInHand(hand).get(DataComponentTypes.CUSTOM_DATA);

        if(user.isSneaking() && data != null)
            user.getStackInHand(hand).set(DataComponentTypes.CUSTOM_DATA, null);

        if(!user.isSneaking() && data != null)
        {
            if (!world.isClient)
            {
                ItemStack stack = user.getStackInHand(hand);
                NbtCompound nbt = data.copyNbt();
                BlockPos pos = NbtHelper.toBlockPos(nbt, "uio.teleporter.pos").get();
                var dimension = nbt.getString("uio.teleporter.dimension");
                //TODO : Finish the code !
            }
        }
        else
        {
            user.sendMessage(Text.literal("Use from Server"));
        }
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type)
    {
        @Nullable var data = stack.get(DataComponentTypes.CUSTOM_DATA);
        if (data != null)
        {
            NbtCompound nbt = data.copyNbt();
            BlockPos pos = NbtHelper.toBlockPos(nbt, "uio.teleporter.pos").get();

            var dimension = nbt.getString("uio.teleporter.dimension");
            var dimensionName = dimension.substring(dimension.indexOf(':') + 1).replace('_', ' ');
            tooltip.add(translate("teleporter.tooltip", pos.getX(), pos.getY(), pos.getZ(), dimensionName));
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