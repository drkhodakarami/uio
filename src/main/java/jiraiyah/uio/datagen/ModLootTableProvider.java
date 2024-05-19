package jiraiyah.uio.datagen;

import jiraiyah.uio.registry.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
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

        addDrop(ModBlocks.CITRINE);
        addDrop(ModBlocks.ENDERITE);
        addDrop(ModBlocks.RUBY);
        addDrop(ModBlocks.SAPPHIRE);

        addDrop(ModBlocks.RAW_CITRINE);
        addDrop(ModBlocks.RAW_ENDERITE);
        addDrop(ModBlocks.RAW_QUARTZ);
        addDrop(ModBlocks.RAW_RUBY);
        addDrop(ModBlocks.RAW_SAPPHIRE);

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

        addDrop(ModBlocks.ORE_DEEP_CITRINE);
        addDrop(ModBlocks.ORE_DEEP_RUBY);
        addDrop(ModBlocks.ORE_DEEP_SAPPHIRE);

        addDrop(ModBlocks.ORE_END_CITRINE);
        addDrop(ModBlocks.ORE_END_ENDERITE_CRACKED);
        addDrop(ModBlocks.ORE_END_RUBY);
        addDrop(ModBlocks.ORE_END_SAPPHIRE);
        addDrop(ModBlocks.ORE_NETHER_CITRINE);
        addDrop(ModBlocks.ORE_NETHER_COAL);
        addDrop(ModBlocks.ORE_NETHER_COPPER);
        addDrop(ModBlocks.ORE_NETHER_DIAMOND);
        addDrop(ModBlocks.ORE_NETHER_IRON);
        addDrop(ModBlocks.ORE_NETHER_LAPIS);
        addDrop(ModBlocks.ORE_NETHER_REDSTONE);
        addDrop(ModBlocks.ORE_NETHER_RUBY);
        addDrop(ModBlocks.ORE_NETHER_SAPPHIRE);
        addDrop(ModBlocks.ORE_WORLD_CITRINE);
        addDrop(ModBlocks.ORE_WORLD_RUBY);
        addDrop(ModBlocks.ORE_WORLD_SAPPHIRE);

        addDrop(ModBlocks.ORE_ENDERITE);
    }

    private LootTable.Builder customOreDrops(Block drop, Item item, float min, float max)
    {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop,
                                                          (LootPoolEntry.Builder)
                                                                  this.applyExplosionDecay(drop,
                                                                                           ((LeafEntry.Builder)
                                                                                                   ItemEntry.builder(item)
                                                                                                            .apply(SetCountLootFunction
                                                                                                                           .builder(UniformLootNumberProvider
                                                                                                                                            .create(min, max))))
                                                                                                   .apply(ApplyBonusLootFunction
                                                                                                                  .oreDrops(Enchantments.FORTUNE))));
    }

    private LootTable.Builder customOreDrops(Block drop, Item item)
    {
        return customOreDrops(drop, item, 2.0f, 5.0f);
    }
}