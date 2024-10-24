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

import jiraiyah.uio.block.AngelBlock;
import jiraiyah.uio.block.OreEnderite;
import jiraiyah.uio.block.goo.*;
import jiraiyah.uio.block.machine.*;
import jiraiyah.uio.util.Registers;
import net.minecraft.block.*;

import java.util.ArrayList;
import java.util.List;

import static jiraiyah.uio.Reference.ModID;
import static jiraiyah.uio.Reference.log;
import static jiraiyah.uio.util.Registers.Blocks.*;
import static jiraiyah.uio.util.Registers.Blocks.registerPressurePlate;

public class ModBlocks
{
    ModBlocks()
    {
        throw new AssertionError();
    }

    public static List<Block> AllBlocks = new ArrayList<>();
    public static final List<Block> BLACK_LIST = new ArrayList<>();

    public static Block ENDERITE;
    public static Block CARROT_BOX, POTATO_BOX;

    public static Block CITRINE, RUBY, SAPPHIRE;
    public static Block RAW_CITRINE, RAW_ENDERITE ,RAW_QUARTZ, RAW_RUBY, RAW_SAPPHIRE;

    public static StairsBlock CITRINE_STAIRS, ENDERITE_STAIRS, RUBY_STAIRS, SAPPHIRE_STAIRS;
    public static Block CITRINE_SLAB, ENDERITE_SLAB, RUBY_SLAB, SAPPHIRE_SLAB;
    public static Block CITRINE_BUTTON, ENDERITE_BUTTON, RUBY_BUTTON, SAPPHIRE_BUTTON;
    public static Block CITRINE_PRESSURE_PLATE, ENDERITE_PRESSURE_PLATE, RUBY_PRESSURE_PLATE, SAPPHIRE_PRESSURE_PLATE;
    public static Block CITRINE_FENCE, ENDERITE_FENCE, RUBY_FENCE,SAPPHIRE_FENCE;
    public static Block CITRINE_FENCE_GATE, ENDERITE_FENCE_GATE, RUBY_FENCE_GATE, SAPPHIRE_FENCE_GATE;
    public static Block CITRINE_WALL, ENDERITE_WALL, RUBY_WALL, SAPPHIRE_WALL;
    public static Block CITRINE_DOOR, ENDERITE_DOOR, RUBY_DOOR, SAPPHIRE_DOOR;
    public static Block CITRINE_TRAP_DOOR, ENDERITE_TRAP_DOOR, RUBY_TRAP_DOOR, SAPPHIRE_TRAP_DOOR;

    public static Block ORE_DEEP_CITRINE, ORE_DEEP_RUBY, ORE_DEEP_SAPPHIRE;
    public static Block ORE_END_CITRINE, ORE_END_ENDERITE_CRACKED, ORE_END_RUBY, ORE_END_SAPPHIRE;
    public static OreEnderite ORE_END_ENDERITE;
    public static Block ORE_NETHER_CITRINE, ORE_NETHER_RUBY, ORE_NETHER_SAPPHIRE, ORE_NETHER_COAL, ORE_NETHER_COPPER, ORE_NETHER_DIAMOND,
                        ORE_NETHER_IRON, ORE_NETHER_LAPIS,ORE_NETHER_REDSTONE;
    public static Block ORE_WORLD_CITRINE, ORE_WORLD_RUBY, ORE_WORLD_SAPPHIRE;
    public static Block ORE_ENDERITE;

    public static Block WATER_EATING_GOO, WATER_GENERATING_GOO, LAVA_EATING_GOO, LAVA_GENERATING_GOO, CHUNK_GOO, TOWERING_GOO,
                        TUNNELING_GOO, BRIDGE_GOO, AIR_BOMB_GOO, CHUNK_BOMB_GOO, LAVA_PUMP_GOO, STONE_BOMB_GOO, WATER_PUMP_GOO;

    public static Block ELEVATOR, ANGEL, REDSTONE_CLOCK, ALLOY_MIXER, CAST_PRESS, GEM_CLEANER, OVEN, PULVERIZER, SMELTER, ANIMAL_FEED,
                        GENERATOR, BLOCK_BREAKER, BLOCK_PLACER, BUILDER, CHUNK_LOADER, CREATIVE_BANK, ENDER_CHANTER, FLUID_PUMP,
                        PRINTER, PROJECT_TABLE, TESSERACT, WOOD_STRIPPER, BATTERY_BANK, SOLAR_PANEL, MINER;
    //endregion

