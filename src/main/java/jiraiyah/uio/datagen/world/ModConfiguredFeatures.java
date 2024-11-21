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

package jiraiyah.uio.datagen.world;

import jiraiyah.uio.registry.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

import static jiraiyah.jiregister.Registers.Datagen.register;
import static jiraiyah.jiregister.Registers.getKey;
import static jiraiyah.uio.Main.LOGGER;

/**
 * The `ModConfiguredFeatures` class is responsible for defining and registering
 * various ore generation features within the mod. It includes configurations for
 * different types of ores that can be generated in the Overworld, Nether, and End
 * dimensions. This class utilizes the Minecraft registry system to ensure that
 * each feature is uniquely identified and properly registered.
 */
public class ModConfiguredFeatures
{
    public static RegistryKey<ConfiguredFeature<?, ?>> ORE_CITRINE_KEY, ORE_RUBY_KEY, ORE_SAPPHIRE_KEY,
            ORE_NETHER_CITRINE_KEY, ORE_NETHER_RUBY_KEY, ORE_NETHER_SAPPHIRE_KEY,
            ORE_NETHER_COAL_KEY, ORE_NETHER_COPPER_KEY, ORE_NETHER_DIAMOND_KEY, ORE_NETHER_IRON_KEY, ORE_NETHER_LAPIS_KEY,
            ORE_NETHER_REDSTONE_KEY,
            ORE_END_CITRINE_KEY, ORE_END_RUBY_KEY, ORE_END_SAPPHIRE_KEY, ORE_END_ENDERITE_KEY;

    /**
     * Constructs a new `ModConfiguredFeatures` instance.
     * This constructor is private to prevent instantiation, as this class is
     * intended to be used statically.
     *
     * @throws AssertionError if an attempt is made to instantiate this class.
     */
    public ModConfiguredFeatures()
    {
        throw new AssertionError();
    }

