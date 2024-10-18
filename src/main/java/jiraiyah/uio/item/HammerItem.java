package jiraiyah.uio.item;

import jiraiyah.uio.Configs;
import jiraiyah.uio.Reference;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static jiraiyah.uio.Reference.*;

public class HammerItem extends MiningToolItem
{
    private final int depth;
    private final int radius;

    public HammerItem(ToolMaterial material, int depth, int radius, Settings settings)
    {
        super(material, BlockTags.PICKAXE_MINEABLE, settings);
        this.depth = depth / 2;
        this.radius = radius - 1;
    }

    public int getDepth()
    {
        return this.depth;
    }

    public int getRadius()
    {
        return this.radius;
    }


    public static List<BlockPos> getAreaBlocks(BlockPos initialPos, int depth, int radius, ServerPlayerEntity player)
    {
        List<BlockPos> positions = new ArrayList<>();

        HitResult hit = player.raycast(Configs.HAMMER_MAX_DISTANCE, 0, false);

        if(hit.getType() != HitResult.Type.BLOCK)
            return positions;

        BlockHitResult block = (BlockHitResult)hit;

        if( block.getSide() == Direction.DOWN || block.getSide() == Direction.UP)
        {
            for(int x = -radius; x <= radius; x++)
            {
                for(int z = -radius; z <= radius; z++)
                {
                    for(int y = 0; y <= depth; y++)
                    {
                        positions.add(new BlockPos(initialPos.getX() + x,
                                                   initialPos.getY() + (block.getSide() == Direction.DOWN ? y : -y),
                                                   initialPos.getZ() + z));
                    }
                }
            }
        }

        if( block.getSide() == Direction.NORTH || block.getSide() == Direction.SOUTH)
        {
            for(int x = -radius; x <= radius; x++)
            {
                for(int y = -radius; y <= radius; y++)
                {
                    for(int z = 0; z <= depth; z++)
                    {
                        positions.add(new BlockPos(initialPos.getX() + x,
                                                   initialPos.getY() + y,
                                                   initialPos.getZ() + (block.getSide() == Direction.NORTH ? z : -z)));
                    }
                }
            }
        }

        if( block.getSide() == Direction.EAST || block.getSide() == Direction.WEST)
        {
            for(int z = -radius; z <= radius; z++)
            {
                for(int y = -radius; y <= radius; y++)
                {
                    for(int x = 0; x <= depth; x++)
                    {
                        positions.add(new BlockPos(initialPos.getX() + (block.getSide() == Direction.WEST ? x : -x),
                                                   initialPos.getY() + y,
                                                   initialPos.getZ() + z));
                    }
                }
            }
        }

        return positions;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type)
    {
        tooltip.add(translate(Constants.HAMMER_PARAM_TOOLTIP, this.radius * 2 + 1, this.radius * 2 + 1, this.depth + 1));
    }
}