package jiraiyah.uio.registry;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static jiraiyah.uio.Reference.identifier;
import static jiraiyah.uio.Reference.log;

public class ModItems
{
    public static final Item BINDING_STRING = registerItem("binding_string", new Item(new Item.Settings()));

    //region CAST
    public static final Item CAST_AXE = registerItem("cast_axe", new Item(new Item.Settings()));
    public static final Item CAST_BINDING = registerItem("cast_binding", new Item(new Item.Settings()));
    public static final Item CAST_GEAR = registerItem("cast_gear", new Item(new Item.Settings()));
    public static final Item CAST_GEM = registerItem("cast_gem", new Item(new Item.Settings()));
    public static final Item CAST_HAMMER = registerItem("cast_hammer", new Item(new Item.Settings()));
    public static final Item CAST_HANDLE = registerItem("cast_handle", new Item(new Item.Settings()));
    public static final Item CAST_HOE = registerItem("cast_hoe", new Item(new Item.Settings()));
    public static final Item CAST_INGOT = registerItem("cast_ingot", new Item(new Item.Settings()));
    public static final Item CAST_NUGGET = registerItem("cast_nugget", new Item(new Item.Settings()));
    public static final Item CAST_PICKAXE = registerItem("cast_pickaxe", new Item(new Item.Settings()));
    public static final Item CAST_PLATE = registerItem("cast_plate", new Item(new Item.Settings()));
    public static final Item CAST_ROD = registerItem("cast_rod", new Item(new Item.Settings()));
    public static final Item CAST_SHOVEL = registerItem("cast_shovel", new Item(new Item.Settings()));
    public static final Item CAST_SWORD = registerItem("cast_sword", new Item(new Item.Settings()));
    public static final Item CAST_WIRE = registerItem("cast_wire", new Item(new Item.Settings()));
    public static final Item CAST_WOOD_INGOT = registerItem("cast_wood_ingot", new Item(new Item.Settings()));
    public static final Item CAST_WOOD_PICKAXE = registerItem("cast_wood_pickaxe", new Item(new Item.Settings()));
    //endregion

    //region RAW
    public static final Item RAW_CITRINE = registerItem("raw_citrine", new Item(new Item.Settings()));
    public static final Item RAW_ENDERITE = registerItem("raw_enderite", new Item(new Item.Settings()));
    public static final Item RAW_QUARTZ = registerItem("raw_quartz", new Item(new Item.Settings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new Item.Settings()));
    public static final Item RAW_SAPPHIRE = registerItem("raw_sapphire", new Item(new Item.Settings()));
    //endregion

    //region GEMS
    public static final Item GEM_CITRINE = registerItem("gem_citrine", new Item(new Item.Settings()));
    public static final Item GEM_RUBY = registerItem("gem_ruby", new Item(new Item.Settings()));
    public static final Item GEM_SAPPHIRE = registerItem("gem_sapphire", new Item(new Item.Settings()));
    //endregion

    //region DUST
    public static final Item DUST_CONDUCTIVE = registerItem("dust_conductive", new Item(new Item.Settings()));
    public static final Item DUST_COPPER = registerItem("dust_copper", new Item(new Item.Settings()));
    public static final Item DUST_ENDERITE = registerItem("dust_enderite", new Item(new Item.Settings()));
    public static final Item DUST_ENERGETIC = registerItem("dust_energetic", new Item(new Item.Settings()));
    public static final Item DUST_GOLD = registerItem("dust_gold", new Item(new Item.Settings()));
    public static final Item DUST_IRON = registerItem("dust_iron", new Item(new Item.Settings()));
    public static final Item DUST_OBSIDIAN = registerItem("dust_obsidian", new Item(new Item.Settings()));
    public static final Item DUST_PULSATING = registerItem("dust_pulsating", new Item(new Item.Settings()));
    public static final Item DUST_RED_ALLOY = registerItem("dust_red_alloy", new Item(new Item.Settings()));
    public static final Item DUST_SOUL = registerItem("dust_soul", new Item(new Item.Settings()));
    public static final Item DUST_VIBRANT = registerItem("dust_vibrant", new Item(new Item.Settings()));
    public static final Item DUST_WITHERING = registerItem("dust_withering", new Item(new Item.Settings()));
    //endregion

