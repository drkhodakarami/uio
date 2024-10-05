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

import jiraiyah.uio.block.*;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static jiraiyah.uio.Reference.*;

public class ModBlocks
{
    public static List<Block> AllBlocks = new ArrayList<>();
    public static final List<Block> BLACK_LIST = new ArrayList<>();

    public static Block ENDERITE;

    public static Block CITRINE, RUBY, SAPPHIRE;
    public static Block RAW_CITRINE, RAW_ENDERITE ,RAW_QUARTZ, RAW_RUBY, RAW_SAPPHIRE;

    public static Block CITRINE_STAIRS, ENDERITE_STAIRS, RUBY_STAIRS, SAPPHIRE_STAIRS;
    public static Block CITRINE_SLAB, ENDERITE_SLAB, RUBY_SLAB, SAPPHIRE_SLAB;
    public static Block CITRINE_BUTTON, ENDERITE_BUTTON, RUBY_BUTTON, SAPPHIRE_BUTTON;
    public static Block CITRINE_PRESSURE_PLATE, ENDERITE_PRESSURE_PLATE, RUBY_PRESSURE_PLATE, SAPPHIRE_PRESSURE_PLATE;
    public static Block CITRINE_FENCE, ENDERITE_FENCE, RUBY_FENCE,SAPPHIRE_FENCE;
    public static Block CITRINE_FENCE_GATE, ENDERITE_FENCE_GATE, RUBY_FENCE_GATE, SAPPHIRE_FENCE_GATE;
    public static Block CITRINE_WALL, ENDERITE_WALL, RUBY_WALL, SAPPHIRE_WALL;
    public static Block CITRINE_DOOR, ENDERITE_DOOR, RUBY_DOOR, SAPPHIRE_DOOR;
    public static Block CITRINE_TRAP_DOOR, ENDERITE_TRAP_DOOR, RUBY_TRAP_DOOR, SAPPHIRE_TRAP_DOOR;

    public static Block ORE_DEEP_CITRINE, ORE_DEEP_RUBY, ORE_DEEP_SAPPHIRE;
    public static Block ORE_END_CITRINE, ORE_END_ENDERITE, ORE_END_ENDERITE_CRACKED, ORE_END_RUBY, ORE_END_SAPPHIRE;
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

    public ModBlocks()
    {
        throw new AssertionError();
    }

