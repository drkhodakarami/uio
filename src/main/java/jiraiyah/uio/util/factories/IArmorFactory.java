package jiraiyah.uio.util.factories;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;

@FunctionalInterface
public interface IArmorFactory<T, R>
{
    R apply(ArmorMaterial material, EquipmentType equipment, T settings);
}