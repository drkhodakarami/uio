package jiraiyah.uio;

import com.mojang.datafixers.util.Pair;
import jiraiyah.uio.util.config.BaseConfig;
import jiraiyah.uio.util.config.ConfigProvider;

import static jiraiyah.uio.Reference.ModID;
import static jiraiyah.uio.Reference.*;

public class Configs
{
    public static BaseConfig CONFIG;

    public static int DCLR_RADIUS;
    public static int CITRINE_SWORD_DURATION;
    public static int COPPER_SWORD_DURATION;

    public static int SAPPHIRE_SWORD_DURATION;
    public static double SAPPHIRE_SWORD_MULTIPLIER;

    public static int EXCAVATOR_MAX_DISTANCE;
    public static int HAMMER_MAX_DISTANCE;

    public static int CITRINE_EXCAVATOR_WIDTH;
    public static int CITRINE_EXCAVATOR_DEPTH;
    public static int CITRINE_HAMMER_WIDTH;
    public static int CITRINE_HAMMER_DEPTH;

    public static int COPPER_EXCAVATOR_WIDTH;
    public static int COPPER_EXCAVATOR_DEPTH;
    public static int COPPER_HAMMER_WIDTH;
    public static int COPPER_HAMMER_DEPTH;

    public static int ENDERITE_EXCAVATOR_WIDTH;
    public static int ENDERITE_EXCAVATOR_DEPTH;
    public static int ENDERITE_HAMMER_WIDTH;
    public static int ENDERITE_HAMMER_DEPTH;

    public static int RUBY_EXCAVATOR_WIDTH;
    public static int RUBY_EXCAVATOR_DEPTH;
    public static int RUBY_HAMMER_WIDTH;
    public static int RUBY_HAMMER_DEPTH;

    public static int SAPPHIRE_EXCAVATOR_WIDTH;
    public static int SAPPHIRE_EXCAVATOR_DEPTH;
    public static int SAPPHIRE_HAMMER_WIDTH;
    public static int SAPPHIRE_HAMMER_DEPTH;

    public static int DIAMOND_EXCAVATOR_WIDTH;
    public static int DIAMOND_EXCAVATOR_DEPTH;
    public static int DIAMOND_HAMMER_WIDTH;
    public static int DIAMOND_HAMMER_DEPTH;

    public static int GOLD_EXCAVATOR_WIDTH;
    public static int GOLD_EXCAVATOR_DEPTH;
    public static int GOLD_HAMMER_WIDTH;
    public static int GOLD_HAMMER_DEPTH;

    public static int IRON_EXCAVATOR_WIDTH;
    public static int IRON_EXCAVATOR_DEPTH;
    public static int IRON_HAMMER_WIDTH;
    public static int IRON_HAMMER_DEPTH;

    public static int NETHERITE_EXCAVATOR_WIDTH;
    public static int NETHERITE_EXCAVATOR_DEPTH;
    public static int NETHERITE_HAMMER_WIDTH;
    public static int NETHERITE_HAMMER_DEPTH;

    public static int STONE_EXCAVATOR_WIDTH;
    public static int STONE_EXCAVATOR_DEPTH;
    public static int STONE_HAMMER_WIDTH;
    public static int STONE_HAMMER_DEPTH;

    public static int WOOD_EXCAVATOR_WIDTH;
    public static int WOOD_EXCAVATOR_DEPTH;
    public static int WOOD_HAMMER_WIDTH;
    public static int WOOD_HAMMER_DEPTH;

    private static ConfigProvider provider;

    public static void load()
    {
        provider = new ConfigProvider();
        createConfigs();

        CONFIG = BaseConfig.of(ModID + "_config").provider(provider).request();

        logN("All " + provider.getConfigList().size() + " config entries have been set properly");

        assignConfigValues();

        logN("All " + provider.getConfigList().size() + " config entries have been loaded properly");
    }

