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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

/**
 * This class contains the reference information for the mod UIO.
 * It includes constants and configurations utilized throughout the mod.
 */
public class Reference
{
    /**
     * The ID of the mod. This should be unique to identify the mod within the Minecraft ecosystem.
     */
    public static final String ModID = "uio";
    /**
     * A Gson instance configured for pretty printing and HTML escaping disabled.
     * Used for serialization and deserialization of JSON data within the mod.
     */
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    /**
     * A Logger instance used for logging messages throughout the UIO mod.
     * It is initialized using the mod's ID, which helps in identifying
     * the source of log messages in the application's log output.
     * This logger can be utilized to capture various log levels,
     * including debug, info, warning, and error messages, facilitating
     * effective monitoring and troubleshooting of the mod's behavior.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(ModID);

    //region Logging
    /**
     * ANSI escape code for resetting the color formatting in the console output.
     * This code can be used to revert the text color back to the default settings
     * after applying any other ANSI color codes. Utilizing this constant makes
     * it easier to manage text color when logging or printing messages to the console.
     */
    public static final String ANSI_RESET = "\u001B[0m";
    /**
     * ANSI escape code for setting the text color to different colors in console output.
     * This code can be used to change the color of the text displayed in the
     * console to different color. It is useful for enhancing the readability of log
     * messages or console output by using different colors for different contexts.
     */
    public static final String ANSI_BLACK = "\u001B[30m";
    /**
     * ANSI escape code for setting the background color to different colors in console output.
     * This code can be used to change the background color of the text displayed
     * in the console to different color. It is useful for enhancing the visual distinction
     * of log messages or console output by applying different background colors.
     */
    public static final String ANSI_BLACK_BACK = "\u001B[40m";
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
    /**
     * Private constructor to prevent instantiation of this utility class.
     * This will throw an AssertionError if attempted.
     */
    Reference()
    {
        throw new AssertionError();
    }
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

    /**
     * Logs the initialization message of the UIO mod to the console.
     * This method uses a specific ANSI color formatting for the log message
     * to enhance visibility. It outputs an info level log indicating
     * that the mod is being initialized. The colors are set to a
     * bright-yellow foreground with a pink background for emphasis.
     */
    public static void logMain()
    {
        LOGGER.info("\u001b[38;2;" + 255 + ";" + 255 + ";" + 0 + ";48;2;" + 255 + ";" + 0 + ";" + 127 +
                    "m>>> " + "Initializing" + " " + Reference.ANSI_RESET);
    }

    /**
     * Logs a message to the console if debugging is enabled.
     * This method checks the DEBUG flag and, if true, logs the provided
     * message using an info level log. The message is formatted with
     * bright magenta text to enhance visibility in the console output.
     *
     * @param message The message to log, intended for debugging purposes.
     */
    public static void log(String message)
    {
        if (DEBUG)
            LOGGER.info(ANSI_BRIGHT_MAGENTA + ">>> " + message + ANSI_RESET);
    }

    /**
     * Logs an error message to the console.
     * This method logs the provided message using an info level log,
     * formatted with a bright red background and black text for emphasis.
     * It is intended for indicating error conditions or significant issues
     * that need to be brought to the user's attention.
     *
     * @param message The error message to log, intended for error tracking.
     */
    public static void logError(String message)
    {
        LOGGER.info(ANSI_BRIGHT_RED_BACK + ANSI_BLACK + ">>> " + message + ANSI_RESET);
    }

    /**
     * Logs a warning message to the console if debugging is enabled.
     * This method checks the DEBUG flag and, if true, logs the provided
     * warning message with bright yellow background and black text for visibility.
     * This is intended for indicating potential issues or important notes
     * that may require attention.
     *
     * @param message The warning message to log, aimed at alerting users
     *                to possible concerns or conditions.
     */
    public static void logWarning(String message)
    {
        if (DEBUG)
            LOGGER.info(ANSI_BRIGHT_YELLOW_BACK + ANSI_BLACK + ">>> " + message + ANSI_RESET);
    }

