package me.afek.huggywuggy.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.world.World;

public class HuggyWuggyEntity extends MobEntity {

    public HuggyWuggyEntity(EntityType<? extends MobEntity> p_i50221_1_, World p_i50221_2_) {
        super(p_i50221_1_, p_i50221_2_);
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 100.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.KNOCKBACK_RESISTANCE, 1.0D).add(Attributes.ATTACK_DAMAGE, 50.0D);
    }
}
