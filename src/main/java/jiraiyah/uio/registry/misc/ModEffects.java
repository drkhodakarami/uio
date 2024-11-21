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

package jiraiyah.uio.registry.misc;

import jiraiyah.uio.effect.FlightEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.entry.RegistryEntry;

import static jiraiyah.jiregister.Registers.StatusEffect.register;
import static jiraiyah.uio.Main.LOGGER;

/**
 * The `ModEffects` class is responsible for registering custom status effects
 * within the mod. It utilizes the Minecraft registry system to ensure that
 * effects are properly registered and available for use in the game.
 * <p>
 * This class is not intended to be instantiated, as it serves a static utility
 * role within the mod's architecture.
 */
public class ModEffects
{
    /**
     * Private constructor to prevent instantiation of the `ModEffects` class.
     * <p>
     * This constructor throws an `AssertionError` if called, as the class is
     * designed to be used in a static context only.
     */
    ModEffects()
    {
        throw new AssertionError();
    }


    public static RegistryEntry<StatusEffect> FLIGHT_EFFECT;

    /**
     * Initializes and registers the custom status effects for the mod.
     * <p>
     * This method logs the registration process and registers the `FlightEffect`
     * with the Minecraft registry system, associating it with a unique identifier.
     * The effect is categorized as beneficial and is assigned a default color.
     */
    public static void init()
    {
        LOGGER.log("Registering Effects");

        FLIGHT_EFFECT = register("flight", StatusEffectCategory.BENEFICIAL, 0xFFFFFF, FlightEffect::new);
    }
}