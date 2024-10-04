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

package jiraiyah.uio.registry;

import com.mojang.brigadier.arguments.StringArgumentType;
import jiraiyah.uio.command.DevCleanSuggestionProvider;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Objects;

import static jiraiyah.uio.Reference.*;

public class ModCommands
{
    public static final String DCLR_ERROR_ID_NAME = "dclr.error";
    public static final String DCLR_START_ID_NAME = "dclr.start";

    private static final int CLEAR_COMMAND_DISTANCE = 32;

    //region DCLR Lists
    static String[] block_clear_list =
            {
                    "oak_log", "spruce_log", "birch_log", "jungle_log", "acacia_log", "cherry_log", "dark_oak_log", "mangrove_log", "mangrove_roots",
                    "muddy_mangrove_roots", "oak_wood", "spruce_wood", "birch_wood", "jungle_wood", "acacia_wood", "cherry_wood", "dark_oak_wood",
                    "mangrove_wood", "oak_planks", "spruce_planks", "birch_planks", "jungle_planks", "acacia_planks", "cherry_planks", "dark_oak_planks",
                    "mangrove_planks", "bamboo_planks", "oak_leaves", "spruce_leaves", "birch_leaves", "jungle_leaves", "acacia_leaves", "cherry_leaves",
                    "dark_oak_leaves", "mangrove_leaves", "azalea_leaves", "flowering_azalea_leaves", "gravel", "sand", "red_sand", "red_sandstone",
                    "water", "lava", "sandstone", "granite", "diorite", "andesite", "dirt", "podzol", "deepslate", "stone", "cobblestone",
                    "mossy_cobblestone", "dripstone_block", "pointed_dripstone", "smooth_basalt", "tuff", "calcite", "obsidian", "tall_grass", "seagrass",
                    "tall_seagrass", "short_grass", "kelp", "sea_pickle", "cobweb", "dirt_path", "grass_block", "netherrack", "soul_sand", "soul_soil",
                    "basalt", "glowstone", "nether_bricks", "end_stone", "end_stone_bricks", "ice", "snow", "snow_block", "powder_snow", "moss_block",
                    "clay", "magma_block", "coarse_dirt", "oak_fence", "spruce_fence", "birch_fence", "jungle_fence", "acacia_fence", "cherry_fence",
                    "dark_oak_fence", "mangrove_fence", "bamboo_fence", "oak_fence_gate", "spruce_fence_gate", "birch_fence_gate", "jungle_fence_gate",
                    "acacia_fence_gate", "cherry_fence_gate", "dark_oak_fence_gate", "mangrove_fence_gate", "bamboo_fence_gate", "nether_brick_fence",
                    "crimson_fence", "warped_fence", "crimson_fence_gate", "warped_fence_gate", "kelp_plant", "mud_bricks", "packed_mud", "white_terracotta",
                    "orange_terracotta", "magenta_terracotta", "light_blue_terracotta", "yellow_terracotta", "lime_terracotta", "pink_terracotta",
                    "gray_terracotta", "light_gray_terracotta", "cyan_terracotta", "purple_terracotta", "blue_terracotta", "brown_terracotta",
                    "green_terracotta", "red_terracotta", "black_terracotta", "terracotta", "white_glazed_terracotta", "orange_glazed_terracotta",
                    "magenta_glazed_terracotta", "light_blue_glazed_terracotta", "yellow_glazed_terracotta", "lime_glazed_terracotta",
                    "pink_glazed_terracotta", "gray_glazed_terracotta", "light_gray_glazed_terracotta", "cyan_glazed_terracotta", "purple_glazed_terracotta",
                    "blue_glazed_terracotta", "brown_glazed_terracotta", "green_glazed_terracotta", "red_glazed_terracotta", "black_glazed_terracotta",
                    "white_concrete", "orange_concrete", "magenta_concrete", "light_blue_concrete", "yellow_concrete", "lime_concrete", "pink_concrete",
                    "gray_concrete", "light_gray_concrete", "cyan_concrete", "purple_concrete", "blue_concrete", "brown_concrete", "green_concrete",
                    "red_concrete", "black_concrete", "white_concrete_powder", "orange_concrete_powder", "magenta_concrete_powder",
                    "light_blue_concrete_powder", "yellow_concrete_powder", "lime_concrete_powder", "pink_concrete_powder", "gray_concrete_powder",
                    "light_gray_concrete_powder", "cyan_concrete_powder", "purple_concrete_powder", "blue_concrete_powder", "brown_concrete_powder",
                    "green_concrete_powder", "red_concrete_powder", "black_concrete_powder", "brown_mushroom", "red_mushroom", "brown_mushroom_block",
                    "red_mushroom_block", "mushroom_stem"
            };

    static String[] ore_clear_list =
            {
                    "gold_ore", "deepslate_gold_ore", "iron_ore", "deepslate_iron_ore", "coal_ore", "deepslate_coal_ore", "nether_gold_ore", "lapis_ore",
                    "deepslate_lapis_ore", "diamond_ore", "deepslate_diamond_ore", "redstone_ore", "deepslate_redstone_ore", "emerald_ore",
                    "deepslate_emerald_ore", "nether_quartz_ore", "copper_ore", "deepslate_copper_ore", "amethyst_block", "budding_amethyst",
                    "amethyst_cluster", "large_amethyst_bud", "medium_amethyst_bud", "small_amethyst_bud", "raw_iron_block", "raw_copper_block", "raw_gold_block",
                    "prismarine", "prismarine_bricks", "dark_prismarine", "sea_lantern"
            };

    static String[] fluid_block_list ={"water", "lava", "kelp", "kelp_plant"};
    //endregion