    /**
     * Logs a general message to the console if debugging is enabled.
     * This method checks the DEBUG flag and, if true, logs the provided
     * message without any special formatting. This is useful for outputting
     * standard messages that do not require specific color coding.
     *
     * @param message The message to log, intended for general informational output.
     */
    public static void logN(String message)
    {
        if (DEBUG)
            LOGGER.info(">>> " + message);
    }

    /**
     * Logs a message to the console with customizable RGB color formatting
     * if debugging is enabled. This method allows the user to specify
     * the red, green, and blue color components for the message text.
     * The output will use the specified RGB values for the text color,
     * making it easier to highlight messages in a colorful manner.
     *
     * @param message The message to log, intended for informational output.
     * @param r       The red component of the text color (0-255).
     * @param g       The green component of the text color (0-255).
     * @param b       The blue component of the text color (0-255).
     */
    public static void logRGB256(String message, int r, int g, int b)
    {
        if (DEBUG)
            LOGGER.info("\u001b[38;2;" + r + ";" + g + ";" + b + "m>>> " + message + ANSI_RESET);
    }

    /**
     * Logs a message to the console with customizable RGB color formatting
     * for both the text and the background if debugging is enabled.
     * This method allows the user to specify the red, green, and blue
     * color components for the message text color and the background color.
     * The output will use the specified RGB values, making it easy to create
     * visually distinct log messages.
     *
     * @param message The message to log, intended for informational output.
     * @param rf      The red component of the text color (0-255).
     * @param gf      The green component of the text color (0-255).
     * @param bf      The blue component of the text color (0-255).
     * @param rb      The red component of the background color (0-255).
     * @param gb      The green component of the background color (0-255).
     * @param bb      The blue component of the background color (0-255).
     */
    public static void logBackRGB256(String message, int rf, int gf, int bf, int rb, int gb, int bb)
    {
        if (DEBUG)
            LOGGER.info("\u001b[38;2;" + rf + ";" + gf + ";" + bf + ";48;2;" + rb + ";" + gb + ";" + bb + "m>>> " + message + " " + ANSI_RESET);
    }
    //endregion

    //region IDENTIFIERS

    /**
     * Constructs a `Identifier` for the given path using the mod's ID.
     * This method creates an identifier that is used to reference
     * resources within the UIO mod. It combines the mod's ID with
     * the provided path to ensure that the identifier is unique within
     * the Minecraft ecosystem.
     *
     * @param path The path string to be combined with the mod's ID.
     *
     * @return A new `Identifier` instance formed by the mod's ID and the specified path.
     */
    @NotNull
    public static Identifier identifier(@NotNull String path)
    {
        return Identifier.of(ModID, path);
    }

    /**
     * Constructs a vanilla `Identifier` for the given path.
     * This method creates an identifier that is used to reference
     * resources within the vanilla Minecraft environment. It takes
     * a path string and returns an identifier that is recognized
     * by Minecraft, ensuring proper resource references for
     * compatibility with the vanilla game.
     *
     * @param path The path string to be used for creating the vanilla identifier.
     * @return A new `Identifier` instance created from the specified path.
     */
    @NotNull
    public static Identifier vanillaID(@NotNull String path)
    {
        return Identifier.ofVanilla(path);
    }

    /**
     * Constructs a generic `Identifier` for the given path.
     * This method creates an identifier that can be used to reference
     * resources in the context of the Minecraft mod or any other
     * identifier needed, ensuring flexibility in how identifiers are created
     * based on the provided path string.
     *
     * @param path The path string to be used for creating the identifier.
     * @return A new `Identifier` instance created from the specified path.
     */
    @NotNull
    public static Identifier idOf(@NotNull String path)
    {
        return Identifier.of(path);
    }
    //endregion

