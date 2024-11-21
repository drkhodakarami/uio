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

import com.mojang.datafixers.util.Pair;
import jiraiyah.config.Config;

/**
 * The Configs class extends the Config class, presumably to manage configuration settings
 * related to the game's mechanics or features. It contains several static integer variables
 * that appear to represent various game parameters.
 */
@SuppressWarnings("unused")
public class Configs extends Config
{
    public int DCLR_RADIUS, CITRINE_SWORD_DURATION, COPPER_SWORD_DURATION, SAPPHIRE_SWORD_DURATION, EXCAVATOR_MAX_DISTANCE, HAMMER_MAX_DISTANCE,
            CITRINE_EXCAVATOR_WIDTH, CITRINE_EXCAVATOR_DEPTH, CITRINE_HAMMER_WIDTH, CITRINE_HAMMER_DEPTH, COPPER_EXCAVATOR_WIDTH, COPPER_EXCAVATOR_DEPTH,
            COPPER_HAMMER_WIDTH, COPPER_HAMMER_DEPTH, ENDERITE_EXCAVATOR_WIDTH, ENDERITE_EXCAVATOR_DEPTH, ENDERITE_HAMMER_WIDTH, ENDERITE_HAMMER_DEPTH,
            RUBY_EXCAVATOR_WIDTH, RUBY_EXCAVATOR_DEPTH, RUBY_HAMMER_WIDTH, RUBY_HAMMER_DEPTH, SAPPHIRE_EXCAVATOR_WIDTH, SAPPHIRE_EXCAVATOR_DEPTH,
            SAPPHIRE_HAMMER_WIDTH, SAPPHIRE_HAMMER_DEPTH, DIAMOND_EXCAVATOR_WIDTH, DIAMOND_EXCAVATOR_DEPTH, DIAMOND_HAMMER_WIDTH, DIAMOND_HAMMER_DEPTH,
            GOLD_EXCAVATOR_WIDTH, GOLD_EXCAVATOR_DEPTH, GOLD_HAMMER_WIDTH, GOLD_HAMMER_DEPTH, IRON_EXCAVATOR_WIDTH, IRON_EXCAVATOR_DEPTH,
            IRON_HAMMER_WIDTH, IRON_HAMMER_DEPTH, NETHERITE_EXCAVATOR_WIDTH, NETHERITE_EXCAVATOR_DEPTH, NETHERITE_HAMMER_WIDTH, NETHERITE_HAMMER_DEPTH,
            STONE_EXCAVATOR_WIDTH, STONE_EXCAVATOR_DEPTH, STONE_HAMMER_WIDTH, STONE_HAMMER_DEPTH, WOOD_EXCAVATOR_WIDTH, WOOD_EXCAVATOR_DEPTH,
            WOOD_HAMMER_WIDTH, WOOD_HAMMER_DEPTH;
    public double SAPPHIRE_SWORD_MULTIPLIER;

    /**
     * The constructor for the Configs class, invoking the superclass constructor and
     * throwing an AssertionError, indicating that this class should not be instantiated directly.
     */
    public Configs(String modId)
    {
        super(modId);
    }

