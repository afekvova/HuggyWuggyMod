package me.afek.huggywuggy.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BaseItemFlashlightClass extends Item {

    public BaseItemFlashlightClass() {
        super(new Properties());
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemStackHand = playerIn.getItemInHand(handIn);
        CompoundNBT compoundNBT = itemStackHand.getOrCreateTag();
        boolean active = compoundNBT.getBoolean("active");
        compoundNBT.putBoolean("active", !active);
        itemStackHand.setTag(compoundNBT);
        if (active) {
            worldIn.playSound(playerIn, playerIn.position().x(), playerIn.position().y(), playerIn.position().z(), SoundEvents.WOODEN_BUTTON_CLICK_ON, SoundCategory.NEUTRAL, 0.1F, 1.5F);
        } else {
            worldIn.playSound(playerIn, playerIn.position().x(), playerIn.position().y(), playerIn.position().z(), SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundCategory.NEUTRAL, 0.1F, 1.5F);
        }

        return new ActionResult(ActionResultType.PASS, itemStackHand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("§eСтатус: " + (stack.getTag().getBoolean("active") ? "§aВКЛ." : "§сВЫКЛ.")));
        tooltip.add(new StringTextComponent("§eЗаряд: §a" + ((stack.getTag().contains("charge") ? stack.getTag().getInt("charge") : 100)) + "%"));
//        tooltip.add(new StringTextComponent("§6"));
//        tooltip.add(new StringTextComponent("§eПасхалка: §6Разработано командой Тумки | §cAfek"));
    }
}
