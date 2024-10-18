package jiraiyah.uio.event;

import jiraiyah.uio.registry.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKey;

import java.util.List;

public class LootTableModifiers
{
    private static final RegistryKey<LootTable> ENDERMAN_KEY = EntityType.ENDERMAN.getLootTableId();

    public LootTableModifiers()
    {
        throw new AssertionError();
    }

    public static void register()
    {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) ->
                                        {
                                            if(key.equals(ENDERMAN_KEY))// && source.isBuiltin())
                                            {
                                                LootPool eye = LootPool.builder()
                                                        .rolls(ConstantLootNumberProvider.create(1))
                                                        .conditionally(RandomChanceLootCondition.builder(0.025f)) //2.5%
                                                        .with(ItemEntry.builder(ModItems.ENDERMAN_EYE))
                                                        .apply(SetCountLootFunction
                                                                       .builder(UniformLootNumberProvider.create(1.0f, 2.0f))
                                                                       .build())
                                                        .build();

                                                LootPool heart = LootPool.builder()
                                                      .rolls(ConstantLootNumberProvider.create(1))
                                                      .conditionally(RandomChanceLootCondition.builder(0.05f)) //5%
                                                      .with(ItemEntry.builder(ModItems.ENDERMAN_HEART))
                                                      .apply(SetCountLootFunction
                                                                     .builder(UniformLootNumberProvider.create(1.0f, 1.0f))
                                                                     .build())
                                                     .build();

                                                LootPool gland = LootPool.builder()
                                                      .rolls(ConstantLootNumberProvider.create(1))
                                                      .conditionally(RandomChanceLootCondition.builder(0.025f)) //2.5%
                                                      .with(ItemEntry.builder(ModItems.ENDERMAN_GLAND))
                                                      .apply(SetCountLootFunction
                                                                     .builder(UniformLootNumberProvider.create(1.0f, 2.0f))
                                                                     .build())
                                                      .build();

                                                tableBuilder.pools(List.of(eye, heart, gland));
                                            }
                                        });
    }
}