    //region GEAR
    public static final Item GEAR_COPPER = registerItem("gear_copper", new Item(new Item.Settings()));
    public static final Item GEAR_DIAMOND = registerItem("gear_diamond", new Item(new Item.Settings()));
    public static final Item GEAR_EMERALD = registerItem("gear_emerald", new Item(new Item.Settings()));
    public static final Item GEAR_ENDERITE = registerItem("gear_enderite", new Item(new Item.Settings()));
    public static final Item GEAR_ENERGIZED = registerItem("gear_energized", new Item(new Item.Settings()));
    public static final Item GEAR_GOLD = registerItem("gear_gold", new Item(new Item.Settings()));
    public static final Item GEAR_IRON = registerItem("gear_iron", new Item(new Item.Settings()));
    public static final Item GEAR_LAPIS = registerItem("gear_lapis", new Item(new Item.Settings()));
    public static final Item GEAR_NETHERITE = registerItem("gear_netherite", new Item(new Item.Settings()));
    public static final Item GEAR_OBSIDIAN = registerItem("gear_obsidian", new Item(new Item.Settings()));
    public static final Item GEAR_PRISMARINE = registerItem("gear_prismarine", new Item(new Item.Settings()));
    public static final Item GEAR_QUARTZ = registerItem("gear_quartz", new Item(new Item.Settings()));
    public static final Item GEAR_RUBY = registerItem("gear_ruby", new Item(new Item.Settings()));
    public static final Item GEAR_SAPPHIRE = registerItem("gear_sapphire", new Item(new Item.Settings()));
    public static final Item GEAR_STONE = registerItem("gear_stone", new Item(new Item.Settings()));
    public static final Item GEAR_VIBRANT = registerItem("gear_vibrant", new Item(new Item.Settings()));
    public static final Item GEAR_WOOD = registerItem("gear_wood", new Item(new Item.Settings()));
    //endregion

    //region INGOT
    public static final Item INGOT_ALLOY_CONDUCTIVE = registerItem("ingot_alloy_conductive", new Item(new Item.Settings()));
    public static final Item INGOT_ALLOY_ENERGETIC = registerItem("ingot_alloy_energetic", new Item(new Item.Settings()));
    public static final Item INGOT_ALLOY_PULSATING = registerItem("ingot_alloy_pulsating", new Item(new Item.Settings()));
    public static final Item INGOT_ALLOY_RED = registerItem("ingot_alloy_red", new Item(new Item.Settings()));
    public static final Item INGOT_ALLOY_VIBRANT = registerItem("ingot_alloy_vibrant", new Item(new Item.Settings()));

    public static final Item INGOT_ENDERITE = registerItem("ingot_enderite", new Item(new Item.Settings()));
    //endregion

    //region PLATE
    public static final Item PLATE_AMETHYST = registerItem("plate_amethyst", new Item(new Item.Settings()));
    public static final Item PLATE_CITRINE = registerItem("plate_citrine", new Item(new Item.Settings()));
    public static final Item PLATE_COPPER = registerItem("plate_copper", new Item(new Item.Settings()));
    public static final Item PLATE_DIAMOND = registerItem("plate_diamond", new Item(new Item.Settings()));
    public static final Item PLATE_EMERALD = registerItem("plate_emerald", new Item(new Item.Settings()));
    public static final Item PLATE_ENDERITE = registerItem("plate_enderite", new Item(new Item.Settings()));
    public static final Item PLATE_GOLD = registerItem("plate_gold", new Item(new Item.Settings()));
    public static final Item PLATE_IRON = registerItem("plate_iron", new Item(new Item.Settings()));
    public static final Item PLATE_NETHERITE = registerItem("plate_netherite", new Item(new Item.Settings()));
    public static final Item PLATE_RUBY = registerItem("plate_ruby", new Item(new Item.Settings()));
    public static final Item PLATE_SAPPHIRE = registerItem("plate_sapphire", new Item(new Item.Settings()));
    public static final Item PLATE_STONE = registerItem("plate_stone", new Item(new Item.Settings()));
    //endregion

