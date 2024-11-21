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

import jiraiyah.jiregister.Registers;
import jiraiyah.uio.item.blockitem.AngelBlockItem;
import net.minecraft.item.BlockItem;

import static jiraiyah.jiregister.Registers.BlockItem.register;
import static jiraiyah.uio.Main.LOGGER;

/**
 * The {@code ModBlockItems} class is responsible for defining and registering
 * various block item instances in the Minecraft mod. This class contains
 * a list of static references to block items, which can be accessed
 * without the need for instantiation, as the constructor throws an
 * {@link AssertionError} to prevent object creation.
 *
 * <p>
 * This class ensures that all block items are registered in a centralized
 * manner, allowing easy access throughout the mod. The block items may
 * include, but are not limited to, various resource items, decorative
 * items, and functional blocks.
 * </p>
 *
 * <p>
 * Usage of this class is intended to be static; hence, instances of
 * {@code ModBlockItems} should not be created.
 * </p>
 *
 * <h2>Example Usage:</h2>
 * <pre>
 * ModBlockItems.init(); // Initializes and registers all block items
 * </pre>
 *
 * @see <a href="https://www.minecraft.net/">Minecraft</a>
 * @see Registers
 * @see BlockItem
 * @since 1.0
 */
public class ModBlockItems
{
    public static BlockItem ANGEL, ENDERITE, CARROT_BOX, POTATO_BOX,
            CITRINE, RUBY, SAPPHIRE, RAW_CITRINE, RAW_ENDERITE, RAW_QUARTZ, RAW_RUBY, RAW_SAPPHIRE,
            CITRINE_STAIRS, ENDERITE_STAIRS, RUBY_STAIRS, SAPPHIRE_STAIRS,
            CITRINE_SLAB, ENDERITE_SLAB, RUBY_SLAB, SAPPHIRE_SLAB,
            CITRINE_BUTTON, ENDERITE_BUTTON, RUBY_BUTTON, SAPPHIRE_BUTTON,
            CITRINE_PRESSURE_PLATE, ENDERITE_PRESSURE_PLATE, RUBY_PRESSURE_PLATE, SAPPHIRE_PRESSURE_PLATE,
            CITRINE_FENCE, ENDERITE_FENCE, RUBY_FENCE, SAPPHIRE_FENCE,
            CITRINE_FENCE_GATE, ENDERITE_FENCE_GATE, RUBY_FENCE_GATE, SAPPHIRE_FENCE_GATE,
            CITRINE_WALL, ENDERITE_WALL, RUBY_WALL, SAPPHIRE_WALL,
            CITRINE_DOOR, ENDERITE_DOOR, RUBY_DOOR, SAPPHIRE_DOOR,
            CITRINE_TRAP_DOOR, ENDERITE_TRAP_DOOR, RUBY_TRAP_DOOR, SAPPHIRE_TRAP_DOOR,
            ORE_DEEP_CITRINE, ORE_DEEP_RUBY, ORE_DEEP_SAPPHIRE,
            ORE_END_CITRINE, ORE_END_ENDERITE, ORE_END_ENDERITE_CRACKED, ORE_END_RUBY, ORE_END_SAPPHIRE,
            ORE_NETHER_CITRINE, ORE_NETHER_RUBY, ORE_NETHER_SAPPHIRE, ORE_NETHER_COAL, ORE_NETHER_COPPER, ORE_NETHER_DIAMOND,
            ORE_NETHER_IRON, ORE_NETHER_LAPIS, ORE_NETHER_REDSTONE,
            ORE_WORLD_CITRINE, ORE_WORLD_RUBY, ORE_WORLD_SAPPHIRE,
            ORE_ENDERITE,
            WATER_EATING_GOO, WATER_GENERATING_GOO, LAVA_EATING_GOO, LAVA_GENERATING_GOO, CHUNK_GOO, TOWERING_GOO,
            TUNNELING_GOO, BRIDGE_GOO, AIR_BOMB_GOO, CHUNK_BOMB_GOO, LAVA_PUMP_GOO, STONE_BOMB_GOO, WATER_PUMP_GOO,
            ELEVATOR, REDSTONE_CLOCK, ALLOY_MIXER, CAST_PRESS, GEM_CLEANER, OVEN, PULVERIZER, SMELTER, ANIMAL_FEED,
            GENERATOR, BLOCK_BREAKER, BLOCK_PLACER, BUILDER, CHUNK_LOADER, CREATIVE_BANK, ENDER_CHANTER, FLUID_PUMP,
            PRINTER, PROJECT_TABLE, TESSERACT, WOOD_STRIPPER, BATTERY_BANK, SOLAR_PANEL, MINER;

