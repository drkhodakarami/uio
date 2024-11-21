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

package jiraiyah.uio.datagen;

import jiraiyah.uio.Main;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static jiraiyah.uio.Main.REFERENCE;

/**
 * The `ModEntityTagProvider` class is responsible for generating and configuring
 * entity type tags for the mod. It extends the `FabricTagProvider.EntityTypeTagProvider`
 * to utilize the data generation capabilities provided by the Fabric API.
 * This class defines specific entity type tags such as blacklists and whitelists
 * for various entities within the mod.
 */
public class ModEntityTagProvider extends FabricTagProvider.EntityTypeTagProvider
{
    /**
     * Constructs a new instance of `ModEntityTagProvider`.
     *
     * @param output The `FabricDataOutput` instance used for data generation output.
     * @param completableFuture A `CompletableFuture` that provides a `RegistryWrapper.WrapperLookup`
     *                          for accessing registry data during tag configuration.
     */
    public ModEntityTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture)
    {
        super(output, completableFuture);
    }

    /**
     * Configures the entity type tags by adding specific entities to predefined
     * blacklists and whitelists. This method is called during the data generation
     * process to populate the tags with the appropriate entities.
     *
     * @param arg A `RegistryWrapper.WrapperLookup` instance used to access registry
     *            data for configuring the tags.
     */
    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg)
    {
        Main.LOGGER.logRGB256("Generating Entity Tag Data", 0, 255, 0);

        getOrCreateTagBuilder(REFERENCE.TUNER_BLACKLIST)
                .add(EntityType.ENDER_DRAGON);

        getOrCreateTagBuilder(REFERENCE.ENDERITE_SWORD_BLACKLIST)
                .add(EntityType.ENDER_DRAGON)
                .add(EntityType.WITHER)
                .add(EntityType.WARDEN);

        getOrCreateTagBuilder(REFERENCE.RUBY_SWORD_WHITELIST)
                .add(EntityType.CAMEL)
                .add(EntityType.CHICKEN)
                .add(EntityType.DONKEY)
                .add(EntityType.COW)
                .add(EntityType.FOX)
                .add(EntityType.GOAT)
                .add(EntityType.HORSE)
                .add(EntityType.LLAMA)
                .add(EntityType.MOOSHROOM)
                .add(EntityType.MULE)
                .add(EntityType.PANDA)
                .add(EntityType.PIG)
                .add(EntityType.POLAR_BEAR)
                .add(EntityType.RABBIT)
                .add(EntityType.SHEEP)
                .add(EntityType.SNIFFER)
                .add(EntityType.WOLF);
    }
}