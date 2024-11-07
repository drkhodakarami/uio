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

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

import static jiraiyah.uio.Reference.logRGB256;
import static jiraiyah.uio.util.registry.Registers.getKey;
import static jiraiyah.uio.util.registry.Registers.Datagen.*;

/**
 * The `ModPlacedFeatures` class is responsible for defining and registering
 * various ore placement features within the game world. It includes registry
 * keys for different types of ores across different dimensions such as the
 * Overworld, Nether, and End. This class ensures that these features are
 * properly registered and available for world generation.
 */
public class ModPlacedFeatures
{
    public static RegistryKey<PlacedFeature> ORE_CITRINE_PLACED_KEY, ORE_RUBY_PLACED_KEY, ORE_SAPPHIRE_PLACED_KEY,
            ORE_NETHER_CITRINE_PLACED_KEY, ORE_NETHER_RUBY_PLACED_KEY, ORE_NETHER_SAPPHIRE_PLACED_KEY,
            ORE_NETHER_COAL_PLACED_KEY, ORE_NETHER_COPPER_PLACED_KEY, ORE_NETHER_DIAMOND_PLACED_KEY, ORE_NETHER_IRON_PLACED_KEY, ORE_NETHER_LAPIS_PLACED_KEY,
            ORE_NETHER_REDSTONE_PLACED_KEY,
            ORE_END_CITRINE_PLACED_KEY, ORE_END_RUBY_PLACED_KEY, ORE_END_SAPPHIRE_PLACED_KEY, ORE_END_ENDERITE_PLACED_KEY;

    /**
     * Constructs a new `ModPlacedFeatures` instance.
     * This constructor is private to prevent instantiation of this utility class.
     * It throws an `AssertionError` if called, as this class is not meant to be instantiated.
     */
    public ModPlacedFeatures()
    {
        throw new AssertionError();
    }

