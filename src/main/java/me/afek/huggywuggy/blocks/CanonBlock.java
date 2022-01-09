package me.afek.huggywuggy.blocks;

import me.afek.huggywuggy.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.registry.Registry;
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
        for (int i = 0; i < 7; i++)
            this.dropItemIntoWorld(world, blockPos.above(), new ItemStack(Registry.ITEM.get(new ResourceLocation("grapple_hooks", "hook_red"))));

        return ActionResultType.CONSUME;
    }

    public final void dropItemIntoWorld(World world, BlockPos pos, ItemStack item) {
        if (item != null && item.getCount() > 0) {
            float rx = RANDOM.nextFloat() * 0.8F + 0.1F;
            float ry = RANDOM.nextFloat() * 0.8F + 0.1F;
            float rz = RANDOM.nextFloat() * 0.8F + 0.1F;

            ItemEntity entityItem = new ItemEntity(world,
                    pos.getX() + rx, pos.getY() + ry, pos.getZ() + rz,
                    item.copy());

            if (item.hasTag()) {
                entityItem.getItem().setTag(item.getTag().copy());
            }

            float factor = 0.05F;
            entityItem.setDeltaMovement(
                    RANDOM.nextGaussian() * factor,
                    RANDOM.nextGaussian() * factor + 0.2F,
                    RANDOM.nextGaussian() * factor);
            world.addFreshEntity(entityItem);
            item.setCount(0);
        }
    }
}
