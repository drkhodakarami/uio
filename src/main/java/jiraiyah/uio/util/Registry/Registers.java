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

package jiraiyah.uio.util.registry;

import com.google.gson.JsonElement;
import jiraiyah.uio.util.registry.factories.IArmorFactory;
import jiraiyah.uio.util.registry.factories.IBlockItemFactory;
import jiraiyah.uio.util.registry.factories.IToolFactory;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.CustomModelDataComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.data.client.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentModel;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.injection.invoke.arg.ArgumentCountException;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

import static jiraiyah.uio.Reference.identifier;

/**
 * This class is used to register all the items, blocks, entities, and other objects in the mod.
 * <br>
 * Thanks to ZeroNoRyouki.
 * <br>
 * Knowledge Base: Functional Programming & Factory Design Pattern
 *
 * @author Jiraiyah
 */
@SuppressWarnings("unused")
public class Registers
{
    Registers()
    {
        throw new AssertionError();
    }

    //region LIST MAPS
    private static final Map<String, List<net.minecraft.item.Item>> ALL_ITEMS = new HashMap<>();
    private static final Map<String, List<net.minecraft.item.Item>> ALL_FOODS = new HashMap<>();
    private static final Map<String, List<net.minecraft.item.Item>> ALL_SNACKS = new HashMap<>();
    private static final Map<String, List<net.minecraft.item.Item>> ALL_BLOCK_ITEMS = new HashMap<>();
    private static final Map<String, List<net.minecraft.block.Block>> ALL_BLOCKS = new HashMap<>();
    private static final Map<String, List<StairsBlock>> ALL_STAIRS = new HashMap<>();
    private static final Map<String, List<SlabBlock>> ALL_SLABS = new HashMap<>();
    private static final Map<String, List<ButtonBlock>> ALL_BUTTONS = new HashMap<>();
    private static final Map<String, List<PressurePlateBlock>> ALL_PRESSURE_PLATES = new HashMap<>();
    private static final Map<String, List<FenceBlock>> ALL_FENCES = new HashMap<>();
    private static final Map<String, List<FenceGateBlock>> ALL_FENCE_GATES = new HashMap<>();
    private static final Map<String, List<WallBlock>> ALL_WALLS = new HashMap<>();
    private static final Map<String, List<DoorBlock>> ALL_DOORS = new HashMap<>();
    private static final Map<String, List<TrapdoorBlock>> ALL_TRAP_DOORS = new HashMap<>();
    private static final Map<String, List<BlockEntityType<? extends BlockEntity>>> ALL_BLOCK_ENTITIES = new HashMap<>();
    private static final Map<String, List<EntityType<? extends Entity>>> ALL_ENTITIES = new HashMap<>();
    private static final Map<String, List<RecipeSerializer<?>>> ALL_RECIPE_SERIALIZERS = new HashMap<>();
    private static final Map<String, List<RecipeType<?>>> ALL_RECIPE_TYPES = new HashMap<>();
    private static final Map<String, List<RegistryEntry<net.minecraft.entity.effect.StatusEffect>>> ALL_EFFECTS = new HashMap<>();
    /**
     * The temporary mod Id that should be used during the registration process.
     */
    private static String modID = "defaultID";
    //endregion

    /**
     * Initializes the registry with the given mod ID.
     *
     * @param modID the mod ID to use for the registry.
     */
    public static void init(String modID)
    {
        Registers.modID = modID;
        ALL_ITEMS.computeIfAbsent(modID, k -> new ArrayList<>());
        ALL_FOODS.computeIfAbsent(modID, k -> new ArrayList<>());
        ALL_SNACKS.computeIfAbsent(modID, k -> new ArrayList<>());
        ALL_BLOCK_ITEMS.computeIfAbsent(modID, k -> new ArrayList<>());
        ALL_BLOCKS.computeIfAbsent(modID, k -> new ArrayList<>());
        ALL_STAIRS.computeIfAbsent(modID, k -> new ArrayList<>());
        ALL_SLABS.computeIfAbsent(modID, k -> new ArrayList<>());
        ALL_BUTTONS.computeIfAbsent(modID, k -> new ArrayList<>());
        ALL_PRESSURE_PLATES.computeIfAbsent(modID, k -> new ArrayList<>());
        ALL_FENCES.computeIfAbsent(modID, k -> new ArrayList<>());
        ALL_FENCE_GATES.computeIfAbsent(modID, k -> new ArrayList<>());
        ALL_WALLS.computeIfAbsent(modID, k -> new ArrayList<>());
        ALL_DOORS.computeIfAbsent(modID, k -> new ArrayList<>());
        ALL_TRAP_DOORS.computeIfAbsent(modID, k -> new ArrayList<>());
        ALL_BLOCK_ENTITIES.computeIfAbsent(modID, k -> new ArrayList<>());
        ALL_ENTITIES.computeIfAbsent(modID, k -> new ArrayList<>());
        ALL_RECIPE_SERIALIZERS.computeIfAbsent(modID, k -> new ArrayList<>());
        ALL_RECIPE_TYPES.computeIfAbsent(modID, k -> new ArrayList<>());
        ALL_EFFECTS.computeIfAbsent(modID, k -> new ArrayList<>());
    }

    //region GET LIST

    /**
     * @param key The mod ID to get the list of items for.
     *
     * @return A list of all the items in the mod with the given mod ID.
     */
    public static List<net.minecraft.item.Item> getAllItems(String key)
    {
        /*return Registries.ITEM.getEntrySet()
                              .stream()
                              .filter(entry -> entry.getKey().getValue().getNamespace().equals(modID))
                              .filter(entry -> !(entry.getValue() instanceof net.minecraft.item.BlockItem))
                              .map(Map.Entry::getValue)
                              .collect(Collectors.toList());*/
        return ALL_ITEMS.get(key);
    }

    /**
     * @param key The mod ID to get the list of food items for.
     *
     * @return A list of all the food items in the mod with the given mod ID.
     */
    public static List<net.minecraft.item.Item> getAllFood(String key)
    {
        return ALL_FOODS.get(key);
    }

    /**
     * @param key The mod ID to get the list of snack food for.
     *
     * @return A list of all the snack food in the mod with the given mod ID.
     */
    public static List<net.minecraft.item.Item> getAllSnacks(String key)
    {
        return ALL_SNACKS.get(key);
    }

    /**
     * @param key The mod ID to get the list of block items for.
     *
     * @return A list of all the block items in the mod with the given mod ID.
     */
    public static List<net.minecraft.item.Item> getAllBlockItems(String key)
    {
        /*return Registries.ITEM.getEntrySet()
                              .stream()
                              .filter(entry -> entry.getKey().getValue().getNamespace().equals(modID))
                              .filter(entry -> entry.getValue() instanceof net.minecraft.item.BlockItem)
                              .map(Map.Entry::getValue)
                              .collect(Collectors.toList());*/
        return ALL_BLOCK_ITEMS.get(key);
    }

    /**
     * @param key The mod ID to get the list of blocks for.
     *
     * @return A list of all the blocks in the mod with the given mod ID.
     */
    public static List<net.minecraft.block.Block> getAllBlocks(String key)
    {
        /*return Registries.BLOCK.getEntrySet()
                               .stream()
                               .filter(entry -> entry.getKey().getValue().getNamespace().equals(modID))
                               .map(Map.Entry::getValue)
                               .collect(Collectors.toList());*/
        return ALL_BLOCKS.get(key);
    }

    /**
     * @param key The mod ID to get the list of stairs for.
     *
     * @return A list of all the stairs in the mod with the given mod ID.
     */
    public static List<StairsBlock> getAllStairs(String key)
    {
        return ALL_STAIRS.get(key);
    }

    /**
     * @param key The mod ID to get the list of slabs for.
     *
     * @return A list of all the slabs in the mod with the given mod ID.
     */
    public static List<SlabBlock> getAllSlabs(String key)
    {
        return ALL_SLABS.get(key);
    }

    /**
     * @param key The mod ID to get the list of buttons for.
     *
     * @return A list of all the buttons in the mod with the given mod ID.
     */
    public static List<ButtonBlock> getAllButtons(String key)
    {
        return ALL_BUTTONS.get(key);
    }

    /**
     * @param key The mod ID to get the list of pressure plates for.
     *
     * @return A list of all the pressure plates in the mod with the given mod ID.
     */
    public static List<PressurePlateBlock> getAllPressurePlates(String key)
    {
        return ALL_PRESSURE_PLATES.get(key);
    }