    public static void register()
    {
        log("Registering Blocks");

        ENDERITE = registerCopy("block_enderite", Blocks.NETHERITE_BLOCK);
        //region GEMS
        CITRINE = registerCopy("block_citrine", Blocks.AMETHYST_BLOCK);
        RUBY = registerCopy("block_ruby", Blocks.AMETHYST_BLOCK);
        SAPPHIRE = registerCopy("block_sapphire", Blocks.AMETHYST_BLOCK);

        RAW_CITRINE = registerCopy("block_raw_citrine", Blocks.STONE);
        RAW_ENDERITE = registerCopy("block_raw_enderite", Blocks.STONE);
        RAW_QUARTZ = registerCopy("block_raw_quartz", Blocks.STONE);
        RAW_RUBY = registerCopy("block_raw_ruby", Blocks.STONE);
        RAW_SAPPHIRE = registerCopy("block_raw_sapphire", Blocks.STONE);
        //endregion
        //region SPECIAL BLOCKS
        CITRINE_STAIRS =
                register("block_citrine_stairs",
                         new StairsBlock(ModBlocks.CITRINE.getDefaultState(), AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
        ENDERITE_STAIRS =
                register("block_enderite_stairs",
                         new StairsBlock(ModBlocks.ENDERITE.getDefaultState(), AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        RUBY_STAIRS =
                register("block_ruby_stairs",
                         new StairsBlock(ModBlocks.RUBY.getDefaultState(), AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
        SAPPHIRE_STAIRS =
                register("block_sapphire_stairs",
                         new StairsBlock(ModBlocks.SAPPHIRE.getDefaultState(), AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));

        CITRINE_SLAB =
                register("block_citrine_slab",
                         new SlabBlock(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
        ENDERITE_SLAB =
                register("block_enderite_slab",
                         new SlabBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        RUBY_SLAB =
                register("block_ruby_slab",
                         new SlabBlock(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
        SAPPHIRE_SLAB =
                register("block_sapphire_slab",
                         new SlabBlock(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));

        CITRINE_BUTTON =
                register("block_citrine_button",
                         new ButtonBlock(BlockSetType.IRON, 40, AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
        ENDERITE_BUTTON =
                register("block_enderite_button",
                         new ButtonBlock(BlockSetType.IRON, 40, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        RUBY_BUTTON =
                register("block_ruby_button",
                         new ButtonBlock(BlockSetType.IRON, 40, AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
        SAPPHIRE_BUTTON =
                register("block_sapphire_button",
                         new ButtonBlock(BlockSetType.IRON, 40, AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));

        CITRINE_PRESSURE_PLATE =
                register("block_citrine_pressure_plate",
                         new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
        ENDERITE_PRESSURE_PLATE =
                register("block_enderite_pressure_plate",
                         new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        RUBY_PRESSURE_PLATE =
                register("block_ruby_pressure_plate",
                         new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
        SAPPHIRE_PRESSURE_PLATE =
                register("block_sapphire_pressure_plate",
                         new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));

        CITRINE_FENCE =
                register("block_citrine_fence",
                         new FenceBlock(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
        ENDERITE_FENCE =
                register("block_enderite_fence",
                         new FenceBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        RUBY_FENCE =
                register("block_ruby_fence",
                         new FenceBlock(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
        SAPPHIRE_FENCE =
                register("block_sapphire_fence",
                         new FenceBlock(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));

        CITRINE_FENCE_GATE =
                register("block_citrine_fence_gate",
                         new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
        ENDERITE_FENCE_GATE =
                register("block_enderite_fence_gate",
                         new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        RUBY_FENCE_GATE =
                register("block_ruby_fence_gate",
                         new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
        SAPPHIRE_FENCE_GATE =
                register("block_sapphire_fence_gate",
                         new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));

        CITRINE_WALL =
                register("block_citrine_wall",
                         new WallBlock(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
        ENDERITE_WALL =
                register("block_enderite_wall",
                         new WallBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        RUBY_WALL =
                register("block_ruby_wall",
                         new WallBlock(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
        SAPPHIRE_WALL =
                register("block_sapphire_wall",
                         new WallBlock(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));

        CITRINE_DOOR =
                register("block_citrine_door",
                         new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.IRON_DOOR)));
        ENDERITE_DOOR =
                register("block_enderite_door",
                         new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.IRON_DOOR)));
        RUBY_DOOR =
                register("block_ruby_door",
                         new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.IRON_DOOR)));
        SAPPHIRE_DOOR =
                register("block_sapphire_door",
                         new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.IRON_DOOR)));

        CITRINE_TRAP_DOOR =
                register("block_citrine_trap_door",
                         new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.IRON_TRAPDOOR)));
        ENDERITE_TRAP_DOOR =
                register("block_enderite_trap_door",
                         new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.IRON_TRAPDOOR)));
        RUBY_TRAP_DOOR =
                register("block_ruby_trap_door",
                         new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.IRON_TRAPDOOR)));
        SAPPHIRE_TRAP_DOOR =
                register("block_sapphire_trap_door",
                         new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.IRON_TRAPDOOR)));
        //endregion
        //region ORE
        ORE_DEEP_CITRINE = registerCopy("ore_deep_citrine", Blocks.DEEPSLATE_IRON_ORE);
        ORE_DEEP_RUBY = registerCopy("ore_deep_ruby", Blocks.DEEPSLATE_DIAMOND_ORE);
        ORE_DEEP_SAPPHIRE = registerCopy("ore_deep_sapphire", Blocks.DEEPSLATE_DIAMOND_ORE);

        ORE_END_CITRINE = registerCopy("ore_end_citrine", Blocks.END_STONE);
        ORE_END_ENDERITE = register("ore_end_enderite", new OreEnderite(AbstractBlock.Settings.create()));
        ORE_END_ENDERITE_CRACKED = registerCopy("ore_end_enderite_cracked", Blocks.END_STONE);
        ORE_END_RUBY = registerCopy("ore_end_ruby", Blocks.END_STONE);
        ORE_END_SAPPHIRE = registerCopy("ore_end_sapphire", Blocks.END_STONE);

        ORE_NETHER_CITRINE = registerCopy("ore_nether_citrine", Blocks.NETHER_GOLD_ORE);
        ORE_NETHER_RUBY = registerCopy("ore_nether_ruby", Blocks.NETHER_GOLD_ORE);
        ORE_NETHER_SAPPHIRE = registerCopy("ore_nether_sapphire", Blocks.NETHER_GOLD_ORE);
        ORE_NETHER_COAL = registerCopy("ore_nether_coal", Blocks.NETHER_QUARTZ_ORE);
        ORE_NETHER_COPPER = registerCopy("ore_nether_copper", Blocks.NETHER_GOLD_ORE);
        ORE_NETHER_DIAMOND = registerCopy("ore_nether_diamond", Blocks.NETHER_QUARTZ_ORE);
        ORE_NETHER_IRON = registerCopy("ore_nether_iron", Blocks.NETHER_QUARTZ_ORE);
        ORE_NETHER_LAPIS = registerCopy("ore_nether_lapis", Blocks.NETHER_GOLD_ORE);
        ORE_NETHER_REDSTONE = registerCopy("ore_nether_redstone", Blocks.NETHER_GOLD_ORE);

        ORE_WORLD_CITRINE = registerCopy("ore_world_citrine", Blocks.IRON_ORE);
        ORE_WORLD_RUBY = registerCopy("ore_world_ruby", Blocks.IRON_ORE);
        ORE_WORLD_SAPPHIRE = registerCopy("ore_world_sapphire", Blocks.IRON_ORE);

        ORE_ENDERITE = registerCopy("ore_enderite", Blocks.ANCIENT_DEBRIS);
        //endregion
        //region GOO
        WATER_EATING_GOO = registerCopy("water_eating_goo", Blocks.GRAY_WOOL);
        WATER_GENERATING_GOO = registerCopy("water_generating_goo", Blocks.GRAY_WOOL);
        LAVA_EATING_GOO = registerCopy("lava_eating_goo", Blocks.GRAY_WOOL);
        LAVA_GENERATING_GOO = registerCopy("lava_generating_goo", Blocks.GRAY_WOOL);
        CHUNK_GOO = registerCopy("chunk_goo", Blocks.GRAY_WOOL);
        TOWERING_GOO = registerCopy("towering_goo", Blocks.GRAY_WOOL);
        TUNNELING_GOO = registerCopy("tunneling_goo", Blocks.GRAY_WOOL);
        BRIDGE_GOO = registerCopy("bridge_goo", Blocks.GRAY_WOOL);

        AIR_BOMB_GOO = registerCopy("air_goo_bomb", Blocks.GRAY_WOOL);
        CHUNK_BOMB_GOO = registerCopy("chunk_goo_bomb", Blocks.GRAY_WOOL);
        LAVA_PUMP_GOO = registerCopy("lava_pump_goo", Blocks.GRAY_WOOL);
        STONE_BOMB_GOO = registerCopy("stone_goo_bomb", Blocks.GRAY_WOOL);
        WATER_PUMP_GOO = registerCopy("water_pump_goo", Blocks.GRAY_WOOL);
        //endregion
        //region MACHINES
        ELEVATOR = registerCopy("elevator", Blocks.GRAY_WOOL);
        REDSTONE_CLOCK = register("redstone_clock",
                                       new RedstoneClock(AbstractBlock.Settings.copy(Blocks.GRAY_WOOL)));
        CREATIVE_BANK = register("creative_bank",
                                      new CreativeEnergyBank(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        BATTERY_BANK = register("battery_bank",
                                     new BatteryBank(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        ALLOY_MIXER = register("alloy_mixer",
                                    new AlloyMixer(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        BUILDER = register("builder",
                                new BuilderBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        CAST_PRESS = register("cast_press",
                                  new CastPress(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        GEM_CLEANER = register("gem_cleaner",
                                    new GemCleaner(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        GENERATOR = register("generator",
                                  new Generator(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        SOLAR_PANEL = register("solar_panel",
                                  new SolarPanel(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        OVEN = register("oven",
                             new Oven(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        PULVERIZER = register("pulverizer",
                                   new Pulverizer(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        SMELTER = register("smelter",
                                new Smelter(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        FLUID_PUMP = register("fluid_pump",
                                   new FluidPump(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        BLOCK_BREAKER = register("block_breaker",
                                      new BlockBreaker(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        BLOCK_PLACER = register("block_placer",
                                     new BlockPlacer(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        WOOD_STRIPPER = register("wood_stripper",
                                      new WoodStripper(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        ANIMAL_FEED = register("animal_feed",
                                    new AnimalFeed(AbstractBlock.Settings.copy(Blocks.CRAFTING_TABLE)));
        TESSERACT = register("tesseract",
                                  new Tesseract(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        ENDER_CHANTER = register("enderchanter",
                                      new EnderChanter(AbstractBlock.Settings.copy(Blocks.ENCHANTING_TABLE)));
        PRINTER = register("printer",
                                new Printer(AbstractBlock.Settings.copy(Blocks.CRAFTING_TABLE)));
        PROJECT_TABLE = register("project_table",
                                      new ProjectTable(AbstractBlock.Settings.copy(Blocks.CRAFTING_TABLE)));
        CHUNK_LOADER = register("chunk_loader",
                                     new ChunkLoader(AbstractBlock.Settings.copy(Blocks.GRAY_WOOL)));
        MINER = register("miner",
                                     new Miner(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        //TODO: Generate Custom Block Item(Use registerBlock and then manually register custom block item)
        ANGEL = register("block_angel",
                         AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).strength(0.1f, 5000.0f));
        //endregion

        AllBlocks = Registries.BLOCK.getEntrySet()
                                  .stream()
                                  .filter(key -> key.getKey().getValue().getNamespace().equals(ModID))
                                  .map(Map.Entry::getValue)
                                  .collect(Collectors.toList());


        BLACK_LIST.add(AIR_BOMB_GOO);
        BLACK_LIST.add(CHUNK_BOMB_GOO);
        BLACK_LIST.add(STONE_BOMB_GOO);
    }

    //region HELPER METHODS
    private static Block register(String name, Block block, boolean hasItem)
    {
        if(hasItem)
            registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, identifier(name), block);
    }

    private static Block register(String name, boolean hasItem)
    {
        return register(name, new Block(AbstractBlock.Settings.create()), hasItem);
    }

    private static Block register(String name, AbstractBlock.Settings settings, boolean hasItem)
    {
        return register(name, new Block(settings), hasItem);
    }

    private static Block register(String name, AbstractBlock.Settings settings)
    {
        return register(name, new Block(settings), true);
    }

    private static Block register(String name, Block block)
    {
        return register(name, block, true);
    }

    private static Block register(String name)
    {
        return register(name, new Block(AbstractBlock.Settings.create()), true);
    }

    private static Block registerBlock(String name, Block block)
    {
        return register(name, block, false);
    }

    private static Block registerBlock(String name)
    {
        return register(name, new Block(AbstractBlock.Settings.create()), false);
    }

    private static Block registerCopy(String name, Block block, boolean hasItem)
    {
        return register(name, new Block(AbstractBlock.Settings.copy(block)), hasItem);
    }

    private static Block registerCopy(String name, Block block)
    {
        return register(name, new Block(AbstractBlock.Settings.copy(block)), true);
    }

    private static Block registerBlockCopy(String name, Block block)
    {
        return register(name, new Block(AbstractBlock.Settings.copy(block)), false);
    }

    private static Block register(String name, Block block, BlockItem blockItem)
    {
        Registry.register(Registries.ITEM, identifier(name), blockItem);
        return Registry.register(Registries.BLOCK, identifier(name), block);
    }

    private static Block register(String name, BlockItem blockItem)
    {
        Registry.register(Registries.ITEM, identifier(name), blockItem);
        return Registry.register(Registries.BLOCK, identifier(name), new Block(AbstractBlock.Settings.create()));
    }

    private static Block registerCopy(String name, Block block, BlockItem blockItem)
    {
        Registry.register(Registries.ITEM, identifier(name), blockItem);
        return Registry.register(Registries.BLOCK, identifier(name), new Block(AbstractBlock.Settings.copy(block)));
    }

    private static void registerBlockItem(String name, Block block)
    {
        Registry.register(Registries.ITEM, identifier(name),
                                        new BlockItem(block, new Item.Settings()));
    }
    //endregion
}