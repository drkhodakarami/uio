package jiraiyah.uio.util.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class AbstractActivatableBlock extends Block
{
    public static final BooleanProperty ACTIVATED = BooleanProperty.of("activated");

    public AbstractActivatableBlock(Settings settings)
    {
        super(settings);

        setDefaultState(this.getDefaultState().with(ACTIVATED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        super.appendProperties(builder);
        builder.add(ACTIVATED);
    }

    //TODO : CHANGE THE MECHANICS, THIS SHOULD NEVER HAPPEN LIKE THIS

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit)
    {
        if(!world.isClient)
            world.setBlockState(pos, state.cycle(ACTIVATED));
        return super.onUse(state, world, pos, player, hit);
    }
}