package jiraiyah.uio.item.blockitem;

import jiraiyah.uio.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AngelBlockItem extends BlockItem
{
    public AngelBlockItem(Block block, Settings settings)
    {
        super(block, settings);
    }

    //TODO: Return of Action Result for 1.21.2
    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand)
    {
        if(world.isClient)
            return super.use(world, user, hand);

        double x = user.getX() + user.getRotationVector().x * 4.5f;
        double y = user.getEyeY() + user.getRotationVector().y * 4.5f;
        double z = user.getZ() + user.getRotationVector().z * 4.5f;

        BlockPos pos = new BlockPos((int) Math.floor(x), (int) Math.floor(y), (int) Math.floor(z));

        if(world.isInBuildLimit(pos))
        {
            world.setBlockState(pos, ModBlocks.ANGEL.getDefaultState(), Block.NOTIFY_ALL);

            if(!user.isCreative())
                user.getStackInHand(hand).decrement(1);
        }

        return super.use(world, user, hand);
    }
}