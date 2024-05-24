package jiraiyah.uio.datagen;

import jiraiyah.uio.Reference;
import jiraiyah.uio.registry.ModBlocks;
import jiraiyah.uio.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;

import static jiraiyah.uio.Reference.logRGB256;

public class ModModelProvider extends FabricModelProvider
{
    public ModModelProvider(FabricDataOutput output)
    {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator)
    {
        logRGB256("Generating Block Model Data", 0, 255, 0);

        //region GEM
        BlockStateModelGenerator.BlockTexturePool citrine_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CITRINE);
        BlockStateModelGenerator.BlockTexturePool ruby_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RUBY);
        BlockStateModelGenerator.BlockTexturePool sapphire_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SAPPHIRE);
        BlockStateModelGenerator.BlockTexturePool enderite_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ENDERITE);
        //endregion

        //region RAW
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_CITRINE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_ENDERITE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_QUARTZ);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_RUBY);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_SAPPHIRE);
        //endregion

        //region SPECIAL BLOCKS
        citrine_pool.stairs(ModBlocks.CITRINE_STAIRS);
        citrine_pool.slab(ModBlocks.CITRINE_SLAB);
        citrine_pool.button(ModBlocks.CITRINE_BUTTON);
        citrine_pool.pressurePlate(ModBlocks.CITRINE_PRESSURE_PLATE);
        citrine_pool.fence(ModBlocks.CITRINE_FENCE);
        citrine_pool.fenceGate(ModBlocks.CITRINE_FENCE_GATE);
        citrine_pool.wall(ModBlocks.CITRINE_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.CITRINE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.CITRINE_TRAP_DOOR);

        enderite_pool.stairs(ModBlocks.ENDERITE_STAIRS);
        enderite_pool.slab(ModBlocks.ENDERITE_SLAB);
        enderite_pool.button(ModBlocks.ENDERITE_BUTTON);
        enderite_pool.pressurePlate(ModBlocks.ENDERITE_PRESSURE_PLATE);
        enderite_pool.fence(ModBlocks.ENDERITE_FENCE);
        enderite_pool.fenceGate(ModBlocks.ENDERITE_FENCE_GATE);
        enderite_pool.wall(ModBlocks.ENDERITE_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.ENDERITE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.ENDERITE_TRAP_DOOR);

        ruby_pool.stairs(ModBlocks.RUBY_STAIRS);
        ruby_pool.slab(ModBlocks.RUBY_SLAB);
        ruby_pool.button(ModBlocks.RUBY_BUTTON);
        ruby_pool.pressurePlate(ModBlocks.RUBY_PRESSURE_PLATE);
        ruby_pool.fence(ModBlocks.RUBY_FENCE);
        ruby_pool.fenceGate(ModBlocks.RUBY_FENCE_GATE);
        ruby_pool.wall(ModBlocks.RUBY_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.RUBY_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.RUBY_TRAP_DOOR);

        sapphire_pool.stairs(ModBlocks.SAPPHIRE_STAIRS);
        sapphire_pool.slab(ModBlocks.SAPPHIRE_SLAB);
        sapphire_pool.button(ModBlocks.SAPPHIRE_BUTTON);
        sapphire_pool.pressurePlate(ModBlocks.SAPPHIRE_PRESSURE_PLATE);
        sapphire_pool.fence(ModBlocks.SAPPHIRE_FENCE);
        sapphire_pool.fenceGate(ModBlocks.SAPPHIRE_FENCE_GATE);
        sapphire_pool.wall(ModBlocks.SAPPHIRE_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.SAPPHIRE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.SAPPHIRE_TRAP_DOOR);
        //endregion

        //region ORE
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_DEEP_CITRINE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_DEEP_RUBY);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_DEEP_SAPPHIRE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_END_CITRINE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_END_ENDERITE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_END_ENDERITE_CRACKED);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_END_RUBY);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_END_SAPPHIRE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_NETHER_CITRINE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_NETHER_COAL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_NETHER_COPPER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_NETHER_DIAMOND);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_NETHER_IRON);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_NETHER_LAPIS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_NETHER_REDSTONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_NETHER_RUBY);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_NETHER_SAPPHIRE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_WORLD_CITRINE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_WORLD_RUBY);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_WORLD_SAPPHIRE);

        blockStateModelGenerator.registerSingleton(ModBlocks.ORE_ENDERITE, TexturedModel.CUBE_COLUMN);
        //endregion

        //region GOO
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAY_GOO);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WORLD_EATING_GOO);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHUNK_GOO);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TOWERING_GOO);
        //endregion

        //region MACHINES
        blockStateModelGenerator.registerSingleton(ModBlocks.ALLOY_SMELTER, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerSingleton(ModBlocks.CAST_PRESS, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerSingleton(ModBlocks.GEM_CLEANER, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerSingleton(ModBlocks.GENERATOR, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerSingleton(ModBlocks.OVEN, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerSingleton(ModBlocks.PULVERIZER, TexturedModel.ORIENTABLE);
        blockStateModelGenerator.registerSingleton(ModBlocks.SMELTER, TexturedModel.ORIENTABLE);

//        blockStateModelGenerator.registerCooker(ModBlocks.ALLOY_SMELTER, TexturedModel.ORIENTABLE);
//        blockStateModelGenerator.registerCooker(ModBlocks.CAST_PRESS, TexturedModel.ORIENTABLE);
//        blockStateModelGenerator.registerCooker(ModBlocks.GEM_CLEANER, TexturedModel.ORIENTABLE);
//        blockStateModelGenerator.registerCooker(ModBlocks.GENERATOR, TexturedModel.ORIENTABLE);
//        blockStateModelGenerator.registerCooker(ModBlocks.OVEN, TexturedModel.ORIENTABLE);
//        blockStateModelGenerator.registerCooker(ModBlocks.PULVERIZER, TexturedModel.ORIENTABLE);
//        blockStateModelGenerator.registerCooker(ModBlocks.SMELTER, TexturedModel.ORIENTABLE);
        //endregion
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator)
    {
        logRGB256("Generating Item Model Data", 0, 255, 0);

        itemModelGenerator.register(ModItems.BINDING_STRING, Models.GENERATED);

        //region CAST
        itemModelGenerator.register(ModItems.CAST_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAST_BINDING, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAST_GEAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAST_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAST_HAMMER, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAST_HANDLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAST_HOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAST_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAST_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAST_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAST_PLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAST_ROD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAST_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAST_SWORD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAST_WIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAST_WOOD_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAST_WOOD_PICKAXE, Models.GENERATED);
        //endregion

        //region DUST
        itemModelGenerator.register(ModItems.DUST_CONDUCTIVE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DUST_COPPER, Models.GENERATED);
        itemModelGenerator.register(ModItems.DUST_ENDERITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DUST_ENERGETIC, Models.GENERATED);
        itemModelGenerator.register(ModItems.DUST_GOLD, Models.GENERATED);
        itemModelGenerator.register(ModItems.DUST_IRON, Models.GENERATED);
        itemModelGenerator.register(ModItems.DUST_OBSIDIAN, Models.GENERATED);
        itemModelGenerator.register(ModItems.DUST_PULSATING, Models.GENERATED);
        itemModelGenerator.register(ModItems.DUST_RED_ALLOY, Models.GENERATED);
        itemModelGenerator.register(ModItems.DUST_SOUL, Models.GENERATED);
        itemModelGenerator.register(ModItems.DUST_VIBRANT, Models.GENERATED);
        itemModelGenerator.register(ModItems.DUST_WITHERING, Models.GENERATED);
        //endregion

        //region GEAR
        itemModelGenerator.register(ModItems.GEAR_COPPER, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEAR_DIAMOND, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEAR_EMERALD, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEAR_ENDERITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEAR_ENERGIZED, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEAR_GOLD, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEAR_IRON, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEAR_LAPIS, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEAR_NETHERITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEAR_OBSIDIAN, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEAR_PRISMARINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEAR_QUARTZ, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEAR_RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEAR_SAPPHIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEAR_STONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEAR_VIBRANT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEAR_WOOD, Models.GENERATED);
        //endregion

        //region GEM
        itemModelGenerator.register(ModItems.GEM_CITRINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEM_RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEM_SAPPHIRE, Models.GENERATED);
        //endregion

        //region INGOT
        itemModelGenerator.register(ModItems.INGOT_ALLOY_CONDUCTIVE, Models.GENERATED);
        itemModelGenerator.register(ModItems.INGOT_ALLOY_ENERGETIC, Models.GENERATED);
        itemModelGenerator.register(ModItems.INGOT_ALLOY_PULSATING, Models.GENERATED);
        itemModelGenerator.register(ModItems.INGOT_ALLOY_RED, Models.GENERATED);
        itemModelGenerator.register(ModItems.INGOT_ALLOY_VIBRANT, Models.GENERATED);

        itemModelGenerator.register(ModItems.INGOT_ENDERITE, Models.GENERATED);
        //endregion

        //region PLATE
        itemModelGenerator.register(ModItems.PLATE_AMETHYST, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATE_CITRINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATE_COPPER, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATE_DIAMOND, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATE_EMERALD, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATE_ENDERITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATE_GOLD, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATE_IRON, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATE_NETHERITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATE_RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATE_SAPPHIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATE_STONE, Models.GENERATED);
        //endregion

        //region RAW
        itemModelGenerator.register(ModItems.RAW_CITRINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_ENDERITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_QUARTZ, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_SAPPHIRE, Models.GENERATED);
        //endregion

        //region REINFORCED
        itemModelGenerator.register(ModItems.REINFORCED_AMETHYST, Models.GENERATED);
        itemModelGenerator.register(ModItems.REINFORCED_CITRINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.REINFORCED_COPPER, Models.GENERATED);
        itemModelGenerator.register(ModItems.REINFORCED_DIAMOND, Models.GENERATED);
        itemModelGenerator.register(ModItems.REINFORCED_EMERALD, Models.GENERATED);
        itemModelGenerator.register(ModItems.REINFORCED_ENDERITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.REINFORCED_GOLD, Models.GENERATED);
        itemModelGenerator.register(ModItems.REINFORCED_IRON, Models.GENERATED);
        itemModelGenerator.register(ModItems.REINFORCED_NETHERITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.REINFORCED_RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.REINFORCED_SAPPHIRE, Models.GENERATED);
        //endregion

        //region ROD
        itemModelGenerator.register(ModItems.ROD_COPPER, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROD_ENDERITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROD_GLOWSTONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROD_GOLD, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROD_IRON, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROD_OBSIDIAN, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROD_REDSTONE, Models.GENERATED);
        //endregion

        //region HEAD
        itemModelGenerator.register(ModItems.HEAD_CITRINE_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_CITRINE_HAMMER, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_CITRINE_HOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_CITRINE_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_CITRINE_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_CITRINE_SWORD, Models.GENERATED);

        itemModelGenerator.register(ModItems.HEAD_COPPER_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_COPPER_HAMMER, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_COPPER_HOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_COPPER_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_COPPER_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_COPPER_SWORD, Models.GENERATED);

        itemModelGenerator.register(ModItems.HEAD_DIAMOND_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_DIAMOND_HAMMER, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_DIAMOND_HOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_DIAMOND_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_DIAMOND_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_DIAMOND_SWORD, Models.GENERATED);

        itemModelGenerator.register(ModItems.HEAD_ENDERITE_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_ENDERITE_HAMMER, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_ENDERITE_HOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_ENDERITE_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_ENDERITE_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_ENDERITE_SWORD, Models.GENERATED);

        itemModelGenerator.register(ModItems.HEAD_GOLD_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_GOLD_HAMMER, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_GOLD_HOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_GOLD_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_GOLD_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_GOLD_SWORD, Models.GENERATED);

        itemModelGenerator.register(ModItems.HEAD_IRON_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_IRON_HAMMER, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_IRON_HOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_IRON_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_IRON_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_IRON_SWORD, Models.GENERATED);

        itemModelGenerator.register(ModItems.HEAD_NETHERITE_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_NETHERITE_HAMMER, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_NETHERITE_HOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_NETHERITE_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_NETHERITE_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_NETHERITE_SWORD, Models.GENERATED);

        itemModelGenerator.register(ModItems.HEAD_RUBY_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_RUBY_HAMMER, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_RUBY_HOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_RUBY_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_RUBY_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_RUBY_SWORD, Models.GENERATED);

        itemModelGenerator.register(ModItems.HEAD_SAPPHIRE_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_SAPPHIRE_HAMMER, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_SAPPHIRE_HOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_SAPPHIRE_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_SAPPHIRE_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_SAPPHIRE_SWORD, Models.GENERATED);

        itemModelGenerator.register(ModItems.HEAD_STONE_HAMMER, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAD_WOOD_HAMMER, Models.GENERATED);
        //endregion

        //region TOOLS
        itemModelGenerator.register(ModItems.TOOL_PLAYER_TELEPORT, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOOL_TUNER, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOOL_WRENCH, Models.GENERATED);

        itemModelGenerator.register(ModItems.TOOL_CITRINE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_CITRINE_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_CITRINE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_CITRINE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_CITRINE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_CITRINE_SWORD, Models.HANDHELD);

        itemModelGenerator.register(ModItems.TOOL_COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_COPPER_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_COPPER_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_COPPER_SWORD, Models.HANDHELD);

        itemModelGenerator.register(ModItems.TOOL_ENDERITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_ENDERITE_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_ENDERITE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_ENDERITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_ENDERITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_ENDERITE_SWORD, Models.HANDHELD);

        itemModelGenerator.register(ModItems.TOOL_RUBY_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_RUBY_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_RUBY_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_RUBY_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_RUBY_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_RUBY_SWORD, Models.HANDHELD);

        itemModelGenerator.register(ModItems.TOOL_SAPPHIRE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_SAPPHIRE_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_SAPPHIRE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_SAPPHIRE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_SAPPHIRE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_SAPPHIRE_SWORD, Models.HANDHELD);

        itemModelGenerator.register(ModItems.TOOL_DIAMOND_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_GOLD_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_IRON_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_NETHERITE_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_STONE_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TOOL_WOOD_HAMMER, Models.HANDHELD);
        //endregion

        //region ARMOR
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_AMETHYST_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_AMETHYST_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_AMETHYST_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_AMETHYST_BOOTS);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_CITRINE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_CITRINE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_CITRINE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_CITRINE_BOOTS);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_COPPER_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_COPPER_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_COPPER_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_COPPER_BOOTS);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_EMERALD_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_EMERALD_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_EMERALD_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_EMERALD_BOOTS);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_ENDERITE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_ENDERITE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_ENDERITE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_ENDERITE_BOOTS);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_RUBY_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_RUBY_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_RUBY_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_RUBY_BOOTS);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_SAPPHIRE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_SAPPHIRE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_SAPPHIRE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ARMOR_SAPPHIRE_BOOTS);
        //endregion
    }
}