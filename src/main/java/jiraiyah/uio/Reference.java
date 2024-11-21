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

package jiraiyah.uio;

import jiraiyah.reference.JiReference;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.MutableText;

/**
 * This class contains the reference information for the mod UIO.
 * It includes constants and configurations utilized throughout the mod.
 */
public class Reference extends JiReference
{
    //region ITEM GROUP NAMES AND TITLES
    public final String BLOCK_ITEM_GROUP_NAME = "_1_block_group";
    public final String INGREDIENT_ITEM_GROUP_NAME = "_5_ingredient_group";
    public final String MACHINE_ITEM_GROUP_NAME = "_2_machine_group";
    public final String TOOLS_ITEM_GROUP_NAME = "_3_tool_group";
    public final String ARMOR_ITEM_GROUP_NAME = "_4_armor_group";
    public final String MISC_ITEM_GROUP_NAME = "_6_misc_group";
    public final MutableText BLOCKS_TITLE = translate(BLOCK_ITEM_GROUP_NAME);
    public final MutableText INGREDIENT_TITLE = translate(INGREDIENT_ITEM_GROUP_NAME);
    public final MutableText MACHINES_TITLE = translate(MACHINE_ITEM_GROUP_NAME);
    public final MutableText TOOLS_TITLE = translate(TOOLS_ITEM_GROUP_NAME);
    public final MutableText ARMORS_TITLE = translate(ARMOR_ITEM_GROUP_NAME);
    public final MutableText MISC_TITLE = translate(MISC_ITEM_GROUP_NAME);
    //endregion
    //region TOOLTIPS
    public final String TUNER_TOOLTIP_ID_NAME = "tuner.tooltip";
    public final String TUNER_TELEPORTED_ID_NAME = "tuner.teleported";
    public final String TUNER_ERROR_ID_NAME = "tuner.error";
    public final String TELEPORTER_TOOLTIP_ID_NAME = "teleporter.tooltip";
    public final String HAMMER_PARAM_TOOLTIP = "hammer.tooltip";
    public final String EXCAVATOR_PARAM_TOOLTIP = "excavator.tooltip";
    //endregion
    //region COMMAND MESSAGES
    public final String DCLR_ERROR_ID_NAME = "dclr.error";
    public final String DCLR_START_ID_NAME = "dclr.start";
    public final String DCLR_END_ID_NAME = "dclr.end";
    //region BLOCK TAGS
    public final TagKey<Block> GEM_BLOCKS = createBlockCommonTag("gem_blocks");
    //endregion
    public final TagKey<Block> IS_MACHINE = createBlockCommonTag("machines");
    public final TagKey<Block> HAMMER_BLACKLIST = createBlockTag("hammer_blacklist");
    public final TagKey<Block> EXCAVATOR_BLACKLIST = createBlockTag("excavator_blacklist");
    public final TagKey<Block> INCORRECT_FOR_ENDERITE_TOOL = createBlockTag("incorrect_for_enderite_tool");
    //region ITEM TAGS
    public final TagKey<Item> FLUID_BUCKET = createItemCommonTag("fluid_buckets");
    //endregion
    public final TagKey<Item> CAST = createItemCommonTag("casts");
    public final TagKey<Item> RAW = createItemCommonTag("raws");
    public final TagKey<Item> WOOD_CAST = createItemCommonTag("wood_casts");
    public final TagKey<Item> GEAR = createItemCommonTag("gears");
    public final TagKey<Item> DUST = createItemCommonTag("dusts");
    public final TagKey<Item> INGOT = createItemCommonTag("ingots");
    public final TagKey<Item> PLATE = createItemCommonTag("plates");
    public final TagKey<Item> REINFORCED = createItemCommonTag("reinforced_plates");
    public final TagKey<Item> ROD = createItemCommonTag("rods");
    public final TagKey<Item> TOOL_HEAD = createItemCommonTag("tool_heads");
    public final TagKey<Item> ALLOY = createItemCommonTag("alloys");
    public final TagKey<Item> GEM = createItemCommonTag("gems");
    public final TagKey<Item> HAMMERS = createItemTag("hammers");
    public final TagKey<Item> EXCAVATORS = createItemTag("excavators");
    public final TagKey<Item> MENDING_ONLY = createItemTag("mending_only");
    public final TagKey<Item> SMELTABLE = createItemTag("smeltery");
    public final TagKey<Item> REPAIRS_AMETHYST_ARMOR = createItemTag("repairs_amethyst_armor");
    public final TagKey<Item> REPAIRS_CITRINE_ARMOR = createItemTag("repairs_citrine_armor");
    public final TagKey<Item> REPAIRS_COPPER_ARMOR = createItemTag("repairs_copper_armor");
    public final TagKey<Item> REPAIRS_EMERALD_ARMOR = createItemTag("repairs_emerald_armor");
    public final TagKey<Item> REPAIRS_ENDERITE_ARMOR = createItemTag("repairs_enderite_armor");
    public final TagKey<Item> REPAIRS_RUBY_ARMOR = createItemTag("repairs_ruby_armor");
    public final TagKey<Item> REPAIRS_SAPPHIRE_ARMOR = createItemTag("repairs_sapphire_armor");
    public final TagKey<Item> REPAIRS_CITRINE_TOOL = createItemTag("repairs_citrine_tool");
    public final TagKey<Item> REPAIRS_COPPER_TOOL = createItemTag("repairs_copper_tool");
    public final TagKey<Item> REPAIRS_ENDERITE_TOOL = createItemTag("repairs_enderite_tool");
    public final TagKey<Item> REPAIRS_RUBY_TOOL = createItemTag("repairs_ruby_tool");
    public final TagKey<Item> REPAIRS_SAPPHIRE_TOOL = createItemTag("repairs_sapphire_tool");
    public final TagKey<Item> AMETHYST_ARMOR_TYPE = createItemTag("amethyst_armor_type");
    public final TagKey<Item> CITRINE_ARMOR_TYPE = createItemTag("citrine_armor_type");
    public final TagKey<Item> COPPER_ARMOR_TYPE = createItemTag("copper_armor_type");
    public final TagKey<Item> EMERALD_ARMOR_TYPE = createItemTag("emerald_armor_type");
    public final TagKey<Item> ENDERITE_ARMOR_TYPE = createItemTag("enderite_armor_type");
    public final TagKey<Item> RUBY_ARMOR_TYPE = createItemTag("ruby_armor_type");
    public final TagKey<Item> SAPPHIRE_ARMOR_TYPE = createItemTag("sapphire_armor_type");
    //region ENTITY TAGS
    public final TagKey<EntityType<?>> TUNER_BLACKLIST = createEntityTag("tuner_blacklist");
    //endregion
    public final TagKey<EntityType<?>> RUBY_SWORD_WHITELIST = createEntityTag("ruby_sword_whitelist");
    public final TagKey<EntityType<?>> ENDERITE_SWORD_BLACKLIST = createEntityTag("enderite_sword_blacklist");
    public Reference(String mod_ID)
    {
        super(mod_ID);
    }
    //endregion

