package jiraiyah.uio.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

import static jiraiyah.uio.Reference.logRGB256;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider
{

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture)
    {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg)
    {
        logRGB256("Generating Item Tag Data", 0, 255, 0);

        getOrCreateTagBuilder(ItemTags.AXES);
        getOrCreateTagBuilder(ItemTags.HOES);
        getOrCreateTagBuilder(ItemTags.PICKAXES);
        getOrCreateTagBuilder(ItemTags.SHOVELS);
        getOrCreateTagBuilder(ItemTags.SWORDS);
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR);

        getOrCreateTagBuilder(ItemTags.COPPER_ORES);
        getOrCreateTagBuilder(ItemTags.REDSTONE_ORES);
        getOrCreateTagBuilder(ItemTags.LAPIS_ORES);
        getOrCreateTagBuilder(ItemTags.IRON_ORES);
        getOrCreateTagBuilder(ItemTags.DIAMOND_ORES);
        getOrCreateTagBuilder(ItemTags.COAL_ORES);
        getOrCreateTagBuilder(ItemTags.GOLD_ORES);
        getOrCreateTagBuilder(ItemTags.EMERALD_ORES);

        getOrCreateTagBuilder(ItemTags.STONE_CRAFTING_MATERIALS);
        getOrCreateTagBuilder(ItemTags.STONE_TOOL_MATERIALS);

    }
}