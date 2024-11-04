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

package jiraiyah.uio.command;

import com.mojang.brigadier.arguments.StringArgumentType;
import jiraiyah.uio.Configs;
import jiraiyah.uio.command.suggestion.DevCleanSuggestionProvider;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Objects;

import static jiraiyah.uio.Reference.*;

public class DclrCommand
{
    private static final int Y_MIN = -64;
    private static final int Y_MAX = 128;

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
                    "red_mushroom_block", "mushroom_stem",
                    "oak_stairs", "spruce_stairs", "birch_stairs", "jungle_stairs", "acacia_stairs", "cherry_stairs", "dark_oak_stairs", "mangrove_stairs",
                    "oak_trapdoor", "spruce_trapdoor", "birch_trapdoor", "jungle_trapdoor", "acacia_trapdoor", "cherry_trapdoor",
                    "dark_oak_trapdoor", "mangrove_trapdoor", "iron_trapdoor",
                    "pumpkin", "chain", "bee_nest", "melon", "polished_blackstone_bricks", "cracked_polished_blackstone_bricks",
                    "chiseled_polished_blackstone", "cracked_deepslate_bricks", "cracked_stone_bricks", "mossy_stone_bricks"
            };

    static String[] ore_clear_list =
            {
                    "gold_ore", "deepslate_gold_ore", "iron_ore", "deepslate_iron_ore", "coal_ore", "deepslate_coal_ore", "nether_gold_ore", "lapis_ore",
                    "deepslate_lapis_ore", "diamond_ore", "deepslate_diamond_ore", "redstone_ore", "deepslate_redstone_ore", "emerald_ore",
                    "deepslate_emerald_ore", "nether_quartz_ore", "copper_ore", "deepslate_copper_ore", "amethyst_block", "budding_amethyst",
                    "amethyst_cluster", "large_amethyst_bud", "medium_amethyst_bud", "small_amethyst_bud", "raw_iron_block", "raw_copper_block", "raw_gold_block",
                    "prismarine", "prismarine_bricks", "dark_prismarine", "sea_lantern"
            };

    static String[] fluid_block_list = {"water", "lava", "kelp", "kelp_plant", "seagrass", "tall_seagrass", "air", "bubble_column", "glow_lichen"};
    //endregion

    public DclrCommand()
    {
        throw new AssertionError();
    }

    public static void register()
    {
        if (FabricLoader.getInstance().isDevelopmentEnvironment())
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
                                                                                        context.getSource().sendFeedback(() -> translate(Constants.DCLR_ERROR_ID_NAME), false);
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

                                                                                            int minX = position.getX() - Configs.DCLR_RADIUS;
                                                                                            int maxX = position.getX() + Configs.DCLR_RADIUS;
                                                                                            int minZ = position.getZ() - Configs.DCLR_RADIUS;
                                                                                            int maxZ = position.getZ() + Configs.DCLR_RADIUS;

                                                                                            context.getSource().sendFeedback(() -> translate(Constants.DCLR_START_ID_NAME), false);

                                                                                            BlockState state;
                                                                                            String name;
                                                                                            BlockPos pos;

                                                                                            World world = player.getWorld();

                                                                                            for (int y = -64; y <= 128; y++)
                                                                                            {
                                                                                                for (int x = minX; x <= maxX; x++)
                                                                                                {
                                                                                                    for (int z = minZ; z <= maxZ; z++)
                                                                                                    {
                                                                                                        pos = new BlockPos(x, y, z);
                                                                                                        state = world.getBlockState(pos);
                                                                                                        name = Registries.BLOCK.getEntry(state.getBlock()).getKey().orElseThrow().getValue().getPath();
                                                                                                        if (x == minX || x == maxX || z == minZ || z == maxZ)
                                                                                                        {
                                                                                                            if (y <= 65 &&
                                                                                                                ArrayUtils.contains(fluid_block_list, name))
                                                                                                                world.setBlockState(pos, Blocks.OBSIDIAN.getDefaultState(), Block.NOTIFY_ALL);
                                                                                                            else if (ArrayUtils.contains(fluid_block_list, name) &&
                                                                                                                     !name.equals("air"))
                                                                                                                world.setBlockState(pos, Blocks.OBSIDIAN.getDefaultState(), Block.NOTIFY_ALL);
                                                                                                        }
                                                                                                        else if (minX < x && x < maxX &&
                                                                                                                 minZ < z && z < maxZ &&
                                                                                                                 ArrayUtils.contains(blocks, name))
                                                                                                            world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
                                                                                                    }
                                                                                                }
                                                                                            }

                                                                                            context.getSource().sendFeedback(() -> translate(Constants.DCLR_END_ID_NAME), false);
                                                                                        }
                                                                                    }
                                                                                    return 1;
                                                                                })));
            })));
        }
    }
}