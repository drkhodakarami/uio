package jiraiyah.uio.util.factories;

import net.minecraft.item.ToolMaterial;

@FunctionalInterface
public interface IToolFactory<U, R>
{
    R apply(ToolMaterial material, Float damage, Float speed, U settings);
}