package jiraiyah.uio.datagen;

import jiraiyah.uio.registry.ModBlocks;
import jiraiyah.uio.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

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
    public void generate(RecipeExporter exporter)
    {
        logRGB256("Generating Recipe Data", 0, 255, 0);

        //region GEM BLOCKS
        offerReversibleCompactingRecipes(exporter,
                                         RecipeCategory.BUILDING_BLOCKS, ModItems.GEM_CITRINE,
                                         RecipeCategory.DECORATIONS, ModBlocks.CITRINE);
        offerReversibleCompactingRecipes(exporter,
                                         RecipeCategory.BUILDING_BLOCKS, ModItems.GEM_RUBY,
                                         RecipeCategory.DECORATIONS, ModBlocks.RUBY);
        offerReversibleCompactingRecipes(exporter,
                                         RecipeCategory.BUILDING_BLOCKS, ModItems.GEM_SAPPHIRE,
                                         RecipeCategory.DECORATIONS, ModBlocks.SAPPHIRE);

        offerReversibleCompactingRecipes(exporter,
                                         RecipeCategory.BUILDING_BLOCKS, ModItems.INGOT_ENDERITE,
                                         RecipeCategory.DECORATIONS, ModBlocks.ENDERITE);

        offerReversibleCompactingRecipes(exporter,
                                         RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_CITRINE,
                                         RecipeCategory.DECORATIONS, ModBlocks.RAW_CITRINE);

        offerReversibleCompactingRecipes(exporter,
                                         RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_ENDERITE,
                                         RecipeCategory.DECORATIONS, ModBlocks.RAW_ENDERITE);

        offerReversibleCompactingRecipes(exporter,
                                         RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_QUARTZ,
                                         RecipeCategory.DECORATIONS, ModBlocks.RAW_QUARTZ);

        offerReversibleCompactingRecipes(exporter,
                                         RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_RUBY,
                                         RecipeCategory.DECORATIONS, ModBlocks.RAW_RUBY);

        offerReversibleCompactingRecipes(exporter,
                                         RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_SAPPHIRE,
                                         RecipeCategory.DECORATIONS, ModBlocks.RAW_SAPPHIRE);
        //endregion

        //region LEATHER
        offerFoodCookingRecipe(exporter,
                               "smoking", RecipeSerializer.SMOKING, SmokingRecipe::new,
                               400, Items.ROTTEN_FLESH, Items.LEATHER, 0.1F);
        offerFoodCookingRecipe(exporter,
                               "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new,
                               2400, Items.ROTTEN_FLESH, Items.LEATHER, 0.1F);
        //endregion

        //region MAIN TOOLS
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_PLAYER_TELEPORT, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_PLAYER_TELEPORT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_TUNER, 1)
                               .pattern("P P")
                               .pattern("IEI")
                               .pattern(" I ")
                               .input('P', Items.ENDER_PEARL)
                               .input('E', Items.ENDER_EYE)
                               .input('I', ModItems.ROD_IRON)
                               .criterion(hasItem(Items.ENDER_EYE), conditionsFromItem(Items.ENDER_EYE))
                               .criterion(hasItem(Items.ENDER_PEARL), conditionsFromItem(Items.ENDER_PEARL))
                               .criterion(hasItem(ModItems.ROD_IRON), conditionsFromItem(ModItems.ROD_IRON))
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_TUNER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_WRENCH, 1)
                               .pattern("O O")
                               .pattern(" O ")
                               .pattern(" I ")
                               .input('O', ModItems.ROD_OBSIDIAN)
                               .input('I', ModItems.ROD_IRON)
                               .criterion(hasItem(ModItems.ROD_IRON), conditionsFromItem(ModItems.ROD_IRON))
                               .criterion(hasItem(ModItems.ROD_OBSIDIAN), conditionsFromItem(ModItems.ROD_OBSIDIAN))
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_WRENCH)));
        //endregion

        //region VANILLA
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.NAME_TAG, 1)
                                  .input(Items.PAPER)
                                  .input(ModItems.ROD_IRON)
                                  .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                                  .criterion(hasItem(ModItems.ROD_IRON), conditionsFromItem(ModItems.ROD_IRON))
                                  .offerTo(exporter, new Identifier(getRecipeName(Items.NAME_TAG) + "_shapeless"));
        //endregion

        //region STAIRS
        /*createStairsRecipe(ModBlocks.CITRINE_STAIRS, Ingredient.ofItems(ModItems.GEM_CITRINE))
                .criterion(hasItem(ModItems.GEM_CITRINE), conditionsFromItem(ModItems.GEM_CITRINE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.CITRINE_STAIRS)));
        createStairsRecipe(ModBlocks.ENDERITE_STAIRS, Ingredient.ofItems(ModItems.INGOT_ENDERITE))
                .criterion(hasItem(ModItems.INGOT_ENDERITE), conditionsFromItem(ModItems.INGOT_ENDERITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ENDERITE_STAIRS)));
        createStairsRecipe(ModBlocks.RUBY_STAIRS, Ingredient.ofItems(ModItems.GEM_RUBY))
                .criterion(hasItem(ModItems.GEM_RUBY), conditionsFromItem(ModItems.GEM_RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_STAIRS)));
        createStairsRecipe(ModBlocks.SAPPHIRE_STAIRS, Ingredient.ofItems(ModItems.GEM_SAPPHIRE))
                .criterion(hasItem(ModItems.GEM_SAPPHIRE), conditionsFromItem(ModItems.GEM_SAPPHIRE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SAPPHIRE_STAIRS)));*/

        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.CITRINE_STAIRS, ModBlocks.CITRINE, 9);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.ENDERITE_STAIRS, ModBlocks.ENDERITE, 9);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.RUBY_STAIRS, ModBlocks.RUBY, 9);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.SAPPHIRE_STAIRS, ModBlocks.SAPPHIRE, 9);
        //endregion

        //region SLABS
        /*createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CITRINE_SLAB, Ingredient.ofItems(ModItems.GEM_CITRINE))
                .criterion(hasItem(ModItems.GEM_CITRINE), conditionsFromItem(ModItems.GEM_CITRINE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.CITRINE_SLAB)));
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENDERITE_SLAB, Ingredient.ofItems(ModItems.INGOT_ENDERITE))
                .criterion(hasItem(ModItems.INGOT_ENDERITE), conditionsFromItem(ModItems.INGOT_ENDERITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ENDERITE_SLAB)));
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_SLAB, Ingredient.ofItems(ModItems.GEM_RUBY))
                .criterion(hasItem(ModItems.GEM_RUBY), conditionsFromItem(ModItems.GEM_RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_SLAB)));
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_SLAB, Ingredient.ofItems(ModItems.GEM_SAPPHIRE))
                .criterion(hasItem(ModItems.GEM_SAPPHIRE), conditionsFromItem(ModItems.GEM_SAPPHIRE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SAPPHIRE_SLAB)));*/

        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.CITRINE_SLAB, ModBlocks.CITRINE, 18);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.ENDERITE_SLAB, ModItems.INGOT_ENDERITE, 18);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.RUBY_SLAB, ModItems.GEM_RUBY, 18);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.SAPPHIRE_SLAB, ModItems.GEM_SAPPHIRE, 18);
        //endregion

        //region PRESSURE PLATE
        createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.CITRINE_PRESSURE_PLATE, Ingredient.ofItems(ModItems.GEM_CITRINE))
                .criterion(hasItem(ModItems.GEM_CITRINE), conditionsFromItem(ModItems.GEM_CITRINE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.CITRINE_PRESSURE_PLATE)));
        createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.ENDERITE_PRESSURE_PLATE, Ingredient.ofItems(ModItems.INGOT_ENDERITE))
                .criterion(hasItem(ModItems.INGOT_ENDERITE), conditionsFromItem(ModItems.INGOT_ENDERITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ENDERITE_PRESSURE_PLATE)));
        createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.RUBY_PRESSURE_PLATE, Ingredient.ofItems(ModItems.GEM_RUBY))
                .criterion(hasItem(ModItems.GEM_RUBY), conditionsFromItem(ModItems.GEM_RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_PRESSURE_PLATE)));
        createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.SAPPHIRE_PRESSURE_PLATE, Ingredient.ofItems(ModItems.GEM_SAPPHIRE))
                .criterion(hasItem(ModItems.GEM_SAPPHIRE), conditionsFromItem(ModItems.GEM_SAPPHIRE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SAPPHIRE_PRESSURE_PLATE)));
        //endregion

        //region FENCE
        /*createFenceRecipe(ModBlocks.CITRINE_FENCE, Ingredient.ofItems(ModItems.GEM_CITRINE))
                .criterion(hasItem(ModItems.GEM_CITRINE), conditionsFromItem(ModItems.GEM_CITRINE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.CITRINE_FENCE)));
        createFenceRecipe(ModBlocks.ENDERITE_FENCE, Ingredient.ofItems(ModItems.INGOT_ENDERITE))
                .criterion(hasItem(ModItems.INGOT_ENDERITE), conditionsFromItem(ModItems.INGOT_ENDERITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ENDERITE_FENCE)));
        createFenceRecipe(ModBlocks.RUBY_FENCE, Ingredient.ofItems(ModItems.GEM_RUBY))
                .criterion(hasItem(ModItems.GEM_RUBY), conditionsFromItem(ModItems.GEM_RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_FENCE)));
        createFenceRecipe(ModBlocks.SAPPHIRE_FENCE, Ingredient.ofItems(ModItems.GEM_SAPPHIRE))
                .criterion(hasItem(ModItems.GEM_SAPPHIRE), conditionsFromItem(ModItems.GEM_SAPPHIRE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SAPPHIRE_FENCE)));*/

        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.CITRINE_FENCE, ModBlocks.CITRINE, 9);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.ENDERITE_FENCE, ModItems.INGOT_ENDERITE, 9);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.RUBY_FENCE, ModItems.GEM_RUBY, 9);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.SAPPHIRE_FENCE, ModItems.GEM_SAPPHIRE, 9);
        //endregion

        //region FENCE GATE
        /*createFenceGateRecipe(ModBlocks.CITRINE_FENCE_GATE, Ingredient.ofItems(ModItems.GEM_CITRINE))
                .criterion(hasItem(ModItems.GEM_CITRINE), conditionsFromItem(ModItems.GEM_CITRINE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.CITRINE_FENCE_GATE)));
        createFenceGateRecipe(ModBlocks.ENDERITE_FENCE_GATE, Ingredient.ofItems(ModItems.INGOT_ENDERITE))
                .criterion(hasItem(ModItems.INGOT_ENDERITE), conditionsFromItem(ModItems.INGOT_ENDERITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ENDERITE_FENCE_GATE)));
        createFenceGateRecipe(ModBlocks.RUBY_FENCE_GATE, Ingredient.ofItems(ModItems.GEM_RUBY))
                .criterion(hasItem(ModItems.GEM_RUBY), conditionsFromItem(ModItems.GEM_RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_FENCE_GATE)));
        createFenceGateRecipe(ModBlocks.SAPPHIRE_FENCE_GATE, Ingredient.ofItems(ModItems.GEM_SAPPHIRE))
                .criterion(hasItem(ModItems.GEM_SAPPHIRE), conditionsFromItem(ModItems.GEM_SAPPHIRE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SAPPHIRE_FENCE_GATE)));*/

        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.CITRINE_FENCE_GATE, ModBlocks.CITRINE, 9);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.ENDERITE_FENCE_GATE, ModItems.INGOT_ENDERITE, 9);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.RUBY_FENCE_GATE, ModItems.GEM_RUBY, 9);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.SAPPHIRE_FENCE_GATE, ModItems.GEM_SAPPHIRE, 9);
        //endregion

        //region DOOR
        createDoorRecipe(ModBlocks.CITRINE_DOOR, Ingredient.ofItems(ModItems.GEM_CITRINE))
                .criterion(hasItem(ModItems.GEM_CITRINE), conditionsFromItem(ModItems.GEM_CITRINE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.CITRINE_DOOR)));
        createDoorRecipe(ModBlocks.ENDERITE_DOOR, Ingredient.ofItems(ModItems.INGOT_ENDERITE))
                .criterion(hasItem(ModItems.INGOT_ENDERITE), conditionsFromItem(ModItems.INGOT_ENDERITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ENDERITE_DOOR)));
        createDoorRecipe(ModBlocks.RUBY_DOOR, Ingredient.ofItems(ModItems.GEM_RUBY))
                .criterion(hasItem(ModItems.GEM_RUBY), conditionsFromItem(ModItems.GEM_RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_DOOR)));
        createDoorRecipe(ModBlocks.SAPPHIRE_DOOR, Ingredient.ofItems(ModItems.GEM_SAPPHIRE))
                .criterion(hasItem(ModItems.GEM_SAPPHIRE), conditionsFromItem(ModItems.GEM_SAPPHIRE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SAPPHIRE_DOOR)));
        //endregion

        //region TRAP DOOR
        createTrapdoorRecipe(ModBlocks.CITRINE_TRAP_DOOR, Ingredient.ofItems(ModItems.GEM_CITRINE))
                .criterion(hasItem(ModItems.GEM_CITRINE), conditionsFromItem(ModItems.GEM_CITRINE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.CITRINE_TRAP_DOOR)));
        createTrapdoorRecipe(ModBlocks.ENDERITE_TRAP_DOOR, Ingredient.ofItems(ModItems.INGOT_ENDERITE))
                .criterion(hasItem(ModItems.INGOT_ENDERITE), conditionsFromItem(ModItems.INGOT_ENDERITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ENDERITE_TRAP_DOOR)));
        createTrapdoorRecipe(ModBlocks.RUBY_TRAP_DOOR, Ingredient.ofItems(ModItems.GEM_RUBY))
                .criterion(hasItem(ModItems.GEM_RUBY), conditionsFromItem(ModItems.GEM_RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_TRAP_DOOR)));
        createTrapdoorRecipe(ModBlocks.SAPPHIRE_TRAP_DOOR, Ingredient.ofItems(ModItems.GEM_SAPPHIRE))
                .criterion(hasItem(ModItems.GEM_SAPPHIRE), conditionsFromItem(ModItems.GEM_SAPPHIRE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SAPPHIRE_TRAP_DOOR)));
        //endregion

        //region WALL
        /*offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CITRINE_WALL, ModBlocks.CITRINE_FENCE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENDERITE_WALL, ModBlocks.ENDERITE_FENCE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_WALL, ModBlocks.RUBY_FENCE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_WALL, ModBlocks.SAPPHIRE_FENCE);*/

        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.CITRINE_WALL, ModBlocks.CITRINE, 9);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.ENDERITE_WALL, ModBlocks.ENDERITE, 9);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.RUBY_WALL, ModBlocks.RUBY, 9);
        offerStonecuttingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.SAPPHIRE_WALL, ModBlocks.SAPPHIRE, 9);
        //endregion

        //region BUTTON
        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.CITRINE_BUTTON, 1)
                                  .input(ModItems.GEM_CITRINE)
                                  .criterion(hasItem(ModItems.GEM_CITRINE), conditionsFromItem(ModItems.GEM_CITRINE))
                                  .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.CITRINE_BUTTON) + "_shapeless"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.ENDERITE_BUTTON, 1)
                                  .input(ModItems.INGOT_ENDERITE)
                                  .criterion(hasItem(ModItems.INGOT_ENDERITE), conditionsFromItem(ModItems.INGOT_ENDERITE))
                                  .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ENDERITE_BUTTON) + "_shapeless"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.RUBY_BUTTON, 1)
                                  .input(ModItems.GEM_RUBY)
                                  .criterion(hasItem(ModItems.GEM_RUBY), conditionsFromItem(ModItems.GEM_RUBY))
                                  .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RUBY_BUTTON) + "_shapeless"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.SAPPHIRE_BUTTON, 1)
                                  .input(ModItems.GEM_SAPPHIRE)
                                  .criterion(hasItem(ModItems.GEM_SAPPHIRE), conditionsFromItem(ModItems.GEM_SAPPHIRE))
                                  .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SAPPHIRE_BUTTON) + "_shapeless"));
        //endregion

        //region CITRINE TOOLS
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_CITRINE_AXE, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_CITRINE_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_CITRINE_HAMMER, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_CITRINE_HAMMER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_CITRINE_HOE, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_CITRINE_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_CITRINE_PICKAXE, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_CITRINE_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_CITRINE_SHOVEL, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_CITRINE_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_CITRINE_SWORD, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_CITRINE_SWORD)));
        //endregion

        //region COPPER TOOLS
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_COPPER_AXE, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_COPPER_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_COPPER_HAMMER, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_COPPER_HAMMER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_COPPER_HOE, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_COPPER_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_COPPER_PICKAXE, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_COPPER_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_COPPER_SHOVEL, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_COPPER_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_COPPER_SWORD, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_COPPER_SWORD)));
        //endregion

        //region ENDERITE TOOLS
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_ENDERITE_AXE, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_ENDERITE_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_ENDERITE_HAMMER, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_ENDERITE_HAMMER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_ENDERITE_HOE, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_ENDERITE_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_ENDERITE_PICKAXE, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_ENDERITE_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_ENDERITE_SHOVEL, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_ENDERITE_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_ENDERITE_SWORD, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_ENDERITE_SWORD)));
        //endregion

        //region RUBY TOOLS
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_RUBY_AXE, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_RUBY_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_RUBY_HAMMER, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_RUBY_HAMMER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_RUBY_HOE, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_RUBY_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_RUBY_PICKAXE, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_RUBY_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_RUBY_SHOVEL, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_RUBY_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_RUBY_SWORD, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_RUBY_SWORD)));
        //endregion

        //region SAPPHIRE TOOLS
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_SAPPHIRE_AXE, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_SAPPHIRE_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_SAPPHIRE_HAMMER, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_SAPPHIRE_HAMMER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_SAPPHIRE_HOE, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_SAPPHIRE_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_SAPPHIRE_PICKAXE, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_SAPPHIRE_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_SAPPHIRE_SHOVEL, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_SAPPHIRE_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_SAPPHIRE_SWORD, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_SAPPHIRE_SWORD)));
        //endregion

        //region VANILLA HAMMERS
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_DIAMOND_HAMMER, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_DIAMOND_HAMMER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_GOLD_HAMMER, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_GOLD_HAMMER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_IRON_HAMMER, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_IRON_HAMMER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_NETHERITE_HAMMER, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_NETHERITE_HAMMER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_STONE_HAMMER, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_STONE_HAMMER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOOL_WOOD_HAMMER, 1)
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
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.TOOL_WOOD_HAMMER)));
        //endregion

        //region AMETHYST ARMOR
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ARMOR_AMETHYST_HELMET, 1)
                               .pattern("III")
                               .pattern("IGI")
                               .pattern("   ")
                               .input('I', ModItems.REINFORCED_AMETHYST)
                               .input('G', ModItems.GEAR_DIAMOND)
                               .criterion(hasItem(ModItems.REINFORCED_AMETHYST), conditionsFromItem(ModItems.REINFORCED_AMETHYST))
                               .criterion(hasItem(ModItems.GEAR_DIAMOND), conditionsFromItem(ModItems.GEAR_DIAMOND))
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.ARMOR_AMETHYST_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ARMOR_AMETHYST_CHESTPLATE, 1)
                               .pattern("IGI")
                               .pattern("III")
                               .pattern("III")
                               .input('I', ModItems.REINFORCED_AMETHYST)
                               .input('G', ModItems.GEAR_DIAMOND)
                               .criterion(hasItem(ModItems.REINFORCED_AMETHYST), conditionsFromItem(ModItems.REINFORCED_AMETHYST))
                               .criterion(hasItem(ModItems.GEAR_DIAMOND), conditionsFromItem(ModItems.GEAR_DIAMOND))
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.ARMOR_AMETHYST_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ARMOR_AMETHYST_LEGGINGS, 1)
                               .pattern("IGI")
                               .pattern("I I")
                               .pattern("I I")
                               .input('I', ModItems.REINFORCED_AMETHYST)
                               .input('G', ModItems.GEAR_DIAMOND)
                               .criterion(hasItem(ModItems.REINFORCED_AMETHYST), conditionsFromItem(ModItems.REINFORCED_AMETHYST))
                               .criterion(hasItem(ModItems.GEAR_DIAMOND), conditionsFromItem(ModItems.GEAR_DIAMOND))
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.ARMOR_AMETHYST_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ARMOR_AMETHYST_BOOTS, 1)
                               .pattern("I I")
                               .pattern("I I")
                               .input('I', ModItems.REINFORCED_AMETHYST)
                               .criterion(hasItem(ModItems.REINFORCED_AMETHYST), conditionsFromItem(ModItems.REINFORCED_AMETHYST))
                               .offerTo(exporter, new Identifier(getRecipeName(ModItems.ARMOR_AMETHYST_BOOTS)));
        //endregion

        offerBlasting(exporter, List.of(ModBlocks.ORE_END_ENDERITE_CRACKED), RecipeCategory.MISC, ModBlocks.ORE_ENDERITE, 5.0f, 1200, "ore_enderite");
    }
}