    /**
     * Translates a key into a `MutableText` object using the mod's localization system.
     * This method appends the mod's ID to the provided key to create a fully qualified
     * translation key. It supports additional parameters for dynamic text replacement in
     * the translated string, making it useful for displaying user-facing text in the mod.
     *
     * @param key The translation key to be used for looking up the localized string.
     * @param params Optional parameters for dynamic text replacement in the translated string.
     * @return A `MutableText` object representing the translated string.
     */
    public static MutableText translate(String key, Object... params)
    {
        return Text.translatable(ModID + "." + key, params);
    }

    /**
     * Translates a container-specific key into a `MutableText` object using the mod's localization system.
     * This method appends the mod's ID and the "container" prefix to the provided key to create a fully
     * qualified translation key specifically for container-related text. It supports additional parameters
     * for dynamic text replacement in the translated string, making it useful for displaying user-facing
     * text for containers in the mod.
     *
     * @param key    The translation key to be used for looking up the localized string for a container.
     * @param params Optional parameters for dynamic text replacement in the translated string.
     *
     * @return A `MutableText` object representing the translated container string.
     */
    public static MutableText translateContainer(String key, Object... params)
    {
        return Text.translatable(ModID + ".container." + key, params);
    }

    /**
     * A utility class that contains constants and methods related to tags
     * used within the UIO mod. The `Tags` class is designed to group related
     * tag definitions, providing a centralized location for managing
     * identifiers associated with various tags in the mod.
     *
     * This class is non-instantiable; attempting to create an instance
     * will result in an AssertionError. It serves only as a container
     * for static members related to tags.
     */
    public static class Tags
    {
        Tags()
        {
            throw new AssertionError();
        }

        /**
         * A class that contains constants for block-related tags used within
         * the UIO mod. This class serves as a centralized repository for
         * all block tag identifiers, allowing for easy reference and
         * management throughout the mod.
         *
         * The `block` subclass groups tags that are specifically related to
         * block types, enabling better organization and access when
         * implementing functionality that relies on block tag data.
         */
        public static class Block
        {
            /**
             * Private constructor to prevent instantiation of the block class.
             * This will throw an AssertionError if instantiation is attempted.
             */
            Block()
            {
                throw new AssertionError();
            }

            public static final TagKey<net.minecraft.block.Block> GEM_BLOCKS = createCommonTag("gem_blocks");
            public static final TagKey<net.minecraft.block.Block> IS_MACHINE = createCommonTag("machines");

            public static final TagKey<net.minecraft.block.Block> HAMMER_BLACKLIST = createTag("hammer_blacklist");
            public static final TagKey<net.minecraft.block.Block> EXCAVATOR_BLACKLIST = createTag("excavator_blacklist");
            public static final TagKey<net.minecraft.block.Block> INCORRECT_FOR_ENDERITE_TOOL = createTag("incorrect_for_enderite_tool");

            //region HELPER METHODS

            /**
             * Creates a `TagKey` for a specific block tag using the provided name.
             * This method takes a string name and constructs a TagKey that refers
             * to a tag associated with blocks in the Minecraft registry. It is
             * intended to facilitate the creation of custom tags for blocks
             * within the UIO mod, ensuring that the tags are properly registered
             * and can be referenced throughout the mod's code.
             *
             * @param name The name of the tag to be created.
             *
             * @return A `TagKey` instance representing the specified block tag.
             */
            protected static TagKey<net.minecraft.block.Block> createTag(String name)
            {
                return TagKey.of(RegistryKeys.BLOCK, identifier(name));
            }

            /**
             * Creates a `TagKey` for a common block tag using the provided name.
             * This method takes a string name and constructs a TagKey that refers
             * to a commonly used tag associated with blocks in the Minecraft registry.
             * It ensures that the tag is registered under the "c" prefix, allowing
             * for easier identification of common tags used throughout the UIO mod.
             *
             * @param name The name of the common tag to be created.
             *
             * @return A `TagKey` instance representing the specified common block tag.
             */
            protected static TagKey<net.minecraft.block.Block> createCommonTag(String name)
            {
                return TagKey.of(RegistryKeys.BLOCK, Identifier.tryParse("c", name));
            }
            //endregion
        }

