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

import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static jiraiyah.uio.Main.DEBUG;

public class Reference
{

    public static final String ModID = "uio";

    //region Logging
    public static final Logger LOGGER = LoggerFactory.getLogger(ModID);

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_MAGENTA = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BRIGHT_BLACK = "\u001B[90m";
    public static final String ANSI_BRIGHT_RED = "\u001B[91m";
    public static final String ANSI_BRIGHT_GREEN = "\u001B[92m";
    public static final String ANSI_BRIGHT_YELLOW = "\u001B[93m";
    public static final String ANSI_BRIGHT_BLUE = "\u001B[94m";
    public static final String ANSI_BRIGHT_MAGENTA = "\u001B[95m";
    public static final String ANSI_BRIGHT_CYAN = "\u001B[96m";
    public static final String ANSI_BRIGHT_WHITE = "\u001B[97m";
    public static final String ANSI_BLACK_BACK = "\u001B[40m";
    public static final String ANSI_RED_BACK = "\u001B[41m";
    public static final String ANSI_GREEN_BACK = "\u001B[42m";
    public static final String ANSI_YELLOW_BACK = "\u001B[43m";
    public static final String ANSI_BLUE_BACK = "\u001B[44m";
    public static final String ANSI_MAGENTA_BACK = "\u001B[45m";
    public static final String ANSI_CYAN_BACK = "\u001B[46m";
    public static final String ANSI_WHITE_BACK = "\u001B[47m";
    public static final String ANSI_BRIGHT_BLACK_BACK = "\u001B[100m";
    public static final String ANSI_BRIGHT_RED_BACK = "\u001B[101m";
    public static final String ANSI_BRIGHT_GREEN_BACK = "\u001B[102m";
    public static final String ANSI_BRIGHT_YELLOW_BACK = "\u001B[103m";
    public static final String ANSI_BRIGHT_BLUE_BACK = "\u001B[104m";
    public static final String ANSI_BRIGHT_MAGENTA_BACK = "\u001B[105m";
    public static final String ANSI_BRIGHT_CYAN_BACK = "\u001B[106m";
    public static final String ANSI_BRIGHT_WHITE_BACK = "\u001B[107m";

    public static void logMain()
    {
        LOGGER.info("\u001b[38;2;" + 255 + ";" + 255 + ";" + 0 + ";48;2;" + 255 + ";" + 0 + ";" + 127 +
                    "m>>> " + "Initializing" + " " + Reference.ANSI_RESET);
    }

    public static void log(String message)
    {
        if (DEBUG)
            LOGGER.info(ANSI_BRIGHT_MAGENTA + ">>> " + message + ANSI_RESET);
    }

    public static void logN(String message)
    {
        if (DEBUG)
            LOGGER.info(">>> " + message);
    }

    public static void logRGB256(String message, int r, int g, int b)
    {
        if (DEBUG)
            LOGGER.info("\u001b[38;2;" + r + ";" + g + ";" + b + "m>>> " + message + ANSI_RESET);
    }

    public static void logBackRGB256(String message, int rf, int gf, int bf, int rb, int gb, int bb)
    {
        if (DEBUG)
            LOGGER.info("\u001b[38;2;" + rf + ";" + gf + ";" + bf + ";48;2;" + rb + ";" + gb + ";" + bb + "m>>> " + message + " " + ANSI_RESET);
    }
    //endregion

    //region IDENTIFIERS
    @NotNull
    public static Identifier identifier(@NotNull String path)
    {
        return Identifier.of(ModID, path);
    }

    @NotNull
    public static Identifier vanillaID(@NotNull String path)
    {
        return Identifier.ofVanilla(path);
    }

    @NotNull
    public static Identifier idOf(@NotNull String path)
    {
        return Identifier.of(path);
    }
    //endregion

    public static MutableText translate(String key, Object... params)
    {
        return Text.translatable(ModID + "." + key, params);
    }

    public static class Tags
    {

        public static class Block
        {
            public static final TagKey<net.minecraft.block.Block> GEM_BLOCKS = createCommonTag("gem_blocks");
            public static final TagKey<net.minecraft.block.Block> IS_MACHINE = createCommonTag("machines");

            public static final TagKey<net.minecraft.block.Block> HAMMER_BLACKLIST = createTag("hammer_blacklist");
            public static final TagKey<net.minecraft.block.Block> EXCAVATOR_BLACKLIST = createTag("excavator_blacklist");
            public static final TagKey<net.minecraft.block.Block> INCORRECT_FOR_ENDERITE_TOOL = createTag("incorrect_for_enderite_tool");

            //region HELPER METHODS
            private static TagKey<net.minecraft.block.Block> createTag(String name)
            {
                return TagKey.of(RegistryKeys.BLOCK, identifier(name));
            }

            private static TagKey<net.minecraft.block.Block> createCommonTag(String name)
            {
                return TagKey.of(RegistryKeys.BLOCK, Identifier.tryParse("c", name));
            }
            //endregion
        }

