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

package jiraiyah.uio.datagen;

import com.google.gson.JsonElement;
import jiraiyah.uio.registry.ModBlocks;
import jiraiyah.uio.registry.ModItems;
import jiraiyah.uio.registry.misc.ModArmorMaterials;
import jiraiyah.uio.util.block.AbstractActivatableBlock;
import jiraiyah.uio.util.block.AbstractActivatableMachineBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

import static jiraiyah.uio.Reference.logRGB256;
import static jiraiyah.uio.util.Registers.Datagen.registerAllArmor;

public class ModModelProvider extends FabricModelProvider
{
    public ModModelProvider(FabricDataOutput output)
    {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator)
    {
        logRGB256("Generating Block Model Data", 0, 255, 0);

        //region GEM
        BlockStateModelGenerator.BlockTexturePool citrine_pool = generator.registerCubeAllModelTexturePool(ModBlocks.CITRINE);
        BlockStateModelGenerator.BlockTexturePool ruby_pool = generator.registerCubeAllModelTexturePool(ModBlocks.RUBY);
        BlockStateModelGenerator.BlockTexturePool sapphire_pool = generator.registerCubeAllModelTexturePool(ModBlocks.SAPPHIRE);
        BlockStateModelGenerator.BlockTexturePool enderite_pool = generator.registerCubeAllModelTexturePool(ModBlocks.ENDERITE);
        //endregion
        //region RAW
        generator.registerSimpleCubeAll(ModBlocks.RAW_CITRINE);
        generator.registerSimpleCubeAll(ModBlocks.RAW_ENDERITE);
        generator.registerSimpleCubeAll(ModBlocks.RAW_QUARTZ);
        generator.registerSimpleCubeAll(ModBlocks.RAW_RUBY);
        generator.registerSimpleCubeAll(ModBlocks.RAW_SAPPHIRE);
        //endregion
        //region SPECIAL BLOCKS
        citrine_pool.stairs(ModBlocks.CITRINE_STAIRS);
        citrine_pool.slab(ModBlocks.CITRINE_SLAB);
        citrine_pool.button(ModBlocks.CITRINE_BUTTON);
        citrine_pool.pressurePlate(ModBlocks.CITRINE_PRESSURE_PLATE);
        citrine_pool.fence(ModBlocks.CITRINE_FENCE);
        citrine_pool.fenceGate(ModBlocks.CITRINE_FENCE_GATE);
        citrine_pool.wall(ModBlocks.CITRINE_WALL);

        generator.registerDoor(ModBlocks.CITRINE_DOOR);
        generator.registerTrapdoor(ModBlocks.CITRINE_TRAP_DOOR);

        enderite_pool.stairs(ModBlocks.ENDERITE_STAIRS);
        enderite_pool.slab(ModBlocks.ENDERITE_SLAB);
        enderite_pool.button(ModBlocks.ENDERITE_BUTTON);
        enderite_pool.pressurePlate(ModBlocks.ENDERITE_PRESSURE_PLATE);
        enderite_pool.fence(ModBlocks.ENDERITE_FENCE);
        enderite_pool.fenceGate(ModBlocks.ENDERITE_FENCE_GATE);
        enderite_pool.wall(ModBlocks.ENDERITE_WALL);

        generator.registerDoor(ModBlocks.ENDERITE_DOOR);
        generator.registerTrapdoor(ModBlocks.ENDERITE_TRAP_DOOR);

        ruby_pool.stairs(ModBlocks.RUBY_STAIRS);
        ruby_pool.slab(ModBlocks.RUBY_SLAB);
        ruby_pool.button(ModBlocks.RUBY_BUTTON);
        ruby_pool.pressurePlate(ModBlocks.RUBY_PRESSURE_PLATE);
        ruby_pool.fence(ModBlocks.RUBY_FENCE);
        ruby_pool.fenceGate(ModBlocks.RUBY_FENCE_GATE);
        ruby_pool.wall(ModBlocks.RUBY_WALL);

        generator.registerDoor(ModBlocks.RUBY_DOOR);
        generator.registerTrapdoor(ModBlocks.RUBY_TRAP_DOOR);

        sapphire_pool.stairs(ModBlocks.SAPPHIRE_STAIRS);
        sapphire_pool.slab(ModBlocks.SAPPHIRE_SLAB);
        sapphire_pool.button(ModBlocks.SAPPHIRE_BUTTON);
        sapphire_pool.pressurePlate(ModBlocks.SAPPHIRE_PRESSURE_PLATE);
        sapphire_pool.fence(ModBlocks.SAPPHIRE_FENCE);
        sapphire_pool.fenceGate(ModBlocks.SAPPHIRE_FENCE_GATE);
        sapphire_pool.wall(ModBlocks.SAPPHIRE_WALL);

        generator.registerDoor(ModBlocks.SAPPHIRE_DOOR);
        generator.registerTrapdoor(ModBlocks.SAPPHIRE_TRAP_DOOR);
        //endregion
        //region ORE
        generator.registerSimpleCubeAll(ModBlocks.ORE_DEEP_CITRINE);
        generator.registerSimpleCubeAll(ModBlocks.ORE_DEEP_RUBY);
        generator.registerSimpleCubeAll(ModBlocks.ORE_DEEP_SAPPHIRE);
        generator.registerSimpleCubeAll(ModBlocks.ORE_END_CITRINE);
        generator.registerSimpleCubeAll(ModBlocks.ORE_END_ENDERITE);
        generator.registerSimpleCubeAll(ModBlocks.ORE_END_ENDERITE_CRACKED);
        generator.registerSimpleCubeAll(ModBlocks.ORE_END_RUBY);
        generator.registerSimpleCubeAll(ModBlocks.ORE_END_SAPPHIRE);
        generator.registerSimpleCubeAll(ModBlocks.ORE_NETHER_CITRINE);
        generator.registerSimpleCubeAll(ModBlocks.ORE_NETHER_COAL);
        generator.registerSimpleCubeAll(ModBlocks.ORE_NETHER_COPPER);
        generator.registerSimpleCubeAll(ModBlocks.ORE_NETHER_DIAMOND);
        generator.registerSimpleCubeAll(ModBlocks.ORE_NETHER_IRON);
        generator.registerSimpleCubeAll(ModBlocks.ORE_NETHER_LAPIS);
        generator.registerSimpleCubeAll(ModBlocks.ORE_NETHER_REDSTONE);
        generator.registerSimpleCubeAll(ModBlocks.ORE_NETHER_RUBY);
        generator.registerSimpleCubeAll(ModBlocks.ORE_NETHER_SAPPHIRE);
        generator.registerSimpleCubeAll(ModBlocks.ORE_WORLD_CITRINE);
        generator.registerSimpleCubeAll(ModBlocks.ORE_WORLD_RUBY);
        generator.registerSimpleCubeAll(ModBlocks.ORE_WORLD_SAPPHIRE);

        generator.registerSingleton(ModBlocks.ORE_ENDERITE, TexturedModel.CUBE_COLUMN);
        //endregion
        //region GOO
        generator.registerSimpleCubeAll(ModBlocks.BRIDGE_GOO);
        generator.registerSimpleCubeAll(ModBlocks.TUNNELING_GOO);
        generator.registerSimpleCubeAll(ModBlocks.TOWERING_GOO);
        generator.registerSimpleCubeAll(ModBlocks.CHUNK_GOO);
        generator.registerSimpleCubeAll(ModBlocks.LAVA_EATING_GOO);
        generator.registerSimpleCubeAll(ModBlocks.LAVA_GENERATING_GOO);
        generator.registerSimpleCubeAll(ModBlocks.LAVA_PUMP_GOO);
        generator.registerSimpleCubeAll(ModBlocks.WATER_EATING_GOO);
        generator.registerSimpleCubeAll(ModBlocks.WATER_GENERATING_GOO);
        generator.registerSimpleCubeAll(ModBlocks.WATER_PUMP_GOO);

        generator.registerSimpleCubeAll(ModBlocks.AIR_BOMB_GOO);
        generator.registerSimpleCubeAll(ModBlocks.CHUNK_BOMB_GOO);
        generator.registerSimpleCubeAll(ModBlocks.STONE_BOMB_GOO);
        //endregion
       
        //region MACHINES
        generator.registerSimpleCubeAll(ModBlocks.ANGEL);
        generator.registerSimpleCubeAll(ModBlocks.CREATIVE_BANK);
        generator.registerSimpleCubeAll(ModBlocks.BATTERY_BANK);

        generator.registerSingleton(ModBlocks.CARROT_BOX, TexturedModel.CUBE_BOTTOM_TOP);
        generator.registerSingleton(ModBlocks.POTATO_BOX, TexturedModel.CUBE_BOTTOM_TOP);

        generator.registerSingleton(ModBlocks.ELEVATOR, TexturedModel.CUBE_BOTTOM_TOP);
        //generator.registerSingleton(ModBlocks.ANIMAL_FEED, TexturedModel.CUBE_BOTTOM_TOP);
        //generator.registerSingleton(ModBlocks.SOLAR_PANEL, TexturedModel.CUBE_BOTTOM_TOP);
        generator.registerSingleton(ModBlocks.MINER, TexturedModel.CUBE_BOTTOM_TOP);

        generator.registerSingleton(ModBlocks.CAST_PRESS, TexturedModel.ORIENTABLE);
        generator.registerSingleton(ModBlocks.BLOCK_BREAKER, TexturedModel.ORIENTABLE);
        generator.registerSingleton(ModBlocks.BLOCK_PLACER, TexturedModel.ORIENTABLE);
        generator.registerSingleton(ModBlocks.FLUID_PUMP, TexturedModel.ORIENTABLE);

        registerCubeVariantBlock(generator, ModBlocks.REDSTONE_CLOCK, AbstractActivatableBlock.ACTIVATED);

        registerOrientableVariantBlock(generator, ModBlocks.ALLOY_MIXER, AbstractActivatableMachineBlock.ACTIVATED);
        registerOrientableVariantBlock(generator, ModBlocks.GEM_CLEANER, AbstractActivatableMachineBlock.ACTIVATED);
        registerOrientableVariantBlock(generator, ModBlocks.OVEN, AbstractActivatableMachineBlock.ACTIVATED);
        registerOrientableVariantBlock(generator, ModBlocks.PULVERIZER, AbstractActivatableMachineBlock.ACTIVATED);
        registerOrientableVariantBlock(generator, ModBlocks.SMELTER, AbstractActivatableMachineBlock.ACTIVATED);
        registerOrientableVariantBlock(generator, ModBlocks.GENERATOR, AbstractActivatableMachineBlock.ACTIVATED);
        registerOrientableVariantBlock(generator, ModBlocks.BUILDER, AbstractActivatableMachineBlock.ACTIVATED);
        registerOrientableVariantBlock(generator, ModBlocks.WOOD_STRIPPER, AbstractActivatableMachineBlock.ACTIVATED);

        generator.registerSimpleState(ModBlocks.ENDER_CHANTER);
        generator.registerSimpleState(ModBlocks.PROJECT_TABLE);
        generator.registerSimpleState(ModBlocks.TESSERACT);
        generator.registerSimpleState(ModBlocks.PRINTER);
        generator.registerSimpleState(ModBlocks.ANIMAL_FEED);
        generator.registerNorthDefaultHorizontalRotation(ModBlocks.SOLAR_PANEL);
        //endregion
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator)
    {
        logRGB256("Generating Item Model Data", 0, 255, 0);

        //region FOOD FUEL MISC
        generator.register(ModItems.BINDING_STRING, Models.GENERATED);
        generator.register(ModItems.UNSTABLE_GOO, Models.GENERATED);
        generator.register(ModItems.COMBUSTION_CORE, Models.GENERATED);
        generator.register(ModItems.RAW_RUBBER, Models.GENERATED);
        generator.register(ModItems.RUBBER, Models.GENERATED);
        generator.register(ModItems.VOID_PLATE, Models.GENERATED);
        generator.register(ModItems.VOID_PLATE_ACTIVATOR, Models.GENERATED);
        generator.register(ModItems.VOID_PLATE_BASE, Models.GENERATED);
        generator.register(ModItems.ENDER_CHARM, Models.GENERATED);
        generator.register(ModItems.ENDERMAN_EYE, Models.GENERATED);
        generator.register(ModItems.ENDERMAN_HEART, Models.GENERATED);
        generator.register(ModItems.ENDERMAN_GLAND, Models.GENERATED);
        generator.register(ModItems.ITEM_FILTER, Models.GENERATED);
        generator.register(ModItems.SLOT_DISABLED, Models.GENERATED);
        generator.register(ModItems.SLOT_ENABLED, Models.GENERATED);

        generator.register(ModItems.COOKED_EGG, Models.GENERATED);
        generator.register(ModItems.EGG_AND_BREAD, Models.GENERATED);
        generator.register(ModItems.HOT_COAL, Models.GENERATED);
        generator.register(ModItems.THERMAL_CORE, Models.GENERATED);


        //endregion
        //region CAST
        generator.register(ModItems.CAST_AXE, Models.GENERATED);
        generator.register(ModItems.CAST_BINDING, Models.GENERATED);
        generator.register(ModItems.CAST_EXCAVATOR, Models.GENERATED);
        generator.register(ModItems.CAST_GEAR, Models.GENERATED);
        generator.register(ModItems.CAST_GEM, Models.GENERATED);
        generator.register(ModItems.CAST_HAMMER, Models.GENERATED);
        generator.register(ModItems.CAST_HANDLE, Models.GENERATED);
        generator.register(ModItems.CAST_HOE, Models.GENERATED);
        generator.register(ModItems.CAST_INGOT, Models.GENERATED);
        generator.register(ModItems.CAST_NUGGET, Models.GENERATED);
        generator.register(ModItems.CAST_PICKAXE, Models.GENERATED);
        generator.register(ModItems.CAST_PLATE, Models.GENERATED);
        generator.register(ModItems.CAST_ROD, Models.GENERATED);
        generator.register(ModItems.CAST_SHOVEL, Models.GENERATED);
        generator.register(ModItems.CAST_SWORD, Models.GENERATED);
        generator.register(ModItems.CAST_WIRE, Models.GENERATED);
        generator.register(ModItems.CAST_WOOD_INGOT, Models.GENERATED);
        generator.register(ModItems.CAST_WOOD_PICKAXE, Models.GENERATED);
        //endregion
        //region DUST
        generator.register(ModItems.CRUSHED_SHULKER, Models.GENERATED);
        generator.register(ModItems.DUST_CONDUCTIVE, Models.GENERATED);
        generator.register(ModItems.DUST_COPPER, Models.GENERATED);
        generator.register(ModItems.DUST_ENDERITE, Models.GENERATED);
        generator.register(ModItems.DUST_ENERGETIC, Models.GENERATED);
        generator.register(ModItems.DUST_GOLD, Models.GENERATED);
        generator.register(ModItems.DUST_IRON, Models.GENERATED);
        generator.register(ModItems.DUST_OBSIDIAN, Models.GENERATED);
        generator.register(ModItems.DUST_PULSATING, Models.GENERATED);
        generator.register(ModItems.DUST_RED_ALLOY, Models.GENERATED);
        generator.register(ModItems.DUST_SOUL, Models.GENERATED);
        generator.register(ModItems.DUST_VIBRANT, Models.GENERATED);
        generator.register(ModItems.DUST_WITHERING, Models.GENERATED);
        //endregion
        //region GEAR
        generator.register(ModItems.GEAR_COPPER, Models.GENERATED);
        generator.register(ModItems.GEAR_DIAMOND, Models.GENERATED);
        generator.register(ModItems.GEAR_EMERALD, Models.GENERATED);
        generator.register(ModItems.GEAR_ENDERITE, Models.GENERATED);
        generator.register(ModItems.GEAR_ENERGIZED, Models.GENERATED);
        generator.register(ModItems.GEAR_GOLD, Models.GENERATED);
        generator.register(ModItems.GEAR_IRON, Models.GENERATED);
        generator.register(ModItems.GEAR_LAPIS, Models.GENERATED);
        generator.register(ModItems.GEAR_NETHERITE, Models.GENERATED);
        generator.register(ModItems.GEAR_OBSIDIAN, Models.GENERATED);
        generator.register(ModItems.GEAR_PRISMARINE, Models.GENERATED);
        generator.register(ModItems.GEAR_QUARTZ, Models.GENERATED);
        generator.register(ModItems.GEAR_RUBY, Models.GENERATED);
        generator.register(ModItems.GEAR_SAPPHIRE, Models.GENERATED);
        generator.register(ModItems.GEAR_SHULKER, Models.GENERATED);
        generator.register(ModItems.GEAR_STONE, Models.GENERATED);
        generator.register(ModItems.GEAR_VIBRANT, Models.GENERATED);
        generator.register(ModItems.GEAR_WOOD, Models.GENERATED);
        //endregion
        //region GEM
        generator.register(ModItems.GEM_CITRINE, Models.GENERATED);
        generator.register(ModItems.GEM_RUBY, Models.GENERATED);
        generator.register(ModItems.GEM_SAPPHIRE, Models.GENERATED);
        //endregion
        //region INGOT
        generator.register(ModItems.INGOT_ALLOY_CONDUCTIVE, Models.GENERATED);
        generator.register(ModItems.INGOT_ALLOY_ENERGETIC, Models.GENERATED);
        generator.register(ModItems.INGOT_ALLOY_PULSATING, Models.GENERATED);
        generator.register(ModItems.INGOT_ALLOY_RED, Models.GENERATED);
        generator.register(ModItems.INGOT_ALLOY_VIBRANT, Models.GENERATED);

        generator.register(ModItems.INGOT_ALLOY_ENDERITE, Models.GENERATED);
        generator.register(ModItems.INGOT_ENDERITE, Models.GENERATED);
        generator.register(ModItems.RAW_ALLOY_ENDERITE, Models.GENERATED);
        //endregion
        //region PLATE
        generator.register(ModItems.PLATE_AMETHYST, Models.GENERATED);
        generator.register(ModItems.PLATE_CITRINE, Models.GENERATED);
        generator.register(ModItems.PLATE_COPPER, Models.GENERATED);
        generator.register(ModItems.PLATE_DIAMOND, Models.GENERATED);
        generator.register(ModItems.PLATE_EMERALD, Models.GENERATED);
        generator.register(ModItems.PLATE_ENDERITE, Models.GENERATED);
        generator.register(ModItems.PLATE_GOLD, Models.GENERATED);
        generator.register(ModItems.PLATE_IRON, Models.GENERATED);
        generator.register(ModItems.PLATE_NETHERITE, Models.GENERATED);
        generator.register(ModItems.PLATE_RUBY, Models.GENERATED);
        generator.register(ModItems.PLATE_SAPPHIRE, Models.GENERATED);
        generator.register(ModItems.PLATE_SHULKER, Models.GENERATED);
        generator.register(ModItems.PLATE_STONE, Models.GENERATED);
        //endregion
        //region RAW
        generator.register(ModItems.RAW_CITRINE, Models.GENERATED);
        generator.register(ModItems.RAW_ENDERITE, Models.GENERATED);
        generator.register(ModItems.RAW_QUARTZ, Models.GENERATED);
        generator.register(ModItems.RAW_RUBY, Models.GENERATED);
        generator.register(ModItems.RAW_SAPPHIRE, Models.GENERATED);
        //endregion
        //region REINFORCED
        generator.register(ModItems.REINFORCED_AMETHYST, Models.GENERATED);
        generator.register(ModItems.REINFORCED_CITRINE, Models.GENERATED);
        generator.register(ModItems.REINFORCED_COPPER, Models.GENERATED);
        generator.register(ModItems.REINFORCED_DIAMOND, Models.GENERATED);
        generator.register(ModItems.REINFORCED_EMERALD, Models.GENERATED);
        generator.register(ModItems.REINFORCED_ENDERITE, Models.GENERATED);
        generator.register(ModItems.REINFORCED_GOLD, Models.GENERATED);
        generator.register(ModItems.REINFORCED_IRON, Models.GENERATED);
        generator.register(ModItems.REINFORCED_NETHERITE, Models.GENERATED);
        generator.register(ModItems.REINFORCED_RUBY, Models.GENERATED);
        generator.register(ModItems.REINFORCED_SAPPHIRE, Models.GENERATED);
        generator.register(ModItems.REINFORCED_SHULKER, Models.GENERATED);
        //endregion
        //region ROD
        generator.register(ModItems.ROD_COPPER, Models.GENERATED);
        generator.register(ModItems.ROD_ENDERITE, Models.GENERATED);
        generator.register(ModItems.ROD_GLOWSTONE, Models.GENERATED);
        generator.register(ModItems.ROD_GOLD, Models.GENERATED);
        generator.register(ModItems.ROD_IRON, Models.GENERATED);
        generator.register(ModItems.ROD_OBSIDIAN, Models.GENERATED);
        generator.register(ModItems.ROD_REDSTONE, Models.GENERATED);
        generator.register(ModItems.ROD_SHULKER, Models.GENERATED);
        //endregion
        //region HEAD
        generator.register(ModItems.HEAD_CITRINE_AXE, Models.GENERATED);
        generator.register(ModItems.HEAD_CITRINE_EXCAVATOR, Models.GENERATED);
        generator.register(ModItems.HEAD_CITRINE_HAMMER, Models.GENERATED);
        generator.register(ModItems.HEAD_CITRINE_HOE, Models.GENERATED);
        generator.register(ModItems.HEAD_CITRINE_PICKAXE, Models.GENERATED);
        generator.register(ModItems.HEAD_CITRINE_SHOVEL, Models.GENERATED);
        generator.register(ModItems.HEAD_CITRINE_SWORD, Models.GENERATED);

        generator.register(ModItems.HEAD_COPPER_AXE, Models.GENERATED);
        generator.register(ModItems.HEAD_COPPER_EXCAVATOR, Models.GENERATED);
        generator.register(ModItems.HEAD_COPPER_HAMMER, Models.GENERATED);
        generator.register(ModItems.HEAD_COPPER_HOE, Models.GENERATED);
        generator.register(ModItems.HEAD_COPPER_PICKAXE, Models.GENERATED);
        generator.register(ModItems.HEAD_COPPER_SHOVEL, Models.GENERATED);
        generator.register(ModItems.HEAD_COPPER_SWORD, Models.GENERATED);

        generator.register(ModItems.HEAD_DIAMOND_AXE, Models.GENERATED);
        generator.register(ModItems.HEAD_DIAMOND_EXCAVATOR, Models.GENERATED);
        generator.register(ModItems.HEAD_DIAMOND_HAMMER, Models.GENERATED);
        generator.register(ModItems.HEAD_DIAMOND_HOE, Models.GENERATED);
        generator.register(ModItems.HEAD_DIAMOND_PICKAXE, Models.GENERATED);
        generator.register(ModItems.HEAD_DIAMOND_SHOVEL, Models.GENERATED);
        generator.register(ModItems.HEAD_DIAMOND_SWORD, Models.GENERATED);

        generator.register(ModItems.HEAD_ENDERITE_AXE, Models.GENERATED);
        generator.register(ModItems.HEAD_ENDERITE_EXCAVATOR, Models.GENERATED);
        generator.register(ModItems.HEAD_ENDERITE_HAMMER, Models.GENERATED);
        generator.register(ModItems.HEAD_ENDERITE_HOE, Models.GENERATED);
        generator.register(ModItems.HEAD_ENDERITE_PICKAXE, Models.GENERATED);
        generator.register(ModItems.HEAD_ENDERITE_SHOVEL, Models.GENERATED);
        generator.register(ModItems.HEAD_ENDERITE_SWORD, Models.GENERATED);

        generator.register(ModItems.HEAD_GOLD_AXE, Models.GENERATED);
        generator.register(ModItems.HEAD_GOLD_EXCAVATOR, Models.GENERATED);
        generator.register(ModItems.HEAD_GOLD_HAMMER, Models.GENERATED);
        generator.register(ModItems.HEAD_GOLD_HOE, Models.GENERATED);
        generator.register(ModItems.HEAD_GOLD_PICKAXE, Models.GENERATED);
        generator.register(ModItems.HEAD_GOLD_SHOVEL, Models.GENERATED);
        generator.register(ModItems.HEAD_GOLD_SWORD, Models.GENERATED);

        generator.register(ModItems.HEAD_IRON_AXE, Models.GENERATED);
        generator.register(ModItems.HEAD_IRON_EXCAVATOR, Models.GENERATED);
        generator.register(ModItems.HEAD_IRON_HAMMER, Models.GENERATED);
        generator.register(ModItems.HEAD_IRON_HOE, Models.GENERATED);
        generator.register(ModItems.HEAD_IRON_PICKAXE, Models.GENERATED);
        generator.register(ModItems.HEAD_IRON_SHOVEL, Models.GENERATED);
        generator.register(ModItems.HEAD_IRON_SWORD, Models.GENERATED);

        generator.register(ModItems.HEAD_NETHERITE_AXE, Models.GENERATED);
        generator.register(ModItems.HEAD_NETHERITE_EXCAVATOR, Models.GENERATED);
        generator.register(ModItems.HEAD_NETHERITE_HAMMER, Models.GENERATED);
        generator.register(ModItems.HEAD_NETHERITE_HOE, Models.GENERATED);
        generator.register(ModItems.HEAD_NETHERITE_PICKAXE, Models.GENERATED);
        generator.register(ModItems.HEAD_NETHERITE_SHOVEL, Models.GENERATED);
        generator.register(ModItems.HEAD_NETHERITE_SWORD, Models.GENERATED);

        generator.register(ModItems.HEAD_RUBY_AXE, Models.GENERATED);
        generator.register(ModItems.HEAD_RUBY_EXCAVATOR, Models.GENERATED);
        generator.register(ModItems.HEAD_RUBY_HAMMER, Models.GENERATED);
        generator.register(ModItems.HEAD_RUBY_HOE, Models.GENERATED);
        generator.register(ModItems.HEAD_RUBY_PICKAXE, Models.GENERATED);
        generator.register(ModItems.HEAD_RUBY_SHOVEL, Models.GENERATED);
        generator.register(ModItems.HEAD_RUBY_SWORD, Models.GENERATED);

        generator.register(ModItems.HEAD_SAPPHIRE_AXE, Models.GENERATED);
        generator.register(ModItems.HEAD_SAPPHIRE_EXCAVATOR, Models.GENERATED);
        generator.register(ModItems.HEAD_SAPPHIRE_HAMMER, Models.GENERATED);
        generator.register(ModItems.HEAD_SAPPHIRE_HOE, Models.GENERATED);
        generator.register(ModItems.HEAD_SAPPHIRE_PICKAXE, Models.GENERATED);
        generator.register(ModItems.HEAD_SAPPHIRE_SHOVEL, Models.GENERATED);
        generator.register(ModItems.HEAD_SAPPHIRE_SWORD, Models.GENERATED);

        generator.register(ModItems.HEAD_STONE_HAMMER, Models.GENERATED);
        generator.register(ModItems.HEAD_STONE_EXCAVATOR, Models.GENERATED);
        generator.register(ModItems.HEAD_WOOD_HAMMER, Models.GENERATED);
        generator.register(ModItems.HEAD_WOOD_EXCAVATOR, Models.GENERATED);
        //endregion
        //region TOOLS
        generator.register(ModItems.PLAYER_TELEPORT, Models.GENERATED);
        generator.register(ModItems.TUNER, Models.GENERATED);
        generator.register(ModItems.ADVANCED_TUNER, Models.GENERATED);
        generator.register(ModItems.WRENCH, Models.GENERATED);
        generator.register(ModItems.CHALICE, Models.GENERATED);
        generator.register(ModItems.CHALICE_EMPTY, Models.GENERATED);

        generator.register(ModItems.BLUEPRINT_EMPTY, Models.GENERATED);
        generator.register(ModItems.BLUEPRINT_PRINTED, Models.GENERATED);

        generator.register(ModItems.BACKPACK, Models.GENERATED);
        generator.register(ModItems.ENDER_BACKPACK, Models.GENERATED);

        generator.register(ModItems.TOOL_CITRINE_AXE, Models.HANDHELD);
        generator.register(ModItems.TOOL_CITRINE_EXCAVATOR, Models.HANDHELD);
        generator.register(ModItems.TOOL_CITRINE_HAMMER, Models.HANDHELD);
        generator.register(ModItems.TOOL_CITRINE_HOE, Models.HANDHELD);
        generator.register(ModItems.TOOL_CITRINE_PICKAXE, Models.HANDHELD);
        generator.register(ModItems.TOOL_CITRINE_SHOVEL, Models.HANDHELD);
        generator.register(ModItems.TOOL_CITRINE_SWORD, Models.HANDHELD);

        generator.register(ModItems.TOOL_COPPER_AXE, Models.HANDHELD);
        generator.register(ModItems.TOOL_COPPER_EXCAVATOR, Models.HANDHELD);
        generator.register(ModItems.TOOL_COPPER_HAMMER, Models.HANDHELD);
        generator.register(ModItems.TOOL_COPPER_HOE, Models.HANDHELD);
        generator.register(ModItems.TOOL_COPPER_PICKAXE, Models.HANDHELD);
        generator.register(ModItems.TOOL_COPPER_SHOVEL, Models.HANDHELD);
        generator.register(ModItems.TOOL_COPPER_SWORD, Models.HANDHELD);

        generator.register(ModItems.TOOL_ENDERITE_AXE, Models.HANDHELD);
        generator.register(ModItems.TOOL_ENDERITE_EXCAVATOR, Models.HANDHELD);
        generator.register(ModItems.TOOL_ENDERITE_HAMMER, Models.HANDHELD);
        generator.register(ModItems.TOOL_ENDERITE_HOE, Models.HANDHELD);
        generator.register(ModItems.TOOL_ENDERITE_PICKAXE, Models.HANDHELD);
        generator.register(ModItems.TOOL_ENDERITE_SHOVEL, Models.HANDHELD);
        generator.register(ModItems.TOOL_ENDERITE_SWORD, Models.HANDHELD);

        generator.register(ModItems.TOOL_RUBY_AXE, Models.HANDHELD);
        generator.register(ModItems.TOOL_RUBY_EXCAVATOR, Models.HANDHELD);
        generator.register(ModItems.TOOL_RUBY_HAMMER, Models.HANDHELD);
        generator.register(ModItems.TOOL_RUBY_HOE, Models.HANDHELD);
        generator.register(ModItems.TOOL_RUBY_PICKAXE, Models.HANDHELD);
        generator.register(ModItems.TOOL_RUBY_SHOVEL, Models.HANDHELD);
        generator.register(ModItems.TOOL_RUBY_SWORD, Models.HANDHELD);

        generator.register(ModItems.TOOL_SAPPHIRE_AXE, Models.HANDHELD);
        generator.register(ModItems.TOOL_SAPPHIRE_EXCAVATOR, Models.HANDHELD);
        generator.register(ModItems.TOOL_SAPPHIRE_HAMMER, Models.HANDHELD);
        generator.register(ModItems.TOOL_SAPPHIRE_HOE, Models.HANDHELD);
        generator.register(ModItems.TOOL_SAPPHIRE_PICKAXE, Models.HANDHELD);
        generator.register(ModItems.TOOL_SAPPHIRE_SHOVEL, Models.HANDHELD);
        generator.register(ModItems.TOOL_SAPPHIRE_SWORD, Models.HANDHELD);

        generator.register(ModItems.TOOL_DIAMOND_HAMMER, Models.HANDHELD);
        generator.register(ModItems.TOOL_DIAMOND_EXCAVATOR, Models.HANDHELD);
        generator.register(ModItems.TOOL_GOLD_HAMMER, Models.HANDHELD);
        generator.register(ModItems.TOOL_GOLD_EXCAVATOR, Models.HANDHELD);
        generator.register(ModItems.TOOL_IRON_HAMMER, Models.HANDHELD);
        generator.register(ModItems.TOOL_IRON_EXCAVATOR, Models.HANDHELD);
        generator.register(ModItems.TOOL_NETHERITE_HAMMER, Models.HANDHELD);
        generator.register(ModItems.TOOL_NETHERITE_EXCAVATOR, Models.HANDHELD);
        generator.register(ModItems.TOOL_STONE_HAMMER, Models.HANDHELD);
        generator.register(ModItems.TOOL_STONE_EXCAVATOR, Models.HANDHELD);
        generator.register(ModItems.TOOL_WOOD_HAMMER, Models.HANDHELD);
        generator.register(ModItems.TOOL_WOOD_EXCAVATOR, Models.HANDHELD);
        //endregion
        //region ARMOR
        /*registerArmor(generator, ModItems.ARMOR_AMETHYST_HELMET, ModArmorMaterials.AMETHYST, EquipmentSlot.HEAD, false);
        registerArmor(generator, ModItems.ARMOR_AMETHYST_CHESTPLATE, ModArmorMaterials.AMETHYST, EquipmentSlot.CHEST, false);
        registerArmor(generator, ModItems.ARMOR_AMETHYST_LEGGINGS, ModArmorMaterials.AMETHYST, EquipmentSlot.LEGS, false);
        registerArmor(generator, ModItems.ARMOR_AMETHYST_BOOTS, ModArmorMaterials.AMETHYST, EquipmentSlot.FEET, false);*/
        registerAllArmor(generator,
                 new Item[]{ModItems.ARMOR_AMETHYST_HELMET, ModItems.ARMOR_AMETHYST_CHESTPLATE,
                                    ModItems.ARMOR_AMETHYST_LEGGINGS, ModItems.ARMOR_AMETHYST_BOOTS},
                 ModArmorMaterials.AMETHYST, false);
        registerAllArmor(generator,
                 new Item[]{ModItems.ARMOR_CITRINE_HELMET, ModItems.ARMOR_CITRINE_CHESTPLATE,
                                    ModItems.ARMOR_CITRINE_LEGGINGS, ModItems.ARMOR_CITRINE_BOOTS},
                 ModArmorMaterials.CITRINE, false);
        registerAllArmor(generator,
             new Item[]{ModItems.ARMOR_COPPER_HELMET, ModItems.ARMOR_COPPER_CHESTPLATE,
                                ModItems.ARMOR_COPPER_LEGGINGS, ModItems.ARMOR_COPPER_BOOTS},
             ModArmorMaterials.COPPER, false);
        registerAllArmor(generator,
                 new Item[]{ModItems.ARMOR_EMERALD_HELMET, ModItems.ARMOR_EMERALD_CHESTPLATE,
                                    ModItems.ARMOR_EMERALD_LEGGINGS, ModItems.ARMOR_EMERALD_BOOTS},
                 ModArmorMaterials.EMERALD, false);
        registerAllArmor(generator,
                 new Item[]{ModItems.ARMOR_ENDERITE_HELMET, ModItems.ARMOR_ENDERITE_CHESTPLATE,
                                    ModItems.ARMOR_EMERALD_LEGGINGS, ModItems.ARMOR_ENDERITE_BOOTS},
                 ModArmorMaterials.ENDERITE, false);
        registerAllArmor(generator,
                 new Item[]{ModItems.ARMOR_RUBY_HELMET, ModItems.ARMOR_RUBY_CHESTPLATE,
                                    ModItems.ARMOR_RUBY_LEGGINGS, ModItems.ARMOR_RUBY_BOOTS},
                 ModArmorMaterials.RUBY, false);
        registerAllArmor(generator,
                 new Item[]{ModItems.ARMOR_SAPPHIRE_HELMET, ModItems.ARMOR_SAPPHIRE_CHESTPLATE,
                                    ModItems.ARMOR_SAPPHIRE_LEGGINGS, ModItems.ARMOR_SAPPHIRE_BOOTS},
                 ModArmorMaterials.SAPPHIRE, false);
        //endregion
    }