        /**
         * A utility class that contains constants and methods related to item-related tags
         * used within the UIO mod. This class serves as a centralized repository for
         * all item tag identifiers, allowing for easy reference and management throughout
         * the mod.
         *
         * The `Item` subclass groups tags that are specifically related to item types,
         * enabling better organization and access when implementing functionality
         * that relies on item tag data.
         */
        public static class Item
        {
            /**
             * Private constructor to prevent instantiation of the Item class.
             * This will throw an AssertionError if instantiation is attempted.
             */
            Item()
            {
                throw new AssertionError();
            }

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

            public static final TagKey<net.minecraft.item.Item> REPAIRS_AMETHYST_ARMOR = createTag("repairs_amethyst_armor");
            public static final TagKey<net.minecraft.item.Item> REPAIRS_CITRINE_ARMOR = createTag("repairs_citrine_armor");
            public static final TagKey<net.minecraft.item.Item> REPAIRS_COPPER_ARMOR = createTag("repairs_copper_armor");
            public static final TagKey<net.minecraft.item.Item> REPAIRS_EMERALD_ARMOR = createTag("repairs_emerald_armor");
            public static final TagKey<net.minecraft.item.Item> REPAIRS_ENDERITE_ARMOR = createTag("repairs_enderite_armor");
            public static final TagKey<net.minecraft.item.Item> REPAIRS_RUBY_ARMOR = createTag("repairs_ruby_armor");
            public static final TagKey<net.minecraft.item.Item> REPAIRS_SAPPHIRE_ARMOR = createTag("repairs_sapphire_armor");
            public static final TagKey<net.minecraft.item.Item> REPAIRS_CITRINE_TOOL = createTag("repairs_citrine_tool");
            public static final TagKey<net.minecraft.item.Item> REPAIRS_COPPER_TOOL = createTag("repairs_copper_tool");
            public static final TagKey<net.minecraft.item.Item> REPAIRS_ENDERITE_TOOL = createTag("repairs_enderite_tool");
            public static final TagKey<net.minecraft.item.Item> REPAIRS_RUBY_TOOL = createTag("repairs_ruby_tool");
            public static final TagKey<net.minecraft.item.Item> REPAIRS_SAPPHIRE_TOOL = createTag("repairs_sapphire_tool");

            public static final TagKey<net.minecraft.item.Item> AMETHYST_ARMOR_TYPE = createTag("amethyst_armor_type");
            public static final TagKey<net.minecraft.item.Item> CITRINE_ARMOR_TYPE = createTag("citrine_armor_type");
            public static final TagKey<net.minecraft.item.Item> COPPER_ARMOR_TYPE = createTag("copper_armor_type");
            public static final TagKey<net.minecraft.item.Item> EMERALD_ARMOR_TYPE = createTag("emerald_armor_type");
            public static final TagKey<net.minecraft.item.Item> ENDERITE_ARMOR_TYPE = createTag("enderite_armor_type");
            public static final TagKey<net.minecraft.item.Item> RUBY_ARMOR_TYPE = createTag("ruby_armor_type");
            public static final TagKey<net.minecraft.item.Item> SAPPHIRE_ARMOR_TYPE = createTag("sapphire_armor_type");

            //region HELPER METHODS

            /**
             * Creates a `TagKey` for a specific item tag using the provided name.
             * This method takes a string name and constructs a TagKey that refers
             * to a tag associated with items in the Minecraft registry. It is
             * intended to facilitate the creation of custom tags for items
             * within the UIO mod, ensuring that the tags are properly registered
             * and can be referenced throughout the mod's code.
             *
             * @param name The name of the tag to be created.
             *
             * @return A `TagKey` instance representing the specified item tag.
             */
            protected static TagKey<net.minecraft.item.Item> createTag(String name)
            {
                return TagKey.of(RegistryKeys.ITEM, identifier(name));
            }

