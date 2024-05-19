package jiraiyah.uio.datagen.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

import static jiraiyah.uio.Reference.identifier;
import static jiraiyah.uio.Reference.logRGB256;

public class ModPlacedFeatures
{
    public ModPlacedFeatures()
    {
        throw new AssertionError();
    }

    public static void bootstrap(Registerable<PlacedFeature> context)
    {
        logRGB256("Generating Placed Features Data", 0, 255, 0);
    }

    public static RegistryKey<PlacedFeature> getRegisterKey(String name)
    {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, identifier(name));
    }

    private static void register(Registerable<PlacedFeature> context,
                                 RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers)
    {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static void register(Registerable<PlacedFeature> context,
                                 RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 PlacementModifier... modifiers)
    {
        register(context, key, configuration, List.of(modifiers));
    }
}