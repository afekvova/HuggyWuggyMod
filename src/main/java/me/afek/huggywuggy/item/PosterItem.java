package me.afek.huggywuggy.item;

import me.afek.huggywuggy.HuggyWuggyMod;
import me.afek.huggywuggy.entity.PosterEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PosterItem extends Item {

    public PosterItem(Item.Properties p_i50043_2_) {
        super(p_i50043_2_);
    }

    public ActionResultType useOn(ItemUseContext itemUseContext) {
        BlockPos blockpos = itemUseContext.getClickedPos();
        Direction direction = itemUseContext.getClickedFace();
        BlockPos blockpos1 = blockpos.relative(direction);
        PlayerEntity playerentity = itemUseContext.getPlayer();
        ItemStack itemstack = itemUseContext.getItemInHand();
        if (playerentity != null && !this.mayPlace(playerentity, direction, itemstack, blockpos1)) {
            return ActionResultType.FAIL;
        } else {
            World world = itemUseContext.getLevel();
            PosterEntity hangingentity = new PosterEntity(world, blockpos1, direction);
            hangingentity.motive = HuggyWuggyMod.POSTER;

            CompoundNBT compoundnbt = itemstack.getTag();
            if (compoundnbt != null)
                EntityType.updateCustomEntityTag(world, playerentity, hangingentity, compoundnbt);

            if (hangingentity.survives()) {
                if (!world.isClientSide) {
                    hangingentity.playPlacementSound();
                    world.addFreshEntity(hangingentity);
                }

                itemstack.shrink(1);
                return ActionResultType.sidedSuccess(world.isClientSide);
            } else {
                return ActionResultType.CONSUME;
            }
        }
    }

    protected boolean mayPlace(PlayerEntity p_200127_1_, Direction p_200127_2_, ItemStack p_200127_3_, BlockPos p_200127_4_) {
        return !p_200127_2_.getAxis().isVertical() && p_200127_1_.mayUseItemAt(p_200127_4_, p_200127_2_, p_200127_3_);
    }
}