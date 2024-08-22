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

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

import static jiraiyah.uio.Reference.log;

public class ModRegistries
{
    public static void register()
    {
        registerFuels();
        registerModCompostables();
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

        registry.add(ModItems.HOT_COAL, 6400);
    }

    private static void registerModCompostables()
    {
        log("Registering Compostables");
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