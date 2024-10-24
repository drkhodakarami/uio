package jiraiyah.uio.util;

import jiraiyah.uio.util.interfaces.ArmorRegisterFunction;
import jiraiyah.uio.util.interfaces.BlockItemRegisterFunction;
import jiraiyah.uio.util.interfaces.ToolRegisterFunction;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.component.ComponentType;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentModel;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
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

    public static List<Item> getAllItems(String modID)
    {
        return Registries.ITEM.getEntrySet()
                              .stream()
                              .filter(key -> key.getKey().getValue().getNamespace().equals(modID))
                              .map(Map.Entry::getValue)
                              .collect(Collectors.toList());
    }

    public static List<Block> getAllBlocks(String modID)
    {
        return Registries.BLOCK.getEntrySet()
                               .stream()
                               .filter(key -> key.getKey().getValue().getNamespace().equals(modID))
                               .map(Map.Entry::getValue)
                               .collect(Collectors.toList());
    }

    //TODO: The new way for registering Items and Blocks in 1.21.2 needs the key
    public static RegistryKey<Item> getItemKey(String name)
    {
        return RegistryKey.of(RegistryKeys.ITEM, identifier(name));
    }

    public static RegistryKey<Block> getBlockKey(String name)
    {
        return RegistryKey.of(RegistryKeys.BLOCK, identifier(name));
    }

    public static class Blocks
    {
        Blocks()
        {
            throw new AssertionError();
        }

        //TODO: The new way of registering items in 1.21.2
        //Knowledge Base: Functional Programming & Factory Design Pattern
        //Thanks to ZeroNoRyouki for the help with the factory design pattern
        public static <T extends Block> T register(String name, Function<AbstractBlock.Settings, T> factory)
        {
            T block = factory.apply(AbstractBlock.Settings.create().registryKey(getBlockKey(name)));
            return Registry.register(Registries.BLOCK, getBlockKey(name), block);
        }

        //Thanks to ZeroNoRyouki for the help with the factory design pattern
        public static <T extends Block> T register(String name, Block blockCopy, Function<AbstractBlock.Settings, T> factory)
        {
            T block = factory.apply(AbstractBlock.Settings.copy(blockCopy).registryKey(getBlockKey(name)));
            return Registry.register(Registries.BLOCK, getBlockKey(name), block);
        }

        //Thanks to ZeroNoRyouki for the help with the factory design pattern
        public static <T extends Block> T register(String name, Function<AbstractBlock.Settings, T> factory, AbstractBlock.Settings settings)
        {
            T block = factory.apply(settings.registryKey(getBlockKey(name)));
            return Registry.register(Registries.BLOCK, getBlockKey(name), block);
        }

        public static Block register(String name)
        {
            return register(name, Block::new);
        }

        public static Block register(String name, AbstractBlock.Settings settings)
        {
            return register(name, Block::new, settings);
        }

        public static <T extends Block> T registerSimple(String name, T block)
        {
            RegistryKey<Block> key = getBlockKey(name);
            return Registry.register(Registries.BLOCK, key , block);
        }

        //region OVERLOADS & HELPERS
        public static StairsBlock registerStair(String name, Block block, Block copyBlock)
        {
            return registerSimple(name, new StairsBlock(block.getDefaultState(),
                                             AbstractBlock.Settings.copy(copyBlock)
                                                                   .registryKey(Registers.getBlockKey(name))));
        }

        public static SlabBlock registerSlab(String name, Block copyBlock)
        {
            return registerSimple(name, new SlabBlock(AbstractBlock.Settings.copy(copyBlock)
                                                                      .registryKey(Registers.getBlockKey(name))));
        }

        public static ButtonBlock registerButton(String name, BlockSetType blockType, int pressureTicks, Block copyBlock)
        {
            return registerSimple(name, new ButtonBlock(blockType, pressureTicks,
                                                  AbstractBlock.Settings.copy(copyBlock)
                                                                        .registryKey(Registers.getBlockKey(name))));
        }

        public static PressurePlateBlock registerPressurePlate(String name, BlockSetType blockType, Block copyBlock)
        {
            return registerSimple(name, new PressurePlateBlock(blockType, AbstractBlock.Settings.copy(copyBlock)
                                                                        .registryKey(Registers.getBlockKey(name))));
        }

        public static FenceBlock registerFence(String name, Block copyBlock)
        {
            return registerSimple(name, new FenceBlock(AbstractBlock.Settings.copy(copyBlock)
                                                                       .registryKey(Registers.getBlockKey(name))));
        }

        public static FenceGateBlock registerFenceGate(String name, WoodType woodType, Block copyBlock)
        {
            return registerSimple(name, new FenceGateBlock(woodType, AbstractBlock.Settings.copy(copyBlock)
                                                                       .registryKey(Registers.getBlockKey(name))));
        }

        public static WallBlock registerWall(String name, Block copyBlock)
        {
            return registerSimple(name, new WallBlock(AbstractBlock.Settings.copy(copyBlock)
                                                                       .registryKey(Registers.getBlockKey(name))));
        }

        public static DoorBlock registerDoor(String name, BlockSetType blockType, Block copyBlock)
        {
            return registerSimple(name, new DoorBlock(blockType, AbstractBlock.Settings.copy(copyBlock)
                                                                      .registryKey(Registers.getBlockKey(name))));
        }

        public static TrapdoorBlock registerTrapdoor(String name, BlockSetType blockType, Block copyBlock)
        {
            return registerSimple(name, new TrapdoorBlock(blockType, AbstractBlock.Settings.copy(copyBlock)
                                                                     .registryKey(Registers.getBlockKey(name))));
        }
        //endregion
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
        //TODO: The new way of registering new Items in 1.21.2
        public static Item register(String name)
        {
            return Registry.register(Registries.ITEM, identifier(name),
                                     new Item(new Item.Settings()
                                                      .registryKey(getItemKey(name))));
        }

        public static Item register(String name, int stackCount)
        {
            return Registry.register(Registries.ITEM, identifier(name),
                                     new Item(new Item.Settings()
                                                      .registryKey(getItemKey(name))
                                                      .maxCount(stackCount)));
        }

        public static <T extends Item> T register(String name, int stackCount, Function<Item.Settings, T> factory)
        {
            T item = factory.apply(new Item.Settings().registryKey(getItemKey(name)).maxCount(stackCount));
            return Registry.register(Registries.ITEM, getItemKey(name), item);
        }

        public static BlockItem registerBI(Block block)
        {
            String name = Registries.BLOCK.getId(block).getPath();

            return Registry.register(Registries.ITEM, identifier(name),
                                     new BlockItem(block, new Item.Settings()
                                             .useBlockPrefixedTranslationKey()
                                             .registryKey(getItemKey(name))));
        }

        public static <T extends BlockItem> T registerBI(Block block, BlockItemRegisterFunction<Item.Settings, T> factory)
        {
            String name = Registries.BLOCK.getId(block).getPath();
            T item = factory.apply(block, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(getItemKey(name)));
            return Registry.register(Registries.ITEM, getItemKey(name), item);
        }

        public static <T extends Item> T registerTool(String name, ToolMaterial material, float attackDamage, float attackSpeed, ToolRegisterFunction<Item.Settings, T> factory)
        {
            T item = factory.apply(material, attackDamage, attackSpeed, new Item.Settings().registryKey(getItemKey(name)));
            return Registry.register(Registries.ITEM, getItemKey(name), item);
        }

        public static <T extends Item> T registerArmor(String name, ArmorMaterial material, EquipmentType equipment, ArmorRegisterFunction<Item.Settings, T> factory)
        {
            T item = factory.apply(material, equipment, new Item.Settings().registryKey(getItemKey(name)));
            return Registry.register(Registries.ITEM, getItemKey(name), item);
        }

        //TODO: Helper method for registering snaks (isSnack -> alwaysEdible)
        public static Item registerSnackFood(String name, int stackCount, int nutrition, float saturation)
        {
            return Registry.register(Registries.ITEM, identifier(name),
                                     new Item(new Item.Settings()
                                                      .registryKey(getItemKey(name))
                                                      .food(new FoodComponent.Builder()
                                                                    .nutrition(nutrition)
                                                                    .saturationModifier(saturation)
                                                                    .alwaysEdible()
                                                                    .build())
                                                      .maxCount(stackCount)));
        }

        //TODO: Helper method for registering Food
        public static Item registerFood(String name, int stackCount, int nutrition, float saturation)
        {
            return Registry.register(Registries.ITEM, identifier(name),
                                     new Item(new Item.Settings()
                                                      .registryKey(getItemKey(name))
                                                      .food(new FoodComponent.Builder()
                                                                    .nutrition(nutrition)
                                                                    .saturationModifier(saturation)
                                                                    .build())
                                                      .maxCount(stackCount)));
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

    /*public static class ArmorMaterials
    {
        ArmorMaterials()
        {
            throw new AssertionError();
        }

        public static RegistryEntry<ArmorMaterial> register(String id, EnumMap<EquipmentType, Integer> defense, int enchantability,
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
    }*/

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

    public static class Datagen
    {
        public static void registerArmor(ItemModelGenerator generator, Item item, ArmorMaterial material, EquipmentSlot slot)
        {
            Identifier id = material.modelId();
            generator.registerArmor(item, material.modelId(),
                                    Registers.Datagen.buildHumanoid(id.getPath()), slot);
        }

        public static LootTable.Builder customOreDrops(FabricBlockLootTableProvider provider, RegistryWrapper.WrapperLookup registries, Block drop, Item item, float min, float max)
        {
            //TODO: registryLookup.getWrapperOrThrow -> registries.getOrThrow for 1.21.2 the lookup became optional
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

        public static LootTable.Builder customOreDrops(FabricBlockLootTableProvider provider, RegistryWrapper.WrapperLookup registries, Block drop, Item item)
        {
            return customOreDrops(provider, registries, drop, item, 2.0f, 5.0f);
        }

        public static EquipmentModel buildHumanoid(String name) {
            return EquipmentModel.builder().addHumanoidLayers(identifier(name)).build();
        }

        private static EquipmentModel buildHumanoidAndHorse(String name) {
            return EquipmentModel.builder()
                                 .addHumanoidLayers(identifier(name))
                                 .addLayers(EquipmentModel.LayerType.HORSE_BODY,
                                            EquipmentModel.Layer
                                                            .createDyeableLeather(identifier(name), false))
                                 .build();
        }
    }
}