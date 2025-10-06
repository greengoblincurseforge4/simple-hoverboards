package net.greeengoblin.simplehoverboards.client.renderer.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.Model;
import net.minecraft.client.Minecraft;

import net.greeengoblin.simplehoverboards.init.SimpleHoverboardsModItems;
import net.greeengoblin.simplehoverboards.client.model.Modeltestboard;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

@OnlyIn(Dist.CLIENT)
public class GreenHoverboardItemItemRenderer extends BlockEntityWithoutLevelRenderer {
	private final EntityModelSet entityModelSet;
	private final ItemStack transformSource;

	public GreenHoverboardItemItemRenderer(BlockEntityRenderDispatcher blockEntityRenderDispatcher, EntityModelSet entityModelSet) {
		super(blockEntityRenderDispatcher, entityModelSet);
		this.entityModelSet = entityModelSet;
		this.transformSource = new ItemStack(SimpleHoverboardsModItems.GREEN_HOVERBOARD_ITEM.get());
	}

	@Override
	public void renderByItem(ItemStack itemstack, ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
		Model model = new Modeltestboard(this.entityModelSet.bakeLayer(Modeltestboard.LAYER_LOCATION));
		ResourceLocation texture = ResourceLocation.parse("simple_hoverboards:textures/item/green_hoverboard_texture.png");
		if (model == null)
			return;
		poseStack.pushPose();
		Minecraft.getInstance().getItemRenderer().getModel(this.transformSource, null, null, 0).applyTransform(displayContext, poseStack, isLeftHand(displayContext));
		poseStack.translate(0.5, isInventory(displayContext) ? 1.5 : 2, 0.5);
		poseStack.scale(1, -1, displayContext == ItemDisplayContext.GUI ? -1 : 1);
		VertexConsumer vertexConsumer = ItemRenderer.getFoilBufferDirect(bufferSource, model.renderType(texture), false, itemstack.hasFoil());
		model.renderToBuffer(poseStack, vertexConsumer, packedLight, packedOverlay);
		poseStack.popPose();
	}

	private static boolean isLeftHand(ItemDisplayContext type) {
		return type == ItemDisplayContext.FIRST_PERSON_LEFT_HAND || type == ItemDisplayContext.THIRD_PERSON_LEFT_HAND;
	}

	private static boolean isInventory(ItemDisplayContext type) {
		return type == ItemDisplayContext.GUI || type == ItemDisplayContext.FIXED;
	}
}