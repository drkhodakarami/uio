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

import jiraiyah.uio.Configs;
import jiraiyah.uio.item.*;
import jiraiyah.uio.item.blockitem.AngelBlockItem;
import jiraiyah.uio.registry.misc.ModArmorMaterials;
import jiraiyah.uio.registry.misc.ModToolMaterials;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;

import java.util.ArrayList;
import java.util.List;

import static jiraiyah.uio.Reference.*;
import static jiraiyah.uio.util.Registers.Items.*;

// Some of the textures are from : https://github/malcolmriley/unused-textures
public class ModItems
{
    ModItems()
    {
        throw new AssertionError();
    }

    public static List<Item> AllItems = new ArrayList<>();
    public static final List<Item> BLACK_LIST = new ArrayList<>();

    public static Item BINDING_STRING, UNSTABLE_GOO, COMBUSTION_CORE;
    public static Item RAW_RUBBER;
    public static Item RUBBER;
    public static Item VOID_PLATE_BASE, VOID_PLATE_ACTIVATOR, VOID_PLATE;
    public static Item ENDER_CHARM, ENDERMAN_EYE, ENDERMAN_HEART, ENDERMAN_GLAND;
    public static Item ITEM_FILTER, CHALICE, CHALICE_EMPTY;
    public static Item SLOT_DISABLED, SLOT_ENABLED;
    public static Item COOKED_EGG, EGG_AND_BREAD;
    public static Item HOT_COAL;
    public static Item THERMAL_CORE;
    public static Item GEM_CITRINE, GEM_RUBY, GEM_SAPPHIRE;
    public static Item CAST_AXE, CAST_BINDING, CAST_EXCAVATOR, CAST_GEAR, CAST_GEM, CAST_HAMMER, CAST_HANDLE, CAST_HOE, CAST_INGOT, CAST_NUGGET,
                       CAST_PICKAXE, CAST_PLATE, CAST_ROD, CAST_SHOVEL, CAST_SWORD, CAST_WIRE, CAST_WOOD_INGOT, CAST_WOOD_PICKAXE;
    public static Item RAW_CITRINE, RAW_ENDERITE, RAW_QUARTZ, RAW_RUBY, RAW_SAPPHIRE;
    public static Item CRUSHED_SHULKER, DUST_CONDUCTIVE, DUST_COPPER, DUST_ENDERITE, DUST_ENERGETIC, DUST_GOLD, DUST_IRON, DUST_OBSIDIAN,
                       DUST_PULSATING, DUST_RED_ALLOY, DUST_SOUL, DUST_VIBRANT, DUST_WITHERING;
    public static Item GEAR_COPPER, GEAR_DIAMOND, GEAR_EMERALD, GEAR_ENDERITE, GEAR_ENERGIZED, GEAR_GOLD, GEAR_IRON, GEAR_LAPIS,
                       GEAR_NETHERITE, GEAR_OBSIDIAN, GEAR_PRISMARINE, GEAR_QUARTZ, GEAR_RUBY, GEAR_SAPPHIRE, GEAR_SHULKER, GEAR_STONE,
                       GEAR_VIBRANT, GEAR_WOOD;
    public static Item INGOT_ALLOY_CONDUCTIVE, INGOT_ALLOY_ENERGETIC, INGOT_ALLOY_PULSATING, INGOT_ALLOY_RED, INGOT_ALLOY_VIBRANT,
                       INGOT_ALLOY_ENDERITE, RAW_ALLOY_ENDERITE, INGOT_ENDERITE;
    public static Item PLATE_AMETHYST, PLATE_CITRINE, PLATE_COPPER, PLATE_DIAMOND, PLATE_EMERALD, PLATE_ENDERITE,PLATE_GOLD,
                       PLATE_IRON, PLATE_NETHERITE, PLATE_RUBY, PLATE_SAPPHIRE, PLATE_SHULKER, PLATE_STONE;
    public static Item REINFORCED_AMETHYST, REINFORCED_CITRINE, REINFORCED_COPPER, REINFORCED_DIAMOND, REINFORCED_EMERALD, REINFORCED_ENDERITE,
                       REINFORCED_GOLD, REINFORCED_IRON, REINFORCED_NETHERITE, REINFORCED_RUBY, REINFORCED_SAPPHIRE,REINFORCED_SHULKER;
    public static Item ROD_COPPER, ROD_ENDERITE, ROD_GLOWSTONE, ROD_GOLD, ROD_IRON, ROD_OBSIDIAN, ROD_REDSTONE, ROD_SHULKER;
    public static Item HEAD_CITRINE_AXE, HEAD_CITRINE_EXCAVATOR, HEAD_CITRINE_HAMMER, HEAD_CITRINE_HOE, HEAD_CITRINE_PICKAXE, HEAD_CITRINE_SHOVEL, HEAD_CITRINE_SWORD,
                       HEAD_COPPER_AXE, HEAD_COPPER_EXCAVATOR, HEAD_COPPER_HAMMER, HEAD_COPPER_HOE, HEAD_COPPER_PICKAXE, HEAD_COPPER_SHOVEL, HEAD_COPPER_SWORD,
                       HEAD_DIAMOND_AXE, HEAD_DIAMOND_EXCAVATOR, HEAD_DIAMOND_HAMMER, HEAD_DIAMOND_HOE, HEAD_DIAMOND_PICKAXE, HEAD_DIAMOND_SHOVEL, HEAD_DIAMOND_SWORD,
                       HEAD_ENDERITE_AXE, HEAD_ENDERITE_EXCAVATOR, HEAD_ENDERITE_HAMMER, HEAD_ENDERITE_HOE, HEAD_ENDERITE_PICKAXE, HEAD_ENDERITE_SHOVEL, HEAD_ENDERITE_SWORD,
                       HEAD_GOLD_AXE, HEAD_GOLD_EXCAVATOR, HEAD_GOLD_HAMMER, HEAD_GOLD_HOE, HEAD_GOLD_PICKAXE, HEAD_GOLD_SHOVEL, HEAD_GOLD_SWORD,
                       HEAD_IRON_AXE, HEAD_IRON_EXCAVATOR, HEAD_IRON_HAMMER, HEAD_IRON_HOE, HEAD_IRON_PICKAXE, HEAD_IRON_SHOVEL, HEAD_IRON_SWORD,
                       HEAD_NETHERITE_AXE, HEAD_NETHERITE_EXCAVATOR, HEAD_NETHERITE_HAMMER, HEAD_NETHERITE_HOE, HEAD_NETHERITE_PICKAXE, HEAD_NETHERITE_SHOVEL, HEAD_NETHERITE_SWORD,
                       HEAD_RUBY_AXE, HEAD_RUBY_EXCAVATOR, HEAD_RUBY_HAMMER, HEAD_RUBY_HOE, HEAD_RUBY_PICKAXE, HEAD_RUBY_SHOVEL, HEAD_RUBY_SWORD,
                       HEAD_SAPPHIRE_AXE, HEAD_SAPPHIRE_EXCAVATOR, HEAD_SAPPHIRE_HAMMER, HEAD_SAPPHIRE_HOE, HEAD_SAPPHIRE_PICKAXE, HEAD_SAPPHIRE_SHOVEL, HEAD_SAPPHIRE_SWORD,
                       HEAD_STONE_HAMMER, HEAD_STONE_EXCAVATOR, HEAD_WOOD_HAMMER, HEAD_WOOD_EXCAVATOR;
    public static Item TOOL_CITRINE_AXE, TOOL_CITRINE_EXCAVATOR, TOOL_CITRINE_HAMMER, TOOL_CITRINE_HOE, TOOL_CITRINE_PICKAXE, TOOL_CITRINE_SHOVEL, TOOL_CITRINE_SWORD,
                       TOOL_COPPER_AXE, TOOL_COPPER_EXCAVATOR, TOOL_COPPER_HAMMER, TOOL_COPPER_HOE, TOOL_COPPER_PICKAXE, TOOL_COPPER_SHOVEL, TOOL_COPPER_SWORD,
                       TOOL_ENDERITE_AXE, TOOL_ENDERITE_EXCAVATOR, TOOL_ENDERITE_HAMMER, TOOL_ENDERITE_HOE, TOOL_ENDERITE_PICKAXE, TOOL_ENDERITE_SHOVEL, TOOL_ENDERITE_SWORD,
                       TOOL_RUBY_AXE, TOOL_RUBY_EXCAVATOR, TOOL_RUBY_HAMMER, TOOL_RUBY_HOE, TOOL_RUBY_PICKAXE, TOOL_RUBY_SHOVEL, TOOL_RUBY_SWORD,
                       TOOL_SAPPHIRE_AXE, TOOL_SAPPHIRE_EXCAVATOR, TOOL_SAPPHIRE_HAMMER, TOOL_SAPPHIRE_HOE, TOOL_SAPPHIRE_PICKAXE, TOOL_SAPPHIRE_SHOVEL, TOOL_SAPPHIRE_SWORD,
                       TOOL_DIAMOND_HAMMER, TOOL_DIAMOND_EXCAVATOR,
                       TOOL_GOLD_HAMMER, TOOL_GOLD_EXCAVATOR,
                       TOOL_IRON_HAMMER, TOOL_IRON_EXCAVATOR,
                       TOOL_NETHERITE_HAMMER, TOOL_NETHERITE_EXCAVATOR,
                       TOOL_STONE_HAMMER, TOOL_STONE_EXCAVATOR,
                       TOOL_WOOD_HAMMER, TOOL_WOOD_EXCAVATOR;
    public static Item BACKPACK, BLUEPRINT_EMPTY, BLUEPRINT_PRINTED, ENDER_BACKPACK, PLAYER_TELEPORT, WRENCH;

