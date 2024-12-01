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

package jiraiyah.uio.block.misc;

import com.mojang.serialization.MapCodec;
import jiraiyah.jiralib.block.BlockWithBE;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

//TODO : Create Model
//TODO : Create Block Recipe
//TODO : Handle Block Entity
//TODO : Add GUI

// Ideas :
// - The name says everything. It's advance chunk loader
// - It can accept Upgrades to expand the distance chunks
// - The default is just current chunk
// - Each upgrade unlocks and loads one chunk
// - The grid is 9 * 9 chunks (total of 80 Upgrades)
public class ChunkLoader extends BlockWithBE
{
    private static VoxelShape SHAPE;
    public static MapCodec<ChunkLoader> CODEC;

    public ChunkLoader(Settings settings)
    {
        super(settings.nonOpaque());
        SHAPE = VoxelShapes.union(VoxelShapes.cuboid(0.0625, 0, 0.0625, 0.9375, 0.125, 0.875),
                                  VoxelShapes.cuboid(0.1875, 0.125, 0.1875, 0.8125, 0.3125, 0.8125),
                                  VoxelShapes.cuboid(0.29374999999999996, 0.3125, 0.29374999999999984, 0.6999999999999996, 1, 0.6999999999999998))
                           .simplify();
        CODEC = createCodec(ChunkLoader::new);
    }

    @Override
    protected MapCodec<? extends Block> getCodec()
    {
        return CODEC;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context)
    {
        return SHAPE;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state)
    {
        return null;
    }
}