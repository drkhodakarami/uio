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

import jiraiyah.uio.registry.ModBlocks;
import jiraiyah.uio.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static jiraiyah.uio.Reference.logRGB256;

@SuppressWarnings("ALL")
public class ModLootTableProvider extends FabricBlockLootTableProvider
{
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup)
    {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate()
    {
        logRGB256("Generating Loot Table Data", 0, 255, 0);

        //region GEM
        addDrop(ModBlocks.CITRINE);
        addDrop(ModBlocks.ENDERITE);
        addDrop(ModBlocks.RUBY);
        addDrop(ModBlocks.SAPPHIRE);
        //endregion

        //region RAW
        addDrop(ModBlocks.RAW_CITRINE);
        addDrop(ModBlocks.RAW_ENDERITE);
        addDrop(ModBlocks.RAW_QUARTZ);
        addDrop(ModBlocks.RAW_RUBY);
        addDrop(ModBlocks.RAW_SAPPHIRE);
        //endregion

        //region SPECIAL BLOCKS
        addDrop(ModBlocks.CITRINE_STAIRS);
        addDrop(ModBlocks.CITRINE_SLAB, slabDrops(ModBlocks.CITRINE_SLAB));
        addDrop(ModBlocks.CITRINE_BUTTON);
        addDrop(ModBlocks.CITRINE_PRESSURE_PLATE);
        addDrop(ModBlocks.CITRINE_FENCE);
        addDrop(ModBlocks.CITRINE_FENCE_GATE);
        addDrop(ModBlocks.CITRINE_WALL);
        addDrop(ModBlocks.CITRINE_DOOR, doorDrops(ModBlocks.CITRINE_DOOR));
        addDrop(ModBlocks.CITRINE_TRAP_DOOR);

        addDrop(ModBlocks.ENDERITE_STAIRS);
        addDrop(ModBlocks.ENDERITE_SLAB, slabDrops(ModBlocks.CITRINE_SLAB));
        addDrop(ModBlocks.ENDERITE_BUTTON);
        addDrop(ModBlocks.ENDERITE_PRESSURE_PLATE);
        addDrop(ModBlocks.ENDERITE_FENCE);
        addDrop(ModBlocks.ENDERITE_FENCE_GATE);
        addDrop(ModBlocks.ENDERITE_WALL);
        addDrop(ModBlocks.ENDERITE_DOOR, doorDrops(ModBlocks.CITRINE_DOOR));
        addDrop(ModBlocks.ENDERITE_TRAP_DOOR);

        addDrop(ModBlocks.RUBY_STAIRS);
        addDrop(ModBlocks.RUBY_SLAB, slabDrops(ModBlocks.CITRINE_SLAB));
        addDrop(ModBlocks.RUBY_BUTTON);
        addDrop(ModBlocks.RUBY_PRESSURE_PLATE);
        addDrop(ModBlocks.RUBY_FENCE);
        addDrop(ModBlocks.RUBY_FENCE_GATE);
        addDrop(ModBlocks.RUBY_WALL);
        addDrop(ModBlocks.RUBY_DOOR, doorDrops(ModBlocks.CITRINE_DOOR));
        addDrop(ModBlocks.RUBY_TRAP_DOOR);

        addDrop(ModBlocks.SAPPHIRE_STAIRS);
        addDrop(ModBlocks.SAPPHIRE_SLAB, slabDrops(ModBlocks.CITRINE_SLAB));
        addDrop(ModBlocks.SAPPHIRE_BUTTON);
        addDrop(ModBlocks.SAPPHIRE_PRESSURE_PLATE);
        addDrop(ModBlocks.SAPPHIRE_FENCE);
        addDrop(ModBlocks.SAPPHIRE_FENCE_GATE);
        addDrop(ModBlocks.SAPPHIRE_WALL);
        addDrop(ModBlocks.SAPPHIRE_DOOR, doorDrops(ModBlocks.CITRINE_DOOR));
        addDrop(ModBlocks.SAPPHIRE_TRAP_DOOR);
        //endregion

        //region ORE DROP
        addDrop(ModBlocks.ORE_DEEP_CITRINE,
                customOreDrops(ModBlocks.ORE_DEEP_CITRINE, ModItems.RAW_CITRINE, 2.0f, 3.0f));
        addDrop(ModBlocks.ORE_DEEP_RUBY,
                customOreDrops(ModBlocks.ORE_DEEP_RUBY, ModItems.RAW_RUBY, 2.0f, 3.0f));
        addDrop(ModBlocks.ORE_DEEP_SAPPHIRE,
                customOreDrops(ModBlocks.ORE_DEEP_SAPPHIRE, ModItems.RAW_SAPPHIRE, 2.0f, 3.0f));
        addDrop(ModBlocks.ORE_END_CITRINE,
                customOreDrops(ModBlocks.ORE_END_CITRINE, ModItems.RAW_CITRINE));
        addDrop(ModBlocks.ORE_END_RUBY,
                customOreDrops(ModBlocks.ORE_END_RUBY, ModItems.RAW_RUBY));
        addDrop(ModBlocks.ORE_END_SAPPHIRE,
                customOreDrops(ModBlocks.ORE_END_SAPPHIRE, ModItems.RAW_SAPPHIRE));
        addDrop(ModBlocks.ORE_NETHER_CITRINE,
                customOreDrops(ModBlocks.ORE_NETHER_CITRINE, ModItems.RAW_CITRINE, 2.0f, 4.0f));
        addDrop(ModBlocks.ORE_NETHER_COAL,
                customOreDrops(ModBlocks.ORE_NETHER_COAL, Items.COAL, 2.0f, 6.0f));
        addDrop(ModBlocks.ORE_NETHER_COPPER,
                customOreDrops(ModBlocks.ORE_NETHER_COPPER, Items.RAW_COPPER));
        addDrop(ModBlocks.ORE_NETHER_DIAMOND,
                customOreDrops(ModBlocks.ORE_NETHER_DIAMOND, Items.DIAMOND, 1.0f, 1.0f));
        addDrop(ModBlocks.ORE_NETHER_IRON,
                customOreDrops(ModBlocks.ORE_NETHER_IRON, Items.RAW_IRON));
        addDrop(ModBlocks.ORE_NETHER_LAPIS,
                customOreDrops(ModBlocks.ORE_NETHER_LAPIS, Items.LAPIS_LAZULI, 2.0f, 4.0f));
        addDrop(ModBlocks.ORE_NETHER_REDSTONE,
                customOreDrops(ModBlocks.ORE_NETHER_REDSTONE, Items.REDSTONE, 2.0f, 44.0f));
        addDrop(ModBlocks.ORE_NETHER_RUBY,
                customOreDrops(ModBlocks.ORE_NETHER_RUBY, ModItems.RAW_RUBY, 2.0f, 4.0f));
        addDrop(ModBlocks.ORE_NETHER_SAPPHIRE,
                customOreDrops(ModBlocks.ORE_NETHER_SAPPHIRE, ModItems.RAW_SAPPHIRE, 2.0f, 4.0f));
        addDrop(ModBlocks.ORE_WORLD_CITRINE,
                customOreDrops(ModBlocks.ORE_WORLD_CITRINE, ModItems.RAW_CITRINE, 2.0f, 3.0f));
        addDrop(ModBlocks.ORE_WORLD_RUBY,
                customOreDrops(ModBlocks.ORE_WORLD_RUBY, ModItems.RAW_RUBY, 2.0f, 3.0f));
        addDrop(ModBlocks.ORE_WORLD_SAPPHIRE,
                customOreDrops(ModBlocks.ORE_WORLD_SAPPHIRE, ModItems.RAW_SAPPHIRE, 2.0f, 3.0f));

        addDrop(ModBlocks.ORE_END_ENDERITE_CRACKED);
        addDrop(ModBlocks.ORE_ENDERITE,
                customOreDrops(ModBlocks.ORE_ENDERITE, ModItems.RAW_ENDERITE, 1.0f, 2.0f));
        //endregion

        // Ore End Enderite --> TNT --> Ore Enderite Cracked --> Blast Furnace --> End Enderite --> pick axe --> raw enderite

        //region MACHINES
        addDrop(ModBlocks.ELEVATOR);
        //addDrop(ModBlocks.REDSTONE_CLOCK);
        //addDrop(ModBlocks.CREATIVE_ENERGY);

        addDrop(ModBlocks.LAVA_PUMP_GOO);
        addDrop(ModBlocks.WATER_PUMP_GOO);
        //endregion
    }
    //region HELPER METHODS

    private LootTable.Builder customOreDrops(Block drop, Item item, float min, float max)
    {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return dropsWithSilkTouch(drop,
                                    this.applyExplosionDecay(drop,
                                                               (ItemEntry.builder(item)
                                                                            .apply(SetCountLootFunction
                                                                                           .builder(UniformLootNumberProvider
                                                                                                            .create(min, max))))
                                                                       .apply(ApplyBonusLootFunction
                                                                              .oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }

    private LootTable.Builder customOreDrops(Block drop, Item item)
    {
        return customOreDrops(drop, item, 2.0f, 5.0f);
    }

    //endregion
}