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
import jiraiyah.uio.registry.misc.ModArmorMaterials;
import jiraiyah.uio.registry.misc.ModToolMaterials;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;

import java.util.ArrayList;
import java.util.List;

import static jiraiyah.uio.Reference.log;
import static jiraiyah.uio.util.registry.Registers.Item.*;

/**
 * The {@code ModItems} class provides utility methods and fields
 * related to the custom items in the Minecraft mod. It handles
 * the registration of various items including gems, tools, and
 * armor, while also maintaining a blacklist for specific items.
 *
 * <p>This class cannot be instantiated as it is intended to be
 * a static utility class.</p>
 *
 * <p>All items are registered in the Minecraft mod and can be
 * accessed statically.</p>
 *
 * <p>Some of the textures are from : <a href="https://github/malcolmriley/unused-textures">GITHUB REPOSITORY</a></p>
 */
public class ModItems
{
    /**
     * A blacklist that contains items that should be excluded from
     * certain functionalities such as crafting or usage.
     * This is a static final list that cannot be modified post
     * initialization.
     */
    public static final List<Item> BLACK_LIST = new ArrayList<>();
    public static Item GEM_CITRINE, GEM_RUBY, GEM_SAPPHIRE,
            RAW_CITRINE, RAW_ENDERITE, RAW_QUARTZ, RAW_RUBY, RAW_SAPPHIRE,
            CAST_AXE, CAST_BINDING, CAST_EXCAVATOR, CAST_GEAR, CAST_GEM, CAST_HAMMER, CAST_HANDLE, CAST_HOE, CAST_INGOT, CAST_NUGGET,
            CAST_PICKAXE, CAST_PLATE, CAST_ROD, CAST_SHOVEL, CAST_SWORD, CAST_WIRE, CAST_WOOD_INGOT, CAST_WOOD_PICKAXE,
            CRUSHED_SHULKER, DUST_CONDUCTIVE, DUST_COPPER, DUST_ENDERITE, DUST_ENERGETIC, DUST_GOLD, DUST_IRON, DUST_OBSIDIAN,
            DUST_PULSATING, DUST_RED_ALLOY, DUST_SOUL, DUST_VIBRANT, DUST_WITHERING,
            GEAR_COPPER, GEAR_DIAMOND, GEAR_EMERALD, GEAR_ENDERITE, GEAR_ENERGIZED, GEAR_GOLD, GEAR_IRON, GEAR_LAPIS,
            GEAR_NETHERITE, GEAR_OBSIDIAN, GEAR_PRISMARINE, GEAR_QUARTZ, GEAR_RUBY, GEAR_SAPPHIRE, GEAR_SHULKER, GEAR_STONE,
            GEAR_VIBRANT, GEAR_WOOD,
            INGOT_ALLOY_CONDUCTIVE, INGOT_ALLOY_ENERGETIC, INGOT_ALLOY_PULSATING, INGOT_ALLOY_RED, INGOT_ALLOY_VIBRANT,
            INGOT_ALLOY_ENDERITE, RAW_ALLOY_ENDERITE, INGOT_ENDERITE,
            PLATE_AMETHYST, PLATE_CITRINE, PLATE_COPPER, PLATE_DIAMOND, PLATE_EMERALD, PLATE_ENDERITE, PLATE_GOLD,
            PLATE_IRON, PLATE_NETHERITE, PLATE_RUBY, PLATE_SAPPHIRE, PLATE_SHULKER, PLATE_STONE,
            REINFORCED_AMETHYST, REINFORCED_CITRINE, REINFORCED_COPPER, REINFORCED_DIAMOND, REINFORCED_EMERALD, REINFORCED_ENDERITE,
            REINFORCED_GOLD, REINFORCED_IRON, REINFORCED_NETHERITE, REINFORCED_RUBY, REINFORCED_SAPPHIRE, REINFORCED_SHULKER,
            ROD_COPPER, ROD_ENDERITE, ROD_GLOWSTONE, ROD_GOLD, ROD_IRON, ROD_OBSIDIAN, ROD_REDSTONE, ROD_SHULKER,
            HEAD_CITRINE_AXE, HEAD_CITRINE_EXCAVATOR, HEAD_CITRINE_HAMMER, HEAD_CITRINE_HOE, HEAD_CITRINE_PICKAXE, HEAD_CITRINE_SHOVEL, HEAD_CITRINE_SWORD,
            HEAD_COPPER_AXE, HEAD_COPPER_EXCAVATOR, HEAD_COPPER_HAMMER, HEAD_COPPER_HOE, HEAD_COPPER_PICKAXE, HEAD_COPPER_SHOVEL, HEAD_COPPER_SWORD,
            HEAD_DIAMOND_AXE, HEAD_DIAMOND_EXCAVATOR, HEAD_DIAMOND_HAMMER, HEAD_DIAMOND_HOE, HEAD_DIAMOND_PICKAXE, HEAD_DIAMOND_SHOVEL, HEAD_DIAMOND_SWORD,
            HEAD_ENDERITE_AXE, HEAD_ENDERITE_EXCAVATOR, HEAD_ENDERITE_HAMMER, HEAD_ENDERITE_HOE, HEAD_ENDERITE_PICKAXE, HEAD_ENDERITE_SHOVEL, HEAD_ENDERITE_SWORD,
            HEAD_GOLD_AXE, HEAD_GOLD_EXCAVATOR, HEAD_GOLD_HAMMER, HEAD_GOLD_HOE, HEAD_GOLD_PICKAXE, HEAD_GOLD_SHOVEL, HEAD_GOLD_SWORD,
            HEAD_IRON_AXE, HEAD_IRON_EXCAVATOR, HEAD_IRON_HAMMER, HEAD_IRON_HOE, HEAD_IRON_PICKAXE, HEAD_IRON_SHOVEL, HEAD_IRON_SWORD,
            HEAD_NETHERITE_AXE, HEAD_NETHERITE_EXCAVATOR, HEAD_NETHERITE_HAMMER, HEAD_NETHERITE_HOE, HEAD_NETHERITE_PICKAXE, HEAD_NETHERITE_SHOVEL, HEAD_NETHERITE_SWORD,
            HEAD_RUBY_AXE, HEAD_RUBY_EXCAVATOR, HEAD_RUBY_HAMMER, HEAD_RUBY_HOE, HEAD_RUBY_PICKAXE, HEAD_RUBY_SHOVEL, HEAD_RUBY_SWORD,
            HEAD_SAPPHIRE_AXE, HEAD_SAPPHIRE_EXCAVATOR, HEAD_SAPPHIRE_HAMMER, HEAD_SAPPHIRE_HOE, HEAD_SAPPHIRE_PICKAXE, HEAD_SAPPHIRE_SHOVEL, HEAD_SAPPHIRE_SWORD,
            HEAD_STONE_HAMMER, HEAD_STONE_EXCAVATOR, HEAD_WOOD_HAMMER, HEAD_WOOD_EXCAVATOR,

