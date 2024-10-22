package jiraiyah.uio.util;

import net.minecraft.world.World;

public class MathHelper
{
    public static float getChance(int value)
    {
        return (100 - value) / 100.0f;
    }

    public static boolean getChance(World world, int value)
    {
        return world.getRandom().nextFloat() >= getChance(value);
    }
}