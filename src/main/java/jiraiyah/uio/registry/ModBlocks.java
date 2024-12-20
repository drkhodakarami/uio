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

import jiraiyah.uio.block.energy.BatteryBank;
import jiraiyah.uio.block.energy.CreativeEnergyBank;
import jiraiyah.uio.block.energy.SolarPanel;
import jiraiyah.uio.block.goo.*;
import jiraiyah.uio.block.machine.*;
import jiraiyah.uio.block.misc.*;
import net.minecraft.block.*;

import java.util.ArrayList;
import java.util.List;

import static jiraiyah.jiregister.Registers.Block.*;
import static jiraiyah.uio.Main.LOGGER;

/**
 * The ModBlocks class is responsible for managing and registering custom blocks
 * within the Minecraft mod associated with the Jiraiyah UI Overhaul (UIO).
 * <p>
 * This class contains static definitions for various block types including ores,
 * decorative blocks, and utility blocks. It also maintains a blacklist that
 * prevents specific blocks from being registered or used within the mod.
 * </p>
 * <p>
 * The constructor is private to prevent instantiation, as this class is intended
 * to serve as a utility class for block management.
 * </p>
 * <p>
 * Example usage includes initializing and registering blocks during the mod's
 * setup phase.
 * </p>
 *
 * <p>
 * <strong>Thread Safety:</strong> This class is not thread-safe and should be
 * accessed within a single-threaded context during mod initialization.
 * </p>
 *
 * @see Block
 * @see List
 * @see java.util.ArrayList
 */
public class ModBlocks
{
    /**
     * A list of blocks that are excluded from registration in the Minecraft mod.
     * <p>
     * This list serves as a blacklist to manage which blocks will not be included
     * or used within the mod functionality. Blocks added to this list will be
     * ignored during the block registration process.
     * </p>
     * <p>
     * The list is static and final, meaning it is shared among all instances and
     * cannot be modified to reference a different list after initialization.
     * </p>
     */
    public static final List<Block> BLACK_LIST = new ArrayList<>();
    public static Block ENDERITE, CARROT_BOX, POTATO_BOX, CITRINE, RUBY, SAPPHIRE, ORE_ENDERITE,
            RAW_CITRINE, RAW_ENDERITE, RAW_QUARTZ, RAW_RUBY, RAW_SAPPHIRE, ORE_DEEP_CITRINE, ORE_DEEP_RUBY, ORE_DEEP_SAPPHIRE,
            ORE_END_CITRINE, ORE_END_ENDERITE_CRACKED, ORE_END_RUBY, ORE_END_SAPPHIRE,
            ORE_NETHER_CITRINE, ORE_NETHER_RUBY, ORE_NETHER_SAPPHIRE, ORE_NETHER_COAL, ORE_NETHER_COPPER, ORE_NETHER_DIAMOND,
            ORE_NETHER_IRON, ORE_NETHER_LAPIS, ORE_NETHER_REDSTONE, ORE_WORLD_CITRINE, ORE_WORLD_RUBY, ORE_WORLD_SAPPHIRE;
    public static FenceBlock CITRINE_FENCE, ENDERITE_FENCE, RUBY_FENCE, SAPPHIRE_FENCE;

    public static StairsBlock CITRINE_STAIRS, ENDERITE_STAIRS, RUBY_STAIRS, SAPPHIRE_STAIRS;
    public static SlabBlock CITRINE_SLAB, ENDERITE_SLAB, RUBY_SLAB, SAPPHIRE_SLAB;
    public static ButtonBlock CITRINE_BUTTON, ENDERITE_BUTTON, RUBY_BUTTON, SAPPHIRE_BUTTON;
    public static PressurePlateBlock CITRINE_PRESSURE_PLATE, ENDERITE_PRESSURE_PLATE, RUBY_PRESSURE_PLATE, SAPPHIRE_PRESSURE_PLATE;
    /**
     * Private constructor for the ModBlocks class.
     * <p>
     * This constructor is intentionally left private to prevent instantiation of
     * the ModBlocks class, as it is intended to be a utility class that contains
     * only static methods and fields for managing mod blocks.
     * </p>
     *
     * @throws AssertionError if an attempt is made to instantiate this class.
     */
    ModBlocks()
    {
        throw new AssertionError();
    }
    public static FenceGateBlock CITRINE_FENCE_GATE, ENDERITE_FENCE_GATE, RUBY_FENCE_GATE, SAPPHIRE_FENCE_GATE;
    public static WallBlock CITRINE_WALL, ENDERITE_WALL, RUBY_WALL, SAPPHIRE_WALL;
    public static DoorBlock CITRINE_DOOR, ENDERITE_DOOR, RUBY_DOOR, SAPPHIRE_DOOR;
    public static TrapdoorBlock CITRINE_TRAP_DOOR, ENDERITE_TRAP_DOOR, RUBY_TRAP_DOOR, SAPPHIRE_TRAP_DOOR;