            /**
             * Creates a `TagKey` for a common item tag using the provided name.
             * This method takes a string name and constructs a TagKey that refers
             * to a commonly used tag associated with items in the Minecraft registry.
             * It ensures that the tag is registered under the "c" prefix, allowing
             * for easier identification of common tags used throughout the UIO mod.
             *
             * @param name The name of the common tag to be created.
             *
             * @return A `TagKey` instance representing the specified common item tag.
             */
            protected static TagKey<net.minecraft.item.Item> createCommonTag(String name)
            {
                return TagKey.of(RegistryKeys.ITEM, Identifier.tryParse("c", name));
            }
            //endregion
        }

        /**
         * A utility class that contains constants and methods related to entity-related tags
         * used within the UIO mod. This class serves as a centralized repository for
         * all entity tag identifiers, allowing for easy reference and management throughout
         * the mod.
         *
         * The `Entity` subclass groups tags that are specifically related to entity types,
         * enabling better organization and access when implementing functionality that
         * relies on entity tag data.
         */
        public static class Entity
        {
            /**
             * Private constructor to prevent instantiation of the Entity class.
             * This will throw an AssertionError if instantiation is attempted.
             */
            Entity()
            {
                throw new AssertionError();
            }

            public static final TagKey<EntityType<?>> TUNER_BLACKLIST = createTag("tuner_blacklist");
            public static final TagKey<EntityType<?>> RUBY_SWORD_WHITELIST = createTag("ruby_sword_whitelist");
            public static final TagKey<EntityType<?>> ENDERITE_SWORD_BLACKLIST = createTag("enderite_sword_blacklist");

            //region HELPER METHODS

            /**
             * Creates a `TagKey` for a specific entity tag using the provided name.
             * This method takes a string name and constructs a TagKey that refers
             * to a tag associated with entity types in the Minecraft registry.
             * It is intended to facilitate the creation of custom tags for entities
             * within the UIO mod, ensuring that the tags are properly registered
             * and can be referenced throughout the mod's code.
             *
             * @param name The name of the tag to be created.
             * @return A `TagKey` instance representing the specified entity tag.
             */
            protected static TagKey<EntityType<?>> createTag(String name)
            {
                return TagKey.of(RegistryKeys.ENTITY_TYPE, identifier(name));
            }

            /**
             * Creates a `TagKey` for a common entity tag using the provided name.
             * This method takes a string name and constructs a TagKey that refers
             * to a commonly used tag associated with entity types in the Minecraft registry.
             * It ensures that the tag is registered under the "c" prefix, allowing
             * for easier identification of common tags used throughout the UIO mod.
             *
             * @param name The name of the common tag to be created.
             *
             * @return A `TagKey` instance representing the specified common entity tag.
             */
            protected static TagKey<EntityType<?>> createCommonTag(String name)
            {
                return TagKey.of(RegistryKeys.ENTITY_TYPE, Identifier.tryParse("c", name));
            }
            //endregion
        }
    }

    /**
     * A utility class that contains constants and methods related to various
     * key definitions used within the UIO mod. This class serves as a centralized
     * repository for managing key identifiers, allowing for easy access and
     * organization of keys used throughout the mod.
     *
     * The `Keys` subclass may be used to define keys for different functionalities
     * or features in the UIO mod, ensuring a consistent approach to key management
     * within the modding framework.
     */
    public static class Keys
    {
        /**
         * Private constructor to prevent instantiation of the Keys class.
         * This will throw an AssertionError if instantiation is attempted.
         */
        Keys()
        {
            throw new AssertionError();
        }

        /**
         * A utility class that contains constants and methods related to suffixes
         * used for key definitions within the UIO mod. This class serves as a
         * centralized repository for managing suffix identifiers, enabling better
         * organization and consistent usage of suffixes associated with various
         * features or functionalities in the mod.
         * <p>
         * The `suffix` subclass may be used to define suffix constants that can
         * be appended to key strings, ensuring adherence to naming conventions
         * and enhancing the readability of key identifiers across the mod.
         */
        public static class Suffix
        {
            public static final String NORTH = ".north";
            public static final String SOUTH = ".south";
            public static final String WEST = ".west";
            public static final String EAST = ".east";
            public static final String TOP = ".top";
            public static final String BOTTOM = ".bottom";
            public static final String NO_DIRECTION = ".no.direction";
            /**
             * Private constructor to prevent instantiation of the suffix class.
             * This will throw an AssertionError if instantiation is attempted.
             */
            Suffix()
            {
                throw new AssertionError();
            }
        }

