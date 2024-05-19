package jiraiyah.uio.compat.rei;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;

public class ModREIClientPlugin implements REIClientPlugin
{
    @Override
    public void registerCategories(CategoryRegistry registry)
    {
        //TODO : Register categories and workstations here

        REIClientPlugin.super.registerCategories(registry);
    }

    @Override
    public void registerDisplays(DisplayRegistry registry)
    {
        //TODO : Register displays here

        REIClientPlugin.super.registerDisplays(registry);
    }

    @Override
    public void registerScreens(ScreenRegistry registry)
    {
        //TODO : Register screens here

        REIClientPlugin.super.registerScreens(registry);
    }
}