    /**
     * Constructs a new instance of {@code ModBlockItems}.
     *
     * <p>
     * This constructor is private and throws an {@link AssertionError} to prevent
     * instantiation of this class, as it is intended to be used solely as a static
     * holder for block item definitions.
     * </p>
     *
     * <p>
     * Users should not attempt to create an instance of this class.
     * </p>
     *
     * @throws AssertionError if invoked, indicating that instantiation is not allowed.
     */
    public ModBlockItems()
    {
        throw new AssertionError();
    }

    /**
     * Initializes and registers all block items defined in this class.
     *
     * <p>
     * This method is responsible for registering block items with the
     * Minecraft item registry. It logs the registration process and
     * associates each block with its corresponding item representation.
     * Block items are referenced using static variables declared in this class.
     * </p>
     *
     * <p>
     * This method should be called once during the mod's initialization
     * phase to ensure that all block items are properly set up before
     * the game runs.
     * </p>
     *
     * @see #setBlackList()
     */
    public static void init()
    {
        LOGGER.log("Registering Block Items");

        //ANGEL = Items.register("block_angel", settings ->  new AngelBlockItem(ModBlocks.ANGEL, settings));
        //ENDERITE = Items.register("block_enderite", settings ->  new AngelBlockItem(ModBlocks.ANGEL, settings));
        ANGEL = register(ModBlocks.ANGEL, AngelBlockItem::new);

        ENDERITE = register(ModBlocks.ENDERITE);
        CARROT_BOX = register(ModBlocks.CARROT_BOX);
        POTATO_BOX = register(ModBlocks.POTATO_BOX);
        CITRINE = register(ModBlocks.CITRINE);
        RUBY = register(ModBlocks.RUBY);
        SAPPHIRE = register(ModBlocks.SAPPHIRE);
        RAW_CITRINE = register(ModBlocks.RAW_CITRINE);
        RAW_ENDERITE = register(ModBlocks.RAW_ENDERITE);
        RAW_QUARTZ = register(ModBlocks.RAW_QUARTZ);
        RAW_RUBY = register(ModBlocks.RAW_RUBY);
        RAW_SAPPHIRE = register(ModBlocks.RAW_SAPPHIRE);
        CITRINE_STAIRS = register(ModBlocks.CITRINE_STAIRS);
        ENDERITE_STAIRS = register(ModBlocks.ENDERITE_STAIRS);
        RUBY_STAIRS = register(ModBlocks.RUBY_STAIRS);
        SAPPHIRE_STAIRS = register(ModBlocks.SAPPHIRE_STAIRS);
        CITRINE_SLAB = register(ModBlocks.CITRINE_SLAB);
        ENDERITE_SLAB = register(ModBlocks.ENDERITE_SLAB);
        RUBY_SLAB = register(ModBlocks.RUBY_SLAB);
        SAPPHIRE_SLAB = register(ModBlocks.SAPPHIRE_SLAB);
        CITRINE_BUTTON = register(ModBlocks.CITRINE_BUTTON);
        ENDERITE_BUTTON = register(ModBlocks.ENDERITE_BUTTON);
        RUBY_BUTTON = register(ModBlocks.RUBY_BUTTON);
        SAPPHIRE_BUTTON = register(ModBlocks.SAPPHIRE_BUTTON);
        CITRINE_PRESSURE_PLATE = register(ModBlocks.CITRINE_PRESSURE_PLATE);
        ENDERITE_PRESSURE_PLATE = register(ModBlocks.ENDERITE_PRESSURE_PLATE);
        RUBY_PRESSURE_PLATE = register(ModBlocks.RUBY_PRESSURE_PLATE);
        SAPPHIRE_PRESSURE_PLATE = register(ModBlocks.SAPPHIRE_PRESSURE_PLATE);
        CITRINE_FENCE = register(ModBlocks.CITRINE_FENCE);
        ENDERITE_FENCE = register(ModBlocks.ENDERITE_FENCE);
        RUBY_FENCE = register(ModBlocks.RUBY_FENCE);
        SAPPHIRE_FENCE = register(ModBlocks.SAPPHIRE_FENCE);
        CITRINE_FENCE_GATE = register(ModBlocks.CITRINE_FENCE_GATE);
        ENDERITE_FENCE_GATE = register(ModBlocks.ENDERITE_FENCE_GATE);
        RUBY_FENCE_GATE = register(ModBlocks.RUBY_FENCE_GATE);
        SAPPHIRE_FENCE_GATE = register(ModBlocks.SAPPHIRE_FENCE_GATE);
        CITRINE_WALL = register(ModBlocks.CITRINE_WALL);
        ENDERITE_WALL = register(ModBlocks.ENDERITE_WALL);
        RUBY_WALL = register(ModBlocks.RUBY_WALL);
        SAPPHIRE_WALL = register(ModBlocks.SAPPHIRE_WALL);
        CITRINE_DOOR = register(ModBlocks.CITRINE_DOOR);
        ENDERITE_DOOR = register(ModBlocks.ENDERITE_DOOR);
        RUBY_DOOR = register(ModBlocks.RUBY_DOOR);
        SAPPHIRE_DOOR = register(ModBlocks.SAPPHIRE_DOOR);
        CITRINE_TRAP_DOOR = register(ModBlocks.CITRINE_TRAP_DOOR);
        ENDERITE_TRAP_DOOR = register(ModBlocks.ENDERITE_TRAP_DOOR);
        RUBY_TRAP_DOOR = register(ModBlocks.RUBY_TRAP_DOOR);
        SAPPHIRE_TRAP_DOOR = register(ModBlocks.SAPPHIRE_TRAP_DOOR);
        ORE_DEEP_CITRINE = register(ModBlocks.ORE_DEEP_CITRINE);
        ORE_DEEP_RUBY = register(ModBlocks.ORE_DEEP_RUBY);
        ORE_DEEP_SAPPHIRE = register(ModBlocks.ORE_DEEP_SAPPHIRE);
        ORE_END_CITRINE = register(ModBlocks.ORE_END_CITRINE);
        ORE_END_ENDERITE_CRACKED = register(ModBlocks.ORE_END_ENDERITE_CRACKED);
        ORE_END_RUBY = register(ModBlocks.ORE_END_RUBY);
        ORE_END_SAPPHIRE = register(ModBlocks.ORE_END_SAPPHIRE);
        ORE_END_ENDERITE = register(ModBlocks.ORE_END_ENDERITE);
        ORE_NETHER_CITRINE = register(ModBlocks.ORE_NETHER_CITRINE);
        ORE_NETHER_RUBY = register(ModBlocks.ORE_NETHER_RUBY);
        ORE_NETHER_SAPPHIRE = register(ModBlocks.ORE_NETHER_SAPPHIRE);
        ORE_NETHER_COAL = register(ModBlocks.ORE_NETHER_COAL);
        ORE_NETHER_COPPER = register(ModBlocks.ORE_NETHER_COPPER);
        ORE_NETHER_DIAMOND = register(ModBlocks.ORE_NETHER_DIAMOND);
        ORE_NETHER_IRON = register(ModBlocks.ORE_NETHER_IRON);
        ORE_NETHER_LAPIS = register(ModBlocks.ORE_NETHER_LAPIS);
        ORE_NETHER_REDSTONE = register(ModBlocks.ORE_NETHER_REDSTONE);
        ORE_WORLD_CITRINE = register(ModBlocks.ORE_WORLD_CITRINE);
        ORE_WORLD_RUBY = register(ModBlocks.ORE_WORLD_RUBY);
        ORE_WORLD_SAPPHIRE = register(ModBlocks.ORE_WORLD_SAPPHIRE);
        ORE_ENDERITE = register(ModBlocks.ORE_ENDERITE);
        WATER_EATING_GOO = register(ModBlocks.WATER_EATING_GOO);
        WATER_GENERATING_GOO = register(ModBlocks.WATER_GENERATING_GOO);
        LAVA_EATING_GOO = register(ModBlocks.LAVA_EATING_GOO);
        LAVA_GENERATING_GOO = register(ModBlocks.LAVA_GENERATING_GOO);
        CHUNK_GOO = register(ModBlocks.CHUNK_GOO);
        TOWERING_GOO = register(ModBlocks.TOWERING_GOO);
        TUNNELING_GOO = register(ModBlocks.TUNNELING_GOO);
        BRIDGE_GOO = register(ModBlocks.BRIDGE_GOO);
        AIR_BOMB_GOO = register(ModBlocks.AIR_BOMB_GOO);
        CHUNK_BOMB_GOO = register(ModBlocks.CHUNK_BOMB_GOO);
        LAVA_PUMP_GOO = register(ModBlocks.LAVA_PUMP_GOO);
        STONE_BOMB_GOO = register(ModBlocks.STONE_BOMB_GOO);
        WATER_PUMP_GOO = register(ModBlocks.WATER_PUMP_GOO);
        ELEVATOR = register(ModBlocks.ELEVATOR);
        REDSTONE_CLOCK = register(ModBlocks.REDSTONE_CLOCK);
        ALLOY_MIXER = register(ModBlocks.ALLOY_MIXER);
        CAST_PRESS = register(ModBlocks.CAST_PRESS);
        GEM_CLEANER = register(ModBlocks.GEM_CLEANER);
        OVEN = register(ModBlocks.OVEN);
        PULVERIZER = register(ModBlocks.PULVERIZER);
        SMELTER = register(ModBlocks.SMELTER);
        ANIMAL_FEED = register(ModBlocks.ANIMAL_FEED);
        GENERATOR = register(ModBlocks.GENERATOR);
        BLOCK_BREAKER = register(ModBlocks.BLOCK_BREAKER);
        BLOCK_PLACER = register(ModBlocks.BLOCK_PLACER);
        BUILDER = register(ModBlocks.BUILDER);
        CHUNK_LOADER = register(ModBlocks.CHUNK_LOADER);
        CREATIVE_BANK = register(ModBlocks.CREATIVE_BANK);
        ENDER_CHANTER = register(ModBlocks.ENDER_CHANTER);
        FLUID_PUMP = register(ModBlocks.FLUID_PUMP);
        PRINTER = register(ModBlocks.PRINTER);
        PROJECT_TABLE = register(ModBlocks.PROJECT_TABLE);
        TESSERACT = register(ModBlocks.TESSERACT);
        WOOD_STRIPPER = register(ModBlocks.WOOD_STRIPPER);
        BATTERY_BANK = register(ModBlocks.BATTERY_BANK);
        SOLAR_PANEL = register(ModBlocks.SOLAR_PANEL);
        MINER = register(ModBlocks.MINER);
    }

    /**
     * Sets a blacklist for the block items.
     *
     * <p>
     * This method is currently empty and has no functionality but serves as a placeholder
     * for future implementation to define restrictions on block items that should not
     * be used or registered in certain contexts.
     * </p>
     *
     * <p>
     * The current implementation does not perform any actions, but it is included
     * for potential future enhancements.
     * </p>
     */
    public static void setBlackList()
    {
    }
}