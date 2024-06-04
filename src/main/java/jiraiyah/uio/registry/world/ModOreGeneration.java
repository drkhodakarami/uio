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

package jiraiyah.uio.registry.world;

import jiraiyah.uio.datagen.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

import static jiraiyah.uio.Reference.log;

public class ModOreGeneration
{
    public ModOreGeneration()
    {
        throw new AssertionError();
    }

    public static void generate()
    {
        log("Registering Ore Data");

        //region OVERWORLD

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                                              GenerationStep.Feature.UNDERGROUND_ORES,
                            ModPlacedFeatures.ORE_CITRINE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                                              GenerationStep.Feature.UNDERGROUND_ORES,
                            ModPlacedFeatures.ORE_RUBY_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                                              GenerationStep.Feature.UNDERGROUND_ORES,
                            ModPlacedFeatures.ORE_SAPPHIRE_PLACED_KEY);

        //endregion

        //region NETHER
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                                              GenerationStep.Feature.UNDERGROUND_ORES,
                            ModPlacedFeatures.ORE_NETHER_CITRINE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                                              GenerationStep.Feature.UNDERGROUND_ORES,
                            ModPlacedFeatures.ORE_NETHER_RUBY_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                                              GenerationStep.Feature.UNDERGROUND_ORES,
                            ModPlacedFeatures.ORE_NETHER_SAPPHIRE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                                              GenerationStep.Feature.UNDERGROUND_ORES,
                            ModPlacedFeatures.ORE_NETHER_COAL_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                                              GenerationStep.Feature.UNDERGROUND_ORES,
                            ModPlacedFeatures.ORE_NETHER_COPPER_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                                              GenerationStep.Feature.UNDERGROUND_ORES,
                            ModPlacedFeatures.ORE_NETHER_DIAMOND_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                                              GenerationStep.Feature.UNDERGROUND_ORES,
                            ModPlacedFeatures.ORE_NETHER_IRON_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                                              GenerationStep.Feature.UNDERGROUND_ORES,
                            ModPlacedFeatures.ORE_NETHER_LAPIS_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(),
                                              GenerationStep.Feature.UNDERGROUND_ORES,
                            ModPlacedFeatures.ORE_NETHER_REDSTONE_PLACED_KEY);
        //endregion

        //region END
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                                              GenerationStep.Feature.UNDERGROUND_ORES,
                            ModPlacedFeatures.ORE_END_CITRINE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                                              GenerationStep.Feature.UNDERGROUND_ORES,
                            ModPlacedFeatures.ORE_END_RUBY_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                                              GenerationStep.Feature.UNDERGROUND_ORES,
                            ModPlacedFeatures.ORE_END_SAPPHIRE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                                              GenerationStep.Feature.UNDERGROUND_ORES,
                            ModPlacedFeatures.ORE_END_ENDERITE_PLACED_KEY);
        //endregion
    }
}