    /**
     * Creates configuration settings for the application.
     * This method adds various comments and pairs to the configuration provider.
     * <p>
     * It includes settings for commands, swords, and items including specific parameters like the radius for
     * the DCLR command that defines how far the command expands on each side.
     * The method is grouped with similar settings to enhance readability and organization within the config.
     */
    @Override
    protected void createConfigs()
    {
        provider.addComment("===================================================================================================");
        provider.addComment("===============================            COMMANDS SETTINGS            ===========================");
        provider.addComment("===================================================================================================");
        provider.addComment("The radius for DCLR command, this will be the value for the command to expand on each side.");
        provider.addComment("The final dimension would be (radius * 2) + 1.");
        provider.addPair(new Pair<>(Reference.ConfigKeys.DCLR, 128));

        provider.addComment("===================================================================================================");
        provider.addComment("===============================             SWORDS SETTINGS             ===========================");
        provider.addComment("===================================================================================================");
        //provider.addComment("The effect duration for citrine sword.");
        provider.addPair(new Pair<>(Reference.ConfigKeys.CITRINE_SWORD_DURATION, 200));

        //provider.addComment("The effect duration for copper sword.");
        provider.addPair(new Pair<>(Reference.ConfigKeys.COPPER_SWORD_DURATION, 200));

        //provider.addComment("The effect duration for sapphire sword.");
        provider.addPair(new Pair<>(Reference.ConfigKeys.SAPPHIRE_SWORD_DURATION, 200), false);
        //provider.addComment("The velocity multiplier for sapphire sword.");
        provider.addPair(new Pair<>(Reference.ConfigKeys.SAPPHIRE_SWORD_MULTIPLIER, 5.0d));

        provider.addComment("===================================================================================================");
        provider.addComment("===============================         EXCAVATOR ITEM SETTINGS         ===========================");
        provider.addComment("===================================================================================================");

        provider.addComment("The max distance for all of the excavators.");
        provider.addPair(new Pair<>(Reference.ConfigKeys.EXCAVATOR_MAX_DISTANCE, 8));

        provider.addComment("Width Value: If you set this as a number like 3, it means the excavator will break 3 by 3 blocks.");
        provider.addComment("Depth Value: If you set this as a number like 2, it means the excavator will break 2 blocks deep.");
        provider.addNewLine();

        provider.addPair(new Pair<>(Reference.ConfigKeys.CITRINE_EXCAVATOR_WIDTH, 5), false);
        provider.addPair(new Pair<>(Reference.ConfigKeys.CITRINE_EXCAVATOR_DEPTH, 1));

        provider.addPair(new Pair<>(Reference.ConfigKeys.COPPER_EXCAVATOR_WIDTH, 3), false);
        provider.addPair(new Pair<>(Reference.ConfigKeys.COPPER_EXCAVATOR_DEPTH, 1));

        provider.addPair(new Pair<>(Reference.ConfigKeys.ENDERITE_EXCAVATOR_WIDTH, 9), false);
        provider.addPair(new Pair<>(Reference.ConfigKeys.ENDERITE_EXCAVATOR_DEPTH, 1));

        provider.addPair(new Pair<>(Reference.ConfigKeys.RUBY_EXCAVATOR_WIDTH, 5), false);
        provider.addPair(new Pair<>(Reference.ConfigKeys.RUBY_EXCAVATOR_DEPTH, 1));

        provider.addPair(new Pair<>(Reference.ConfigKeys.SAPPHIRE_EXCAVATOR_WIDTH, 5), false);
        provider.addNewLine();
        provider.addPair(new Pair<>(Reference.ConfigKeys.SAPPHIRE_EXCAVATOR_DEPTH, 1));

        provider.addPair(new Pair<>(Reference.ConfigKeys.DIAMOND_EXCAVATOR_WIDTH, 5), false);
        provider.addPair(new Pair<>(Reference.ConfigKeys.DIAMOND_EXCAVATOR_DEPTH, 1));

        provider.addPair(new Pair<>(Reference.ConfigKeys.GOLD_EXCAVATOR_WIDTH, 5), false);
        provider.addPair(new Pair<>(Reference.ConfigKeys.GOLD_EXCAVATOR_DEPTH, 1));

        provider.addPair(new Pair<>(Reference.ConfigKeys.IRON_EXCAVATOR_WIDTH, 5), false);
        provider.addPair(new Pair<>(Reference.ConfigKeys.IRON_EXCAVATOR_DEPTH, 1));

        provider.addPair(new Pair<>(Reference.ConfigKeys.NETHERITE_EXCAVATOR_WIDTH, 7), false);
        provider.addPair(new Pair<>(Reference.ConfigKeys.NETHERITE_EXCAVATOR_DEPTH, 1));

        provider.addPair(new Pair<>(Reference.ConfigKeys.STONE_EXCAVATOR_WIDTH, 3), false);
        provider.addPair(new Pair<>(Reference.ConfigKeys.STONE_EXCAVATOR_DEPTH, 1));

        provider.addPair(new Pair<>(Reference.ConfigKeys.WOOD_EXCAVATOR_WIDTH, 3), false);
        provider.addPair(new Pair<>(Reference.ConfigKeys.WOOD_EXCAVATOR_DEPTH, 1));

        provider.addComment("===================================================================================================");
        provider.addComment("===============================           HAMMER ITEM SETTINGS          ===========================");
        provider.addComment("===================================================================================================");

        provider.addComment("The max distance for all of the hammers.");
        provider.addPair(new Pair<>(Reference.ConfigKeys.HAMMER_MAX_DISTANCE, 8));

        provider.addComment("Width Value: If you set this as a number like 3, it means the hammer will break 3 by 3 blocks.");
        provider.addComment("Depth Value: If you set this as a number like 2, it means the hammer will break 2 blocks deep.");
        provider.addNewLine();

        provider.addPair(new Pair<>(Reference.ConfigKeys.CITRINE_HAMMER_WIDTH, 3), false);
        provider.addPair(new Pair<>(Reference.ConfigKeys.CITRINE_HAMMER_DEPTH, 2));

        provider.addPair(new Pair<>(Reference.ConfigKeys.COPPER_HAMMER_WIDTH, 3), false);
        provider.addPair(new Pair<>(Reference.ConfigKeys.COPPER_HAMMER_DEPTH, 2));

        provider.addPair(new Pair<>(Reference.ConfigKeys.ENDERITE_HAMMER_WIDTH, 5), false);
        provider.addPair(new Pair<>(Reference.ConfigKeys.ENDERITE_HAMMER_DEPTH, 5));

        provider.addPair(new Pair<>(Reference.ConfigKeys.RUBY_HAMMER_WIDTH, 5), false);
        provider.addPair(new Pair<>(Reference.ConfigKeys.RUBY_HAMMER_DEPTH, 2));

        provider.addPair(new Pair<>(Reference.ConfigKeys.SAPPHIRE_HAMMER_WIDTH, 5), false);
        provider.addPair(new Pair<>(Reference.ConfigKeys.SAPPHIRE_HAMMER_DEPTH, 2));

        provider.addPair(new Pair<>(Reference.ConfigKeys.DIAMOND_HAMMER_WIDTH, 5), false);
        provider.addPair(new Pair<>(Reference.ConfigKeys.DIAMOND_HAMMER_DEPTH, 2));

        provider.addPair(new Pair<>(Reference.ConfigKeys.GOLD_HAMMER_WIDTH, 5), false);
        provider.addPair(new Pair<>(Reference.ConfigKeys.GOLD_HAMMER_DEPTH, 1));

        provider.addPair(new Pair<>(Reference.ConfigKeys.IRON_HAMMER_WIDTH, 5), false);
        provider.addPair(new Pair<>(Reference.ConfigKeys.IRON_HAMMER_DEPTH, 1));

        provider.addPair(new Pair<>(Reference.ConfigKeys.NETHERITE_HAMMER_WIDTH, 5), false);
        provider.addPair(new Pair<>(Reference.ConfigKeys.NETHERITE_HAMMER_DEPTH, 3));

        provider.addPair(new Pair<>(Reference.ConfigKeys.STONE_HAMMER_WIDTH, 3), false);
        provider.addPair(new Pair<>(Reference.ConfigKeys.STONE_HAMMER_DEPTH, 1));

        provider.addPair(new Pair<>(Reference.ConfigKeys.WOOD_HAMMER_WIDTH, 3), false);
        provider.addPair(new Pair<>(Reference.ConfigKeys.WOOD_HAMMER_DEPTH, 1), false, true);
    }

