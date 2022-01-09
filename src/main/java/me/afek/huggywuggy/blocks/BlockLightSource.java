package me.afek.huggywuggy.blocks;

import me.afek.huggywuggy.tileentity.TileEntityLightSource;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AirBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class BlockLightSource extends AirBlock implements ITileEntityProvider {

    public BlockLightSource() {
        super(AbstractBlock.Properties.of(new Material.Builder(MaterialColor.NONE).nonSolid().noCollider().replaceable().build()).air().dynamicShape().noDrops().lightLevel((p_235464_0_) -> 15));
    }

    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        return 15;
    }

    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
        return new TileEntityLightSource();
    }
}
