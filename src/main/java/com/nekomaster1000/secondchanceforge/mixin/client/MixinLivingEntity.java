package com.nekomaster1000.secondchanceforge.mixin.client;

import com.nekomaster1000.secondchanceforge.config.SecondChanceConfig;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity extends Entity {
    @Shadow private int jumpTicks;

    @Shadow protected abstract void jump();

    private int ticksFalling = 0;
    private boolean hasJumped = false;

    public MixinLivingEntity(EntityType<?> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
    }

    @Inject(method = "jump", at = @At(value = "HEAD"))
    private void SCF_setHasJumped(CallbackInfo ci) {
        this.hasJumped = true;
    }

    @Inject(method = "livingTick", at = @At(value = "HEAD"))
    private void SCF_countTicksFalling(CallbackInfo ci) {
        if (!this.onGround) {
            this.ticksFalling++;
        } else {
            this.ticksFalling = 0;
            this.hasJumped = false;
        }
    }

    @Inject(method = "livingTick", at = @At(target = "Lnet/minecraft/entity/LivingEntity;getFluidJumpHeight()D", value = "INVOKE", shift = At.Shift.AFTER))
    private void SCF_coyoteTimeJump(CallbackInfo ci) {
        if (SecondChanceConfig.CONFIG.coyoteTimeEnabled.get() && this.ticksFalling <= 10 && !this.hasJumped) {
            this.jump();
            this.jumpTicks = 10;
        }
    }
}
