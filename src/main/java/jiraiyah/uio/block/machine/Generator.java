package jiraiyah.uio.block.machine;

import jiraiyah.uio.block.base.MachineBase;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
//TODO : Create Model
//TODO : Create Block Recipe
//TODO : Handle Block Entity
//TODO : Add GUI
//TODO : Add Custom Recipe
//TODO : Add Custom Recipe Datagen

// Ideas :
// - It produces energy
// - For producing energy we can use different resources:
// - Lava can produce energy
// - Coal / Charcoal / Hot coal / Wood can produce energy
// - Stars can produce energy
// - If it's inside river biome surrounded by water can produce energy
// - If it's inside desert / mountain biome it can produce energy by wind (increases based on height)
// - Snowy biomes have negative effect on energy production
// - Nether has positive effect on energy production

public class Generator extends MachineBase
{
    public Generator(Settings settings)
    {
        super(settings);
        CODEC = createCodec(Generator::new);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state)
    {
        return null;
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type)
    {
        return super.getTicker(world, state, type);
    }
}