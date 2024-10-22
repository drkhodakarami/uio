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

package jiraiyah.uio.registry.misc;

import jiraiyah.uio.registry.ModItems;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;

import java.util.EnumMap;

import static jiraiyah.uio.Reference.*;
import static jiraiyah.uio.util.Registers.ArmorMaterials.*;

public class ModArmorMaterials
{
    ModArmorMaterials()
    {
        throw new AssertionError();
    }

    public static RegistryEntry<ArmorMaterial> AMETHYST, CITRINE, COPPER, EMERALD, ENDERITE, RUBY, SAPPHIRE;

    public static void init()
    {
        log("Registering Armor Materials");

        AMETHYST = register("amethyst",
                     Util.make(new EnumMap<>(ArmorItem.Type.class),
                               map ->
                               {
                                   map.put(ArmorItem.Type.BOOTS, 1);
                                   map.put(ArmorItem.Type.LEGGINGS, 5);
                                   map.put(ArmorItem.Type.CHESTPLATE, 7);
                                   map.put(ArmorItem.Type.HELMET, 2);
                                   map.put(ArmorItem.Type.BODY, 5);
                               }),
                     0, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                     1.5f, 0.05f,
                     () -> Ingredient.ofItems(ModItems.REINFORCED_AMETHYST));

        CITRINE = register("citrine",
                    Util.make(new EnumMap<>(ArmorItem.Type.class),
                              map ->
                              {
                                  map.put(ArmorItem.Type.BOOTS, 3);
                                  map.put(ArmorItem.Type.LEGGINGS, 6);
                                  map.put(ArmorItem.Type.CHESTPLATE, 8);
                                  map.put(ArmorItem.Type.HELMET, 3);
                                  map.put(ArmorItem.Type.BODY, 7);
                              }),
                    0, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                    2.0f, 0.1f,
                    () -> Ingredient.ofItems(ModItems.REINFORCED_CITRINE));

        COPPER = register("copper",
                   Util.make(new EnumMap<>(ArmorItem.Type.class),
                             map ->
                             {
                                 map.put(ArmorItem.Type.BOOTS, 2);
                                 map.put(ArmorItem.Type.LEGGINGS, 5);
                                 map.put(ArmorItem.Type.CHESTPLATE, 6);
                                 map.put(ArmorItem.Type.HELMET, 2);
                                 map.put(ArmorItem.Type.BODY, 7);
                             }),
                   0, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                   1.0f, 0.0f,
                   () -> Ingredient.ofItems(ModItems.REINFORCED_COPPER));

        EMERALD = register("emerald",
                    Util.make(new EnumMap<>(ArmorItem.Type.class),
                              map ->
                              {
                                  map.put(ArmorItem.Type.BOOTS, 1);
                                  map.put(ArmorItem.Type.LEGGINGS, 5);
                                  map.put(ArmorItem.Type.CHESTPLATE, 7);
                                  map.put(ArmorItem.Type.HELMET, 2);
                                  map.put(ArmorItem.Type.BODY, 7);
                              }),
                    0, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                    1.5f, 0.15f,
                    () -> Ingredient.ofItems(ModItems.REINFORCED_EMERALD));

        ENDERITE = register("enderite",
                     Util.make(new EnumMap<>(ArmorItem.Type.class),
                               map ->
                               {
                                   map.put(ArmorItem.Type.BOOTS, 3);
                                   map.put(ArmorItem.Type.LEGGINGS, 6);
                                   map.put(ArmorItem.Type.CHESTPLATE, 8);
                                   map.put(ArmorItem.Type.HELMET, 3);
                                   map.put(ArmorItem.Type.BODY, 15);
                               }),
                     0, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
                     3.0f, 0.2f,
                     () -> Ingredient.ofItems(ModItems.REINFORCED_ENDERITE));

        RUBY = register("ruby",
                     Util.make(new EnumMap<>(ArmorItem.Type.class),
                               map ->
                               {
                                   map.put(ArmorItem.Type.BOOTS, 3);
                                   map.put(ArmorItem.Type.LEGGINGS, 6);
                                   map.put(ArmorItem.Type.CHESTPLATE, 8);
                                   map.put(ArmorItem.Type.HELMET, 3);
                                   map.put(ArmorItem.Type.BODY, 7);
                               }),
                     0, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                     2.0f, 0.1f,
                     () -> Ingredient.ofItems(ModItems.REINFORCED_RUBY));

        SAPPHIRE = register("sapphire",
                     Util.make(new EnumMap<>(ArmorItem.Type.class),
                               map ->
                               {
                                   map.put(ArmorItem.Type.BOOTS, 3);
                                   map.put(ArmorItem.Type.LEGGINGS, 6);
                                   map.put(ArmorItem.Type.CHESTPLATE, 8);
                                   map.put(ArmorItem.Type.HELMET, 3);
                                   map.put(ArmorItem.Type.BODY, 7);
                               }),
                     0, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                     2.0f, 0.1f,
                     () -> Ingredient.ofItems(ModItems.REINFORCED_SAPPHIRE));
    }
}