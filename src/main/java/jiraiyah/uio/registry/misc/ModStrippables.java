package jiraiyah.uio.registry.misc;

import static jiraiyah.uio.Reference.log;

public class ModStrippables
{
    ModStrippables()
    {
        throw new AssertionError();
    }

    public static void init()
    {
        log("Registering Strippables");
    }
}