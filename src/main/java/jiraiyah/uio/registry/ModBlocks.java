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

import jiraiyah.uio.block.ElevatorBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static jiraiyah.uio.Reference.identifier;
import static jiraiyah.uio.Reference.log;

public class ModBlocks
{
    public static final Block ENDERITE = registerBlock("block_enderite", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));

    //region GEMS
    public static final Block CITRINE = registerBlock("block_citrine", new Block(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
    public static final Block RUBY = registerBlock("block_ruby", new Block(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
    public static final Block SAPPHIRE = registerBlock("block_sapphire", new Block(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));

    public static final Block RAW_CITRINE = registerBlock("block_raw_citrine", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static final Block RAW_ENDERITE = registerBlock("block_raw_enderite", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static final Block RAW_QUARTZ = registerBlock("block_raw_quartz", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static final Block RAW_RUBY = registerBlock("block_raw_ruby", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));
    public static final Block RAW_SAPPHIRE = registerBlock("block_raw_sapphire", new Block(AbstractBlock.Settings.copy(Blocks.STONE)));
    //endregion

    //region SPECIAL BLOCKS
    public static final Block CITRINE_STAIRS =
            registerBlock("block_citrine_stairs",
                          new StairsBlock(ModBlocks.CITRINE.getDefaultState(), AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
    public static final Block ENDERITE_STAIRS =
            registerBlock("block_enderite_stairs",
                          new StairsBlock(ModBlocks.ENDERITE.getDefaultState(), AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    public static final Block RUBY_STAIRS =
            registerBlock("block_ruby_stairs",
                          new StairsBlock(ModBlocks.RUBY.getDefaultState(), AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
    public static final Block SAPPHIRE_STAIRS =
            registerBlock("block_sapphire_stairs",
                          new StairsBlock(ModBlocks.SAPPHIRE.getDefaultState(), AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));

    public static final Block CITRINE_SLAB =
            registerBlock("block_citrine_slab",
                          new SlabBlock(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
    public static final Block ENDERITE_SLAB =
            registerBlock("block_enderite_slab",
                          new SlabBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    public static final Block RUBY_SLAB =
            registerBlock("block_ruby_slab",
                          new SlabBlock(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
    public static final Block SAPPHIRE_SLAB =
            registerBlock("block_sapphire_slab",
                          new SlabBlock(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));

    public static final Block CITRINE_BUTTON =
            registerBlock("block_citrine_button",
                          new ButtonBlock(BlockSetType.IRON, 40, AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
    public static final Block ENDERITE_BUTTON =
            registerBlock("block_enderite_button",
                          new ButtonBlock(BlockSetType.IRON, 40, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    public static final Block RUBY_BUTTON =
            registerBlock("block_ruby_button",
                          new ButtonBlock(BlockSetType.IRON, 40, AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
    public static final Block SAPPHIRE_BUTTON =
            registerBlock("block_sapphire_button",
                          new ButtonBlock(BlockSetType.IRON, 40, AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));

    public static final Block CITRINE_PRESSURE_PLATE =
            registerBlock("block_citrine_pressure_plate",
                          new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
    public static final Block ENDERITE_PRESSURE_PLATE =
            registerBlock("block_enderite_pressure_plate",
                          new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    public static final Block RUBY_PRESSURE_PLATE =
            registerBlock("block_ruby_pressure_plate",
                          new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
    public static final Block SAPPHIRE_PRESSURE_PLATE =
            registerBlock("block_sapphire_pressure_plate",
                          new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));

    public static final Block CITRINE_FENCE =
            registerBlock("block_citrine_fence",
                          new FenceBlock(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
    public static final Block ENDERITE_FENCE =
            registerBlock("block_enderite_fence",
                          new FenceBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    public static final Block RUBY_FENCE =
            registerBlock("block_ruby_fence",
                          new FenceBlock(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
    public static final Block SAPPHIRE_FENCE =
            registerBlock("block_sapphire_fence",
                          new FenceBlock(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));

    public static final Block CITRINE_FENCE_GATE =
            registerBlock("block_citrine_fence_gate",
                          new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
    public static final Block ENDERITE_FENCE_GATE =
            registerBlock("block_enderite_fence_gate",
                          new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    public static final Block RUBY_FENCE_GATE =
            registerBlock("block_ruby_fence_gate",
                          new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
    public static final Block SAPPHIRE_FENCE_GATE =
            registerBlock("block_sapphire_fence_gate",
                          new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));

    public static final Block CITRINE_WALL =
            registerBlock("block_citrine_wall",
                          new WallBlock(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
    public static final Block ENDERITE_WALL =
            registerBlock("block_enderite_wall",
                          new WallBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    public static final Block RUBY_WALL =
            registerBlock("block_ruby_wall",
                          new WallBlock(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));
    public static final Block SAPPHIRE_WALL =
            registerBlock("block_sapphire_wall",
                          new WallBlock(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)));

    public static final Block CITRINE_DOOR =
            registerBlock("block_citrine_door",
                          new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.IRON_DOOR)));
    public static final Block ENDERITE_DOOR =
            registerBlock("block_enderite_door",
                          new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.IRON_DOOR)));
    public static final Block RUBY_DOOR =
            registerBlock("block_ruby_door",
                          new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.IRON_DOOR)));
    public static final Block SAPPHIRE_DOOR =
            registerBlock("block_sapphire_door",
                          new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.IRON_DOOR)));

    public static final Block CITRINE_TRAP_DOOR =
            registerBlock("block_citrine_trap_door",
                          new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.IRON_TRAPDOOR)));
    public static final Block ENDERITE_TRAP_DOOR =
            registerBlock("block_enderite_trap_door",
                          new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.IRON_TRAPDOOR)));
    public static final Block RUBY_TRAP_DOOR =
            registerBlock("block_ruby_trap_door",
                          new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.IRON_TRAPDOOR)));
    public static final Block SAPPHIRE_TRAP_DOOR =
            registerBlock("block_sapphire_trap_door",
                          new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.IRON_TRAPDOOR)));
    //endregion

    //region ORE
    public static final Block ORE_DEEP_CITRINE = registerBlock("ore_deep_citrine", new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_IRON_ORE)));
    public static final Block ORE_DEEP_RUBY = registerBlock("ore_deep_ruby", new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));
    public static final Block ORE_DEEP_SAPPHIRE = registerBlock("ore_deep_sapphire", new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));

    public static final Block ORE_END_CITRINE = registerBlock("ore_end_citrine", new Block(AbstractBlock.Settings.copy(Blocks.END_STONE)));
    public static final Block ORE_END_ENDERITE = registerBlock("ore_end_enderite", new Block(AbstractBlock.Settings.copy(Blocks.END_STONE)));
    public static final Block ORE_END_ENDERITE_CRACKED = registerBlock("ore_end_enderite_cracked", new Block(AbstractBlock.Settings.copy(Blocks.END_STONE)));
    public static final Block ORE_END_RUBY = registerBlock("ore_end_ruby", new Block(AbstractBlock.Settings.copy(Blocks.END_STONE)));
    public static final Block ORE_END_SAPPHIRE = registerBlock("ore_end_sapphire", new Block(AbstractBlock.Settings.copy(Blocks.END_STONE)));

    public static final Block ORE_NETHER_CITRINE = registerBlock("ore_nether_citrine", new Block(AbstractBlock.Settings.copy(Blocks.NETHER_GOLD_ORE)));
    public static final Block ORE_NETHER_RUBY = registerBlock("ore_nether_ruby", new Block(AbstractBlock.Settings.copy(Blocks.NETHER_GOLD_ORE)));
    public static final Block ORE_NETHER_SAPPHIRE = registerBlock("ore_nether_sapphire", new Block(AbstractBlock.Settings.copy(Blocks.NETHER_GOLD_ORE)));
    public static final Block ORE_NETHER_COAL = registerBlock("ore_nether_coal", new Block(AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE)));
    public static final Block ORE_NETHER_COPPER = registerBlock("ore_nether_copper", new Block(AbstractBlock.Settings.copy(Blocks.NETHER_GOLD_ORE)));
    public static final Block ORE_NETHER_DIAMOND = registerBlock("ore_nether_diamond", new Block(AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE)));
    public static final Block ORE_NETHER_IRON = registerBlock("ore_nether_iron", new Block(AbstractBlock.Settings.copy(Blocks.NETHER_QUARTZ_ORE)));
    public static final Block ORE_NETHER_LAPIS = registerBlock("ore_nether_lapis", new Block(AbstractBlock.Settings.copy(Blocks.NETHER_GOLD_ORE)));
    public static final Block ORE_NETHER_REDSTONE = registerBlock("ore_nether_redstone", new Block(AbstractBlock.Settings.copy(Blocks.NETHER_GOLD_ORE)));

    public static final Block ORE_WORLD_CITRINE = registerBlock("ore_world_citrine", new Block(AbstractBlock.Settings.copy(Blocks.IRON_ORE)));
    public static final Block ORE_WORLD_RUBY = registerBlock("ore_world_ruby", new Block(AbstractBlock.Settings.copy(Blocks.IRON_ORE)));
    public static final Block ORE_WORLD_SAPPHIRE = registerBlock("ore_world_sapphire", new Block(AbstractBlock.Settings.copy(Blocks.IRON_ORE)));

    public static final Block ORE_ENDERITE = registerBlock("ore_enderite", new Block(AbstractBlock.Settings.copy(Blocks.ANCIENT_DEBRIS)));
    //endregion

    //region GOO

    public static final Block WATER_EATING_GOO = registerBlock("water_eating_goo", new Block(AbstractBlock.Settings.copy(Blocks.GRAY_WOOL)));
    public static final Block WATER_GENERATING_GOO = registerBlock("water_generating_goo", new Block(AbstractBlock.Settings.copy(Blocks.GRAY_WOOL)));
    public static final Block LAVA_EATING_GOO = registerBlock("lava_eating_goo", new Block(AbstractBlock.Settings.copy(Blocks.GRAY_WOOL)));
    public static final Block LAVA_GENERATING_GOO = registerBlock("lava_generating_goo", new Block(AbstractBlock.Settings.copy(Blocks.GRAY_WOOL)));
    public static final Block CHUNK_GOO = registerBlock("chunk_goo", new Block(AbstractBlock.Settings.copy(Blocks.GRAY_WOOL)));
    public static final Block TOWERING_GOO = registerBlock("towering_goo", new Block(AbstractBlock.Settings.copy(Blocks.GRAY_WOOL)));
    public static final Block TUNNELING_GOO = registerBlock("tunneling_goo", new Block(AbstractBlock.Settings.copy(Blocks.GRAY_WOOL)));
    public static final Block BRIDGE_GOO = registerBlock("bridge_goo", new Block(AbstractBlock.Settings.copy(Blocks.GRAY_WOOL)));
    //endregion

    //region MACHINES
    //public static final Block ALLOY_SMELTER = registerBlock("alloy_smelter", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    //public static final Block CAST_PRESS = registerBlock("cast_press", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    //public static final Block GEM_CLEANER = registerBlock("gem_cleaner", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    //public static final Block GENERATOR = registerBlock("generator", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    //public static final Block OVEN = registerBlock("oven", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    //public static final Block PULVERIZER = registerBlock("pulverizer", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    //public static final Block SMELTER = registerBlock("smelter", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    //public static final Block FLUID_PUMP = registerBlock("fluid_pump", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    //public static final Block BLOCK_BREAKER = registerBlock("block_breaker", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    //public static final Block BLOCK_PLACER = registerBlock("block_placer", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    //public static final Block WOOD_STRIPPER = registerBlock("wood_stripper", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    //public static final Block ANIMAL_FEED = registerBlock("animal_feed", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    //public static final Block TESSERACT = registerBlock("tesseract", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).nonOpaque()));
    // Enderchanter
    // Project Table
    public static final Block ELEVATOR = registerBlock("elevator", new ElevatorBlock(AbstractBlock.Settings.copy(Blocks.GRAY_WOOL)));
    //endregion

    // TODO : Explain pillar block, leaves block, and sappling block here
    public static final Block RUBBER_WOOD_LOG = registerBlock("rubber_wood_log",
                                                              new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).strength(4f)));
    public static final Block RUBBER_WOOD_WOOD = registerBlock("rubber_wood_wood",
                                                               new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).strength(4f)));
    public static final Block STRIPPED_RUBBER_WOOD_LOG = registerBlock("stripped_rubber_wood_log",
                                                                       new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).strength(4f)));
    public static final Block STRIPPED_RUBBER_WOOD_WOOD = registerBlock("stripped_rubber_wood_wood",
                                                                        new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).strength(4f)));
    public static final Block RUBBER_WOOD_PLANKS = registerBlock("rubber_wood_planks",
                                                                 new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).strength(4f)));
    public static final Block RUBBER_WOOD_LEAVES = registerBlock("rubber_wood_leaves",
                                                                 new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).strength(1f)));
    // TODO : Add world gen for sapling later (generator --> null)
    public static final Block RUBBER_WOOD_SAPLING = registerBlock("stripped_rubber_sapling",
                                                                  new SaplingBlock(null, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    public static final Block RUBBER_WOOD_STAIRS =
            registerBlock("rubber_wood_stairs",
                          new StairsBlock(ModBlocks.RUBBER_WOOD_PLANKS.getDefaultState(),
                                          AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));

    public static final Block RUBBER_WOOD_SLAB =
            registerBlock("rubber_wood_slab",
                          new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));

    public static final Block RUBBER_WOOD_BUTTON =
            registerBlock("rubber_wood_button",
                          new ButtonBlock(BlockSetType.OAK, 30,
                                          AbstractBlock.Settings.copy(Blocks.OAK_BUTTON)));

    public static final Block RUBBER_WOOD_PRESSURE_PLATE =
            registerBlock("rubber_wood_pressure_plate",
                          new PressurePlateBlock(BlockSetType.OAK,
                                                 AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE)));

    public static final Block RUBBER_WOOD_FENCE =
            registerBlock("rubber_wood_fence",
                          new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE)));

    public static final Block RUBBER_WOOD_FENCE_GATE =
            registerBlock("rubber_wood_fence_gate",
                          new FenceGateBlock(WoodType.OAK,
                                             AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE)));

    public static final Block RUBBER_WOOD_DOOR =
            registerBlock("rubber_wood_door",
                          new DoorBlock(BlockSetType.OAK,
                                        AbstractBlock.Settings.copy(Blocks.OAK_DOOR)));

    public static final Block RUBBER_WOOD_TRAP_DOOR =
            registerBlock("rubber_wood_trap_door",
                          new TrapdoorBlock(BlockSetType.OAK,
                                            AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR)));

    public ModBlocks()
    {
        throw new AssertionError();
    }

    //region HELPER METHODS

    public static void register()
    {
        log("Registering Blocks");
    }

    private static Block registerBlock(String name, Block block)
    {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, identifier(name), block);
    }

    private static Item registerBlockItem(String name, Block block)
    {
        return Registry.register(Registries.ITEM, identifier(name),
                                 new BlockItem(block, new Item.Settings()));
    }

    //endregion
}