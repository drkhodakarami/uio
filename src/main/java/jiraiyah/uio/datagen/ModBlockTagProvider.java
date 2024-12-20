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
import jiraiyah.uio.registry.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

import static jiraiyah.uio.Main.REFERENCE;

/**
 * The `ModBlockTagProvider` class is responsible for generating block tag data for the mod.
 * It extends the `FabricTagProvider.BlockTagProvider` to utilize the Fabric API's data generation capabilities.
 * This class defines various block tags and associates them with specific blocks from the mod.
 */
public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider
{
    /**
     * Constructs a new `ModBlockTagProvider` instance.
     *
     * @param output           The `FabricDataOutput` instance used for data generation output.
     * @param registriesFuture A `CompletableFuture` that provides access to the `RegistryWrapper.WrapperLookup`,
     *                         which contains registry data needed for tag configuration.
     */
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, registriesFuture);
    }

    /**
     * Configures the block tags by associating specific blocks with predefined tags.
     * This method is called during the data generation process to define the relationships
     * between blocks and their respective tags.
     *
     * @param arg The `RegistryWrapper.WrapperLookup` instance providing access to the registry data.
     */
    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg)
    {
        Main.LOGGER.logRGB256("Generating Block Tag Data", 0, 255, 0);

        //region TOOL NEEDS
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.CITRINE)
                .add(ModBlocks.ENDERITE)
                .add(ModBlocks.RUBY)
                .add(ModBlocks.SAPPHIRE)
                .add(ModBlocks.RAW_CITRINE)
                .add(ModBlocks.RAW_ENDERITE)
                .add(ModBlocks.RAW_QUARTZ)
                .add(ModBlocks.RAW_RUBY)
                .add(ModBlocks.RAW_SAPPHIRE)
                .add(ModBlocks.ORE_DEEP_CITRINE)
                .add(ModBlocks.ORE_DEEP_RUBY)
                .add(ModBlocks.ORE_DEEP_SAPPHIRE)
                .add(ModBlocks.ORE_END_CITRINE)
                .add(ModBlocks.ORE_END_ENDERITE_CRACKED)
                .add(ModBlocks.ORE_END_RUBY)
                .add(ModBlocks.ORE_END_SAPPHIRE)
                .add(ModBlocks.ORE_ENDERITE)
                .add(ModBlocks.ORE_NETHER_CITRINE)
                .add(ModBlocks.ORE_NETHER_COAL)
                .add(ModBlocks.ORE_NETHER_COPPER)
                .add(ModBlocks.ORE_NETHER_DIAMOND)
                .add(ModBlocks.ORE_NETHER_IRON)
                .add(ModBlocks.ORE_NETHER_LAPIS)
                .add(ModBlocks.ORE_NETHER_REDSTONE)
                .add(ModBlocks.ORE_NETHER_RUBY)
                .add(ModBlocks.ORE_NETHER_SAPPHIRE)
                .add(ModBlocks.ORE_WORLD_CITRINE)
                .add(ModBlocks.ORE_WORLD_RUBY)
                .add(ModBlocks.ORE_WORLD_SAPPHIRE)
                .add(ModBlocks.ALLOY_MIXER)
                .add(ModBlocks.CAST_PRESS)
                .add(ModBlocks.GEM_CLEANER)
                .add(ModBlocks.OVEN)
                .add(ModBlocks.PULVERIZER)
                .add(ModBlocks.SMELTER)
                .add(ModBlocks.GENERATOR)
                .add(ModBlocks.SOLAR_PANEL)
                .add(ModBlocks.BLOCK_BREAKER)
                .add(ModBlocks.BLOCK_PLACER)
                .add(ModBlocks.BUILDER)
                .add(ModBlocks.CREATIVE_BANK)
                .add(ModBlocks.ENDER_CHANTER)
                .add(ModBlocks.FLUID_PUMP)
                .add(ModBlocks.TESSERACT)
                .add(ModBlocks.WOOD_STRIPPER)
                .add(ModBlocks.BATTERY_BANK)
                .add(ModBlocks.MINER);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.ANIMAL_FEED)
                .add(ModBlocks.PRINTER)
                .add(ModBlocks.PROJECT_TABLE);
        //endregion

        //region TIER DEFINITION
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL);
        //.add(ModBlocks.CREATIVE_ENERGY);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.CITRINE)
                .add(ModBlocks.ENDERITE)
                .add(ModBlocks.RUBY)
                .add(ModBlocks.SAPPHIRE)
                .add(ModBlocks.RAW_CITRINE)
                .add(ModBlocks.RAW_ENDERITE)
                .add(ModBlocks.RAW_QUARTZ)
                .add(ModBlocks.RAW_RUBY)
                .add(ModBlocks.RAW_SAPPHIRE)
                .add(ModBlocks.ORE_DEEP_CITRINE)
                .add(ModBlocks.ORE_DEEP_RUBY)
                .add(ModBlocks.ORE_DEEP_SAPPHIRE)
                .add(ModBlocks.ORE_END_CITRINE)
                .add(ModBlocks.ORE_END_RUBY)
                .add(ModBlocks.ORE_END_SAPPHIRE)
                .add(ModBlocks.ORE_NETHER_CITRINE)
                .add(ModBlocks.ORE_NETHER_DIAMOND)
                .add(ModBlocks.ORE_NETHER_LAPIS)
                .add(ModBlocks.ORE_NETHER_REDSTONE)
                .add(ModBlocks.ORE_NETHER_RUBY)
                .add(ModBlocks.ORE_NETHER_SAPPHIRE)
                .add(ModBlocks.ORE_WORLD_CITRINE)
                .add(ModBlocks.ORE_WORLD_RUBY)
                .add(ModBlocks.ORE_WORLD_SAPPHIRE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.ORE_END_ENDERITE_CRACKED)
                .add(ModBlocks.ORE_ENDERITE);

        //getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_4"))); // Netherite
        //endregion

        //region ORE
        getOrCreateTagBuilder(BlockTags.COPPER_ORES)
                .add(ModBlocks.ORE_NETHER_COPPER);

        getOrCreateTagBuilder(BlockTags.REDSTONE_ORES)
                .add(ModBlocks.ORE_NETHER_REDSTONE);

        getOrCreateTagBuilder(BlockTags.LAPIS_ORES)
                .add(ModBlocks.ORE_NETHER_LAPIS);

        getOrCreateTagBuilder(BlockTags.IRON_ORES)
                .add(ModBlocks.ORE_NETHER_IRON);

        getOrCreateTagBuilder(BlockTags.DIAMOND_ORES)
                .add(ModBlocks.ORE_NETHER_DIAMOND);

        getOrCreateTagBuilder(BlockTags.GOLD_ORES);

        getOrCreateTagBuilder(BlockTags.COAL_ORES)
                .add(ModBlocks.ORE_NETHER_COAL);

        getOrCreateTagBuilder(BlockTags.EMERALD_ORES);
        //endregion

        //region FENCE - WALL
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.CITRINE_FENCE)
                .add(ModBlocks.ENDERITE_FENCE)
                .add(ModBlocks.RUBY_FENCE)
                .add(ModBlocks.SAPPHIRE_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.CITRINE_FENCE_GATE)
                .add(ModBlocks.ENDERITE_FENCE_GATE)
                .add(ModBlocks.RUBY_FENCE_GATE)
                .add(ModBlocks.SAPPHIRE_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.CITRINE_WALL)
                .add(ModBlocks.ENDERITE_WALL)
                .add(ModBlocks.RUBY_WALL)
                .add(ModBlocks.SAPPHIRE_WALL);
        //endregion

        getOrCreateTagBuilder(REFERENCE.HAMMER_BLACKLIST)
                .add(ModBlocks.ELEVATOR)
                .add(ModBlocks.ANGEL)
                .add(ModBlocks.REDSTONE_CLOCK)
                .add(ModBlocks.ALLOY_MIXER)
                .add(ModBlocks.CAST_PRESS)
                .add(ModBlocks.GEM_CLEANER)
                .add(ModBlocks.OVEN)
                .add(ModBlocks.PULVERIZER)
                .add(ModBlocks.SMELTER)
                .add(ModBlocks.ANIMAL_FEED)
                .add(ModBlocks.GENERATOR)
                .add(ModBlocks.SOLAR_PANEL)
                .add(ModBlocks.BLOCK_BREAKER)
                .add(ModBlocks.BLOCK_PLACER)
                .add(ModBlocks.BUILDER)
                .add(ModBlocks.CHUNK_LOADER)
                .add(ModBlocks.CREATIVE_BANK)
                .add(ModBlocks.ENDER_CHANTER)
                .add(ModBlocks.FLUID_PUMP)
                .add(ModBlocks.PRINTER)
                .add(ModBlocks.PROJECT_TABLE)
                .add(ModBlocks.TESSERACT)
                .add(ModBlocks.WOOD_STRIPPER)
                .add(ModBlocks.BATTERY_BANK)
                .add(ModBlocks.MINER);

        getOrCreateTagBuilder(REFERENCE.EXCAVATOR_BLACKLIST)
                .add(ModBlocks.ELEVATOR)
                .add(ModBlocks.ANGEL);

        getOrCreateTagBuilder(REFERENCE.GEM_BLOCKS)
                .add(ModBlocks.RUBY)
                .add(ModBlocks.CITRINE)
                .add(ModBlocks.SAPPHIRE)
                .add(ModBlocks.ENDERITE);

        getOrCreateTagBuilder(REFERENCE.IS_MACHINE)
                .add(ModBlocks.ELEVATOR)
                .add(ModBlocks.ANGEL)
                .add(ModBlocks.REDSTONE_CLOCK)
                .add(ModBlocks.ALLOY_MIXER)
                .add(ModBlocks.CAST_PRESS)
                .add(ModBlocks.GEM_CLEANER)
                .add(ModBlocks.OVEN)
                .add(ModBlocks.PULVERIZER)
                .add(ModBlocks.SMELTER)
                .add(ModBlocks.ANIMAL_FEED)
                .add(ModBlocks.GENERATOR)
                .add(ModBlocks.SOLAR_PANEL)
                .add(ModBlocks.BLOCK_BREAKER)
                .add(ModBlocks.BLOCK_PLACER)
                .add(ModBlocks.BUILDER)
                .add(ModBlocks.CHUNK_LOADER)
                .add(ModBlocks.CREATIVE_BANK)
                .add(ModBlocks.ENDER_CHANTER)
                .add(ModBlocks.FLUID_PUMP)
                .add(ModBlocks.PRINTER)
                .add(ModBlocks.PROJECT_TABLE)
                .add(ModBlocks.TESSERACT)
                .add(ModBlocks.WOOD_STRIPPER)
                .add(ModBlocks.BATTERY_BANK)
                .add(ModBlocks.MINER);

        getOrCreateTagBuilder(REFERENCE.INCORRECT_FOR_ENDERITE_TOOL);
    }
}