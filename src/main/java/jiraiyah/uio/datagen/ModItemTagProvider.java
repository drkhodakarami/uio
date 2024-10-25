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

import jiraiyah.uio.Reference.*;
import jiraiyah.uio.registry.ModBlocks;
import jiraiyah.uio.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

import static jiraiyah.uio.Reference.logRGB256;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider
{

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture)
    {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg)
    {
        logRGB256("Generating Item Tag Data", 0, 255, 0);

        //region TOOLS
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.TOOL_CITRINE_AXE)
                .add(ModItems.TOOL_COPPER_AXE)
                .add(ModItems.TOOL_ENDERITE_AXE)
                .add(ModItems.TOOL_RUBY_AXE)
                .add(ModItems.TOOL_SAPPHIRE_AXE);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.TOOL_CITRINE_HOE)
                .add(ModItems.TOOL_COPPER_HOE)
                .add(ModItems.TOOL_ENDERITE_HOE)
                .add(ModItems.TOOL_RUBY_HOE)
                .add(ModItems.TOOL_SAPPHIRE_HOE);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.TOOL_CITRINE_PICKAXE)
                .add(ModItems.TOOL_COPPER_PICKAXE)
                .add(ModItems.TOOL_ENDERITE_PICKAXE)
                .add(ModItems.TOOL_RUBY_PICKAXE)
                .add(ModItems.TOOL_SAPPHIRE_PICKAXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.TOOL_CITRINE_SHOVEL)
                .add(ModItems.TOOL_COPPER_SHOVEL)
                .add(ModItems.TOOL_ENDERITE_SHOVEL)
                .add(ModItems.TOOL_RUBY_SHOVEL)
                .add(ModItems.TOOL_SAPPHIRE_SHOVEL);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.TOOL_CITRINE_SWORD)
                .add(ModItems.TOOL_COPPER_SWORD)
                .add(ModItems.TOOL_ENDERITE_SWORD)
                .add(ModItems.TOOL_RUBY_SWORD)
                .add(ModItems.TOOL_SAPPHIRE_SWORD);

        getOrCreateTagBuilder(Tags.Item.HAMMERS)
                .add(ModItems.TOOL_CITRINE_HAMMER)
                .add(ModItems.TOOL_COPPER_HAMMER)
                .add(ModItems.TOOL_ENDERITE_HAMMER)
                .add(ModItems.TOOL_RUBY_HAMMER)
                .add(ModItems.TOOL_SAPPHIRE_HAMMER)
                .add(ModItems.TOOL_DIAMOND_HAMMER)
                .add(ModItems.TOOL_GOLD_HAMMER)
                .add(ModItems.TOOL_IRON_HAMMER)
                .add(ModItems.TOOL_NETHERITE_HAMMER)
                .add(ModItems.TOOL_STONE_HAMMER)
                .add(ModItems.TOOL_WOOD_HAMMER);

        getOrCreateTagBuilder(Tags.Item.EXCAVATORS)
                .add(ModItems.TOOL_CITRINE_EXCAVATOR)
                .add(ModItems.TOOL_COPPER_EXCAVATOR)
                .add(ModItems.TOOL_ENDERITE_EXCAVATOR)
                .add(ModItems.TOOL_RUBY_EXCAVATOR)
                .add(ModItems.TOOL_SAPPHIRE_EXCAVATOR)
                .add(ModItems.TOOL_DIAMOND_EXCAVATOR)
                .add(ModItems.TOOL_GOLD_EXCAVATOR)
                .add(ModItems.TOOL_IRON_EXCAVATOR)
                .add(ModItems.TOOL_NETHERITE_EXCAVATOR)
                .add(ModItems.TOOL_STONE_EXCAVATOR)
                .add(ModItems.TOOL_WOOD_EXCAVATOR);
        //endregion
        //region ARMOR
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ARMOR_AMETHYST_BOOTS)
                .add(ModItems.ARMOR_AMETHYST_LEGGINGS)
                .add(ModItems.ARMOR_AMETHYST_CHESTPLATE)
                .add(ModItems.ARMOR_AMETHYST_HELMET)

                .add(ModItems.ARMOR_CITRINE_BOOTS)
                .add(ModItems.ARMOR_CITRINE_LEGGINGS)
                .add(ModItems.ARMOR_CITRINE_CHESTPLATE)
                .add(ModItems.ARMOR_CITRINE_HELMET)

                .add(ModItems.ARMOR_COPPER_BOOTS)
                .add(ModItems.ARMOR_COPPER_LEGGINGS)
                .add(ModItems.ARMOR_COPPER_CHESTPLATE)
                .add(ModItems.ARMOR_COPPER_HELMET)

                .add(ModItems.ARMOR_EMERALD_BOOTS)
                .add(ModItems.ARMOR_EMERALD_LEGGINGS)
                .add(ModItems.ARMOR_EMERALD_CHESTPLATE)
                .add(ModItems.ARMOR_EMERALD_HELMET)

                .add(ModItems.ARMOR_ENDERITE_BOOTS)
                .add(ModItems.ARMOR_ENDERITE_LEGGINGS)
                .add(ModItems.ARMOR_ENDERITE_CHESTPLATE)
                .add(ModItems.ARMOR_ENDERITE_HELMET)

                .add(ModItems.ARMOR_RUBY_BOOTS)
                .add(ModItems.ARMOR_RUBY_LEGGINGS)
                .add(ModItems.ARMOR_RUBY_CHESTPLATE)
                .add(ModItems.ARMOR_RUBY_HELMET)

                .add(ModItems.ARMOR_SAPPHIRE_BOOTS)
                .add(ModItems.ARMOR_SAPPHIRE_LEGGINGS)
                .add(ModItems.ARMOR_SAPPHIRE_CHESTPLATE)
                .add(ModItems.ARMOR_SAPPHIRE_HELMET);

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItems.ARMOR_AMETHYST_HELMET)
                .add(ModItems.ARMOR_CITRINE_HELMET)
                .add(ModItems.ARMOR_COPPER_HELMET)
                .add(ModItems.ARMOR_EMERALD_HELMET)
                .add(ModItems.ARMOR_ENDERITE_HELMET)
                .add(ModItems.ARMOR_RUBY_HELMET)
                .add(ModItems.ARMOR_SAPPHIRE_HELMET);

        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR)
                .add(ModItems.ARMOR_AMETHYST_CHESTPLATE)
                .add(ModItems.ARMOR_CITRINE_CHESTPLATE)
                .add(ModItems.ARMOR_COPPER_CHESTPLATE)
                .add(ModItems.ARMOR_EMERALD_CHESTPLATE)
                .add(ModItems.ARMOR_ENDERITE_CHESTPLATE)
                .add(ModItems.ARMOR_RUBY_CHESTPLATE)
                .add(ModItems.ARMOR_SAPPHIRE_CHESTPLATE);

        getOrCreateTagBuilder(ItemTags.LEG_ARMOR)
                .add(ModItems.ARMOR_AMETHYST_LEGGINGS)
                .add(ModItems.ARMOR_CITRINE_LEGGINGS)
                .add(ModItems.ARMOR_COPPER_LEGGINGS)
                .add(ModItems.ARMOR_EMERALD_LEGGINGS)
                .add(ModItems.ARMOR_ENDERITE_LEGGINGS)
                .add(ModItems.ARMOR_RUBY_LEGGINGS)
                .add(ModItems.ARMOR_SAPPHIRE_LEGGINGS);

        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItems.ARMOR_AMETHYST_BOOTS)
                .add(ModItems.ARMOR_CITRINE_BOOTS)
                .add(ModItems.ARMOR_COPPER_BOOTS)
                .add(ModItems.ARMOR_EMERALD_BOOTS)
                .add(ModItems.ARMOR_ENDERITE_BOOTS)
                .add(ModItems.ARMOR_RUBY_BOOTS)
                .add(ModItems.ARMOR_SAPPHIRE_BOOTS);
        //endregion
        //region ORE
        getOrCreateTagBuilder(ItemTags.COPPER_ORES)
                .add(ModBlocks.ORE_NETHER_COPPER.asItem());

        getOrCreateTagBuilder(ItemTags.REDSTONE_ORES)
                .add(ModBlocks.ORE_NETHER_REDSTONE.asItem());

        getOrCreateTagBuilder(ItemTags.LAPIS_ORES)
                .add(ModBlocks.ORE_NETHER_LAPIS.asItem());

        getOrCreateTagBuilder(ItemTags.IRON_ORES)
                .add(ModBlocks.ORE_NETHER_IRON.asItem());

        getOrCreateTagBuilder(ItemTags.DIAMOND_ORES)
                .add(ModBlocks.ORE_NETHER_DIAMOND.asItem());

        getOrCreateTagBuilder(ItemTags.COAL_ORES)
                .add(ModBlocks.ORE_NETHER_COAL.asItem());

        getOrCreateTagBuilder(ItemTags.GOLD_ORES);

        getOrCreateTagBuilder(ItemTags.EMERALD_ORES);
        //endregion
        //region INGREDIENTS
        getOrCreateTagBuilder(Tags.Item.CAST)
                .add(ModItems.CAST_AXE)
                .add(ModItems.CAST_BINDING)
                .add(ModItems.CAST_EXCAVATOR)
                .add(ModItems.CAST_GEAR)
                .add(ModItems.CAST_GEM)
                .add(ModItems.CAST_HAMMER)
                .add(ModItems.CAST_HANDLE)
                .add(ModItems.CAST_HOE)
                .add(ModItems.CAST_INGOT)
                .add(ModItems.CAST_NUGGET)
                .add(ModItems.CAST_PICKAXE)
                .add(ModItems.CAST_PLATE)
                .add(ModItems.CAST_ROD)
                .add(ModItems.CAST_SHOVEL)
                .add(ModItems.CAST_SWORD)
                .add(ModItems.CAST_WIRE);

        getOrCreateTagBuilder(Tags.Item.RAW)
                .add(ModItems.RAW_CITRINE)
                .add(ModItems.RAW_ENDERITE)
                .add(ModItems.RAW_QUARTZ)
                .add(ModItems.RAW_RUBY)
                .add(ModItems.RAW_SAPPHIRE);

        getOrCreateTagBuilder(Tags.Item.WOOD_CAST)
                .add(ModItems.CAST_WOOD_INGOT)
                .add(ModItems.CAST_WOOD_PICKAXE);

        getOrCreateTagBuilder(Tags.Item.GEAR)
                .add(ModItems.GEAR_COPPER)
                .add(ModItems.GEAR_DIAMOND)
                .add(ModItems.GEAR_EMERALD)
                .add(ModItems.GEAR_ENDERITE)
                .add(ModItems.GEAR_ENERGIZED)
                .add(ModItems.GEAR_GOLD)
                .add(ModItems.GEAR_IRON)
                .add(ModItems.GEAR_LAPIS)
                .add(ModItems.GEAR_NETHERITE)
                .add(ModItems.GEAR_OBSIDIAN)
                .add(ModItems.GEAR_PRISMARINE)
                .add(ModItems.GEAR_QUARTZ)
                .add(ModItems.GEAR_RUBY)
                .add(ModItems.GEAR_SAPPHIRE)
                .add(ModItems.GEAR_SHULKER)
                .add(ModItems.GEAR_STONE)
                .add(ModItems.GEAR_VIBRANT)
                .add(ModItems.GEAR_WOOD);

        getOrCreateTagBuilder(Tags.Item.GEM)
                .add(ModItems.GEM_CITRINE)
                .add(ModItems.GEM_RUBY)
                .add(ModItems.GEM_SAPPHIRE)
                .add(Items.DIAMOND)
                .add(Items.EMERALD);

        getOrCreateTagBuilder(Tags.Item.DUST)
                .add(ModItems.CRUSHED_SHULKER)
                .add(ModItems.DUST_CONDUCTIVE)
                .add(ModItems.DUST_COPPER)
                .add(ModItems.DUST_ENDERITE)
                .add(ModItems.DUST_ENERGETIC)
                .add(ModItems.DUST_GOLD)
                .add(ModItems.DUST_IRON)
                .add(ModItems.DUST_OBSIDIAN)
                .add(ModItems.DUST_PULSATING)
                .add(ModItems.DUST_RED_ALLOY)
                .add(ModItems.DUST_SOUL)
                .add(ModItems.DUST_VIBRANT)
                .add(ModItems.DUST_WITHERING);

        getOrCreateTagBuilder(Tags.Item.INGOT)
                .add(ModItems.INGOT_ALLOY_CONDUCTIVE)
                .add(ModItems.INGOT_ALLOY_ENERGETIC)
                .add(ModItems.INGOT_ALLOY_PULSATING)
                .add(ModItems.INGOT_ALLOY_RED)
                .add(ModItems.INGOT_ALLOY_VIBRANT)
                .add(ModItems.RAW_ALLOY_ENDERITE)
                .add(ModItems.INGOT_ALLOY_ENDERITE)
                .add(ModItems.INGOT_ENDERITE);

        getOrCreateTagBuilder(Tags.Item.ALLOY)
                .add(ModItems.INGOT_ALLOY_CONDUCTIVE)
                .add(ModItems.INGOT_ALLOY_ENERGETIC)
                .add(ModItems.INGOT_ALLOY_PULSATING)
                .add(ModItems.INGOT_ALLOY_RED)
                .add(ModItems.INGOT_ALLOY_VIBRANT);

        getOrCreateTagBuilder(Tags.Item.PLATE)
                .add(ModItems.PLATE_AMETHYST)
                .add(ModItems.PLATE_CITRINE)
                .add(ModItems.PLATE_COPPER)
                .add(ModItems.PLATE_DIAMOND)
                .add(ModItems.PLATE_EMERALD)
                .add(ModItems.PLATE_ENDERITE)
                .add(ModItems.PLATE_GOLD)
                .add(ModItems.PLATE_IRON)
                .add(ModItems.PLATE_NETHERITE)
                .add(ModItems.PLATE_RUBY)
                .add(ModItems.PLATE_SAPPHIRE)
                .add(ModItems.PLATE_SHULKER)
                .add(ModItems.PLATE_STONE);

        getOrCreateTagBuilder(Tags.Item.REINFORCED)
                .add(ModItems.REINFORCED_AMETHYST)
                .add(ModItems.REINFORCED_CITRINE)
                .add(ModItems.REINFORCED_COPPER)
                .add(ModItems.REINFORCED_DIAMOND)
                .add(ModItems.REINFORCED_EMERALD)
                .add(ModItems.REINFORCED_ENDERITE)
                .add(ModItems.REINFORCED_GOLD)
                .add(ModItems.REINFORCED_IRON)
                .add(ModItems.REINFORCED_NETHERITE)
                .add(ModItems.REINFORCED_RUBY)
                .add(ModItems.REINFORCED_SAPPHIRE)
                .add(ModItems.REINFORCED_SHULKER);

        getOrCreateTagBuilder(Tags.Item.ROD)
                .add(ModItems.ROD_COPPER)
                .add(ModItems.ROD_ENDERITE)
                .add(ModItems.ROD_GLOWSTONE)
                .add(ModItems.ROD_GOLD)
                .add(ModItems.ROD_IRON)
                .add(ModItems.ROD_OBSIDIAN)
                .add(ModItems.ROD_REDSTONE)
                .add(ModItems.ROD_SHULKER);

        getOrCreateTagBuilder(Tags.Item.TOOL_HEAD)
                .add(ModItems.HEAD_CITRINE_AXE)
                .add(ModItems.HEAD_CITRINE_HAMMER)
                .add(ModItems.HEAD_CITRINE_HOE)
                .add(ModItems.HEAD_CITRINE_PICKAXE)
                .add(ModItems.HEAD_CITRINE_SHOVEL)
                .add(ModItems.HEAD_CITRINE_SWORD)
                .add(ModItems.HEAD_COPPER_AXE)
                .add(ModItems.HEAD_COPPER_HAMMER)
                .add(ModItems.HEAD_COPPER_HOE)
                .add(ModItems.HEAD_COPPER_PICKAXE)
                .add(ModItems.HEAD_COPPER_SHOVEL)
                .add(ModItems.HEAD_COPPER_SWORD)
                .add(ModItems.HEAD_DIAMOND_AXE)
                .add(ModItems.HEAD_DIAMOND_HAMMER)
                .add(ModItems.HEAD_DIAMOND_HOE)
                .add(ModItems.HEAD_DIAMOND_PICKAXE)
                .add(ModItems.HEAD_DIAMOND_SHOVEL)
                .add(ModItems.HEAD_DIAMOND_SWORD)
                .add(ModItems.HEAD_ENDERITE_AXE)
                .add(ModItems.HEAD_ENDERITE_HAMMER)
                .add(ModItems.HEAD_ENDERITE_HOE)
                .add(ModItems.HEAD_ENDERITE_PICKAXE)
                .add(ModItems.HEAD_ENDERITE_SHOVEL)
                .add(ModItems.HEAD_ENDERITE_SWORD)
                .add(ModItems.HEAD_GOLD_AXE)
                .add(ModItems.HEAD_GOLD_HAMMER)
                .add(ModItems.HEAD_GOLD_HOE)
                .add(ModItems.HEAD_GOLD_PICKAXE)
                .add(ModItems.HEAD_GOLD_SHOVEL)
                .add(ModItems.HEAD_GOLD_SWORD)
                .add(ModItems.HEAD_IRON_AXE)
                .add(ModItems.HEAD_IRON_HAMMER)
                .add(ModItems.HEAD_IRON_HOE)
                .add(ModItems.HEAD_IRON_PICKAXE)
                .add(ModItems.HEAD_IRON_SHOVEL)
                .add(ModItems.HEAD_IRON_SWORD)
                .add(ModItems.HEAD_NETHERITE_AXE)
                .add(ModItems.HEAD_NETHERITE_HAMMER)
                .add(ModItems.HEAD_NETHERITE_HOE)
                .add(ModItems.HEAD_NETHERITE_PICKAXE)
                .add(ModItems.HEAD_NETHERITE_SHOVEL)
                .add(ModItems.HEAD_NETHERITE_SWORD)
                .add(ModItems.HEAD_RUBY_AXE)
                .add(ModItems.HEAD_RUBY_HAMMER)
                .add(ModItems.HEAD_RUBY_HOE)
                .add(ModItems.HEAD_RUBY_PICKAXE)
                .add(ModItems.HEAD_RUBY_SHOVEL)
                .add(ModItems.HEAD_RUBY_SWORD)
                .add(ModItems.HEAD_SAPPHIRE_AXE)
                .add(ModItems.HEAD_SAPPHIRE_HAMMER)
                .add(ModItems.HEAD_SAPPHIRE_HOE)
                .add(ModItems.HEAD_SAPPHIRE_PICKAXE)
                .add(ModItems.HEAD_SAPPHIRE_SHOVEL)
                .add(ModItems.HEAD_SAPPHIRE_SWORD)
                .add(ModItems.HEAD_STONE_HAMMER)
                .add(ModItems.HEAD_WOOD_HAMMER);
        //endregion
        //region MENDING WHITELIST
        getOrCreateTagBuilder(Tags.Item.MENDING_ONLY)
                .add(ModItems.TOOL_CITRINE_AXE)
                .add(ModItems.TOOL_COPPER_AXE)
                .add(ModItems.TOOL_ENDERITE_AXE)
                .add(ModItems.TOOL_RUBY_AXE)
                .add(ModItems.TOOL_SAPPHIRE_AXE)
                .add(ModItems.TOOL_CITRINE_HOE)
                .add(ModItems.TOOL_COPPER_HOE)
                .add(ModItems.TOOL_ENDERITE_HOE)
                .add(ModItems.TOOL_RUBY_HOE)
                .add(ModItems.TOOL_SAPPHIRE_HOE)
                .add(ModItems.TOOL_CITRINE_HAMMER)
                .add(ModItems.TOOL_COPPER_HAMMER)
                .add(ModItems.TOOL_DIAMOND_HAMMER)
                .add(ModItems.TOOL_ENDERITE_HAMMER)
                .add(ModItems.TOOL_GOLD_HAMMER)
                .add(ModItems.TOOL_IRON_HAMMER)
                .add(ModItems.TOOL_NETHERITE_HAMMER)
                .add(ModItems.TOOL_RUBY_HAMMER)
                .add(ModItems.TOOL_SAPPHIRE_HAMMER)
                .add(ModItems.TOOL_STONE_HAMMER)
                .add(ModItems.TOOL_WOOD_HAMMER)
                .add(ModItems.TOOL_CITRINE_PICKAXE)
                .add(ModItems.TOOL_COPPER_PICKAXE)
                .add(ModItems.TOOL_ENDERITE_PICKAXE)
                .add(ModItems.TOOL_RUBY_PICKAXE)
                .add(ModItems.TOOL_SAPPHIRE_PICKAXE)
                .add(ModItems.TOOL_CITRINE_SHOVEL)
                .add(ModItems.TOOL_COPPER_SHOVEL)
                .add(ModItems.TOOL_ENDERITE_SHOVEL)
                .add(ModItems.TOOL_RUBY_SHOVEL)
                .add(ModItems.TOOL_SAPPHIRE_SHOVEL)
                .add(ModItems.TOOL_CITRINE_SWORD)
                .add(ModItems.TOOL_COPPER_SWORD)
                .add(ModItems.TOOL_ENDERITE_SWORD)
                .add(ModItems.TOOL_RUBY_SWORD)
                .add(ModItems.TOOL_SAPPHIRE_SWORD)
                .add(ModItems.ARMOR_AMETHYST_HELMET)
                .add(ModItems.ARMOR_AMETHYST_CHESTPLATE)
                .add(ModItems.ARMOR_AMETHYST_LEGGINGS)
                .add(ModItems.ARMOR_AMETHYST_BOOTS)
                .add(ModItems.ARMOR_CITRINE_HELMET)
                .add(ModItems.ARMOR_CITRINE_CHESTPLATE)
                .add(ModItems.ARMOR_CITRINE_LEGGINGS)
                .add(ModItems.ARMOR_CITRINE_BOOTS)
                .add(ModItems.ARMOR_COPPER_HELMET)
                .add(ModItems.ARMOR_COPPER_CHESTPLATE)
                .add(ModItems.ARMOR_COPPER_LEGGINGS)
                .add(ModItems.ARMOR_COPPER_BOOTS)
                .add(ModItems.ARMOR_EMERALD_HELMET)
                .add(ModItems.ARMOR_EMERALD_CHESTPLATE)
                .add(ModItems.ARMOR_EMERALD_LEGGINGS)
                .add(ModItems.ARMOR_EMERALD_BOOTS)
                .add(ModItems.ARMOR_ENDERITE_HELMET)
                .add(ModItems.ARMOR_ENDERITE_CHESTPLATE)
                .add(ModItems.ARMOR_ENDERITE_LEGGINGS)
                .add(ModItems.ARMOR_ENDERITE_BOOTS)
                .add(ModItems.ARMOR_RUBY_HELMET)
                .add(ModItems.ARMOR_RUBY_CHESTPLATE)
                .add(ModItems.ARMOR_RUBY_LEGGINGS)
                .add(ModItems.ARMOR_RUBY_BOOTS)
                .add(ModItems.ARMOR_SAPPHIRE_HELMET)
                .add(ModItems.ARMOR_SAPPHIRE_CHESTPLATE)
                .add(ModItems.ARMOR_SAPPHIRE_LEGGINGS)
                .add(ModItems.ARMOR_SAPPHIRE_BOOTS);
        //endregion
        //region SMELTERY
        getOrCreateTagBuilder(Tags.Item.SMELTABLE)
                .add(ModItems.GEM_CITRINE)
                .add(ModItems.GEM_RUBY)
                .add(ModItems.GEM_SAPPHIRE)
                .add(Items.DIAMOND)
                .add(Items.EMERALD)
                .add(Items.PRISMARINE_SHARD)
                .add(Items.AMETHYST_SHARD)
                .add(Items.COPPER_INGOT)
                .add(ModItems.INGOT_ALLOY_ENDERITE)
                .add(Items.GLOWSTONE)
                .add(Items.GOLD_INGOT)
                .add(Items.IRON_INGOT)
                .add(Items.LAPIS_LAZULI)
                .add(Items.NETHERITE_INGOT)
                .add(Items.OBSIDIAN)
                .add(Items.QUARTZ)
                .add(ModBlocks.ORE_NETHER_COAL.asItem())
                .add(ModBlocks.ORE_NETHER_IRON.asItem())
                .add(ModBlocks.ORE_NETHER_LAPIS.asItem())
                .add(ModBlocks.ORE_NETHER_REDSTONE.asItem())
                .add(ModBlocks.ORE_NETHER_COPPER.asItem())
                .add(ModBlocks.ORE_NETHER_DIAMOND.asItem())
                .add(Items.RAW_COPPER)
                .add(Items.RAW_IRON)
                .add(Items.RAW_GOLD);
        //endregion

        getOrCreateTagBuilder(ItemTags.STONE_CRAFTING_MATERIALS);
        getOrCreateTagBuilder(ItemTags.STONE_TOOL_MATERIALS);

        getOrCreateTagBuilder(Tags.Item.FLUID_BUCKET)
                .add(Items.LAVA_BUCKET)
                .add(Items.WATER_BUCKET)
                .add(Items.MILK_BUCKET)
                .add(Items.BUCKET);

        getOrCreateTagBuilder(Tags.Item.REPAIRS_AMETHYST_ARMOR)
                .add(ModItems.REINFORCED_AMETHYST);
        getOrCreateTagBuilder(Tags.Item.REPAIRS_CITRINE_ARMOR)
                .add(ModItems.REINFORCED_CITRINE);
        getOrCreateTagBuilder(Tags.Item.REPAIRS_COPPER_ARMOR)
                .add(ModItems.REINFORCED_COPPER);
        getOrCreateTagBuilder(Tags.Item.REPAIRS_EMERALD_ARMOR)
                .add(ModItems.REINFORCED_EMERALD);
        getOrCreateTagBuilder(Tags.Item.REPAIRS_ENDERITE_ARMOR)
                .add(ModItems.REINFORCED_ENDERITE);
        getOrCreateTagBuilder(Tags.Item.REPAIRS_RUBY_ARMOR)
                .add(ModItems.REINFORCED_RUBY);
        getOrCreateTagBuilder(Tags.Item.REPAIRS_SAPPHIRE_ARMOR)
                .add(ModItems.REINFORCED_SAPPHIRE);
        getOrCreateTagBuilder(Tags.Item.REPAIRS_CITRINE_TOOL)
                .add(ModItems.PLATE_CITRINE);
        getOrCreateTagBuilder(Tags.Item.REPAIRS_COPPER_TOOL)
                .add(ModItems.PLATE_COPPER);
        getOrCreateTagBuilder(Tags.Item.REPAIRS_ENDERITE_TOOL)
                .add(ModItems.PLATE_ENDERITE);
        getOrCreateTagBuilder(Tags.Item.REPAIRS_RUBY_TOOL)
                .add(ModItems.PLATE_RUBY);
        getOrCreateTagBuilder(Tags.Item.REPAIRS_SAPPHIRE_TOOL)
                .add(ModItems.PLATE_SAPPHIRE);

        getOrCreateTagBuilder(Tags.Item.AMETHYST_ARMOR_TYPE)
                .add(ModItems.ARMOR_AMETHYST_HELMET)
                .add(ModItems.ARMOR_AMETHYST_CHESTPLATE)
                .add(ModItems.ARMOR_AMETHYST_LEGGINGS)
                .add(ModItems.ARMOR_AMETHYST_BOOTS);
        getOrCreateTagBuilder(Tags.Item.CITRINE_ARMOR_TYPE)
                .add(ModItems.ARMOR_CITRINE_HELMET)
                .add(ModItems.ARMOR_CITRINE_CHESTPLATE)
                .add(ModItems.ARMOR_CITRINE_LEGGINGS)
                .add(ModItems.ARMOR_CITRINE_BOOTS);
        getOrCreateTagBuilder(Tags.Item.COPPER_ARMOR_TYPE)
                .add(ModItems.ARMOR_COPPER_HELMET)
                .add(ModItems.ARMOR_COPPER_CHESTPLATE)
                .add(ModItems.ARMOR_COPPER_LEGGINGS)
                .add(ModItems.ARMOR_COPPER_BOOTS);
        getOrCreateTagBuilder(Tags.Item.EMERALD_ARMOR_TYPE)
                .add(ModItems.ARMOR_EMERALD_HELMET)
                .add(ModItems.ARMOR_EMERALD_CHESTPLATE)
                .add(ModItems.ARMOR_EMERALD_LEGGINGS)
                .add(ModItems.ARMOR_EMERALD_BOOTS);
        getOrCreateTagBuilder(Tags.Item.ENDERITE_ARMOR_TYPE)
                .add(ModItems.ARMOR_ENDERITE_HELMET)
                .add(ModItems.ARMOR_ENDERITE_CHESTPLATE)
                .add(ModItems.ARMOR_ENDERITE_LEGGINGS)
                .add(ModItems.ARMOR_ENDERITE_BOOTS);
        getOrCreateTagBuilder(Tags.Item.RUBY_ARMOR_TYPE)
                .add(ModItems.ARMOR_RUBY_HELMET)
                .add(ModItems.ARMOR_RUBY_CHESTPLATE)
                .add(ModItems.ARMOR_RUBY_LEGGINGS)
                .add(ModItems.ARMOR_RUBY_BOOTS);
        getOrCreateTagBuilder(Tags.Item.SAPPHIRE_ARMOR_TYPE)
                .add(ModItems.ARMOR_SAPPHIRE_HELMET)
                .add(ModItems.ARMOR_SAPPHIRE_CHESTPLATE)
                .add(ModItems.ARMOR_SAPPHIRE_LEGGINGS)
                .add(ModItems.ARMOR_SAPPHIRE_BOOTS);

        getOrCreateTagBuilder(ItemTags.EQUIPPABLE_ENCHANTABLE);

        getOrCreateTagBuilder(ItemTags.ARMOR_ENCHANTABLE);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE);
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE);

        getOrCreateTagBuilder(ItemTags.FISHING_ENCHANTABLE);
        getOrCreateTagBuilder(ItemTags.BOW_ENCHANTABLE);
        getOrCreateTagBuilder(ItemTags.CROSSBOW_ENCHANTABLE);
        getOrCreateTagBuilder(ItemTags.MACE_ENCHANTABLE);
        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE);
        getOrCreateTagBuilder(ItemTags.TRIDENT_ENCHANTABLE);
        getOrCreateTagBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE);
        getOrCreateTagBuilder(ItemTags.WEAPON_ENCHANTABLE);

        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.ARMOR_AMETHYST_HELMET)
                .add(ModItems.ARMOR_AMETHYST_CHESTPLATE)
                .add(ModItems.ARMOR_AMETHYST_LEGGINGS)
                .add(ModItems.ARMOR_AMETHYST_BOOTS)
                .add(ModItems.ARMOR_CITRINE_HELMET)
                .add(ModItems.ARMOR_CITRINE_CHESTPLATE)
                .add(ModItems.ARMOR_CITRINE_LEGGINGS)
                .add(ModItems.ARMOR_CITRINE_BOOTS)
                .add(ModItems.ARMOR_COPPER_HELMET)
                .add(ModItems.ARMOR_COPPER_CHESTPLATE)
                .add(ModItems.ARMOR_COPPER_LEGGINGS)
                .add(ModItems.ARMOR_COPPER_BOOTS)
                .add(ModItems.ARMOR_EMERALD_HELMET)
                .add(ModItems.ARMOR_EMERALD_CHESTPLATE)
                .add(ModItems.ARMOR_EMERALD_LEGGINGS)
                .add(ModItems.ARMOR_EMERALD_BOOTS)
                .add(ModItems.ARMOR_ENDERITE_HELMET)
                .add(ModItems.ARMOR_ENDERITE_CHESTPLATE)
                .add(ModItems.ARMOR_ENDERITE_LEGGINGS)
                .add(ModItems.ARMOR_ENDERITE_BOOTS)
                .add(ModItems.ARMOR_RUBY_HELMET)
                .add(ModItems.ARMOR_RUBY_CHESTPLATE)
                .add(ModItems.ARMOR_RUBY_LEGGINGS)
                .add(ModItems.ARMOR_RUBY_BOOTS)
                .add(ModItems.ARMOR_SAPPHIRE_HELMET)
                .add(ModItems.ARMOR_SAPPHIRE_CHESTPLATE)
                .add(ModItems.ARMOR_SAPPHIRE_LEGGINGS)
                .add(ModItems.ARMOR_SAPPHIRE_BOOTS)
                .add(ModItems.TOOL_CITRINE_AXE)
                .add(ModItems.TOOL_CITRINE_EXCAVATOR)
                .add(ModItems.TOOL_CITRINE_HAMMER)
                .add(ModItems.TOOL_CITRINE_HOE)
                .add(ModItems.TOOL_CITRINE_PICKAXE)
                .add(ModItems.TOOL_CITRINE_SHOVEL)
                .add(ModItems.TOOL_CITRINE_SWORD)
                .add(ModItems.TOOL_COPPER_AXE)
                .add(ModItems.TOOL_COPPER_EXCAVATOR)
                .add(ModItems.TOOL_COPPER_HAMMER)
                .add(ModItems.TOOL_COPPER_HOE)
                .add(ModItems.TOOL_COPPER_PICKAXE)
                .add(ModItems.TOOL_COPPER_SHOVEL)
                .add(ModItems.TOOL_COPPER_SWORD)
                .add(ModItems.TOOL_ENDERITE_AXE)
                .add(ModItems.TOOL_ENDERITE_EXCAVATOR)
                .add(ModItems.TOOL_ENDERITE_HAMMER)
                .add(ModItems.TOOL_ENDERITE_HOE)
                .add(ModItems.TOOL_ENDERITE_PICKAXE)
                .add(ModItems.TOOL_ENDERITE_SHOVEL)
                .add(ModItems.TOOL_ENDERITE_SWORD)
                .add(ModItems.TOOL_RUBY_AXE)
                .add(ModItems.TOOL_RUBY_EXCAVATOR)
                .add(ModItems.TOOL_RUBY_HAMMER)
                .add(ModItems.TOOL_RUBY_HOE)
                .add(ModItems.TOOL_RUBY_PICKAXE)
                .add(ModItems.TOOL_RUBY_SHOVEL)
                .add(ModItems.TOOL_RUBY_SWORD)
                .add(ModItems.TOOL_SAPPHIRE_AXE)
                .add(ModItems.TOOL_SAPPHIRE_EXCAVATOR)
                .add(ModItems.TOOL_SAPPHIRE_HAMMER)
                .add(ModItems.TOOL_SAPPHIRE_HOE)
                .add(ModItems.TOOL_SAPPHIRE_PICKAXE)
                .add(ModItems.TOOL_SAPPHIRE_SHOVEL)
                .add(ModItems.TOOL_SAPPHIRE_SWORD)
                .add(ModItems.TOOL_DIAMOND_EXCAVATOR)
                .add(ModItems.TOOL_DIAMOND_HAMMER)
                .add(ModItems.TOOL_GOLD_EXCAVATOR)
                .add(ModItems.TOOL_GOLD_HAMMER)
                .add(ModItems.TOOL_IRON_EXCAVATOR)
                .add(ModItems.TOOL_IRON_HAMMER)
                .add(ModItems.TOOL_NETHERITE_EXCAVATOR)
                .add(ModItems.TOOL_NETHERITE_HAMMER)
                .add(ModItems.TOOL_STONE_EXCAVATOR)
                .add(ModItems.TOOL_STONE_HAMMER)
                .add(ModItems.TOOL_WOOD_EXCAVATOR)
                .add(ModItems.TOOL_WOOD_HAMMER);

        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE);
        getOrCreateTagBuilder(ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(ModItems.TOOL_CITRINE_EXCAVATOR)
                .add(ModItems.TOOL_CITRINE_HAMMER)
                .add(ModItems.TOOL_CITRINE_PICKAXE)
                .add(ModItems.TOOL_CITRINE_SHOVEL)
                .add(ModItems.TOOL_COPPER_EXCAVATOR)
                .add(ModItems.TOOL_COPPER_HAMMER)
                .add(ModItems.TOOL_COPPER_PICKAXE)
                .add(ModItems.TOOL_COPPER_SHOVEL)
                .add(ModItems.TOOL_ENDERITE_EXCAVATOR)
                .add(ModItems.TOOL_ENDERITE_HAMMER)
                .add(ModItems.TOOL_ENDERITE_PICKAXE)
                .add(ModItems.TOOL_ENDERITE_SHOVEL)
                .add(ModItems.TOOL_RUBY_EXCAVATOR)
                .add(ModItems.TOOL_RUBY_HAMMER)
                .add(ModItems.TOOL_RUBY_PICKAXE)
                .add(ModItems.TOOL_RUBY_SHOVEL)
                .add(ModItems.TOOL_SAPPHIRE_EXCAVATOR)
                .add(ModItems.TOOL_SAPPHIRE_HAMMER)
                .add(ModItems.TOOL_SAPPHIRE_PICKAXE)
                .add(ModItems.TOOL_SAPPHIRE_SHOVEL)
                .add(ModItems.TOOL_DIAMOND_EXCAVATOR)
                .add(ModItems.TOOL_DIAMOND_HAMMER)
                .add(ModItems.TOOL_GOLD_EXCAVATOR)
                .add(ModItems.TOOL_GOLD_HAMMER)
                .add(ModItems.TOOL_IRON_EXCAVATOR)
                .add(ModItems.TOOL_IRON_HAMMER)
                .add(ModItems.TOOL_NETHERITE_EXCAVATOR)
                .add(ModItems.TOOL_NETHERITE_HAMMER)
                .add(ModItems.TOOL_STONE_EXCAVATOR)
                .add(ModItems.TOOL_STONE_HAMMER)
                .add(ModItems.TOOL_WOOD_EXCAVATOR)
                .add(ModItems.TOOL_WOOD_HAMMER);

        getOrCreateTagBuilder(ItemTags.FIRE_ASPECT_ENCHANTABLE);
        getOrCreateTagBuilder(ItemTags.VANISHING_ENCHANTABLE);
    }
}