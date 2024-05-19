package jiraiyah.uio.registry;

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

    public static final Block GRAY_GOO = registerBlock("gray_goo", new Block(AbstractBlock.Settings.copy(Blocks.GRAY_WOOL)));
    public static final Block WORLD_EATING_GOO = registerBlock("world_eating_goo", new Block(AbstractBlock.Settings.copy(Blocks.GRAY_WOOL)));
    public static final Block CHUNK_GOO = registerBlock("chunk_goo", new Block(AbstractBlock.Settings.copy(Blocks.GRAY_WOOL)));
    public static final Block TOWERING_GOO = registerBlock("towering_goo", new Block(AbstractBlock.Settings.copy(Blocks.GRAY_WOOL)));

    public ModBlocks()
    {
        throw new AssertionError();
    }

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
}