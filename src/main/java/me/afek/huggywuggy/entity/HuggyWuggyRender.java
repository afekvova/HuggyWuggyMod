package me.afek.huggywuggy.entity;

import me.afek.huggywuggy.HuggyWuggyMod;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class HuggyWuggyRender extends MobRenderer<HuggyWuggyEntity, huggy_wuggy_bd> {
    private static final ResourceLocation GOLEM_LOCATION = new ResourceLocation(HuggyWuggyMod.MODID, "textures/entity/huggywuggy.png");

    public HuggyWuggyRender(EntityRendererManager p_i46133_1_) {
        super(p_i46133_1_, new huggy_wuggy_bd(), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(HuggyWuggyEntity p_110775_1_) {
        return GOLEM_LOCATION;
    }
}