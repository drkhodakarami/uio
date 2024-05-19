package jiraiyah.uio.registry;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static jiraiyah.uio.Reference.identifier;
import static jiraiyah.uio.Reference.log;

public class ModRecipes
{
    public ModRecipes()
    {
        throw new AssertionError();
    }

    public static void register()
    {
        log("Registering Recipes");
    }

    private static void register(String name, RecipeSerializer<?> serializer)
    {
        Registry.register(Registries.RECIPE_SERIALIZER, identifier(name), serializer);
    }

    private static void register(String name, RecipeType<?> recipeType)
    {
        Registry.register(Registries.RECIPE_TYPE, identifier(name), recipeType);
    }
}