    ENDER_CHARM, ENDERMAN_EYE, ENDERMAN_HEART, ENDERMAN_GLAND, BLUEPRINT_EMPTY, THERMAL_CORE, HOT_COAL,
            COOKED_EGG, EGG_AND_BREAD, SLOT_DISABLED, SLOT_ENABLED, ITEM_FILTER, CHALICE_EMPTY,
            VOID_PLATE_BASE, VOID_PLATE_ACTIVATOR, VOID_PLATE, RUBBER, RAW_RUBBER, BINDING_STRING, UNSTABLE_GOO, COMBUSTION_CORE;
    public static ArmorItem ARMOR_AMETHYST_HELMET, ARMOR_AMETHYST_CHESTPLATE, ARMOR_AMETHYST_LEGGINGS, ARMOR_AMETHYST_BOOTS,
            ARMOR_CITRINE_HELMET, ARMOR_CITRINE_CHESTPLATE, ARMOR_CITRINE_LEGGINGS, ARMOR_CITRINE_BOOTS,
            ARMOR_COPPER_HELMET, ARMOR_COPPER_CHESTPLATE, ARMOR_COPPER_LEGGINGS, ARMOR_COPPER_BOOTS,
            ARMOR_EMERALD_HELMET, ARMOR_EMERALD_CHESTPLATE, ARMOR_EMERALD_LEGGINGS, ARMOR_EMERALD_BOOTS,
            ARMOR_ENDERITE_HELMET, ARMOR_ENDERITE_CHESTPLATE, ARMOR_ENDERITE_LEGGINGS, ARMOR_ENDERITE_BOOTS,
            ARMOR_RUBY_HELMET, ARMOR_RUBY_CHESTPLATE, ARMOR_RUBY_LEGGINGS, ARMOR_RUBY_BOOTS,
            ARMOR_SAPPHIRE_HELMET, ARMOR_SAPPHIRE_CHESTPLATE, ARMOR_SAPPHIRE_LEGGINGS, ARMOR_SAPPHIRE_BOOTS;

    public static ExcavatorItem TOOL_CITRINE_EXCAVATOR, TOOL_COPPER_EXCAVATOR, TOOL_ENDERITE_EXCAVATOR, TOOL_RUBY_EXCAVATOR, TOOL_SAPPHIRE_EXCAVATOR,
            TOOL_NETHERITE_EXCAVATOR, TOOL_DIAMOND_EXCAVATOR, TOOL_GOLD_EXCAVATOR, TOOL_IRON_EXCAVATOR, TOOL_STONE_EXCAVATOR, TOOL_WOOD_EXCAVATOR;
    public static HammerItem TOOL_CITRINE_HAMMER, TOOL_COPPER_HAMMER, TOOL_ENDERITE_HAMMER, TOOL_RUBY_HAMMER, TOOL_SAPPHIRE_HAMMER,
            TOOL_NETHERITE_HAMMER, TOOL_DIAMOND_HAMMER, TOOL_GOLD_HAMMER, TOOL_IRON_HAMMER, TOOL_STONE_HAMMER, TOOL_WOOD_HAMMER;
    public static AxeItem TOOL_CITRINE_AXE, TOOL_COPPER_AXE, TOOL_ENDERITE_AXE, TOOL_RUBY_AXE, TOOL_SAPPHIRE_AXE;
    public static HoeItem TOOL_CITRINE_HOE, TOOL_COPPER_HOE, TOOL_ENDERITE_HOE, TOOL_RUBY_HOE, TOOL_SAPPHIRE_HOE;
    public static PickaxeItem TOOL_CITRINE_PICKAXE, TOOL_COPPER_PICKAXE, TOOL_ENDERITE_PICKAXE, TOOL_RUBY_PICKAXE, TOOL_SAPPHIRE_PICKAXE;
    public static ShovelItem TOOL_CITRINE_SHOVEL, TOOL_COPPER_SHOVEL, TOOL_ENDERITE_SHOVEL, TOOL_RUBY_SHOVEL, TOOL_SAPPHIRE_SHOVEL;
    //public static SwordItem;