    public static OreEndEnderite ORE_END_ENDERITE;

    public static WaterEatingGoo WATER_EATING_GOO;
    public static WaterGeneratingGoo WATER_GENERATING_GOO;
    public static LavaEatingGoo LAVA_EATING_GOO;
    public static LavaGeneratingGoo LAVA_GENERATING_GOO;
    public static ChunkGoo CHUNK_GOO;
    public static ToweringGoo TOWERING_GOO;
    public static TunnelingGoo TUNNELING_GOO;
    public static BridgeGoo BRIDGE_GOO;
    public static LavaPumpGoo LAVA_PUMP_GOO;
    public static WaterPumpGoo WATER_PUMP_GOO;
    public static AirGooBomb AIR_BOMB_GOO;
    public static ChunkGooBomb CHUNK_BOMB_GOO;
    public static StoneGooBomb STONE_BOMB_GOO;

    public static Elevator ELEVATOR;
    public static AngelBlock ANGEL;
    public static RedstoneClock REDSTONE_CLOCK;
    public static AlloyMixer ALLOY_MIXER;
    public static CastPress CAST_PRESS;
    public static GemCleaner GEM_CLEANER;
    public static Oven OVEN;
    public static Pulverizer PULVERIZER;
    public static Smelter SMELTER;
    public static AnimalFeed ANIMAL_FEED;
    public static Generator GENERATOR;
    public static BlockBreaker BLOCK_BREAKER;
    public static BlockPlacer BLOCK_PLACER;
    public static BuilderBlock BUILDER;
    public static ChunkLoader CHUNK_LOADER;
    public static CreativeEnergyBank CREATIVE_BANK;
    public static EnderChanter ENDER_CHANTER;
    public static FluidPump FLUID_PUMP;
    public static Printer PRINTER;
    public static ProjectTable PROJECT_TABLE;
    public static Tesseract TESSERACT;
    public static WoodStripper WOOD_STRIPPER;
    public static BatteryBank BATTERY_BANK;
    public static SolarPanel SOLAR_PANEL;
    public static Miner MINER;
    //endregion

