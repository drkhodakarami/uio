package jiraiyah.uio.util.interfaces;

import net.minecraft.item.ToolMaterial;

@FunctionalInterface
public interface ToolRegisterFunction<U, R>
{
    R apply(ToolMaterial material, Float damage, Float speed, U settings);
}