package jiraiyah.uio;

import jiraiyah.uio.registry.*;
import jiraiyah.uio.registry.world.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import static jiraiyah.uio.Reference.logBackRGB256;

// This is the flat world gen custom preset I always use
// 5*minecraft:bedrock,30*minecraft:light_blue_wool,minecraft:light_blue_carpet;minecraft:plains;village

public class Main implements ModInitializer
{
    public static final boolean DEBUG = true;

    @Override
    public void onInitialize()
    {
        logBackRGB256("Initializing", 255, 255, 0, 255, 0, 127);

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

// Ideas for the mod :

//region BASIC

// SIMPLE
//===================
// TODO : Full Armor Effects : Sapphire --> Aqua Breath, Night Vision, Dolphin Grace
// TODO : Full Armor Effects : Ruby --> Fire Resistance, Blast Resistance, Ignorance !
// TODO : Full Armor Effects : Citrine --> Speed, Jump Boost, Feather Falling
// TODO : Full Armor Effects : Amethyst --> Night Vision, Haste, Invisibility
// TODO : Full Armor Effects : Emerald --> Luck, Hero Of the Village, Raid
// Full Armor Effects : Enderite --> Invisibility, Creative Flight, Night Vision
// Sapphire Sword Effect --> Knock Back
// Copper Sword Effect --> Weathering
// Citrine Sword Effect --> Slowness
// Cooked Egg and Breakfast
// Stylish Fences
// Shears
// Hot Coal
// Coal Block
// Ore Generation
// Enderite Ore Handling
// Game Rules
// Infinite Water Chalice
// Player Teleportation
// Entity Teleportation
// Grass Breaking Item
// Elevators
// Angle Block
// Blast Furnace is used for "Blasting"
// Detectors --> Spawner / Slime Chunk
// Mod Menu Badges Compatibility
// Configs (used for goo settings)
// Villager Trades

// Need Block Entity
//===================
// Goo for Chunk
// Goo for Water eat / generate
// Goo for Lava
// Goo for Tower
// Goo for Tunnel
// Goo for Bridge
// Block Breaker / Placer
// Fluid Pump
// Wood Stripper
// Animal Feed
// Project Table
// Redstone Lanterns
// Wrench Rotate Objects

//endregion

//region INTERMEDIATE

// SIMPLE
//===================
// Magnet
// XP Charm
// Measurement
// Enchants : Sonic Deflect
// Projectile : Fire Rune
// Projectile : Lightning Rune
// One Shot Kill Block
// Death Counter for Player
// HUD show Coordinates, Heading, Chunk Coordinates, Biomes, Clock, Day
// Using Cloth Config
// Molten Enderite Fluid
// Custom Villager

// Need Block Entity
//===================
// Cobble Gen
// Pulverizer
// Oven (Advanced Furnace)
// Gem Cleaner
// Cast Press
// Smelter
// Alloy Smelter
// Enchanting Book Print
// Energy Generators and Solar Panels
// Chargers and Batteries
// Machines Have Speed/Energy/Fluid Upgrades
// New Hoppers
// Hopper Speed
// Fluid Tank
// Advanced Recipes
// REI and Jade Compatibility

// Need Mixin
//===================
// Ruby Sword Effect
// Enderite Axe beheading Weather Skeleton
// Enderite Hoe Pickup Spawners
// Enderite Sword Gives More Ender Pearl
// Enderite Pickaxe breaks bedrock
// Enderite Shovel Pickup Amethyst Buds
// Functional Hammers
// Better Infinity and + Mending
// No Enderman Grief
// Shulker Drop Change
// Everything Stack More

// MISC
//===================
// Expanded Ender Chest
// Make Use of Runes!
// Sprinkler
// Add Trees and Corresponding Items ?! (Rubber Tree Maybe but rubber should be provided without tapping!)

//endregion

//region ADVANCE

// SIMPLE
//===================
// Item Filters
// Engineer Helmet show Slime Chunk Rendering
// Engineer Helmet show Spawn Chunk
// Engineer Helmet show Hit boxes
// Engineer Helmet show Village Info
// Engineer Helmet show Piston Info
// Chunk Loader Compass
// Backpack

// Need Block Entity
//===================
// Item Collector
// Tesseracts for transferring energy/liquid/item/redstone
// Cables for energy
// Cables for liquid
// Cables for item
// Cables for redstone
// Logic Gates
// Panels for item system
// Chunk Loader
// Shulker Boxes
// Building Printer

// Need Mixin
//===================
// Make Hoppers Use Item Filters
// Drop into Shulker
// Anti Creeper
// Invisibility Hide Armor
// Mobs Ignore Invisibility
// Warden Ignore If Enderite Full Armor

// MISC
//===================
// Flat Biomes for Mining
// Void Biomes for Farming
// Fake Player (Persistent for World)
// Machine Dimension (Space in a Block)
// Some Passive or Aggressive Entities
// Custom Buildings

//endregion