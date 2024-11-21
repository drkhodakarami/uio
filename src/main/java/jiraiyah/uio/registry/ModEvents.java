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

import jiraiyah.uio.event.*;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;

import static jiraiyah.uio.Main.LOGGER;

/**
 * The {@code ModEvents} class serves as a central hub for registering
 * and managing various game events within the Minecraft mod framework.
 * Specifically designed for integration with the Fabric API, this class
 * facilitates the setup of event listeners that handle interactions related
 * to player actions, entity combat, and other gameplay mechanics.
 *
 * <p>This class is intentionally not instantiable, as it is designed to
 * be used statically for initialization purposes. All event registration is
 * performed within the static {@link #init()} method, ensuring that event
 * handlers are properly set up during the mod's initialization phase.</p>
 *
 * <p>By organizing event registration in this manner, the {@code ModEvents}
 * class contributes to cleaner code and enhances the maintainability of the mod.</p>
 */
public class ModEvents
{
    /**
     * Private constructor to prevent instantiation of the ModEvents class.
     * This class is designed to be a utility class and should not be instantiated.
     * An AssertionError is thrown if an attempt to instantiate this class is made.
     */
    ModEvents()
    {
        throw new AssertionError();
    }

    /**
     * Initializes the ModEvents class by registering event listeners for
     * various gameplay events within the Minecraft mod. This method is responsible
     * for setting up the necessary hooks into the Fabric API to handle player actions,
     * entity combat events, and other interactions in the game.
     *
     * <p>This method should be invoked during the initial setup phase of the mod
     * to ensure that all events are properly registered and the mod can respond
     * to player and entity actions as intended.</p>
     *
     * <p>Upon invocation, it logs a message indicating the start of the event
     * registration process.</p>
     *
     * @see PlayerBlockBreakEvents#BEFORE
     * @see ServerEntityCombatEvents#AFTER_KILLED_OTHER_ENTITY
     * @see UseEntityCallbackListener
     * @see ServerPlayerEquipChangeListener
     * @see LootTableModifiers
     */
    public static void init()
    {
        LOGGER.log("Registering Events");

        PlayerBlockBreakEvents.BEFORE.register(new BeforePlayerBlockBreakListener());
        ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register(new KillingEntityListener());

        UseEntityCallbackListener.register();
        ServerPlayerEquipChangeListener.register();
        LootTableModifiers.register();
    }
}