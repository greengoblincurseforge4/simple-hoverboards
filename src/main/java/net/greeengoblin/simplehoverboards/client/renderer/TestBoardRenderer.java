package net.greeengoblin.simplehoverboards.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.greeengoblin.simplehoverboards.entity.TestBoardEntity;
import net.greeengoblin.simplehoverboards.client.model.Modeltestboard;

public class TestBoardRenderer extends MobRenderer<TestBoardEntity, Modeltestboard<TestBoardEntity>> {
	public TestBoardRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeltestboard<TestBoardEntity>(context.bakeLayer(Modeltestboard.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TestBoardEntity entity) {
		return ResourceLocation.parse("simple_hoverboards:textures/entities/green_hoverboard_texture.png");
	}
}