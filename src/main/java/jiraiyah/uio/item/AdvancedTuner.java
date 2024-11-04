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

import jiraiyah.uio.util.record.CoordinateData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static jiraiyah.uio.Reference.*;

public class AdvancedTuner extends TunerItem
{
    public AdvancedTuner(Settings settings)
    {
        super(settings);
    }

    @Override
    @NotNull
    protected ActionResult useOnEntityResult(PlayerEntity user, LivingEntity entity, @Nullable CoordinateData data)
    {
        if (data == null)
            return ActionResult.PASS;

        BlockPos pos = data.pos();

        if (!user.getWorld().isClient())
        {
            var dimension = data.dimension();
            MinecraftServer server = user.getWorld().getServer();
            RegistryKey<World> storedKey = RegistryKey.of(RegistryKeys.WORLD, idOf(dimension));
            if (storedKey == null || server == null || server.getWorld(storedKey) == null)
                return ActionResult.PASS;
            TeleportTarget target = new TeleportTarget(server.getWorld(storedKey),
                                                       new Vec3d(pos.getX() + 0.5f, pos.getY() + 1f, pos.getZ() + 0.5f),
                                                       new Vec3d(0, 0, 0), user.getYaw(), user.getPitch(),
                                                       TeleportTarget.NO_OP);
            entity.teleportTo(target);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
}