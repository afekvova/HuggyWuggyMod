package me.afek.huggywuggy;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import me.afek.huggywuggy.item.ModItems;
import me.ichun.mods.morph.api.MorphApi;
import me.ichun.mods.morph.api.morph.MorphVariant;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

import java.util.Random;

public class SetupCommand {

    Random random = new Random();

    public SetupCommand(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("setup").executes((command) -> returnHome(command.getSource())));
    }

    private int returnHome(CommandSource source) throws CommandSyntaxException {
        MorphVariant variant = MorphApi.getApiImpl().createVariant(ModItems.HUGGY_WUGGY_ENTITY.get().create(source.getLevel()));
        MorphApi.getApiImpl().morphTo(source.getPlayerOrException(), variant);
        HuggyWuggyMod.isHuggy = true;
        return 1;
    }
}