        public static class Item
        {
            public static final TagKey<net.minecraft.item.Item> FLUID_BUCKET = createCommonTag("fluid_buckets");
            public static final TagKey<net.minecraft.item.Item> CAST = createCommonTag("casts");
            public static final TagKey<net.minecraft.item.Item> RAW = createCommonTag("raws");
            public static final TagKey<net.minecraft.item.Item> WOOD_CAST = createCommonTag("wood_casts");
            public static final TagKey<net.minecraft.item.Item> GEAR = createCommonTag("gears");
            public static final TagKey<net.minecraft.item.Item> DUST = createCommonTag("dusts");
            public static final TagKey<net.minecraft.item.Item> INGOT = createCommonTag("ingots");
            public static final TagKey<net.minecraft.item.Item> PLATE = createCommonTag("plates");
            public static final TagKey<net.minecraft.item.Item> REINFORCED = createCommonTag("reinforced_plates");
            public static final TagKey<net.minecraft.item.Item> ROD = createCommonTag("rods");
            public static final TagKey<net.minecraft.item.Item> TOOL_HEAD = createCommonTag("tool_heads");
            public static final TagKey<net.minecraft.item.Item> ALLOY = createCommonTag("alloys");
            public static final TagKey<net.minecraft.item.Item> GEM = createCommonTag("gems");

            public static final TagKey<net.minecraft.item.Item> HAMMERS = createTag("hammers");
            public static final TagKey<net.minecraft.item.Item> EXCAVATORS = createTag("excavators");
            public static final TagKey<net.minecraft.item.Item> MENDING_ONLY = createTag("mending_only");
            public static final TagKey<net.minecraft.item.Item> SMELTABLE = createTag("smeltery");

            //region HELPER METHODS
            private static TagKey<net.minecraft.item.Item> createTag(String name)
            {
                return TagKey.of(RegistryKeys.ITEM, identifier(name));
            }

            private static TagKey<net.minecraft.item.Item> createCommonTag(String name)
            {
                return TagKey.of(RegistryKeys.ITEM, Identifier.tryParse("c", name));
            }
            //endregion
        }

        public static class Entity
        {

            public static final TagKey<EntityType<?>> TUNER_BLACKLIST = createTag("tuner_blacklist");
            public static final TagKey<EntityType<?>> RUBY_SWORD_WHITELIST = createTag("ruby_sword_whitelist");
            public static final TagKey<EntityType<?>> ENDERITE_SWORD_BLACKLIST = createTag("enderite_sword_blacklist");

            //region HELPER METHODS
            private static TagKey<EntityType<?>> createTag(String name)
            {
                return TagKey.of(RegistryKeys.ENTITY_TYPE, identifier(name));
            }

            private static TagKey<EntityType<?>> createCommonTag(String name)
            {
                return TagKey.of(RegistryKeys.ENTITY_TYPE, Identifier.tryParse("c", name));
            }
            //endregion
        }
    }

    public static class Keys
    {
        public static class Items
        {}

        public static class BlockEntities
        {
            public static final String ENERGY_AMOUNT = ModID + ".energy.amount";
            public static final String ENERGY_CAPACITY = ModID + ".energy.capacity";
            public static final String FLUID_AMOUNT = ModID + ".fluid.amount";
            public static final String FLUID_CAPACITY = ModID + ".fluid.capacity";
            public static final String PROGRESS_AMOUNT = ModID + ".progress.amount";
            public static final String PROGRESS_COOLDOWN = ModID + ".progress.cooldown";
            public static final String PROGRESS_MAX = ModID + ".progress.max";
        }

        public static class Config
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
        }
    }

    public static class Constants
    {
        //region ITEM GROUP NAMES AND TITLES
        public static final String BLOCK_ITEM_GROUP_NAME = "_1_block_group";
        public static final String INGREDIENT_ITEM_GROUP_NAME = "_5_ingredient_group";
        public static final String MACHINE_ITEM_GROUP_NAME = "_2_machine_group";
        public static final String TOOLS_ITEM_GROUP_NAME = "_3_tool_group";
        public static final String ARMOR_ITEM_GROUP_NAME = "_4_armor_group";
        public static final String MISC_ITEM_GROUP_NAME = "_6_misc_group";

        public static final MutableText BLOCKS_TITLE = translate(BLOCK_ITEM_GROUP_NAME);
        public static final MutableText INGREDIENT_TITLE = translate(INGREDIENT_ITEM_GROUP_NAME);
        public static final MutableText MACHINES_TITLE = translate(MACHINE_ITEM_GROUP_NAME);
        public static final MutableText TOOLS_TITLE = translate(TOOLS_ITEM_GROUP_NAME);
        public static final MutableText ARMORS_TITLE = translate(ARMOR_ITEM_GROUP_NAME);
        public static final MutableText MISC_TITLE = translate(MISC_ITEM_GROUP_NAME);
        //endregion
        //region TOOLTIPS
        public static final String TUNER_TOOLTIP_ID_NAME = "tuner.tooltip";
        public static final String TUNER_TELEPORTED_ID_NAME = "tuner.teleported";
        public static final String TUNER_ERROR_ID_NAME = "tuner.error";
        public static final String TELEPORTER_TOOLTIP_ID_NAME = "teleporter.tooltip";
        public static final String HAMMER_PARAM_TOOLTIP = "hammer.tooltip";
        public static final String EXCAVATOR_PARAM_TOOLTIP = "excavator.tooltip";
        //endregion
        //region COMMAND MESSAGES
        public static final String DCLR_ERROR_ID_NAME = "dclr.error";
        public static final String DCLR_START_ID_NAME = "dclr.start";
        public static final String DCLR_END_ID_NAME = "dclr.end";
        //endregion
    }
}