    /**
     * Assigns configuration values to the application.
     * This method is responsible for setting up the necessary
     * configurations based on predefined parameters.
     */
    @Override
    protected void assignConfigValues()
    {
        DCLR_RADIUS = config.getOrDefault(Reference.ConfigKeys.DCLR, 128);
        CITRINE_SWORD_DURATION = config.getOrDefault(Reference.ConfigKeys.CITRINE_SWORD_DURATION, 200);
        COPPER_SWORD_DURATION = config.getOrDefault(Reference.ConfigKeys.COPPER_SWORD_DURATION, 200);
        SAPPHIRE_SWORD_DURATION = config.getOrDefault(Reference.ConfigKeys.SAPPHIRE_SWORD_DURATION, 200);
        SAPPHIRE_SWORD_MULTIPLIER = config.getOrDefault(Reference.ConfigKeys.SAPPHIRE_SWORD_MULTIPLIER, 5.0d);
        EXCAVATOR_MAX_DISTANCE = config.getOrDefault(Reference.ConfigKeys.EXCAVATOR_MAX_DISTANCE, 8);
        HAMMER_MAX_DISTANCE = config.getOrDefault(Reference.ConfigKeys.HAMMER_MAX_DISTANCE, 8);

        CITRINE_EXCAVATOR_WIDTH = config.getOrDefault(Reference.ConfigKeys.CITRINE_EXCAVATOR_WIDTH, 5);
        CITRINE_EXCAVATOR_DEPTH = config.getOrDefault(Reference.ConfigKeys.CITRINE_EXCAVATOR_DEPTH, 1);
        CITRINE_HAMMER_WIDTH = config.getOrDefault(Reference.ConfigKeys.CITRINE_HAMMER_WIDTH, 3);
        CITRINE_HAMMER_DEPTH = config.getOrDefault(Reference.ConfigKeys.CITRINE_HAMMER_DEPTH, 2);

        COPPER_EXCAVATOR_WIDTH = config.getOrDefault(Reference.ConfigKeys.COPPER_EXCAVATOR_WIDTH, 3);
        COPPER_EXCAVATOR_DEPTH = config.getOrDefault(Reference.ConfigKeys.COPPER_EXCAVATOR_DEPTH, 1);
        COPPER_HAMMER_WIDTH = config.getOrDefault(Reference.ConfigKeys.COPPER_HAMMER_WIDTH, 3);
        COPPER_HAMMER_DEPTH = config.getOrDefault(Reference.ConfigKeys.COPPER_HAMMER_DEPTH, 2);

        ENDERITE_EXCAVATOR_WIDTH = config.getOrDefault(Reference.ConfigKeys.ENDERITE_EXCAVATOR_WIDTH, 9);
        ENDERITE_EXCAVATOR_DEPTH = config.getOrDefault(Reference.ConfigKeys.ENDERITE_EXCAVATOR_DEPTH, 1);
        ENDERITE_HAMMER_WIDTH = config.getOrDefault(Reference.ConfigKeys.ENDERITE_HAMMER_WIDTH, 5);
        ENDERITE_HAMMER_DEPTH = config.getOrDefault(Reference.ConfigKeys.ENDERITE_HAMMER_DEPTH, 5);

        RUBY_EXCAVATOR_WIDTH = config.getOrDefault(Reference.ConfigKeys.RUBY_EXCAVATOR_WIDTH, 5);
        RUBY_EXCAVATOR_DEPTH = config.getOrDefault(Reference.ConfigKeys.RUBY_EXCAVATOR_DEPTH, 1);
        RUBY_HAMMER_WIDTH = config.getOrDefault(Reference.ConfigKeys.RUBY_HAMMER_WIDTH, 5);
        RUBY_HAMMER_DEPTH = config.getOrDefault(Reference.ConfigKeys.RUBY_HAMMER_DEPTH, 2);

        SAPPHIRE_EXCAVATOR_WIDTH = config.getOrDefault(Reference.ConfigKeys.SAPPHIRE_EXCAVATOR_WIDTH, 5);
        SAPPHIRE_EXCAVATOR_DEPTH = config.getOrDefault(Reference.ConfigKeys.SAPPHIRE_EXCAVATOR_DEPTH, 1);
        SAPPHIRE_HAMMER_WIDTH = config.getOrDefault(Reference.ConfigKeys.SAPPHIRE_HAMMER_WIDTH, 5);
        SAPPHIRE_HAMMER_DEPTH = config.getOrDefault(Reference.ConfigKeys.SAPPHIRE_HAMMER_DEPTH, 2);

        DIAMOND_EXCAVATOR_WIDTH = config.getOrDefault(Reference.ConfigKeys.DIAMOND_EXCAVATOR_WIDTH, 5);
        DIAMOND_EXCAVATOR_DEPTH = config.getOrDefault(Reference.ConfigKeys.DIAMOND_EXCAVATOR_DEPTH, 1);
        DIAMOND_HAMMER_WIDTH = config.getOrDefault(Reference.ConfigKeys.DIAMOND_HAMMER_WIDTH, 5);
        DIAMOND_HAMMER_DEPTH = config.getOrDefault(Reference.ConfigKeys.DIAMOND_HAMMER_DEPTH, 2);

        GOLD_EXCAVATOR_WIDTH = config.getOrDefault(Reference.ConfigKeys.GOLD_EXCAVATOR_WIDTH, 5);
        GOLD_EXCAVATOR_DEPTH = config.getOrDefault(Reference.ConfigKeys.GOLD_EXCAVATOR_DEPTH, 1);
        GOLD_HAMMER_WIDTH = config.getOrDefault(Reference.ConfigKeys.GOLD_HAMMER_WIDTH, 5);
        GOLD_HAMMER_DEPTH = config.getOrDefault(Reference.ConfigKeys.GOLD_HAMMER_DEPTH, 1);

        IRON_EXCAVATOR_WIDTH = config.getOrDefault(Reference.ConfigKeys.IRON_EXCAVATOR_WIDTH, 5);
        IRON_EXCAVATOR_DEPTH = config.getOrDefault(Reference.ConfigKeys.IRON_EXCAVATOR_DEPTH, 1);
        IRON_HAMMER_WIDTH = config.getOrDefault(Reference.ConfigKeys.IRON_HAMMER_WIDTH, 5);
        IRON_HAMMER_DEPTH = config.getOrDefault(Reference.ConfigKeys.IRON_HAMMER_DEPTH, 1);

        NETHERITE_EXCAVATOR_WIDTH = config.getOrDefault(Reference.ConfigKeys.NETHERITE_EXCAVATOR_WIDTH, 7);
        NETHERITE_EXCAVATOR_DEPTH = config.getOrDefault(Reference.ConfigKeys.NETHERITE_EXCAVATOR_DEPTH, 1);
        NETHERITE_HAMMER_WIDTH = config.getOrDefault(Reference.ConfigKeys.NETHERITE_HAMMER_WIDTH, 5);
        NETHERITE_HAMMER_DEPTH = config.getOrDefault(Reference.ConfigKeys.NETHERITE_HAMMER_DEPTH, 3);

        STONE_EXCAVATOR_WIDTH = config.getOrDefault(Reference.ConfigKeys.STONE_EXCAVATOR_WIDTH, 3);
        STONE_EXCAVATOR_DEPTH = config.getOrDefault(Reference.ConfigKeys.STONE_EXCAVATOR_DEPTH, 1);
        STONE_HAMMER_WIDTH = config.getOrDefault(Reference.ConfigKeys.STONE_HAMMER_WIDTH, 3);
        STONE_HAMMER_DEPTH = config.getOrDefault(Reference.ConfigKeys.STONE_HAMMER_DEPTH, 1);

        WOOD_EXCAVATOR_WIDTH = config.getOrDefault(Reference.ConfigKeys.WOOD_EXCAVATOR_WIDTH, 3);
        WOOD_EXCAVATOR_DEPTH = config.getOrDefault(Reference.ConfigKeys.WOOD_EXCAVATOR_DEPTH, 1);
        WOOD_HAMMER_WIDTH = config.getOrDefault(Reference.ConfigKeys.WOOD_HAMMER_WIDTH, 3);
        WOOD_HAMMER_DEPTH = config.getOrDefault(Reference.ConfigKeys.WOOD_HAMMER_DEPTH, 1);
    }
}