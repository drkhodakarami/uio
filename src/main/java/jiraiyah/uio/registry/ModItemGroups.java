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

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static jiraiyah.uio.Reference.*;

public class ModItemGroups
{
    public static final ItemGroup BLOCKS =
            Registry.register(Registries.ITEM_GROUP,
                              identifier(ModID + "_block_group"),
                              FabricItemGroup.builder().displayName(translate("block.group"))
                                             .icon(() -> new ItemStack(ModBlocks.CITRINE))
                                             .entries((displayContext, entries) ->
                                                      {
                                                          entries.add(ModBlocks.CITRINE);
                                                          entries.add(ModBlocks.ENDERITE);
                                                          entries.add(ModBlocks.RUBY);
                                                          entries.add(ModBlocks.SAPPHIRE);

                                                          entries.add(ModBlocks.BRIDGE_GOO);
                                                          entries.add(ModBlocks.CHUNK_GOO);
                                                          entries.add(ModBlocks.LAVA_EATING_GOO);
                                                          entries.add(ModBlocks.LAVA_GENERATING_GOO);
                                                          entries.add(ModBlocks.TOWERING_GOO);
                                                          entries.add(ModBlocks.TUNNELING_GOO);
                                                          entries.add(ModBlocks.WATER_EATING_GOO);
                                                          entries.add(ModBlocks.WATER_GENERATING_GOO);

                                                          entries.add(ModBlocks.RAW_CITRINE);
                                                          entries.add(ModBlocks.RAW_ENDERITE);
                                                          entries.add(ModBlocks.RAW_QUARTZ);
                                                          entries.add(ModBlocks.RAW_RUBY);
                                                          entries.add(ModBlocks.RAW_SAPPHIRE);

                                                          entries.add(ModBlocks.CITRINE_BUTTON);
                                                          entries.add(ModBlocks.ENDERITE_BUTTON);
                                                          entries.add(ModBlocks.RUBY_BUTTON);
                                                          entries.add(ModBlocks.SAPPHIRE_BUTTON);

                                                          entries.add(ModBlocks.CITRINE_PRESSURE_PLATE);
                                                          entries.add(ModBlocks.ENDERITE_PRESSURE_PLATE);
                                                          entries.add(ModBlocks.RUBY_PRESSURE_PLATE);
                                                          entries.add(ModBlocks.SAPPHIRE_PRESSURE_PLATE);

                                                          entries.add(ModBlocks.CITRINE_DOOR);
                                                          entries.add(ModBlocks.ENDERITE_DOOR);
                                                          entries.add(ModBlocks.RUBY_DOOR);
                                                          entries.add(ModBlocks.SAPPHIRE_DOOR);

                                                          entries.add(ModBlocks.CITRINE_TRAP_DOOR);
                                                          entries.add(ModBlocks.ENDERITE_TRAP_DOOR);
                                                          entries.add(ModBlocks.RUBY_TRAP_DOOR);
                                                          entries.add(ModBlocks.SAPPHIRE_TRAP_DOOR);

                                                          entries.add(ModBlocks.CITRINE_FENCE);
                                                          entries.add(ModBlocks.ENDERITE_FENCE);
                                                          entries.add(ModBlocks.RUBY_FENCE);
                                                          entries.add(ModBlocks.SAPPHIRE_FENCE);

                                                          entries.add(ModBlocks.CITRINE_FENCE_GATE);
                                                          entries.add(ModBlocks.ENDERITE_FENCE_GATE);
                                                          entries.add(ModBlocks.RUBY_FENCE_GATE);
                                                          entries.add(ModBlocks.SAPPHIRE_FENCE_GATE);

                                                          entries.add(ModBlocks.CITRINE_WALL);
                                                          entries.add(ModBlocks.ENDERITE_WALL);
                                                          entries.add(ModBlocks.RUBY_WALL);
                                                          entries.add(ModBlocks.SAPPHIRE_WALL);

                                                          entries.add(ModBlocks.CITRINE_SLAB);
                                                          entries.add(ModBlocks.ENDERITE_SLAB);
                                                          entries.add(ModBlocks.RUBY_SLAB);
                                                          entries.add(ModBlocks.SAPPHIRE_SLAB);

                                                          entries.add(ModBlocks.CITRINE_STAIRS);
                                                          entries.add(ModBlocks.ENDERITE_STAIRS);
                                                          entries.add(ModBlocks.RUBY_STAIRS);
                                                          entries.add(ModBlocks.SAPPHIRE_STAIRS);

                                                          entries.add(ModBlocks.ORE_ENDERITE);

                                                          entries.add(ModBlocks.ORE_DEEP_CITRINE);
                                                          entries.add(ModBlocks.ORE_DEEP_RUBY);
                                                          entries.add(ModBlocks.ORE_DEEP_SAPPHIRE);
                                                          entries.add(ModBlocks.ORE_END_CITRINE);
                                                          entries.add(ModBlocks.ORE_END_ENDERITE);
                                                          entries.add(ModBlocks.ORE_END_ENDERITE_CRACKED);
                                                          entries.add(ModBlocks.ORE_END_RUBY);
                                                          entries.add(ModBlocks.ORE_END_SAPPHIRE);
                                                          entries.add(ModBlocks.ORE_NETHER_CITRINE);
                                                          entries.add(ModBlocks.ORE_NETHER_COAL);
                                                          entries.add(ModBlocks.ORE_NETHER_COPPER);
                                                          entries.add(ModBlocks.ORE_NETHER_DIAMOND);
                                                          entries.add(ModBlocks.ORE_NETHER_IRON);
                                                          entries.add(ModBlocks.ORE_NETHER_LAPIS);
                                                          entries.add(ModBlocks.ORE_NETHER_REDSTONE);
                                                          entries.add(ModBlocks.ORE_NETHER_RUBY);
                                                          entries.add(ModBlocks.ORE_NETHER_SAPPHIRE);
                                                          entries.add(ModBlocks.ORE_WORLD_CITRINE);
                                                          entries.add(ModBlocks.ORE_WORLD_RUBY);
                                                          entries.add(ModBlocks.ORE_WORLD_SAPPHIRE);
                                                      }).build());

