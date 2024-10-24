package jiraiyah.uio.event;

import jiraiyah.uio.registry.ModItems;
import jiraiyah.uio.registry.misc.ModDataComponentTypes;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.PositionFlag;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import static jiraiyah.uio.Reference.Constants;
import static jiraiyah.uio.Reference.Tags.Entity.TUNER_BLACKLIST;
import static jiraiyah.uio.Reference.translate;

public class UseEntityCallbackListener
{
    public UseEntityCallbackListener()
    {
        throw new AssertionError();
    }

    public static void register()
    {
        UseEntityCallback.EVENT.register(((player, world, hand, entity, hitResult) ->
        {
            ItemStack stack = player.getStackInHand(hand);
            if(stack.isOf(ModItems.TUNER))
            {
                @Nullable var data = stack.get(ModDataComponentTypes.COORDINATE);
                if (data != null)
                {
                    if(entity.getType().isIn(TUNER_BLACKLIST))
                        return ActionResult.PASS;
                    if(entity.getType() == EntityType.VILLAGER)
                    {
                        BlockPos pos = data.pos();
                        if(!player.getWorld().isClient)
                        {
                            var dimension = data.dimension();
                            var userDimension = player.getWorld().getRegistryKey().getValue().toString();
                            if (dimension.equalsIgnoreCase(userDimension))
                            {
                                //TODO: Use of server world for 1.21.2
                                //TODO: Teleport now asks for boolean at the end (resetCamera)
                                if(entity.getWorld() instanceof ServerWorld sw)
                                    entity.teleport(sw , entity.getX(), pos.getY() + 1, entity.getZ(),
                                                    PositionFlag.VALUES, entity.getYaw(), entity.getPitch(), false);
                                entity.refreshPositionAfterTeleport(pos.getX(), pos.getY() + 1, pos.getZ());
                                return ActionResult.SUCCESS;
                            }
                            return ActionResult.FAIL;
                        }
                        var dimension = data.dimension();
                        var userDimension = player.getWorld().getRegistryKey().getValue().toString();
                        var dimensionName = dimension.substring(dimension.indexOf(':') + 1).replace('_', ' ');
                        if (dimension.equalsIgnoreCase(userDimension))
                        {
                            player.sendMessage(translate(Constants.TUNER_TELEPORTED_ID_NAME, pos.getX(), pos.getY(), pos.getZ(), dimensionName), false);
                            return ActionResult.SUCCESS;
                        }
                        else
                        {
                            player.sendMessage(translate(Constants.TUNER_ERROR_ID_NAME, dimensionName), false);
                            return ActionResult.FAIL;
                        }
                    }
                }
            }
            return ActionResult.PASS;
        }));
    }
}