        /**
         * A utility class that contains constants and methods related to item keys
         * used within the UIO mod. This class serves as a centralized repository
         * for managing item key identifiers, enabling better organization and
         * consistent usage of keys associated with different items in the mod.
         *
         * The `items` subclass may be used to define key constants that are specific
         * to item types or functionalities, ensuring adherence to naming conventions
         * and enhancing the readability of key identifiers across the mod's code.
         */
        public static class Items
        {
            /**
             * Private constructor to prevent instantiation of the items class.
             * This will throw an AssertionError if instantiation is attempted.
             */
            Items()
            {
                throw new AssertionError();
            }
        }

        /**
         * A utility class that contains constants and methods related to block entity keys
         * used within the UIO mod. This class serves as a centralized repository for
         * managing block entity key identifiers, enabling better organization and
         * consistent usage of keys associated with different block entities in the mod.
         *
         * The `blockEntities` subclass may be used to define key constants that are specific
         * to block entity types or functionalities, ensuring adherence to naming conventions
         * and enhancing the readability of key identifiers across the mod's code.
         */
        public static class BlockEntities
        {
            public static final String ENERGY_AMOUNT = ModID + ".be.energy.amount";
            public static final String ENERGY_CAPACITY = ModID + ".be.energy.capacity";
            public static final String FLUID_AMOUNT = ModID + ".be.fluid.amount";
            public static final String FLUID_CAPACITY = ModID + ".be.fluid.capacity";
            public static final String PROGRESS_AMOUNT = ModID + ".be.progress.amount";
            public static final String PROGRESS_MAX = ModID + ".be.progress.max";
            public static final String COOLDOWN_AMOUNT = ModID + ".be.cooldown.amount";
            public static final String COOLDOWN_MAX = ModID + ".be.cooldown.max";
            public static final String BURN_AMOUNT = ModID + ".be.burn.amount";
            public static final String BURN_MAX = ModID + ".be.burn.max";
            public static final String INVENTORY_KEY = ModID + ".be.inventory";
            /**
             * Private constructor to prevent instantiation of the blockEntities class.
             * This will throw an AssertionError if instantiation is attempted.
             */
            BlockEntities()
            {
                throw new AssertionError();
            }
        }

        /**
         * A utility class that contains constants and methods related to configuration keys
         * used within the UIO mod. This class serves as a centralized repository for
         * managing configuration key identifiers, enabling better organization and
         * consistent usage of keys associated with configurable settings in the mod.
         *
         * The `config` subclass may be used to define key constants that are specific
         * to configuration parameters, ensuring adherence to naming conventions
         * and enhancing the readability of key identifiers throughout the mod's code.
         */
        public static class Config
        {
            /**
             * Private constructor to prevent instantiation of the config class.
             * This will throw an AssertionError if instantiation is attempted.
             */
            Config()
            {
                throw new AssertionError();
            }

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

    /**
     * A utility class that contains constant values used throughout the UIO mod.
     * This class serves as a centralized repository for defining and managing
     * constant identifiers, ensuring consistency and ease of use across various
     * components of the mod.
     *
     * The `constants` subclass may include various fixed values, such as
     * configuration parameters, tag names, and other key identifiers that
     * remain unchanged during the runtime of the mod. By storing these values
     * in a single location, the code becomes more maintainable and readable.
     */
    public static class Constants
    {
        /**
         * Private constructor to prevent instantiation of the constants class.
         * This will throw an AssertionError if instantiation is attempted.
         */
        Constants()
        {
            throw new AssertionError();
        }

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