    private static void createConfigs()
    {
        provider.addComment("===================================================================================================");
        provider.addComment("===============================            COMMANDS SETTINGS            ===========================");
        provider.addComment("===================================================================================================");
        provider.addComment("The radius for DCLR command, this will be the value for the command to expand on each side.");
        provider.addComment("The final dimension would be (radius * 2) + 1.");
        provider.addPair(new Pair<>(Keys.Config.DCLR, 128));

        provider.addComment("===================================================================================================");
        provider.addComment("===============================             SWORDS SETTINGS             ===========================");
        provider.addComment("===================================================================================================");
        //provider.addComment("The effect duration for citrine sword.");
        provider.addPair(new Pair<>(Keys.Config.CITRINE_SWORD_DURATION, 200));

        //provider.addComment("The effect duration for copper sword.");
        provider.addPair(new Pair<>(Keys.Config.COPPER_SWORD_DURATION, 200));

        //provider.addComment("The effect duration for sapphire sword.");
        provider.addPair(new Pair<>(Keys.Config.SAPPHIRE_SWORD_DURATION, 200), false);
        //provider.addComment("The velocity multiplier for sapphire sword.");
        provider.addPair(new Pair<>(Keys.Config.SAPPHIRE_SWORD_MULTIPLIER, 5.0d));

        provider.addComment("===================================================================================================");
        provider.addComment("===============================         EXCAVATOR ITEM SETTINGS         ===========================");
        provider.addComment("===================================================================================================");

        provider.addComment("The max distance for all of the excavators.");
        provider.addPair(new Pair<>(Keys.Config.EXCAVATOR_MAX_DISTANCE, 8));

        provider.addComment("Width Value: If you set this as a number like 3, it means the excavator will break 3 by 3 blocks.");
        provider.addComment("Depth Value: If you set this as a number like 2, it means the excavator will break 2 blocks deep.");
        provider.addNewLine();

        provider.addPair(new Pair<>(Keys.Config.CITRINE_EXCAVATOR_WIDTH, 5), false);
        provider.addPair(new Pair<>(Keys.Config.CITRINE_EXCAVATOR_DEPTH, 1));

        provider.addPair(new Pair<>(Keys.Config.COPPER_EXCAVATOR_WIDTH, 3), false);
        provider.addPair(new Pair<>(Keys.Config.COPPER_EXCAVATOR_DEPTH, 1));

        provider.addPair(new Pair<>(Keys.Config.ENDERITE_EXCAVATOR_WIDTH, 9), false);
        provider.addPair(new Pair<>(Keys.Config.ENDERITE_EXCAVATOR_DEPTH, 1));

        provider.addPair(new Pair<>(Keys.Config.RUBY_EXCAVATOR_WIDTH, 5), false);
        provider.addPair(new Pair<>(Keys.Config.RUBY_EXCAVATOR_DEPTH, 1));

        provider.addPair(new Pair<>(Keys.Config.SAPPHIRE_EXCAVATOR_WIDTH, 5), false);
        provider.addNewLine();
        provider.addPair(new Pair<>(Keys.Config.SAPPHIRE_EXCAVATOR_DEPTH, 1));

        provider.addPair(new Pair<>(Keys.Config.DIAMOND_EXCAVATOR_WIDTH, 5), false);
        provider.addPair(new Pair<>(Keys.Config.DIAMOND_EXCAVATOR_DEPTH, 1));

        provider.addPair(new Pair<>(Keys.Config.GOLD_EXCAVATOR_WIDTH, 5), false);
        provider.addPair(new Pair<>(Keys.Config.GOLD_EXCAVATOR_DEPTH, 1));

        provider.addPair(new Pair<>(Keys.Config.IRON_EXCAVATOR_WIDTH, 5), false);
        provider.addPair(new Pair<>(Keys.Config.IRON_EXCAVATOR_DEPTH, 1));

        provider.addPair(new Pair<>(Keys.Config.NETHERITE_EXCAVATOR_WIDTH, 7), false);
        provider.addPair(new Pair<>(Keys.Config.NETHERITE_EXCAVATOR_DEPTH, 1));

        provider.addPair(new Pair<>(Keys.Config.STONE_EXCAVATOR_WIDTH, 3), false);
        provider.addPair(new Pair<>(Keys.Config.STONE_EXCAVATOR_DEPTH, 1));

        provider.addPair(new Pair<>(Keys.Config.WOOD_EXCAVATOR_WIDTH, 3), false);
        provider.addPair(new Pair<>(Keys.Config.WOOD_EXCAVATOR_DEPTH, 1));

        provider.addComment("===================================================================================================");
        provider.addComment("===============================           HAMMER ITEM SETTINGS          ===========================");
        provider.addComment("===================================================================================================");

        provider.addComment("The max distance for all of the hammers.");
        provider.addPair(new Pair<>(Keys.Config.HAMMER_MAX_DISTANCE, 8));

        provider.addComment("Width Value: If you set this as a number like 3, it means the hammer will break 3 by 3 blocks.");
        provider.addComment("Depth Value: If you set this as a number like 2, it means the hammer will break 2 blocks deep.");
        provider.addNewLine();

        provider.addPair(new Pair<>(Keys.Config.CITRINE_HAMMER_WIDTH, 3), false);
        provider.addPair(new Pair<>(Keys.Config.CITRINE_HAMMER_DEPTH, 2));

        provider.addPair(new Pair<>(Keys.Config.COPPER_HAMMER_WIDTH, 3), false);
        provider.addPair(new Pair<>(Keys.Config.COPPER_HAMMER_DEPTH, 2));

        provider.addPair(new Pair<>(Keys.Config.ENDERITE_HAMMER_WIDTH, 5), false);
        provider.addPair(new Pair<>(Keys.Config.ENDERITE_HAMMER_DEPTH, 5));

        provider.addPair(new Pair<>(Keys.Config.RUBY_HAMMER_WIDTH, 5), false);
        provider.addPair(new Pair<>(Keys.Config.RUBY_HAMMER_DEPTH, 2));

        provider.addPair(new Pair<>(Keys.Config.SAPPHIRE_HAMMER_WIDTH, 5), false);
        provider.addPair(new Pair<>(Keys.Config.SAPPHIRE_HAMMER_DEPTH, 2));

        provider.addPair(new Pair<>(Keys.Config.DIAMOND_HAMMER_WIDTH, 5), false);
        provider.addPair(new Pair<>(Keys.Config.DIAMOND_HAMMER_DEPTH, 2));

        provider.addPair(new Pair<>(Keys.Config.GOLD_HAMMER_WIDTH, 5), false);
        provider.addPair(new Pair<>(Keys.Config.GOLD_HAMMER_DEPTH, 1));

        provider.addPair(new Pair<>(Keys.Config.IRON_HAMMER_WIDTH, 5), false);
        provider.addPair(new Pair<>(Keys.Config.IRON_HAMMER_DEPTH, 1));

        provider.addPair(new Pair<>(Keys.Config.NETHERITE_HAMMER_WIDTH, 5), false);
        provider.addPair(new Pair<>(Keys.Config.NETHERITE_HAMMER_DEPTH, 3));

        provider.addPair(new Pair<>(Keys.Config.STONE_HAMMER_WIDTH, 3), false);
        provider.addPair(new Pair<>(Keys.Config.STONE_HAMMER_DEPTH, 1));

        provider.addPair(new Pair<>(Keys.Config.WOOD_HAMMER_WIDTH, 3), false);
        provider.addPair(new Pair<>(Keys.Config.WOOD_HAMMER_DEPTH, 1), false, true);
    }