    /**
     * Initializes and registers all configured features for ore generation.
     * This method sets up the ore generation rules and registers each ore
     * feature with the provided registry context. It logs the process of
     * generating configured features data for debugging purposes.
     *
     * @param context The registry context used to register configured features.
     */
    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context)
    {
        LOGGER.logRGB256("Generating Configured Features Data", 0, 255, 0);

        init();

        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        //region OVERWORLD
        List<OreFeatureConfig.Target> overworldCitrineOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.ORE_WORLD_CITRINE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepReplaceables, ModBlocks.ORE_DEEP_CITRINE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldRubyOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.ORE_WORLD_RUBY.getDefaultState()),
                        OreFeatureConfig.createTarget(deepReplaceables, ModBlocks.ORE_DEEP_RUBY.getDefaultState()));

        List<OreFeatureConfig.Target> overworldSapphireOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.ORE_WORLD_SAPPHIRE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepReplaceables, ModBlocks.ORE_DEEP_SAPPHIRE.getDefaultState()));
        //endregion

        //region NETHER
        List<OreFeatureConfig.Target> netherCitrineOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.ORE_NETHER_CITRINE.getDefaultState()));

        List<OreFeatureConfig.Target> netherRubyOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.ORE_NETHER_RUBY.getDefaultState()));

        List<OreFeatureConfig.Target> netherSapphireOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.ORE_NETHER_SAPPHIRE.getDefaultState()));

        List<OreFeatureConfig.Target> netherCoalOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.ORE_NETHER_COAL.getDefaultState()));

        List<OreFeatureConfig.Target> netherCopperOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.ORE_NETHER_COPPER.getDefaultState()));

        List<OreFeatureConfig.Target> netherDiamondOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.ORE_NETHER_DIAMOND.getDefaultState()));

        List<OreFeatureConfig.Target> netherIronOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.ORE_NETHER_IRON.getDefaultState()));

        List<OreFeatureConfig.Target> netherLapisOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.ORE_NETHER_LAPIS.getDefaultState()));

        List<OreFeatureConfig.Target> netherRedstoneOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.ORE_NETHER_REDSTONE.getDefaultState()));
        //endregion

        //region END
        List<OreFeatureConfig.Target> endCitrineOres =
                List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.ORE_END_CITRINE.getDefaultState()));

        List<OreFeatureConfig.Target> endRubyOres =
                List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.ORE_END_RUBY.getDefaultState()));

        List<OreFeatureConfig.Target> endSapphireOres =
                List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.ORE_END_SAPPHIRE.getDefaultState()));

        List<OreFeatureConfig.Target> endEnderiteOres =
                List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.ORE_END_ENDERITE.getDefaultState()));
        //endregion

        // 3 --> Vein Size Per Vein
        register(context, ORE_CITRINE_KEY, Feature.ORE, new OreFeatureConfig(overworldCitrineOres, 8));
        register(context, ORE_RUBY_KEY, Feature.ORE, new OreFeatureConfig(overworldRubyOres, 8));
        register(context, ORE_SAPPHIRE_KEY, Feature.ORE, new OreFeatureConfig(overworldSapphireOres, 8));

        register(context, ORE_NETHER_CITRINE_KEY, Feature.ORE, new OreFeatureConfig(netherCitrineOres, 3));
        register(context, ORE_NETHER_RUBY_KEY, Feature.ORE, new OreFeatureConfig(netherRubyOres, 3));
        register(context, ORE_NETHER_SAPPHIRE_KEY, Feature.ORE, new OreFeatureConfig(netherSapphireOres, 3));

        register(context, ORE_NETHER_COAL_KEY, Feature.ORE, new OreFeatureConfig(netherCoalOres, 12));
        register(context, ORE_NETHER_COPPER_KEY, Feature.ORE, new OreFeatureConfig(netherCopperOres, 8));
        register(context, ORE_NETHER_DIAMOND_KEY, Feature.ORE, new OreFeatureConfig(netherDiamondOres, 3));
        register(context, ORE_NETHER_IRON_KEY, Feature.ORE, new OreFeatureConfig(netherIronOres, 8));
        register(context, ORE_NETHER_LAPIS_KEY, Feature.ORE, new OreFeatureConfig(netherLapisOres, 8));
        register(context, ORE_NETHER_REDSTONE_KEY, Feature.ORE, new OreFeatureConfig(netherRedstoneOres, 6));

        register(context, ORE_END_CITRINE_KEY, Feature.ORE, new OreFeatureConfig(endCitrineOres, 3));
        register(context, ORE_END_RUBY_KEY, Feature.ORE, new OreFeatureConfig(endRubyOres, 3));
        register(context, ORE_END_SAPPHIRE_KEY, Feature.ORE, new OreFeatureConfig(endSapphireOres, 3));
        register(context, ORE_END_ENDERITE_KEY, Feature.ORE, new OreFeatureConfig(endEnderiteOres, 3));
    }

    /**
     * Initializes the registry keys for all configured ore features.
     * This method assigns unique `RegistryKey` instances to each ore type,
     * ensuring that they can be registered and identified within the
     * Minecraft registry system. It uses the `getKey` method to create
     * keys for ores in the Overworld, Nether, and End dimensions.
     */
    private static void init()
    {
        ORE_CITRINE_KEY = getKey("ore_citrine", RegistryKeys.CONFIGURED_FEATURE);
        ORE_RUBY_KEY = getKey("ore_ruby", RegistryKeys.CONFIGURED_FEATURE);
        ORE_SAPPHIRE_KEY = getKey("ore_sapphire", RegistryKeys.CONFIGURED_FEATURE);

        ORE_NETHER_CITRINE_KEY = getKey("ore_nether_citrine", RegistryKeys.CONFIGURED_FEATURE);
        ORE_NETHER_RUBY_KEY = getKey("ore_nether_ruby", RegistryKeys.CONFIGURED_FEATURE);
        ORE_NETHER_SAPPHIRE_KEY = getKey("ore_nether_sapphire", RegistryKeys.CONFIGURED_FEATURE);

        ORE_NETHER_COAL_KEY = getKey("ore_nether_coal", RegistryKeys.CONFIGURED_FEATURE);
        ORE_NETHER_COPPER_KEY = getKey("ore_nether_copper", RegistryKeys.CONFIGURED_FEATURE);
        ORE_NETHER_DIAMOND_KEY = getKey("ore_nether_diamond", RegistryKeys.CONFIGURED_FEATURE);
        ORE_NETHER_IRON_KEY = getKey("ore_nether_iron", RegistryKeys.CONFIGURED_FEATURE);
        ORE_NETHER_LAPIS_KEY = getKey("ore_nether_lapis", RegistryKeys.CONFIGURED_FEATURE);
        ORE_NETHER_REDSTONE_KEY = getKey("ore_nether_redstone", RegistryKeys.CONFIGURED_FEATURE);

        ORE_END_CITRINE_KEY = getKey("ore_end_citrine", RegistryKeys.CONFIGURED_FEATURE);
        ORE_END_RUBY_KEY = getKey("ore_end_ruby", RegistryKeys.CONFIGURED_FEATURE);
        ORE_END_SAPPHIRE_KEY = getKey("ore_end_sapphire", RegistryKeys.CONFIGURED_FEATURE);
        ORE_END_ENDERITE_KEY = getKey("ore_end_enderite", RegistryKeys.CONFIGURED_FEATURE);
    }
}