    /**
     * A utility class that contains constants and methods related to configuration keys
     * used within the UIO mod. This class serves as a centralized repository for
     * managing configuration key identifiers, enabling better organization and
     * consistent usage of keys associated with configurable settings in the mod.
     * The `config` subclass may be used to define key constants that are specific
     * to configuration parameters, ensuring adherence to naming conventions
     * and enhancing the readability of key identifiers throughout the mod's code.
     */
    public static class ConfigKeys
    {
        public static final String DCLR = "dclr.command.radius";
        public static final String CITRINE_SWORD_DURATION = "citrine.sword.effect.duration";
        public static final String COPPER_SWORD_DURATION = "copper.sword.effect.duration";
        public static final String SAPPHIRE_SWORD_DURATION = "sapphire.sword.effect.duration";
        public static final String SAPPHIRE_SWORD_MULTIPLIER = "sapphire.sword.velocity.multiplier";
        public static final String EXCAVATOR_MAX_DISTANCE = "excavator.max.distance";
        public static final String HAMMER_MAX_DISTANCE = "hammer.max.distance";
        public static final String CITRINE_EXCAVATOR_WIDTH = "citrine.excavator.width";
        public static final String CITRINE_EXCAVATOR_DEPTH = "citrine.excavator.depth";
        public static final String CITRINE_HAMMER_WIDTH = "citrine.hammer.width";
        public static final String CITRINE_HAMMER_DEPTH = "citrine.hammer.depth";
        public static final String COPPER_EXCAVATOR_WIDTH = "copper.excavator.width";
        public static final String COPPER_EXCAVATOR_DEPTH = "copper.excavator.depth";
        public static final String COPPER_HAMMER_WIDTH = "copper.hammer.width";
        public static final String COPPER_HAMMER_DEPTH = "copper.hammer.depth";
        public static final String ENDERITE_EXCAVATOR_WIDTH = "enderite.excavator.width";
        public static final String ENDERITE_EXCAVATOR_DEPTH = "enderite.excavator.depth";
        public static final String ENDERITE_HAMMER_WIDTH = "enderite.hammer.width";
        public static final String ENDERITE_HAMMER_DEPTH = "enderite.hammer.depth";
        public static final String RUBY_EXCAVATOR_WIDTH = "ruby.excavator.width";
        public static final String RUBY_EXCAVATOR_DEPTH = "ruby.excavator.depth";
        public static final String RUBY_HAMMER_WIDTH = "ruby.hammer.width";
        public static final String RUBY_HAMMER_DEPTH = "ruby.hammer.depth";
        public static final String SAPPHIRE_EXCAVATOR_WIDTH = "sapphire.excavator.width";
        public static final String SAPPHIRE_EXCAVATOR_DEPTH = "sapphire.excavator.depth";
        public static final String SAPPHIRE_HAMMER_WIDTH = "sapphire.hammer.width";
        public static final String SAPPHIRE_HAMMER_DEPTH = "sapphire.hammer.depth";
        public static final String DIAMOND_EXCAVATOR_WIDTH = "diamond.excavator.width";
        public static final String DIAMOND_EXCAVATOR_DEPTH = "diamond.excavator.depth";
        public static final String DIAMOND_HAMMER_WIDTH = "diamond.hammer.width";
        public static final String DIAMOND_HAMMER_DEPTH = "diamond.hammer.depth";
        public static final String GOLD_EXCAVATOR_WIDTH = "gold.excavator.width";
        public static final String GOLD_EXCAVATOR_DEPTH = "gold.excavator.depth";
        public static final String GOLD_HAMMER_WIDTH = "gold.hammer.width";
        public static final String GOLD_HAMMER_DEPTH = "gold.hammer.depth";
        public static final String IRON_EXCAVATOR_WIDTH = "iron.excavator.width";
        public static final String IRON_EXCAVATOR_DEPTH = "iron.excavator.depth";
        public static final String IRON_HAMMER_WIDTH = "iron.hammer.width";
        public static final String IRON_HAMMER_DEPTH = "iron.hammer.depth";
        public static final String NETHERITE_EXCAVATOR_WIDTH = "netherite.excavator.width";
        public static final String NETHERITE_EXCAVATOR_DEPTH = "netherite.excavator.depth";
        public static final String NETHERITE_HAMMER_WIDTH = "netherite.hammer.width";
        public static final String NETHERITE_HAMMER_DEPTH = "netherite.hammer.depth";
        public static final String STONE_EXCAVATOR_WIDTH = "stone.excavator.width";
        public static final String STONE_EXCAVATOR_DEPTH = "stone.excavator.depth";
        public static final String STONE_HAMMER_WIDTH = "stone.hammer.width";
        public static final String STONE_HAMMER_DEPTH = "stone.hammer.depth";
        public static final String WOOD_EXCAVATOR_WIDTH = "wood.excavator.width";
        public static final String WOOD_EXCAVATOR_DEPTH = "wood.excavator.depth";
        public static final String WOOD_HAMMER_WIDTH = "wood.hammer.width";
        public static final String WOOD_HAMMER_DEPTH = "wood.hammer.depth";
        /**
         * Private constructor to prevent instantiation of the Keys class.
         * This will throw an AssertionError if instantiation is attempted.
         */
        ConfigKeys()
        {
            throw new AssertionError();
        }
    }
}