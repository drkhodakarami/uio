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
    public static final Logger LOGGER = LoggerFactory.getLogger(ModID);

    //region Logging
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
    //endregion

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
            public static final TagKey<net.minecraft.item.Item> MENDING_ONLY = createTag("mending_only");
            public static final TagKey<net.minecraft.item.Item> SMELTERY = createTag("smeltery");

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
}