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
import jiraiyah.uio.util.block.abstracts.base.AbstractActivatableBlock;
import net.minecraft.block.Block;

//TODO : Handle Block Entity
//TODO : Add GUI

// Ideas :
// - Will pulse redstone signal with the 15 power
// - The default speed is 1 pulse per second
// - Can be set to go as fast as 1 pulse per tick or as slow as 1 pulse per minute
// - The interface provides buttons to increase / decrease the speed
// ==> 1 / 5 / 10 / 100 tick buttons
public class RedstoneClock extends AbstractActivatableBlock
{
    public static MapCodec<RedstoneClock> CODEC;

    public RedstoneClock(Settings settings)
    {
        super(settings);
        CODEC = createCodec(RedstoneClock::new);
    }

    @Override
    protected MapCodec<? extends Block> getCodec()
    {
        return CODEC;
    }
}