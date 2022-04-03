package org.infernalstudios.secondchanceforge;

import org.infernalstudios.secondchanceforge.config.SecondChanceConfig;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
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

        if (entity instanceof Player) {
            Player player = (Player) entity;
            if (SecondChanceConfig.CONFIG.secondChanceEnabled.get() && ((SecondChanceConfig.CONFIG.secondChanceExplosions.get() && source.isExplosion()) || (SecondChanceConfig.CONFIG.secondChanceMobs.get() && source.getMsgId().equals("mob"))) && player.getHealth() <= event.getAmount() && player.getHealth() >= SecondChanceConfig.CONFIG.secondChanceActivationHealth.get()) {
                if (SecondChanceConfig.CONFIG.secondChanceSound.get()) {
                    player.getCommandSenderWorld().playSound(null, player.getX(), player.getY(), player.getZ(), SecondChanceSoundEvents.CLASSIC_HURT.get(), SoundSource.PLAYERS, 2.0F, 1.0F);
                }
                event.setAmount((float)(player.getHealth() - SecondChanceConfig.CONFIG.secondChanceHealthRemainder.get()));
            }
        }
    }

}
