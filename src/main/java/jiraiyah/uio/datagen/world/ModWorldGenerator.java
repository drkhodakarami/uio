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

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static jiraiyah.uio.Reference.ModID;

/**
 * The `ModWorldGenerator` class is responsible for generating world data for the mod.
 * It extends the `FabricDynamicRegistryProvider` to utilize Fabric's data generation capabilities.
 * This class configures the necessary features and placements for the mod's world generation.
 */
public class ModWorldGenerator extends FabricDynamicRegistryProvider
{
    /**
     * Constructs a new `ModWorldGenerator` instance.
     *
     * @param output The `FabricDataOutput` instance used for data generation output.
     * @param registriesFuture A `CompletableFuture` that provides access to the `RegistryWrapper.WrapperLookup`,
     *                         which contains the registries needed for world generation.
     */
    public ModWorldGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, registriesFuture);
    }

    /**
     * Returns the name of the mod, which is used to identify the mod within the Minecraft ecosystem.
     *
     * @return The mod ID as a `String`.
     */
    @Override
    public String getName()
    {
        return ModID;
    }

    /**
     * Configures the world generation by adding entries to the registry.
     * This method is responsible for registering configured and placed features.
     *
     * @param registries The `RegistryWrapper.WrapperLookup` providing access to the necessary registries.
     * @param entries The `Entries` object used to add configured and placed features to the registry.
     */
    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries)
    {
        entries.addAll(registries.getOrThrow(RegistryKeys.CONFIGURED_FEATURE));
        entries.addAll(registries.getOrThrow(RegistryKeys.PLACED_FEATURE));
    }
}