    public static CitrineSword TOOL_CITRINE_SWORD;
    public static CopperSword TOOL_COPPER_SWORD;
    public static EnderiteSword TOOL_ENDERITE_SWORD;
    public static RubySword TOOL_RUBY_SWORD;
    public static SapphireSword TOOL_SAPPHIRE_SWORD;

    public static BackpackItem BACKPACK;
    public static BlueprintItem BLUEPRINT_PRINTED;
    public static EnderBackpackItem ENDER_BACKPACK;
    public static TunerItem TUNER;
    public static AdvancedTuner ADVANCED_TUNER;
    public static PlayerTeleporter PLAYER_TELEPORT;
    public static ChaliceItem CHALICE;
    public static WrenchItem WRENCH;

    /**
     * Private constructor to prevent instantiation of this class.
     * Throws an {@code AssertionError} if attempted.
     */
    ModItems()
    {
        throw new AssertionError();
    }

    //BI: Block Item

    /**
     * Initializes and registers all custom items for the Minecraft mod.
     * <p>
     * This method is called during the mod's initialization phase to ensure
     * that all items are properly registered and available for use. It logs
     * the registration process for debugging and tracking purposes.
     * The method will encapsulate the registration of various categories of
     * items including gems, raw materials, tools, casts, dusts, gears,
     * ingots, plates, reinforced materials, rods, and armor.
     * </p>
     * <p>
     * Each item is registered using the appropriate registration methods,
     * and the method ensures that all items are accounted for in the
     * mod's collection of items.
     * </p>
     */
    public static void init()
    {
        log("Registering Items");

        //region FOOD FUEL MISC
        BINDING_STRING = register("binding_string", 16);
        UNSTABLE_GOO = register("unstable_goo_core");
        COMBUSTION_CORE = register("unstable_goo_base");
        RAW_RUBBER = register("raw_rubber", 16);
        RUBBER = register("rubber", 16);
        VOID_PLATE_BASE = register("void_plate_base", 1);
        VOID_PLATE_ACTIVATOR = register("void_plate_activator", 1);
        VOID_PLATE = register("void_plate", 1);
        ENDER_CHARM = register("ender_charm", 16);
        ENDERMAN_EYE = register("enderman_eye", 16);
        ENDERMAN_HEART = register("enderman_heart", 16);
        ENDERMAN_GLAND = register("enderman_gland", 16);
        ITEM_FILTER = register("item_filter", 16);
        SLOT_DISABLED = register("slot_disabled", 16);
        SLOT_ENABLED = register("slot_enabled", 16);
        COOKED_EGG = registerSnackFood("cooked_egg", 16, 4, 0.55f);
        EGG_AND_BREAD = registerSnackFood("egg_and_bread", 16, 11, 1.2f);
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
        CAST_AXE = register("cast_axe", 1);
        CAST_BINDING = register("cast_binding", 1);
        CAST_EXCAVATOR = register("cast_excavator", 1);
        CAST_GEAR = register("cast_gear", 1);
        CAST_GEM = register("cast_gem", 1);
        CAST_HAMMER = register("cast_hammer", 1);
        CAST_HANDLE = register("cast_handle", 1);
        CAST_HOE = register("cast_hoe", 1);
        CAST_INGOT = register("cast_ingot", 1);
        CAST_NUGGET = register("cast_nugget", 1);
        CAST_PICKAXE = register("cast_pickaxe", 1);
        CAST_PLATE = register("cast_plate", 1);
        CAST_ROD = register("cast_rod", 1);
        CAST_SHOVEL = register("cast_shovel", 1);
        CAST_SWORD = register("cast_sword", 1);
        CAST_WIRE = register("cast_wire", 1);
        CAST_WOOD_INGOT = register("cast_wood_ingot", 1);
        CAST_WOOD_PICKAXE = register("cast_wood_pickaxe", 1);
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
        GEAR_COPPER = register("gear_copper", 16);
        GEAR_DIAMOND = register("gear_diamond", 16);
        GEAR_EMERALD = register("gear_emerald", 16);
        GEAR_ENDERITE = register("gear_enderite", 16);
        GEAR_ENERGIZED = register("gear_energized", 16);
        GEAR_GOLD = register("gear_gold", 16);
        GEAR_IRON = register("gear_iron", 16);
        GEAR_LAPIS = register("gear_lapis", 16);
        GEAR_NETHERITE = register("gear_netherite", 16);
        GEAR_OBSIDIAN = register("gear_obsidian", 16);
        GEAR_PRISMARINE = register("gear_prismarine", 16);
        GEAR_QUARTZ = register("gear_quartz", 16);
        GEAR_RUBY = register("gear_ruby", 16);
        GEAR_SAPPHIRE = register("gear_sapphire", 16);
        GEAR_SHULKER = register("gear_shulker", 16);
        GEAR_STONE = register("gear_stone", 16);
        GEAR_VIBRANT = register("gear_vibrant", 16);
        GEAR_WOOD = register("gear_wood", 16);
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
        REINFORCED_AMETHYST = register("reinforced_amethyst", 16);
        REINFORCED_CITRINE = register("reinforced_citrine", 16);
        REINFORCED_COPPER = register("reinforced_copper", 16);
        REINFORCED_DIAMOND = register("reinforced_diamond", 16);
        REINFORCED_EMERALD = register("reinforced_emerald", 16);
        REINFORCED_ENDERITE = register("reinforced_enderite", 16);
        REINFORCED_GOLD = register("reinforced_gold", 16);
        REINFORCED_IRON = register("reinforced_iron", 16);
        REINFORCED_NETHERITE = register("reinforced_netherite", 16);
        REINFORCED_RUBY = register("reinforced_ruby", 16);
        REINFORCED_SAPPHIRE = register("reinforced_sapphire", 16);
        REINFORCED_SHULKER = register("reinforced_shulker", 16);
        //endregion
        //region ROD
        ROD_COPPER = register("rod_copper", 16);
        ROD_ENDERITE = register("rod_enderite", 16);
        ROD_GLOWSTONE = register("rod_glowstone", 16);
        ROD_GOLD = register("rod_gold", 16);
        ROD_IRON = register("rod_iron", 16);
        ROD_OBSIDIAN = register("rod_obsidian", 16);
        ROD_REDSTONE = register("rod_redstone", 16);
        ROD_SHULKER = register("rod_shulker", 16);
        //endregion
        //region HEADS
        HEAD_CITRINE_AXE = register("head_citrine_axe", 16);
        HEAD_CITRINE_EXCAVATOR = register("head_citrine_excavator", 16);
        HEAD_CITRINE_HAMMER = register("head_citrine_hammer", 16);
        HEAD_CITRINE_HOE = register("head_citrine_hoe", 16);
        HEAD_CITRINE_PICKAXE = register("head_citrine_pickaxe", 16);
        HEAD_CITRINE_SHOVEL = register("head_citrine_shovel", 16);
        HEAD_CITRINE_SWORD = register("head_citrine_sword", 16);

        HEAD_COPPER_AXE = register("head_copper_axe", 16);
        HEAD_COPPER_EXCAVATOR = register("head_copper_excavator", 16);
        HEAD_COPPER_HAMMER = register("head_copper_hammer", 16);
        HEAD_COPPER_HOE = register("head_copper_hoe", 16);
        HEAD_COPPER_PICKAXE = register("head_copper_pickaxe", 16);
        HEAD_COPPER_SHOVEL = register("head_copper_shovel", 16);
        HEAD_COPPER_SWORD = register("head_copper_sword", 16);

        HEAD_DIAMOND_AXE = register("head_diamond_axe", 16);
        HEAD_DIAMOND_EXCAVATOR = register("head_diamond_excavator", 16);
        HEAD_DIAMOND_HAMMER = register("head_diamond_hammer", 16);
        HEAD_DIAMOND_HOE = register("head_diamond_hoe", 16);
        HEAD_DIAMOND_PICKAXE = register("head_diamond_pickaxe", 16);
        HEAD_DIAMOND_SHOVEL = register("head_diamond_shovel", 16);
        HEAD_DIAMOND_SWORD = register("head_diamond_sword", 16);

        HEAD_ENDERITE_AXE = register("head_enderite_axe", 16);
        HEAD_ENDERITE_EXCAVATOR = register("head_enderite_excavator", 16);
        HEAD_ENDERITE_HAMMER = register("head_enderite_hammer", 16);
        HEAD_ENDERITE_HOE = register("head_enderite_hoe", 16);
        HEAD_ENDERITE_PICKAXE = register("head_enderite_pickaxe", 16);
        HEAD_ENDERITE_SHOVEL = register("head_enderite_shovel", 16);
        HEAD_ENDERITE_SWORD = register("head_enderite_sword", 16);

        HEAD_GOLD_AXE = register("head_gold_axe", 16);
        HEAD_GOLD_EXCAVATOR = register("head_gold_excavator", 16);
        HEAD_GOLD_HAMMER = register("head_gold_hammer", 16);
        HEAD_GOLD_HOE = register("head_gold_hoe", 16);
        HEAD_GOLD_PICKAXE = register("head_gold_pickaxe", 16);
        HEAD_GOLD_SHOVEL = register("head_gold_shovel", 16);
        HEAD_GOLD_SWORD = register("head_gold_sword", 16);

        HEAD_IRON_AXE = register("head_iron_axe", 16);
        HEAD_IRON_EXCAVATOR = register("head_iron_excavator", 16);
        HEAD_IRON_HAMMER = register("head_iron_hammer", 16);
        HEAD_IRON_HOE = register("head_iron_hoe", 16);
        HEAD_IRON_PICKAXE = register("head_iron_pickaxe", 16);
        HEAD_IRON_SHOVEL = register("head_iron_shovel", 16);
        HEAD_IRON_SWORD = register("head_iron_sword", 16);

        HEAD_NETHERITE_AXE = register("head_netherite_axe", 16);
        HEAD_NETHERITE_EXCAVATOR = register("head_netherite_excavator", 16);
        HEAD_NETHERITE_HAMMER = register("head_netherite_hammer", 16);
        HEAD_NETHERITE_HOE = register("head_netherite_hoe", 16);
        HEAD_NETHERITE_PICKAXE = register("head_netherite_pickaxe", 16);
        HEAD_NETHERITE_SHOVEL = register("head_netherite_shovel", 16);
        HEAD_NETHERITE_SWORD = register("head_netherite_sword", 16);

        HEAD_RUBY_AXE = register("head_ruby_axe", 16);
        HEAD_RUBY_EXCAVATOR = register("head_ruby_excavator", 16);
        HEAD_RUBY_HAMMER = register("head_ruby_hammer", 16);
        HEAD_RUBY_HOE = register("head_ruby_hoe", 16);
        HEAD_RUBY_PICKAXE = register("head_ruby_pickaxe", 16);
        HEAD_RUBY_SHOVEL = register("head_ruby_shovel", 16);
        HEAD_RUBY_SWORD = register("head_ruby_sword", 16);

        HEAD_SAPPHIRE_AXE = register("head_sapphire_axe", 16);
        HEAD_SAPPHIRE_EXCAVATOR = register("head_sapphire_excavator", 16);
        HEAD_SAPPHIRE_HAMMER = register("head_sapphire_hammer", 16);
        HEAD_SAPPHIRE_HOE = register("head_sapphire_hoe", 16);
        HEAD_SAPPHIRE_PICKAXE = register("head_sapphire_pickaxe", 16);
        HEAD_SAPPHIRE_SHOVEL = register("head_sapphire_shovel", 16);
        HEAD_SAPPHIRE_SWORD = register("head_sapphire_sword", 16);

        HEAD_STONE_HAMMER = register("head_stone_hammer", 16);
        HEAD_STONE_EXCAVATOR = register("head_stone_excavator", 16);
        HEAD_WOOD_HAMMER = register("head_wood_hammer", 16);
        HEAD_WOOD_EXCAVATOR = register("head_wood_excavator", 16);
        //endregion
        //region CITRINE TOOLS
        TOOL_CITRINE_AXE = registerTool("tool_citrine_axe", ModToolMaterials.CITRINE, 0.0f, 0.0f, AxeItem::new);
        TOOL_CITRINE_HOE = registerTool("tool_citrine_hoe", ModToolMaterials.CITRINE, 0.0f, 0.0f, HoeItem::new);
        TOOL_CITRINE_PICKAXE = registerTool("tool_citrine_pickaxe", ModToolMaterials.CITRINE, 1.0f, -2.8f, PickaxeItem::new);
        TOOL_CITRINE_SHOVEL = registerTool("tool_citrine_shovel", ModToolMaterials.CITRINE, 0.0f, 0.0f, ShovelItem::new);
        TOOL_CITRINE_SWORD = registerTool("tool_citrine_sword", ModToolMaterials.CITRINE, 3.0f, -0.5f, CitrineSword::new);
        TOOL_CITRINE_EXCAVATOR = registerTool("tool_citrine_excavator", ModToolMaterials.CITRINE, 0.0f, 0.0f, ExcavatorItem::new)
                .setDepth(Configs.CITRINE_EXCAVATOR_DEPTH).setRadius(Configs.CITRINE_EXCAVATOR_WIDTH);
        TOOL_CITRINE_HAMMER = registerTool("tool_citrine_hammer", ModToolMaterials.CITRINE, 1.0f, -2.0f, HammerItem::new)
                .setDepth(Configs.CITRINE_HAMMER_DEPTH).setRadius(Configs.CITRINE_HAMMER_WIDTH);
        //endregion
        //region COPPER TOOLS
        TOOL_COPPER_AXE = registerTool("tool_copper_axe", ModToolMaterials.COPPER, 6.0f, -1.5f, AxeItem::new);
        TOOL_COPPER_HOE = registerTool("tool_copper_hoe", ModToolMaterials.COPPER, 0.0f, 0.0f, HoeItem::new);
        TOOL_COPPER_PICKAXE = registerTool("tool_copper_pickaxe", ModToolMaterials.COPPER, 1.0f, -1.0f, PickaxeItem::new);
        TOOL_COPPER_SHOVEL = registerTool("tool_copper_shovel", ModToolMaterials.COPPER, 0.0f, 0.0f, ShovelItem::new);
        TOOL_COPPER_SWORD = registerTool("tool_copper_sword", ModToolMaterials.COPPER, 3.0f, -2.4f, CopperSword::new);
        TOOL_COPPER_EXCAVATOR = registerTool("tool_copper_excavator", ModToolMaterials.COPPER, 0.0f, 0.0f, ExcavatorItem::new)
                .setDepth(Configs.COPPER_EXCAVATOR_DEPTH).setRadius(Configs.COPPER_EXCAVATOR_WIDTH);
        TOOL_COPPER_HAMMER = registerTool("tool_copper_hammer", ModToolMaterials.COPPER, 1.0f, -2.8f, HammerItem::new)
                .setDepth(Configs.COPPER_HAMMER_DEPTH).setRadius(Configs.COPPER_HAMMER_WIDTH);
        //endregion
        //region ENDERITE TOOLS
        TOOL_ENDERITE_AXE = registerTool("tool_enderite_axe", ModToolMaterials.ENDERITE, 20.0f, -2.5f, AxeItem::new);
        TOOL_ENDERITE_HOE = registerTool("tool_enderite_hoe", ModToolMaterials.ENDERITE, 0.0f, 0.0f, HoeItem::new);
        TOOL_ENDERITE_PICKAXE = registerTool("tool_enderite_pickaxe", ModToolMaterials.ENDERITE, 1.0f, -1.0f, PickaxeItem::new);
        TOOL_ENDERITE_SHOVEL = registerTool("tool_enderite_shovel", ModToolMaterials.ENDERITE, 0.0f, 0.0f, ShovelItem::new);
        TOOL_ENDERITE_SWORD = registerTool("tool_enderite_sword", ModToolMaterials.ENDERITE, 3.0f, 3.0f, EnderiteSword::new);
        TOOL_ENDERITE_EXCAVATOR = registerTool("tool_enderite_excavator", ModToolMaterials.ENDERITE, 0.0f, 0.0f, ExcavatorItem::new)
                .setDepth(Configs.ENDERITE_EXCAVATOR_DEPTH).setRadius(Configs.ENDERITE_EXCAVATOR_WIDTH);
        TOOL_ENDERITE_HAMMER = registerTool("tool_enderite_hammer", ModToolMaterials.ENDERITE, 1.0f, -2.8f, HammerItem::new)
                .setDepth(Configs.ENDERITE_HAMMER_DEPTH).setRadius(Configs.ENDERITE_HAMMER_WIDTH);

        //endregion
        //region RUBY TOOLS
        TOOL_RUBY_AXE = registerTool("tool_ruby_axe", ModToolMaterials.RUBY, 5.0f, -1.5f, AxeItem::new);
        TOOL_RUBY_HOE = registerTool("tool_ruby_hoe", ModToolMaterials.RUBY, 0.0f, 0.0f, HoeItem::new);
        TOOL_RUBY_PICKAXE = registerTool("tool_ruby_pickaxe", ModToolMaterials.RUBY, 1.0f, -1.0f, PickaxeItem::new);
        TOOL_RUBY_SHOVEL = registerTool("tool_ruby_shovel", ModToolMaterials.RUBY, 0.0f, 0.0f, ShovelItem::new);
        TOOL_RUBY_SWORD = registerTool("tool_ruby_sword", ModToolMaterials.RUBY, 4.0f, -0.5f, RubySword::new);
        TOOL_RUBY_EXCAVATOR = registerTool("tool_ruby_excavator", ModToolMaterials.RUBY, 0.0f, 0.0f, ExcavatorItem::new)
                .setDepth(Configs.RUBY_EXCAVATOR_DEPTH).setRadius(Configs.RUBY_EXCAVATOR_WIDTH);
        TOOL_RUBY_HAMMER = registerTool("tool_ruby_hammer", ModToolMaterials.RUBY, 1.0f, -2.8f, HammerItem::new)
                .setDepth(Configs.RUBY_HAMMER_DEPTH).setRadius(Configs.RUBY_HAMMER_WIDTH);
        //endregion
        //region SAPPHIRE TOOLS
        TOOL_SAPPHIRE_AXE = registerTool("tool_sapphire_axe", ModToolMaterials.SAPPHIRE, 5.0f, -1.5f, AxeItem::new);
        TOOL_SAPPHIRE_HOE = registerTool("tool_sapphire_hoe", ModToolMaterials.SAPPHIRE, 0.0f, 0.0f, HoeItem::new);
        TOOL_SAPPHIRE_PICKAXE = registerTool("tool_sapphire_pickaxe", ModToolMaterials.SAPPHIRE, 1.0f, -1.0f, PickaxeItem::new);
        TOOL_SAPPHIRE_SHOVEL = registerTool("tool_sapphire_shovel", ModToolMaterials.SAPPHIRE, 0.0f, 0.0f, ShovelItem::new);
        TOOL_SAPPHIRE_SWORD = registerTool("tool_sapphire_sword", ModToolMaterials.SAPPHIRE, 4.0f, -0.5f, SapphireSword::new);
        TOOL_SAPPHIRE_EXCAVATOR = registerTool("tool_sapphire_excavator", ModToolMaterials.SAPPHIRE, 0.0f, 0.0f, ExcavatorItem::new)
                .setDepth(Configs.SAPPHIRE_EXCAVATOR_DEPTH).setRadius(Configs.SAPPHIRE_EXCAVATOR_WIDTH);
        TOOL_SAPPHIRE_HAMMER = registerTool("tool_sapphire_hammer", ModToolMaterials.SAPPHIRE, 1.0f, -2.8f, HammerItem::new)
                .setDepth(Configs.SAPPHIRE_HAMMER_DEPTH).setRadius(Configs.SAPPHIRE_HAMMER_WIDTH);
        //endregion
        //region VANILLA HAMMERS
        TOOL_DIAMOND_EXCAVATOR = registerTool("tool_diamond_excavator", ToolMaterial.DIAMOND, 0.0f, 0.0f, ExcavatorItem::new)
                .setDepth(Configs.DIAMOND_EXCAVATOR_DEPTH).setRadius(Configs.DIAMOND_EXCAVATOR_WIDTH);
        TOOL_DIAMOND_HAMMER = registerTool("tool_diamond_hammer", ToolMaterial.DIAMOND, 1.0f, -2.8f, HammerItem::new)
                .setDepth(Configs.DIAMOND_HAMMER_DEPTH).setRadius(Configs.DIAMOND_HAMMER_WIDTH);
        TOOL_GOLD_EXCAVATOR = registerTool("tool_gold_excavator", ToolMaterial.GOLD, 0.0f, 0.0f, ExcavatorItem::new)
                .setDepth(Configs.GOLD_EXCAVATOR_DEPTH).setRadius(Configs.GOLD_EXCAVATOR_WIDTH);
        TOOL_GOLD_HAMMER = registerTool("tool_gold_hammer", ToolMaterial.GOLD, 1.0f, -2.8f, HammerItem::new)
                .setDepth(Configs.GOLD_HAMMER_DEPTH).setRadius(Configs.GOLD_HAMMER_WIDTH);
        TOOL_IRON_EXCAVATOR = registerTool("tool_iron_excavator", ToolMaterial.IRON, 0.0f, 0.0f, ExcavatorItem::new)
                .setDepth(Configs.IRON_EXCAVATOR_DEPTH).setRadius(Configs.IRON_EXCAVATOR_WIDTH);
        TOOL_IRON_HAMMER = registerTool("tool_iron_hammer", ToolMaterial.IRON, 1.0f, -2.8f, HammerItem::new)
                .setDepth(Configs.IRON_HAMMER_DEPTH).setRadius(Configs.IRON_HAMMER_WIDTH);
        TOOL_NETHERITE_EXCAVATOR = registerTool("tool_netherite_excavator", ToolMaterial.NETHERITE, 0.0f, 0.0f, ExcavatorItem::new)
                .setDepth(Configs.NETHERITE_EXCAVATOR_DEPTH).setRadius(Configs.NETHERITE_EXCAVATOR_WIDTH);
        TOOL_NETHERITE_HAMMER = registerTool("tool_netherite_hammer", ToolMaterial.NETHERITE, 1.0f, -2.8f, HammerItem::new)
                .setDepth(Configs.NETHERITE_HAMMER_DEPTH).setRadius(Configs.NETHERITE_HAMMER_WIDTH);
        TOOL_STONE_EXCAVATOR = registerTool("tool_stone_excavator", ToolMaterial.STONE, 0.0f, 0.0f, ExcavatorItem::new)
                .setDepth(Configs.STONE_EXCAVATOR_DEPTH).setRadius(Configs.STONE_EXCAVATOR_WIDTH);
        TOOL_STONE_HAMMER = registerTool("tool_stone_hammer", ToolMaterial.STONE, 1.0f, -2.8f, HammerItem::new)
                .setDepth(Configs.STONE_HAMMER_DEPTH).setRadius(Configs.STONE_HAMMER_WIDTH);
        TOOL_WOOD_EXCAVATOR = registerTool("tool_wood_excavator", ToolMaterial.WOOD, 0.0f, 0.0f, ExcavatorItem::new)
                .setDepth(Configs.WOOD_EXCAVATOR_DEPTH).setRadius(Configs.WOOD_EXCAVATOR_WIDTH);
        TOOL_WOOD_HAMMER = registerTool("tool_wood_hammer", ToolMaterial.WOOD, 1.0f, -2.8f, HammerItem::new)
                .setDepth(Configs.WOOD_HAMMER_DEPTH).setRadius(Configs.WOOD_HAMMER_WIDTH);
        //endregion
        //region TOOL
        BACKPACK = register("backpack", 1, BackpackItem::new);
        ENDER_BACKPACK = register("ender_backpack", 1, EnderBackpackItem::new);
        BLUEPRINT_EMPTY = register("blueprint_empty", 1);
        BLUEPRINT_PRINTED = register("blueprint_printed", 1, BlueprintItem::new);
        PLAYER_TELEPORT = register("tool_player_teleport", 1, PlayerTeleporter::new);
        TUNER = register("tool_tuner", 1, TunerItem::new);
        ADVANCED_TUNER = register("tool_tuner_advanced", 1, AdvancedTuner::new);
        WRENCH = register("tool_wrench", 1, WrenchItem::new);
        CHALICE = register("chalice", 1, ChaliceItem::new);
        CHALICE_EMPTY = register("chalice_empty", 1);
        //endregion
        //region AMETHYST ARMOR
        ARMOR_AMETHYST_HELMET = registerArmor("armor_amethyst_helmet", ModArmorMaterials.AMETHYST, EquipmentType.HELMET, ArmorItem::new);
        ARMOR_AMETHYST_CHESTPLATE = registerArmor("armor_amethyst_chestplate", ModArmorMaterials.AMETHYST, EquipmentType.CHESTPLATE, ArmorItem::new);
        ARMOR_AMETHYST_LEGGINGS = registerArmor("armor_amethyst_leggings", ModArmorMaterials.AMETHYST, EquipmentType.LEGGINGS, ArmorItem::new);
        ARMOR_AMETHYST_BOOTS = registerArmor("armor_amethyst_boots", ModArmorMaterials.AMETHYST, EquipmentType.BOOTS, ArmorItem::new);
        //endregion
        //region CITRINE ARMOR
        ARMOR_CITRINE_HELMET = registerArmor("armor_citrine_helmet", ModArmorMaterials.CITRINE, EquipmentType.HELMET, ArmorItem::new);
        ARMOR_CITRINE_CHESTPLATE = registerArmor("armor_citrine_chestplate", ModArmorMaterials.CITRINE, EquipmentType.CHESTPLATE, ArmorItem::new);
        ARMOR_CITRINE_LEGGINGS = registerArmor("armor_citrine_leggings", ModArmorMaterials.CITRINE, EquipmentType.LEGGINGS, ArmorItem::new);
        ARMOR_CITRINE_BOOTS = registerArmor("armor_citrine_boots", ModArmorMaterials.CITRINE, EquipmentType.BOOTS, ArmorItem::new);
        //endregion
        //region COPPER ARMOR
        ARMOR_COPPER_HELMET = registerArmor("armor_copper_helmet", ModArmorMaterials.COPPER, EquipmentType.HELMET, ArmorItem::new);
        ARMOR_COPPER_CHESTPLATE = registerArmor("armor_copper_chestplate", ModArmorMaterials.COPPER, EquipmentType.CHESTPLATE, ArmorItem::new);
        ARMOR_COPPER_LEGGINGS = registerArmor("armor_copper_leggings", ModArmorMaterials.COPPER, EquipmentType.LEGGINGS, ArmorItem::new);
        ARMOR_COPPER_BOOTS = registerArmor("armor_copper_boots", ModArmorMaterials.COPPER, EquipmentType.BOOTS, ArmorItem::new);
        //endregion
        //region EMERALD ARMOR
        ARMOR_EMERALD_HELMET = registerArmor("armor_emerald_helmet", ModArmorMaterials.EMERALD, EquipmentType.HELMET, ArmorItem::new);
        ARMOR_EMERALD_CHESTPLATE = registerArmor("armor_emerald_chestplate", ModArmorMaterials.EMERALD, EquipmentType.CHESTPLATE, ArmorItem::new);
        ARMOR_EMERALD_LEGGINGS = registerArmor("armor_emerald_leggings", ModArmorMaterials.EMERALD, EquipmentType.LEGGINGS, ArmorItem::new);
        ARMOR_EMERALD_BOOTS = registerArmor("armor_emerald_boots", ModArmorMaterials.EMERALD, EquipmentType.BOOTS, ArmorItem::new);
        //endregion
        //region ENDERITE ARMOR
        ARMOR_ENDERITE_HELMET = registerArmor("armor_enderite_helmet", ModArmorMaterials.ENDERITE, EquipmentType.HELMET, ArmorItem::new);
        ARMOR_ENDERITE_CHESTPLATE = registerArmor("armor_enderite_chestplate", ModArmorMaterials.ENDERITE, EquipmentType.CHESTPLATE, ArmorItem::new);
        ARMOR_ENDERITE_LEGGINGS = registerArmor("armor_enderite_leggings", ModArmorMaterials.ENDERITE, EquipmentType.LEGGINGS, ArmorItem::new);
        ARMOR_ENDERITE_BOOTS = registerArmor("armor_enderite_boots", ModArmorMaterials.ENDERITE, EquipmentType.BOOTS, ArmorItem::new);
        //endregion
        //region RUBY ARMOR
        ARMOR_RUBY_HELMET = registerArmor("armor_ruby_helmet", ModArmorMaterials.RUBY, EquipmentType.HELMET, ArmorItem::new);
        ARMOR_RUBY_CHESTPLATE = registerArmor("armor_ruby_chestplate", ModArmorMaterials.RUBY, EquipmentType.CHESTPLATE, ArmorItem::new);
        ARMOR_RUBY_LEGGINGS = registerArmor("armor_ruby_leggings", ModArmorMaterials.RUBY, EquipmentType.LEGGINGS, ArmorItem::new);
        ARMOR_RUBY_BOOTS = registerArmor("armor_ruby_boots", ModArmorMaterials.RUBY, EquipmentType.BOOTS, ArmorItem::new);
        //endregion
        //region SAPPHIRE ARMOR
        ARMOR_SAPPHIRE_HELMET = registerArmor("armor_sapphire_helmet", ModArmorMaterials.SAPPHIRE, EquipmentType.HELMET, ArmorItem::new);
        ARMOR_SAPPHIRE_CHESTPLATE = registerArmor("armor_sapphire_chestplate", ModArmorMaterials.SAPPHIRE, EquipmentType.CHESTPLATE, ArmorItem::new);
        ARMOR_SAPPHIRE_LEGGINGS = registerArmor("armor_sapphire_leggings", ModArmorMaterials.SAPPHIRE, EquipmentType.LEGGINGS, ArmorItem::new);
        ARMOR_SAPPHIRE_BOOTS = registerArmor("armor_sapphire_boots", ModArmorMaterials.SAPPHIRE, EquipmentType.BOOTS, ArmorItem::new);
        //endregion
    }