    //region REINFORCED
    public static final Item REINFORCED_AMETHYST = registerItem("reinforced_amethyst", new Item(new Item.Settings()));
    public static final Item REINFORCED_CITRINE = registerItem("reinforced_citrine", new Item(new Item.Settings()));
    public static final Item REINFORCED_COPPER = registerItem("reinforced_copper", new Item(new Item.Settings()));
    public static final Item REINFORCED_DIAMOND = registerItem("reinforced_diamond", new Item(new Item.Settings()));
    public static final Item REINFORCED_EMERALD = registerItem("reinforced_emerald", new Item(new Item.Settings()));
    public static final Item REINFORCED_ENDERITE = registerItem("reinforced_enderite", new Item(new Item.Settings()));
    public static final Item REINFORCED_GOLD = registerItem("reinforced_gold", new Item(new Item.Settings()));
    public static final Item REINFORCED_IRON = registerItem("reinforced_iron", new Item(new Item.Settings()));
    public static final Item REINFORCED_NETHERITE = registerItem("reinforced_netherite", new Item(new Item.Settings()));
    public static final Item REINFORCED_RUBY = registerItem("reinforced_ruby", new Item(new Item.Settings()));
    public static final Item REINFORCED_SAPPHIRE = registerItem("reinforced_sapphire", new Item(new Item.Settings()));
    //endregion

    //region ROD
    public static final Item ROD_COPPER = registerItem("rod_copper", new Item(new Item.Settings()));
    public static final Item ROD_ENDERITE = registerItem("rod_enderite", new Item(new Item.Settings()));
    public static final Item ROD_GLOWSTONE = registerItem("rod_glowstone", new Item(new Item.Settings()));
    public static final Item ROD_GOLD = registerItem("rod_gold", new Item(new Item.Settings()));
    public static final Item ROD_IRON = registerItem("rod_iron", new Item(new Item.Settings()));
    public static final Item ROD_OBSIDIAN = registerItem("rod_obsidian", new Item(new Item.Settings()));
    public static final Item ROD_REDSTONE = registerItem("rod_redstone", new Item(new Item.Settings()));
    //endregion

    //region HEADS
    public static final Item HEAD_CITRINE_AXE = registerItem("head_citrine_axe", new Item(new Item.Settings()));
    public static final Item HEAD_CITRINE_HAMMER = registerItem("head_citrine_hammer", new Item(new Item.Settings()));
    public static final Item HEAD_CITRINE_HOE = registerItem("head_citrine_hoe", new Item(new Item.Settings()));
    public static final Item HEAD_CITRINE_PICKAXE = registerItem("head_citrine_pickaxe", new Item(new Item.Settings()));
    public static final Item HEAD_CITRINE_SHOVEL = registerItem("head_citrine_shovel", new Item(new Item.Settings()));
    public static final Item HEAD_CITRINE_SWORD = registerItem("head_citrine_sword", new Item(new Item.Settings()));

    public static final Item HEAD_COPPER_AXE = registerItem("head_copper_axe", new Item(new Item.Settings()));
    public static final Item HEAD_COPPER_HAMMER = registerItem("head_copper_hammer", new Item(new Item.Settings()));
    public static final Item HEAD_COPPER_HOE = registerItem("head_copper_hoe", new Item(new Item.Settings()));
    public static final Item HEAD_COPPER_PICKAXE = registerItem("head_copper_pickaxe", new Item(new Item.Settings()));
    public static final Item HEAD_COPPER_SHOVEL = registerItem("head_copper_shovel", new Item(new Item.Settings()));
    public static final Item HEAD_COPPER_SWORD = registerItem("head_copper_sword", new Item(new Item.Settings()));

