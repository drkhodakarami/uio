package jiraiyah.uio.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static jiraiyah.uio.Reference.Tags.Entity.RUBY_SWORD_IGNITES;
import static jiraiyah.uio.Reference.Tags.Entity.TUNER_BLACKLIST;
import static jiraiyah.uio.Reference.logRGB256;

public class ModEntityTagProvider extends FabricTagProvider.EntityTypeTagProvider
{
    public ModEntityTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture)
    {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg)
    {
        logRGB256("Generating Entity Tag Data", 0, 255, 0);

        getOrCreateTagBuilder(TUNER_BLACKLIST)
                .add(EntityType.ENDER_DRAGON);

        getOrCreateTagBuilder(RUBY_SWORD_IGNITES)
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