    public ModCommands()
    {
        throw new AssertionError();
    }

    public static void register()
    {
        log("Registering Commands");

        registerDevCleanCommand();
    }

    private static void registerDevCleanCommand()
    {
        if(FabricLoader.getInstance().isDevelopmentEnvironment())
        {
            CommandRegistrationCallback.EVENT.register((((dispatcher, registryAccess, environment) ->
            {
                dispatcher.register(CommandManager.literal("dclr")
                          .then(CommandManager.argument("clear_operation_type", StringArgumentType.string())
                              .suggests(new DevCleanSuggestionProvider())
                              .executes(context ->
                                {
                                    String typ = StringArgumentType.getString(context, "clear_operation_type");
                                    if (Objects.equals(typ, ""))
                                        typ = "all";

                                    if (!Objects.equals(typ, "ore") &&
                                        !Objects.equals(typ, "block") &&
                                        !Objects.equals(typ, "fluid") &&
                                        !Objects.equals(typ, "all"))
                                    {
                                        context.getSource().sendFeedback(() -> translate(DCLR_ERROR_ID_NAME), false);
                                    }
                                    else
                                    {
                                        String[] blocks = Objects.equals(typ, "ore")
                                                          ? ArrayUtils.addAll(ore_clear_list)
                                                          : Objects.equals(typ, "block")
                                                            ? ArrayUtils.addAll(block_clear_list)
                                                            : Objects.equals(typ, "fluid")
                                                              ? ArrayUtils.addAll(fluid_block_list)
                                                              : ArrayUtils.addAll(block_clear_list, ore_clear_list);

                                        if (blocks.length == 0)
                                            return 1;

                                        PlayerEntity player = context.getSource().getPlayer();

                                        if (player != null)
                                        {
                                            MinecraftServer server = player.getServer();
                                            BlockPos position = player.getBlockPos();

                                            int minX = position.getX() - CLEAR_COMMAND_DISTANCE;
                                            int maxX = position.getX() + CLEAR_COMMAND_DISTANCE;
                                            int minZ = position.getZ() - CLEAR_COMMAND_DISTANCE;
                                            int maxZ = position.getZ() + CLEAR_COMMAND_DISTANCE;

                                            CommandManager commandManager = Objects.requireNonNull(server).getCommandManager();
                                            ServerCommandSource commandSource = server.getCommandSource();

                                            context.getSource().sendFeedback(() -> translate(DCLR_START_ID_NAME), false);

                                            String cmd = "";

                                            boolean rule = context.getSource().getWorld().getGameRules().getBoolean(GameRules.SEND_COMMAND_FEEDBACK);

                                            cmd = "/gamerule sendCommandFeedback false";
                                            commandManager.executeWithPrefix(commandSource, cmd);
                                            try
                                            {
                                                Thread.sleep(5);
                                            }
                                            catch (InterruptedException ignored){}

                                            for (String block : fluid_block_list)
                                            {
                                                // /fill ~-32 -64 ~-32 ~-32 128 ~32 minecraft:obsidian replace minecraft:water
                                                cmd = ("/fill " + minX + " -64 " + minZ + " " + minX + " 128 " + maxZ + " minecraft:obsidian replace minecraft:" + block);
                                                commandManager.executeWithPrefix(commandSource, cmd);
                                                try
                                                {
                                                    Thread.sleep(5);
                                                }
                                                catch (InterruptedException ignored){}

                                                cmd = ("/fill " + minX + " -64 " + minZ + " " + maxX + " 128 " + minZ + " minecraft:obsidian replace minecraft:" + block);
                                                commandManager.executeWithPrefix(commandSource, cmd);
                                                try
                                                {
                                                    Thread.sleep(5);
                                                }
                                                catch (InterruptedException ignored){}

                                                cmd = ("/fill " + minX + " -64 " + maxZ + " " + maxX + " 128 " + maxZ + " minecraft:obsidian replace minecraft:" + block);
                                                commandManager.executeWithPrefix(commandSource, cmd);
                                                try
                                                {
                                                    Thread.sleep(5);
                                                }
                                                catch (InterruptedException ignored){}

                                                cmd = ("/fill " + maxX + " -64 " + minZ + " " + maxX + " 128 " + maxZ + " minecraft:obsidian replace minecraft:" + block);
                                                commandManager.executeWithPrefix(commandSource, cmd);
                                                try
                                                {
                                                    Thread.sleep(5);
                                                }
                                                catch (InterruptedException ignored){}
                                            }

                                            for (int l = 144; l >= -63; l -= 8)
                                            {
                                                for (String block : blocks)
                                                {
                                                    cmd = ("/fill |minX| |l| |minZ| |maxX| |m| |maxZ| minecraft:air replace minecraft:" + block)
                                                            .replace("|l|", String.valueOf(l))
                                                            .replace("|m|", String.valueOf(l - 7))
                                                            .replace("|minX|", String.valueOf(minX + 1))
                                                            .replace("|maxX|", String.valueOf(maxX - 1))
                                                            .replace("|minZ|", String.valueOf(minZ + 1))
                                                            .replace("|maxZ|", String.valueOf(maxZ - 1));

                                                    commandManager.executeWithPrefix(commandSource, cmd);
                                                    try
                                                    {
                                                        Thread.sleep(5);
                                                    }
                                                    catch (InterruptedException ignored){}
                                                }
                                            }

                                            cmd = "/gamerule sendCommandFeedback " + rule;
                                            commandManager.executeWithPrefix(commandSource, cmd);
                                            try
                                            {
                                                Thread.sleep(5);
                                            }
                                            catch (InterruptedException ignored){}
                                        }
                                    }
                                    return 1;
                                })));
            })));
        }
    }
}