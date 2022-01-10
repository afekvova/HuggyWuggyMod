package me.afek.huggywuggy.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class HuggyWuggyModel extends EntityModel<HuggyWuggyEntity> {
    private final ModelRenderer rote;
    private final ModelRenderer all;
    private final ModelRenderer rightleg8;
    private final ModelRenderer rightleg7;
    private final ModelRenderer rightleg6;
    private final ModelRenderer rightleg5;
    private final ModelRenderer rightleg10;
    private final ModelRenderer rightleg4;
    private final ModelRenderer rightleg11;
    private final ModelRenderer rightleg3;
    private final ModelRenderer rightleg2;
    private final ModelRenderer rightleg2_r1;
    private final ModelRenderer rightleg2_r2;
    private final ModelRenderer rightleg2_r3;
    private final ModelRenderer rightleg2_r4;
    private final ModelRenderer rightleg;
    private final ModelRenderer rightleg9;
    private final ModelRenderer rightleg9_r1;
    private final ModelRenderer leftleg9;
    private final ModelRenderer leftleg10;
    private final ModelRenderer leftleg11;
    private final ModelRenderer leftleg1;
    private final ModelRenderer leftleg2;
    private final ModelRenderer leftleg13;
    private final ModelRenderer leftleg3;
    private final ModelRenderer leftleg14;
    private final ModelRenderer leftleg15;
    private final ModelRenderer leftleg15_r1;
    private final ModelRenderer leftleg15_r2;
    private final ModelRenderer leftleg15_r3;
    private final ModelRenderer leftleg15_r4;
    private final ModelRenderer leftleg16;
    private final ModelRenderer leftleg;
    private final ModelRenderer leftleg_r1;
    private final ModelRenderer body2;
    private final ModelRenderer body;
    private final ModelRenderer body_r1;
    private final ModelRenderer lefthand;
    private final ModelRenderer lefthand2;
    private final ModelRenderer lefthand3;
    private final ModelRenderer lefthand4;
    private final ModelRenderer lefthand5;
    private final ModelRenderer lefthand12;
    private final ModelRenderer lefthand6;
    private final ModelRenderer lefthand7;
    private final ModelRenderer lefthand8;
    private final ModelRenderer lefthand8_r1;
    private final ModelRenderer lefthand8_r2;
    private final ModelRenderer lefthand8_r3;
    private final ModelRenderer lefthand8_r4;
    private final ModelRenderer lefthand8_r5;
    private final ModelRenderer lefthand8_r6;
    private final ModelRenderer lefthand8_r7;
    private final ModelRenderer lefthand8_r8;
    private final ModelRenderer lefthand9;
    private final ModelRenderer lefthand10;
    private final ModelRenderer lefthand11;
    private final ModelRenderer righthand1;
    private final ModelRenderer righthand13;
    private final ModelRenderer righthand14;
    private final ModelRenderer righthand15;
    private final ModelRenderer righthand16;
    private final ModelRenderer righthand3;
    private final ModelRenderer righthand17;
    private final ModelRenderer righthand18;
    private final ModelRenderer righthand19;
    private final ModelRenderer righthand19_r1;
    private final ModelRenderer righthand19_r2;
    private final ModelRenderer righthand19_r3;
    private final ModelRenderer righthand19_r4;
    private final ModelRenderer righthand19_r5;
    private final ModelRenderer righthand19_r6;
    private final ModelRenderer righthand19_r7;
    private final ModelRenderer righthand19_r8;
    private final ModelRenderer righthand0;
    private final ModelRenderer lefthand21;
    private final ModelRenderer righthand2;
    private final ModelRenderer neck;
    private final ModelRenderer head;
    private final ModelRenderer hide_bug;
    private final ModelRenderer eyeball;
    private final ModelRenderer eye1;
    private final ModelRenderer eyeball2;
    private final ModelRenderer eye2;
    private final ModelRenderer lip;
    private final ModelRenderer teeth;
    private final ModelRenderer teeth_r1;
    private final ModelRenderer teeth_r2;
    private final ModelRenderer lip3;
    private final ModelRenderer lip2;
    private final ModelRenderer teeth2;
    private final ModelRenderer teeth2_r1;
    private final ModelRenderer teeth2_r2;

    public HuggyWuggyModel() {
        texWidth = 148;
        texHeight = 148;

        rote = new ModelRenderer(this);
        rote.setPos(0.0F, -7.0F, 0.0F);


        all = new ModelRenderer(this);
        all.setPos(0.0F, 31.0F, 0.0F);
        rote.addChild(all);


        rightleg8 = new ModelRenderer(this);
        rightleg8.setPos(-3.0F, -40.0F, 0.0F);
        all.addChild(rightleg8);
        rightleg8.texOffs(34, 77).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

        rightleg7 = new ModelRenderer(this);
        rightleg7.setPos(0.0F, 4.0F, 0.0F);
        rightleg8.addChild(rightleg7);
        rightleg7.texOffs(51, 77).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.01F, false);

        rightleg6 = new ModelRenderer(this);
        rightleg6.setPos(0.0F, 4.0F, 0.0F);
        rightleg7.addChild(rightleg6);
        rightleg6.texOffs(64, 82).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

        rightleg5 = new ModelRenderer(this);
        rightleg5.setPos(0.0F, 4.0F, 0.0F);
        rightleg6.addChild(rightleg5);
        rightleg5.texOffs(81, 82).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.01F, false);

        rightleg10 = new ModelRenderer(this);
        rightleg10.setPos(0.0F, 4.0F, 0.0F);
        rightleg5.addChild(rightleg10);
        rightleg10.texOffs(85, 41).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

        rightleg4 = new ModelRenderer(this);
        rightleg4.setPos(0.0F, 4.0F, 0.0F);
        rightleg10.addChild(rightleg4);
        rightleg4.texOffs(85, 41).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.01F, false);

        rightleg11 = new ModelRenderer(this);
        rightleg11.setPos(0.0F, 4.0F, 0.0F);
        rightleg4.addChild(rightleg11);
        rightleg11.texOffs(85, 50).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

        rightleg3 = new ModelRenderer(this);
        rightleg3.setPos(0.0F, 4.0F, 0.0F);
        rightleg11.addChild(rightleg3);
        rightleg3.texOffs(85, 50).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.01F, false);

        rightleg2 = new ModelRenderer(this);
        rightleg2.setPos(0.0F, 4.0F, 0.0F);
        rightleg3.addChild(rightleg2);
        rightleg2.texOffs(0, 86).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

        rightleg2_r1 = new ModelRenderer(this);
        rightleg2_r1.setPos(-3.8706F, 0.517F, -1.0F);
        rightleg2.addChild(rightleg2_r1);
        setRotationAngle(rightleg2_r1, -1.5708F, 1.3526F, -1.5708F);
        rightleg2_r1.texOffs(140, 8).addBox(1.0F, -0.5F, 1.85F, 0.0F, 7.0F, 4.0F, 0.0F, true);

        rightleg2_r2 = new ModelRenderer(this);
        rightleg2_r2.setPos(-2.0F, 0.5F, 0.0F);
        rightleg2.addChild(rightleg2_r2);
        setRotationAngle(rightleg2_r2, 0.0F, 0.0F, 0.1745F);
        rightleg2_r2.texOffs(140, 8).addBox(0.0F, -0.5F, -2.0F, 0.0F, 7.0F, 4.0F, 0.0F, true);

        rightleg2_r3 = new ModelRenderer(this);
        rightleg2_r3.setPos(2.0F, 0.5F, 0.0F);
        rightleg2.addChild(rightleg2_r3);
        setRotationAngle(rightleg2_r3, 0.0F, 0.0F, -0.1745F);
        rightleg2_r3.texOffs(140, 8).addBox(0.0F, -0.5F, -2.0F, 0.0F, 7.0F, 4.0F, 0.0F, true);

        rightleg2_r4 = new ModelRenderer(this);
        rightleg2_r4.setPos(-3.8706F, 0.517F, -1.0F);
        rightleg2.addChild(rightleg2_r4);
        setRotationAngle(rightleg2_r4, 1.5708F, 1.4399F, 1.5708F);
        rightleg2_r4.texOffs(140, 8).addBox(-3.0F, -0.5F, 1.85F, 0.0F, 7.0F, 4.0F, 0.0F, true);

        rightleg = new ModelRenderer(this);
        rightleg.setPos(0.0F, 4.0F, 0.0F);
        rightleg2.addChild(rightleg);
        rightleg.texOffs(98, 37).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 2.0F, 4.0F, 0.01F, false);

        rightleg9 = new ModelRenderer(this);
        rightleg9.setPos(0.0F, 2.0F, 0.0F);
        rightleg.addChild(rightleg9);
        rightleg9.texOffs(48, 0).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 2.0F, 4.0F, 0.01F, false);
        rightleg9.texOffs(100, 22).addBox(-2.0F, 0.0F, -6.0F, 4.0F, 2.0F, 3.0F, 0.01F, false);

        rightleg9_r1 = new ModelRenderer(this);
        rightleg9_r1.setPos(2.0F, 1.0F, -1.0F);
        rightleg9.addChild(rightleg9_r1);
        setRotationAngle(rightleg9_r1, 0.0F, -0.3491F, 0.0F);
        rightleg9_r1.texOffs(86, 100).addBox(-2.0F, -1.0F, -3.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);

        leftleg9 = new ModelRenderer(this);
        leftleg9.setPos(3.0F, -40.0F, 0.0F);
        all.addChild(leftleg9);
        leftleg9.texOffs(17, 77).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

        leftleg10 = new ModelRenderer(this);
        leftleg10.setPos(0.0F, 4.0F, 0.0F);
        leftleg9.addChild(leftleg10);
        leftleg10.texOffs(0, 77).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.01F, false);

        leftleg11 = new ModelRenderer(this);
        leftleg11.setPos(0.0F, 4.0F, 0.0F);
        leftleg10.addChild(leftleg11);
        leftleg11.texOffs(76, 61).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

        leftleg1 = new ModelRenderer(this);
        leftleg1.setPos(0.0F, 4.0F, 0.0F);
        leftleg11.addChild(leftleg1);
        leftleg1.texOffs(76, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.01F, false);

        leftleg2 = new ModelRenderer(this);
        leftleg2.setPos(0.0F, 4.0F, 0.0F);
        leftleg1.addChild(leftleg2);
        leftleg2.texOffs(72, 73).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

        leftleg13 = new ModelRenderer(this);
        leftleg13.setPos(0.0F, 4.0F, 0.0F);
        leftleg2.addChild(leftleg13);
        leftleg13.texOffs(72, 73).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.01F, false);

        leftleg3 = new ModelRenderer(this);
        leftleg3.setPos(0.0F, 4.0F, 0.0F);
        leftleg13.addChild(leftleg3);
        leftleg3.texOffs(17, 68).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

        leftleg14 = new ModelRenderer(this);
        leftleg14.setPos(0.0F, 4.0F, 0.0F);
        leftleg3.addChild(leftleg14);
        leftleg14.texOffs(17, 68).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.01F, false);

        leftleg15 = new ModelRenderer(this);
        leftleg15.setPos(0.0F, 4.0F, 0.0F);
        leftleg14.addChild(leftleg15);
        leftleg15.texOffs(0, 68).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

        leftleg15_r1 = new ModelRenderer(this);
        leftleg15_r1.setPos(3.8706F, 0.517F, -1.0F);
        leftleg15.addChild(leftleg15_r1);
        setRotationAngle(leftleg15_r1, -1.5708F, -1.3526F, 1.5708F);
        leftleg15_r1.texOffs(140, 8).addBox(-1.0F, -0.5F, 1.85F, 0.0F, 7.0F, 4.0F, 0.0F, false);

        leftleg15_r2 = new ModelRenderer(this);
        leftleg15_r2.setPos(2.0F, 0.5F, 0.0F);
        leftleg15.addChild(leftleg15_r2);
        setRotationAngle(leftleg15_r2, 0.0F, 0.0F, -0.1745F);
        leftleg15_r2.texOffs(140, 8).addBox(0.0F, -0.5F, -2.0F, 0.0F, 7.0F, 4.0F, 0.0F, false);

        leftleg15_r3 = new ModelRenderer(this);
        leftleg15_r3.setPos(-2.0F, 0.5F, 0.0F);
        leftleg15.addChild(leftleg15_r3);
        setRotationAngle(leftleg15_r3, 0.0F, 0.0F, 0.1745F);
        leftleg15_r3.texOffs(140, 8).addBox(0.0F, -0.5F, -2.0F, 0.0F, 7.0F, 4.0F, 0.0F, false);

        leftleg15_r4 = new ModelRenderer(this);
        leftleg15_r4.setPos(3.8706F, 0.517F, -1.0F);
        leftleg15.addChild(leftleg15_r4);
        setRotationAngle(leftleg15_r4, 1.5708F, -1.4399F, -1.5708F);
        leftleg15_r4.texOffs(140, 8).addBox(3.0F, -0.5F, 1.85F, 0.0F, 7.0F, 4.0F, 0.0F, false);

        leftleg16 = new ModelRenderer(this);
        leftleg16.setPos(0.0F, 4.0F, 0.0F);
        leftleg15.addChild(leftleg16);
        leftleg16.texOffs(96, 9).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 2.0F, 4.0F, 0.01F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setPos(0.0F, 2.0F, 0.0F);
        leftleg16.addChild(leftleg);
        leftleg.texOffs(51, 32).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 2.0F, 4.0F, 0.01F, false);
        leftleg.texOffs(98, 84).addBox(-2.0F, 0.0F, -6.0F, 4.0F, 2.0F, 3.0F, 0.01F, false);

        leftleg_r1 = new ModelRenderer(this);
        leftleg_r1.setPos(-2.0F, 1.0F, -1.0F);
        leftleg.addChild(leftleg_r1);
        setRotationAngle(leftleg_r1, 0.0F, 0.3491F, 0.0F);
        leftleg_r1.texOffs(73, 100).addBox(0.0F, -1.0F, -3.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);

        body2 = new ModelRenderer(this);
        body2.setPos(0.0F, -40.0F, 0.0F);
        all.addChild(body2);
        body2.texOffs(59, 0).addBox(-5.0F, -7.0F, -4.0F, 10.0F, 7.0F, 8.0F, 0.0F, false);
        body2.texOffs(112, 19).addBox(-5.0F, 0.0F, -4.0F, 10.0F, 2.0F, 8.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setPos(0.0F, -7.0F, 0.0F);
        body2.addChild(body);
        body.texOffs(39, 61).addBox(-5.0F, -7.0F, -4.0F, 10.0F, 7.0F, 8.0F, 0.0F, false);

        body_r1 = new ModelRenderer(this);
        body_r1.setPos(0.0F, -7.0F, -4.0F);
        body.addChild(body_r1);
        setRotationAngle(body_r1, -0.0869F, 0.0013F, -0.0092F);
        body_r1.texOffs(110, 1).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 7.0F, 0.0F, 0.0F, false);

        lefthand = new ModelRenderer(this);
        lefthand.setPos(6.0F, -4.0F, 0.0F);
        body.addChild(lefthand);
        lefthand.texOffs(98, 55).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.0F, false);

        lefthand2 = new ModelRenderer(this);
        lefthand2.setPos(0.5F, 2.0F, 0.0F);
        lefthand.addChild(lefthand2);
        lefthand2.texOffs(45, 96).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.01F, false);

        lefthand3 = new ModelRenderer(this);
        lefthand3.setPos(0.0F, 4.0F, 0.0F);
        lefthand2.addChild(lefthand3);
        lefthand3.texOffs(96, 0).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.0F, false);

        lefthand4 = new ModelRenderer(this);
        lefthand4.setPos(0.0F, 4.0F, 0.0F);
        lefthand3.addChild(lefthand4);
        lefthand4.texOffs(30, 95).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.01F, false);

        lefthand5 = new ModelRenderer(this);
        lefthand5.setPos(0.0F, 4.0F, 0.0F);
        lefthand4.addChild(lefthand5);
        lefthand5.texOffs(15, 95).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.0F, false);

        lefthand12 = new ModelRenderer(this);
        lefthand12.setPos(0.0F, 4.0F, 0.0F);
        lefthand5.addChild(lefthand12);
        lefthand12.texOffs(0, 95).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.01F, false);

        lefthand6 = new ModelRenderer(this);
        lefthand6.setPos(0.0F, 4.0F, 0.0F);
        lefthand12.addChild(lefthand6);
        lefthand6.texOffs(0, 95).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.0F, false);

        lefthand7 = new ModelRenderer(this);
        lefthand7.setPos(0.0F, 4.0F, 0.0F);
        lefthand6.addChild(lefthand7);
        lefthand7.texOffs(94, 75).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.01F, false);

        lefthand8 = new ModelRenderer(this);
        lefthand8.setPos(0.0F, 4.0F, 0.0F);
        lefthand7.addChild(lefthand8);
        lefthand8.texOffs(93, 28).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.0F, false);

        lefthand8_r1 = new ModelRenderer(this);
        lefthand8_r1.setPos(1.5F, 4.0F, 0.0F);
        lefthand8.addChild(lefthand8_r1);
        setRotationAngle(lefthand8_r1, 0.0F, 0.0F, -0.3054F);
        lefthand8_r1.texOffs(139, 0).addBox(0.0F, 0.0F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, false);

        lefthand8_r2 = new ModelRenderer(this);
        lefthand8_r2.setPos(-1.5F, 4.0F, 0.0F);
        lefthand8.addChild(lefthand8_r2);
        setRotationAngle(lefthand8_r2, 0.0F, 0.0F, 0.2618F);
        lefthand8_r2.texOffs(139, 0).addBox(0.0F, 0.0F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, false);

        lefthand8_r3 = new ModelRenderer(this);
        lefthand8_r3.setPos(0.0F, 4.0F, 2.0F);
        lefthand8.addChild(lefthand8_r3);
        setRotationAngle(lefthand8_r3, 0.3054F, 0.0F, 0.0F);
        lefthand8_r3.texOffs(142, 7).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, 0.0F, false);

        lefthand8_r4 = new ModelRenderer(this);
        lefthand8_r4.setPos(0.0F, 4.0F, -2.0F);
        lefthand8.addChild(lefthand8_r4);
        setRotationAngle(lefthand8_r4, -0.6109F, 0.0F, 0.0F);
        lefthand8_r4.texOffs(142, 7).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, 0.0F, false);

        lefthand8_r5 = new ModelRenderer(this);
        lefthand8_r5.setPos(1.5F, 0.0F, 0.0F);
        lefthand8.addChild(lefthand8_r5);
        setRotationAngle(lefthand8_r5, 0.0F, 0.0F, -0.3054F);
        lefthand8_r5.texOffs(131, -2).addBox(0.0F, 0.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, false);

        lefthand8_r6 = new ModelRenderer(this);
        lefthand8_r6.setPos(-1.4991F, 0.0003F, 0.0F);
        lefthand8.addChild(lefthand8_r6);
        setRotationAngle(lefthand8_r6, 0.0F, 0.0F, 0.3054F);
        lefthand8_r6.texOffs(131, -2).addBox(0.0F, 0.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, true);

        lefthand8_r7 = new ModelRenderer(this);
        lefthand8_r7.setPos(0.0F, 0.0F, 2.0F);
        lefthand8.addChild(lefthand8_r7);
        setRotationAngle(lefthand8_r7, 0.3054F, 0.0F, 0.0F);
        lefthand8_r7.texOffs(142, 7).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F, 0.0F, false);

        lefthand8_r8 = new ModelRenderer(this);
        lefthand8_r8.setPos(0.0F, 0.0F, -2.0F);
        lefthand8.addChild(lefthand8_r8);
        setRotationAngle(lefthand8_r8, -0.3054F, 0.0F, 0.0F);
        lefthand8_r8.texOffs(142, 7).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F, 0.0F, false);

        lefthand9 = new ModelRenderer(this);
        lefthand9.setPos(0.0F, 4.0F, 0.0F);
        lefthand8.addChild(lefthand9);
        lefthand9.texOffs(60, 100).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);

        lefthand10 = new ModelRenderer(this);
        lefthand10.setPos(1.0F, 2.0F, 0.0F);
        lefthand9.addChild(lefthand10);
        setRotationAngle(lefthand10, 0.0F, 0.0F, 0.3054F);
        lefthand10.texOffs(98, 46).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 3.0F, 4.0F, 0.0F, false);

        lefthand11 = new ModelRenderer(this);
        lefthand11.setPos(0.0F, 0.0F, -2.0F);
        lefthand9.addChild(lefthand11);
        setRotationAngle(lefthand11, -0.1745F, 0.0F, 0.3054F);
        lefthand11.texOffs(0, 54).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);

        righthand1 = new ModelRenderer(this);
        righthand1.setPos(-6.0F, -4.0F, 0.0F);
        body.addChild(righthand1);
        righthand1.texOffs(88, 91).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.0F, false);

        righthand13 = new ModelRenderer(this);
        righthand13.setPos(-0.5F, 2.0F, 0.0F);
        righthand1.addChild(righthand13);
        righthand13.texOffs(73, 91).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.01F, false);

        righthand14 = new ModelRenderer(this);
        righthand14.setPos(0.0F, 4.0F, 0.0F);
        righthand13.addChild(righthand14);
        righthand14.texOffs(58, 91).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.0F, false);

        righthand15 = new ModelRenderer(this);
        righthand15.setPos(0.0F, 4.0F, 0.0F);
        righthand14.addChild(righthand15);
        righthand15.texOffs(89, 66).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.01F, false);

        righthand16 = new ModelRenderer(this);
        righthand16.setPos(0.0F, 4.0F, 0.0F);
        righthand15.addChild(righthand16);
        righthand16.texOffs(88, 16).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.0F, false);

        righthand3 = new ModelRenderer(this);
        righthand3.setPos(0.0F, 4.0F, 0.0F);
        righthand16.addChild(righthand3);
        righthand3.texOffs(47, 86).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.01F, false);

        righthand17 = new ModelRenderer(this);
        righthand17.setPos(0.0F, 4.0F, 0.0F);
        righthand3.addChild(righthand17);
        righthand17.texOffs(47, 86).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.0F, false);

        righthand18 = new ModelRenderer(this);
        righthand18.setPos(0.0F, 4.0F, 0.0F);
        righthand17.addChild(righthand18);
        righthand18.texOffs(32, 86).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.01F, false);

        righthand19 = new ModelRenderer(this);
        righthand19.setPos(0.0F, 4.0F, 0.0F);
        righthand18.addChild(righthand19);
        righthand19.texOffs(17, 86).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 4.0F, 0.0F, false);

        righthand19_r1 = new ModelRenderer(this);
        righthand19_r1.setPos(-1.5F, 4.0F, 0.0F);
        righthand19.addChild(righthand19_r1);
        setRotationAngle(righthand19_r1, 0.0F, 0.0F, 0.3054F);
        righthand19_r1.texOffs(139, 0).addBox(0.0F, 0.0F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, true);

        righthand19_r2 = new ModelRenderer(this);
        righthand19_r2.setPos(1.5F, 4.0F, 0.0F);
        righthand19.addChild(righthand19_r2);
        setRotationAngle(righthand19_r2, 0.0F, 0.0F, -0.2618F);
        righthand19_r2.texOffs(139, 0).addBox(0.0F, 0.0F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, true);

        righthand19_r3 = new ModelRenderer(this);
        righthand19_r3.setPos(0.0F, 4.0F, 2.0F);
        righthand19.addChild(righthand19_r3);
        setRotationAngle(righthand19_r3, 0.3054F, 0.0F, 0.0F);
        righthand19_r3.texOffs(142, 7).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, 0.0F, true);

        righthand19_r4 = new ModelRenderer(this);
        righthand19_r4.setPos(0.0F, 4.0F, -2.0F);
        righthand19.addChild(righthand19_r4);
        setRotationAngle(righthand19_r4, -0.6109F, 0.0F, 0.0F);
        righthand19_r4.texOffs(142, 7).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, 0.0F, true);

        righthand19_r5 = new ModelRenderer(this);
        righthand19_r5.setPos(-1.5F, 0.0F, 0.0F);
        righthand19.addChild(righthand19_r5);
        setRotationAngle(righthand19_r5, 0.0F, 0.0F, 0.3054F);
        righthand19_r5.texOffs(131, -2).addBox(0.0F, 0.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, true);

        righthand19_r6 = new ModelRenderer(this);
        righthand19_r6.setPos(1.4991F, 0.0003F, 0.0F);
        righthand19.addChild(righthand19_r6);
        setRotationAngle(righthand19_r6, 0.0F, 0.0F, -0.3054F);
        righthand19_r6.texOffs(131, -2).addBox(0.0F, 0.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, false);

        righthand19_r7 = new ModelRenderer(this);
        righthand19_r7.setPos(0.0F, 0.0F, 2.0F);
        righthand19.addChild(righthand19_r7);
        setRotationAngle(righthand19_r7, 0.3054F, 0.0F, 0.0F);
        righthand19_r7.texOffs(142, 7).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F, 0.0F, true);

        righthand19_r8 = new ModelRenderer(this);
        righthand19_r8.setPos(0.0F, 0.0F, -2.0F);
        righthand19.addChild(righthand19_r8);
        setRotationAngle(righthand19_r8, -0.3054F, 0.0F, 0.0F);
        righthand19_r8.texOffs(142, 7).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F, 0.0F, true);

        righthand0 = new ModelRenderer(this);
        righthand0.setPos(0.0F, 4.0F, 0.0F);
        righthand19.addChild(righthand0);
        righthand0.texOffs(99, 96).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);

        lefthand21 = new ModelRenderer(this);
        lefthand21.setPos(-1.0F, 2.0F, 0.0F);
        righthand0.addChild(lefthand21);
        setRotationAngle(lefthand21, 0.0F, 0.0F, -0.3054F);
        lefthand21.texOffs(40, 28).addBox(0.0F, 0.0F, -2.0F, 2.0F, 3.0F, 4.0F, 0.0F, false);

        righthand2 = new ModelRenderer(this);
        righthand2.setPos(0.0F, 0.0F, -2.0F);
        righthand0.addChild(righthand2);
        setRotationAngle(righthand2, -0.1745F, 0.0F, -0.3054F);
        righthand2.texOffs(0, 49).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);

        neck = new ModelRenderer(this);
        neck.setPos(0.0F, -7.0F, 0.0F);
        body.addChild(neck);


        head = new ModelRenderer(this);
        head.setPos(0.0F, 0.0F, 0.0F);
        neck.addChild(head);
        head.texOffs(0, 0).addBox(-9.0F, -14.0F, -5.0F, 18.0F, 13.0F, 11.0F, 0.01F, false);
        head.texOffs(81, 117).addBox(-9.0F, -12.0F, -5.0F, 18.0F, 0.0F, 11.0F, 0.0F, false);
        head.texOffs(101, 78).addBox(-9.0F, -5.0F, -5.0F, 18.0F, 0.0F, 11.0F, 0.0F, false);
        head.texOffs(81, 106).addBox(-7.0F, -1.0F, -5.0F, 14.0F, 0.0F, 11.0F, 0.0F, false);
        head.texOffs(-4, 109).addBox(-6.0F, 0.0F, -5.0F, 12.0F, 0.0F, 11.0F, 0.0F, false);
        head.texOffs(42, 40).addBox(-6.0F, -11.1F, -4.9F, 12.0F, 11.0F, 9.0F, 0.0F, false);
        head.texOffs(0, 25).addBox(-7.0F, -12.0F, -5.0F, 14.0F, 12.0F, 11.0F, 0.0F, false);
        head.texOffs(102, 126).addBox(-6.1F, -1.0F, -5.0F, 12.0F, 1.0F, 11.0F, 0.0F, false);
        head.texOffs(112, 138).addBox(-5.0F, 0.0F, -4.0F, 10.0F, 2.0F, 8.0F, -0.01F, false);

        hide_bug = new ModelRenderer(this);
        hide_bug.setPos(0.0F, 1.0F, -4.0F);
        head.addChild(hide_bug);
        hide_bug.texOffs(92, 146).addBox(-5.0F, -1.0F, 0.0F, 10.0F, 2.0F, 0.0F, -0.01F, false);

        eyeball = new ModelRenderer(this);
        eyeball.setPos(2.5F, -8.5F, -4.5F);
        head.addChild(eyeball);
        eyeball.texOffs(0, 31).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);
        eyeball.texOffs(0, 31).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);

        eye1 = new ModelRenderer(this);
        eye1.setPos(-0.5F, -0.6F, -0.95F);
        eyeball.addChild(eye1);
        eye1.texOffs(0, 25).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 3.0F, 2.0F, -0.2F, false);

        eyeball2 = new ModelRenderer(this);
        eyeball2.setPos(-2.5F, -7.5F, -4.5F);
        head.addChild(eyeball2);
        eyeball2.texOffs(0, 6).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);
        eyeball2.texOffs(0, 6).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);

        eye2 = new ModelRenderer(this);
        eye2.setPos(0.5F, -0.4F, -0.95F);
        eyeball2.addChild(eye2);
        eye2.texOffs(0, 0).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 3.0F, 2.0F, -0.2F, false);

        lip = new ModelRenderer(this);
        lip.setPos(0.0F, -1.0F, 0.0F);
        head.addChild(lip);
        lip.texOffs(0, 52).addBox(-7.0F, -5.0F, -4.7F, 14.0F, 6.0F, 9.0F, 0.5F, false);

        teeth = new ModelRenderer(this);
        teeth.setPos(0.0F, -1.1512F, -2.1899F);
        lip.addChild(teeth);


        teeth_r1 = new ModelRenderer(this);
        teeth_r1.setPos(0.0F, 0.0F, 0.0F);
        teeth.addChild(teeth_r1);
        setRotationAngle(teeth_r1, 0.2182F, -0.3491F, 0.0F);
        teeth_r1.texOffs(64, 121).addBox(-5.0F, -4.0F, 0.0F, 14.0F, 4.0F, 0.0F, 0.0F, false);

        teeth_r2 = new ModelRenderer(this);
        teeth_r2.setPos(0.0F, 0.0F, 0.0F);
        teeth.addChild(teeth_r2);
        setRotationAngle(teeth_r2, 0.2182F, 0.3491F, 0.0F);
        teeth_r2.texOffs(64, 121).addBox(-9.0F, -4.0F, 0.0F, 14.0F, 4.0F, 0.0F, 0.0F, true);

        lip3 = new ModelRenderer(this);
        lip3.setPos(0.0F, 0.0F, 0.2F);
        head.addChild(lip3);
        lip3.texOffs(8, 120).addBox(-7.0F, -7.0F, -5.0F, 14.0F, 7.0F, 1.0F, 0.5F, false);

        lip2 = new ModelRenderer(this);
        lip2.setPos(0.0F, -7.0F, 0.0F);
        head.addChild(lip2);
        lip2.texOffs(50, 16).addBox(-7.0F, 0.0F, -4.7F, 14.0F, 6.0F, 9.0F, 0.51F, false);

        teeth2 = new ModelRenderer(this);
        teeth2.setPos(0.0F, 2.0F, -1.0F);
        lip2.addChild(teeth2);


        teeth2_r1 = new ModelRenderer(this);
        teeth2_r1.setPos(0.0F, 0.0F, 0.0F);
        teeth2.addChild(teeth2_r1);
        setRotationAngle(teeth2_r1, -0.2618F, 0.3491F, 0.0F);
        teeth2_r1.texOffs(64, 118).addBox(-9.0F, 0.261F, -0.9829F, 14.0F, 3.0F, 0.0F, 0.0F, true);

        teeth2_r2 = new ModelRenderer(this);
        teeth2_r2.setPos(0.0F, 0.0F, 0.0F);
        teeth2.addChild(teeth2_r2);
        setRotationAngle(teeth2_r2, -0.2618F, -0.3491F, 0.0F);
        teeth2_r2.texOffs(64, 118).addBox(-5.0F, 0.261F, -0.9829F, 14.0F, 3.0F, 0.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(HuggyWuggyEntity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        this.head.yRot = p_225597_5_ * ((float) Math.PI / 180F);
        this.head.xRot = p_225597_6_ * ((float) Math.PI / 180F);
        boolean flag = p_225597_1_.getFallFlyingTicks() > 4;
        float f = 1.0F;
        if (flag) {
            f = (float) p_225597_1_.getDeltaMovement().lengthSqr();
            f = f / 0.2F;
            f = f * f * f;
        }

        if (f < 1.0F) {
            f = 1.0F;
        }

        this.righthand1.xRot = MathHelper.cos(p_225597_2_ * 0.6662F + (float) Math.PI) * 2.0F * p_225597_3_ * 0.5F / f;
        this.lefthand.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 2.0F * p_225597_3_ * 0.5F / f;
        this.righthand1.zRot = 0.0F;
        this.lefthand.zRot = 0.0F;
        this.rightleg8.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_ / f;
        this.leftleg9.xRot = MathHelper.cos(p_225597_2_ * 0.6662F + (float) Math.PI) * 1.4F * p_225597_3_ / f;
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
    
    @Override
    public void renderToBuffer(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        rote.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_);
    }
}