    /**
     * Bootstraps the registration process for placed features.
     * This method is responsible for logging the start of the registration process
     * and registering all the defined ore placement features using the provided context.
     *
     * @param context The `Registerable` context used to register placed features.
     */
    public static void bootstrap(Registerable<PlacedFeature> context)
    {
        logRGB256("Generating Placed Features Data", 0, 255, 0);

        init();

        var lookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        //region OVERWORLD
        register(context, ORE_CITRINE_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_CITRINE_KEY),
                 modifiersWithCount(2, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(4), YOffset.aboveBottom(64))));

        register(context, ORE_RUBY_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_RUBY_KEY),
                 modifiersWithCount(2, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(4), YOffset.aboveBottom(64))));

        register(context, ORE_SAPPHIRE_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_SAPPHIRE_KEY),
                 modifiersWithCount(2, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(4), YOffset.aboveBottom(64))));
        //endregion

        //region NETHER
        register(context, ORE_NETHER_CITRINE_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_NETHER_CITRINE_KEY),
                 modifiersWithCount(3, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(32), YOffset.belowTop(5))));

        register(context, ORE_NETHER_RUBY_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_NETHER_RUBY_KEY),
                 modifiersWithCount(3, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(32), YOffset.belowTop(5))));

        register(context, ORE_NETHER_SAPPHIRE_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_NETHER_SAPPHIRE_KEY),
                 modifiersWithCount(3, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(32), YOffset.belowTop(5))));

        register(context, ORE_NETHER_COAL_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_NETHER_COAL_KEY),
                 modifiersWithCount(16, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(32), YOffset.belowTop(5))));

        register(context, ORE_NETHER_COPPER_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_NETHER_COPPER_KEY),
                 modifiersWithCount(10, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(32), YOffset.belowTop(5))));

        register(context, ORE_NETHER_DIAMOND_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_NETHER_DIAMOND_KEY),
                 modifiersWithCount(4, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(32), YOffset.aboveBottom(42))));

        register(context, ORE_NETHER_IRON_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_NETHER_IRON_KEY),
                 modifiersWithCount(14, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(32), YOffset.belowTop(5))));

        register(context, ORE_NETHER_LAPIS_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_NETHER_LAPIS_KEY),
                 modifiersWithCount(10, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(32), YOffset.belowTop(5))));

        register(context, ORE_NETHER_REDSTONE_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_NETHER_REDSTONE_KEY),
                 modifiersWithCount(10, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(32), YOffset.belowTop(5))));
        //endregion

        //region END
        register(context, ORE_END_CITRINE_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_END_CITRINE_KEY),
                 modifiersWithCount(1, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.fixed(50), YOffset.fixed(65))));

        register(context, ORE_END_RUBY_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_END_RUBY_KEY),
                 modifiersWithCount(1, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.fixed(50), YOffset.fixed(65))));

        register(context, ORE_END_SAPPHIRE_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_END_SAPPHIRE_KEY),
                 modifiersWithCount(1, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.fixed(50), YOffset.fixed(65))));

        register(context, ORE_END_ENDERITE_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.ORE_END_ENDERITE_KEY),
                 modifiersWithCount(3, // Veins per chunk
                                    HeightRangePlacementModifier.uniform(YOffset.fixed(50), YOffset.fixed(65))));
        //endregion
    }

    /**
     * Initializes the registry keys for various ore placement features.
     * This method assigns unique `RegistryKey` instances to each ore type
     * across different dimensions (Overworld, Nether, and End). These keys
     * are used to register the corresponding placed features in the game world.
     * The method utilizes the `getKey` utility to generate keys based on ore names
     * and the `PLACED_FEATURE` registry type.
     */
    public static void init()
    {
        ORE_CITRINE_PLACED_KEY = getKey("ore_citrine_placed", RegistryKeys.PLACED_FEATURE);
        ORE_RUBY_PLACED_KEY = getKey("ore_ruby_placed", RegistryKeys.PLACED_FEATURE);
        ORE_SAPPHIRE_PLACED_KEY = getKey("ore_sapphire_placed", RegistryKeys.PLACED_FEATURE);

        ORE_NETHER_CITRINE_PLACED_KEY = getKey("ore_nether_citrine_placed", RegistryKeys.PLACED_FEATURE);
        ORE_NETHER_RUBY_PLACED_KEY = getKey("ore_nether_ruby_placed", RegistryKeys.PLACED_FEATURE);
        ORE_NETHER_SAPPHIRE_PLACED_KEY = getKey("ore_nether_sapphire_placed", RegistryKeys.PLACED_FEATURE);

        ORE_NETHER_COAL_PLACED_KEY = getKey("ore_nether_coal_placed", RegistryKeys.PLACED_FEATURE);
        ORE_NETHER_COPPER_PLACED_KEY = getKey("ore_nether_copper_placed", RegistryKeys.PLACED_FEATURE);
        ORE_NETHER_DIAMOND_PLACED_KEY = getKey("ore_nether_diamond_placed", RegistryKeys.PLACED_FEATURE);
        ORE_NETHER_IRON_PLACED_KEY = getKey("ore_nether_iron_placed", RegistryKeys.PLACED_FEATURE);
        ORE_NETHER_LAPIS_PLACED_KEY = getKey("ore_nether_lapis_placed", RegistryKeys.PLACED_FEATURE);
        ORE_NETHER_REDSTONE_PLACED_KEY = getKey("ore_nether_redstone_placed", RegistryKeys.PLACED_FEATURE);

        ORE_END_CITRINE_PLACED_KEY = getKey("ore_end_citrine_placed", RegistryKeys.PLACED_FEATURE);
        ORE_END_RUBY_PLACED_KEY = getKey("ore_end_ruby_placed", RegistryKeys.PLACED_FEATURE);
        ORE_END_SAPPHIRE_PLACED_KEY = getKey("ore_end_sapphire_placed", RegistryKeys.PLACED_FEATURE);
        ORE_END_ENDERITE_PLACED_KEY = getKey("ore_end_enderite_placed", RegistryKeys.PLACED_FEATURE);
    }
}