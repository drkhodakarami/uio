package jiraiyah.uio.registry.misc;

import jiraiyah.uio.registry.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;

import static jiraiyah.uio.Reference.log;

public class ModFuels
{
    public ModFuels()
    {
        throw new AssertionError();
    }

    public static void register()
    {
        log("Registering Fuel");
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.HOT_COAL, 6400);
    }
}
