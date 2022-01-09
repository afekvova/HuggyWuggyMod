package me.afek.huggywuggy.entity;

import me.afek.huggywuggy.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.PaintingEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class PosterEntity extends PaintingEntity {

    public PosterEntity(EntityType<? extends PaintingEntity> p_i50221_1_, World p_i50221_2_) {
        super(p_i50221_1_, p_i50221_2_);
    }

    public PosterEntity(World world, BlockPos blockpos1, Direction direction) {
        super(world, blockpos1, direction);
    }

    @Override
    public void dropItem(@Nullable Entity p_110128_1_) {
        this.spawnAtLocation(ModItems.POSTER_ITEM.get());
    }
}
