package me.afek.huggywuggy.packets;

import me.afek.huggywuggy.HuggyWuggyMod;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.StringTextComponent;
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
        ctx.enqueueWork(() -> {
            HuggyWuggyMod.POSTER_COUNT = message.getPosterCount();
            HuggyWuggyMod.getInstance().getTitleRenderer().displayTitle(new StringTextComponent("Кто-то нашёл постер!"), new StringTextComponent("Осталось " + (20 - HuggyWuggyMod.POSTER_COUNT) + " " + padezh("Постер", "", "а", "", (20 - HuggyWuggyMod.POSTER_COUNT))));

        });
        ctx.setPacketHandled(true);
    }

    public static String padezh(String ed, String a, String b, String c, int n) {
        if (n < 0) n = -n;
        int last = n % 100;
        if (last > 10 && last < 21) return ed + c;
        last = n % 10;
        if (last == 0 || last > 4) return ed + c;
        if (last == 1) return ed + a;
        if (last < 5) return ed + b;
        return ed + c;
    }
}