    /**
     * @param key The mod ID to get the list of fences for.
     *
     * @return A list of all the fences in the mod with the given mod ID.
     */
    public static List<FenceBlock> getAllFences(String key)
    {
        return ALL_FENCES.get(key);
    }

    /**
     * @param key The mod ID to get the list of fence gates for.
     *
     * @return A list of all the fence gates in the mod with the given mod ID.
     */
    public static List<FenceGateBlock> getAllFenceGates(String key)
    {
        return ALL_FENCE_GATES.get(key);
    }

    /**
     * @param key The mod ID to get the list of walls for.
     *
     * @return A list of all the walls in the mod with the given mod ID.
     */
    public static List<WallBlock> getAllWalls(String key)
    {
        return ALL_WALLS.get(key);
    }

    /**
     * @param key The mod ID to get the list of doors for.
     *
     * @return A list of all the doors in the mod with the given mod ID.
     */
    public static List<DoorBlock> getAllDoors(String key)
    {
        return ALL_DOORS.get(key);
    }

    /**
     * @param key The mod ID to get the list of trap doors for.
     *
     * @return A list of all the trap doors in the mod with the given mod ID.
     */
    public static List<TrapdoorBlock> getAllTrapDoors(String key)
    {
        return ALL_TRAP_DOORS.get(key);
    }

    /**
     * @param key The mod ID to get the list of block entities for.
     *
     * @return A list of all the block entities in the mod with the given mod ID.
     */
    public static List<BlockEntityType<? extends BlockEntity>> getAllBlockEntities(String key)
    {
        return ALL_BLOCK_ENTITIES.get(key);
    }

    /**
     * @param key The mod ID to get the list of entities for.
     *
     * @return A list of all the entities in the mod with the given mod ID.
     */
    public static List<EntityType<? extends Entity>> getAllEntities(String key)
    {
        return ALL_ENTITIES.get(key);
    }

    /**
     * @param key The mod ID to get the list of entities for.
     *
     * @return A list of all the registry entries for the effects in the mod with the given mod ID.
     */
    public static List<RegistryEntry<net.minecraft.entity.effect.StatusEffect>> getAllEffects(String key)
    {
        return ALL_EFFECTS.get(key);
    }
    //endregion

    //Thanks to TurtyWurty for the code snippet for generating the RegistryKey

    /**
     * Returns a new RegistryKey for the given name and registry type.
     *
     * @param name        the name of the registry key.
     * @param registryKey the type of registry to create the key for.
     * @param <T>         the type of registry to create the key for.
     *
     *                    <br>
     *                    <h4>Example usage:
     *                    <pre>{@code
     *                                          getKey("someName", RegistryKeys.BLOCK);
     *                                          getKey("someName", RegistryKeys.ITEM);
     *                                          getKey("someName", RegistryKeys.BLOCK_ENTITY);
     *                                          }</pre>
     *
     * @return a new RegistryKey for the given name and registry type.
     */
    public static <T> RegistryKey<T> getKey(String name, RegistryKey<? extends Registry<T>> registryKey)
    {
        return RegistryKey.of(registryKey, identifier(name));
    }

    /**
     * Registers a new block with the given name and block factory.
     */
    public static class Block
    {
        Block()
        {
            throw new AssertionError();
        }

        /**
         * Registers a new block with the given name and default block factory.
         *
         * @param name the name of the block.
         *
         * @return the registered block.
         *
         * <br>
         * <h4>Example usage:
         * <pre>{@code
         *    Blocks.register("someName");
         *    }</pre>
         */
        public static net.minecraft.block.Block register(String name)
        {
            return register(name, net.minecraft.block.Block::new);
        }

        /**
         * Registers a new block with the given tooltips.
         *
         * @param name     The name of the block to be registered, used as its unique identifier.
         * @param tooltips A list of tooltips to be displayed when hovering over the block in the inventory, providing additional information.
         * @return The registered block.
         * This method uses the internal registry system to create and register a new block within the game.
         * It ensures that the block is properly identified by the given name and attaches the provided tooltips for enhanced user interaction and information.
         */
        public static net.minecraft.block.Block register(String name, List<Text> tooltips)
        {
            RegistryKey<net.minecraft.block.Block> key = getKey(name, RegistryKeys.BLOCK);
            net.minecraft.block.Block block = Registry.register(Registries.BLOCK, key,
                                                                new net.minecraft.block.Block(AbstractBlock.Settings.create().registryKey(key))
                                                                {
                                                                    @Override
                                                                    public void appendTooltip(ItemStack stack, net.minecraft.item.Item.TooltipContext context, List<Text> tooltip, TooltipType options)
                                                                    {
                                                                        tooltip.addAll(tooltips);
                                                                        super.appendTooltip(stack, context, tooltip, options);
                                                                    }
                                                                });
            ALL_BLOCKS.get(modID).add(block);
            return block;
        }
        /**
         * Registers a new block with the given name and copies the settings from the givne block.
         *
         * @param name      the name of the block.
         * @param blockCopy the block to copy the settings from.
         *
         * @return the registered block.
         *
         * <br>
         * <h4>Example usage:
         * <pre>{@code
         *    Blocks.register("someName", Blocks.STONE);
         *    }</pre>
         */
        public static net.minecraft.block.Block register(String name, net.minecraft.block.Block blockCopy)
        {
            return register(name, blockCopy, net.minecraft.block.Block::new);
        }

        /**
         * Registers a new block by copying the properties of an existing block and adding specified tooltips.
         *
         * @param name      The name of the block to be registered, used as its unique identifier.
         * @param blockCopy The existing block whose properties will be copied to the new block.
         * @param tooltips  A list of tooltips to be displayed when hovering over the block in the inventory, providing additional information.
         * @return The registered block.
         * This method uses the internal registry system to create and register a new block within the game.
         * It duplicates the properties of the provided `blockCopy` and ensures that the new block is properly identified by the given name.
         * Additionally, it attaches the provided tooltips for enhanced user interaction and information.
         */
        public static net.minecraft.block.Block register(String name, net.minecraft.block.Block blockCopy, List<Text> tooltips)
        {
            RegistryKey<net.minecraft.block.Block> key = getKey(name, RegistryKeys.BLOCK);
            net.minecraft.block.Block block = Registry.register(Registries.BLOCK, key,
                                                                new net.minecraft.block.Block(AbstractBlock.Settings.copy(blockCopy).registryKey(key))
                                                                {
                                                                    @Override
                                                                    public void appendTooltip(ItemStack stack, net.minecraft.item.Item.TooltipContext context, List<Text> tooltip, TooltipType options)
                                                                    {
                                                                        tooltip.addAll(tooltips);
                                                                        super.appendTooltip(stack, context, tooltip, options);
                                                                    }
                                                                });
            ALL_BLOCKS.get(modID).add(block);
            return block;
        }
        /**
         * Registers a new block with the given name and settings.
         *
         * @param name     the name of the block.
         * @param settings the settings to use for the block.
         *
         * @return the registered block.
         *
         * <br>
         * <h4>Example usage:
         * <pre>{@code
         *    Blocks.register("someName", new AbstractBlock.Settings.create()));
         *    }</pre>
         */
        public static net.minecraft.block.Block register(String name, AbstractBlock.Settings settings)
        {
            return register(name, settings, net.minecraft.block.Block::new);
        }

        /**
         * Registers a new block with the specified settings and tooltips.
         *
         * @param name     The name of the block to be registered, used as its unique identifier.
         * @param settings The settings that define the properties and behavior of the block, such as hardness, resistance, and material.
         * @param tooltips A list of tooltips to be displayed when hovering over the block in the inventory, providing additional information.
         * @return The registered block.
         * This method uses the internal registry system to create and register a new block within the game.
         * It ensures that the block is properly identified by the given name and configured with the specified settings.
         * Additionally, it attaches the provided tooltips for enhanced user interaction and information.
         */
        public static net.minecraft.block.Block register(String name, AbstractBlock.Settings settings, List<Text> tooltips)
        {
            RegistryKey<net.minecraft.block.Block> key = getKey(name, RegistryKeys.BLOCK);
            net.minecraft.block.Block block = Registry.register(Registries.BLOCK, key,
                                                                new net.minecraft.block.Block(settings.registryKey(key))
                                                                {
                                                                    @Override
                                                                    public void appendTooltip(ItemStack stack, net.minecraft.item.Item.TooltipContext context, List<Text> tooltip, TooltipType options)
                                                                    {
                                                                        tooltip.addAll(tooltips);
                                                                        super.appendTooltip(stack, context, tooltip, options);
                                                                    }
                                                                });
            ALL_BLOCKS.get(modID).add(block);
            return block;
        }

