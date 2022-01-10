package me.afek.huggywuggy.packets;

import me.afek.huggywuggy.HuggyWuggyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class ScaredPacket {

    int x, y, z;

    public ScaredPacket(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static ScaredPacket decode(PacketBuffer buf) {
        int x = buf.readInt();
        int y = buf.readInt();
        int z = buf.readInt();
        return new ScaredPacket(x, y, z);
    }

    public void encode(PacketBuffer buf) {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
    }

    public static void onMessageReceived(ScaredPacket message, Supplier<NetworkEvent.Context> ctxSupplier) {
        NetworkEvent.Context ctx = ctxSupplier.get();
        if (Minecraft.getInstance().player.position().distanceToSqr(new Vector3d(message.x, message.y, message.z)) >= 9)
            ctx.enqueueWork(() -> HuggyWuggyMod.getInstance().getScareRenderer().displayImage());
        ctx.setPacketHandled(true);
    }
}