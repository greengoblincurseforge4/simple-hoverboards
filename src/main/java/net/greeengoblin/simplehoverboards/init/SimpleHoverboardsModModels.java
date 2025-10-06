/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.greeengoblin.simplehoverboards.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.greeengoblin.simplehoverboards.client.model.Modeltestboard;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class SimpleHoverboardsModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modeltestboard.LAYER_LOCATION, Modeltestboard::createBodyLayer);
	}
}