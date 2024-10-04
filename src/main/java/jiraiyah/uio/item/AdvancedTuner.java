package jiraiyah.uio.item;

import jiraiyah.uio.Reference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import static jiraiyah.uio.Reference.*;

public class AdvancedTuner extends TunerItem
{
    public AdvancedTuner(Settings settings)
    {
        super(settings);
    }

    @Override
    @NotNull
    protected ActionResult useOnEntityResult(PlayerEntity user, LivingEntity entity, NbtCompound nbt)
    {
        if(NbtHelper.toBlockPos(nbt, Keys.TUNER_POS).isEmpty())
            return ActionResult.PASS;
        BlockPos pos = NbtHelper.toBlockPos(nbt, Keys.TUNER_POS).get();

        if (!user.getWorld().isClient())
        {
            var dimension = nbt.getString(Keys.TUNER_DIMENSION);
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