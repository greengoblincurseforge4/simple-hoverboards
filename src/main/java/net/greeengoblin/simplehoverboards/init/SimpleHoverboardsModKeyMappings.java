/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.greeengoblin.simplehoverboards.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class SimpleHoverboardsModKeyMappings {
	public static final KeyMapping HOVERBOARD_JUMP_KEYBIND = new KeyMapping("key.simple_hoverboards.hoverboard_jump_keybind", GLFW.GLFW_KEY_I, "key.categories.misc");
	public static final KeyMapping HOVERBOARD_LOW_KEYBIND = new KeyMapping("key.simple_hoverboards.hoverboard_low_keybind", GLFW.GLFW_KEY_K, "key.categories.misc");

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(HOVERBOARD_JUMP_KEYBIND);
		event.register(HOVERBOARD_LOW_KEYBIND);
	}

	@EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
			}
		}
	}
}