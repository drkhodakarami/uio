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

package jiraiyah.uio.item;

import jiraiyah.uio.registry.ModArmorMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ModArmorItem extends ArmorItem
{
    private static final Map<RegistryEntry<ArmorMaterial>, ArrayList<StatusEffectInstance>> MATERIAL_TO_EFFECT;

    static
    {
        MATERIAL_TO_EFFECT = new HashMap<>();

        addValue(ModArmorMaterials.EMERALD, StatusEffects.HERO_OF_THE_VILLAGE);
        addValue(ModArmorMaterials.EMERALD, StatusEffects.BAD_OMEN);
        addValue(ModArmorMaterials.EMERALD, StatusEffects.REGENERATION);

        addValue(ModArmorMaterials.AMETHYST, StatusEffects.HASTE);
        addValue(ModArmorMaterials.AMETHYST, StatusEffects.NIGHT_VISION);
        //TODO : Add Ignore Effect

        addValue(ModArmorMaterials.CITRINE, StatusEffects.SATURATION);
        addValue(ModArmorMaterials.CITRINE, StatusEffects.HEALTH_BOOST);
        //TODO : Add Ignore Effect

        addValue(ModArmorMaterials.RUBY, StatusEffects.FIRE_RESISTANCE);
        addValue(ModArmorMaterials.RUBY, StatusEffects.RESISTANCE);
        //TODO : Add Ignore Effect

        addValue(ModArmorMaterials.SAPPHIRE, StatusEffects.CONDUIT_POWER);
        addValue(ModArmorMaterials.SAPPHIRE, StatusEffects.DOLPHINS_GRACE);
        addValue(ModArmorMaterials.SAPPHIRE, StatusEffects.INVISIBILITY);

        addValue(ModArmorMaterials.COPPER, StatusEffects.SPEED);
        addValue(ModArmorMaterials.COPPER, StatusEffects.JUMP_BOOST);
        addValue(ModArmorMaterials.COPPER, StatusEffects.SLOW_FALLING);

        addValue(ModArmorMaterials.ENDERITE, StatusEffects.LUCK);
        addValue(ModArmorMaterials.ENDERITE, StatusEffects.NIGHT_VISION);
        //TODO : Add Ignore Effect
        //TODO : Flight Effect
    }

    public ModArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings)
    {
        super(material, type, settings);
    }

    private static void addValue(RegistryEntry<ArmorMaterial> key, RegistryEntry<StatusEffect> effect)
    {
        ArrayList tempList;

        StatusEffectInstance newEffect = new StatusEffectInstance(effect, 1200, 3, false, false, true);

        if (MATERIAL_TO_EFFECT.containsKey(key))
        {
            tempList = MATERIAL_TO_EFFECT.get(key);
            if (tempList == null)
                tempList = new ArrayList<>();
            tempList.add(newEffect);
        }
        else
        {
            tempList = new ArrayList<>();
            tempList.add(newEffect);
        }

        MATERIAL_TO_EFFECT.put(key, tempList);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
    {
        if (!world.isClient())
            if (entity instanceof PlayerEntity player && hasFullArmorSet(player))
                evaluateArmorEffect(player);
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private boolean hasFullArmorSet(PlayerEntity player)
    {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    private void evaluateArmorEffect(PlayerEntity player)
    {
        for (Map.Entry<RegistryEntry<ArmorMaterial>, ArrayList<StatusEffectInstance>> entry : MATERIAL_TO_EFFECT.entrySet())
        {
            ArmorMaterial material = entry.getKey().value();

            entry.getValue().forEach((effect) ->
                                     {
                                         if (hasCorrectArmor(material, player) && isStatusFading(player, effect))
                                             addStatus(player, effect);
                                     });
        }
    }

    private boolean hasCorrectArmor(ArmorMaterial material, PlayerEntity player)
    {
        // Preventing Elytra from Crashing the Game (Elytra is not ArmorItem)
        for (ItemStack armor : player.getInventory().armor)
            if (!(armor.getItem() instanceof ArmorItem))
                return false;

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmorStack(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial().value() == material &&
               chestplate.getMaterial().value() == material &&
               leggings.getMaterial().value() == material &&
               boots.getMaterial().value() == material;
    }

    private boolean isStatusFading(PlayerEntity player, StatusEffectInstance effect)
    {
        StatusEffectInstance playerEffect = player.getStatusEffect(effect.getEffectType());

        return playerEffect == null ||
               !player.hasStatusEffect(effect.getEffectType()) ||
               playerEffect.isDurationBelow(220);
    }

    private void addStatus(PlayerEntity player, StatusEffectInstance effect)
    {
        player.addStatusEffect(new StatusEffectInstance(effect.getEffectType(),
                                                        effect.getDuration(),
                                                        effect.getAmplifier(),
                                                        effect.isAmbient(),
                                                        effect.shouldShowParticles(),
                                                        effect.shouldShowIcon()));
    }
}