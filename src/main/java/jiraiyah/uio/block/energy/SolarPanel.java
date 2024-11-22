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

package jiraiyah.uio.block.energy;

import jiraiyah.jimachina.block.AbstractMachineBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class SolarPanel extends AbstractMachineBlock
{
    private static VoxelShape SHAPE;

    public SolarPanel(Settings settings)
    {
        super(settings.nonOpaque());
        SHAPE = VoxelShapes.union(
                                   VoxelShapes.cuboid(0.0625, 0.4375, 0.19375, 0.9375, 0.9868125, 0.7625),
                                   VoxelShapes.cuboid(0.125, 0, 0.1875, 0.875, 0.0625, 0.8125),
                                   VoxelShapes.cuboid(0.2500625, 0.616272553118655, 0.48640973553180533, 0.7500625, 0.741272553118655, 0.6114097355318053),
                                   VoxelShapes.cuboid(0.4375, 0.0625, 0.4375, 0.5625, 0.64375, 0.5625),
                                   VoxelShapes.cuboid(0.40625, 0.40625, 0.96875, 0.59375, 0.59375, 1),
                                   VoxelShapes.cuboid(0.46875, 0.46875, 0.559375, 0.53125, 0.53125, 0.9968125),
                                   VoxelShapes.cuboid(0.00125, 0.46875, 0.46875, 0.4386875, 0.53125, 0.53125),
                                   VoxelShapes.cuboid(0, 0.40625, 0.40625, 0.03125, 0.59375, 0.59375),
                                   VoxelShapes.cuboid(0.559375, 0.46875, 0.46875, 0.9968125, 0.53125, 0.53125),
                                   VoxelShapes.cuboid(0.96875, 0.40625, 0.40625, 1, 0.59375, 0.59375))
                           .simplify();
        CODEC = createCodec(SolarPanel::new);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state)
    {
        return null;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context)
    {
        return SHAPE;
    }
}