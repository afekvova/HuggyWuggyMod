package me.afek.huggywuggy.renderer;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class ScareRenderer {

    public int titleDisplayTime, imageTimer;
    public ResourceLocation image;

    public ScareRenderer(int titleDisplayTime, ResourceLocation image) {
        this.titleDisplayTime = titleDisplayTime;
        this.image = image;
    }

    public void renderImage(RenderGameOverlayEvent.Pre event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL && this.image != null && this.imageTimer > 0) {
            int screenHeight = event.getWindow().getGuiScaledHeight();
            int screenWidth = event.getWindow().getGuiScaledWidth();
            RenderSystem.disableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.defaultBlendFunc();
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.disableAlphaTest();
            Minecraft.getInstance().getTextureManager().bind(this.image);
            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tessellator.getBuilder();
            bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
            bufferbuilder.vertex(0.0D, screenHeight, -90.0D).uv(0.0F, 1.0F).endVertex();
            bufferbuilder.vertex(screenWidth, screenHeight, -90.0D).uv(1.0F, 1.0F).endVertex();
            bufferbuilder.vertex(screenWidth, 0.0D, -90.0D).uv(1.0F, 0.0F).endVertex();
            bufferbuilder.vertex(0.0D, 0.0D, -90.0D).uv(0.0F, 0.0F).endVertex();
            tessellator.end();
            RenderSystem.depthMask(true);
            RenderSystem.enableDepthTest();
            RenderSystem.enableAlphaTest();
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    public void tick() {
        if (this.imageTimer > 0) {
            --this.imageTimer;
            if (this.imageTimer <= 0)
                this.reset();
        }
    }

    public void displayImage(ResourceLocation resourceLocation) {
        this.image = resourceLocation;
        this.imageTimer = this.titleDisplayTime + 15;
    }

    public void displayImage() {
        if (this.image != null)
            this.imageTimer = this.titleDisplayTime + 15;
    }

    public void reset() {
        this.imageTimer = 0;
    }
}

