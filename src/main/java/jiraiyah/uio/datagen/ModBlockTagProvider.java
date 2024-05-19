package jiraiyah.uio.datagen;

import jiraiyah.uio.registry.ModBlocks;
import jiraiyah.uio.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static jiraiyah.uio.Reference.logRGB256;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider
{
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg)
    {
        logRGB256("Generating Block Tag Data", 0, 255, 0);

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
                .add(ModBlocks.ORE_WORLD_SAPPHIRE);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL);

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

        //TODO : Fix Netherite Tier
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4"))); // Netherite

        getOrCreateTagBuilder(BlockTags.LOGS);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN);

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
    }
}