        /**
         * Registers the given block with the given name.
         *
         * @param name  the name of the block.
         * @param block the block to register.
         *
         * @return the registered block.
         *
         * <br>
         * <h4>Example usage:
         * <pre>{@code
         *    Blocks.register("someName", new Block(AbstractBlock.Settings.create()));
         *    }</pre>
         */
        public static <T extends net.minecraft.block.Block> T registerSimple(String name, T block)
        {
            RegistryKey<net.minecraft.block.Block> key = getKey(name, RegistryKeys.BLOCK);
            T newBlock = Registry.register(Registries.BLOCK, key, block);
            ALL_BLOCKS.get(modID).add(newBlock);
            return newBlock;
        }

        /**
         * Registers a new block with the given name and given block factory.
         *
         * @param name    the name of the block.
         * @param factory the factory to use to create the block.
         *
         * @return the registered block.
         *
         * <br>
         * <h4>Example usage:
         * <pre>{@code
         *    Blocks.register("someName", SomeBlock::new);
         *    }</pre>
         */
        public static <T extends net.minecraft.block.Block> T register(String name,
                                                                       Function<AbstractBlock.Settings, T> factory)
        {
            RegistryKey<net.minecraft.block.Block> key = getKey(name, RegistryKeys.BLOCK);
            T block = factory.apply(AbstractBlock.Settings.create().registryKey(key));
            T newBlock = Registry.register(Registries.BLOCK, key, block);
            ALL_BLOCKS.get(modID).add(newBlock);
            return newBlock;
        }

        /**
         * Registers a new block with the given name and given block factory using the given block to copy the settings from.
         *
         * @param name      the name of the block.
         * @param blockCopy the block to copy the settings from.
         * @param factory   the factory to use to create the block.
         *
         * @return the registered block.
         *
         * <br>
         * <h4>Example usage:
         * <pre>{@code
         *    Blocks.register("someName", Blocks.GRAY_WOOL, SomeBlock::new);
         *    }</pre>
         */
        public static <T extends net.minecraft.block.Block> T register(String name, net.minecraft.block.Block blockCopy,
                                                                       Function<AbstractBlock.Settings, T> factory)
        {
            RegistryKey<net.minecraft.block.Block> key = getKey(name, RegistryKeys.BLOCK);
            T block = factory.apply(AbstractBlock.Settings.copy(blockCopy).registryKey(key));
            T newBlock = Registry.register(Registries.BLOCK, key, block);
            ALL_BLOCKS.get(modID).add(newBlock);
            return newBlock;
        }

        /**
         * Registers a new block with the given name and given block factory and with the given settings.
         *
         * @param name     the name of the block.
         * @param settings the settings to use for the block.
         * @param factory  the factory to use to create the block.
         *
         * @return the registered block.
         *
         * <br>
         * <h4>Example usage:
         * <pre>{@code
         *    Blocks.register("someName", new AbstractBlock.Settings.copy(Blocks.GRAY_WOOL), SomeBlock::new);
         *    }</pre>
         */
        public static <T extends net.minecraft.block.Block> T register(String name, AbstractBlock.Settings settings,
                                                                       Function<AbstractBlock.Settings, T> factory)
        {
            RegistryKey<net.minecraft.block.Block> key = getKey(name, RegistryKeys.BLOCK);
            T block = factory.apply(settings.registryKey(key));
            T newBlock = Registry.register(Registries.BLOCK, key, block);
            ALL_BLOCKS.get(modID).add(newBlock);
            return newBlock;
        }

