package jiraiyah.uio.registry.misc;

import jiraiyah.uio.util.record.CoordinateData;
import net.minecraft.component.ComponentType;

import static jiraiyah.uio.Reference.log;
import static jiraiyah.uio.util.Registers.ComponentTypes.*;

public class ModDataComponentTypes
{
    public static ComponentType<CoordinateData> COORDINATE;

    public static void init()
    {
        log("Registering custom data component types");

        COORDINATE = register("coordinates", builder -> builder.codec(CoordinateData.CODEC));
    }
}