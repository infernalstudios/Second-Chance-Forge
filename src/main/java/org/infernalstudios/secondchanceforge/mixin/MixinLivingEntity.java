package org.infernalstudios.secondchanceforge.mixin;

import org.infernalstudios.secondchanceforge.config.SecondChanceConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity extends Entity {
    @Shadow private int noJumpDelay;

    @Shadow protected abstract void jumpFromGround();

    private int ticksFalling = 0;
    private boolean hasJumped = false;

    public MixinLivingEntity(EntityType<?> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
    }

    @Inject(method = "jumpFromGround", at = @At(value = "HEAD"))
    private void SCF_setHasJumped(CallbackInfo ci) {
        this.hasJumped = true;
    }

    @Inject(method = "aiStep", at = @At(value = "HEAD"))
    private void SCF_countTicksFalling(CallbackInfo ci) {
        if (!this.onGround) {
            this.ticksFalling++;
        } else if (!this.isInWater()) {
            this.ticksFalling = 0;
            this.hasJumped = false;
        }
    }

    @Inject(method = "aiStep", at = @At(target = "Lnet/minecraft/entity/LivingEntity;getFluidJumpThreshold()D", value = "INVOKE", shift = At.Shift.AFTER))
    private void SCF_coyoteTimeJump(CallbackInfo ci) {
        if (SecondChanceConfig.CONFIG.coyoteTimeEnabled.get() && this.ticksFalling <= SecondChanceConfig.CONFIG.coyoteTimeTicks.get() && !this.hasJumped && !this.isInWater()) {
            this.jumpFromGround();
            this.noJumpDelay = 10;
        }
    }
}
