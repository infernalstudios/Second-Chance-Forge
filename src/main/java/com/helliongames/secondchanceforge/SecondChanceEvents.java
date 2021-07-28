package com.helliongames.secondchanceforge;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SecondChanceForge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SecondChanceEvents {

    @SubscribeEvent
    public void onEntityDamage(LivingDamageEvent event) {
        LivingEntity entity = event.getEntityLiving();
        DamageSource source = event.getSource();

        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            if ((source.isExplosion() || source.getDamageType().equals("mob")) && player.getHealth() <= event.getAmount() && player.getHealth() >= 13.5F) {
                player.getEntityWorld().playSound(null, player.getPosX(), player.getPosY(), player.getPosZ(), SecondChanceSoundEvents.CLASSIC_HURT.get(), SoundCategory.PLAYERS, 2.0F, 1.0F);
                event.setAmount(player.getHealth() - 1.0F);
            }
        }
    }

}
