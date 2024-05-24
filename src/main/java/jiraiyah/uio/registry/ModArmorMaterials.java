package jiraiyah.uio.registry;

import jiraiyah.uio.Reference;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

import static jiraiyah.uio.Reference.*;

public class ModArmorMaterials
{
    public static final RegistryEntry<ArmorMaterial> AMETHYST = register("amethyst",
                                                                         Util.make(new EnumMap(ArmorItem.Type.class),
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

    //region HELPER METHODS
    public static RegistryEntry<ArmorMaterial> getDefault(Registry<ArmorMaterial> registry)
    {
        return ArmorMaterials.LEATHER;
    }

    private static RegistryEntry<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient)
    {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(identifier(id)));
        return register(id, defense, enchantability, equipSound, toughness, knockbackResistance, repairIngredient, list);
    }

    private static RegistryEntry<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient, List<ArmorMaterial.Layer> layers)
    {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values())
        {
            enumMap.put(type, defense.get(type));
        }
        return Registry.registerReference(Registries.ARMOR_MATERIAL, identifier(id), new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance));
    }
    //endregion
}