package net.greeengoblin.simplehoverboards.item;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.Minecraft;

import net.greeengoblin.simplehoverboards.procedures.GreenHoverboardItemRightclickedOnBlockProcedure;
import net.greeengoblin.simplehoverboards.init.SimpleHoverboardsModItems;
import net.greeengoblin.simplehoverboards.client.renderer.item.GreenHoverboardItemItemRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class GreenHoverboardItemItem extends Item {
	public GreenHoverboardItemItem() {
		super(new Item.Properties().stacksTo(1).fireResistant());
	}

	@SubscribeEvent
	public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			private GreenHoverboardItemItemRenderer rendererInstance;

			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer() {
				if (rendererInstance == null)
					rendererInstance = new GreenHoverboardItemItemRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
				return rendererInstance;
			}
		}, SimpleHoverboardsModItems.GREEN_HOVERBOARD_ITEM.get());
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		GreenHoverboardItemRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ());
		return InteractionResult.SUCCESS;
	}
}