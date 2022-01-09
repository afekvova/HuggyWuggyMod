package me.afek.huggywuggy.events;

import me.afek.huggywuggy.HuggyWuggyMod;
import me.afek.huggywuggy.packets.PosterCountChangePacket;
import me.afek.huggywuggy.packets.ScaredPacket;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import java.util.Optional;


public class ModidPacketHandler {

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(HuggyWuggyMod.MODID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void init() {
        INSTANCE.registerMessage(1, PosterCountChangePacket.class,
                PosterCountChangePacket::encode, PosterCountChangePacket::decode,
                PosterCountChangePacket::onMessageReceived,
                Optional.of(NetworkDirection.PLAY_TO_CLIENT));
        INSTANCE.registerMessage(2, ScaredPacket.class,
                ScaredPacket::encode, ScaredPacket::decode,
                ScaredPacket::onMessageReceived,
                Optional.of(NetworkDirection.PLAY_TO_CLIENT));
    }
}
