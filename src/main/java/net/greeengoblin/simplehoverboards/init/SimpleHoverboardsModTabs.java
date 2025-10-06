/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.greeengoblin.simplehoverboards.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.greeengoblin.simplehoverboards.SimpleHoverboardsMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class SimpleHoverboardsModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SimpleHoverboardsMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(SimpleHoverboardsModItems.GREEN_HOVERBOARD_ITEM.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
			tabData.accept(SimpleHoverboardsModItems.GREEN_HOVERBOARD_ITEM.get());
		}
	}
}