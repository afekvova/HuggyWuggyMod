package me.afek.huggywuggy.packets;

import me.afek.huggywuggy.HuggyWuggyMod;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class ScaredPacket {

    private boolean isKilled;

    public ScaredPacket(boolean isKilled) {
        this.isKilled = isKilled;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public static ScaredPacket decode(PacketBuffer buf) {
        boolean isKilled = buf.readBoolean();
        return new ScaredPacket(isKilled);
    }

    public void encode(PacketBuffer buf) {
        buf.writeBoolean(this.isKilled);
    }

    public static void onMessageReceived(ScaredPacket message, Supplier<NetworkEvent.Context> ctxSupplier) {
        if (message.isKilled()) {
            Minecraft.getInstance().player.kill();
            return;
        }

        HuggyWuggyMod.SCARED = 250;
    }
}