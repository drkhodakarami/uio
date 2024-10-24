package jiraiyah.uio.util.interfaces;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;

public interface ArmorRegisterFunction<U, R>
{
    R apply(ArmorMaterial material, EquipmentType equipment, U settings);
}