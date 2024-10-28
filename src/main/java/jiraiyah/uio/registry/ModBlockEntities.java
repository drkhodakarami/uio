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

package jiraiyah.uio.registry;

import jiraiyah.uio.blockentity.*;
import jiraiyah.uio.blockentity.WaterEatingGooBE;
import jiraiyah.uio.util.Registers.Entities;
import net.minecraft.block.entity.BlockEntityType;

import static jiraiyah.uio.Reference.log;

public class ModBlockEntities
{
    public static BlockEntityType<AirGooBombBE> AIR_GOO_BOMB;
    public static BlockEntityType<BridgeGooBE> BRIDGE_GOO;
    public static BlockEntityType<ChunkGooBE> CHUNK_GOO;
    public static BlockEntityType<ChunkGooBombBE> CHUNK_GOO_BOMB;
    public static BlockEntityType<LavaEatingGooBE> LAVA_EATING_GOO;
    public static BlockEntityType<LavaGeneratingGooBE> LAVA_GENERATING_GOO;
    public static BlockEntityType<LavaPumpGooBE> LAVA_PUMP_GOO;
    public static BlockEntityType<StoneGooBombBE> STONE_GOO_BOMB;
    public static BlockEntityType<ToweringGooBE> TOWERING_GOO;
    public static BlockEntityType<TunnelingGooBE> TUNNELING_GOO;
    public static BlockEntityType<WaterEatingGooBE> WATER_EATING_GOO;
    public static BlockEntityType<WaterGeneratingGooBE> WATER_GENERATING_GOO;
    public static BlockEntityType<WaterPumpGooBE> WATER_PUMP_GOO;

    ModBlockEntities()
    {
        throw new AssertionError();
    }


    public static void init()
    {
        log("Registering Block Entities");

        AIR_GOO_BOMB = Entities.register("air_bomb_goo", ModBlocks.AIR_BOMB_GOO, AirGooBombBE::new);
        BRIDGE_GOO = Entities.register("bridge_goo", ModBlocks.BRIDGE_GOO, BridgeGooBE::new);
        CHUNK_GOO = Entities.register("chunk_goo", ModBlocks.CHUNK_GOO, ChunkGooBE::new);
        CHUNK_GOO_BOMB = Entities.register("chunk_bomb_goo", ModBlocks.CHUNK_BOMB_GOO, ChunkGooBombBE::new);
        LAVA_EATING_GOO = Entities.register("lava_eating_goo", ModBlocks.LAVA_EATING_GOO, LavaEatingGooBE::new);
        LAVA_GENERATING_GOO = Entities.register("lava_generating_goo", ModBlocks.LAVA_GENERATING_GOO, LavaGeneratingGooBE::new);
        LAVA_PUMP_GOO = Entities.register("lava_pump_goo", ModBlocks.LAVA_PUMP_GOO, LavaPumpGooBE::new);
        STONE_GOO_BOMB = Entities.register("stone_bomb_goo", ModBlocks.STONE_BOMB_GOO, StoneGooBombBE::new);
        TOWERING_GOO = Entities.register("towering_goo", ModBlocks.TOWERING_GOO, ToweringGooBE::new);
        TUNNELING_GOO = Entities.register("tunneling_goo", ModBlocks.TUNNELING_GOO, TunnelingGooBE::new);
        WATER_EATING_GOO = Entities.register("water_eating_goo", ModBlocks.WATER_EATING_GOO, WaterEatingGooBE::new);
        WATER_GENERATING_GOO = Entities.register("water_generating_goo", ModBlocks.WATER_GENERATING_GOO, WaterGeneratingGooBE::new);
        WATER_PUMP_GOO = Entities.register("water_pump_goo", ModBlocks.WATER_PUMP_GOO, WaterPumpGooBE::new);
    }
}