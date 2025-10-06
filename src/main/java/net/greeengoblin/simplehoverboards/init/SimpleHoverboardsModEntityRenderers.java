/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.greeengoblin.simplehoverboards.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.greeengoblin.simplehoverboards.client.renderer.TestBoardRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SimpleHoverboardsModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(SimpleHoverboardsModEntities.GREEN_HOVERBOARD.get(), TestBoardRenderer::new);
	}
}