    public static final ItemGroup INGREDIENTS =
            Registry.register(Registries.ITEM_GROUP,
                              identifier(ModID + "_ingredient_group"),
                              FabricItemGroup.builder().displayName(translate("ingredient.group"))
                                             .icon(() -> new ItemStack(ModItems.GEM_RUBY))
                                             .entries((displayContext, entries) ->
                                                      {
                                                          entries.add(ModItems.GEM_CITRINE);
                                                          entries.add(ModItems.GEM_RUBY);
                                                          entries.add(ModItems.GEM_SAPPHIRE);

                                                          entries.add(ModItems.RAW_CITRINE);
                                                          entries.add(ModItems.RAW_ENDERITE);
                                                          entries.add(ModItems.RAW_QUARTZ);
                                                          entries.add(ModItems.RAW_RUBY);
                                                          entries.add(ModItems.RAW_SAPPHIRE);

                                                          entries.add(ModItems.BINDING_STRING);

                                                          entries.add(ModItems.UNSTABLE_GOO);

                                                          entries.add(ModItems.DUST_CONDUCTIVE);
                                                          entries.add(ModItems.DUST_COPPER);
                                                          entries.add(ModItems.DUST_ENDERITE);
                                                          entries.add(ModItems.DUST_ENERGETIC);
                                                          entries.add(ModItems.DUST_GOLD);
                                                          entries.add(ModItems.DUST_IRON);
                                                          entries.add(ModItems.DUST_OBSIDIAN);
                                                          entries.add(ModItems.DUST_PULSATING);
                                                          entries.add(ModItems.DUST_RED_ALLOY);
                                                          entries.add(ModItems.DUST_SOUL);
                                                          entries.add(ModItems.DUST_VIBRANT);
                                                          entries.add(ModItems.DUST_WITHERING);

                                                          entries.add(ModItems.GEAR_COPPER);
                                                          entries.add(ModItems.GEAR_DIAMOND);
                                                          entries.add(ModItems.GEAR_EMERALD);
                                                          entries.add(ModItems.GEAR_ENDERITE);
                                                          entries.add(ModItems.GEAR_ENERGIZED);
                                                          entries.add(ModItems.GEAR_GOLD);
                                                          entries.add(ModItems.GEAR_IRON);
                                                          entries.add(ModItems.GEAR_LAPIS);
                                                          entries.add(ModItems.GEAR_NETHERITE);
                                                          entries.add(ModItems.GEAR_OBSIDIAN);
                                                          entries.add(ModItems.GEAR_PRISMARINE);
                                                          entries.add(ModItems.GEAR_QUARTZ);
                                                          entries.add(ModItems.GEAR_RUBY);
                                                          entries.add(ModItems.GEAR_SAPPHIRE);
                                                          entries.add(ModItems.GEAR_STONE);
                                                          entries.add(ModItems.GEAR_VIBRANT);
                                                          entries.add(ModItems.GEAR_WOOD);

                                                          entries.add(ModItems.INGOT_ALLOY_CONDUCTIVE);
                                                          entries.add(ModItems.INGOT_ALLOY_ENERGETIC);
                                                          entries.add(ModItems.INGOT_ALLOY_PULSATING);
                                                          entries.add(ModItems.INGOT_ALLOY_RED);
                                                          entries.add(ModItems.INGOT_ALLOY_VIBRANT);
                                                          entries.add(ModItems.INGOT_ENDERITE);

                                                          entries.add(ModItems.PLATE_AMETHYST);
                                                          entries.add(ModItems.PLATE_CITRINE);
                                                          entries.add(ModItems.PLATE_COPPER);
                                                          entries.add(ModItems.PLATE_DIAMOND);
                                                          entries.add(ModItems.PLATE_EMERALD);
                                                          entries.add(ModItems.PLATE_ENDERITE);
                                                          entries.add(ModItems.PLATE_GOLD);
                                                          entries.add(ModItems.PLATE_IRON);
                                                          entries.add(ModItems.PLATE_NETHERITE);
                                                          entries.add(ModItems.PLATE_RUBY);
                                                          entries.add(ModItems.PLATE_SAPPHIRE);
                                                          entries.add(ModItems.PLATE_STONE);

                                                          entries.add(ModItems.REINFORCED_AMETHYST);
                                                          entries.add(ModItems.REINFORCED_CITRINE);
                                                          entries.add(ModItems.REINFORCED_COPPER);
                                                          entries.add(ModItems.REINFORCED_DIAMOND);
                                                          entries.add(ModItems.REINFORCED_EMERALD);
                                                          entries.add(ModItems.REINFORCED_ENDERITE);
                                                          entries.add(ModItems.REINFORCED_GOLD);
                                                          entries.add(ModItems.REINFORCED_IRON);
                                                          entries.add(ModItems.REINFORCED_NETHERITE);
                                                          entries.add(ModItems.REINFORCED_RUBY);
                                                          entries.add(ModItems.REINFORCED_SAPPHIRE);

                                                          entries.add(ModItems.ROD_COPPER);
                                                          entries.add(ModItems.ROD_ENDERITE);
                                                          entries.add(ModItems.ROD_GLOWSTONE);
                                                          entries.add(ModItems.ROD_GOLD);
                                                          entries.add(ModItems.ROD_IRON);
                                                          entries.add(ModItems.ROD_OBSIDIAN);
                                                          entries.add(ModItems.ROD_REDSTONE);
                                                      }).build());

