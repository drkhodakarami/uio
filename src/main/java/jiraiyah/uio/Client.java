package jiraiyah.uio;

import jiraiyah.uio.registry.ModBlocks;
import jiraiyah.uio.registry.ModMessages;
import jiraiyah.uio.registry.ModModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class Client implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        //region SPECIAL BLOCK CUTOUT
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CITRINE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CITRINE_TRAP_DOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ENDERITE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ENDERITE_TRAP_DOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_TRAP_DOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SAPPHIRE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SAPPHIRE_TRAP_DOOR, RenderLayer.getCutout());
        //endregion

        ModMessages.registerS2CPackets();

        ModModelPredicateProvider.register();
    }
}