        //region HELPERS
        /**
         * Registers a new Stair Block with the given name and given block for default state and uses the given block to copy the settings from.
         *
         * @param name       the name of the block.
         * @param stateBlock the block to copy the default state from.
         * @param copyBlock  the block to copy the settings from.
         *
         * @return the registered stair block.
         *
         * <br>
         * <h4>Example usage:
         * <pre>{@code
         *    registerStair("some_name", ModBlocks.SOME_BLOCK, Blocks.AMETHYST_BLOCK);
         *    }</pre>
         */
        public static StairsBlock registerStair(String name, net.minecraft.block.Block stateBlock,
                                                net.minecraft.block.Block copyBlock)
        {
            RegistryKey<net.minecraft.block.Block> key = getKey(name, RegistryKeys.BLOCK);
            StairsBlock newBlock = registerSimple(name,
                                                  new StairsBlock(stateBlock.getDefaultState(),
                                                                  AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
            ALL_STAIRS.get(modID).add(newBlock);
            ALL_BLOCKS.get(modID).add(newBlock);
            return newBlock;
        }

        /**
         * Registers a new Slab Block with the given name and the given block to copy the settings from.
         *
         * @param name      the name of the block.
         * @param copyBlock the block to copy the settings from.
         *
         * @return the registered slab block.
         *
         * <br>
         * <h4>Example usage:
         * <pre>{@code
         *    registerSlab("some_name", Blocks.AMETHYST_BLOCK);
         *    }</pre>
         */
        public static SlabBlock registerSlab(String name, net.minecraft.block.Block copyBlock)
        {
            RegistryKey<net.minecraft.block.Block> key = getKey(name, RegistryKeys.BLOCK);
            SlabBlock newBlock = registerSimple(name,
                                                new SlabBlock(AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
            ALL_SLABS.get(modID).add(newBlock);
            ALL_BLOCKS.get(modID).add(newBlock);
            return newBlock;
        }

        /**
         * Registers a new Button Block with the given name and the given block to copy the settings from.
         *
         * @param name          the name of the block.
         * @param blockType     the type of button to create.
         * @param pressureTicks the number of ticks the button should be pressed for.
         * @param copyBlock     the block to copy the settings from.
         *
         * @return the registered button block.
         *
         * <br>
         * <h4>Example usage:
         * <pre>{@code
         *    registerButton("some_name", BlockSetType.WOOD, 20, Blocks.AMETHYST_BLOCK);
         *    }</pre>
         */
        public static ButtonBlock registerButton(String name, BlockSetType blockType, int pressureTicks,
                                                 net.minecraft.block.Block copyBlock)
        {
            RegistryKey<net.minecraft.block.Block> key = getKey(name, RegistryKeys.BLOCK);
            ButtonBlock newBlock = registerSimple(name,
                                                  new ButtonBlock(blockType, pressureTicks,
                                                                  AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
            ALL_BUTTONS.get(modID).add(newBlock);
            ALL_BLOCKS.get(modID).add(newBlock);
            return newBlock;
        }

        /**
         * Registers a new pressure Plate Block with the given name and the given block to copy the settings from.
         *
         * @param name      the name of the block.
         * @param blockType the type of button to create.
         * @param copyBlock the block to copy the settings from.
         *
         * @return the registered pressure plate block.
         *
         * <br>
         * <h4>Example usage:
         * <pre>{@code
         *    registerPressurePlate("some_name", BlockSetType.WOOD, Blocks.AMETHYST_BLOCK);
         *    }</pre>
         */
        public static PressurePlateBlock registerPressurePlate(String name, BlockSetType blockType,
                                                               net.minecraft.block.Block copyBlock)
        {
            RegistryKey<net.minecraft.block.Block> key = getKey(name, RegistryKeys.BLOCK);
            PressurePlateBlock newBlock = registerSimple(name,
                                                         new PressurePlateBlock(blockType,
                                                                                AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
            ALL_PRESSURE_PLATES.get(modID).add(newBlock);
            ALL_BLOCKS.get(modID).add(newBlock);
            return newBlock;
        }

        /**
         * Registers a new Fence Block with the given name and the given block to copy the settings from.
         *
         * @param name      the name of the block.
         * @param copyBlock the block to copy the settings from.
         *
         * @return the registered fence block.
         *
         * <br>
         * <h4>Example usage:
         * <pre>{@code
         *    registerFence("some_name", Blocks.AMETHYST_BLOCK);
         *    }</pre>
         */
        public static FenceBlock registerFence(String name, net.minecraft.block.Block copyBlock)
        {
            RegistryKey<net.minecraft.block.Block> key = getKey(name, RegistryKeys.BLOCK);
            FenceBlock newBlock = registerSimple(name,
                                                 new FenceBlock(AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
            ALL_FENCES.get(modID).add(newBlock);
            ALL_BLOCKS.get(modID).add(newBlock);
            return newBlock;
        }

        /**
         * Registers a new Fence Gate Block with the given name and the given block to copy the settings from.
         *
         * @param name      the name of the block.
         * @param woodType  the type of wood to use for the sound of the fence gate.
         * @param copyBlock the block to copy the settings from.
         *
         * @return the registered fence gate block.
         *
         * <br>
         * <h4>Example usage:
         * <pre>{@code
         *    registerFenceGate("some_name", WoodType.OAK, Blocks.AMETHYST_BLOCK);
         *    }</pre>
         */
        public static FenceGateBlock registerFenceGate(String name, WoodType woodType, net.minecraft.block.Block copyBlock)
        {
            RegistryKey<net.minecraft.block.Block> key = getKey(name, RegistryKeys.BLOCK);
            FenceGateBlock newBlock = registerSimple(name,
                                                     new FenceGateBlock(woodType,
                                                                        AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
            ALL_FENCE_GATES.get(modID).add(newBlock);
            ALL_BLOCKS.get(modID).add(newBlock);
            return newBlock;
        }

        /**
         * Registers a new Wall Block with the given name and the given block to copy the settings from.
         *
         * @param name      the name of the block.
         * @param copyBlock the block to copy the settings from.
         *
         * @return the registered wall block.
         *
         * <br>
         * <h4>Example usage:
         * <pre>{@code
         *    registerWall("some_name", Blocks.AMETHYST_BLOCK);
         *    }</pre>
         */
        public static WallBlock registerWall(String name, net.minecraft.block.Block copyBlock)
        {
            RegistryKey<net.minecraft.block.Block> key = getKey(name, RegistryKeys.BLOCK);
            WallBlock newBlock = registerSimple(name,
                                                new WallBlock(AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
            ALL_WALLS.get(modID).add(newBlock);
            ALL_BLOCKS.get(modID).add(newBlock);
            return newBlock;
        }

        /**
         * Registers a new Door Block with the given name and the given block to copy the settings from.
         *
         * @param name      the name of the block.
         * @param blockType the type of door to create.
         * @param copyBlock the block to copy the settings from.
         *
         * @return the registered door block.
         *
         * <br>
         * <h4>Example usage:
         * <pre>{@code
         *    registerDoor("some_name", BlockSetType.IRON, Blocks.AMETHYST_BLOCK);
         *    }</pre>
         */
        public static DoorBlock registerDoor(String name, BlockSetType blockType, net.minecraft.block.Block copyBlock)
        {
            RegistryKey<net.minecraft.block.Block> key = getKey(name, RegistryKeys.BLOCK);
            DoorBlock newBlock = registerSimple(name,
                                                new DoorBlock(blockType,
                                                              AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
            ALL_DOORS.get(modID).add(newBlock);
            ALL_BLOCKS.get(modID).add(newBlock);
            return newBlock;
        }

        /**
         * Registers a new Trap Door Block with the given name and the given block to copy the settings from.
         *
         * @param name      the name of the block.
         * @param blockType the type of door to create.
         * @param copyBlock the block to copy the settings from.
         *
         * @return the registered trap door block.
         *
         * <br>
         * <h4>Example usage:
         * <pre>{@code
         *    registerTrapDoor("some_name", BlockSetType.IRON, Blocks.AMETHYST_BLOCK);
         *    }</pre>
         */
        public static TrapdoorBlock registerTrapdoor(String name, BlockSetType blockType, net.minecraft.block.Block copyBlock)
        {
            RegistryKey<net.minecraft.block.Block> key = getKey(name, RegistryKeys.BLOCK);
            TrapdoorBlock newBlock = registerSimple(name,
                                                    new TrapdoorBlock(blockType,
                                                                      AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
            ALL_TRAP_DOORS.get(modID).add(newBlock);
            ALL_BLOCKS.get(modID).add(newBlock);
            return newBlock;
        }
        //endregion
    }

    /**
     * Registers a new Block Entity or any other Entity with the given name and the given factory.
     */
    public static class Entities
    {
        Entities()
        {
            throw new AssertionError();
        }

        /**
         * Registers a new Block Entity with the given name and the given factory.
         *
         * @param name    the name of the block entity.
         * @param block   the block associated with the block entity.
         * @param factory the factory to use to create the block entity.
         * @param <T>     the type of the block entity.
         *
         *                <br>
         *                <h4>Example usage:
         *                <pre>{@code
         *                                  Entities.register("someName", ModBlocks.SOME_BLOCK, SomeBlockEntity::new);
         *                                  }</pre>
         *
         * @return the registered block entity.
         */
        public static <T extends BlockEntity> BlockEntityType<T> register(String name, net.minecraft.block.Block block,
                                                                          FabricBlockEntityTypeBuilder.Factory<T> factory)
        {
            RegistryKey<BlockEntityType<?>> key = getKey(name, RegistryKeys.BLOCK_ENTITY_TYPE);
            BlockEntityType<T> beType = FabricBlockEntityTypeBuilder.create(factory, block).build(null);
            BlockEntityType<T> be = Registry.register(Registries.BLOCK_ENTITY_TYPE, key, beType);
            ALL_BLOCK_ENTITIES.get(modID).add(be);
            return be;
        }

        /**
         * Registers a new Entity with the given name and the given factory.
         *
         * @param name    the name of the entity.
         * @param factory the factory to use to create the entity.
         * @param <T>     the type of the entity.
         *
         *                <br>
         *                <h4>Example usage:
         *                <pre>{@code
         *                   Entities.register("someName", SomeEntity::new);
         *                   }</pre>
         *
         * @return the registered entity.
         */
        public static <T extends Entity> EntityType<T> register(String name, EntityType.EntityFactory<T> factory)
        {
            RegistryKey<EntityType<?>> key = getKey(name, RegistryKeys.ENTITY_TYPE);
            EntityType<T> entityType = EntityType.Builder.create(factory, SpawnGroup.MISC).build(key);
            EntityType<T> entity = Registry.register(Registries.ENTITY_TYPE, key, entityType);
            ALL_ENTITIES.get(modID).add(entity);
            return entity;
        }
    }

    /**
     * Registers a new Item with the given name and the given factory.
     */
    public static class Item
    {
        /**
         * Registers an Item with the given name and the default factory.
         * @param name the name of the item.
         * @return the registered item.
         * <br>
         * <h4>Example usage:
         * <pre>
         *     {@code
         *    Item.register("someName");
         *    }
         *    </pre>
         */
        public static net.minecraft.item.Item register(String name)
        {
            return register(name, net.minecraft.item.Item::new);
        }

        /**
         * Registers a new item with the tooltips.
         * @param name     The name of the item to be registered, used as its unique identifier.
         * @param tooltips A list of tooltips to be displayed when hovering over the item in the inventory, providing additional information.
         * @return The registered item.
         * This method uses the internal registry system to create and register a new item within the game.
         * It ensures that the item is properly identified by the given name and attaches the provided tooltips for enhanced user interaction and information.
         */
        public static net.minecraft.item.Item register(String name, List<Text> tooltips)
        {
            RegistryKey<net.minecraft.item.Item> key = getKey(name, RegistryKeys.ITEM);
            net.minecraft.item.Item item = Registry.register(Registries.ITEM, key, new net.minecraft.item.Item(new net.minecraft.item.Item.Settings().registryKey(key))
            {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type)
                {
                    tooltip.addAll(tooltips);
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });
            ALL_ITEMS.get(modID).add(item);
            return item;
        }

        /**
         * Registers an Item with the given name and the given stack count.
         * @param name       the name of the item.
         * @param stackCount the stack count of the item.
         * @return the registered item.
         * <br>
         * <h4>Example usage:
         * <pre>{@code
         *    Item.register("someName", 16);
         *    }</pre>
         */
        public static net.minecraft.item.Item register(String name, int stackCount)
        {
            return register(name, stackCount, net.minecraft.item.Item::new);
        }

        /**
         * Registers a new item with the specified stack count.
         * @param name       The name of the item to be registered, used as its unique identifier.
         * @param stackCount The maximum number of items that can be stacked together in the inventory.
         * @param tooltips   A list of tooltips to be displayed when hovering over the item in the inventory, providing additional information.
         * @return The registered item.
         * This method uses the internal registry system to create and register a new item within the game.
         * It ensures that the item has the specified stack size and attaches the provided tooltips for enhanced user interaction and information.
         */
        public static net.minecraft.item.Item register(String name, int stackCount, List<Text> tooltips)
        {
            RegistryKey<net.minecraft.item.Item> key = getKey(name, RegistryKeys.ITEM);
            net.minecraft.item.Item item = Registry.register(Registries.ITEM, key, new net.minecraft.item.Item(new net.minecraft.item.Item.Settings()
                                                                                               .maxCount(stackCount)
                                                                                               .registryKey(key))
            {
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type)
                {
                    tooltip.addAll(tooltips);
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });
            ALL_ITEMS.get(modID).add(item);
            return item;
        }

        /**
         * Registers an Item with the given name and the given factory.
         * @param name    the name of the item.
         * @param factory the factory to use to create the item.
         * @param <T>     the type of the item.
         *                <br>
         *                <h4>Example usage:
         *                <pre>{@code
         *                                  Item.register("someName", SomeItem::new);
         *                                  }</pre>
         * @return the registered item.
         */
        public static <T extends net.minecraft.item.Item> T register(String name,
                                                                     Function<net.minecraft.item.Item.Settings, T> factory)
        {
            RegistryKey<net.minecraft.item.Item> key = getKey(name, RegistryKeys.ITEM);
            T item = factory.apply(new net.minecraft.item.Item.Settings().registryKey(key));
            T newItem = Registry.register(Registries.ITEM, key, item);
            ALL_ITEMS.get(modID).add(newItem);
            return newItem;
        }

        /**
         * Registers an Item with the given name, stack count and the given factory.
         * @param name       the name of the item.
         * @param stackCount the stack count of the item.
         * @param factory    the factory to use to create the item.
         * @param <T>        the type of the item.
         *                   <br>
         *                   <h4>Example usage:
         *                   <pre>{@code
         *                                        Item.register("someName", 16, SomeItem::new);
         *                                        }</pre>
         * @return the registered item.
         */
        public static <T extends net.minecraft.item.Item> T register(String name, int stackCount,
                                                                     Function<net.minecraft.item.Item.Settings, T> factory)
        {
            RegistryKey<net.minecraft.item.Item> key = getKey(name, RegistryKeys.ITEM);
            T item = factory.apply(new net.minecraft.item.Item.Settings().registryKey(key).maxCount(stackCount));
            T newItem = Registry.register(Registries.ITEM, key, item);
            ALL_ITEMS.get(modID).add(newItem);
            return newItem;
        }

        /**
         * Registers an Item with the given name, stack count, custom settings and the given factory.
         * @param name       the name of the item.
         * @param stackCount the stack count of the item.
         * @param settings   the custom settings for the item.
         * @param factory    the factory to use to create the item.
         * @param <T>        the type of the item.
         *                   <br>
         *                   <h4>Example usage:
         *                   <pre>{@code
         *                                        Item.register("someName", 16, new Item.Settings(), SomeItem::new);
         *                                        }</pre>
         * @return the registered item.
         */
        public static <T extends net.minecraft.item.Item> T register(String name, int stackCount,
                                                                     net.minecraft.item.Item.Settings settings,
                                                                     Function<net.minecraft.item.Item.Settings, T> factory)
        {
            RegistryKey<net.minecraft.item.Item> key = getKey(name, RegistryKeys.ITEM);
            T item = factory.apply(settings.registryKey(key).maxCount(stackCount));
            T newItem = Registry.register(Registries.ITEM, key, item);
            ALL_ITEMS.get(modID).add(newItem);
            return newItem;
        }

        /**
         * Registers an Item with the given name, custom settings and the given factory.
         * @param name     the name of the item.
         * @param settings the custom settings for the item.
         * @param factory  the factory to use to create the item.
         * @param <T>      the type of the item.
         *                 <br>
         *                 <h4>Example usage:
         *                 <pre>{@code
         *                                    Item.register("someName", new Item.Settings(), SomeItem::new);
         *                                    }</pre>
         * @return the registered item.
         */
        public static <T extends net.minecraft.item.Item> T register(String name, net.minecraft.item.Item.Settings settings,
                                                                     Function<net.minecraft.item.Item.Settings, T> factory)
        {
            RegistryKey<net.minecraft.item.Item> key = getKey(name, RegistryKeys.ITEM);
            T item = factory.apply(settings.registryKey(key));
            T newItem = Registry.register(Registries.ITEM, key, item);
            ALL_ITEMS.get(modID).add(newItem);
            return newItem;
        }

        /**
         * Registers a tool with the given name, material, attack damage and attack speed, and the given factory.
         * @param name         the name of the tool.
         * @param material     the material of the tool.
         * @param attackDamage the attack damage of the tool.
         * @param attackSpeed  the attack speed of the tool.
         * @param factory      the factory to use to create the tool.
         * @param <T>          the type of the tool.
         *                     <br>
         *                     <h4>Example usage:
         *                     <pre>{@code
         *                                            Item.registerTool("someName", ToolMaterials.DIAMOND, 0.0f, 0.0f, HoeItem::new);
         *                                            }</pre>
         * @return the registered tool.
         */
        public static <T extends net.minecraft.item.Item> T registerTool(String name, ToolMaterial material,
                                                                         float attackDamage, float attackSpeed,
                                                                         IToolFactory<net.minecraft.item.Item.Settings, T> factory)
        {
            RegistryKey<net.minecraft.item.Item> key = getKey(name, RegistryKeys.ITEM);
            T item = factory.apply(material, attackDamage, attackSpeed,
                                   new net.minecraft.item.Item.Settings().registryKey(key));
            T newItem = Registry.register(Registries.ITEM, key, item);
            ALL_ITEMS.get(modID).add(newItem);
            return newItem;
        }

        /**
         * Registers a tool with the given name, material, attack damage and attack speed, custom settings, and the given factory.
         * @param name         the name of the tool.
         * @param material     the material of the tool.
         * @param attackDamage the attack damage of the tool.
         * @param attackSpeed  the attack speed of the tool.
         * @param settings     the custom settings for the tool.
         * @param factory      the factory to use to create the tool.
         * @param <T>          the type of the tool.
         *                     <br>
         *                     <h4>Example usage:
         *                     <pre>{@code
         *                                            Item.registerTool("someName", ToolMaterials.DIAMOND, 0.0f, 0.0f, new Item.Settings(), HoeItem::new);
         *                                            }</pre>
         * @return the registered tool.
         */
        public static <T extends net.minecraft.item.Item> T registerTool(String name, ToolMaterial material,
                                                                         float attackDamage, float attackSpeed,
                                                                         net.minecraft.item.Item.Settings settings,
                                                                         IToolFactory<net.minecraft.item.Item.Settings, T> factory)
        {
            RegistryKey<net.minecraft.item.Item> key = getKey(name, RegistryKeys.ITEM);
            T item = factory.apply(material, attackDamage, attackSpeed, settings.registryKey(key));
            T newItem = Registry.register(Registries.ITEM, key, item);
            ALL_ITEMS.get(modID).add(newItem);
            return newItem;
        }

        /**
         * Registers an armor with the given name, material, equipment type, and the given factory.
         * @param name      the name of the armor.
         * @param material  the material of the armor.
         * @param equipment the equipment type of the armor.
         * @param factory   the factory to use to create the armor.
         * @param <T>       the type of the armor.
         *                  <br>
         *                  <h4>Example usage:
         *                  <pre>{@code
         *                                      Item.registerArmor("someName", ArmorMaterial.DIAMOND, EquipmentType.HELMET, ArmorItem::new);
         *                                      }</pre>
         * @return the registered armor.
         */
        public static <T extends net.minecraft.item.Item> T registerArmor(String name, ArmorMaterial material,
                                                                          EquipmentType equipment,
                                                                          IArmorFactory<net.minecraft.item.Item.Settings, T> factory)
        {
            RegistryKey<net.minecraft.item.Item> key = getKey(name, RegistryKeys.ITEM);
            T item = factory.apply(material, equipment, new net.minecraft.item.Item.Settings().registryKey(key));
            T newItem = Registry.register(Registries.ITEM, key, item);
            ALL_ITEMS.get(modID).add(newItem);
            return newItem;
        }

        /**
         * Registers an armor with the given name, material, equipment type, custom settings, and the given factory.
         * @param name      the name of the armor.
         * @param material  the material of the armor.
         * @param equipment the equipment type of the armor.
         * @param settings  the custom settings for the armor.
         * @param factory   the factory to use to create the armor.
         * @param <T>       the type of the armor.
         *                  <br>
         *                  <h4>Example usage:
         *                  <pre>{@code
         *                                      Item.registerArmor("someName", ArmorMaterial.DIAMOND, EquipmentType.HELMET, new Item.Settings(), ArmorItem::new);
         *                                      }</pre>
         * @return the registered armor.
         */
        public static <T extends net.minecraft.item.Item> T registerArmor(String name, ArmorMaterial material,
                                                                          EquipmentType equipment,
                                                                          net.minecraft.item.Item.Settings settings,
                                                                          IArmorFactory<net.minecraft.item.Item.Settings, T> factory)
        {
            RegistryKey<net.minecraft.item.Item> key = getKey(name, RegistryKeys.ITEM);
            T item = factory.apply(material, equipment, settings.registryKey(key));
            T newItem = Registry.register(Registries.ITEM, key, item);
            ALL_ITEMS.get(modID).add(newItem);
            return newItem;
        }

        /**
         * Registers a snack food item with the given name, stack count, nutrition and saturation.
         * @param name       the name of the snack food
         * @param stackCount the stack count of the snack food
         * @param nutrition  the nutrition amount of the snack food
         * @param saturation the saturation amount of the snack food
         * @return the registered snack food item.
         * <br>
         * <h4>Example usage:
         * <pre>{@code
         *    Item.registerSnackFood("someName", 16, 4, 0.55f);
         *    }</pre>
         */
        public static net.minecraft.item.Item registerSnackFood(String name, int stackCount, int nutrition, float saturation)
        {
            RegistryKey<net.minecraft.item.Item> key = getKey(name, RegistryKeys.ITEM);
            net.minecraft.item.Item newItem = Registry.register(Registries.ITEM, key,
                                                                new net.minecraft.item.Item(new net.minecraft.item.Item.Settings()
                                                                                                    .registryKey(key)
                                                                                                    .food(new FoodComponent.Builder()
                                                                                                                  .nutrition(nutrition)
                                                                                                                  .saturationModifier(saturation)
                                                                                                                  .alwaysEdible()
                                                                                                                  .build())
                                                                                                    .maxCount(stackCount)));
            ALL_SNACKS.get(modID).add(newItem);
            ALL_ITEMS.get(modID).add(newItem);
            return newItem;
        }

        /**
         * Registers a new snack food item with the specified properties.
         * @param name       The name of the snack food item to be registered. This serves as the unique identifier.
         * @param stackCount The maximum number of items that can be stacked together in the inventory.
         * @param nutrition  The amount of hunger points restored when the snack food item is consumed.
         * @param saturation The saturation modifier applied when the snack food item is consumed, affecting how long the hunger points last.
         * @param tooltips   A list of tooltips to be displayed when hovering over the snack food item in the inventory, providing additional information.
         * @return The registered snack food item.
         * This method uses the internal registry system to create and register a new snack food item within the game.
         * It ensures that the item has the specified stack size, nutrition value, and saturation effect.
         * Additionally, it attaches the provided tooltips to the item for enhanced user interaction and information.
         */
        public static net.minecraft.item.Item registerSnackFood(String name, int stackCount, int nutrition, float saturation, List<Text> tooltips)
        {
            RegistryKey<net.minecraft.item.Item> key = getKey(name, RegistryKeys.ITEM);
            net.minecraft.item.Item newItem = Registry.register(Registries.ITEM, key,
                                                                new net.minecraft.item.Item(new net.minecraft.item.Item.Settings()
                                                                                                    .registryKey(key)
                                                                                                    .food(new FoodComponent.Builder()
                                                                                                                  .nutrition(nutrition)
                                                                                                                  .saturationModifier(saturation)
                                                                                                                  .alwaysEdible()
                                                                                                                  .build())
                                                                                                    .maxCount(stackCount))
                                                                {
                                                                    @Override
                                                                    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type)
                                                                    {
                                                                        tooltip.addAll(tooltips);
                                                                        super.appendTooltip(stack, context, tooltip, type);
                                                                    }
                                                                });
            ALL_SNACKS.get(modID).add(newItem);
            ALL_ITEMS.get(modID).add(newItem);
            return newItem;
        }

        /**
         * Registers a food item with the given name, stack count, nutrition and saturation.
         * @param name       the name of the food
         * @param stackCount the stack count of the food
         * @param nutrition  the nutrition amount of the food
         * @param saturation the saturation amount of the food
         * @return the registered food item.
         * <br>
         * <h4>Example usage:
         * <pre>{@code
         *    Item.registerFood("someName", 16, 4, 0.55f);
         *    }</pre>
         */
        public static net.minecraft.item.Item registerFood(String name, int stackCount, int nutrition, float saturation)
        {
            RegistryKey<net.minecraft.item.Item> key = getKey(name, RegistryKeys.ITEM);
            net.minecraft.item.Item newItem = Registry.register(Registries.ITEM, key,
                                                                new net.minecraft.item.Item(new net.minecraft.item.Item.Settings()
                                                                                                    .registryKey(key)
                                                                                                    .food(new FoodComponent.Builder()
                                                                                                                  .nutrition(nutrition)
                                                                                                                  .saturationModifier(saturation)
                                                                                                                  .build())
                                                                                                    .maxCount(stackCount)));
            ALL_FOODS.get(modID).add(newItem);
            ALL_ITEMS.get(modID).add(newItem);
            return newItem;
        }

        /**
         * Registers a new food item with the specified properties.
         * @param name       The name of the food item to be registered. This is used as the identifier.
         * @param stackCount The maximum stack size for the food item.
         * @param nutrition  The amount of hunger points restored when the food item is consumed.
         * @param saturation The saturation modifier applied when the food item is consumed.
         * @param tooltips   A list of tooltips to be displayed when hovering over the food item in the inventory.
         * @return The registered food item.
         * This method utilizes the internal registry system to create and register a new food item in the game.
         * It ensures that the item has the specified stack size, nutrition value, and saturation effect.
         * Additionally, it attaches the provided tooltips to the item for enhanced user interaction.
         */
        public static net.minecraft.item.Item registerFood(String name, int stackCount, int nutrition, float saturation, List<Text> tooltips)
        {
            RegistryKey<net.minecraft.item.Item> key = getKey(name, RegistryKeys.ITEM);
            net.minecraft.item.Item newItem = Registry.register(Registries.ITEM, key,
                                                                new net.minecraft.item.Item(new net.minecraft.item.Item.Settings()
                                                                                                    .registryKey(key)
                                                                                                    .food(new FoodComponent.Builder()
                                                                                                                  .nutrition(nutrition)
                                                                                                                  .saturationModifier(saturation)
                                                                                                                  .build())
                                                                                                    .maxCount(stackCount))
                                                                {
                                                                    @Override
                                                                    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type)
                                                                    {
                                                                        tooltip.addAll(tooltips);
                                                                        super.appendTooltip(stack, context, tooltip, type);
                                                                    }
                                                                });
            ALL_FOODS.get(modID).add(newItem);
            ALL_ITEMS.get(modID).add(newItem);
            return newItem;
        }
    }

    /**
     * Registers a new Block Item with the given name and the given factory
     */
    public static class BlockItem
    {
        /**
         * Registers block item for the given block.
         *
         * @param block the block to register block item for
         *
         * @return the registered block item.
         *
         * <br>
         * <h4>Example usage:
         * <pre>{@code
         *    BlockItem.register(ModBlocks.SOME_BLOCK);
         *    }</pre>
         */
        public static net.minecraft.item.BlockItem register(net.minecraft.block.Block block)
        {
            String name = Registries.BLOCK.getId(block).getPath();
            RegistryKey<net.minecraft.item.Item> key = getKey(name, RegistryKeys.ITEM);
            net.minecraft.item.BlockItem newItem = Registry.register(Registries.ITEM, key,
                                                                     new net.minecraft.item.BlockItem(block,
                                                                                                      new net.minecraft.item.Item.Settings()
                                                                                                              .useBlockPrefixedTranslationKey()
                                                                                                              .registryKey(key)));
            ALL_BLOCK_ITEMS.get(modID).add(newItem);
            return newItem;
        }

        /**
         * Registers block item for the given block with the given factory.
         *
         * @param block   the block to register block item for
         * @param factory the factory to use to create the block item.
         * @param <T>     the type of the block item.
         *
         *                <br>
         *                <h4>Example usage:
         *                <pre>{@code
         *                                  BlockItem.register(ModBlocks.SOME_BLOCK, SomeBlockItem::new);
         *                                  }</pre>
         *
         * @return the registered block item.
         */
        public static <T extends net.minecraft.item.BlockItem> T register(net.minecraft.block.Block block,
                                                                          IBlockItemFactory<net.minecraft.item.Item.Settings, T> factory)
        {
            String name = Registries.BLOCK.getId(block).getPath();
            RegistryKey<net.minecraft.item.Item> key = getKey(name, RegistryKeys.ITEM);
            T item = factory.apply(block, new net.minecraft.item.Item.Settings()
                    .useBlockPrefixedTranslationKey()
                    .registryKey(key));
            T newItem = Registry.register(Registries.ITEM, key, item);
            ALL_BLOCK_ITEMS.get(modID).add(newItem);
            return newItem;
        }

        /**
         * Registers block item for the given block with the given factory and custom settings.
         *
         * @param block    the block to register block item for
         * @param settings the custom settings for the block item.
         * @param factory  the factory to use to create the block item.
         * @param <T>      the type of the block item.
         *
         *                 <br>
         *                 <h4>Example usage:
         *                 <pre>{@code
         *                                    BlockItem.register(ModBlocks.SOME_BLOCK, AbstractBlock.Settings.create(), SomeBlockItem::new);
         *                                    }</pre>
         *
         * @return the registered block item.
         */
        public static <T extends net.minecraft.item.BlockItem> T register(net.minecraft.block.Block block,
                                                                          net.minecraft.item.Item.Settings settings,
                                                                          IBlockItemFactory<net.minecraft.item.Item.Settings, T> factory)
        {
            String name = Registries.BLOCK.getId(block).getPath();
            RegistryKey<net.minecraft.item.Item> key = getKey(name, RegistryKeys.ITEM);
            T item = factory.apply(block, settings
                    .useBlockPrefixedTranslationKey()
                    .registryKey(key));
            T newItem = Registry.register(Registries.ITEM, key, item);
            ALL_BLOCK_ITEMS.get(modID).add(newItem);
            return newItem;
        }
    }

    /**
     * Registers the new Recipe Serializer and Recipe Type
     */
    public static class Recipe
    {
        Recipe()
        {
            throw new AssertionError();
        }

        //TODO: Add usage example to java doc

        /**
         * Registers the serializer for a custom recipe with the provided name and recipe serializer
         *
         * @param name       the name of the recipe serializer.
         * @param serializer the recipe serializer.
         *
         * @return the registered recipe serializer.
         */
        public static RecipeSerializer<?> register(String name, RecipeSerializer<?> serializer)
        {
            RegistryKey<RecipeSerializer<?>> key = getKey(name, RegistryKeys.RECIPE_SERIALIZER);
            RecipeSerializer<?> result = Registry.register(Registries.RECIPE_SERIALIZER, key, serializer);
            ALL_RECIPE_SERIALIZERS.get(modID).add(result);
            return result;
        }

        //TODO: Add usage example to java doc

        /**
         * Registers the recipe type for a custom recipe with the provided name and the recipe type.
         *
         * @param name       the name of the recipe type.
         * @param recipeType the recipe type.
         *
         * @return the registered recipe type.
         */
        public static RecipeType<?> register(String name, RecipeType<?> recipeType)
        {
            RegistryKey<RecipeType<?>> key = getKey(name, RegistryKeys.RECIPE_TYPE);
            var result = Registry.register(Registries.RECIPE_TYPE, key, recipeType);
            ALL_RECIPE_TYPES.get(modID).add(result);
            return result;
        }
    }

    /**
     * Registers Custom Component Types
     */
    public static class ComponentType
    {
        ComponentType()
        {
            throw new AssertionError();
        }

        /**
         * Registers the new custom data component type with the given name and provided builder operation factory
         *
         * @param name          the name of the custom data component type.
         * @param buildOperator the builder operation factory
         * @param <T>           the type of the custom data component type.
         *
         *                      <br>
         *                      <h4>Example usage:
         *                      <pre>{@code
         *                         ComponentType.register("some_name", builder -> builder.codec(SomeRecord.CODEC));
         *                         }</pre>
         *
         * @return the registered custom data component type.
         */
        public static <T> net.minecraft.component.ComponentType<T> register(String name,
                                                                            UnaryOperator<net.minecraft.component.ComponentType.Builder<T>> buildOperator)
        {
            RegistryKey<net.minecraft.component.ComponentType<?>> key = getKey(name, RegistryKeys.DATA_COMPONENT_TYPE);
            return Registry.register(Registries.DATA_COMPONENT_TYPE, key,
                                     buildOperator.apply(net.minecraft.component.ComponentType.builder()).build());
        }
    }

    /**
     * Registers Custom Status Effects
     */
    public static class StatusEffect
    {
        /**
         * Registers a new status effect with the specified name, category, and color.
         *
         * @param name The name of the status effect to be registered.
         * @param category The category of the status effect, which determines its behavior and application.
         * @param color The color associated with the status effect, typically used for display purposes.
         * @param factory A factory function that creates a new instance of the status effect using the provided category and color.
         * @return A `RegistryEntry` representing the registered status effect.
         */
        public static RegistryEntry<net.minecraft.entity.effect.StatusEffect> register(String name, StatusEffectCategory category, int color,
                                                           BiFunction<StatusEffectCategory, Integer, net.minecraft.entity.effect.StatusEffect> factory)
        {
            RegistryKey<net.minecraft.entity.effect.StatusEffect> key = getKey(name, RegistryKeys.STATUS_EFFECT);
            net.minecraft.entity.effect.StatusEffect effect = factory.apply(category, color);
            RegistryEntry<net.minecraft.entity.effect.StatusEffect> newEffect = Registry.registerReference(Registries.STATUS_EFFECT, key, effect);
            ALL_EFFECTS.get(modID).add(newEffect);
            return newEffect;
        }
    }

    /**
     * Helper methods for datagen ore and model registration
     */
    public static class Datagen
    {
        Datagen()
        {
            throw new AssertionError();
        }

        /**
         * Registers all the armor provided inside the array list using the same material
         *
         * @param generator the item model generator
         * @param items     the list of all the armor items
         * @param material  the armor material to use
         *
         *                  <br>
         *                  <h4>Example usage:
         *                  <pre>{@code
         *                                      Datagen.registerAllArmor(generator, {ModItems.HELMET, ModItems.CHESTPLATE, ModItems.LEGGINGS, ModItems.BOOTS}, ArmorMaterial.DIAMOND);
         *                                      }</pre>
         */
        public static void registerAllArmor(ItemModelGenerator generator, net.minecraft.item.Item[] items, ArmorMaterial material)
        {
            for (net.minecraft.item.Item item : items)
            {
                EquipmentSlot slot = Objects.requireNonNull(item.getComponents().get(DataComponentTypes.EQUIPPABLE)).slot();
                if (slot != null && slot.isArmorSlot())
                    registerArmor(generator, item, material, slot);
            }
        }

        /**
         * Registers a single Armor Item type for the item model generator
         *
         * @param generator the item model generator
         * @param item      the armor item to generate the model for
         * @param material  the armor material to use
         * @param slot      the armor equipment slot
         *
         *                  <br>
         *                  <h4>Example usage:
         *                  <pre>{@code
         *                     Datagen.registerArmor(generator, ModItems.HELMET, ArmorMaterial.DIAMOND, EquipmentSlot.HEAD);
         *                     }</pre>
         */
        public static void registerArmor(ItemModelGenerator generator, net.minecraft.item.Item item, ArmorMaterial material, EquipmentSlot slot)
        {
            Identifier id = material.modelId();
            generator.registerArmor(item, material.modelId(),
                                    slot == EquipmentSlot.BODY
                                    ? Registers.Datagen.buildHumanoidAndHorse(id.getPath())
                                    : Registers.Datagen.buildHumanoid(id.getPath())
                    , slot);
        }

        /**
         * Generated the ore drop for loot table provider.
         * This method should be called from the loot table provider datagen class directly.
         *
         * @param provider   the loot table provider.
         * @param registries the registries of the loot table provider.
         * @param drop       the block that should drop the ore items
         * @param item       the ore items that should drop
         * @param min        the minimum number of items that should drop
         * @param max        the maximum number of items that should drop
         *
         * @return the builder for the loot table provider
         *
         * <br>
         * <h4>Example usage:
         * <pre>{@code
         *    Datagen.customOreDrops(this, this.registries, ModBlocks.SOME_BLOCK, ModItems.SOME_ITEM, 1.0f, 3.0f);
         *    }</pre>
         */
        public static LootTable.Builder customOreDrops(FabricBlockLootTableProvider provider, RegistryWrapper.WrapperLookup registries, net.minecraft.block.Block drop, net.minecraft.item.Item item, float min, float max)
        {
            RegistryWrapper.Impl<Enchantment> impl = registries.getOrThrow(RegistryKeys.ENCHANTMENT);
            return provider.dropsWithSilkTouch(drop,
                                               provider.applyExplosionDecay(drop,
                                                                            (ItemEntry.builder(item)
                                                                                      .apply(SetCountLootFunction
                                                                                                     .builder(UniformLootNumberProvider
                                                                                                                      .create(min, max))))
                                                                                    .apply(ApplyBonusLootFunction
                                                                                                   .oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
        }

        /**
         * Generated the ore drop for loot table provider. Uses the default minimum and maximum as 2 and 5.
         * This method should be called from the loot table provider datagen class directly.
         *
         * @param provider   the loot table provider.
         * @param registries the registries of the loot table provider.
         * @param drop       the block that should drop the ore items
         * @param item       the ore items that should drop
         *
         * @return the builder for the loot table provider
         *
         * <br>
         * <h4>Example usage:
         * <pre>{@code
         *    Datagen.customOreDrops(this, this.registries, ModBlocks.SOME_BLOCK, ModItems.SOME_ITEM);
         *    }</pre>
         */
        public static LootTable.Builder customOreDrops(FabricBlockLootTableProvider provider, RegistryWrapper.WrapperLookup registries, net.minecraft.block.Block drop, net.minecraft.item.Item item)
        {
            return customOreDrops(provider, registries, drop, item, 2.0f, 5.0f);
        }

        /**
         * Directly registers the model for a block with orientable model type using the provided property for variants/
         *
         * @param generator the block state model generator.
         * @param machine   the block to generate model for.
         * @param property  the property to use for model variants.
         *
         *                  <br>
         *                  <h4>Example usage:
         *                  <pre>{@code
         *                     Datagen.registerOrientableVariantBlock(generator, ModBlocks.SOME_BLOCK, SomeBlock.SOME_PROPERTY);
         *                     }</pre>
         */
        @SuppressWarnings("SameParameterValue")
        public static void registerOrientableVariantBlock(BlockStateModelGenerator generator, net.minecraft.block.Block machine, BooleanProperty property)
        {
            BiConsumer<Identifier, Supplier<JsonElement>> modelCollector = generator.modelCollector;
            Identifier machineOff = TexturedModel.ORIENTABLE.upload(machine, modelCollector);
            Identifier machineFront = TextureMap.getSubId(machine, "_front_on");
            Identifier machineOn = TexturedModel.ORIENTABLE.get(machine).textures((textures) ->
                                                                                  {
                                                                                      textures.put(TextureKey.FRONT, machineFront);
                                                                                  }).upload(machine, "_on", modelCollector);
            generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(machine)
                                                                           .coordinate(BlockStateModelGenerator.createBooleanModelMap(property,
                                                                                                                                      machineOn,
                                                                                                                                      machineOff))
                                                                           .coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates()));
        }

        /**
         * Directly registers the model for a block with cube all model type using the provided property for variants/
         *
         * @param generator the block state model generator.
         * @param machine   the block to generate model for.
         * @param property  the property to use for model variants.
         *
         *                  <br>
         *                  <h4>Example usage:
         *                  <pre>{@code
         *                     Datagen.registerOrientableVariantBlock(generator, ModBlocks.SOME_BLOCK, SomeBlock.SOME_PROPERTY);
         *                     }</pre>
         */
        @SuppressWarnings("SameParameterValue")
        public static void registerCubeVariantBlock(BlockStateModelGenerator generator, net.minecraft.block.Block machine, BooleanProperty property)
        {
            BiConsumer<Identifier, Supplier<JsonElement>> modelCollector = generator.modelCollector;
            Identifier cubeOff = TexturedModel.CUBE_ALL.upload(machine, modelCollector);
            Identifier cubeOn = generator.createSubModel(machine, "_on", Models.CUBE_ALL, TextureMap::all);
            generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(machine)
                                                                           .coordinate(BlockStateModelGenerator.createBooleanModelMap(property,
                                                                                                                                      cubeOn,
                                                                                                                                      cubeOff)));
        }

        /**
         * Generate the humanoid armor equipment models for armor item model generator.
         *
         * @param name the name of the armor material.
         *
         * @return the equipment model for the armor material.
         *
         * <br>
         * <h4>Example usage:
         * <pre>{@code
         *    Datagen.buildHumanoid("emerald");
         *    }</pre>
         */
        public static EquipmentModel buildHumanoid(String name)
        {
            return EquipmentModel.builder().addHumanoidLayers(identifier(name)).build();
        }

        /**
         * Generate the humanoid and horse armor equipment models for armor item model generator.
         *
         * @param name the name of the armor material.
         *
         * @return the equipment model for the armor material.
         *
         * <br>
         * <h4>Example usage:
         * <pre>{@code
         *    Datagen.buildHumanoidAndHorse("emerald");
         *    }</pre>
         */
        public static EquipmentModel buildHumanoidAndHorse(String name)
        {
            return EquipmentModel.builder()
                                 .addHumanoidLayers(identifier(name))
                                 .addLayers(EquipmentModel.LayerType.HORSE_BODY,
                                            EquipmentModel.Layer
                                                    .createDyeableLeather(identifier(name), false))
                                 .build();
        }

        /**
         * Registers a placed feature with the given parameters.
         * This method is used internally to register a placed feature with a specific
         * configuration and placement modifiers.
         *
         * @param context      The `Registerable` context used to register the placed feature.
         * @param key          The registry key for the placed feature.
         * @param configuration The configuration entry for the feature.
         * @param modifiers    The list of placement modifiers to apply to the feature.
         */
        public static void register(Registerable<PlacedFeature> context,
                                    RegistryKey<PlacedFeature> key,
                                    RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                    List<PlacementModifier> modifiers)
        {
            context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
        }

        /**
         * Registers a placed feature with the given parameters.
         * This overloaded method allows for a variable number of placement modifiers.
         *
         * @param context      The `Registerable` context used to register the placed feature.
         * @param key          The registry key for the placed feature.
         * @param configuration The configuration entry for the feature.
         * @param modifiers    The placement modifiers to apply to the feature.
         */
        public static void register(Registerable<PlacedFeature> context,
                                     RegistryKey<PlacedFeature> key,
                                     RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                     PlacementModifier... modifiers)
        {
            register(context, key, configuration, List.of(modifiers));
        }

        /**
         * Registers a configured feature with the given parameters.
         * This method creates a new `ConfiguredFeature` instance and registers it
         * with the specified registry context using the provided key, feature, and
         * configuration.
         *
         * @param context      The registry context used to register the configured feature.
         * @param key          The unique registry key for the configured feature.
         * @param feature      The feature to be configured and registered.
         * @param configuration The configuration for the feature.
         * @param <FC>         The type of the feature configuration.
         * @param <F>          The type of the feature.
         */
        public static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                       RegistryKey<ConfiguredFeature<?, ?>> key,
                                                                                       F feature, FC configuration)
        {
            context.register(key, new ConfiguredFeature<>(feature, configuration));
        }

        /**
         * Creates a list of {@link PlacementModifier} instances for ore placement.
         * The list includes a count modifier, a square placement modifier, a height modifier,
         * and a biome placement modifier.
         *
         * @param countModifier the {@link PlacementModifier} that specifies the count of ore placements.
         * @param heightModifier the {@link PlacementModifier} that specifies the height range for ore placements.
         * @return a list of {@link PlacementModifier} instances for ore placement.
         */
        public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier)
        {
            return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
        }

        /**
         * Creates a list of {@link PlacementModifier} instances for ore placement with a specified count.
         * This method uses a {@link CountPlacementModifier} to specify the number of ore placements.
         *
         * @param count the number of ore placements.
         * @param heightModifier the {@link PlacementModifier} that specifies the height range for ore placements.
         * @return a list of {@link PlacementModifier} instances for ore placement.
         */
        public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier)
        {
            return modifiers(CountPlacementModifier.of(count), heightModifier);
        }

        /**
         * Creates a list of {@link PlacementModifier} instances for ore placement with a specified rarity.
         * This method uses a {@link RarityFilterPlacementModifier} to specify the chance of ore placement.
         *
         * @param chance the chance of ore placement, where a lower value indicates higher rarity.
         * @param heightModifier the {@link PlacementModifier} that specifies the height range for ore placements.
         * @return a list of {@link PlacementModifier} instances for ore placement.
         */
        public static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier)
        {
            return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
        }
    }
}