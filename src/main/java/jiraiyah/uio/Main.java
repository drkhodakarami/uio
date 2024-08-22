/***********************************************************************************
 * Copyright (c) 2024 Alireza Khodakarami (Jiraiyah)                               *
 * ------------------------------------------------------------------------------- *
 * MIT License                                                                     *
 * =============================================================================== *
 * Permission is hereby granted, free of charge, to any person obtaining a copy    *
 * of this software and associated documentation files (the "Software"), to deal   *
 * in the Software without restriction, including without limitation the rights    *
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell       *
 * copies of the Software, and to permit persons to whom the Software is           *
 * furnished to do so, subject to the following conditions:                        *
 * ------------------------------------------------------------------------------- *
 * The above copyright notice and this permission notice shall be included in all  *
 * copies or substantial portions of the Software.                                 *
 * ------------------------------------------------------------------------------- *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR      *
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,        *
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE     *
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER          *
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,   *
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE   *
 * SOFTWARE.                                                                       *
 ***********************************************************************************/

package jiraiyah.uio;

import jiraiyah.uio.event.ModEvents;
import jiraiyah.uio.registry.*;
import jiraiyah.uio.registry.world.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import static jiraiyah.uio.Reference.logBackRGB256;

// This is the flat world gen custom preset I always use
// 5*minecraft:bedrock,30*minecraft:light_blue_wool,minecraft:light_blue_carpet;minecraft:plains;village


public class Main implements ModInitializer
{
    public static boolean DEBUG;

    @Override
    public void onInitialize()
    {
        DEBUG = FabricLoader.getInstance().isDevelopmentEnvironment();

        Reference.LOGGER.info("\u001b[38;2;" + 255 + ";" + 255 + ";" + 0 + ";48;2;" + 255 + ";" + 0 + ";" + 127 + "m>>> " + "Initializing" + " " + Reference.ANSI_RESET);

        ModEvents.addListeners();

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