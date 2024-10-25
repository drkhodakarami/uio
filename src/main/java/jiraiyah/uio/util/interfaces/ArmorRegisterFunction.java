package jiraiyah.uio.util.interfaces;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;

@FunctionalInterface
public interface ArmorRegisterFunction<T, R>
{
    R apply(ArmorMaterial material, EquipmentType equipment, T settings);
}