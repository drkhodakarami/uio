package jiraiyah.uio.util;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.component.ComponentType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import static jiraiyah.uio.Reference.identifier;

@SuppressWarnings("unused")
public class Registers
{
    Registers()
    {
        throw new AssertionError();
    }

    public static class Blocks
    {
        Blocks()
        {
            throw new AssertionError();
        }

        public static <T extends Block> T register(String name, T block, boolean hasItem)
        {
            if (hasItem)
                registerBlockItem(name, block);
            return Registry.register(Registries.BLOCK, identifier(name), block);
        }

        public static <T extends Block> T register(String name, T block)
        {
            return register(name, block, true);
        }

        public static <T extends Block> T registerBlock(String name, T block)
        {
            return register(name, block, false);
        }

        public static <T extends Block> T register(String name, T block, BlockItem blockItem)
        {
            Registry.register(Registries.ITEM, identifier(name), blockItem);
            return Registry.register(Registries.BLOCK, identifier(name), block);
        }

        public static Block register(String name, boolean hasItem)
        {
            return register(name, new Block(AbstractBlock.Settings.create()), hasItem);
        }

        public static Block register(String name, AbstractBlock.Settings settings, boolean hasItem)
        {
            return register(name, new Block(settings), hasItem);
        }

        public static Block register(String name, AbstractBlock.Settings settings)
        {
            return register(name, new Block(settings), true);
        }

        public static Block register(String name)
        {
            return register(name, new Block(AbstractBlock.Settings.create()), true);
        }

        public static Block register(String name, BlockItem blockItem)
        {
            Registry.register(Registries.ITEM, identifier(name), blockItem);
            return Registry.register(Registries.BLOCK, identifier(name),
                                     new Block(AbstractBlock.Settings.create()));
        }

        public static Block registerBlock(String name)
        {
            return register(name, new Block(AbstractBlock.Settings.create()), false);
        }

        public static Block registerBlockCopy(String name, Block block)
        {
            return register(name, new Block(AbstractBlock.Settings.copy(block)), false);
        }

        public static Block registerCopy(String name, Block block, boolean hasItem)
        {
            return register(name, new Block(AbstractBlock.Settings.copy(block)), hasItem);
        }

        public static Block registerCopy(String name, Block block)
        {
            return register(name, new Block(AbstractBlock.Settings.copy(block)), true);
        }

        public static Block registerCopy(String name, Block block, BlockItem blockItem)
        {
            Registry.register(Registries.ITEM, identifier(name), blockItem);
            return Registry.register(Registries.BLOCK, identifier(name),
                                     new Block(AbstractBlock.Settings.copy(block)));
        }

        public static void registerBlockItem(String name, Block block)
        {
            Registry.register(Registries.ITEM, identifier(name),
                              new BlockItem(block, new net.minecraft.item.Item.Settings()));
        }

        public static List<Block> getAllBlocks(String modID)
        {
            return Registries.BLOCK.getEntrySet()
                            .stream()
                            .filter(key -> key.getKey().getValue().getNamespace().equals(modID))
                            .map(Map.Entry::getValue)
                            .collect(Collectors.toList());
        }
    }

    public static class BlockEntities
    {
        BlockEntities()
        {
            throw new AssertionError();
        }

        public static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> type)
        {
            return Registry.register(Registries.BLOCK_ENTITY_TYPE, identifier(name), type);
        }
    }

    public static class Items
    {
        Items()
        {
            throw new AssertionError();
        }

        public static <T extends Item> T register(String name, T item)
        {
            return Registry.register(Registries.ITEM, identifier(name), item);
        }

        public static Item register(String name)
        {
            return Registry.register(Registries.ITEM, identifier(name),
                                     new Item(new Item.Settings()));
        }

        public static Item register(String name, Item.Settings settings)
        {
            return Registry.register(Registries.ITEM, identifier(name), new Item(settings));
        }

        public static Item registerBlockItem(String name, BlockItem blockitem)
        {
            return Registry.register(Registries.ITEM, identifier(name),blockitem);
        }

        public static List<Item> getAllItems(String modID)
        {
            return Registries.ITEM.getEntrySet()
                                   .stream()
                                   .filter(key -> key.getKey().getValue().getNamespace().equals(modID))
                                   .map(Map.Entry::getValue)
                                   .collect(Collectors.toList());
        }
    }

    public static class Recipes
    {
        Recipes()
        {
            throw new AssertionError();
        }

        public static void register(String name, RecipeSerializer<?> serializer)
        {
            Registry.register(Registries.RECIPE_SERIALIZER, identifier(name), serializer);
        }

        public static void register(String name, RecipeType<?> recipeType)
        {
            Registry.register(Registries.RECIPE_TYPE, identifier(name), recipeType);
        }
    }

    public static class ArmorMaterials
    {
        ArmorMaterials()
        {
            throw new AssertionError();
        }

        public static RegistryEntry<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability,
                                                            RegistryEntry<SoundEvent> equipSound,
                                                            float toughness, float knockbackResistance,
                                                            Supplier<Ingredient> repairIngredient)
        {
            List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(identifier(id)));
            return register(id, defense, enchantability, equipSound, toughness, knockbackResistance, repairIngredient, list);
        }

        public static RegistryEntry<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability,
                                                                                RegistryEntry<SoundEvent> equipSound,
                                                                                float toughness, float knockbackResistance,
                                                                                Supplier<Ingredient> repairIngredient,
                                                                                List<ArmorMaterial.Layer> layers)
        {
            EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap<>(ArmorItem.Type.class);
            for (ArmorItem.Type type : ArmorItem.Type.values())
            {
                enumMap.put(type, defense.get(type));
            }
            return Registry.registerReference(Registries.ARMOR_MATERIAL, identifier(id),
                                              new net.minecraft.item.ArmorMaterial(enumMap, enchantability, equipSound,
                                                           repairIngredient, layers, toughness, knockbackResistance));
        }
    }

    public static class ComponentTypes
    {
        public static <T>ComponentType<T> register(String name,
                                                               UnaryOperator<ComponentType.Builder<T>> buildOperator)
        {
            return Registry.register(Registries.DATA_COMPONENT_TYPE,
                                         identifier(name),
                                         buildOperator.apply(ComponentType.builder())
                                    .build());
        }
    }
}