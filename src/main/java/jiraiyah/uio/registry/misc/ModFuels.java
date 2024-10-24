package jiraiyah.uio.registry.misc;

import jiraiyah.uio.registry.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;

import static jiraiyah.uio.Reference.log;

public class ModFuels
{
    ModFuels()
    {
        throw new AssertionError();
    }

    public static void init()
    {
        log("Registering Fuel");

        //TODO: New way of registering fuel for 1.21.2
        FuelRegistryEvents.BUILD.register((builder, context) ->
                                             {
                                                 builder.add(ModItems.HOT_COAL, context.baseSmeltTime() * 32); //6400
                                             });
    }
}