    public static final Item HEAD_DIAMOND_AXE = registerItem("head_diamond_axe", new Item(new Item.Settings()));
    public static final Item HEAD_DIAMOND_HAMMER = registerItem("head_diamond_hammer", new Item(new Item.Settings()));
    public static final Item HEAD_DIAMOND_HOE = registerItem("head_diamond_hoe", new Item(new Item.Settings()));
    public static final Item HEAD_DIAMOND_PICKAXE = registerItem("head_diamond_pickaxe", new Item(new Item.Settings()));
    public static final Item HEAD_DIAMOND_SHOVEL = registerItem("head_diamond_shovel", new Item(new Item.Settings()));
    public static final Item HEAD_DIAMOND_SWORD = registerItem("head_diamond_sword", new Item(new Item.Settings()));

    public static final Item HEAD_ENDERITE_AXE = registerItem("head_enderite_axe", new Item(new Item.Settings()));
    public static final Item HEAD_ENDERITE_HAMMER = registerItem("head_enderite_hammer", new Item(new Item.Settings()));
    public static final Item HEAD_ENDERITE_HOE = registerItem("head_enderite_hoe", new Item(new Item.Settings()));
    public static final Item HEAD_ENDERITE_PICKAXE = registerItem("head_enderite_pickaxe", new Item(new Item.Settings()));
    public static final Item HEAD_ENDERITE_SHOVEL = registerItem("head_enderite_shovel", new Item(new Item.Settings()));
    public static final Item HEAD_ENDERITE_SWORD = registerItem("head_enderite_sword", new Item(new Item.Settings()));

    public static final Item HEAD_GOLD_AXE = registerItem("head_gold_axe", new Item(new Item.Settings()));
    public static final Item HEAD_GOLD_HAMMER = registerItem("head_gold_hammer", new Item(new Item.Settings()));
    public static final Item HEAD_GOLD_HOE = registerItem("head_gold_hoe", new Item(new Item.Settings()));
    public static final Item HEAD_GOLD_PICKAXE = registerItem("head_gold_pickaxe", new Item(new Item.Settings()));
    public static final Item HEAD_GOLD_SHOVEL = registerItem("head_gold_shovel", new Item(new Item.Settings()));
    public static final Item HEAD_GOLD_SWORD = registerItem("head_gold_sword", new Item(new Item.Settings()));

    public static final Item HEAD_IRON_AXE = registerItem("head_iron_axe", new Item(new Item.Settings()));
    public static final Item HEAD_IRON_HAMMER = registerItem("head_iron_hammer", new Item(new Item.Settings()));
    public static final Item HEAD_IRON_HOE = registerItem("head_iron_hoe", new Item(new Item.Settings()));
    public static final Item HEAD_IRON_PICKAXE = registerItem("head_iron_pickaxe", new Item(new Item.Settings()));
    public static final Item HEAD_IRON_SHOVEL = registerItem("head_iron_shovel", new Item(new Item.Settings()));
    public static final Item HEAD_IRON_SWORD = registerItem("head_iron_sword", new Item(new Item.Settings()));

    public static final Item HEAD_NETHERITE_AXE = registerItem("head_netherite_axe", new Item(new Item.Settings()));
    public static final Item HEAD_NETHERITE_HAMMER = registerItem("head_netherite_hammer", new Item(new Item.Settings()));
    public static final Item HEAD_NETHERITE_HOE = registerItem("head_netherite_hoe", new Item(new Item.Settings()));
    public static final Item HEAD_NETHERITE_PICKAXE = registerItem("head_netherite_pickaxe", new Item(new Item.Settings()));
    public static final Item HEAD_NETHERITE_SHOVEL = registerItem("head_netherite_shovel", new Item(new Item.Settings()));
    public static final Item HEAD_NETHERITE_SWORD = registerItem("head_netherite_sword", new Item(new Item.Settings()));

    public static final Item HEAD_RUBY_AXE = registerItem("head_ruby_axe", new Item(new Item.Settings()));
    public static final Item HEAD_RUBY_HAMMER = registerItem("head_ruby_hammer", new Item(new Item.Settings()));
    public static final Item HEAD_RUBY_HOE = registerItem("head_ruby_hoe", new Item(new Item.Settings()));
    public static final Item HEAD_RUBY_PICKAXE = registerItem("head_ruby_pickaxe", new Item(new Item.Settings()));
    public static final Item HEAD_RUBY_SHOVEL = registerItem("head_ruby_shovel", new Item(new Item.Settings()));
    public static final Item HEAD_RUBY_SWORD = registerItem("head_ruby_sword", new Item(new Item.Settings()));

