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
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static jiraiyah.uio.Reference.*;

//TODO : Add the ability to name the teleporter using shift click
// - The name should be shown in the tooltip when hovering over the teleporter
// - The name should be saved in the custom data of the teleporter
// - The name should be editable using shift click
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
                    nbt.put(Keys.TELEPORTER_POS, NbtHelper.fromBlockPos(pos));
                    nbt.putString(Keys.TELEPORTER_DIMENSION, player.getWorld().getRegistryKey().getValue().toString());
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
                if(nbt == null || NbtHelper.toBlockPos(nbt, Keys.TELEPORTER_POS).isEmpty())
                    return super.use(world, user, hand);
                BlockPos pos = NbtHelper.toBlockPos(nbt, Keys.TELEPORTER_POS).get();
                var dimension = nbt.getString(Keys.TELEPORTER_DIMENSION);
                MinecraftServer server = world.getServer();
                RegistryKey<World> storedKey = RegistryKey.of(RegistryKeys.WORLD, idOf(dimension));
                if(storedKey == null || server == null)
                    return super.use(world, user, hand);
                TeleportTarget target = new TeleportTarget(server.getWorld(storedKey),
                                                           new Vec3d(pos.getX() + 0.5f, pos.getY() + 1.0f, pos.getZ() + 0.5f),
                                                           new Vec3d(0, 0, 0),
                                                           user.getYaw(),
                                                           user.getPitch(),
                                                           TeleportTarget.NO_OP);
                if(user.getWorld().getRegistryKey().equals(storedKey))
                    ((ServerPlayerEntity) user).networkHandler.requestTeleport(target.pos().getX(),
                                                                               target.pos().getY(),
                                                                               target.pos().getZ(),
                                                                               target.yaw(),
                                                                               target.pitch());
                else
                    user.teleportTo(target);

            }
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
            if(NbtHelper.toBlockPos(nbt, Keys.TELEPORTER_POS).isEmpty())
                return;
            BlockPos pos = NbtHelper.toBlockPos(nbt, Keys.TELEPORTER_POS).get();

            var dimension = nbt.getString(Keys.TELEPORTER_DIMENSION);
            var dimensionName = dimension.substring(dimension.indexOf(':') + 1).replace('_', ' ');
            tooltip.add(translate(TELEPORTER_TOOLTIP_ID_NAME, pos.getX(), pos.getY(), pos.getZ(), dimensionName));
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
        player.sendMessage(translate(TUNER_TOOLTIP_ID_NAME, pos.getX(), pos.getY(), pos.getZ(), dimension), false);
    }
}