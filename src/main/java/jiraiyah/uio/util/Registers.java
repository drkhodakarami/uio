package jiraiyah.uio.util;

import jiraiyah.uio.util.interfaces.ArmorRegisterFunction;
import jiraiyah.uio.util.interfaces.BlockItemRegisterFunction;
import jiraiyah.uio.util.interfaces.ToolRegisterFunction;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.component.ComponentType;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnGroup;
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
import org.spongepowered.asm.mixin.injection.invoke.arg.ArgumentCountException;

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

    //Thanks to TurtyWurty for the code snippet for generating the RegistryKey
    public static <T> RegistryKey<T> getKey(String name, RegistryKey<? extends Registry<T>> registryKey)
    {
        return RegistryKey.of(registryKey, identifier(name));
    }

    public static class Blocks
    {
        Blocks()
        {
            throw new AssertionError();
        }

        public static Block register(String name)
        {
            return register(name, Block::new);
        }

        public static Block register(String name, Block blockCopy)
        {
            return register(name, blockCopy, Block::new);
        }

        public static Block register(String name, AbstractBlock.Settings settings)
        {
            return register(name, settings, Block::new);
        }

        public static <T extends Block> T registerSimple(String name, T block)
        {
            RegistryKey<Block> key = getKey(name, RegistryKeys.BLOCK);
            return Registry.register(Registries.BLOCK, key , block);
        }

        //Knowledge Base: Functional Programming & Factory Design Pattern
        //Thanks to ZeroNoRyouki for the help with the factory design pattern and mentioning that this approach is usable
        public static <T extends Block> T register(String name,
                                                   Function<AbstractBlock.Settings, T> factory)
        {
            RegistryKey<Block> key = getKey(name, RegistryKeys.BLOCK);
            T block = factory.apply(AbstractBlock.Settings.create().registryKey(key));
            return Registry.register(Registries.BLOCK, key, block);
        }

        public static <T extends Block> T register(String name, Block blockCopy,
                                                   Function<AbstractBlock.Settings, T> factory)
        {
            RegistryKey<Block> key = getKey(name, RegistryKeys.BLOCK);
            T block = factory.apply(AbstractBlock.Settings.copy(blockCopy).registryKey(key));
            return Registry.register(Registries.BLOCK, key, block);
        }

        public static <T extends Block> T register(String name, AbstractBlock.Settings settings,
                                                   Function<AbstractBlock.Settings, T> factory)
        {
            RegistryKey<Block> key = getKey(name, RegistryKeys.BLOCK);
            T block = factory.apply(settings.registryKey(key));
            return Registry.register(Registries.BLOCK, key, block);
        }

        //region HELPERS
        public static StairsBlock registerStair(String name, Block block, Block copyBlock)
        {
            RegistryKey<Block> key = getKey(name, RegistryKeys.BLOCK);
            return registerSimple(name,
                          new StairsBlock(block.getDefaultState(),
                                         AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
        }

        public static SlabBlock registerSlab(String name, Block copyBlock)
        {
            RegistryKey<Block> key = getKey(name, RegistryKeys.BLOCK);
            return registerSimple(name,
                          new SlabBlock(AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
        }

        public static ButtonBlock registerButton(String name, BlockSetType blockType, int pressureTicks, Block copyBlock)
        {
            RegistryKey<Block> key = getKey(name, RegistryKeys.BLOCK);
            return registerSimple(name,
                          new ButtonBlock(blockType, pressureTicks,
                                          AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
        }

        public static PressurePlateBlock registerPressurePlate(String name, BlockSetType blockType, Block copyBlock)
        {
            RegistryKey<Block> key = getKey(name, RegistryKeys.BLOCK);
            return registerSimple(name,
                          new PressurePlateBlock(blockType, AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
        }

        public static FenceBlock registerFence(String name, Block copyBlock)
        {
            RegistryKey<Block> key = getKey(name, RegistryKeys.BLOCK);
            return registerSimple(name,
                          new FenceBlock(AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
        }

        public static FenceGateBlock registerFenceGate(String name, WoodType woodType, Block copyBlock)
        {
            RegistryKey<Block> key = getKey(name, RegistryKeys.BLOCK);
            return registerSimple(name,
                          new FenceGateBlock(woodType,
                                         AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
        }

        public static WallBlock registerWall(String name, Block copyBlock)
        {
            RegistryKey<Block> key = getKey(name, RegistryKeys.BLOCK);
            return registerSimple(name,
                          new WallBlock(AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
        }

        public static DoorBlock registerDoor(String name, BlockSetType blockType, Block copyBlock)
        {
            RegistryKey<Block> key = getKey(name, RegistryKeys.BLOCK);
            return registerSimple(name,
                          new DoorBlock(blockType,
                                            AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
        }

        public static TrapdoorBlock registerTrapdoor(String name, BlockSetType blockType, Block copyBlock)
        {
            RegistryKey<Block> key = getKey(name, RegistryKeys.BLOCK);
            return registerSimple(name,
                          new TrapdoorBlock(blockType,
                                            AbstractBlock.Settings.copy(copyBlock).registryKey(key)));
        }
        //endregion
    }

    public static class Entities
    {
        Entities()
        {
            throw new AssertionError();
        }

        public static <T extends BlockEntity> BlockEntityType<T> register(String name, Block block,
                                                                          FabricBlockEntityTypeBuilder. Factory<T> factory)
        {
            RegistryKey<BlockEntityType<?>> key = getKey(name, RegistryKeys.BLOCK_ENTITY_TYPE);
            BlockEntityType<T> beType = FabricBlockEntityTypeBuilder.create(factory, block).build(null);
            return Registry.register(Registries.BLOCK_ENTITY_TYPE, key, beType);
        }

        public static <T extends Entity> EntityType<T> register(String name, EntityType.EntityFactory<T> factory)
        {
            RegistryKey<EntityType<?>> key = getKey(name, RegistryKeys.ENTITY_TYPE);
            EntityType<T> entityType = EntityType.Builder.<T>create(factory, SpawnGroup.MISC).build(key);
            return Registry.register(Registries.ENTITY_TYPE, key, entityType);
        }
    }

    public static class Items
    {
        public static Item register(String name)
        {
            return register(name, Item::new);
        }

        public static Item register(String name, int stackCount)
        {
            return register(name, stackCount, Item::new);
        }

        public static <T extends Item> T register(String name, Function<Item.Settings, T> factory)
        {
            RegistryKey<Item> key = getKey(name, RegistryKeys.ITEM);
            T item = factory.apply(new Item.Settings().registryKey(key));
            return Registry.register(Registries.ITEM, key, item);
        }

        public static <T extends Item> T register(String name, int stackCount, Function<Item.Settings, T> factory)
        {
            RegistryKey<Item> key = getKey(name, RegistryKeys.ITEM);
            T item = factory.apply(new Item.Settings().registryKey(key).maxCount(stackCount));
            return Registry.register(Registries.ITEM, key, item);
        }

        public static <T extends Item> T register(String name, int stackCount, Item.Settings settings, Function<Item.Settings, T> factory)
        {
            RegistryKey<Item> key = getKey(name, RegistryKeys.ITEM);
            T item = factory.apply(settings.registryKey(key).maxCount(stackCount));
            return Registry.register(Registries.ITEM, key, item);
        }

        public static <T extends Item> T register(String name, Item.Settings settings, Function<Item.Settings, T> factory)
        {
            RegistryKey<Item> key = getKey(name, RegistryKeys.ITEM);
            T item = factory.apply(settings.registryKey(key));
            return Registry.register(Registries.ITEM, key, item);
        }

        public static BlockItem registerBI(Block block)
        {
            String name = Registries.BLOCK.getId(block).getPath();
            RegistryKey<Item> key = getKey(name, RegistryKeys.ITEM);
            return Registry.register(Registries.ITEM, key,
                                     new BlockItem(block, new Item.Settings()
                                             .useBlockPrefixedTranslationKey()
                                             .registryKey(key)));
        }

        public static <T extends BlockItem> T registerBI(Block block, BlockItemRegisterFunction<Item.Settings, T> factory)
        {
            String name = Registries.BLOCK.getId(block).getPath();
            RegistryKey<Item> key = getKey(name, RegistryKeys.ITEM);
            T item = factory.apply(block, new Item.Settings()
                    .useBlockPrefixedTranslationKey()
                    .registryKey(key));
            return Registry.register(Registries.ITEM, key, item);
        }

        public static <T extends BlockItem> T registerBI(Block block, Item.Settings settings,
                                                         BlockItemRegisterFunction<Item.Settings, T> factory)
        {
            String name = Registries.BLOCK.getId(block).getPath();
            RegistryKey<Item> key = getKey(name, RegistryKeys.ITEM);
            T item = factory.apply(block, settings
                    .useBlockPrefixedTranslationKey()
                    .registryKey(key));
            return Registry.register(Registries.ITEM, key, item);
        }

        public static <T extends Item> T registerTool(String name, ToolMaterial material, float attackDamage, float attackSpeed,
                                                      ToolRegisterFunction<Item.Settings, T> factory)
        {
            RegistryKey<Item> key = getKey(name, RegistryKeys.ITEM);
            T item = factory.apply(material, attackDamage, attackSpeed, new Item.Settings().registryKey(key));
            return Registry.register(Registries.ITEM, key, item);
        }

        public static <T extends Item> T registerTool(String name, ToolMaterial material, float attackDamage, float attackSpeed,
                                                      Item.Settings settings, ToolRegisterFunction<Item.Settings, T> factory)
        {
            RegistryKey<Item> key = getKey(name, RegistryKeys.ITEM);
            T item = factory.apply(material, attackDamage, attackSpeed, settings.registryKey(key));
            return Registry.register(Registries.ITEM, key, item);
        }

        public static <T extends Item> T registerArmor(String name, ArmorMaterial material, EquipmentType equipment,
                                                       ArmorRegisterFunction<Item.Settings, T> factory)
        {
            RegistryKey<Item> key = getKey(name, RegistryKeys.ITEM);
            T item = factory.apply(material, equipment, new Item.Settings().registryKey(key));
            return Registry.register(Registries.ITEM, key, item);
        }

        public static <T extends Item> T registerArmor(String name, ArmorMaterial material, EquipmentType equipment, Item.Settings settings,
                                                       ArmorRegisterFunction<Item.Settings, T> factory)
        {
            RegistryKey<Item> key = getKey(name, RegistryKeys.ITEM);
            T item = factory.apply(material, equipment, settings.registryKey(key));
            return Registry.register(Registries.ITEM, key, item);
        }

        public static Item registerSnackFood(String name, int stackCount, int nutrition, float saturation)
        {
            RegistryKey<Item> key = getKey(name, RegistryKeys.ITEM);
            return Registry.register(Registries.ITEM, key,
                                     new Item(new Item.Settings()
                                                      .registryKey(key)
                                                      .food(new FoodComponent.Builder()
                                                                    .nutrition(nutrition)
                                                                    .saturationModifier(saturation)
                                                                    .alwaysEdible()
                                                                    .build())
                                                      .maxCount(stackCount)));
        }

        public static Item registerFood(String name, int stackCount, int nutrition, float saturation)
        {
            RegistryKey<Item> key = getKey(name, RegistryKeys.ITEM);
            return Registry.register(Registries.ITEM, key,
                                     new Item(new Item.Settings()
                                                      .registryKey(key)
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
            RegistryKey<RecipeSerializer<?>> key = getKey(name, RegistryKeys.RECIPE_SERIALIZER);
            Registry.register(Registries.RECIPE_SERIALIZER, key, serializer);
        }

        public static void register(String name, RecipeType<?> recipeType)
        {
            RegistryKey<RecipeType<?>> key = getKey(name, RegistryKeys.RECIPE_TYPE);
            Registry.register(Registries.RECIPE_TYPE, key, recipeType);
        }
    }

    public static class ComponentTypes
    {
        public static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> buildOperator)
        {
            RegistryKey<ComponentType<?>> key = getKey(name, RegistryKeys.DATA_COMPONENT_TYPE);
            return Registry.register(Registries.DATA_COMPONENT_TYPE, key,
                                     buildOperator.apply(ComponentType.builder()).build());
        }
    }

    public static class Datagen
    {
        public static void registerAllArmor(ItemModelGenerator generator, Item[] items, ArmorMaterial material, boolean hasHorseArmor)
        {
            if(items.length < 4)
                throw new ArgumentCountException(items.length, 4, "Armor item array should contain at least 4 items : Helmet, Chest, Leggings, Boots");
            registerArmor(generator, items[0], material, EquipmentSlot.HEAD);
            registerArmor(generator, items[1], material, EquipmentSlot.CHEST);
            registerArmor(generator, items[2], material, EquipmentSlot.LEGS);
            registerArmor(generator, items[3], material, EquipmentSlot.FEET);
            if(hasHorseArmor && items.length == 5)
                registerArmor(generator, items[4], material, EquipmentSlot.BODY);
        }

        public static void registerArmor(ItemModelGenerator generator, Item item, ArmorMaterial material, EquipmentSlot slot)
        {
            Identifier id = material.modelId();
            generator.registerArmor(item, material.modelId(),
                                    slot == EquipmentSlot.BODY
                                    ? Registers.Datagen.buildHumanoidAndHorse(id.getPath())
                                    : Registers.Datagen.buildHumanoid(id.getPath())
                    , slot);
        }

        public static LootTable.Builder customOreDrops(FabricBlockLootTableProvider provider, RegistryWrapper.WrapperLookup registries, Block drop, Item item, float min, float max)
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

        public static LootTable.Builder customOreDrops(FabricBlockLootTableProvider provider, RegistryWrapper.WrapperLookup registries, Block drop, Item item)
        {
            return customOreDrops(provider, registries, drop, item, 2.0f, 5.0f);
        }

        public static EquipmentModel buildHumanoid(String name) {
            return EquipmentModel.builder().addHumanoidLayers(identifier(name)).build();
        }

        public static EquipmentModel buildHumanoidAndHorse(String name) {
            return EquipmentModel.builder()
                                 .addHumanoidLayers(identifier(name))
                                 .addLayers(EquipmentModel.LayerType.HORSE_BODY,
                                            EquipmentModel.Layer
                                                            .createDyeableLeather(identifier(name), false))
                                 .build();
        }
    }
}