    public static void init()
    {
        log("Registering Blocks");

        //TODO: Talk about massive code refactor and the reason
        ENDERITE = register("block_enderite", Blocks.NETHERITE_BLOCK, Block::new);
        //region GEMS
        CITRINE = register("block_citrine", Blocks.AMETHYST_BLOCK, Block::new);
        RUBY = register("block_ruby", Blocks.AMETHYST_BLOCK, Block::new);
        SAPPHIRE = register("block_sapphire", Blocks.AMETHYST_BLOCK, Block::new);

        RAW_CITRINE = register("block_raw_citrine", Blocks.STONE, Block::new);
        RAW_ENDERITE = register("block_raw_enderite", Blocks.STONE, Block::new);
        RAW_QUARTZ = register("block_raw_quartz", Blocks.STONE, Block::new);
        RAW_RUBY = register("block_raw_ruby", Blocks.STONE, Block::new);
        RAW_SAPPHIRE = register("block_raw_sapphire", Blocks.STONE, Block::new);
        //endregion
        //TODO: The registration for special blocks are changed 1.21.2 (look into helper method)
        //region SPECIAL BLOCKS
        CITRINE_STAIRS = registerStair("block_citrine_stairs", ModBlocks.CITRINE, Blocks.AMETHYST_BLOCK);
        ENDERITE_STAIRS = registerStair("block_enderite_stairs", ModBlocks.ENDERITE, Blocks.IRON_BLOCK);
        RUBY_STAIRS = registerStair("block_ruby_stairs", ModBlocks.RUBY, Blocks.AMETHYST_BLOCK);
        SAPPHIRE_STAIRS = registerStair("block_sapphire_stairs", ModBlocks.SAPPHIRE, Blocks.AMETHYST_BLOCK);

        CITRINE_SLAB = registerSlab("block_citrine_slab", Blocks.AMETHYST_BLOCK);
        ENDERITE_SLAB = registerSlab("block_enderite_slab", Blocks.IRON_BLOCK);
        RUBY_SLAB = registerSlab("block_ruby_slab", Blocks.AMETHYST_BLOCK);
        SAPPHIRE_SLAB = registerSlab("block_sapphire_slab", Blocks.AMETHYST_BLOCK);

        CITRINE_BUTTON = registerButton("block_citrine_button", BlockSetType.IRON, 40, Blocks.AMETHYST_BLOCK);
        ENDERITE_BUTTON = registerButton("block_enderite_button", BlockSetType.IRON, 40, Blocks.IRON_BLOCK);
        RUBY_BUTTON = registerButton("block_ruby_button", BlockSetType.IRON, 40, Blocks.AMETHYST_BLOCK);
        SAPPHIRE_BUTTON = registerButton("block_sapphire_button", BlockSetType.IRON, 40, Blocks.AMETHYST_BLOCK);

        CITRINE_PRESSURE_PLATE = registerPressurePlate("block_citrine_pressure_plate", BlockSetType.IRON, Blocks.AMETHYST_BLOCK);
        ENDERITE_PRESSURE_PLATE = registerPressurePlate("block_enderite_pressure_plate",BlockSetType.IRON, Blocks.IRON_BLOCK);
        RUBY_PRESSURE_PLATE = registerPressurePlate("block_ruby_pressure_plate",BlockSetType.IRON, Blocks.AMETHYST_BLOCK);
        SAPPHIRE_PRESSURE_PLATE = registerPressurePlate("block_sapphire_pressure_plate",BlockSetType.IRON, Blocks.AMETHYST_BLOCK);

        CITRINE_FENCE = registerFence("block_citrine_fence", Blocks.AMETHYST_BLOCK);
        ENDERITE_FENCE = registerFence("block_enderite_fence", Blocks.IRON_BLOCK);
        RUBY_FENCE = registerFence("block_ruby_fence", Blocks.AMETHYST_BLOCK);
        SAPPHIRE_FENCE = registerFence("block_sapphire_fence", Blocks.AMETHYST_BLOCK);

        CITRINE_FENCE_GATE = registerFenceGate("block_citrine_fence_gate", WoodType.OAK, Blocks.AMETHYST_BLOCK);
        ENDERITE_FENCE_GATE = registerFenceGate("block_enderite_fence_gate", WoodType.OAK, Blocks.IRON_BLOCK);
        RUBY_FENCE_GATE = registerFenceGate("block_ruby_fence_gate", WoodType.OAK, Blocks.AMETHYST_BLOCK);
        SAPPHIRE_FENCE_GATE = registerFenceGate("block_sapphire_fence_gate", WoodType.OAK, Blocks.AMETHYST_BLOCK);

        CITRINE_WALL = registerWall("block_citrine_wall", Blocks.AMETHYST_BLOCK);
        ENDERITE_WALL = registerWall("block_enderite_wall", Blocks.IRON_BLOCK);
        RUBY_WALL = registerWall("block_ruby_wall", Blocks.AMETHYST_BLOCK);
        SAPPHIRE_WALL = registerWall("block_sapphire_wall", Blocks.AMETHYST_BLOCK);

        CITRINE_DOOR = registerDoor("block_citrine_door", BlockSetType.IRON, Blocks.IRON_DOOR);
        ENDERITE_DOOR = registerDoor("block_enderite_door", BlockSetType.IRON, Blocks.IRON_DOOR);
        RUBY_DOOR = registerDoor("block_ruby_door", BlockSetType.IRON, Blocks.IRON_DOOR);
        SAPPHIRE_DOOR = registerDoor("block_sapphire_door", BlockSetType.IRON, Blocks.IRON_DOOR);

        CITRINE_TRAP_DOOR = registerTrapdoor("block_citrine_trap_door", BlockSetType.IRON, Blocks.IRON_DOOR);
        ENDERITE_TRAP_DOOR = registerTrapdoor("block_enderite_trap_door", BlockSetType.IRON, Blocks.IRON_DOOR);
        RUBY_TRAP_DOOR = registerTrapdoor("block_ruby_trap_door", BlockSetType.IRON, Blocks.IRON_DOOR);
        SAPPHIRE_TRAP_DOOR = registerTrapdoor("block_sapphire_trap_door", BlockSetType.IRON, Blocks.IRON_DOOR);
        //endregion
        //region ORE
        ORE_DEEP_CITRINE = register("ore_deep_citrine", Blocks.DEEPSLATE_IRON_ORE, Block::new);
        ORE_DEEP_RUBY = register("ore_deep_ruby", Blocks.DEEPSLATE_DIAMOND_ORE, Block::new);
        ORE_DEEP_SAPPHIRE = register("ore_deep_sapphire", Blocks.DEEPSLATE_DIAMOND_ORE, Block::new);

        ORE_END_CITRINE = register("ore_end_citrine", Blocks.END_STONE, Block::new);
        ORE_END_ENDERITE = register("ore_end_enderite", OreEnderite::new);
        ORE_END_ENDERITE_CRACKED = register("ore_end_enderite_cracked", Blocks.END_STONE, Block::new);
        ORE_END_RUBY = register("ore_end_ruby", Blocks.END_STONE, Block::new);
        ORE_END_SAPPHIRE = register("ore_end_sapphire", Blocks.END_STONE, Block::new);

        ORE_NETHER_CITRINE = register("ore_nether_citrine", Blocks.NETHER_GOLD_ORE, Block::new);
        ORE_NETHER_RUBY = register("ore_nether_ruby", Blocks.NETHER_GOLD_ORE, Block::new);
        ORE_NETHER_SAPPHIRE = register("ore_nether_sapphire", Blocks.NETHER_GOLD_ORE, Block::new);
        ORE_NETHER_COAL = register("ore_nether_coal", Blocks.NETHER_QUARTZ_ORE, Block::new);
        ORE_NETHER_COPPER = register("ore_nether_copper", Blocks.NETHER_GOLD_ORE, Block::new);
        ORE_NETHER_DIAMOND = register("ore_nether_diamond", Blocks.NETHER_QUARTZ_ORE, Block::new);
        ORE_NETHER_IRON = register("ore_nether_iron", Blocks.NETHER_QUARTZ_ORE, Block::new);
        ORE_NETHER_LAPIS = register("ore_nether_lapis", Blocks.NETHER_GOLD_ORE, Block::new);
        ORE_NETHER_REDSTONE = register("ore_nether_redstone", Blocks.NETHER_GOLD_ORE, Block::new);

        ORE_WORLD_CITRINE = register("ore_world_citrine", Blocks.IRON_ORE, Block::new);
        ORE_WORLD_RUBY = register("ore_world_ruby", Blocks.IRON_ORE, Block::new);
        ORE_WORLD_SAPPHIRE = register("ore_world_sapphire", Blocks.IRON_ORE, Block::new);

        ORE_ENDERITE = register("ore_enderite", Blocks.ANCIENT_DEBRIS, Block::new);
        //endregion
        //region GOO
        WATER_EATING_GOO = register("water_eating_goo", Blocks.GRAY_WOOL, WaterEatingGoo::new);
        WATER_GENERATING_GOO = register("water_generating_goo", Blocks.GRAY_WOOL, WaterGeneratingGoo::new);
        LAVA_EATING_GOO = register("lava_eating_goo", Blocks.GRAY_WOOL, LavaEatingGoo::new);
        LAVA_GENERATING_GOO = register("lava_generating_goo", Blocks.GRAY_WOOL, LavaGeneratingGoo::new);
        CHUNK_GOO = register("chunk_goo", Blocks.GRAY_WOOL, ChunkGoo::new);
        TOWERING_GOO = register("towering_goo", Blocks.GRAY_WOOL, ToweringGoo::new);
        TUNNELING_GOO = register("tunneling_goo", Blocks.GRAY_WOOL, TunnelingGoo::new);
        BRIDGE_GOO = register("bridge_goo", Blocks.GRAY_WOOL, BridgeGoo::new);
        AIR_BOMB_GOO = register("air_goo_bomb", Blocks.GRAY_WOOL, AirGooBomb::new);
        CHUNK_BOMB_GOO = register("chunk_goo_bomb", Blocks.GRAY_WOOL, ChunkGooBomb::new);
        STONE_BOMB_GOO = register("stone_goo_bomb", Blocks.GRAY_WOOL, StoneGooBomb::new);
        LAVA_PUMP_GOO = register("lava_pump_goo", Blocks.GRAY_WOOL, LavaPumpGoo::new);
        WATER_PUMP_GOO = register("water_pump_goo", Blocks.GRAY_WOOL, WaterPumpGoo::new);
        //endregion
        //region MACHINES
        ELEVATOR = register("elevator", Blocks.GRAY_WOOL, Block::new);

        CARROT_BOX = register("carrot_box", Blocks.OAK_PLANKS, Block::new);
        POTATO_BOX = register("potato_box", Blocks.OAK_PLANKS, Block::new);

        REDSTONE_CLOCK = register("redstone_clock", Blocks.GRAY_WOOL, RedstoneClock::new);
        CREATIVE_BANK = register("creative_bank", Blocks.IRON_BLOCK, CreativeEnergyBank::new);
        BATTERY_BANK = register("battery_bank", Blocks.IRON_BLOCK,BatteryBank::new);
        ALLOY_MIXER = register("alloy_mixer", Blocks.IRON_BLOCK, AlloyMixer::new);
        BUILDER = register("builder", Blocks.IRON_BLOCK, BuilderBlock::new);
        CAST_PRESS = register("cast_press", Blocks.IRON_BLOCK, CastPress::new);
        GEM_CLEANER = register("gem_cleaner", Blocks.IRON_BLOCK, GemCleaner::new);
        GENERATOR = register("generator", Blocks.IRON_BLOCK, Generator::new);
        SOLAR_PANEL = register("solar_panel", Blocks.IRON_BLOCK, SolarPanel::new);
        OVEN = register("oven", Blocks.IRON_BLOCK, Oven::new);
        PULVERIZER = register("pulverizer", Blocks.IRON_BLOCK, Pulverizer::new);
        SMELTER = register("smelter", Blocks.IRON_BLOCK, Smelter::new);
        FLUID_PUMP = register("fluid_pump", Blocks.IRON_BLOCK, FluidPump::new);
        BLOCK_BREAKER = register("block_breaker", Blocks.IRON_BLOCK, BlockBreaker::new);
        BLOCK_PLACER = register("block_placer", Blocks.IRON_BLOCK, BlockPlacer::new);
        WOOD_STRIPPER = register("wood_stripper", Blocks.IRON_BLOCK, WoodStripper::new);
        ANIMAL_FEED = register("animal_feed", Blocks.CRAFTING_TABLE, AnimalFeed::new);
        TESSERACT = register("tesseract", Blocks.IRON_BLOCK, Tesseract::new);
        ENDER_CHANTER = register("enderchanter", Blocks.ENCHANTING_TABLE, EnderChanter::new);
        PRINTER = register("printer", Blocks.CRAFTING_TABLE, Printer::new);
        PROJECT_TABLE = register("project_table", Blocks.CRAFTING_TABLE, ProjectTable::new);
        CHUNK_LOADER = register("chunk_loader", Blocks.IRON_BLOCK, ChunkLoader::new);
        MINER = register("miner", Blocks.IRON_BLOCK, Miner::new);
        ANGEL = registerSimple("block_angel",
                         new AngelBlock(AbstractBlock.Settings.copy(Blocks.WHITE_WOOL)
                                                              .strength(0.1f, 5000.0f)
                                                              .registryKey(Registers.getBlockKey("block_angel"))));
        //endregion
    }

    public static void addToItemGroups()
    {
        log("Adding Blocks to Item Groups");
    }

    public static void setAllBlocks()
    {
        AllBlocks = Registers.getAllBlocks(ModID);

        BLACK_LIST.add(AIR_BOMB_GOO);
        BLACK_LIST.add(CHUNK_BOMB_GOO);
        BLACK_LIST.add(STONE_BOMB_GOO);
    }
}