package me.afek.huggywuggy.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ColorHelper;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import javax.annotation.Nullable;

public class TitleRenderer {
    public ITextComponent displayedTitle = null;
    public ITextComponent displayedSubTitle = null;
    public int titleTimer = 0;
    public int cooldownTimer = 0;
    public int titleFadeInTicks;
    public int titleDisplayTime;
    public int titleFadeOutTicks;
    public int titleTextcolor;
    public String titleDefaultTextColor;
    public boolean showTextShadow;
    public float titleTextSize;
    public float titleXOffset;
    public float titleYOffset;
    public boolean isTextCentered;


    public TitleRenderer(int fadeInTicks, int displayTicks, int fadeOutTicks, String textColor, boolean showTextShadow, double textSize, double xOffset, double yOffset, boolean centerText) {
        this.titleFadeInTicks = fadeInTicks;
        this.titleDisplayTime = displayTicks;
        this.titleFadeOutTicks = fadeOutTicks;
        this.setColor(textColor);
        this.titleDefaultTextColor = textColor;
        this.showTextShadow = showTextShadow;
        this.titleTextSize = (float) textSize;
        this.titleXOffset = (float) xOffset;
        this.titleYOffset = (float) yOffset;
        this.isTextCentered = centerText;
    }

    @OnlyIn(Dist.CLIENT)
    public void renderText(RenderGameOverlayEvent.Pre event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL && this.displayedTitle != null && this.titleTimer > 0) {
            float age = (float) this.titleTimer - event.getPartialTicks();
            int opacity = 255;
            if (this.titleTimer > this.titleFadeOutTicks + this.titleDisplayTime) {
                float r = (float) (this.titleFadeInTicks + this.titleDisplayTime + this.titleFadeOutTicks) - age;
                opacity = (int) (r * 255.0f / (float) this.titleFadeInTicks);
            }
            if (this.titleTimer <= this.titleFadeOutTicks) {
                opacity = (int) (age * 255.0f / (float) this.titleFadeOutTicks);
            }
            if ((opacity = MathHelper.clamp((int) opacity, (int) 0, (int) 255)) > 8) {
                float xOffset;
                RenderSystem.pushMatrix();
                if (this.isTextCentered)
                    RenderSystem.translatef((float) (Minecraft.getInstance().getWindow().getGuiScaledWidth() / 2), (float) (Minecraft.getInstance().getWindow().getGuiScaledHeight() / 2), (float) 0.0f);
                RenderSystem.enableBlend();
                RenderSystem.defaultBlendFunc();
                RenderSystem.pushMatrix();
                RenderSystem.scalef((float) this.titleTextSize, (float) this.titleTextSize, (float) this.titleTextSize);
                int alpha = opacity << 24 & 0xFF000000;
                FontRenderer fontRenderer = Minecraft.getInstance().font;
                int titleWidth = fontRenderer.width(this.displayedTitle);
                this.drawTextBackground(event.getMatrixStack(), -10, titleWidth, this.titleTextcolor | alpha);
                float f = xOffset = this.isTextCentered ? this.titleXOffset + (float) (-titleWidth / 2) : this.titleXOffset;
                if (this.showTextShadow) {
                    fontRenderer.drawShadow(event.getMatrixStack(), this.displayedTitle, xOffset, this.titleYOffset, this.titleTextcolor | alpha);
                } else {
                    fontRenderer.draw(event.getMatrixStack(), this.displayedTitle, xOffset, this.titleYOffset, this.titleTextcolor | alpha);
                }

                RenderSystem.popMatrix();
                if (this.displayedSubTitle != null) {
                    RenderSystem.pushMatrix();
                    RenderSystem.scalef((float) 1.3f, (float) 1.3f, (float) 1.3f);
                    int subtitleWidth = fontRenderer.width(this.displayedSubTitle);
                    this.drawTextBackground(event.getMatrixStack(), 5, subtitleWidth, 0xFFFFFF | alpha);
                    if (this.showTextShadow) {
                        fontRenderer.drawShadow(event.getMatrixStack(), this.displayedSubTitle, (float) (-subtitleWidth / 2), 10.0f, 0xFFFFFF | alpha);
                    } else {
                        fontRenderer.draw(event.getMatrixStack(), this.displayedSubTitle, (float) (-subtitleWidth / 2), 10.0f, 0xFFFFFF | alpha);
                    }

                    RenderSystem.popMatrix();
                }
                RenderSystem.disableBlend();
                RenderSystem.popMatrix();
            }
        }
    }

    public void tick() {
        if (this.titleTimer > 0) {
            --this.titleTimer;
            if (this.titleTimer <= 0)
                this.reset();
        }

        if (this.cooldownTimer > 0)
            --this.cooldownTimer;
    }

    public void displayTitle(ITextComponent titleText, @Nullable ITextComponent subtitleText) {
        this.displayedTitle = titleText;
        this.titleTimer = this.titleFadeInTicks + this.titleDisplayTime + this.titleFadeOutTicks;
        if (subtitleText != null) {
            this.displayedSubTitle = subtitleText;
        }
    }

    public void reset() {
        this.titleTimer = 0;
    }

    public void setColor(String textColor) {
        try {
            this.titleTextcolor = (int) Long.parseLong(textColor, 16);
        } catch (Exception e) {
            this.titleTextcolor = 0xFFFFFF;
        }
    }

    @OnlyIn(Dist.CLIENT)
    protected void drawTextBackground(MatrixStack mStack, int yOffset, int width, int color) {
        int textBackgroundColor = Minecraft.getInstance().options.getBackgroundColor(0.0f);
        if (textBackgroundColor != 0) {
            int xOffset = -width / 2;
            AbstractGui.fill((MatrixStack) mStack, (int) (xOffset - 2), (int) (yOffset - 2), (int) (xOffset + width + 2), (int) (yOffset + 9 + 2), (int) ColorHelper.PackedColor.multiply((int) textBackgroundColor, (int) color));
        }
    }
}