    //region HELPER METHODS
    @SuppressWarnings("SameParameterValue")
    private void registerOrientableVariantBlock(BlockStateModelGenerator generator, Block machine, BooleanProperty property)
    {
        BiConsumer<Identifier, Supplier<JsonElement>> modelCollector = generator.modelCollector;
        Identifier machineOff = TexturedModel.ORIENTABLE.upload(machine, modelCollector);
        Identifier machineFront = TextureMap.getSubId(machine, "_front_on");
        Identifier machineOn = TexturedModel.ORIENTABLE.get(machine).textures((textures) ->
                                                                 {
                                                                     textures.put(TextureKey.FRONT, machineFront);
                                                                 }).upload(machine, "_on", modelCollector);
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(machine)
                                                   .coordinate(BlockStateModelGenerator.createBooleanModelMap(property,
                                                                                                              machineOn,
                                                                                                              machineOff))
                                                   .coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates()));
    }

    @SuppressWarnings("SameParameterValue")
    private void registerCubeVariantBlock(BlockStateModelGenerator generator, Block machine, BooleanProperty property)
    {
        BiConsumer<Identifier, Supplier<JsonElement>> modelCollector = generator.modelCollector;
        Identifier cubeOff = TexturedModel.CUBE_ALL.upload(machine, modelCollector);
        Identifier cubeOn = generator.createSubModel(machine, "_on", Models.CUBE_ALL, TextureMap::all);
        generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(machine)
                                                   .coordinate(BlockStateModelGenerator.createBooleanModelMap(property,
                                                                                                              cubeOn,
                                                                                                              cubeOff)));
    }
    //endregion
}