    public static final ItemGroup MACHINES =
            Registry.register(Registries.ITEM_GROUP,
                              identifier(ModID + "_machine_group"),
                              FabricItemGroup.builder().displayName(translate("machine.group"))
                                             .icon(() -> new ItemStack(ModBlocks.ELEVATOR))
                                             .entries((displayContext, entries) ->
                                                      {
                                                          //entries.add(ModBlocks.ALLOY_SMELTER);
                                                          //entries.add(ModBlocks.CAST_PRESS);
                                                          //entries.add(ModBlocks.GEM_CLEANER);
                                                          //entries.add(ModBlocks.GENERATOR);
                                                          //entries.add(ModBlocks.OVEN);
                                                          //entries.add(ModBlocks.PULVERIZER);
                                                          //entries.add(ModBlocks.SMELTER);
                                                          //entries.add(ModBlocks.FLUID_PUMP);
                                                          //entries.add(ModBlocks.BLOCK_BREAKER);
                                                          //entries.add(ModBlocks.BLOCK_PLACER);
                                                          //entries.add(ModBlocks.WOOD_STRIPPER);
                                                          //entries.add(ModBlocks.ANIMAL_FEED);
                                                          //entries.add(ModBlocks.TESSERACT);
                                                          entries.add(ModBlocks.ELEVATOR);

                                                          entries.add(ModItems.CAST_AXE);
                                                          entries.add(ModItems.CAST_BINDING);
                                                          entries.add(ModItems.CAST_GEAR);
                                                          entries.add(ModItems.CAST_GEM);
                                                          entries.add(ModItems.CAST_HAMMER);
                                                          entries.add(ModItems.CAST_HANDLE);
                                                          entries.add(ModItems.CAST_HOE);
                                                          entries.add(ModItems.CAST_INGOT);
                                                          entries.add(ModItems.CAST_NUGGET);
                                                          entries.add(ModItems.CAST_PICKAXE);
                                                          entries.add(ModItems.CAST_PLATE);
                                                          entries.add(ModItems.CAST_ROD);
                                                          entries.add(ModItems.CAST_SHOVEL);
                                                          entries.add(ModItems.CAST_SWORD);
                                                          entries.add(ModItems.CAST_WIRE);
                                                          entries.add(ModItems.CAST_WOOD_INGOT);
                                                          entries.add(ModItems.CAST_WOOD_PICKAXE);
                                                      }).build());

