package me.afek.huggywuggy.blocks;

import me.afek.huggywuggy.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import java.util.Random;

public class ChargeBlock extends Block {

    Random random = new Random();

    public ChargeBlock() {
        super(AbstractBlock.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).harvestLevel(1000).noOcclusion().noCollission());
    }

    @Override
    public ActionResultType use(BlockState blockState, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockRayTraceResult blockRayTraceResult) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (itemStack.getItem() != ModItems.FLASH_LIGHT_ITEM.get()) return ActionResultType.SUCCESS;

        CompoundNBT nbt = itemStack.getOrCreateTag();
        int charge = nbt.contains("charge") ? nbt.getInt("charge") : 100;
        charge += random.nextInt(20 - 10) + 10;
        if (charge > 100) charge = 100;

        nbt.putInt("charge", charge);
        itemStack.setTag(nbt);
        return ActionResultType.CONSUME;
    }
}
