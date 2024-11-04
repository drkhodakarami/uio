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
import jiraiyah.uio.registry.misc.ModEffects;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;

import static jiraiyah.uio.Reference.Tags;

public class ServerPlayerEquipChangeListener
{
    public ServerPlayerEquipChangeListener()
    {
        throw new AssertionError();
    }

    public static void register()
    {
        ServerEntityEvents.EQUIPMENT_CHANGE.register(((livingEntity, equipmentSlot, previousStack, currentStack) ->
        {
            if (!(livingEntity instanceof PlayerEntity player))
                return;
            if (!equipmentSlot.isArmorSlot())
                return;
            //region EMERALD
            if (previousStack.isOf(ModItems.ARMOR_EMERALD_HELMET))
            {
                player.removeStatusEffect(StatusEffects.SATURATION);
                player.removeStatusEffect(StatusEffects.HERO_OF_THE_VILLAGE);
            }
            else if (previousStack.isOf(ModItems.ARMOR_EMERALD_CHESTPLATE))
            {
                player.removeStatusEffect(StatusEffects.REGENERATION);
                player.removeStatusEffect(StatusEffects.HERO_OF_THE_VILLAGE);
            }
            else if (previousStack.isOf(ModItems.ARMOR_EMERALD_LEGGINGS))
            {
                player.removeStatusEffect(StatusEffects.LUCK);
                player.removeStatusEffect(StatusEffects.HERO_OF_THE_VILLAGE);
            }
            else if (previousStack.isOf(ModItems.ARMOR_EMERALD_BOOTS))
            {
                player.removeStatusEffect(StatusEffects.BAD_OMEN);
                player.removeStatusEffect(StatusEffects.HERO_OF_THE_VILLAGE);
            }
            //endregion
            //region AMETHYST
            else if (previousStack.isOf(ModItems.ARMOR_AMETHYST_HELMET))
            {
                player.removeStatusEffect(StatusEffects.NIGHT_VISION);
                player.removeStatusEffect(StatusEffects.LUCK);
            }
            else if (previousStack.isOf(ModItems.ARMOR_AMETHYST_CHESTPLATE))
            {
                player.removeStatusEffect(StatusEffects.SATURATION);
                player.removeStatusEffect(StatusEffects.LUCK);
            }
            else if (previousStack.isOf(ModItems.ARMOR_AMETHYST_LEGGINGS))
            {
                player.removeStatusEffect(StatusEffects.REGENERATION);
                player.removeStatusEffect(StatusEffects.LUCK);
            }
            else if (previousStack.isOf(ModItems.ARMOR_AMETHYST_BOOTS))
            {
                player.removeStatusEffect(StatusEffects.HASTE);
                player.removeStatusEffect(StatusEffects.LUCK);
            }
            //endregion
            //region CITRINE
            else if (previousStack.isOf(ModItems.ARMOR_CITRINE_HELMET))
            {
                player.removeStatusEffect(StatusEffects.SATURATION);
                player.removeStatusEffect(StatusEffects.HEALTH_BOOST);
            }
            else if (previousStack.isOf(ModItems.ARMOR_CITRINE_CHESTPLATE))
            {
                player.removeStatusEffect(StatusEffects.REGENERATION);
                player.removeStatusEffect(StatusEffects.HEALTH_BOOST);
            }
            else if (previousStack.isOf(ModItems.ARMOR_CITRINE_LEGGINGS))
            {
                player.removeStatusEffect(StatusEffects.LUCK);
                player.removeStatusEffect(StatusEffects.HEALTH_BOOST);
            }
            else if (previousStack.isOf(ModItems.ARMOR_CITRINE_BOOTS))
            {
                player.removeStatusEffect(StatusEffects.INVISIBILITY);
                player.removeStatusEffect(StatusEffects.HEALTH_BOOST);
            }
            //endregion
            //region RUBY
            else if (previousStack.isOf(ModItems.ARMOR_RUBY_HELMET))
            {
                player.removeStatusEffect(StatusEffects.SATURATION);
                player.removeStatusEffect(StatusEffects.LUCK);
            }
            else if (previousStack.isOf(ModItems.ARMOR_RUBY_CHESTPLATE))
            {
                player.removeStatusEffect(StatusEffects.RESISTANCE);
                player.removeStatusEffect(StatusEffects.LUCK);
            }
            else if (previousStack.isOf(ModItems.ARMOR_RUBY_LEGGINGS))
            {
                player.removeStatusEffect(StatusEffects.REGENERATION);
                player.removeStatusEffect(StatusEffects.LUCK);
            }
            else if (previousStack.isOf(ModItems.ARMOR_RUBY_BOOTS))
            {
                player.removeStatusEffect(StatusEffects.FIRE_RESISTANCE);
                player.removeStatusEffect(StatusEffects.LUCK);
            }
            //endregion
            //region SAPPHIRE
            else if (previousStack.isOf(ModItems.ARMOR_SAPPHIRE_HELMET))
            {
                player.removeStatusEffect(StatusEffects.CONDUIT_POWER);
                player.removeStatusEffect(StatusEffects.LUCK);
            }
            else if (previousStack.isOf(ModItems.ARMOR_SAPPHIRE_CHESTPLATE))
            {
                player.removeStatusEffect(StatusEffects.SATURATION);
                player.removeStatusEffect(StatusEffects.LUCK);
            }
            else if (previousStack.isOf(ModItems.ARMOR_SAPPHIRE_LEGGINGS))
            {
                player.removeStatusEffect(StatusEffects.DOLPHINS_GRACE);
                player.removeStatusEffect(StatusEffects.LUCK);
            }
            else if (previousStack.isOf(ModItems.ARMOR_SAPPHIRE_BOOTS))
            {
                player.removeStatusEffect(StatusEffects.INVISIBILITY);
                player.removeStatusEffect(StatusEffects.LUCK);
            }
            //endregion
            //region COPPER
            else if (previousStack.isOf(ModItems.ARMOR_COPPER_HELMET))
            {
                player.removeStatusEffect(StatusEffects.SPEED);
                player.removeStatusEffect(StatusEffects.STRENGTH);
            }
            else if (previousStack.isOf(ModItems.ARMOR_COPPER_CHESTPLATE))
            {
                player.removeStatusEffect(StatusEffects.RESISTANCE);
                player.removeStatusEffect(StatusEffects.STRENGTH);
            }
            else if (previousStack.isOf(ModItems.ARMOR_COPPER_LEGGINGS))
            {
                player.removeStatusEffect(StatusEffects.JUMP_BOOST);
                player.removeStatusEffect(StatusEffects.STRENGTH);
            }
            else if (previousStack.isOf(ModItems.ARMOR_COPPER_BOOTS))
            {
                player.removeStatusEffect(StatusEffects.SLOW_FALLING);
                player.removeStatusEffect(StatusEffects.STRENGTH);
            }
            //endregion
            //region ENDERITE
            else if (previousStack.isOf(ModItems.ARMOR_ENDERITE_HELMET))
            {
                player.removeStatusEffect(StatusEffects.NIGHT_VISION);
                player.removeStatusEffect(StatusEffects.LUCK);
                player.removeStatusEffect(ModEffects.FLIGHT_EFFECT);
            }
            else if (previousStack.isOf(ModItems.ARMOR_ENDERITE_CHESTPLATE))
            {
                player.removeStatusEffect(StatusEffects.REGENERATION);
                player.removeStatusEffect(StatusEffects.LUCK);
                player.removeStatusEffect(ModEffects.FLIGHT_EFFECT);
            }
            else if (previousStack.isOf(ModItems.ARMOR_ENDERITE_LEGGINGS))
            {
                player.removeStatusEffect(StatusEffects.SATURATION);
                player.removeStatusEffect(StatusEffects.LUCK);
                player.removeStatusEffect(ModEffects.FLIGHT_EFFECT);
            }
            else if (previousStack.isOf(ModItems.ARMOR_ENDERITE_BOOTS))
            {
                player.removeStatusEffect(StatusEffects.INVISIBILITY);
                player.removeStatusEffect(StatusEffects.LUCK);
                player.removeStatusEffect(ModEffects.FLIGHT_EFFECT);
            }
            //endregion

            //region ENDERITE
            if (currentStack.isOf(ModItems.ARMOR_ENDERITE_HELMET))
            {
                addEffect(StatusEffects.NIGHT_VISION, player);
                if (hasFullSet(Tags.Item.ENDERITE_ARMOR_TYPE, player))
                {
                    addEffect(StatusEffects.LUCK, player);
                    addEffect(ModEffects.FLIGHT_EFFECT, player);
                }
                return;
            }
            if (currentStack.isOf(ModItems.ARMOR_ENDERITE_CHESTPLATE))
            {
                addEffect(StatusEffects.REGENERATION, player);
                if (hasFullSet(Tags.Item.ENDERITE_ARMOR_TYPE, player))
                {
                    addEffect(StatusEffects.LUCK, player);
                    addEffect(ModEffects.FLIGHT_EFFECT, player);
                }
                return;
            }
            if (currentStack.isOf(ModItems.ARMOR_ENDERITE_LEGGINGS))
            {
                addEffect(StatusEffects.SATURATION, player);
                if (hasFullSet(Tags.Item.ENDERITE_ARMOR_TYPE, player))
                {
                    addEffect(StatusEffects.LUCK, player);
                    addEffect(ModEffects.FLIGHT_EFFECT, player);
                }
                return;
            }
            if (currentStack.isOf(ModItems.ARMOR_ENDERITE_BOOTS))
            {
                addEffect(StatusEffects.INVISIBILITY, player);
                if (hasFullSet(Tags.Item.ENDERITE_ARMOR_TYPE, player))
                {
                    addEffect(StatusEffects.LUCK, player);
                    addEffect(ModEffects.FLIGHT_EFFECT, player);
                }
                return;
            }
            //endregion
            //region COPPER
            if (currentStack.isOf(ModItems.ARMOR_COPPER_HELMET))
            {
                addEffect(StatusEffects.SPEED, player);
                if (hasFullSet(Tags.Item.COPPER_ARMOR_TYPE, player))
                    addEffect(StatusEffects.STRENGTH, player);
                return;
            }
            if (currentStack.isOf(ModItems.ARMOR_COPPER_CHESTPLATE))
            {
                addEffect(StatusEffects.RESISTANCE, player);
                if (hasFullSet(Tags.Item.COPPER_ARMOR_TYPE, player))
                    addEffect(StatusEffects.STRENGTH, player);
                return;
            }
            if (currentStack.isOf(ModItems.ARMOR_COPPER_LEGGINGS))
            {
                addEffect(StatusEffects.JUMP_BOOST, player);
                if (hasFullSet(Tags.Item.COPPER_ARMOR_TYPE, player))
                    addEffect(StatusEffects.STRENGTH, player);
                return;
            }
            if (currentStack.isOf(ModItems.ARMOR_COPPER_BOOTS))
            {
                addEffect(StatusEffects.SLOW_FALLING, player);
                if (hasFullSet(Tags.Item.COPPER_ARMOR_TYPE, player))
                    addEffect(StatusEffects.STRENGTH, player);
                return;
            }
            //endregion
            //region AMETHYST
            if (currentStack.isOf(ModItems.ARMOR_AMETHYST_HELMET))
            {
                addEffect(StatusEffects.NIGHT_VISION, player);
                if (hasFullSet(Tags.Item.AMETHYST_ARMOR_TYPE, player))
                    addEffect(StatusEffects.LUCK, player);
                return;
            }
            if (currentStack.isOf(ModItems.ARMOR_AMETHYST_CHESTPLATE))
            {
                addEffect(StatusEffects.SATURATION, player);
                if (hasFullSet(Tags.Item.AMETHYST_ARMOR_TYPE, player))
                    addEffect(StatusEffects.LUCK, player);
                return;
            }
            if (currentStack.isOf(ModItems.ARMOR_AMETHYST_LEGGINGS))
            {
                addEffect(StatusEffects.REGENERATION, player);
                if (hasFullSet(Tags.Item.AMETHYST_ARMOR_TYPE, player))
                    addEffect(StatusEffects.LUCK, player);
                return;
            }
            if (currentStack.isOf(ModItems.ARMOR_AMETHYST_BOOTS))
            {
                addEffect(StatusEffects.HASTE, player);
                if (hasFullSet(Tags.Item.AMETHYST_ARMOR_TYPE, player))
                    addEffect(StatusEffects.LUCK, player);
                return;
            }
            //endregion
            //region EMERALD
            if (currentStack.isOf(ModItems.ARMOR_EMERALD_HELMET))
            {
                addEffect(StatusEffects.SATURATION, player);
                if (hasFullSet(Tags.Item.EMERALD_ARMOR_TYPE, player))
                    addEffect(StatusEffects.HERO_OF_THE_VILLAGE, player);
                return;
            }
            if (currentStack.isOf(ModItems.ARMOR_EMERALD_CHESTPLATE))
            {
                addEffect(StatusEffects.REGENERATION, player);
                if (hasFullSet(Tags.Item.EMERALD_ARMOR_TYPE, player))
                    addEffect(StatusEffects.HERO_OF_THE_VILLAGE, player);
                return;
            }
            if (currentStack.isOf(ModItems.ARMOR_EMERALD_LEGGINGS))
            {
                addEffect(StatusEffects.LUCK, player);
                if (hasFullSet(Tags.Item.EMERALD_ARMOR_TYPE, player))
                    addEffect(StatusEffects.HERO_OF_THE_VILLAGE, player);
                return;
            }
            if (currentStack.isOf(ModItems.ARMOR_EMERALD_BOOTS))
            {
                addEffect(StatusEffects.BAD_OMEN, player);
                if (hasFullSet(Tags.Item.EMERALD_ARMOR_TYPE, player))
                    addEffect(StatusEffects.HERO_OF_THE_VILLAGE, player);
                return;
            }
            //endregion
            //region CITRINE
            if (currentStack.isOf(ModItems.ARMOR_CITRINE_HELMET))
            {
                addEffect(StatusEffects.SATURATION, player);
                if (hasFullSet(Tags.Item.CITRINE_ARMOR_TYPE, player))
                    addEffect(StatusEffects.HEALTH_BOOST, player);
                return;
            }
            if (currentStack.isOf(ModItems.ARMOR_CITRINE_CHESTPLATE))
            {
                addEffect(StatusEffects.REGENERATION, player);
                if (hasFullSet(Tags.Item.CITRINE_ARMOR_TYPE, player))
                    addEffect(StatusEffects.HEALTH_BOOST, player);
                return;
            }
            if (currentStack.isOf(ModItems.ARMOR_CITRINE_LEGGINGS))
            {
                addEffect(StatusEffects.LUCK, player);
                if (hasFullSet(Tags.Item.CITRINE_ARMOR_TYPE, player))
                    addEffect(StatusEffects.HEALTH_BOOST, player);
                return;
            }
            if (currentStack.isOf(ModItems.ARMOR_CITRINE_BOOTS))
            {
                addEffect(StatusEffects.INVISIBILITY, player);
                if (hasFullSet(Tags.Item.CITRINE_ARMOR_TYPE, player))
                    addEffect(StatusEffects.HEALTH_BOOST, player);
                return;
            }
            //endregion
            //region RUBY
            if (currentStack.isOf(ModItems.ARMOR_RUBY_HELMET))
            {
                addEffect(StatusEffects.SATURATION, player);
                if (hasFullSet(Tags.Item.RUBY_ARMOR_TYPE, player))
                    addEffect(StatusEffects.LUCK, player);
                return;
            }
            if (currentStack.isOf(ModItems.ARMOR_RUBY_CHESTPLATE))
            {
                addEffect(StatusEffects.RESISTANCE, player);
                if (hasFullSet(Tags.Item.RUBY_ARMOR_TYPE, player))
                    addEffect(StatusEffects.LUCK, player);
                return;
            }
            if (currentStack.isOf(ModItems.ARMOR_RUBY_LEGGINGS))
            {
                addEffect(StatusEffects.REGENERATION, player);
                if (hasFullSet(Tags.Item.RUBY_ARMOR_TYPE, player))
                    addEffect(StatusEffects.LUCK, player);
                return;
            }
            if (currentStack.isOf(ModItems.ARMOR_RUBY_BOOTS))
            {
                addEffect(StatusEffects.FIRE_RESISTANCE, player);
                if (hasFullSet(Tags.Item.RUBY_ARMOR_TYPE, player))
                    addEffect(StatusEffects.LUCK, player);
                return;
            }
            //endregion
            //region SAPPHIRE
            if (currentStack.isOf(ModItems.ARMOR_SAPPHIRE_HELMET))
            {
                addEffect(StatusEffects.CONDUIT_POWER, player);
                if (hasFullSet(Tags.Item.SAPPHIRE_ARMOR_TYPE, player))
                    addEffect(StatusEffects.LUCK, player);
                return;
            }
            if (currentStack.isOf(ModItems.ARMOR_SAPPHIRE_CHESTPLATE))
            {
                addEffect(StatusEffects.SATURATION, player);
                if (hasFullSet(Tags.Item.SAPPHIRE_ARMOR_TYPE, player))
                    addEffect(StatusEffects.LUCK, player);
                return;
            }
            if (currentStack.isOf(ModItems.ARMOR_SAPPHIRE_LEGGINGS))
            {
                addEffect(StatusEffects.DOLPHINS_GRACE, player);
                if (hasFullSet(Tags.Item.SAPPHIRE_ARMOR_TYPE, player))
                    addEffect(StatusEffects.LUCK, player);
                return;
            }
            if (currentStack.isOf(ModItems.ARMOR_SAPPHIRE_BOOTS))
            {
                addEffect(StatusEffects.INVISIBILITY, player);
                if (hasFullSet(Tags.Item.SAPPHIRE_ARMOR_TYPE, player))
                    addEffect(StatusEffects.LUCK, player);
            }
            //endregion
        }));
    }

    private static void addEffect(RegistryEntry<StatusEffect> effect, PlayerEntity player)
    {
        player.addStatusEffect(new StatusEffectInstance(effect, -1, 3, false, false, true));
    }

    private static boolean hasFullSet(TagKey<Item> tag, PlayerEntity player)
    {
        // Preventing Elytra from Crashing the Game (Elytra is not ArmorItem)
        for (ItemStack armor : player.getInventory().armor)
            if (!(armor.getItem() instanceof ArmorItem))
                return false;

        ItemStack boots = player.getInventory().getArmorStack(EquipmentSlot.FEET.getEntitySlotId());
        ItemStack leggings = player.getInventory().getArmorStack(EquipmentSlot.LEGS.getEntitySlotId());
        ItemStack chestplate = player.getInventory().getArmorStack(EquipmentSlot.CHEST.getEntitySlotId());
        ItemStack helmet = player.getInventory().getArmorStack(EquipmentSlot.HEAD.getEntitySlotId());

        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty() &&
               helmet.isIn(tag) && chestplate.isIn(tag) && leggings.isIn(tag) && boots.isIn(tag);
    }
}