    /**
     * Initializes and registers all custom blocks for the Minecraft mod.
     * <p>
     * This method is responsible for creating instances of the various blocks defined
     * in this class, such as gems, ores, and utility blocks, and registering them
     * with the appropriate Minecraft registry system. It outputs logging information
     * to indicate the registration process.
     * </p>
     * <p>
     * Typically called during the mod's initialization phase to ensure all blocks
     * are available for use in the game. This method also handles the
     * registration of block variations such as stairs, slabs, and buttons.
     * </p>
     * <p>
     * <strong>Note:</strong> This method should only be called once during the
     * initialization process to avoid duplicate registrations.
     * </p>
     */
    public static void init()
    {
        LOGGER.log("Registering Blocks");

        ENDERITE = register("block_enderite", Blocks.NETHERITE_BLOCK);
        //region GEMS
        CITRINE = register("block_citrine", Blocks.AMETHYST_BLOCK);
        RUBY = register("block_ruby", Blocks.AMETHYST_BLOCK);
        SAPPHIRE = register("block_sapphire", Blocks.AMETHYST_BLOCK);

        RAW_CITRINE = register("block_raw_citrine", Blocks.STONE);
        RAW_ENDERITE = register("block_raw_enderite", Blocks.STONE);
        RAW_QUARTZ = register("block_raw_quartz", Blocks.STONE);
        RAW_RUBY = register("block_raw_ruby", Blocks.STONE);
        RAW_SAPPHIRE = register("block_raw_sapphire", Blocks.STONE);
        //endregion
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
        ENDERITE_PRESSURE_PLATE = registerPressurePlate("block_enderite_pressure_plate", BlockSetType.IRON, Blocks.IRON_BLOCK);
        RUBY_PRESSURE_PLATE = registerPressurePlate("block_ruby_pressure_plate", BlockSetType.IRON, Blocks.AMETHYST_BLOCK);
        SAPPHIRE_PRESSURE_PLATE = registerPressurePlate("block_sapphire_pressure_plate", BlockSetType.IRON, Blocks.AMETHYST_BLOCK);

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
        ORE_DEEP_CITRINE = register("ore_deep_citrine", Blocks.DEEPSLATE_IRON_ORE);
        ORE_DEEP_RUBY = register("ore_deep_ruby", Blocks.DEEPSLATE_DIAMOND_ORE);
        ORE_DEEP_SAPPHIRE = register("ore_deep_sapphire", Blocks.DEEPSLATE_DIAMOND_ORE);

        ORE_END_CITRINE = register("ore_end_citrine", Blocks.END_STONE);
        ORE_END_ENDERITE = register("ore_end_enderite", OreEndEnderite::new);
        ORE_END_ENDERITE_CRACKED = register("ore_end_enderite_cracked", Blocks.END_STONE);
        ORE_END_RUBY = register("ore_end_ruby", Blocks.END_STONE);
        ORE_END_SAPPHIRE = register("ore_end_sapphire", Blocks.END_STONE);

        ORE_NETHER_CITRINE = register("ore_nether_citrine", Blocks.NETHER_GOLD_ORE);
        ORE_NETHER_RUBY = register("ore_nether_ruby", Blocks.NETHER_GOLD_ORE);
        ORE_NETHER_SAPPHIRE = register("ore_nether_sapphire", Blocks.NETHER_GOLD_ORE);
        ORE_NETHER_COAL = register("ore_nether_coal", Blocks.NETHER_QUARTZ_ORE);
        ORE_NETHER_COPPER = register("ore_nether_copper", Blocks.NETHER_GOLD_ORE);
        ORE_NETHER_DIAMOND = register("ore_nether_diamond", Blocks.NETHER_QUARTZ_ORE);
        ORE_NETHER_IRON = register("ore_nether_iron", Blocks.NETHER_QUARTZ_ORE);
        ORE_NETHER_LAPIS = register("ore_nether_lapis", Blocks.NETHER_GOLD_ORE);
        ORE_NETHER_REDSTONE = register("ore_nether_redstone", Blocks.NETHER_GOLD_ORE);

        ORE_WORLD_CITRINE = register("ore_world_citrine", Blocks.IRON_ORE);
        ORE_WORLD_RUBY = register("ore_world_ruby", Blocks.IRON_ORE);
        ORE_WORLD_SAPPHIRE = register("ore_world_sapphire", Blocks.IRON_ORE);

        ORE_ENDERITE = register("ore_enderite", Blocks.ANCIENT_DEBRIS);
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
        CARROT_BOX = register("carrot_box", Blocks.OAK_PLANKS);
        POTATO_BOX = register("potato_box", Blocks.OAK_PLANKS);

        ELEVATOR = register("elevator", Blocks.GRAY_WOOL, Elevator::new);

        REDSTONE_CLOCK = register("redstone_clock", Blocks.GRAY_WOOL, RedstoneClock::new);
        CREATIVE_BANK = register("creative_bank", Blocks.IRON_BLOCK, CreativeEnergyBank::new);
        BATTERY_BANK = register("battery_bank", Blocks.IRON_BLOCK, BatteryBank::new);
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
        ANGEL = register("block_angel",
                         AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).strength(0.1f, 5000.0f),
                         AngelBlock::new);
        //endregion
    }

    /**
     * Adds custom blocks to appropriate item groups in the Minecraft mod.
     * <p>
     * This method is responsible for including the registered custom blocks
     * into various item groups, allowing them to be accessible in the game's
     * inventory system. For example, this could include adding blocks to the
     * building blocks group or any other relevant categories.
     * </p>
     * <p>
     * The method may utilize item group events to modify existing groups or
     * create new ones, ensuring that players can find and use these blocks
     * easily within the game.
     * </p>
     * <p>
     * <strong>Note:</strong> The method currently contains commented-out code
     * indicating potential future implementations. Ensure to implement item
     * group additions as needed based on game design requirements.
     * </p>
     */
    public static void addToItemGroups()
    {
        LOGGER.log("Adding Blocks to Item Groups");

        /*ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries ->
                                                                                {
                                                                                    entries.add(ANGEL);
                                                                                });*/
    }

    /**
     * Populates the blacklist with specific block types that should be excluded
     * from registration in the Minecraft mod.
     * <p>
     * This method adds predefined blocks to the BLACK_LIST, preventing them from
     * being registered or utilized within the mod's functionality. The blacklist
     * serves as a filter to manage which blocks are ignored during the
     * registration process, ensuring certain blocks do not interfere with
     * gameplay or mod features.
     * </p>
     * <p>
     * This method should be called during the mod's initialization phase to
     * effectively manage block exclusions before any registration occurs.
     * </p>
     */
    public static void setBlackList()
    {
        BLACK_LIST.add(AIR_BOMB_GOO);
        BLACK_LIST.add(CHUNK_BOMB_GOO);
        BLACK_LIST.add(STONE_BOMB_GOO);
    }
}