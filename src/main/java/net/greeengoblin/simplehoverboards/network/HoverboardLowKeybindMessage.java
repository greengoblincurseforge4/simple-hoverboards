package net.greeengoblin.simplehoverboards.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import net.greeengoblin.simplehoverboards.SimpleHoverboardsMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record HoverboardLowKeybindMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<HoverboardLowKeybindMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(SimpleHoverboardsMod.MODID, "key_hoverboard_low_keybind"));
	public static final StreamCodec<RegistryFriendlyByteBuf, HoverboardLowKeybindMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, HoverboardLowKeybindMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new HoverboardLowKeybindMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<HoverboardLowKeybindMessage> type() {
		return TYPE;
	}

	public static void handleData(final HoverboardLowKeybindMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		SimpleHoverboardsMod.addNetworkMessage(HoverboardLowKeybindMessage.TYPE, HoverboardLowKeybindMessage.STREAM_CODEC, HoverboardLowKeybindMessage::handleData);
	}
}