    /**
     * Adds custom items to specific vanilla item groups for better
     * organization and accessibility in the game.
     *
     * <p>
     * This method enhances the user experience by categorizing items
     * into appropriate item groups, making it easier for players to
     * locate them within the inventory and creative mode's item
     * menu. It is particularly useful for mods with numerous custom
     * items, helping to avoid clutter and improving the overall
     * navigation through item lists.
     * </p>
     * <p>
     * The method currently contains commented-out logic for adding a
     * specific item (e.g., {@code RUBBER}) to the building blocks
     * item group. Additional entries can be modified or added in future
     * updates.
     * </p>
     */
    public static void addToItemGroups()
    {
        log("Adding Items to Item Groups");

        /*ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries ->
                                                                                {
                                                                                    entries.add(RUBBER);
                                                                                });*/
    }

    /**
     * Configures or sets the blacklist for items that should be excluded
     * from certain functionalities within the mod.
     *
     * <p>
     * This method provides a mechanism to define specific items that will
     * not be available for crafting, usage, or other interactions, allowing
     * for greater control over the game's mechanics and item utilization.
     * While the currently implemented version of this method is empty,
     * it is intended for future development where specific items can
     * be added to or removed from the blacklist.
     * </p>
     */
    public static void setBlackList()
    {
    }
}