    public static final Item HEAD_SAPPHIRE_AXE = registerItem("head_sapphire_axe", new Item(new Item.Settings()));
    public static final Item HEAD_SAPPHIRE_HAMMER = registerItem("head_sapphire_hammer", new Item(new Item.Settings()));
    public static final Item HEAD_SAPPHIRE_HOE = registerItem("head_sapphire_hoe", new Item(new Item.Settings()));
    public static final Item HEAD_SAPPHIRE_PICKAXE = registerItem("head_sapphire_pickaxe", new Item(new Item.Settings()));
    public static final Item HEAD_SAPPHIRE_SHOVEL = registerItem("head_sapphire_shovel", new Item(new Item.Settings()));
    public static final Item HEAD_SAPPHIRE_SWORD = registerItem("head_sapphire_sword", new Item(new Item.Settings()));

    public static final Item HEAD_STONE_HAMMER = registerItem("head_stone_hammer", new Item(new Item.Settings()));

    public static final Item HEAD_WOOD_HAMMER = registerItem("head_wood_hammer", new Item(new Item.Settings()));
    //endregion

    public static final Item TOOL_CITRINE_AXE = registerItem("tool_citrine_axe", new AxeItem(ModToolMaterials.CITRINE,
                                                                                             new Item.Settings().attributeModifiers(
                                                                                                     AxeItem.createAttributeModifiers(
                                                                                                             ModToolMaterials.CITRINE,
                                                                                                             6.0f, -3.1f))));

    //TODO : Add Hammer Class for Tools
    public static final Item TOOL_CITRINE_HAMMER = registerItem("tool_citrine_hammer", new AxeItem(ModToolMaterials.CITRINE,
                                                                                                   new Item.Settings().attributeModifiers(
                                                                                                           AxeItem.createAttributeModifiers(
                                                                                                                   ModToolMaterials.CITRINE,
                                                                                                                   9.0f, -1.5f))));

    public static final Item TOOL_CITRINE_HOE = registerItem("tool_citrine_hoe", new HoeItem(ModToolMaterials.CITRINE,
                                                                                             new Item.Settings().attributeModifiers(
                                                                                                     HoeItem.createAttributeModifiers(
                                                                                                             ModToolMaterials.CITRINE,
                                                                                                             -2.0f, -1.0f))));
    public static final Item TOOL_CITRINE_PICKAXE = registerItem("tool_citrine_pickaxe", new PickaxeItem(ModToolMaterials.CITRINE,
                                                                                                         new Item.Settings().attributeModifiers(
                                                                                                                 PickaxeItem.createAttributeModifiers(
                                                                                                                         ModToolMaterials.CITRINE,
                                                                                                                         1.0f, -2.8f))));
    public static final Item TOOL_CITRINE_SHOVEL = registerItem("tool_citrine_shovel", new ShovelItem(ModToolMaterials.CITRINE,
                                                                                                      new Item.Settings().attributeModifiers(
                                                                                                              ShovelItem.createAttributeModifiers(
                                                                                                                      ModToolMaterials.CITRINE,
                                                                                                                      1.5f, -3.0f))));
    public static final Item TOOL_CITRINE_SWORD = registerItem("tool_citrine_sword", new SwordItem(ModToolMaterials.CITRINE,
                                                                                                   new Item.Settings().attributeModifiers(
                                                                                                           SwordItem.createAttributeModifiers(
                                                                                                                   ModToolMaterials.CITRINE,
                                                                                                                   3, -2.4f))));

    //region TOOL
    public static final Item TOOL_PLAYER_TELEPORT = registerItem("tool_player_teleport", new Item(new Item.Settings()));
    public static final Item TOOL_TUNER = registerItem("tool_tuner", new Item(new Item.Settings()));
    public static final Item TOOL_WRENCH = registerItem("tool_wrench", new Item(new Item.Settings()));
    //endregion

    public ModItems()
    {
        throw new AssertionError();
    }

    public static void register()
    {
        log("Registering Items");
    }

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, identifier(name), item);
    }
}