    public static final ItemGroup TOOLS =
            Registry.register(Registries.ITEM_GROUP,
                              identifier(ModID + "_tool_group"),
                              FabricItemGroup.builder().displayName(translate("tool.group"))
                                             .icon(() -> new ItemStack(ModItems.TOOL_WRENCH))
                                             .entries((displayContext, entries) ->
                                                      {
                                                          entries.add(ModItems.TOOL_PLAYER_TELEPORT);
                                                          entries.add(ModItems.TOOL_TUNER);
                                                          entries.add(ModItems.TOOL_WRENCH);

                                                          entries.add(ModItems.TOOL_CITRINE_AXE);
                                                          entries.add(ModItems.TOOL_COPPER_AXE);
                                                          entries.add(ModItems.TOOL_ENDERITE_AXE);
                                                          entries.add(ModItems.TOOL_RUBY_AXE);
                                                          entries.add(ModItems.TOOL_SAPPHIRE_AXE);

                                                          entries.add(ModItems.TOOL_CITRINE_HAMMER);
                                                          entries.add(ModItems.TOOL_COPPER_HAMMER);
                                                          entries.add(ModItems.TOOL_ENDERITE_HAMMER);
                                                          entries.add(ModItems.TOOL_RUBY_HAMMER);
                                                          entries.add(ModItems.TOOL_SAPPHIRE_HAMMER);
                                                          entries.add(ModItems.TOOL_GOLD_HAMMER);
                                                          entries.add(ModItems.TOOL_IRON_HAMMER);
                                                          entries.add(ModItems.TOOL_NETHERITE_HAMMER);
                                                          entries.add(ModItems.TOOL_STONE_HAMMER);
                                                          entries.add(ModItems.TOOL_WOOD_HAMMER);

                                                          entries.add(ModItems.TOOL_CITRINE_HOE);
                                                          entries.add(ModItems.TOOL_COPPER_HOE);
                                                          entries.add(ModItems.TOOL_ENDERITE_HOE);
                                                          entries.add(ModItems.TOOL_RUBY_HOE);
                                                          entries.add(ModItems.TOOL_SAPPHIRE_HOE);

                                                          entries.add(ModItems.TOOL_CITRINE_PICKAXE);
                                                          entries.add(ModItems.TOOL_COPPER_PICKAXE);
                                                          entries.add(ModItems.TOOL_ENDERITE_PICKAXE);
                                                          entries.add(ModItems.TOOL_RUBY_PICKAXE);
                                                          entries.add(ModItems.TOOL_SAPPHIRE_PICKAXE);

                                                          entries.add(ModItems.TOOL_CITRINE_SHOVEL);
                                                          entries.add(ModItems.TOOL_COPPER_SHOVEL);
                                                          entries.add(ModItems.TOOL_ENDERITE_SHOVEL);
                                                          entries.add(ModItems.TOOL_RUBY_SHOVEL);
                                                          entries.add(ModItems.TOOL_SAPPHIRE_SHOVEL);

                                                          entries.add(ModItems.TOOL_CITRINE_SWORD);
                                                          entries.add(ModItems.TOOL_COPPER_SWORD);
                                                          entries.add(ModItems.TOOL_ENDERITE_SWORD);
                                                          entries.add(ModItems.TOOL_RUBY_SWORD);
                                                          entries.add(ModItems.TOOL_SAPPHIRE_SWORD);

                                                          entries.add(ModItems.HEAD_CITRINE_AXE);
                                                          entries.add(ModItems.HEAD_CITRINE_HAMMER);
                                                          entries.add(ModItems.HEAD_CITRINE_HOE);
                                                          entries.add(ModItems.HEAD_CITRINE_PICKAXE);
                                                          entries.add(ModItems.HEAD_CITRINE_SHOVEL);
                                                          entries.add(ModItems.HEAD_CITRINE_SWORD);

                                                          entries.add(ModItems.HEAD_COPPER_AXE);
                                                          entries.add(ModItems.HEAD_COPPER_HAMMER);
                                                          entries.add(ModItems.HEAD_COPPER_HOE);
                                                          entries.add(ModItems.HEAD_COPPER_PICKAXE);
                                                          entries.add(ModItems.HEAD_COPPER_SHOVEL);
                                                          entries.add(ModItems.HEAD_COPPER_SWORD);

                                                          entries.add(ModItems.HEAD_DIAMOND_AXE);
                                                          entries.add(ModItems.HEAD_DIAMOND_HAMMER);
                                                          entries.add(ModItems.HEAD_DIAMOND_HOE);
                                                          entries.add(ModItems.HEAD_DIAMOND_PICKAXE);
                                                          entries.add(ModItems.HEAD_DIAMOND_SHOVEL);
                                                          entries.add(ModItems.HEAD_DIAMOND_SWORD);

                                                          entries.add(ModItems.HEAD_ENDERITE_AXE);
                                                          entries.add(ModItems.HEAD_ENDERITE_HAMMER);
                                                          entries.add(ModItems.HEAD_ENDERITE_HOE);
                                                          entries.add(ModItems.HEAD_ENDERITE_PICKAXE);
                                                          entries.add(ModItems.HEAD_ENDERITE_SHOVEL);
                                                          entries.add(ModItems.HEAD_ENDERITE_SWORD);

                                                          entries.add(ModItems.HEAD_GOLD_AXE);
                                                          entries.add(ModItems.HEAD_GOLD_HAMMER);
                                                          entries.add(ModItems.HEAD_GOLD_HOE);
                                                          entries.add(ModItems.HEAD_GOLD_PICKAXE);
                                                          entries.add(ModItems.HEAD_GOLD_SHOVEL);
                                                          entries.add(ModItems.HEAD_GOLD_SWORD);

                                                          entries.add(ModItems.HEAD_IRON_AXE);
                                                          entries.add(ModItems.HEAD_IRON_HAMMER);
                                                          entries.add(ModItems.HEAD_IRON_HOE);
                                                          entries.add(ModItems.HEAD_IRON_PICKAXE);
                                                          entries.add(ModItems.HEAD_IRON_SHOVEL);
                                                          entries.add(ModItems.HEAD_IRON_SWORD);

                                                          entries.add(ModItems.HEAD_NETHERITE_AXE);
                                                          entries.add(ModItems.HEAD_NETHERITE_HAMMER);
                                                          entries.add(ModItems.HEAD_NETHERITE_HOE);
                                                          entries.add(ModItems.HEAD_NETHERITE_PICKAXE);
                                                          entries.add(ModItems.HEAD_NETHERITE_SHOVEL);
                                                          entries.add(ModItems.HEAD_NETHERITE_SWORD);

                                                          entries.add(ModItems.HEAD_RUBY_AXE);
                                                          entries.add(ModItems.HEAD_RUBY_HAMMER);
                                                          entries.add(ModItems.HEAD_RUBY_HOE);
                                                          entries.add(ModItems.HEAD_RUBY_PICKAXE);
                                                          entries.add(ModItems.HEAD_RUBY_SHOVEL);
                                                          entries.add(ModItems.HEAD_RUBY_SWORD);

                                                          entries.add(ModItems.HEAD_SAPPHIRE_AXE);
                                                          entries.add(ModItems.HEAD_SAPPHIRE_HAMMER);
                                                          entries.add(ModItems.HEAD_SAPPHIRE_HOE);
                                                          entries.add(ModItems.HEAD_SAPPHIRE_PICKAXE);
                                                          entries.add(ModItems.HEAD_SAPPHIRE_SHOVEL);
                                                          entries.add(ModItems.HEAD_SAPPHIRE_SWORD);

                                                          entries.add(ModItems.HEAD_STONE_HAMMER);
                                                          entries.add(ModItems.HEAD_WOOD_HAMMER);
                                                      }).build());

