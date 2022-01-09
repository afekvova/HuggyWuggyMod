package me.afek.huggywuggy.tileentity;

import me.afek.huggywuggy.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityLightSource extends TileEntity implements ITickableTileEntity {

    public int ticksExisted;

    public TileEntityLightSource() {
        super(ModItems.LIGHT_SOURCE.get());
    }

    @Override
    public void tick() {
        this.ticksExisted++;
        if (this.ticksExisted > 4 && this.level != null) {
            this.level.setBlockAndUpdate(this.getBlockPos(), Blocks.AIR.defaultBlockState());
            this.level.removeBlockEntity(this.getBlockPos());
        }
    }
}
