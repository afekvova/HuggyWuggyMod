package me.afek.huggywuggy.packets;

import me.afek.huggywuggy.HuggyWuggyMod;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class PosterCountChangePacket {

    private int posterCount;

    public PosterCountChangePacket(int posterCount) {
        this.posterCount = posterCount;
    }

    public int getPosterCount() {
        return posterCount;
    }

    public static PosterCountChangePacket decode(PacketBuffer buf) {
        int count = buf.readInt();
        return new PosterCountChangePacket(count);
    }

    public void encode(PacketBuffer buf) {
        buf.writeInt(this.posterCount);
    }

    public static void onMessageReceived(PosterCountChangePacket message, Supplier<NetworkEvent.Context> ctxSupplier) {
        NetworkEvent.Context ctx = ctxSupplier.get();
        ctx.enqueueWork(() -> HuggyWuggyMod.POSTER_COUNT = message.getPosterCount());
        ctx.setPacketHandled(true);
    }
}