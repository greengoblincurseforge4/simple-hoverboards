/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.greeengoblin.simplehoverboards.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import net.greeengoblin.simplehoverboards.item.GreenHoverboardItemItem;
import net.greeengoblin.simplehoverboards.SimpleHoverboardsMod;

public class SimpleHoverboardsModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(SimpleHoverboardsMod.MODID);
	public static final DeferredItem<Item> GREEN_HOVERBOARD_ITEM = REGISTRY.register("green_hoverboard_item", GreenHoverboardItemItem::new);
	// Start of user code block custom items
	// End of user code block custom items
}