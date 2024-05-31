package jiraiyah.uio.item;

import net.minecraft.client.item.TooltipType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class PlayerTeleporter extends Item
{
    public PlayerTeleporter(Settings settings)
    {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context)
    {
        if (context.getWorld().isClient)
        {
            context.getPlayer().sendMessage(Text.literal("Use On Block from Client"));
        }
        else
        {
            context.getPlayer().sendMessage(Text.literal("Use On Block from Server"));
        }
        return super.useOnBlock(context);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        if (world.isClient)
        {
            user.sendMessage(Text.literal("Use from Client"));
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
        super.appendTooltip(stack, context, tooltip, type);
    }

    @Override
    public boolean hasGlint(ItemStack stack)
    {
        return super.hasGlint(stack);
    }
}