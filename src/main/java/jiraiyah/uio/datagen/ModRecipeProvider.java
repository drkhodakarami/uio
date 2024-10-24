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

package jiraiyah.uio.datagen;

import jiraiyah.uio.registry.ModBlocks;
import jiraiyah.uio.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static jiraiyah.uio.Reference.logRGB256;

public class ModRecipeProvider extends FabricRecipeProvider
{
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, registriesFuture);
    }

    @Override
    public String getName()
    {
        return "";
    }

    //TODO: New way of providing recipe for datagen in 1.21.2
    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter)
    {
        return new RecipeGenerator(registries, exporter)
        {
            @Override
            public void generate()
            {
                logRGB256("Generating Recipe Data", 0, 255, 0);

                //region GEM BLOCKS
                //TODO: In the offer methods, we don't send in the exporter any more
                // When you see exporter as first param, just delete it!
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.GEM_CITRINE,
                                                 RecipeCategory.DECORATIONS, ModBlocks.CITRINE);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.GEM_RUBY,
                                                 RecipeCategory.DECORATIONS, ModBlocks.RUBY);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.GEM_SAPPHIRE,
                                                 RecipeCategory.DECORATIONS, ModBlocks.SAPPHIRE);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.INGOT_ENDERITE,
                                                 RecipeCategory.DECORATIONS, ModBlocks.ENDERITE);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_CITRINE,
                                                 RecipeCategory.DECORATIONS, ModBlocks.RAW_CITRINE);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_ENDERITE,
                                                 RecipeCategory.DECORATIONS, ModBlocks.RAW_ENDERITE);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_QUARTZ,
                                                 RecipeCategory.DECORATIONS, ModBlocks.RAW_QUARTZ);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_RUBY,
                                                 RecipeCategory.DECORATIONS, ModBlocks.RAW_RUBY);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_SAPPHIRE,
                                                 RecipeCategory.DECORATIONS, ModBlocks.RAW_SAPPHIRE);
                //endregion
                //region LEATHER
                offerFoodCookingRecipe("smoking", RecipeSerializer.SMOKING, SmokingRecipe::new,
                                       400, Items.ROTTEN_FLESH, Items.LEATHER, 0.1F);
                //endregion
                //region MAIN TOOLS
                //TODO: Now we have createShaped and createShapeless methods instead ShapedRecipeJsonBuilder and ShapelessRecipeJsonBuilder
                // the offerTo now accepts String instead of identifier, remove the VanillaID and send the name directly
                createShaped(RecipeCategory.TOOLS, ModItems.BACKPACK, 1)
                                       .pattern("LLL")
                                       .pattern("LCL")
                                       .pattern("LLL")
                                       .input('C', Items.CHEST)
                                       .input('L', Items.LEATHER)
                                       .criterion(hasItem(Items.CHEST), conditionsFromItem(Items.CHEST))
                                       .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                                       .offerTo(exporter, getRecipeName(ModItems.BACKPACK));

                createShaped(RecipeCategory.TOOLS, ModItems.ENDER_BACKPACK, 1)
                                       .pattern(" L ")
                                       .pattern("LCL")
                                       .pattern(" L ")
                                       .input('C', ModItems.BACKPACK)
                                       .input('L', ModItems.INGOT_ENDERITE)
                                       .criterion(hasItem(ModItems.BACKPACK), conditionsFromItem(ModItems.BACKPACK))
                                       .criterion(hasItem(ModItems.INGOT_ENDERITE), conditionsFromItem(ModItems.INGOT_ENDERITE))
                                       .offerTo(exporter, getRecipeName(ModItems.ENDER_BACKPACK));

                createShaped(RecipeCategory.TOOLS, ModItems.PLAYER_TELEPORT, 1)
                                       .pattern("PEP")
                                       .pattern("DCD")
                                       .pattern("GGG")
                                       .input('P', Items.ENDER_PEARL)
                                       .input('E', Items.ENDER_EYE)
                                       .input('C', Items.COMPASS)
                                       .input('D', ModItems.REINFORCED_DIAMOND)
                                       .input('G', ModItems.REINFORCED_GOLD)
                                       .criterion(hasItem(Items.COMPASS), conditionsFromItem(Items.COMPASS))
                                       .criterion(hasItem(Items.ENDER_EYE), conditionsFromItem(Items.ENDER_EYE))
                                       .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                                       .criterion(hasItem(ModItems.REINFORCED_DIAMOND), conditionsFromItem(ModItems.REINFORCED_DIAMOND))
                                       .criterion(hasItem(ModItems.REINFORCED_GOLD), conditionsFromItem(ModItems.REINFORCED_GOLD))
                                       .offerTo(exporter, getRecipeName(ModItems.PLAYER_TELEPORT));

                createShaped(RecipeCategory.TOOLS, ModItems.TUNER, 1)
                                       .pattern("P P")
                                       .pattern("IEI")
                                       .pattern(" I ")
                                       .input('P', Items.ENDER_PEARL)
                                       .input('E', Items.ENDER_EYE)
                                       .input('I', ModItems.ROD_IRON)
                                       .criterion(hasItem(Items.ENDER_EYE), conditionsFromItem(Items.ENDER_EYE))
                                       .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                                       .criterion(hasItem(ModItems.ROD_IRON), conditionsFromItem(ModItems.ROD_IRON))
                                       .offerTo(exporter, getRecipeName(ModItems.TUNER));

                createShaped(RecipeCategory.TOOLS, ModItems.ADVANCED_TUNER, 1)
                                       .pattern("PIP")
                                       .pattern("IEI")
                                       .pattern("PIP")
                                       .input('I', ModItems.ENDER_CHARM)
                                       .input('E', ModItems.TUNER)
                                       .input('P', ModItems.HOT_COAL)
                                       .criterion(hasItem(ModItems.TUNER), conditionsFromItem(ModItems.TUNER))
                                       .criterion(hasItem(ModItems.ENDER_CHARM), conditionsFromItem(ModItems.ENDER_CHARM))
                                       .criterion(hasItem(ModItems.HOT_COAL), conditionsFromItem(ModItems.HOT_COAL))
                                       .offerTo(exporter, getRecipeName(ModItems.ADVANCED_TUNER));

                createShaped(RecipeCategory.TOOLS, ModItems.WRENCH, 1)
                                       .pattern("O O")
                                       .pattern(" O ")
                                       .pattern(" I ")
                                       .input('O', ModItems.ROD_OBSIDIAN)
                                       .input('I', ModItems.ROD_IRON)
                                       .criterion(hasItem(ModItems.ROD_IRON), conditionsFromItem(ModItems.ROD_IRON))
                                       .criterion(hasItem(ModItems.ROD_OBSIDIAN), conditionsFromItem(ModItems.ROD_OBSIDIAN))
                                       .offerTo(exporter, getRecipeName(ModItems.WRENCH));

                createShaped(RecipeCategory.TOOLS, ModItems.CHALICE_EMPTY, 1)
                                       .pattern("GEG")
                                       .pattern(" R ")
                                       .pattern("GGG")
                                       .input('G', ModItems.PLATE_GOLD)
                                       .input('R', ModItems.ROD_GOLD)
                                       .input('E', Items.ENDER_PEARL)
                                       .criterion(hasItem(ModItems.ROD_GOLD), conditionsFromItem(ModItems.ROD_GOLD))
                                       .criterion(hasItem(ModItems.PLATE_GOLD), conditionsFromItem(ModItems.PLATE_GOLD))
                                       .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                                       .offerTo(exporter, getRecipeName(ModItems.CHALICE_EMPTY));

                createShapeless(RecipeCategory.MISC, ModItems.CHALICE, 1)
                                          .input(Items.WATER_BUCKET)
                                          .input(ModItems.CHALICE_EMPTY)
                                          .criterion(hasItem(Items.WATER_BUCKET), conditionsFromItem(Items.WATER_BUCKET))
                                          .criterion(hasItem(ModItems.CHALICE_EMPTY), conditionsFromItem(ModItems.CHALICE_EMPTY))
                                          .offerTo(exporter, getRecipeName(ModItems.CHALICE) + "_shapeless");
                //endregion
                //region VANILLA
                createShapeless(RecipeCategory.MISC, Items.NAME_TAG, 1)
                                          .input(Items.PAPER)
                                          .input(ModItems.ROD_IRON)
                                          .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                                          .criterion(hasItem(ModItems.ROD_IRON), conditionsFromItem(ModItems.ROD_IRON))
                                          .offerTo(exporter, getRecipeName(Items.NAME_TAG) + "_shapeless");
                //endregion
                //region STAIRS
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.CITRINE_STAIRS, ModBlocks.CITRINE, 9);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.ENDERITE_STAIRS, ModBlocks.ENDERITE, 9);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.RUBY_STAIRS, ModBlocks.RUBY, 9);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.SAPPHIRE_STAIRS, ModBlocks.SAPPHIRE, 9);
                //endregion
                //region SLABS
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.CITRINE_SLAB, ModBlocks.CITRINE, 18);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.ENDERITE_SLAB, ModItems.INGOT_ENDERITE, 18);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.RUBY_SLAB, ModItems.GEM_RUBY, 18);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.SAPPHIRE_SLAB, ModItems.GEM_SAPPHIRE, 18);
                //endregion
                //region PRESSURE PLATE
                createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.CITRINE_PRESSURE_PLATE, Ingredient.ofItems(ModItems.GEM_CITRINE))
                        .criterion(hasItem(ModItems.GEM_CITRINE), conditionsFromItem(ModItems.GEM_CITRINE))
                        .offerTo(exporter, getRecipeName(ModBlocks.CITRINE_PRESSURE_PLATE));
                createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.ENDERITE_PRESSURE_PLATE, Ingredient.ofItems(ModItems.INGOT_ENDERITE))
                        .criterion(hasItem(ModItems.INGOT_ENDERITE), conditionsFromItem(ModItems.INGOT_ENDERITE))
                        .offerTo(exporter, getRecipeName(ModBlocks.ENDERITE_PRESSURE_PLATE));
                createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.RUBY_PRESSURE_PLATE, Ingredient.ofItems(ModItems.GEM_RUBY))
                        .criterion(hasItem(ModItems.GEM_RUBY), conditionsFromItem(ModItems.GEM_RUBY))
                        .offerTo(exporter, getRecipeName(ModBlocks.RUBY_PRESSURE_PLATE));
                createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.SAPPHIRE_PRESSURE_PLATE, Ingredient.ofItems(ModItems.GEM_SAPPHIRE))
                        .criterion(hasItem(ModItems.GEM_SAPPHIRE), conditionsFromItem(ModItems.GEM_SAPPHIRE))
                        .offerTo(exporter, getRecipeName(ModBlocks.SAPPHIRE_PRESSURE_PLATE));
                //endregion
                //region FENCE
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.CITRINE_FENCE, ModBlocks.CITRINE, 9);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.ENDERITE_FENCE, ModItems.INGOT_ENDERITE, 9);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.RUBY_FENCE, ModItems.GEM_RUBY, 9);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.SAPPHIRE_FENCE, ModItems.GEM_SAPPHIRE, 9);
                //endregion
                //region FENCE GATE
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.CITRINE_FENCE_GATE, ModBlocks.CITRINE, 9);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.ENDERITE_FENCE_GATE, ModItems.INGOT_ENDERITE, 9);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.RUBY_FENCE_GATE, ModItems.GEM_RUBY, 9);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.SAPPHIRE_FENCE_GATE, ModItems.GEM_SAPPHIRE, 9);
                //endregion
                //region DOOR
                createDoorRecipe(ModBlocks.CITRINE_DOOR, Ingredient.ofItems(ModItems.GEM_CITRINE))
                        .criterion(hasItem(ModItems.GEM_CITRINE), conditionsFromItem(ModItems.GEM_CITRINE))
                        .offerTo(exporter, getRecipeName(ModBlocks.CITRINE_DOOR));
                createDoorRecipe(ModBlocks.ENDERITE_DOOR, Ingredient.ofItems(ModItems.INGOT_ENDERITE))
                        .criterion(hasItem(ModItems.INGOT_ENDERITE), conditionsFromItem(ModItems.INGOT_ENDERITE))
                        .offerTo(exporter, getRecipeName(ModBlocks.ENDERITE_DOOR));
                createDoorRecipe(ModBlocks.RUBY_DOOR, Ingredient.ofItems(ModItems.GEM_RUBY))
                        .criterion(hasItem(ModItems.GEM_RUBY), conditionsFromItem(ModItems.GEM_RUBY))
                        .offerTo(exporter, getRecipeName(ModBlocks.RUBY_DOOR));
                createDoorRecipe(ModBlocks.SAPPHIRE_DOOR, Ingredient.ofItems(ModItems.GEM_SAPPHIRE))
                        .criterion(hasItem(ModItems.GEM_SAPPHIRE), conditionsFromItem(ModItems.GEM_SAPPHIRE))
                        .offerTo(exporter, getRecipeName(ModBlocks.SAPPHIRE_DOOR));
                //endregion
                //region TRAP DOOR
                createTrapdoorRecipe(ModBlocks.CITRINE_TRAP_DOOR, Ingredient.ofItems(ModItems.GEM_CITRINE))
                        .criterion(hasItem(ModItems.GEM_CITRINE), conditionsFromItem(ModItems.GEM_CITRINE))
                        .offerTo(exporter, getRecipeName(ModBlocks.CITRINE_TRAP_DOOR));
                createTrapdoorRecipe(ModBlocks.ENDERITE_TRAP_DOOR, Ingredient.ofItems(ModItems.INGOT_ENDERITE))
                        .criterion(hasItem(ModItems.INGOT_ENDERITE), conditionsFromItem(ModItems.INGOT_ENDERITE))
                        .offerTo(exporter, getRecipeName(ModBlocks.ENDERITE_TRAP_DOOR));
                createTrapdoorRecipe(ModBlocks.RUBY_TRAP_DOOR, Ingredient.ofItems(ModItems.GEM_RUBY))
                        .criterion(hasItem(ModItems.GEM_RUBY), conditionsFromItem(ModItems.GEM_RUBY))
                        .offerTo(exporter, getRecipeName(ModBlocks.RUBY_TRAP_DOOR));
                createTrapdoorRecipe(ModBlocks.SAPPHIRE_TRAP_DOOR, Ingredient.ofItems(ModItems.GEM_SAPPHIRE))
                        .criterion(hasItem(ModItems.GEM_SAPPHIRE), conditionsFromItem(ModItems.GEM_SAPPHIRE))
                        .offerTo(exporter, getRecipeName(ModBlocks.SAPPHIRE_TRAP_DOOR));
                //endregion
                //region WALL
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.CITRINE_WALL, ModBlocks.CITRINE, 9);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.ENDERITE_WALL, ModBlocks.ENDERITE, 9);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.RUBY_WALL, ModBlocks.RUBY, 9);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.SAPPHIRE_WALL, ModBlocks.SAPPHIRE, 9);
                //endregion
                //region BUTTON
                createShapeless(RecipeCategory.REDSTONE, ModBlocks.CITRINE_BUTTON, 1)
                                          .input(ModItems.GEM_CITRINE)
                                          .criterion(hasItem(ModItems.GEM_CITRINE), conditionsFromItem(ModItems.GEM_CITRINE))
                                          .offerTo(exporter, getRecipeName(ModBlocks.CITRINE_BUTTON) + "_shapeless");
                createShapeless(RecipeCategory.REDSTONE, ModBlocks.ENDERITE_BUTTON, 1)
                                          .input(ModItems.INGOT_ENDERITE)
                                          .criterion(hasItem(ModItems.INGOT_ENDERITE), conditionsFromItem(ModItems.INGOT_ENDERITE))
                                          .offerTo(exporter, getRecipeName(ModBlocks.ENDERITE_BUTTON) + "_shapeless");
                createShapeless(RecipeCategory.REDSTONE, ModBlocks.RUBY_BUTTON, 1)
                                          .input(ModItems.GEM_RUBY)
                                          .criterion(hasItem(ModItems.GEM_RUBY), conditionsFromItem(ModItems.GEM_RUBY))
                                          .offerTo(exporter, getRecipeName(ModBlocks.RUBY_BUTTON) + "_shapeless");
                createShapeless(RecipeCategory.REDSTONE, ModBlocks.SAPPHIRE_BUTTON, 1)
                                          .input(ModItems.GEM_SAPPHIRE)
                                          .criterion(hasItem(ModItems.GEM_SAPPHIRE), conditionsFromItem(ModItems.GEM_SAPPHIRE))
                                          .offerTo(exporter, getRecipeName(ModBlocks.SAPPHIRE_BUTTON) + "_shapeless");
                //endregion
                //region CITRINE TOOLS
                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_CITRINE_AXE, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_CITRINE_AXE)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_CITRINE_AXE),
                                                  conditionsFromItem(ModItems.HEAD_CITRINE_AXE))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_CITRINE_AXE));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_CITRINE_EXCAVATOR, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_CITRINE_EXCAVATOR)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_CITRINE_EXCAVATOR),
                                                  conditionsFromItem(ModItems.HEAD_CITRINE_EXCAVATOR))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_CITRINE_EXCAVATOR));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_CITRINE_HAMMER, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_CITRINE_HAMMER)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_CITRINE_HAMMER),
                                                  conditionsFromItem(ModItems.HEAD_CITRINE_HAMMER))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_CITRINE_HAMMER));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_CITRINE_HOE, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_CITRINE_HOE)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_CITRINE_HOE),
                                                  conditionsFromItem(ModItems.HEAD_CITRINE_HOE))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_CITRINE_HOE));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_CITRINE_PICKAXE, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_CITRINE_PICKAXE)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_CITRINE_PICKAXE),
                                                  conditionsFromItem(ModItems.HEAD_CITRINE_PICKAXE))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_CITRINE_PICKAXE));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_CITRINE_SHOVEL, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_CITRINE_SHOVEL)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_CITRINE_SHOVEL),
                                                  conditionsFromItem(ModItems.HEAD_CITRINE_SHOVEL))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_CITRINE_SHOVEL));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_CITRINE_SWORD, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_CITRINE_SWORD)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_CITRINE_SWORD),
                                                  conditionsFromItem(ModItems.HEAD_CITRINE_SWORD))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_CITRINE_SWORD));
                //endregion
                //region COPPER TOOLS
                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_COPPER_AXE, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_COPPER_AXE)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_COPPER_AXE),
                                                  conditionsFromItem(ModItems.HEAD_COPPER_AXE))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_COPPER_AXE));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_COPPER_EXCAVATOR, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_COPPER_EXCAVATOR)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_COPPER_EXCAVATOR),
                                                  conditionsFromItem(ModItems.HEAD_COPPER_EXCAVATOR))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_COPPER_EXCAVATOR));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_COPPER_HAMMER, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_COPPER_HAMMER)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_COPPER_HAMMER),
                                                  conditionsFromItem(ModItems.HEAD_COPPER_HAMMER))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_COPPER_HAMMER));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_COPPER_HOE, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_COPPER_HOE)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_COPPER_HOE),
                                                  conditionsFromItem(ModItems.HEAD_COPPER_HOE))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_COPPER_HOE));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_COPPER_PICKAXE, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_COPPER_PICKAXE)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_COPPER_PICKAXE),
                                                  conditionsFromItem(ModItems.HEAD_COPPER_PICKAXE))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_COPPER_PICKAXE));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_COPPER_SHOVEL, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_COPPER_SHOVEL)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_COPPER_SHOVEL),
                                                  conditionsFromItem(ModItems.HEAD_COPPER_SHOVEL))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_COPPER_SHOVEL));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_COPPER_SWORD, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_COPPER_SWORD)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_COPPER_SWORD),
                                                  conditionsFromItem(ModItems.HEAD_COPPER_SWORD))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_COPPER_SWORD));
                //endregion
                //region ENDERITE TOOLS
                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_ENDERITE_AXE, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_ENDERITE_AXE)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_ENDERITE_AXE),
                                                  conditionsFromItem(ModItems.HEAD_ENDERITE_AXE))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_ENDERITE_AXE));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_ENDERITE_EXCAVATOR, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_ENDERITE_EXCAVATOR)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_ENDERITE_EXCAVATOR),
                                                  conditionsFromItem(ModItems.HEAD_ENDERITE_EXCAVATOR))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_ENDERITE_EXCAVATOR));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_ENDERITE_HAMMER, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_ENDERITE_HAMMER)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_ENDERITE_HAMMER),
                                                  conditionsFromItem(ModItems.HEAD_ENDERITE_HAMMER))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_ENDERITE_HAMMER));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_ENDERITE_HOE, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_ENDERITE_HOE)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_ENDERITE_HOE),
                                                  conditionsFromItem(ModItems.HEAD_ENDERITE_HOE))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_ENDERITE_HOE));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_ENDERITE_PICKAXE, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_ENDERITE_PICKAXE)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_ENDERITE_PICKAXE),
                                                  conditionsFromItem(ModItems.HEAD_ENDERITE_PICKAXE))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_ENDERITE_PICKAXE));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_ENDERITE_SHOVEL, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_ENDERITE_SHOVEL)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_ENDERITE_SHOVEL),
                                                  conditionsFromItem(ModItems.HEAD_ENDERITE_SHOVEL))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_ENDERITE_SHOVEL));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_ENDERITE_SWORD, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_ENDERITE_SWORD)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_ENDERITE_SWORD),
                                                  conditionsFromItem(ModItems.HEAD_ENDERITE_SWORD))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_ENDERITE_SWORD));
                //endregion
                //region RUBY TOOLS
                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_RUBY_AXE, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_RUBY_AXE)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_RUBY_AXE),
                                                  conditionsFromItem(ModItems.HEAD_RUBY_AXE))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_RUBY_AXE));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_RUBY_EXCAVATOR, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_RUBY_EXCAVATOR)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_RUBY_EXCAVATOR),
                                                  conditionsFromItem(ModItems.HEAD_RUBY_EXCAVATOR))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_RUBY_EXCAVATOR));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_RUBY_HAMMER, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_RUBY_HAMMER)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_RUBY_HAMMER),
                                                  conditionsFromItem(ModItems.HEAD_RUBY_HAMMER))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_RUBY_HAMMER));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_RUBY_HOE, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_RUBY_HOE)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_RUBY_HOE),
                                                  conditionsFromItem(ModItems.HEAD_RUBY_HOE))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_RUBY_HOE));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_RUBY_PICKAXE, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_RUBY_PICKAXE)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_RUBY_PICKAXE),
                                                  conditionsFromItem(ModItems.HEAD_RUBY_PICKAXE))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_RUBY_PICKAXE));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_RUBY_SHOVEL, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_RUBY_SHOVEL)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_RUBY_SHOVEL),
                                                  conditionsFromItem(ModItems.HEAD_RUBY_SHOVEL))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_RUBY_SHOVEL));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_RUBY_SWORD, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_RUBY_SWORD)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_RUBY_SWORD),
                                                  conditionsFromItem(ModItems.HEAD_RUBY_SWORD))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_RUBY_SWORD));
                //endregion
                //region SAPPHIRE TOOLS
                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_SAPPHIRE_AXE, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_SAPPHIRE_AXE)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_SAPPHIRE_AXE),
                                                  conditionsFromItem(ModItems.HEAD_SAPPHIRE_AXE))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_SAPPHIRE_AXE));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_SAPPHIRE_EXCAVATOR, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_SAPPHIRE_EXCAVATOR)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_SAPPHIRE_EXCAVATOR),
                                                  conditionsFromItem(ModItems.HEAD_SAPPHIRE_EXCAVATOR))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_SAPPHIRE_EXCAVATOR));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_SAPPHIRE_HAMMER, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_SAPPHIRE_HAMMER)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_SAPPHIRE_HAMMER),
                                                  conditionsFromItem(ModItems.HEAD_SAPPHIRE_HAMMER))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_SAPPHIRE_HAMMER));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_SAPPHIRE_HOE, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_SAPPHIRE_HOE)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_SAPPHIRE_HOE),
                                                  conditionsFromItem(ModItems.HEAD_SAPPHIRE_HOE))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_SAPPHIRE_HOE));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_SAPPHIRE_PICKAXE, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_SAPPHIRE_PICKAXE)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_SAPPHIRE_PICKAXE),
                                                  conditionsFromItem(ModItems.HEAD_SAPPHIRE_PICKAXE))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_SAPPHIRE_PICKAXE));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_SAPPHIRE_SHOVEL, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_SAPPHIRE_SHOVEL)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_SAPPHIRE_SHOVEL),
                                                  conditionsFromItem(ModItems.HEAD_SAPPHIRE_SHOVEL))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_SAPPHIRE_SHOVEL));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_SAPPHIRE_SWORD, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_SAPPHIRE_SWORD)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_SAPPHIRE_SWORD),
                                                  conditionsFromItem(ModItems.HEAD_SAPPHIRE_SWORD))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_SAPPHIRE_SWORD));
                //endregion
                //region VANILLA HAMMERS
                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_DIAMOND_HAMMER, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_DIAMOND_HAMMER)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_DIAMOND_HAMMER),
                                                  conditionsFromItem(ModItems.HEAD_DIAMOND_HAMMER))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_DIAMOND_HAMMER));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_DIAMOND_EXCAVATOR, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_DIAMOND_EXCAVATOR)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_DIAMOND_EXCAVATOR),
                                                  conditionsFromItem(ModItems.HEAD_DIAMOND_EXCAVATOR))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_DIAMOND_EXCAVATOR));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_GOLD_HAMMER, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_GOLD_HAMMER)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_GOLD_HAMMER),
                                                  conditionsFromItem(ModItems.HEAD_GOLD_HAMMER))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_GOLD_HAMMER));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_GOLD_EXCAVATOR, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_GOLD_EXCAVATOR)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_GOLD_EXCAVATOR),
                                                  conditionsFromItem(ModItems.HEAD_GOLD_EXCAVATOR))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_GOLD_EXCAVATOR));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_IRON_HAMMER, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_IRON_HAMMER)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_IRON_HAMMER),
                                                  conditionsFromItem(ModItems.HEAD_IRON_HAMMER))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_IRON_HAMMER));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_IRON_EXCAVATOR, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_IRON_EXCAVATOR)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_IRON_EXCAVATOR),
                                                  conditionsFromItem(ModItems.HEAD_IRON_EXCAVATOR))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_IRON_EXCAVATOR));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_NETHERITE_HAMMER, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_NETHERITE_HAMMER)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_NETHERITE_HAMMER),
                                                  conditionsFromItem(ModItems.HEAD_NETHERITE_HAMMER))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_NETHERITE_HAMMER));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_NETHERITE_EXCAVATOR, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_NETHERITE_EXCAVATOR)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_NETHERITE_EXCAVATOR),
                                                  conditionsFromItem(ModItems.HEAD_NETHERITE_EXCAVATOR))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_NETHERITE_EXCAVATOR));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_STONE_HAMMER, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_STONE_HAMMER)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_STONE_HAMMER),
                                                  conditionsFromItem(ModItems.HEAD_STONE_HAMMER))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_STONE_HAMMER));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_STONE_EXCAVATOR, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_STONE_EXCAVATOR)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_STONE_EXCAVATOR),
                                                  conditionsFromItem(ModItems.HEAD_STONE_EXCAVATOR))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_STONE_EXCAVATOR));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_WOOD_HAMMER, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_WOOD_HAMMER)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_WOOD_HAMMER),
                                                  conditionsFromItem(ModItems.HEAD_WOOD_HAMMER))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_WOOD_HAMMER));

                createShaped(RecipeCategory.TOOLS, ModItems.TOOL_WOOD_EXCAVATOR, 1)
                                       .pattern("H")
                                       .pattern("B")
                                       .pattern("S")
                                       .input('B', ModItems.BINDING_STRING)
                                       .input('S', Items.STICK)
                                       .input('H', ModItems.HEAD_WOOD_EXCAVATOR)
                                       .criterion(hasItem(ModItems.BINDING_STRING),
                                                  conditionsFromItem(ModItems.BINDING_STRING))
                                       .criterion(hasItem(ModItems.HEAD_WOOD_EXCAVATOR),
                                                  conditionsFromItem(ModItems.HEAD_WOOD_EXCAVATOR))
                                       .offerTo(exporter, getRecipeName(ModItems.TOOL_WOOD_EXCAVATOR));
                //endregion
                //region AMETHYST ARMOR
                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_AMETHYST_HELMET, 1)
                                       .pattern("III")
                                       .pattern("IGI")
                                       .pattern("   ")
                                       .input('I', ModItems.REINFORCED_AMETHYST)
                                       .input('G', ModItems.GEAR_DIAMOND)
                                       .criterion(hasItem(ModItems.REINFORCED_AMETHYST), conditionsFromItem(ModItems.REINFORCED_AMETHYST))
                                       .criterion(hasItem(ModItems.GEAR_DIAMOND), conditionsFromItem(ModItems.GEAR_DIAMOND))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_AMETHYST_HELMET));

                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_AMETHYST_CHESTPLATE, 1)
                                       .pattern("IGI")
                                       .pattern("III")
                                       .pattern("III")
                                       .input('I', ModItems.REINFORCED_AMETHYST)
                                       .input('G', ModItems.GEAR_DIAMOND)
                                       .criterion(hasItem(ModItems.REINFORCED_AMETHYST), conditionsFromItem(ModItems.REINFORCED_AMETHYST))
                                       .criterion(hasItem(ModItems.GEAR_DIAMOND), conditionsFromItem(ModItems.GEAR_DIAMOND))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_AMETHYST_CHESTPLATE));

                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_AMETHYST_LEGGINGS, 1)
                                       .pattern("IGI")
                                       .pattern("I I")
                                       .pattern("I I")
                                       .input('I', ModItems.REINFORCED_AMETHYST)
                                       .input('G', ModItems.GEAR_DIAMOND)
                                       .criterion(hasItem(ModItems.REINFORCED_AMETHYST), conditionsFromItem(ModItems.REINFORCED_AMETHYST))
                                       .criterion(hasItem(ModItems.GEAR_DIAMOND), conditionsFromItem(ModItems.GEAR_DIAMOND))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_AMETHYST_LEGGINGS));

                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_AMETHYST_BOOTS, 1)
                                       .pattern("I I")
                                       .pattern("I I")
                                       .input('I', ModItems.REINFORCED_AMETHYST)
                                       .criterion(hasItem(ModItems.REINFORCED_AMETHYST), conditionsFromItem(ModItems.REINFORCED_AMETHYST))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_AMETHYST_BOOTS));
                //endregion
                //region CITRINE ARMOR
                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_CITRINE_HELMET, 1)
                                       .pattern("III")
                                       .pattern("IGI")
                                       .pattern("   ")
                                       .input('I', ModItems.REINFORCED_CITRINE)
                                       .input('G', ModItems.GEAR_GOLD)
                                       .criterion(hasItem(ModItems.REINFORCED_CITRINE), conditionsFromItem(ModItems.REINFORCED_CITRINE))
                                       .criterion(hasItem(ModItems.GEAR_GOLD), conditionsFromItem(ModItems.GEAR_GOLD))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_CITRINE_HELMET));

                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_CITRINE_CHESTPLATE, 1)
                                       .pattern("IGI")
                                       .pattern("III")
                                       .pattern("III")
                                       .input('I', ModItems.REINFORCED_CITRINE)
                                       .input('G', ModItems.GEAR_GOLD)
                                       .criterion(hasItem(ModItems.REINFORCED_CITRINE), conditionsFromItem(ModItems.REINFORCED_CITRINE))
                                       .criterion(hasItem(ModItems.GEAR_GOLD), conditionsFromItem(ModItems.GEAR_GOLD))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_CITRINE_CHESTPLATE));

                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_CITRINE_LEGGINGS, 1)
                                       .pattern("IGI")
                                       .pattern("I I")
                                       .pattern("I I")
                                       .input('I', ModItems.REINFORCED_CITRINE)
                                       .input('G', ModItems.GEAR_GOLD)
                                       .criterion(hasItem(ModItems.REINFORCED_CITRINE), conditionsFromItem(ModItems.REINFORCED_CITRINE))
                                       .criterion(hasItem(ModItems.GEAR_GOLD), conditionsFromItem(ModItems.GEAR_GOLD))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_CITRINE_LEGGINGS));

                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_CITRINE_BOOTS, 1)
                                       .pattern("I I")
                                       .pattern("I I")
                                       .input('I', ModItems.REINFORCED_CITRINE)
                                       .criterion(hasItem(ModItems.REINFORCED_CITRINE), conditionsFromItem(ModItems.REINFORCED_CITRINE))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_CITRINE_BOOTS));
                //endregion
                //region COPPER ARMOR
                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_COPPER_HELMET, 1)
                                       .pattern("III")
                                       .pattern("IGI")
                                       .pattern("   ")
                                       .input('I', ModItems.REINFORCED_COPPER)
                                       .input('G', ModItems.GEAR_COPPER)
                                       .criterion(hasItem(ModItems.REINFORCED_COPPER), conditionsFromItem(ModItems.REINFORCED_COPPER))
                                       .criterion(hasItem(ModItems.GEAR_COPPER), conditionsFromItem(ModItems.GEAR_COPPER))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_COPPER_HELMET));

                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_COPPER_CHESTPLATE, 1)
                                       .pattern("IGI")
                                       .pattern("III")
                                       .pattern("III")
                                       .input('I', ModItems.REINFORCED_COPPER)
                                       .input('G', ModItems.GEAR_COPPER)
                                       .criterion(hasItem(ModItems.REINFORCED_COPPER), conditionsFromItem(ModItems.REINFORCED_COPPER))
                                       .criterion(hasItem(ModItems.GEAR_COPPER), conditionsFromItem(ModItems.GEAR_COPPER))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_COPPER_CHESTPLATE));

                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_COPPER_LEGGINGS, 1)
                                       .pattern("IGI")
                                       .pattern("I I")
                                       .pattern("I I")
                                       .input('I', ModItems.REINFORCED_COPPER)
                                       .input('G', ModItems.GEAR_COPPER)
                                       .criterion(hasItem(ModItems.REINFORCED_COPPER), conditionsFromItem(ModItems.REINFORCED_COPPER))
                                       .criterion(hasItem(ModItems.GEAR_COPPER), conditionsFromItem(ModItems.GEAR_COPPER))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_COPPER_LEGGINGS));

                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_COPPER_BOOTS, 1)
                                       .pattern("I I")
                                       .pattern("I I")
                                       .input('I', ModItems.REINFORCED_COPPER)
                                       .criterion(hasItem(ModItems.REINFORCED_COPPER), conditionsFromItem(ModItems.REINFORCED_COPPER))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_COPPER_BOOTS));
                //endregion
                // region EMERALD ARMOR
                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_EMERALD_HELMET, 1)
                                       .pattern("III")
                                       .pattern("IGI")
                                       .pattern("   ")
                                       .input('I', ModItems.REINFORCED_EMERALD)
                                       .input('G', ModItems.GEAR_EMERALD)
                                       .criterion(hasItem(ModItems.REINFORCED_EMERALD), conditionsFromItem(ModItems.REINFORCED_EMERALD))
                                       .criterion(hasItem(ModItems.GEAR_EMERALD), conditionsFromItem(ModItems.GEAR_EMERALD))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_EMERALD_HELMET));

                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_EMERALD_CHESTPLATE, 1)
                                       .pattern("IGI")
                                       .pattern("III")
                                       .pattern("III")
                                       .input('I', ModItems.REINFORCED_EMERALD)
                                       .input('G', ModItems.GEAR_EMERALD)
                                       .criterion(hasItem(ModItems.REINFORCED_EMERALD), conditionsFromItem(ModItems.REINFORCED_EMERALD))
                                       .criterion(hasItem(ModItems.GEAR_EMERALD), conditionsFromItem(ModItems.GEAR_EMERALD))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_EMERALD_CHESTPLATE));

                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_EMERALD_LEGGINGS, 1)
                                       .pattern("IGI")
                                       .pattern("I I")
                                       .pattern("I I")
                                       .input('I', ModItems.REINFORCED_EMERALD)
                                       .input('G', ModItems.GEAR_EMERALD)
                                       .criterion(hasItem(ModItems.REINFORCED_EMERALD), conditionsFromItem(ModItems.REINFORCED_EMERALD))
                                       .criterion(hasItem(ModItems.GEAR_EMERALD), conditionsFromItem(ModItems.GEAR_EMERALD))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_EMERALD_LEGGINGS));

                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_EMERALD_BOOTS, 1)
                                       .pattern("I I")
                                       .pattern("I I")
                                       .input('I', ModItems.REINFORCED_EMERALD)
                                       .criterion(hasItem(ModItems.REINFORCED_EMERALD), conditionsFromItem(ModItems.REINFORCED_EMERALD))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_EMERALD_BOOTS));
                //endregion
                // region ENDERITE ARMOR
                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_ENDERITE_HELMET, 1)
                                       .pattern("III")
                                       .pattern("IGI")
                                       .pattern("   ")
                                       .input('I', ModItems.REINFORCED_ENDERITE)
                                       .input('G', ModItems.GEAR_ENDERITE)
                                       .criterion(hasItem(ModItems.REINFORCED_ENDERITE), conditionsFromItem(ModItems.REINFORCED_ENDERITE))
                                       .criterion(hasItem(ModItems.GEAR_ENDERITE), conditionsFromItem(ModItems.GEAR_ENDERITE))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_ENDERITE_HELMET));

                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_ENDERITE_CHESTPLATE, 1)
                                       .pattern("IGI")
                                       .pattern("III")
                                       .pattern("III")
                                       .input('I', ModItems.REINFORCED_ENDERITE)
                                       .input('G', ModItems.GEAR_ENDERITE)
                                       .criterion(hasItem(ModItems.REINFORCED_ENDERITE), conditionsFromItem(ModItems.REINFORCED_ENDERITE))
                                       .criterion(hasItem(ModItems.GEAR_ENDERITE), conditionsFromItem(ModItems.GEAR_ENDERITE))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_ENDERITE_CHESTPLATE));

                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_ENDERITE_LEGGINGS, 1)
                                       .pattern("IGI")
                                       .pattern("I I")
                                       .pattern("I I")
                                       .input('I', ModItems.REINFORCED_ENDERITE)
                                       .input('G', ModItems.GEAR_ENDERITE)
                                       .criterion(hasItem(ModItems.REINFORCED_ENDERITE), conditionsFromItem(ModItems.REINFORCED_ENDERITE))
                                       .criterion(hasItem(ModItems.GEAR_ENDERITE), conditionsFromItem(ModItems.GEAR_ENDERITE))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_ENDERITE_LEGGINGS));

                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_ENDERITE_BOOTS, 1)
                                       .pattern("I I")
                                       .pattern("I I")
                                       .input('I', ModItems.REINFORCED_ENDERITE)
                                       .criterion(hasItem(ModItems.REINFORCED_ENDERITE), conditionsFromItem(ModItems.REINFORCED_ENDERITE))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_ENDERITE_BOOTS));
                //endregion
                // region RUBY ARMOR
                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_RUBY_HELMET, 1)
                                       .pattern("III")
                                       .pattern("IGI")
                                       .pattern("   ")
                                       .input('I', ModItems.REINFORCED_RUBY)
                                       .input('G', ModItems.GEAR_RUBY)
                                       .criterion(hasItem(ModItems.REINFORCED_RUBY), conditionsFromItem(ModItems.REINFORCED_RUBY))
                                       .criterion(hasItem(ModItems.GEAR_RUBY), conditionsFromItem(ModItems.GEAR_RUBY))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_RUBY_HELMET));

                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_RUBY_CHESTPLATE, 1)
                                       .pattern("IGI")
                                       .pattern("III")
                                       .pattern("III")
                                       .input('I', ModItems.REINFORCED_RUBY)
                                       .input('G', ModItems.GEAR_RUBY)
                                       .criterion(hasItem(ModItems.REINFORCED_RUBY), conditionsFromItem(ModItems.REINFORCED_RUBY))
                                       .criterion(hasItem(ModItems.GEAR_RUBY), conditionsFromItem(ModItems.GEAR_RUBY))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_RUBY_CHESTPLATE));

                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_RUBY_LEGGINGS, 1)
                                       .pattern("IGI")
                                       .pattern("I I")
                                       .pattern("I I")
                                       .input('I', ModItems.REINFORCED_RUBY)
                                       .input('G', ModItems.GEAR_RUBY)
                                       .criterion(hasItem(ModItems.REINFORCED_RUBY), conditionsFromItem(ModItems.REINFORCED_RUBY))
                                       .criterion(hasItem(ModItems.GEAR_RUBY), conditionsFromItem(ModItems.GEAR_RUBY))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_RUBY_LEGGINGS));

                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_RUBY_BOOTS, 1)
                                       .pattern("I I")
                                       .pattern("I I")
                                       .input('I', ModItems.REINFORCED_RUBY)
                                       .criterion(hasItem(ModItems.REINFORCED_RUBY), conditionsFromItem(ModItems.REINFORCED_RUBY))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_RUBY_BOOTS));
                //endregion
                // region SAPPHIRE ARMOR
                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_SAPPHIRE_HELMET, 1)
                                       .pattern("III")
                                       .pattern("IGI")
                                       .pattern("   ")
                                       .input('I', ModItems.REINFORCED_SAPPHIRE)
                                       .input('G', ModItems.GEAR_SAPPHIRE)
                                       .criterion(hasItem(ModItems.REINFORCED_SAPPHIRE), conditionsFromItem(ModItems.REINFORCED_SAPPHIRE))
                                       .criterion(hasItem(ModItems.GEAR_SAPPHIRE), conditionsFromItem(ModItems.GEAR_SAPPHIRE))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_SAPPHIRE_HELMET));

                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_SAPPHIRE_CHESTPLATE, 1)
                                       .pattern("IGI")
                                       .pattern("III")
                                       .pattern("III")
                                       .input('I', ModItems.REINFORCED_SAPPHIRE)
                                       .input('G', ModItems.GEAR_SAPPHIRE)
                                       .criterion(hasItem(ModItems.REINFORCED_SAPPHIRE), conditionsFromItem(ModItems.REINFORCED_SAPPHIRE))
                                       .criterion(hasItem(ModItems.GEAR_SAPPHIRE), conditionsFromItem(ModItems.GEAR_SAPPHIRE))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_SAPPHIRE_CHESTPLATE));

                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_SAPPHIRE_LEGGINGS, 1)
                                       .pattern("IGI")
                                       .pattern("I I")
                                       .pattern("I I")
                                       .input('I', ModItems.REINFORCED_SAPPHIRE)
                                       .input('G', ModItems.GEAR_SAPPHIRE)
                                       .criterion(hasItem(ModItems.REINFORCED_SAPPHIRE), conditionsFromItem(ModItems.REINFORCED_SAPPHIRE))
                                       .criterion(hasItem(ModItems.GEAR_SAPPHIRE), conditionsFromItem(ModItems.GEAR_SAPPHIRE))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_SAPPHIRE_LEGGINGS));

                createShaped(RecipeCategory.COMBAT, ModItems.ARMOR_SAPPHIRE_BOOTS, 1)
                                       .pattern("I I")
                                       .pattern("I I")
                                       .input('I', ModItems.REINFORCED_SAPPHIRE)
                                       .criterion(hasItem(ModItems.REINFORCED_SAPPHIRE), conditionsFromItem(ModItems.REINFORCED_SAPPHIRE))
                                       .offerTo(exporter, getRecipeName(ModItems.ARMOR_SAPPHIRE_BOOTS));
                //endregion
                //TODO: We add  + "_shaped" to the end of the name for netherite armor because we are overriding vanilla recipe
                // The new way of registering shaped recipe will throw an exception if the name of the recipe is equal to vanilla!
                // Look into CraftingRecipeJsonBuilder line 33!
                // region NETHERITE ARMOR
                createShaped(RecipeCategory.COMBAT, Items.NETHERITE_HELMET, 1)
                                       .pattern("IRI")
                                       .pattern("I I")
                                       .pattern("   ")
                                       .input('I', ModItems.PLATE_NETHERITE)
                                       .input('R', ModItems.REINFORCED_NETHERITE)
                                       .criterion(hasItem(ModItems.PLATE_NETHERITE), conditionsFromItem(ModItems.PLATE_NETHERITE))
                                       .offerTo(exporter, getRecipeName(Items.NETHERITE_HELMET) + "_shaped");

                createShaped(RecipeCategory.COMBAT, Items.NETHERITE_CHESTPLATE, 1)
                                       .pattern("I I")
                                       .pattern("IRI")
                                       .pattern("IRI")
                                       .input('I', ModItems.PLATE_NETHERITE)
                                       .input('R', ModItems.REINFORCED_NETHERITE)
                                       .criterion(hasItem(ModItems.PLATE_NETHERITE), conditionsFromItem(ModItems.PLATE_NETHERITE))
                                       .offerTo(exporter, getRecipeName(Items.NETHERITE_CHESTPLATE) + "_shaped");

                createShaped(RecipeCategory.COMBAT, Items.NETHERITE_LEGGINGS, 1)
                                       .pattern("IRI")
                                       .pattern("I I")
                                       .pattern("I I")
                                       .input('I', ModItems.PLATE_NETHERITE)
                                       .input('R', ModItems.REINFORCED_NETHERITE)
                                       .criterion(hasItem(ModItems.PLATE_NETHERITE), conditionsFromItem(ModItems.PLATE_NETHERITE))
                                       .offerTo(exporter, getRecipeName(Items.NETHERITE_LEGGINGS) + "_shaped");

                createShaped(RecipeCategory.COMBAT, Items.NETHERITE_BOOTS, 1)
                                       .pattern("I I")
                                       .pattern("R R")
                                       .input('I', ModItems.PLATE_NETHERITE)
                                       .input('R', ModItems.REINFORCED_NETHERITE)
                                       .criterion(hasItem(ModItems.PLATE_NETHERITE), conditionsFromItem(ModItems.PLATE_NETHERITE))
                                       .offerTo(exporter, getRecipeName(Items.NETHERITE_BOOTS) + "_shaped");
                //endregion
                //region GOO
                createShaped(RecipeCategory.MISC, ModBlocks.BRIDGE_GOO, 1)
                                       .pattern("DED")
                                       .pattern("EWE")
                                       .pattern("DED")
                                       .input('E', Items.ENDER_PEARL)
                                       .input('W', ModItems.UNSTABLE_GOO)
                                       .input('D', Items.YELLOW_DYE)
                                       .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                                       .criterion(hasItem(ModItems.UNSTABLE_GOO), conditionsFromItem(ModItems.UNSTABLE_GOO))
                                       .criterion(hasItem(Items.YELLOW_DYE), conditionsFromItem(Items.YELLOW_DYE))
                                       .offerTo(exporter, getRecipeName(ModBlocks.BRIDGE_GOO));

                createShaped(RecipeCategory.MISC, ModBlocks.CHUNK_GOO, 1)
                                       .pattern("DED")
                                       .pattern("EWE")
                                       .pattern("DED")
                                       .input('E', Items.ENDER_PEARL)
                                       .input('W', ModItems.UNSTABLE_GOO)
                                       .input('D', Items.PINK_DYE)
                                       .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                                       .criterion(hasItem(ModItems.UNSTABLE_GOO), conditionsFromItem(ModItems.UNSTABLE_GOO))
                                       .criterion(hasItem(Items.PINK_DYE), conditionsFromItem(Items.PINK_DYE))
                                       .offerTo(exporter, getRecipeName(ModBlocks.CHUNK_GOO));

                createShaped(RecipeCategory.MISC, ModBlocks.LAVA_EATING_GOO, 1)
                                       .pattern("DED")
                                       .pattern("EWE")
                                       .pattern("DED")
                                       .input('E', Items.ENDER_PEARL)
                                       .input('W', ModItems.UNSTABLE_GOO)
                                       .input('D', Items.MAGENTA_DYE)
                                       .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                                       .criterion(hasItem(ModItems.UNSTABLE_GOO), conditionsFromItem(ModItems.UNSTABLE_GOO))
                                       .criterion(hasItem(Items.MAGENTA_DYE), conditionsFromItem(Items.MAGENTA_DYE))
                                       .offerTo(exporter, getRecipeName(ModBlocks.LAVA_EATING_GOO));

                createShaped(RecipeCategory.MISC, ModBlocks.LAVA_GENERATING_GOO, 1)
                                       .pattern("DED")
                                       .pattern("EWE")
                                       .pattern("DED")
                                       .input('E', Items.ENDER_PEARL)
                                       .input('W', ModItems.UNSTABLE_GOO)
                                       .input('D', Items.RED_DYE)
                                       .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                                       .criterion(hasItem(ModItems.UNSTABLE_GOO), conditionsFromItem(ModItems.UNSTABLE_GOO))
                                       .criterion(hasItem(Items.RED_DYE), conditionsFromItem(Items.RED_DYE))
                                       .offerTo(exporter, getRecipeName(ModBlocks.LAVA_GENERATING_GOO));

                createShaped(RecipeCategory.MISC, ModBlocks.TOWERING_GOO, 1)
                                       .pattern("DED")
                                       .pattern("EWE")
                                       .pattern("DED")
                                       .input('E', Items.ENDER_PEARL)
                                       .input('W', ModItems.UNSTABLE_GOO)
                                       .input('D', Items.PURPLE_DYE)
                                       .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                                       .criterion(hasItem(ModItems.UNSTABLE_GOO), conditionsFromItem(ModItems.UNSTABLE_GOO))
                                       .criterion(hasItem(Items.PURPLE_DYE), conditionsFromItem(Items.PURPLE_DYE))
                                       .offerTo(exporter, getRecipeName(ModBlocks.TOWERING_GOO));

                createShaped(RecipeCategory.MISC, ModBlocks.TUNNELING_GOO, 1)
                                       .pattern("DED")
                                       .pattern("EWE")
                                       .pattern("DED")
                                       .input('E', Items.ENDER_PEARL)
                                       .input('W', ModItems.UNSTABLE_GOO)
                                       .input('D', Items.CYAN_DYE)
                                       .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                                       .criterion(hasItem(ModItems.UNSTABLE_GOO), conditionsFromItem(ModItems.UNSTABLE_GOO))
                                       .criterion(hasItem(Items.CYAN_DYE), conditionsFromItem(Items.CYAN_DYE))
                                       .offerTo(exporter, getRecipeName(ModBlocks.TUNNELING_GOO));

                createShaped(RecipeCategory.MISC, ModBlocks.WATER_EATING_GOO, 1)
                                       .pattern("DED")
                                       .pattern("EWE")
                                       .pattern("DED")
                                       .input('E', Items.ENDER_PEARL)
                                       .input('W', ModItems.UNSTABLE_GOO)
                                       .input('D', Items.GRAY_DYE)
                                       .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                                       .criterion(hasItem(ModItems.UNSTABLE_GOO), conditionsFromItem(ModItems.UNSTABLE_GOO))
                                       .criterion(hasItem(Items.GRAY_DYE), conditionsFromItem(Items.GRAY_DYE))
                                       .offerTo(exporter, getRecipeName(ModBlocks.WATER_EATING_GOO));

                createShaped(RecipeCategory.MISC, ModBlocks.WATER_GENERATING_GOO, 1)
                                       .pattern("DED")
                                       .pattern("EWE")
                                       .pattern("DED")
                                       .input('E', Items.ENDER_PEARL)
                                       .input('W', ModItems.UNSTABLE_GOO)
                                       .input('D', Items.BLUE_DYE)
                                       .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                                       .criterion(hasItem(ModItems.UNSTABLE_GOO), conditionsFromItem(ModItems.UNSTABLE_GOO))
                                       .criterion(hasItem(Items.BLUE_DYE), conditionsFromItem(Items.BLUE_DYE))
                                       .offerTo(exporter, getRecipeName(ModBlocks.WATER_GENERATING_GOO));
                //endregion
                //region WOOD STRIPPER

                //endregion
                //region FOOD FUEL MISC
                offerSmelting(List.of(Items.EGG), RecipeCategory.FOOD, ModItems.COOKED_EGG, 0.15f, 100, "cooked_egg_smelting");
                offerFoodCookingRecipe("campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new,
                                       300, Items.EGG, ModItems.COOKED_EGG, 0.15F);

                createShapeless(RecipeCategory.FOOD, ModItems.EGG_AND_BREAD, 1)
                                          .input(ModItems.COOKED_EGG)
                                          .input(Items.BREAD)
                                          .criterion(hasItem(ModItems.COOKED_EGG), conditionsFromItem(ModItems.COOKED_EGG))
                                          .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
                                          .offerTo(exporter, getRecipeName(ModItems.EGG_AND_BREAD) + "_shapeless");

                createShaped(RecipeCategory.MISC, ModItems.HOT_COAL, 8)
                                       .pattern("CCC")
                                       .pattern("CBC")
                                       .pattern("CCC")
                                       .input('C', Items.COAL)
                                       .input('B', Items.LAVA_BUCKET)
                                       .criterion(hasItem(Items.COAL), conditionsFromItem(Items.COAL))
                                       .criterion(hasItem(Items.LAVA_BUCKET), conditionsFromItem(Items.LAVA_BUCKET))
                                       .offerTo(exporter, getRecipeName(ModItems.HOT_COAL));

                createShaped(RecipeCategory.MISC, ModItems.BLUEPRINT_EMPTY, 1)
                                       .pattern("RRR")
                                       .pattern("LLL")
                                       .pattern("PPP")
                                       .input('P', Items.PAPER)
                                       .input('L', Items.LAPIS_LAZULI)
                                       .input('R', Items.REDSTONE)
                                       .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                                       .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                                       .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                                       .offerTo(exporter, getRecipeName(ModItems.BLUEPRINT_EMPTY));

                createShaped(RecipeCategory.TOOLS, ModItems.ENDER_CHARM, 1)
                                       .pattern("EIE")
                                       .pattern("GIG")
                                       .pattern("IHI")
                                       .input('E', ModItems.ENDERMAN_EYE)
                                       .input('I', ModItems.INGOT_ENDERITE)
                                       .input('G', ModItems.ENDERMAN_GLAND)
                                       .input('H', ModItems.ENDERMAN_HEART)
                                       .criterion(hasItem(ModItems.ENDERMAN_EYE), conditionsFromItem(ModItems.ENDERMAN_EYE))
                                       .criterion(hasItem(ModItems.INGOT_ENDERITE), conditionsFromItem(ModItems.INGOT_ENDERITE))
                                       .criterion(hasItem(ModItems.ENDERMAN_GLAND), conditionsFromItem(ModItems.ENDERMAN_GLAND))
                                       .criterion(hasItem(ModItems.ENDERMAN_HEART), conditionsFromItem(ModItems.ENDERMAN_HEART))
                                       .offerTo(exporter, getRecipeName(ModItems.ENDER_CHARM));

                createShapeless(RecipeCategory.TOOLS, ModItems.VOID_PLATE, 1)
                                          .input(ModItems.VOID_PLATE_BASE)
                                          .input(ModItems.VOID_PLATE_ACTIVATOR)
                                          .criterion(hasItem(ModItems.VOID_PLATE_BASE), conditionsFromItem(ModItems.VOID_PLATE_BASE))
                                          .criterion(hasItem(ModItems.VOID_PLATE_ACTIVATOR), conditionsFromItem(ModItems.VOID_PLATE_ACTIVATOR))
                                          .offerTo(exporter, getRecipeName(ModItems.VOID_PLATE) + "_shapeless");

                createShaped(RecipeCategory.MISC, ModItems.ITEM_FILTER, 1)
                                       .pattern("   ")
                                       .pattern("RRR")
                                       .pattern("PPP")
                                       .input('R', Items.REDSTONE)
                                       .input('P', Items.PAPER)
                                       .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                                       .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                                       .offerTo(exporter, getRecipeName(ModItems.ITEM_FILTER));

                createShaped(RecipeCategory.MISC, ModItems.SLOT_DISABLED, 1)
                                       .pattern("   ")
                                       .pattern("RWR")
                                       .pattern("SSS")
                                       .input('R', Items.REDSTONE)
                                       .input('W', Items.LAPIS_LAZULI)
                                       .input('S', ModItems.PLATE_STONE)
                                       .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                                       .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                                       .criterion(hasItem(ModItems.PLATE_STONE), conditionsFromItem(ModItems.PLATE_STONE))
                                       .offerTo(exporter, getRecipeName(ModItems.SLOT_DISABLED));

                createShaped(RecipeCategory.MISC, ModItems.SLOT_ENABLED, 1)
                                       .pattern("   ")
                                       .pattern("RWR")
                                       .pattern("SSS")
                                       .input('R', Items.REDSTONE)
                                       .input('W', Items.EMERALD)
                                       .input('S', ModItems.PLATE_STONE)
                                       .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                                       .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                                       .criterion(hasItem(ModItems.PLATE_STONE), conditionsFromItem(ModItems.PLATE_STONE))
                                       .offerTo(exporter, getRecipeName(ModItems.SLOT_ENABLED));
                //endregion
                //region BLASTING
                offerBlasting(List.of(ModBlocks.ORE_END_ENDERITE_CRACKED), RecipeCategory.MISC, ModBlocks.ORE_ENDERITE, 7.0f, 7200, "ore_enderite");
                offerBlasting(List.of(ModItems.ENDER_CHARM), RecipeCategory.MISC, ModItems.VOID_PLATE_ACTIVATOR, 5.0f, 2400, "void_plate_activator");
                offerBlasting(List.of(ModBlocks.ENDERITE), RecipeCategory.MISC, ModItems.VOID_PLATE_BASE, 5.0f, 3600, "void_plate_base");
                offerBlasting(List.of(ModItems.COMBUSTION_CORE), RecipeCategory.MISC, ModItems.UNSTABLE_GOO, 2.0f, 2400, "unstable_goo");
                offerBlasting(List.of(ModItems.HOT_COAL), RecipeCategory.MISC, ModItems.COMBUSTION_CORE, 2.0f, 1200, "combustion_core");
                //offerBlasting(exporter, List.of(ModItems.), RecipeCategory.MISC, ModItems.RAW_RUBBER, 0.5f, 200, "rubber");
                //endregion
                //region RUBBER
                offerSmelting(List.of(ModItems.RAW_RUBBER), RecipeCategory.MISC, ModItems.RUBBER, 0.1f, 100, "rubber_smelting");
                offerFoodCookingRecipe("smoking", RecipeSerializer.SMOKING, SmokingRecipe::new,
                                       400, ModItems.RAW_RUBBER, ModItems.RUBBER, 0.1F);
                offerFoodCookingRecipe("campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new,
                                       2400, ModItems.RAW_RUBBER, ModItems.RUBBER, 0.1F);
                //endregion
                //region FOOD BOX
                offerReversibleCompactingRecipes(RecipeCategory.FOOD, Items.CARROT,
                                                 RecipeCategory.FOOD, ModBlocks.CARROT_BOX);
                offerReversibleCompactingRecipes(RecipeCategory.FOOD, Items.POTATO,
                                                 RecipeCategory.FOOD, ModBlocks.POTATO_BOX);
                //endregion

                //region MACHINES
                createShaped(RecipeCategory.MISC, ModItems.THERMAL_CORE, 1)
                                       .pattern("PPP")
                                       .pattern("HIH")
                                       .pattern("PPP")
                                       .input('I', ModItems.COMBUSTION_CORE)
                                       .input('H', ModItems.HOT_COAL)
                                       .input('P', ModItems.REINFORCED_IRON)
                                       .criterion(hasItem(ModItems.HOT_COAL), conditionsFromItem(ModItems.HOT_COAL))
                                       .criterion(hasItem(Blocks.IRON_BLOCK), conditionsFromItem(Blocks.IRON_BLOCK))
                                       .criterion(hasItem(ModItems.REINFORCED_IRON), conditionsFromItem(ModItems.REINFORCED_IRON))
                                       .offerTo(exporter, getRecipeName(ModItems.THERMAL_CORE));

                createShaped(RecipeCategory.MISC, ModBlocks.ELEVATOR, 1)
                                       .pattern(" E ")
                                       .pattern("EWE")
                                       .pattern(" E ")
                                       .input('E', Items.ENDER_PEARL)
                                       .input('W', ItemTags.WOOL)
                                       .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                                       .criterion("has_wool", conditionsFromTag(ItemTags.WOOL))
                                       .offerTo(exporter, getRecipeName(ModBlocks.ELEVATOR));

                createShapeless(RecipeCategory.TOOLS, ModBlocks.ANGEL, 1)
                                          .input(ItemTags.WOOL)
                                          .input(Items.ENDER_PEARL)
                                          .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                                          .criterion("has_wool", conditionsFromTag(ItemTags.WOOL))
                                          .offerTo(exporter, getRecipeName(ModBlocks.ANGEL) + "_shapeless");

                createShaped(RecipeCategory.MISC, ModBlocks.REDSTONE_CLOCK, 1)
                                       .pattern("EEE")
                                       .pattern("ECE")
                                       .pattern("ERE")
                                       .input('R', Blocks.REDSTONE_BLOCK)
                                       .input('E', ItemTags.WOOL)
                                       .input('C', Items.CLOCK)
                                       .criterion(hasItem(Items.CLOCK), conditionsFromItem(Items.CLOCK))
                                       .criterion(hasItem(Blocks.REDSTONE_BLOCK), conditionsFromItem(Blocks.REDSTONE_BLOCK))
                                       .criterion("has_wool", conditionsFromTag(ItemTags.WOOL))
                                       .offerTo(exporter, getRecipeName(ModBlocks.REDSTONE_CLOCK));

                // ALLOY_MIXER
                // CAST_PRESS
                // GEM_CLEANER
                // GENERATOR
                // OVEN
                // PULVERIZER
                // SMELTER
                // FLUID_PUMP
                // BLOCK_BREAKER
                // BLOCK_PLACER
                // WOOD_STRIPPER
                // ANIMAL_FEED
                // TESSERACT
                // Enderchanter
                // Project Table
                //endregion
                //region ALLOY SMELTER

                // Iron + Soul + Glass --> Pulsating --> Base Cable Alloy
                // Iron + Soul + Sand --> Pulsating --> Base Cable Alloy
                // Obsidian + Copper + Wither --> Conductive --> Fluid Cable
                // Gold + Citrine + Sapphire --> Energetic --> Energy Cable
                // Ruby + Redstone + Quartz --> Red Alloy --> Redstone Cable
                // Citrine + Enderite + Diamond --> Vibrant --> Item Cable

                //endregion
                //region PULVERIZER

                // Enderite --> Enderite Dust
                // Wither Bone --> Withering Dust
                // Soul Sand --> Soul Dust
                // Obsidian --> Obsidian Dust
                // Copper --> Copper Dust
                // Gold --> Gold Dust
                // Iron --> Iron Dust

                //endregion
                //region OVEN
                //TODO: Move alloy creation from blast furnace to the oven!
                offerBlasting(List.of(ModItems.RAW_ALLOY_ENDERITE), RecipeCategory.MISC, ModItems.INGOT_ALLOY_ENDERITE, 3.0f, 4800, "enderite_alloy");
                offerBlasting(List.of(ModItems.DUST_VIBRANT), RecipeCategory.MISC, ModItems.INGOT_ALLOY_VIBRANT, 3.0f, 4800, "vibrant_alloy");
                offerBlasting(List.of(ModItems.DUST_RED_ALLOY), RecipeCategory.MISC, ModItems.INGOT_ALLOY_RED, 3.0f, 4800, "red_alloy");
                offerBlasting(List.of(ModItems.DUST_PULSATING), RecipeCategory.MISC, ModItems.INGOT_ALLOY_PULSATING, 3.0f, 4800, "pulsating_alloy");
                offerBlasting(List.of(ModItems.DUST_ENERGETIC), RecipeCategory.MISC, ModItems.INGOT_ALLOY_ENERGETIC, 3.0f, 4800, "energetic_alloy");
                offerBlasting(List.of(ModItems.DUST_CONDUCTIVE), RecipeCategory.MISC, ModItems.INGOT_ALLOY_CONDUCTIVE, 3.0f, 4800, "conductive_alloy");
                //endregion
                //region GEM CLEANER
                // Raw Gem --> Gem
                // Wool --> Binding
                // String --> Binding
                //endregion
                //region SMELTERY

                // Ingot --> Liquid

                //endregion
            }
        };
    }
}