    public static final ItemGroup ARMORS =
            Registry.register(Registries.ITEM_GROUP,
                              identifier(ModID + "_armor_group"),
                              FabricItemGroup.builder().displayName(translate("armor.group"))
                                             .icon(() -> new ItemStack(ModItems.ARMOR_AMETHYST_CHESTPLATE))
                                             .entries((displayContext, entries) ->
                                                      {
                                                          entries.add(ModItems.ARMOR_AMETHYST_HELMET);
                                                          entries.add(ModItems.ARMOR_AMETHYST_CHESTPLATE);
                                                          entries.add(ModItems.ARMOR_AMETHYST_LEGGINGS);
                                                          entries.add(ModItems.ARMOR_AMETHYST_BOOTS);

                                                          entries.add(ModItems.ARMOR_CITRINE_HELMET);
                                                          entries.add(ModItems.ARMOR_CITRINE_CHESTPLATE);
                                                          entries.add(ModItems.ARMOR_CITRINE_LEGGINGS);
                                                          entries.add(ModItems.ARMOR_CITRINE_BOOTS);

                                                          entries.add(ModItems.ARMOR_COPPER_HELMET);
                                                          entries.add(ModItems.ARMOR_COPPER_CHESTPLATE);
                                                          entries.add(ModItems.ARMOR_COPPER_LEGGINGS);
                                                          entries.add(ModItems.ARMOR_COPPER_BOOTS);

                                                          entries.add(ModItems.ARMOR_EMERALD_HELMET);
                                                          entries.add(ModItems.ARMOR_EMERALD_CHESTPLATE);
                                                          entries.add(ModItems.ARMOR_EMERALD_LEGGINGS);
                                                          entries.add(ModItems.ARMOR_EMERALD_BOOTS);

                                                          entries.add(ModItems.ARMOR_ENDERITE_HELMET);
                                                          entries.add(ModItems.ARMOR_ENDERITE_CHESTPLATE);
                                                          entries.add(ModItems.ARMOR_ENDERITE_LEGGINGS);
                                                          entries.add(ModItems.ARMOR_ENDERITE_BOOTS);

                                                          entries.add(ModItems.ARMOR_RUBY_HELMET);
                                                          entries.add(ModItems.ARMOR_RUBY_CHESTPLATE);
                                                          entries.add(ModItems.ARMOR_RUBY_LEGGINGS);
                                                          entries.add(ModItems.ARMOR_RUBY_BOOTS);

                                                          entries.add(ModItems.ARMOR_SAPPHIRE_HELMET);
                                                          entries.add(ModItems.ARMOR_SAPPHIRE_CHESTPLATE);
                                                          entries.add(ModItems.ARMOR_SAPPHIRE_LEGGINGS);
                                                          entries.add(ModItems.ARMOR_SAPPHIRE_BOOTS);
                                                      }).build());

    public static final ItemGroup MISC =
            Registry.register(Registries.ITEM_GROUP,
                              identifier(ModID + "_misc_group"),
                              FabricItemGroup.builder().displayName(translate("misc.group"))
                                             .icon(() -> new ItemStack(ModItems.HOT_COAL))
                                             .entries((displayContext, entries) ->
                                                      {
                                                          entries.add(ModItems.COOKED_EGG);
                                                          entries.add(ModItems.EGG_AND_BREAD);
                                                          entries.add(ModItems.HOT_COAL);
                                                      }).build());

    public ModItemGroups()
    {
        throw new AssertionError();
    }

    public static void register()
    {
        log("Registering Item Groups");
    }
}