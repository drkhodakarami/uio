package jiraiyah.uio.registry;

import net.fabricmc.fabric.api.registry.FuelRegistry;

import static jiraiyah.uio.Reference.log;

public class ModRegistries
{
    public static void register()
    {
        registerFuels();
        registerModCompostables();
        registerCommands();
        registerEvents();
        registerPotionRecipes();
        registerCustomTrades();
        registerStrippables();
        registerFlammables();
        registerAttributes();
        registerOxidizables();
        createPortal();
    }

    private static void registerFuels()
    {
        log("Registering Fuel");
        FuelRegistry registry = FuelRegistry.INSTANCE;
    }

    private static void registerModCompostables()
    {
        log("Registering Compostables");
    }

    private static void registerCommands()
    {
        log("Registering Commands");
    }

    private static void registerEvents()
    {
        log("Registering Events");
    }

    private static void registerPotionRecipes()
    {
        log("Registering PotionRecipes");
    }

    private static void registerCustomTrades()
    {
        log("Registering Custom Trades");
    }

    private static void registerStrippables()
    {
        log("Registering Strippables");
    }

    private static void registerFlammables()
    {
        log("Registering Flammables");
    }

    private static void registerAttributes()
    {
        log("Registering Attributes");
    }

    private static void registerOxidizables()
    {
        log("Registering Oxidizables");
    }

    private static void createPortal()
    {
        log("Registering Custom Portals");
    }
}