    private static void assignConfigValues()
    {
        DCLR_RADIUS = CONFIG.getOrDefault(Keys.Config.DCLR, 128);
        CITRINE_SWORD_DURATION = CONFIG.getOrDefault(Keys.Config.CITRINE_SWORD_DURATION, 200);
        COPPER_SWORD_DURATION = CONFIG.getOrDefault(Keys.Config.COPPER_SWORD_DURATION, 200);
        SAPPHIRE_SWORD_DURATION = CONFIG.getOrDefault(Keys.Config.SAPPHIRE_SWORD_DURATION, 200);
        SAPPHIRE_SWORD_MULTIPLIER = CONFIG.getOrDefault(Keys.Config.SAPPHIRE_SWORD_MULTIPLIER, 5.0d);
        EXCAVATOR_MAX_DISTANCE = CONFIG.getOrDefault(Keys.Config.EXCAVATOR_MAX_DISTANCE, 8);
        HAMMER_MAX_DISTANCE = CONFIG.getOrDefault(Keys.Config.HAMMER_MAX_DISTANCE, 8);

        CITRINE_EXCAVATOR_WIDTH = CONFIG.getOrDefault(Keys.Config.CITRINE_EXCAVATOR_WIDTH, 5);
        CITRINE_EXCAVATOR_DEPTH = CONFIG.getOrDefault(Keys.Config.CITRINE_EXCAVATOR_DEPTH, 1);
        CITRINE_HAMMER_WIDTH = CONFIG.getOrDefault(Keys.Config.CITRINE_HAMMER_WIDTH, 3);
        CITRINE_HAMMER_DEPTH = CONFIG.getOrDefault(Keys.Config.CITRINE_HAMMER_DEPTH, 2);

        COPPER_EXCAVATOR_WIDTH = CONFIG.getOrDefault(Keys.Config.COPPER_EXCAVATOR_WIDTH, 3);
        COPPER_EXCAVATOR_DEPTH = CONFIG.getOrDefault(Keys.Config.COPPER_EXCAVATOR_DEPTH, 1);
        COPPER_HAMMER_WIDTH = CONFIG.getOrDefault(Keys.Config.COPPER_HAMMER_WIDTH, 3);
        COPPER_HAMMER_DEPTH = CONFIG.getOrDefault(Keys.Config.COPPER_HAMMER_DEPTH, 2);

        ENDERITE_EXCAVATOR_WIDTH = CONFIG.getOrDefault(Keys.Config.ENDERITE_EXCAVATOR_WIDTH, 9);
        ENDERITE_EXCAVATOR_DEPTH = CONFIG.getOrDefault(Keys.Config.ENDERITE_EXCAVATOR_DEPTH, 1);
        ENDERITE_HAMMER_WIDTH = CONFIG.getOrDefault(Keys.Config.ENDERITE_HAMMER_WIDTH, 5);
        ENDERITE_HAMMER_DEPTH = CONFIG.getOrDefault(Keys.Config.ENDERITE_HAMMER_DEPTH, 5);

        RUBY_EXCAVATOR_WIDTH = CONFIG.getOrDefault(Keys.Config.RUBY_EXCAVATOR_WIDTH, 5);
        RUBY_EXCAVATOR_DEPTH = CONFIG.getOrDefault(Keys.Config.RUBY_EXCAVATOR_DEPTH, 1);
        RUBY_HAMMER_WIDTH = CONFIG.getOrDefault(Keys.Config.RUBY_HAMMER_WIDTH, 5);
        RUBY_HAMMER_DEPTH = CONFIG.getOrDefault(Keys.Config.RUBY_HAMMER_DEPTH, 2);

        SAPPHIRE_EXCAVATOR_WIDTH = CONFIG.getOrDefault(Keys.Config.SAPPHIRE_EXCAVATOR_WIDTH, 5);
        SAPPHIRE_EXCAVATOR_DEPTH = CONFIG.getOrDefault(Keys.Config.SAPPHIRE_EXCAVATOR_DEPTH, 1);
        SAPPHIRE_HAMMER_WIDTH = CONFIG.getOrDefault(Keys.Config.SAPPHIRE_HAMMER_WIDTH, 5);
        SAPPHIRE_HAMMER_DEPTH = CONFIG.getOrDefault(Keys.Config.SAPPHIRE_HAMMER_DEPTH, 2);

        DIAMOND_EXCAVATOR_WIDTH = CONFIG.getOrDefault(Keys.Config.DIAMOND_EXCAVATOR_WIDTH, 5);
        DIAMOND_EXCAVATOR_DEPTH = CONFIG.getOrDefault(Keys.Config.DIAMOND_EXCAVATOR_DEPTH, 1);
        DIAMOND_HAMMER_WIDTH = CONFIG.getOrDefault(Keys.Config.DIAMOND_HAMMER_WIDTH, 5);
        DIAMOND_HAMMER_DEPTH = CONFIG.getOrDefault(Keys.Config.DIAMOND_HAMMER_DEPTH, 2);

        GOLD_EXCAVATOR_WIDTH = CONFIG.getOrDefault(Keys.Config.GOLD_EXCAVATOR_WIDTH, 5);
        GOLD_EXCAVATOR_DEPTH = CONFIG.getOrDefault(Keys.Config.GOLD_EXCAVATOR_DEPTH, 1);
        GOLD_HAMMER_WIDTH = CONFIG.getOrDefault(Keys.Config.GOLD_HAMMER_WIDTH, 5);
        GOLD_HAMMER_DEPTH = CONFIG.getOrDefault(Keys.Config.GOLD_HAMMER_DEPTH, 1);

        IRON_EXCAVATOR_WIDTH = CONFIG.getOrDefault(Keys.Config.IRON_EXCAVATOR_WIDTH, 5);
        IRON_EXCAVATOR_DEPTH = CONFIG.getOrDefault(Keys.Config.IRON_EXCAVATOR_DEPTH, 1);
        IRON_HAMMER_WIDTH = CONFIG.getOrDefault(Keys.Config.IRON_HAMMER_WIDTH, 5);
        IRON_HAMMER_DEPTH = CONFIG.getOrDefault(Keys.Config.IRON_HAMMER_DEPTH, 1);

        NETHERITE_EXCAVATOR_WIDTH = CONFIG.getOrDefault(Keys.Config.NETHERITE_EXCAVATOR_WIDTH, 7);
        NETHERITE_EXCAVATOR_DEPTH = CONFIG.getOrDefault(Keys.Config.NETHERITE_EXCAVATOR_DEPTH, 1);
        NETHERITE_HAMMER_WIDTH = CONFIG.getOrDefault(Keys.Config.NETHERITE_HAMMER_WIDTH, 5);
        NETHERITE_HAMMER_DEPTH = CONFIG.getOrDefault(Keys.Config.NETHERITE_HAMMER_DEPTH, 3);

        STONE_EXCAVATOR_WIDTH = CONFIG.getOrDefault(Keys.Config.STONE_EXCAVATOR_WIDTH, 3);
        STONE_EXCAVATOR_DEPTH = CONFIG.getOrDefault(Keys.Config.STONE_EXCAVATOR_DEPTH, 1);
        STONE_HAMMER_WIDTH = CONFIG.getOrDefault(Keys.Config.STONE_HAMMER_WIDTH, 3);
        STONE_HAMMER_DEPTH = CONFIG.getOrDefault(Keys.Config.STONE_HAMMER_DEPTH, 1);

        WOOD_EXCAVATOR_WIDTH = CONFIG.getOrDefault(Keys.Config.WOOD_EXCAVATOR_WIDTH, 3);
        WOOD_EXCAVATOR_DEPTH = CONFIG.getOrDefault(Keys.Config.WOOD_EXCAVATOR_DEPTH, 1);
        WOOD_HAMMER_WIDTH = CONFIG.getOrDefault(Keys.Config.WOOD_HAMMER_WIDTH, 3);
        WOOD_HAMMER_DEPTH = CONFIG.getOrDefault(Keys.Config.WOOD_HAMMER_DEPTH, 1);
    }
}