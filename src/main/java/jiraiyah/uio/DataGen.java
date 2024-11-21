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

import jiraiyah.uio.datagen.*;
import jiraiyah.uio.datagen.world.ModConfiguredFeatures;
import jiraiyah.uio.datagen.world.ModPlacedFeatures;
import jiraiyah.uio.datagen.world.ModWorldGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

import static jiraiyah.uio.Main.LOGGER;

/**
 * The DataGen class implements the DataGeneratorEntrypoint interface,
 * providing the entry point for generating data packs for the mod.
 */
public class DataGen implements DataGeneratorEntrypoint
{
    /**
     * Initializes the data generator, setting up various data providers
     * and logging the beginning of the data generation process.
     *
     * @param fabricDataGenerator the FabricDataGenerator instance used for data generation
     */
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator)
    {
        LOGGER.logBackRGB256("Generating Data", 255, 255, 0, 0, 155, 55);

        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModEntityTagProvider::new);
        pack.addProvider(ModLootTableProvider::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModWorldGenerator::new);
        pack.addProvider(ModEnLanguageProvider::new);
    }

    /**
     * Builds the registry for configured and placed features.
     * <p>
     * This method is responsible for registering data generation features
     * to the provided {@link RegistryBuilder}. It adds the necessary
     * configured and placed features, allowing them to be used within
     * the game's world generation.
     *
     * @param registryBuilder The {@link RegistryBuilder} instance used
     *                        to register the configured and placed features.
     */
    @Override
    public void buildRegistry(RegistryBuilder registryBuilder)
    {
        LOGGER.logRGB256("Registering Data Generation Features", 0, 255, 0);

        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
    }
}