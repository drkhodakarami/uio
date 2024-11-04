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

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;

import java.util.EnumMap;

import static jiraiyah.uio.Reference.*;

/**
 * The {@code ModArmorMaterials} class is responsible for registering custom armor materials
 * used within the mod. It initializes various armor materials with specific properties such as
 * durability, enchantability, toughness, and knockback resistance.
 * <p>
 * This class is not meant to be instantiated, hence the private constructor throws an
 * {@link AssertionError} to prevent instantiation.
 */
public class ModArmorMaterials
{
    /**
     * Private constructor to prevent instantiation of the {@code ModArmorMaterials} class.
     * This class is intended to be used statically.
     *
     * @throws AssertionError always, as this class should not be instantiated.
     */
    ModArmorMaterials()
    {
        throw new AssertionError();
    }

    public static ArmorMaterial AMETHYST, CITRINE, COPPER, EMERALD, ENDERITE, RUBY, SAPPHIRE;

    /**
     * Initializes and registers the custom armor materials used in the mod.
     * <p>
     * Each armor material is defined with specific properties such as durability, protection
     * values for different equipment types, enchantability, sound on equip, toughness, knockback
     * resistance, and repair item tags.
     * <p>
     * The method logs the registration process for debugging purposes.
     */
    public static void init()
    {
        log("Registering Armor Materials");

        //I: durability: Leather: 5, Chain: 15, Iron 15, Gold: 7, Diamond: 33, TurtleScute: 25, Netherite: 37, ArmadilloScute: 4
        //J: enchantability: Leather: 15, Chain: 12, IroL 9, Gold: 25, Diamond: 10, TurtleScute: 9, Netherite: 15, ArmadilloScute: 10
        //F: Toughness: Leather: 0.0f, Chain: 0.0f, Iron 0.0f, Gold: 0.0f, Diamond: 2.0f, TurtleScute: 0.0f, Netherite: 3.0f, ArmadilloScute: 0.0f
        //G: Knockback Resistance: Leather: 0.0f, Chain: 0.0f, Iron 0.0f, Gold: 0.0f, Diamond: 0.0f, TurtleScute: 0.0f, Netherite: 0.1f, ArmadilloScute: 0.0f
        //Enchantability can't be 0 any more, take a look at Item Tag Provider Datagen
        AMETHYST = new ArmorMaterial(20, Util.make(new EnumMap<>(EquipmentType.class),
                                                   (map) ->
                                                   {
                                                       map.put(EquipmentType.BOOTS, 1);
                                                       map.put(EquipmentType.LEGGINGS, 5);
                                                       map.put(EquipmentType.CHESTPLATE, 7);
                                                       map.put(EquipmentType.HELMET, 3);
                                                       map.put(EquipmentType.BODY, 5);
                                                   }),
                                     20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                                     1.5f, 0.05f, Tags.Item.REPAIRS_AMETHYST_ARMOR,
                                     identifier("amethyst"));

        CITRINE = new ArmorMaterial(30, Util.make(new EnumMap<>(EquipmentType.class),
                                                  (map) ->
                                                  {
                                                      map.put(EquipmentType.BOOTS, 3);
                                                      map.put(EquipmentType.LEGGINGS, 6);
                                                      map.put(EquipmentType.CHESTPLATE, 8);
                                                      map.put(EquipmentType.HELMET, 3);
                                                      map.put(EquipmentType.BODY, 7);
                                                  }),
                                    10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                                    2.0f, 0.05f, Tags.Item.REPAIRS_CITRINE_ARMOR,
                                    identifier("citrine"));

        COPPER = new ArmorMaterial(25, Util.make(new EnumMap<>(EquipmentType.class),
                                                 (map) ->
                                                 {
                                                     map.put(EquipmentType.BOOTS, 2);
                                                     map.put(EquipmentType.LEGGINGS, 5);
                                                     map.put(EquipmentType.CHESTPLATE, 6);
                                                     map.put(EquipmentType.HELMET, 2);
                                                     map.put(EquipmentType.BODY, 7);
                                                 }),
                                   9, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                                   0.0f, 0.0f, Tags.Item.REPAIRS_COPPER_ARMOR,
                                   identifier("copper"));

        EMERALD = new ArmorMaterial(15, Util.make(new EnumMap<>(EquipmentType.class),
                                                  (map) ->
                                                  {
                                                      map.put(EquipmentType.BOOTS, 1);
                                                      map.put(EquipmentType.LEGGINGS, 5);
                                                      map.put(EquipmentType.CHESTPLATE, 7);
                                                      map.put(EquipmentType.HELMET, 2);
                                                      map.put(EquipmentType.BODY, 7);
                                                  }),
                                    20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                                    1.5f, 0.05f, Tags.Item.REPAIRS_EMERALD_ARMOR,
                                    identifier("emerald"));

        ENDERITE = new ArmorMaterial(42, Util.make(new EnumMap<>(EquipmentType.class),
                                                   (map) ->
                                                   {
                                                       map.put(EquipmentType.BOOTS, 3);
                                                       map.put(EquipmentType.LEGGINGS, 6);
                                                       map.put(EquipmentType.CHESTPLATE, 8);
                                                       map.put(EquipmentType.HELMET, 3);
                                                       map.put(EquipmentType.BODY, 15);
                                                   }),
                                     30, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                                     4.0f, 0.2f, Tags.Item.REPAIRS_ENDERITE_ARMOR,
                                     identifier("enderite"));

        RUBY = new ArmorMaterial(35, Util.make(new EnumMap<>(EquipmentType.class),
                                               (map) ->
                                               {
                                                   map.put(EquipmentType.BOOTS, 3);
                                                   map.put(EquipmentType.LEGGINGS, 6);
                                                   map.put(EquipmentType.CHESTPLATE, 8);
                                                   map.put(EquipmentType.HELMET, 3);
                                                   map.put(EquipmentType.BODY, 7);
                                               }),
                                 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                                 2.0f, 0.05f, Tags.Item.REPAIRS_RUBY_ARMOR,
                                 identifier("ruby"));

        SAPPHIRE = new ArmorMaterial(35, Util.make(new EnumMap<>(EquipmentType.class),
                                                   (map) ->
                                                   {
                                                       map.put(EquipmentType.BOOTS, 3);
                                                       map.put(EquipmentType.LEGGINGS, 6);
                                                       map.put(EquipmentType.CHESTPLATE, 8);
                                                       map.put(EquipmentType.HELMET, 3);
                                                       map.put(EquipmentType.BODY, 7);
                                                   }),
                                     10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                                     2.0f, 0.05f, Tags.Item.REPAIRS_SAPPHIRE_ARMOR,
                                     identifier("sapphire"));
    }
}