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

import jiraiyah.uio.registry.ModEvents;
import jiraiyah.uio.registry.*;
import jiraiyah.uio.registry.misc.*;
import jiraiyah.uio.registry.world.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.math.BlockPos;

import static jiraiyah.uio.Reference.LOGGER;
import static jiraiyah.uio.Reference.logMain;

//region CUSTOM FLAT WORLD GEN PRESETS
// This is a flat world gen custom preset I always use for redstone and building massive tech contraptions
// It has 5 levels of bedrock, 30 layers of green concrete, and a black stained-glass on top layer.
// The concrete color is such that it will let redstone dust be seen easier. The reason for glass on top layer
// is to prevent any mob spawn if you forget to set the world to peaceful.
// >>>
// 5*minecraft:bedrock,30*minecraft:green_concrete,minecraft:black_stained_glass;minecraft:plains;
//
// This is an alternate version without any glass layer on top. If you don't set the world to peaceful, mobs will spawn on ground
// >>>
// 5*minecraft:bedrock,30*minecraft:green_concrete;minecraft:plains;
// ==================================================================================================================================
// This is the flat world gen custom preset I always use for demonstration of my mod and test the game mechanics
// It has 5 levels of bedrock, 30 layers of light blue wool and a layer of light blue carpet on top.
// Having carpet as top layer will make sure that even if you forget to make the game peaceful, no mod will spawn
// >>>
// 5*minecraft:bedrock,30*minecraft:light_blue_wool,minecraft:light_blue_carpet;minecraft:plains;village
//endregion

//region FACING CHEAT SHEET
// ======================
// FACING GUIDE LINE :
// ======================
// Blocks that are facing Opposite directions on placement will have the opposite
// relative facing compared to the direction the player is facing.
// >>>>>>>>>> NORTH <<<<<<<<<<<<<
// ======== Negative Z ========
// Left  : West, Negative X
// Right : East, Positive X
// Front : South, Positive Z
// Back  : North, Negative Z
// >>>>>>>>>> SOUTH <<<<<<<<<<<<<
// ======== Positive Z ========
// Left  : East, Positive X
// Right : West, Negative X
// Front : North, Negative Z
// Back  : South, Positive Z
// >>>>>>>>>> EAST <<<<<<<<<<<<<<
// ======== Positive X ========
// Left  : North, Negative Y
// Right : South, Positive Y
// Front : West, Negative Z
// Back  : East, Positive Z
// >>>>>>>>>> WEST <<<<<<<<<<<<<<
// ======== Negative X ========
// Left  : South, Positive Y
// Right : North, Negative Y
// Front : East, Positive Z
// Back  : West, Negative Z
//endregion

//TODO : Add void dimension
//TODO : Add Mining dimension (maybe)
//TODO : Add Crops (maybe corn or something more useful)
//TODO : Add Rubber Tree with everything related to wood
//TODO : Add Villager Trades and New Villager Type
//TODO : Add Ender Shulker Boxes
//TODO : Add redstone logic gates
//TODO : Add Fluid Tanks
//TODO : Rotate Blocks Using Wrench
//TODO : Draw extra info in world when have wrench in hand (maybe)
//TODO : Add new rideable entity that moves faster than player
//TODO : Add new projectile (maybe tnt / torch arrow?)
//TODO : Add new aggressive mob (maybe with new AI?)
//TODO : Make different goo blocks functional
//TODO : Add new flower (not sure what)
//TODO : Add new biome (maybe planes with less bump and more flatness with more rubber trees)
//TODO : Add player starting inventory kit
//TODO : Add custom structures (maybe ruined portals to custom mod dimensions)
//TODO : Add new enchantment (Lava Walking)

public class Main implements ModInitializer
{
    public static boolean DEBUG;

    @Override
    public void onInitialize()
    {
        DEBUG = FabricLoader.getInstance().isDevelopmentEnvironment();

        logMain();

        //region REGISTER CALLS
        ModEvents.register();

        ModItems.register();
        ModBlocks.register();

        ModRecipes.register(); // Should happen after item and block registration
        ModItemGroups.register(); // Should happen after Items and Block Registration
        ModBlockEntities.register(); // Should happen after block registration
        ModScreenHandlers.register(); // Should happen after block and block entity registration

        ModWorldGeneration.register(); // Should happen after Items and Block Registration
        ModPortals.register(); // Should happen after Items and Block Registration
        ModStrippables.register(); // Should happen after Items and Block Registration

        ModAttributes.register();
        ModCompostables.register();
        ModEffects.register();
        ModFlammables.register();
        ModFuels.register();
        ModOxidizables.register();
        ModPotionRecipes.register();
        ModTrades.register();

        ModCommands.register();

        ModMessages.registerC2SPackets();
        //endregion
    }
}