    public static TunerItem TUNER;
    public static AdvancedTuner ADVANCED_TUNER;

    public static Item ARMOR_AMETHYST_HELMET, ARMOR_AMETHYST_CHESTPLATE, ARMOR_AMETHYST_LEGGINGS, ARMOR_AMETHYST_BOOTS,
                       ARMOR_CITRINE_HELMET, ARMOR_CITRINE_CHESTPLATE, ARMOR_CITRINE_LEGGINGS, ARMOR_CITRINE_BOOTS,
                       ARMOR_COPPER_HELMET, ARMOR_COPPER_CHESTPLATE, ARMOR_COPPER_LEGGINGS,ARMOR_COPPER_BOOTS,
                       ARMOR_EMERALD_HELMET, ARMOR_EMERALD_CHESTPLATE, ARMOR_EMERALD_LEGGINGS, ARMOR_EMERALD_BOOTS,
                       ARMOR_ENDERITE_HELMET, ARMOR_ENDERITE_CHESTPLATE, ARMOR_ENDERITE_LEGGINGS, ARMOR_ENDERITE_BOOTS,
                       ARMOR_RUBY_HELMET, ARMOR_RUBY_CHESTPLATE, ARMOR_RUBY_LEGGINGS, ARMOR_RUBY_BOOTS,
                       ARMOR_SAPPHIRE_HELMET, ARMOR_SAPPHIRE_CHESTPLATE, ARMOR_SAPPHIRE_LEGGINGS, ARMOR_SAPPHIRE_BOOTS;

    public static Item ANGEL_BLOCK_ITEM;

