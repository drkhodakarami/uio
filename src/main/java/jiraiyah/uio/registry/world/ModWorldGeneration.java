package jiraiyah.uio.registry.world;

import static jiraiyah.uio.Reference.log;

public class ModWorldGeneration
{
    public ModWorldGeneration()
    {
        throw new AssertionError();
    }

    public static void register()
    {
        log("Registering World Generation");

        ModGeodeGeneration.generate();
        ModOreGeneration.generate();
        ModTreeGeneration.generate();
        ModFlowerGeneration.generate();
        ModEntitySpawns.addSpawns();
    }
}