package org.infernalstudios.secondchanceforge;

import org.infernalstudios.secondchanceforge.config.SecondChanceConfig;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SecondChanceForge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SecondChanceEvents {

    // Called when an entity takes damage
    @SubscribeEvent
    public void onEntityDamage(LivingDamageEvent event) {
        LivingEntity entity = event.getEntityLiving();
        DamageSource source = event.getSource();

        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            double activationHealth = SecondChanceConfig.CONFIG.usePercentConfig.get() ? SecondChanceConfig.CONFIG.secondChanceActivationPercent.get() * player.getMaxHealth() / 100 : SecondChanceConfig.CONFIG.secondChanceActivationHealth.get();
            double remainderHealth = SecondChanceConfig.CONFIG.usePercentConfig.get() ? SecondChanceConfig.CONFIG.secondChanceRemainderPercent.get() * player.getMaxHealth() / 100 : SecondChanceConfig.CONFIG.secondChanceHealthRemainder.get();

            if (SecondChanceConfig.CONFIG.secondChanceEnabled.get() && ((SecondChanceConfig.CONFIG.secondChanceExplosions.get() && source.isExplosion()) || (SecondChanceConfig.CONFIG.secondChanceMobs.get() && source.getMsgId().equals("mob"))) && player.getHealth() <= event.getAmount() && player.getHealth() >= activationHealth) {
                if (SecondChanceConfig.CONFIG.secondChanceSound.get()) {
                    player.getCommandSenderWorld().playSound(null, player.getX(), player.getY(), player.getZ(), SecondChanceSoundEvents.CLASSIC_HURT.get(), SoundCategory.PLAYERS, 2.0F, 1.0F);
                }
                event.setAmount((float)(player.getHealth() - remainderHealth));
            }
        }
    }

}
