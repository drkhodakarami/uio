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
    private static final RegistryKey<LootTable> ENDERMAN_KEY = EntityType.ENDERMAN.getLootTableKey().orElseThrow();

    public LootTableModifiers()
    {
        throw new AssertionError();
    }

    public static void register()
    {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) ->
                                        {
                                            if (key.equals(ENDERMAN_KEY))// && source.isBuiltin())
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