    public static void init()
    {
        log("Registering Items");

        /*ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries ->
                                                                                {
                                                                                    entries.add(RUBBER);
                                                                                });*/

        //region FOOD FUEL MISC
        BINDING_STRING = register("binding_string", new Item.Settings().maxCount(16));
        UNSTABLE_GOO = register("unstable_goo_core");
        COMBUSTION_CORE = register("unstable_goo_base");
        RAW_RUBBER = register("raw_rubber", new Item.Settings().maxCount(16));
        RUBBER = register("rubber", new Item.Settings().maxCount(16));
        VOID_PLATE_BASE = register("void_plate_base", new Item.Settings().maxCount(1));
        VOID_PLATE_ACTIVATOR = register("void_plate_activator", new Item.Settings().maxCount(1));
        VOID_PLATE = register("void_plate", new Item.Settings().maxCount(1));
        ENDER_CHARM = register("ender_charm", new Item.Settings().maxCount(16));
        ENDERMAN_EYE = register("enderman_eye", new Item.Settings().maxCount(16));
        ENDERMAN_HEART = register("enderman_heart", new Item.Settings().maxCount(16));
        ENDERMAN_GLAND = register("enderman_gland", new Item.Settings().maxCount(16));
        ITEM_FILTER = register("item_filter", new Item.Settings().maxCount(16));
        SLOT_DISABLED = register("slot_disabled", new Item.Settings().maxCount(16));
        SLOT_ENABLED = register("slot_enabled", new Item.Settings().maxCount(16));
        COOKED_EGG = register("cooked_egg", new Item.Settings().food(new FoodComponent.Builder()
                                                                                    .nutrition(4)
                                                                                    .saturationModifier(0.55f)
                                                                                    .snack().build())
                                                                                .maxCount(16));
        EGG_AND_BREAD = register("egg_and_bread", new Item.Settings().food(new FoodComponent.Builder()
                                                                                    .nutrition(11)
                                                                                    .saturationModifier(1.2f)
                                                                                    .snack().build())
                                                                                 .maxCount(16));
        HOT_COAL = register("hot_coal");
        THERMAL_CORE = register("thermal_core");
        //endregion
        //region GEMS
        GEM_CITRINE = register("gem_citrine");
        GEM_RUBY = register("gem_ruby");
        GEM_SAPPHIRE = register("gem_sapphire");
        //endregion
        //region RAW
        RAW_CITRINE = register("raw_citrine");
        RAW_ENDERITE = register("raw_enderite");
        RAW_QUARTZ = register("raw_quartz");
        RAW_RUBY = register("raw_ruby");
        RAW_SAPPHIRE = register("raw_sapphire");
        //endregion
        //region CAST
        CAST_AXE = register("cast_axe", new Item.Settings().maxCount(1));
        CAST_BINDING = register("cast_binding", new Item.Settings().maxCount(1));
        CAST_EXCAVATOR = register("cast_excavator", new Item.Settings().maxCount(1));
        CAST_GEAR = register("cast_gear", new Item.Settings().maxCount(1));
        CAST_GEM = register("cast_gem", new Item.Settings().maxCount(1));
        CAST_HAMMER = register("cast_hammer", new Item.Settings().maxCount(1));
        CAST_HANDLE = register("cast_handle", new Item.Settings().maxCount(1));
        CAST_HOE = register("cast_hoe", new Item.Settings().maxCount(1));
        CAST_INGOT = register("cast_ingot", new Item.Settings().maxCount(1));
        CAST_NUGGET = register("cast_nugget", new Item.Settings().maxCount(1));
        CAST_PICKAXE = register("cast_pickaxe", new Item.Settings().maxCount(1));
        CAST_PLATE = register("cast_plate", new Item.Settings().maxCount(1));
        CAST_ROD = register("cast_rod", new Item.Settings().maxCount(1));
        CAST_SHOVEL = register("cast_shovel", new Item.Settings().maxCount(1));
        CAST_SWORD = register("cast_sword", new Item.Settings().maxCount(1));
        CAST_WIRE = register("cast_wire", new Item.Settings().maxCount(1));
        CAST_WOOD_INGOT = register("cast_wood_ingot", new Item.Settings().maxCount(1));
        CAST_WOOD_PICKAXE = register("cast_wood_pickaxe", new Item.Settings().maxCount(1));
        //endregion
        //region DUST
        CRUSHED_SHULKER = register("crushed_shulker_shell");
        DUST_CONDUCTIVE = register("dust_conductive");
        DUST_COPPER = register("dust_copper");
        DUST_ENDERITE = register("dust_enderite");
        DUST_ENERGETIC = register("dust_energetic");
        DUST_GOLD = register("dust_gold");
        DUST_IRON = register("dust_iron");
        DUST_OBSIDIAN = register("dust_obsidian");
        DUST_PULSATING = register("dust_pulsating");
        DUST_RED_ALLOY = register("dust_red_alloy");
        DUST_SOUL = register("dust_soul");
        DUST_VIBRANT = register("dust_vibrant");
        DUST_WITHERING = register("dust_withering");
        //endregion
        //region GEAR
        GEAR_COPPER = register("gear_copper", new Item.Settings().maxCount(16));
        GEAR_DIAMOND = register("gear_diamond", new Item.Settings().maxCount(16));
        GEAR_EMERALD = register("gear_emerald", new Item.Settings().maxCount(16));
        GEAR_ENDERITE = register("gear_enderite", new Item.Settings().maxCount(16));
        GEAR_ENERGIZED = register("gear_energized", new Item.Settings().maxCount(16));
        GEAR_GOLD = register("gear_gold", new Item.Settings().maxCount(16));
        GEAR_IRON = register("gear_iron", new Item.Settings().maxCount(16));
        GEAR_LAPIS = register("gear_lapis", new Item.Settings().maxCount(16));
        GEAR_NETHERITE = register("gear_netherite", new Item.Settings().maxCount(16));
        GEAR_OBSIDIAN = register("gear_obsidian", new Item.Settings().maxCount(16));
        GEAR_PRISMARINE = register("gear_prismarine", new Item.Settings().maxCount(16));
        GEAR_QUARTZ = register("gear_quartz", new Item.Settings().maxCount(16));
        GEAR_RUBY = register("gear_ruby", new Item.Settings().maxCount(16));
        GEAR_SAPPHIRE = register("gear_sapphire", new Item.Settings().maxCount(16));
        GEAR_SHULKER = register("gear_shulker", new Item.Settings().maxCount(16));
        GEAR_STONE = register("gear_stone", new Item.Settings().maxCount(16));
        GEAR_VIBRANT = register("gear_vibrant", new Item.Settings().maxCount(16));
        GEAR_WOOD = register("gear_wood", new Item.Settings().maxCount(16));
        //endregion
        //region INGOT - ALLOY
        INGOT_ALLOY_CONDUCTIVE = register("ingot_alloy_conductive");
        INGOT_ALLOY_ENERGETIC = register("ingot_alloy_energetic");
        INGOT_ALLOY_PULSATING = register("ingot_alloy_pulsating");
        INGOT_ALLOY_RED = register("ingot_alloy_red");
        INGOT_ALLOY_VIBRANT = register("ingot_alloy_vibrant");
        INGOT_ALLOY_ENDERITE = register("ingot_alloy_enderite");
        
        RAW_ALLOY_ENDERITE = register("raw_alloy_enderite");

        INGOT_ENDERITE = register("ingot_enderite");
        //endregion
        //region PLATE
        PLATE_AMETHYST = register("plate_amethyst");
        PLATE_CITRINE = register("plate_citrine");
        PLATE_COPPER = register("plate_copper");
        PLATE_DIAMOND = register("plate_diamond");
        PLATE_EMERALD = register("plate_emerald");
        PLATE_ENDERITE = register("plate_enderite");
        PLATE_GOLD = register("plate_gold");
        PLATE_IRON = register("plate_iron");
        PLATE_NETHERITE = register("plate_netherite");
        PLATE_RUBY = register("plate_ruby");
        PLATE_SAPPHIRE = register("plate_sapphire");
        PLATE_SHULKER = register("plate_shulker");
        PLATE_STONE = register("plate_stone");
        //endregion
        //region REINFORCED
        REINFORCED_AMETHYST = register("reinforced_amethyst", new Item.Settings().maxCount(16));
        REINFORCED_CITRINE = register("reinforced_citrine", new Item.Settings().maxCount(16));
        REINFORCED_COPPER = register("reinforced_copper", new Item.Settings().maxCount(16));
        REINFORCED_DIAMOND = register("reinforced_diamond", new Item.Settings().maxCount(16));
        REINFORCED_EMERALD = register("reinforced_emerald", new Item.Settings().maxCount(16));
        REINFORCED_ENDERITE = register("reinforced_enderite", new Item.Settings().maxCount(16));
        REINFORCED_GOLD = register("reinforced_gold", new Item.Settings().maxCount(16));
        REINFORCED_IRON = register("reinforced_iron", new Item.Settings().maxCount(16));
        REINFORCED_NETHERITE = register("reinforced_netherite", new Item.Settings().maxCount(16));
        REINFORCED_RUBY = register("reinforced_ruby", new Item.Settings().maxCount(16));
        REINFORCED_SAPPHIRE = register("reinforced_sapphire", new Item.Settings().maxCount(16));
        REINFORCED_SHULKER = register("reinforced_shulker", new Item.Settings().maxCount(16));
        //endregion
        //region ROD
        ROD_COPPER = register("rod_copper", new Item.Settings().maxCount(16));
        ROD_ENDERITE = register("rod_enderite", new Item.Settings().maxCount(16));
        ROD_GLOWSTONE = register("rod_glowstone", new Item.Settings().maxCount(16));
        ROD_GOLD = register("rod_gold", new Item.Settings().maxCount(16));
        ROD_IRON = register("rod_iron", new Item.Settings().maxCount(16));
        ROD_OBSIDIAN = register("rod_obsidian", new Item.Settings().maxCount(16));
        ROD_REDSTONE = register("rod_redstone", new Item.Settings().maxCount(16));
        ROD_SHULKER = register("rod_shulker", new Item.Settings().maxCount(16));
        //endregion
        //region HEADS
        HEAD_CITRINE_AXE = register("head_citrine_axe", new Item.Settings().maxCount(16));
        HEAD_CITRINE_EXCAVATOR = register("head_citrine_excavator", new Item.Settings().maxCount(16));
        HEAD_CITRINE_HAMMER = register("head_citrine_hammer", new Item.Settings().maxCount(16));
        HEAD_CITRINE_HOE = register("head_citrine_hoe", new Item.Settings().maxCount(16));
        HEAD_CITRINE_PICKAXE = register("head_citrine_pickaxe", new Item.Settings().maxCount(16));
        HEAD_CITRINE_SHOVEL = register("head_citrine_shovel", new Item.Settings().maxCount(16));
        HEAD_CITRINE_SWORD = register("head_citrine_sword", new Item.Settings().maxCount(16));

        HEAD_COPPER_AXE = register("head_copper_axe", new Item.Settings().maxCount(16));
        HEAD_COPPER_EXCAVATOR = register("head_copper_excavator", new Item.Settings().maxCount(16));
        HEAD_COPPER_HAMMER = register("head_copper_hammer", new Item.Settings().maxCount(16));
        HEAD_COPPER_HOE = register("head_copper_hoe", new Item.Settings().maxCount(16));
        HEAD_COPPER_PICKAXE = register("head_copper_pickaxe", new Item.Settings().maxCount(16));
        HEAD_COPPER_SHOVEL = register("head_copper_shovel", new Item.Settings().maxCount(16));
        HEAD_COPPER_SWORD = register("head_copper_sword", new Item.Settings().maxCount(16));

        HEAD_DIAMOND_AXE = register("head_diamond_axe", new Item.Settings().maxCount(16));
        HEAD_DIAMOND_EXCAVATOR = register("head_diamond_excavator", new Item.Settings().maxCount(16));
        HEAD_DIAMOND_HAMMER = register("head_diamond_hammer", new Item.Settings().maxCount(16));
        HEAD_DIAMOND_HOE = register("head_diamond_hoe", new Item.Settings().maxCount(16));
        HEAD_DIAMOND_PICKAXE = register("head_diamond_pickaxe", new Item.Settings().maxCount(16));
        HEAD_DIAMOND_SHOVEL = register("head_diamond_shovel", new Item.Settings().maxCount(16));
        HEAD_DIAMOND_SWORD = register("head_diamond_sword", new Item.Settings().maxCount(16));

        HEAD_ENDERITE_AXE = register("head_enderite_axe", new Item.Settings().maxCount(16));
        HEAD_ENDERITE_EXCAVATOR = register("head_enderite_excavator", new Item.Settings().maxCount(16));
        HEAD_ENDERITE_HAMMER = register("head_enderite_hammer", new Item.Settings().maxCount(16));
        HEAD_ENDERITE_HOE = register("head_enderite_hoe", new Item.Settings().maxCount(16));
        HEAD_ENDERITE_PICKAXE = register("head_enderite_pickaxe", new Item.Settings().maxCount(16));
        HEAD_ENDERITE_SHOVEL = register("head_enderite_shovel", new Item.Settings().maxCount(16));
        HEAD_ENDERITE_SWORD = register("head_enderite_sword", new Item.Settings().maxCount(16));

        HEAD_GOLD_AXE = register("head_gold_axe", new Item.Settings().maxCount(16));
        HEAD_GOLD_EXCAVATOR = register("head_gold_excavator", new Item.Settings().maxCount(16));
        HEAD_GOLD_HAMMER = register("head_gold_hammer", new Item.Settings().maxCount(16));
        HEAD_GOLD_HOE = register("head_gold_hoe", new Item.Settings().maxCount(16));
        HEAD_GOLD_PICKAXE = register("head_gold_pickaxe", new Item.Settings().maxCount(16));
        HEAD_GOLD_SHOVEL = register("head_gold_shovel", new Item.Settings().maxCount(16));
        HEAD_GOLD_SWORD = register("head_gold_sword", new Item.Settings().maxCount(16));

        HEAD_IRON_AXE = register("head_iron_axe", new Item.Settings().maxCount(16));
        HEAD_IRON_EXCAVATOR = register("head_iron_excavator", new Item.Settings().maxCount(16));
        HEAD_IRON_HAMMER = register("head_iron_hammer", new Item.Settings().maxCount(16));
        HEAD_IRON_HOE = register("head_iron_hoe", new Item.Settings().maxCount(16));
        HEAD_IRON_PICKAXE = register("head_iron_pickaxe", new Item.Settings().maxCount(16));
        HEAD_IRON_SHOVEL = register("head_iron_shovel", new Item.Settings().maxCount(16));
        HEAD_IRON_SWORD = register("head_iron_sword", new Item.Settings().maxCount(16));

        HEAD_NETHERITE_AXE = register("head_netherite_axe", new Item.Settings().maxCount(16));
        HEAD_NETHERITE_EXCAVATOR = register("head_netherite_excavator", new Item.Settings().maxCount(16));
        HEAD_NETHERITE_HAMMER = register("head_netherite_hammer", new Item.Settings().maxCount(16));
        HEAD_NETHERITE_HOE = register("head_netherite_hoe", new Item.Settings().maxCount(16));
        HEAD_NETHERITE_PICKAXE = register("head_netherite_pickaxe", new Item.Settings().maxCount(16));
        HEAD_NETHERITE_SHOVEL = register("head_netherite_shovel", new Item.Settings().maxCount(16));
        HEAD_NETHERITE_SWORD = register("head_netherite_sword", new Item.Settings().maxCount(16));

        HEAD_RUBY_AXE = register("head_ruby_axe", new Item.Settings().maxCount(16));
        HEAD_RUBY_EXCAVATOR = register("head_ruby_excavator", new Item.Settings().maxCount(16));
        HEAD_RUBY_HAMMER = register("head_ruby_hammer", new Item.Settings().maxCount(16));
        HEAD_RUBY_HOE = register("head_ruby_hoe", new Item.Settings().maxCount(16));
        HEAD_RUBY_PICKAXE = register("head_ruby_pickaxe", new Item.Settings().maxCount(16));
        HEAD_RUBY_SHOVEL = register("head_ruby_shovel", new Item.Settings().maxCount(16));
        HEAD_RUBY_SWORD = register("head_ruby_sword", new Item.Settings().maxCount(16));

        HEAD_SAPPHIRE_AXE = register("head_sapphire_axe", new Item.Settings().maxCount(16));
        HEAD_SAPPHIRE_EXCAVATOR = register("head_sapphire_excavator", new Item.Settings().maxCount(16));
        HEAD_SAPPHIRE_HAMMER = register("head_sapphire_hammer", new Item.Settings().maxCount(16));
        HEAD_SAPPHIRE_HOE = register("head_sapphire_hoe", new Item.Settings().maxCount(16));
        HEAD_SAPPHIRE_PICKAXE = register("head_sapphire_pickaxe", new Item.Settings().maxCount(16));
        HEAD_SAPPHIRE_SHOVEL = register("head_sapphire_shovel", new Item.Settings().maxCount(16));
        HEAD_SAPPHIRE_SWORD = register("head_sapphire_sword", new Item.Settings().maxCount(16));

        HEAD_STONE_HAMMER = register("head_stone_hammer", new Item.Settings().maxCount(16));
        HEAD_STONE_EXCAVATOR = register("head_stone_excavator", new Item.Settings().maxCount(16));
        HEAD_WOOD_HAMMER = register("head_wood_hammer", new Item.Settings().maxCount(16));
        HEAD_WOOD_EXCAVATOR = register("head_wood_excavator", new Item.Settings().maxCount(16));
        //endregion
        //region CITRINE TOOLS
        TOOL_CITRINE_AXE = register("tool_citrine_axe",
                                     new AxeItem(ModToolMaterials.CITRINE,
                                                 new Item.Settings().attributeModifiers(
                                                         AxeItem.createAttributeModifiers(
                                                                 ModToolMaterials.CITRINE,
                                                                 6.0f, -3.1f))));

        TOOL_CITRINE_EXCAVATOR = register("tool_citrine_excavator",
                                       new ExcavatorItem(ModToolMaterials.CITRINE,
                                                         Configs.CITRINE_EXCAVATOR_DEPTH, Configs.CITRINE_EXCAVATOR_WIDTH,
                                                         new Item.Settings().attributeModifiers(
                                                              ShovelItem.createAttributeModifiers(
                                                                      ModToolMaterials.CITRINE,
                                                                      0.0f, -0.0f))));
        TOOL_CITRINE_HAMMER = register("tool_citrine_hammer",
                                       new HammerItem(ModToolMaterials.CITRINE,
                                                      Configs.CITRINE_HAMMER_DEPTH, Configs.CITRINE_HAMMER_WIDTH,
                                                      new Item.Settings().attributeModifiers(
                                                              PickaxeItem.createAttributeModifiers(
                                                                      ModToolMaterials.CITRINE,
                                                                      1.0f, -2.8f))));
        TOOL_CITRINE_HOE = register("tool_citrine_hoe",
                                         new HoeItem(ModToolMaterials.CITRINE,
                                                     new Item.Settings().attributeModifiers(
                                                             HoeItem.createAttributeModifiers(
                                                                     ModToolMaterials.CITRINE,
                                                                     -0.0f, -0.0f))));
        TOOL_CITRINE_PICKAXE = register("tool_citrine_pickaxe",
                                             new PickaxeItem(ModToolMaterials.CITRINE,
                                                             new Item.Settings().attributeModifiers(
                                                                     PickaxeItem.createAttributeModifiers(
                                                                             ModToolMaterials.CITRINE,
                                                                             1.0f, -2.8f))));
        TOOL_CITRINE_SHOVEL = register("tool_citrine_shovel",
                                            new ShovelItem(ModToolMaterials.CITRINE,
                                                           new Item.Settings().attributeModifiers(
                                                                   ShovelItem.createAttributeModifiers(
                                                                           ModToolMaterials.CITRINE,
                                                                           0.0f, -0.0f))));
        TOOL_CITRINE_SWORD = register("tool_citrine_sword",
                                           new CitrineSword(ModToolMaterials.CITRINE,
                                                            new Item.Settings().attributeModifiers(
                                                                    SwordItem.createAttributeModifiers(
                                                                            ModToolMaterials.CITRINE,
                                                                            3, -0.5f))));
        //endregion
        //region COPPER TOOLS
        TOOL_COPPER_AXE = register("tool_copper_axe",
                                        new AxeItem(ModToolMaterials.COPPER,
                                                    new Item.Settings().attributeModifiers(
                                                            AxeItem.createAttributeModifiers(
                                                                    ModToolMaterials.COPPER,
                                                                    6.0f, -1.5f))));

        TOOL_COPPER_EXCAVATOR = register("tool_copper_excavator",
                                          new ExcavatorItem(ModToolMaterials.COPPER,
                                                            Configs.COPPER_EXCAVATOR_DEPTH, Configs.COPPER_EXCAVATOR_WIDTH,
                                                            new Item.Settings().attributeModifiers(
                                                                    ShovelItem.createAttributeModifiers(
                                                                            ModToolMaterials.COPPER,
                                                                            0.0f, -0.0f))));
        TOOL_COPPER_HAMMER = register("tool_copper_hammer",
                                      new HammerItem(ModToolMaterials.COPPER,
                                                     Configs.COPPER_HAMMER_DEPTH, Configs.COPPER_HAMMER_WIDTH,
                                                     new Item.Settings().attributeModifiers(
                                                             PickaxeItem.createAttributeModifiers(
                                                                     ModToolMaterials.COPPER,
                                                                     1.0f, -2.8f))));
        TOOL_COPPER_HOE = register("tool_copper_hoe",
                                        new HoeItem(ModToolMaterials.COPPER,
                                                    new Item.Settings().attributeModifiers(
                                                            HoeItem.createAttributeModifiers(
                                                                    ModToolMaterials.COPPER,
                                                                    -0.0f, -0.0f))));
        TOOL_COPPER_PICKAXE = register("tool_copper_pickaxe",
                                            new PickaxeItem(ModToolMaterials.COPPER,
                                                            new Item.Settings().attributeModifiers(
                                                                    PickaxeItem.createAttributeModifiers(
                                                                            ModToolMaterials.COPPER,
                                                                            1.0f, -1.0f))));
        TOOL_COPPER_SHOVEL = register("tool_copper_shovel",
                                           new ShovelItem(ModToolMaterials.COPPER,
                                                          new Item.Settings().attributeModifiers(
                                                                  ShovelItem.createAttributeModifiers(
                                                                          ModToolMaterials.COPPER,
                                                                          0.0f, -0.0f))));
        TOOL_COPPER_SWORD = register("tool_copper_sword",
                                          new CopperSword(ModToolMaterials.COPPER,
                                                          new Item.Settings().attributeModifiers(
                                                                  SwordItem.createAttributeModifiers(
                                                                          ModToolMaterials.COPPER,
                                                                          3, -2.4f))));
        //endregion
        //region ENDERITE TOOLS
        TOOL_ENDERITE_AXE = register("tool_enderite_axe",
                                          new AxeItem(ModToolMaterials.ENDERITE,
                                                      new Item.Settings().attributeModifiers(
                                                              AxeItem.createAttributeModifiers(
                                                                      ModToolMaterials.ENDERITE,
                                                                      20.0f, -2.5f))));

        TOOL_ENDERITE_EXCAVATOR = register("tool_enderite_excavator",
                                         new ExcavatorItem(ModToolMaterials.ENDERITE,
                                                           Configs.ENDERITE_EXCAVATOR_DEPTH, Configs.ENDERITE_EXCAVATOR_WIDTH,
                                                           new Item.Settings().attributeModifiers(
                                                                   ShovelItem.createAttributeModifiers(
                                                                           ModToolMaterials.ENDERITE,
                                                                           0.0f, -0.0f))));
        TOOL_ENDERITE_HAMMER = register("tool_enderite_hammer",
                                        new HammerItem(ModToolMaterials.ENDERITE,
                                                       Configs.ENDERITE_HAMMER_DEPTH, Configs.ENDERITE_HAMMER_WIDTH,
                                                       new Item.Settings().attributeModifiers(
                                                               PickaxeItem.createAttributeModifiers(
                                                                       ModToolMaterials.ENDERITE,
                                                                       1.0f, -2.8f))));
        TOOL_ENDERITE_HOE = register("tool_enderite_hoe",
                                          new HoeItem(ModToolMaterials.ENDERITE,
                                                      new Item.Settings().attributeModifiers(
                                                              HoeItem.createAttributeModifiers(
                                                                      ModToolMaterials.ENDERITE,
                                                                      -0.0f, -0.0f))));
        TOOL_ENDERITE_PICKAXE = register("tool_enderite_pickaxe",
                                              new PickaxeItem(ModToolMaterials.ENDERITE,
                                                              new Item.Settings().attributeModifiers(
                                                                      PickaxeItem.createAttributeModifiers(
                                                                              ModToolMaterials.ENDERITE,
                                                                              1.0f, -1.0f))));
        TOOL_ENDERITE_SHOVEL = register("tool_enderite_shovel",
                                             new ShovelItem(ModToolMaterials.ENDERITE,
                                                            new Item.Settings().attributeModifiers(
                                                                    ShovelItem.createAttributeModifiers(
                                                                            ModToolMaterials.ENDERITE,
                                                                            0.0f, -0.0f))));
        TOOL_ENDERITE_SWORD = register("tool_enderite_sword",
                                            new EnderiteSword(ModToolMaterials.ENDERITE,
                                                          new Item.Settings().attributeModifiers(
                                                                  SwordItem.createAttributeModifiers(
                                                                          ModToolMaterials.ENDERITE,
                                                                          3, 3.0f))));
        //endregion
        //region RUBY TOOLS
        TOOL_RUBY_AXE = register("tool_ruby_axe",
                                      new AxeItem(ModToolMaterials.RUBY,
                                                  new Item.Settings().attributeModifiers(
                                                          AxeItem.createAttributeModifiers(
                                                                  ModToolMaterials.RUBY,
                                                                  5.0f, -1.5f))));

        TOOL_RUBY_EXCAVATOR = register("tool_ruby_excavator",
                                         new ExcavatorItem(ModToolMaterials.RUBY,
                                                           Configs.RUBY_EXCAVATOR_DEPTH, Configs.RUBY_EXCAVATOR_WIDTH,
                                                           new Item.Settings().attributeModifiers(
                                                                   ShovelItem.createAttributeModifiers(
                                                                           ModToolMaterials.RUBY,
                                                                           0.0f, -0.0f))));
        TOOL_RUBY_HAMMER = register("tool_ruby_hammer",
                                    new HammerItem(ModToolMaterials.RUBY,
                                                   Configs.RUBY_HAMMER_DEPTH, Configs.RUBY_HAMMER_WIDTH,
                                                   new Item.Settings().attributeModifiers(
                                                           PickaxeItem.createAttributeModifiers(
                                                                   ModToolMaterials.RUBY,
                                                                   1.0f, -2.8f))));
        TOOL_RUBY_HOE = register("tool_ruby_hoe",
                                      new HoeItem(ModToolMaterials.RUBY,
                                                  new Item.Settings().attributeModifiers(
                                                          HoeItem.createAttributeModifiers(
                                                                  ModToolMaterials.RUBY,
                                                                  -0.0f, -0.0f))));
        TOOL_RUBY_PICKAXE = register("tool_ruby_pickaxe",
                                          new PickaxeItem(ModToolMaterials.RUBY,
                                                          new Item.Settings().attributeModifiers(
                                                                  PickaxeItem.createAttributeModifiers(
                                                                          ModToolMaterials.RUBY,
                                                                          1.0f, -1.0f))));
        TOOL_RUBY_SHOVEL = register("tool_ruby_shovel",
                                         new ShovelItem(ModToolMaterials.RUBY,
                                                        new Item.Settings().attributeModifiers(
                                                                ShovelItem.createAttributeModifiers(
                                                                        ModToolMaterials.RUBY,
                                                                        0.0f, -0.0f))));
        TOOL_RUBY_SWORD = register("tool_ruby_sword",
                                        new SwordItem(ModToolMaterials.RUBY,
                                                      new Item.Settings().attributeModifiers(
                                                              SwordItem.createAttributeModifiers(
                                                                      ModToolMaterials.RUBY,
                                                                      4, -0.5f))));
        //endregion
        //region SAPPHIRE TOOLS
        TOOL_SAPPHIRE_AXE = register("tool_sapphire_axe",
                                          new AxeItem(ModToolMaterials.SAPPHIRE,
                                                      new Item.Settings().attributeModifiers(
                                                              AxeItem.createAttributeModifiers(
                                                                      ModToolMaterials.SAPPHIRE,
                                                                      5.0f, -1.5f))));

        TOOL_SAPPHIRE_EXCAVATOR = register("tool_sapphire_excavator",
                                         new ExcavatorItem(ModToolMaterials.SAPPHIRE,
                                                           Configs.SAPPHIRE_EXCAVATOR_DEPTH, Configs.SAPPHIRE_EXCAVATOR_WIDTH,
                                                           new Item.Settings().attributeModifiers(
                                                                   ShovelItem.createAttributeModifiers(
                                                                           ModToolMaterials.SAPPHIRE,
                                                                           0.0f, -0.0f))));
        TOOL_SAPPHIRE_HAMMER = register("tool_sapphire_hammer",
                                        new HammerItem(ModToolMaterials.SAPPHIRE,
                                                       Configs.SAPPHIRE_HAMMER_DEPTH, Configs.SAPPHIRE_HAMMER_WIDTH,
                                                       new Item.Settings().attributeModifiers(
                                                               PickaxeItem.createAttributeModifiers(
                                                                       ModToolMaterials.SAPPHIRE,
                                                                       1.0f, -2.8f))));
        TOOL_SAPPHIRE_HOE = register("tool_sapphire_hoe",
                                          new HoeItem(ModToolMaterials.SAPPHIRE,
                                                      new Item.Settings().attributeModifiers(
                                                              HoeItem.createAttributeModifiers(
                                                                      ModToolMaterials.SAPPHIRE,
                                                                      -0.0f, -0.0f))));
        TOOL_SAPPHIRE_PICKAXE = register("tool_sapphire_pickaxe",
                                              new PickaxeItem(ModToolMaterials.SAPPHIRE,
                                                              new Item.Settings().attributeModifiers(
                                                                      PickaxeItem.createAttributeModifiers(
                                                                              ModToolMaterials.SAPPHIRE,
                                                                              1.0f, -1.0f))));
        TOOL_SAPPHIRE_SHOVEL = register("tool_sapphire_shovel",
                                             new ShovelItem(ModToolMaterials.SAPPHIRE,
                                                            new Item.Settings().attributeModifiers(
                                                                    ShovelItem.createAttributeModifiers(
                                                                            ModToolMaterials.SAPPHIRE,
                                                                            0.0f, -0.0f))));
        TOOL_SAPPHIRE_SWORD = register("tool_sapphire_sword",
                                            new SapphireSword(ModToolMaterials.SAPPHIRE,
                                                              new Item.Settings().attributeModifiers(
                                                                      SwordItem.createAttributeModifiers(
                                                                              ModToolMaterials.SAPPHIRE,
                                                                              4, -0.5f))));
        //endregion
        //region VANILLA HAMMERS
        TOOL_DIAMOND_HAMMER = register("tool_diamond_hammer",
                                       new HammerItem(ToolMaterials.DIAMOND,
                                                      Configs.DIAMOND_HAMMER_DEPTH, Configs.DIAMOND_HAMMER_WIDTH,
                                                      new Item.Settings().attributeModifiers(
                                                              PickaxeItem.createAttributeModifiers(
                                                                      ToolMaterials.DIAMOND,
                                                                      1.0f, -2.8f))));

        TOOL_DIAMOND_EXCAVATOR = register("tool_diamond_excavator",
                                           new ExcavatorItem(ToolMaterials.DIAMOND,
                                                             Configs.DIAMOND_EXCAVATOR_DEPTH, Configs.DIAMOND_EXCAVATOR_WIDTH,
                                                             new Item.Settings().attributeModifiers(
                                                                     ShovelItem.createAttributeModifiers(
                                                                             ToolMaterials.DIAMOND,
                                                                             0.0f, -0.0f))));
        TOOL_GOLD_HAMMER = register("tool_gold_hammer",
                                    new HammerItem(ToolMaterials.GOLD,
                                                   Configs.GOLD_HAMMER_DEPTH, Configs.GOLD_HAMMER_WIDTH,
                                                   new Item.Settings().attributeModifiers(
                                                           PickaxeItem.createAttributeModifiers(
                                                                   ToolMaterials.GOLD,
                                                                   1.0f, -2.8f))));

        TOOL_GOLD_EXCAVATOR = register("tool_gold_excavator",
                                           new ExcavatorItem(ToolMaterials.GOLD,
                                                             Configs.GOLD_EXCAVATOR_DEPTH, Configs.GOLD_EXCAVATOR_WIDTH,
                                                             new Item.Settings().attributeModifiers(
                                                                     ShovelItem.createAttributeModifiers(
                                                                             ToolMaterials.GOLD,
                                                                             0.0f, -0.0f))));
        TOOL_IRON_HAMMER = register("tool_iron_hammer",
                                    new HammerItem(ToolMaterials.IRON,
                                                   Configs.IRON_HAMMER_DEPTH, Configs.IRON_HAMMER_WIDTH,
                                                   new Item.Settings().attributeModifiers(
                                                           PickaxeItem.createAttributeModifiers(
                                                                   ToolMaterials.IRON,
                                                                   1.0f, -2.8f))));

        TOOL_IRON_EXCAVATOR = register("tool_iron_excavator",
                                       new ExcavatorItem(ToolMaterials.IRON,
                                                         Configs.IRON_EXCAVATOR_DEPTH, Configs.IRON_EXCAVATOR_WIDTH,
                                                         new Item.Settings().attributeModifiers(
                                                                 ShovelItem.createAttributeModifiers(
                                                                         ToolMaterials.IRON,
                                                                         0.0f, -0.0f))));
        TOOL_NETHERITE_HAMMER = register("tool_netherite_hammer",
                                         new HammerItem(ToolMaterials.NETHERITE,
                                                        Configs.NETHERITE_HAMMER_DEPTH, Configs.NETHERITE_HAMMER_WIDTH,
                                                        new Item.Settings().attributeModifiers(
                                                                PickaxeItem.createAttributeModifiers(
                                                                        ToolMaterials.NETHERITE,
                                                                        1.0f, -2.8f))));

        TOOL_NETHERITE_EXCAVATOR = register("tool_netherite_excavator",
                                       new ExcavatorItem(ToolMaterials.NETHERITE,
                                                         Configs.NETHERITE_EXCAVATOR_DEPTH, Configs.NETHERITE_EXCAVATOR_WIDTH,
                                                         new Item.Settings().attributeModifiers(
                                                                 ShovelItem.createAttributeModifiers(
                                                                         ToolMaterials.NETHERITE,
                                                                         0.0f, -0.0f))));
        TOOL_STONE_HAMMER = register("tool_stone_hammer",
                                     new HammerItem(ToolMaterials.STONE,
                                                    Configs.STONE_HAMMER_DEPTH, Configs.STONE_HAMMER_WIDTH,
                                                    new Item.Settings().attributeModifiers(
                                                            PickaxeItem.createAttributeModifiers(
                                                                    ToolMaterials.STONE,
                                                                    1.0f, -2.8f))));

        TOOL_STONE_EXCAVATOR = register("tool_stone_excavator",
                                       new ExcavatorItem(ToolMaterials.STONE,
                                                         Configs.STONE_EXCAVATOR_DEPTH, Configs.STONE_EXCAVATOR_WIDTH,
                                                         new Item.Settings().attributeModifiers(
                                                                 ShovelItem.createAttributeModifiers(
                                                                         ToolMaterials.STONE,
                                                                         0.0f, -0.0f))));
        TOOL_WOOD_HAMMER = register("tool_wood_hammer",
                                    new HammerItem(ToolMaterials.WOOD,
                                                   Configs.WOOD_HAMMER_DEPTH, Configs.WOOD_HAMMER_WIDTH,
                                                   new Item.Settings().attributeModifiers(
                                                           PickaxeItem.createAttributeModifiers(
                                                                   ToolMaterials.WOOD,
                                                                   1.0f, -2.8f))));

        TOOL_WOOD_EXCAVATOR = register("tool_wood_excavator",
                                       new ExcavatorItem(ToolMaterials.WOOD,
                                                         Configs.WOOD_EXCAVATOR_DEPTH, Configs.WOOD_EXCAVATOR_WIDTH,
                                                         new Item.Settings().attributeModifiers(
                                                                 ShovelItem.createAttributeModifiers(
                                                                         ToolMaterials.WOOD,
                                                                         0.0f, -0.0f))));
        //endregion
        //region TOOL
        BACKPACK = register("backpack",
                            new BackpackItem(new Item.Settings().maxCount(1)));
        ENDER_BACKPACK = register("ender_backpack",
                                  new EnderBackpackItem(new Item.Settings().maxCount(1)));

        BLUEPRINT_EMPTY = register("blueprint_empty");
        BLUEPRINT_PRINTED = register("blueprint_printed",
                                     new BlueprintItem(new Item.Settings().maxCount(1)));
        PLAYER_TELEPORT = register("tool_player_teleport",
                                   new PlayerTeleporter(new Item.Settings().maxCount(1)));
        TUNER = register("tool_tuner",
                         new TunerItem(new Item.Settings().maxCount(1)));
        ADVANCED_TUNER = register("tool_tuner_advanced",
                                  new AdvancedTuner(new Item.Settings().maxCount(1)));
        WRENCH = register("tool_wrench",
                          new Item.Settings().maxCount(1));
        CHALICE = register("chalice",
                           new ChaliceItem(new Item.Settings().maxCount(1)));
        CHALICE_EMPTY = register("chalice_empty");
        //endregion
        //region AMETHYST ARMOR
        ARMOR_AMETHYST_HELMET =
                register("armor_amethyst_helmet",
                         new ArmorItem(ModArmorMaterials.AMETHYST,
                                       ArmorItem.Type.HELMET,
                                       new Item.Settings()
                                               .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(20)).maxCount(1)));
        ARMOR_AMETHYST_CHESTPLATE =
                register("armor_amethyst_chestplate",
                         new ArmorItem(ModArmorMaterials.AMETHYST,
                                       ArmorItem.Type.CHESTPLATE,
                                       new Item.Settings()
                                               .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(20)).maxCount(1)));
        ARMOR_AMETHYST_LEGGINGS =
                register("armor_amethyst_leggings",
                         new ArmorItem(ModArmorMaterials.AMETHYST,
                                          ArmorItem.Type.LEGGINGS,
                                          new Item.Settings()
                                                  .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(20)).maxCount(1)));
        ARMOR_AMETHYST_BOOTS =
                register("armor_amethyst_boots",
                         new ArmorItem(ModArmorMaterials.AMETHYST,
                                       ArmorItem.Type.BOOTS,
                                       new Item.Settings()
                                               .maxDamage(ArmorItem.Type.BOOTS
                                                                  .getMaxDamage(20)).maxCount(1)));
        //endregion
        //region CITRINE ARMOR
        ARMOR_CITRINE_HELMET =
                register("armor_citrine_helmet",
                         new ArmorItem(ModArmorMaterials.CITRINE,
                                       ArmorItem.Type.HELMET,
                                       new Item.Settings()
                                               .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(30)).maxCount(1)));
        ARMOR_CITRINE_CHESTPLATE =
                register("armor_citrine_chestplate",
                         new ArmorItem(ModArmorMaterials.CITRINE,
                                       ArmorItem.Type.CHESTPLATE,
                                       new Item.Settings()
                                               .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(30)).maxCount(1)));
        ARMOR_CITRINE_LEGGINGS =
                register("armor_citrine_leggings",
                         new ArmorItem(ModArmorMaterials.CITRINE,
                                          ArmorItem.Type.LEGGINGS,
                                          new Item.Settings()
                                                  .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(30)).maxCount(1)));
        ARMOR_CITRINE_BOOTS =
                register("armor_citrine_boots",
                         new ArmorItem(ModArmorMaterials.CITRINE,
                                       ArmorItem.Type.BOOTS,
                                       new Item.Settings()
                                               .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(30)).maxCount(1)));
        //endregion
        //region COPPER ARMOR
        ARMOR_COPPER_HELMET =
                register("armor_copper_helmet",
                         new ArmorItem(ModArmorMaterials.COPPER,
                                       ArmorItem.Type.HELMET,
                                       new Item.Settings()
                                               .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(25)).maxCount(1)));
        ARMOR_COPPER_CHESTPLATE =
                register("armor_copper_chestplate",
                         new ArmorItem(ModArmorMaterials.COPPER,
                                       ArmorItem.Type.CHESTPLATE,
                                       new Item.Settings()
                                               .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(25)).maxCount(1)));
        ARMOR_COPPER_LEGGINGS =
                register("armor_copper_leggings",
                         new ArmorItem(ModArmorMaterials.COPPER,
                                          ArmorItem.Type.LEGGINGS,
                                          new Item.Settings()
                                                  .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(25)).maxCount(1)));
        ARMOR_COPPER_BOOTS =
                register("armor_copper_boots",
                         new ArmorItem(ModArmorMaterials.COPPER,
                                       ArmorItem.Type.BOOTS,
                                       new Item.Settings()
                                               .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(25)).maxCount(1)));
        //endregion
        //region EMERALD ARMOR
        ARMOR_EMERALD_HELMET =
                register("armor_emerald_helmet",
                         new ArmorItem(ModArmorMaterials.EMERALD,
                                       ArmorItem.Type.HELMET,
                                       new Item.Settings()
                                               .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15)).maxCount(1)));
        ARMOR_EMERALD_CHESTPLATE =
                register("armor_emerald_chestplate",
                         new ArmorItem(ModArmorMaterials.EMERALD,
                                       ArmorItem.Type.CHESTPLATE,
                                       new Item.Settings()
                                               .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15)).maxCount(1)));
        ARMOR_EMERALD_LEGGINGS =
                register("armor_emerald_leggings",
                         new ArmorItem(ModArmorMaterials.EMERALD,
                                          ArmorItem.Type.LEGGINGS,
                                          new Item.Settings()
                                                  .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15)).maxCount(1)));
        ARMOR_EMERALD_BOOTS =
                register("armor_emerald_boots",
                         new ArmorItem(ModArmorMaterials.EMERALD,
                                       ArmorItem.Type.BOOTS,
                                       new Item.Settings()
                                               .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15)).maxCount(1)));
        //endregion
        //region ENDERITE ARMOR
        ARMOR_ENDERITE_HELMET =
                register("armor_enderite_helmet",
                         new ArmorItem(ModArmorMaterials.ENDERITE,
                                       ArmorItem.Type.HELMET,
                                       new Item.Settings()
                                               .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(42)).maxCount(1)));
        ARMOR_ENDERITE_CHESTPLATE =
                register("armor_enderite_chestplate",
                         new ArmorItem(ModArmorMaterials.ENDERITE,
                                       ArmorItem.Type.CHESTPLATE,
                                       new Item.Settings()
                                               .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(42)).maxCount(1)));
        ARMOR_ENDERITE_LEGGINGS =
                register("armor_enderite_leggings",
                         new ArmorItem(ModArmorMaterials.ENDERITE,
                                          ArmorItem.Type.LEGGINGS,
                                          new Item.Settings()
                                                  .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(42)).maxCount(1)));
        ARMOR_ENDERITE_BOOTS =
                register("armor_enderite_boots",
                         new ArmorItem(ModArmorMaterials.ENDERITE,
                                       ArmorItem.Type.BOOTS,
                                       new Item.Settings()
                                               .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(42)).maxCount(1)));
        //endregion
        //region RUBY ARMOR
        ARMOR_RUBY_HELMET =
                register("armor_ruby_helmet",
                         new ArmorItem(ModArmorMaterials.RUBY,
                                       ArmorItem.Type.HELMET,
                                       new Item.Settings()
                                               .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(36)).maxCount(1)));
        ARMOR_RUBY_CHESTPLATE =
                register("armor_ruby_chestplate",
                         new ArmorItem(ModArmorMaterials.RUBY,
                                       ArmorItem.Type.CHESTPLATE,
                                       new Item.Settings()
                                               .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(36)).maxCount(1)));
        ARMOR_RUBY_LEGGINGS =
                register("armor_ruby_leggings",
                         new ArmorItem(ModArmorMaterials.RUBY,
                                          ArmorItem.Type.LEGGINGS,
                                          new Item.Settings()
                                                  .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(36)).maxCount(1)));
        ARMOR_RUBY_BOOTS =
                register("armor_ruby_boots",
                         new ArmorItem(ModArmorMaterials.RUBY,
                                       ArmorItem.Type.BOOTS,
                                       new Item.Settings()
                                               .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(36)).maxCount(1)));
        //endregion
        //region SAPPHIRE ARMOR
        ARMOR_SAPPHIRE_HELMET =
                register("armor_sapphire_helmet",
                         new ArmorItem(ModArmorMaterials.SAPPHIRE,
                                       ArmorItem.Type.HELMET,
                                       new Item.Settings()
                                               .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(36)).maxCount(1)));

        ARMOR_SAPPHIRE_CHESTPLATE =
                register("armor_sapphire_chestplate",
                         new ArmorItem(ModArmorMaterials.SAPPHIRE,
                                       ArmorItem.Type.CHESTPLATE,
                                       new Item.Settings()
                                               .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(36)).maxCount(1)));

        ARMOR_SAPPHIRE_LEGGINGS =
                register("armor_sapphire_leggings",
                         new ArmorItem(ModArmorMaterials.SAPPHIRE,
                                          ArmorItem.Type.LEGGINGS,
                                          new Item.Settings()
                                                  .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(36)).maxCount(1)));

        ARMOR_SAPPHIRE_BOOTS =
                register("armor_sapphire_boots",
                         new ArmorItem(ModArmorMaterials.SAPPHIRE,
                                       ArmorItem.Type.BOOTS,
                                       new Item.Settings()
                                               .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(36)).maxCount(1)));
        //endregion

        ANGEL_BLOCK_ITEM = registerBlockItem("block_angel",
                                             new AngelBlockItem(ModBlocks.ANGEL, new Item.Settings()));

        AllItems = getAllItems(ModID);
    }

    //region HELPER METHODS


    //endregion
}