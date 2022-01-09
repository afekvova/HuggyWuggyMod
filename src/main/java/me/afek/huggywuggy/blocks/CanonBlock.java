package me.afek.huggywuggy.blocks;

import me.afek.huggywuggy.HuggyWuggyMod;
import me.afek.huggywuggy.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class CanonBlock extends Block {

    public CanonBlock() {
        super(AbstractBlock.Properties.of(Material.STONE).strength(-1.0F, 3600000.0F).harvestLevel(1000).noOcclusion().noCollission());
    }

    @Override
    public ActionResultType use(BlockState blockState, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockRayTraceResult blockRayTraceResult) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (itemStack.getItem() != ModItems.POSTER_ITEM.get() || itemStack.getCount() < 20)
            return ActionResultType.SUCCESS;

        itemStack.shrink(20);
        HuggyWuggyMod.getInstance().getTitleRenderer().displayTitle(new StringTextComponent("ПОБЕДА!"), new StringTextComponent(""));
        return ActionResultType.CONSUME;
    }
}
