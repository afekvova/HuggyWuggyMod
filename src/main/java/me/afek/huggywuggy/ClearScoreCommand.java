package me.afek.huggywuggy;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import me.afek.huggywuggy.events.ModidPacketHandler;
import me.afek.huggywuggy.packets.PosterCountChangePacket;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraftforge.fml.network.PacketDistributor;

public class ClearScoreCommand {

    public ClearScoreCommand(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("clearscore").executes((command) -> returnHome(command.getSource())));
    }

    private int returnHome(CommandSource source) throws CommandSyntaxException {
        ModidPacketHandler.INSTANCE.send(PacketDistributor.ALL.noArg(), new PosterCountChangePacket(0));
        HuggyWuggyMod.POSTER_COUNT = 0;
        return 1;
    }
}
