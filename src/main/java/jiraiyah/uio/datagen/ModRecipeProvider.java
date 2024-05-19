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
        createStairsRecipe(ModBlocks.CITRINE_STAIRS, Ingredient.ofItems(ModItems.GEM_CITRINE))
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
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SAPPHIRE_STAIRS)));
        //endregion

        //region SLABS
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CITRINE_SLAB, Ingredient.ofItems(ModItems.GEM_CITRINE))
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
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SAPPHIRE_SLAB)));
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
        createFenceRecipe(ModBlocks.CITRINE_FENCE, Ingredient.ofItems(ModItems.GEM_CITRINE))
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
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SAPPHIRE_FENCE)));
        //endregion

        //region FENCE GATE
        createFenceGateRecipe(ModBlocks.CITRINE_FENCE_GATE, Ingredient.ofItems(ModItems.GEM_CITRINE))
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
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SAPPHIRE_FENCE_GATE)));
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
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CITRINE_WALL, ModBlocks.CITRINE_FENCE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENDERITE_WALL, ModBlocks.ENDERITE_FENCE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_WALL, ModBlocks.RUBY_FENCE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_WALL, ModBlocks.SAPPHIRE_FENCE);
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
    }
}