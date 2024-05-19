package jiraiyah.uio;

import jiraiyah.uio.registry.*;
import jiraiyah.uio.registry.world.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import static jiraiyah.uio.Reference.logBackRGB256;

// This is the flat world gen custom preset I always use
// 5*minecraft:bedrock,30*minecraft:light_blue_wool,minecraft:light_blue_carpet;minecraft:plains;village

public class Main implements ModInitializer
{
    public static final boolean DEBUG = true;

    @Override
    public void onInitialize()
    {
        logBackRGB256("Initializing", 255, 255, 0, 255, 0, 127);

        ModItems.register();
        ModBlocks.register();
        ModItemGroups.register();
        ModCommands.register();
        ModBlockEntities.register();
        ModScreenHandlers.register();
        ModRecipes.register();
        ModWorldGeneration.register();
        ModMessages.registerC2SPackets();
        ModEffects.register();

        ModRegistries.register();
    }
}