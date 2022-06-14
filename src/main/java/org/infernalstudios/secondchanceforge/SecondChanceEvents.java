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

            if (SecondChanceConfig.CONFIG.secondChanceEnabled.get() && canActivateSecondChance(source) && player.getHealth() <= event.getAmount() && player.getHealth() >= activationHealth) {
                if (SecondChanceConfig.CONFIG.secondChanceSound.get()) {
                    player.getCommandSenderWorld().playSound(null, player.getX(), player.getY(), player.getZ(), SecondChanceSoundEvents.CLASSIC_HURT.get(), SoundCategory.PLAYERS, 2.0F, 1.0F);
                }
                event.setAmount((float)(player.getHealth() - remainderHealth));
            }
        }
    }

    private boolean canActivateSecondChance(DamageSource source) {
        boolean activateForExplosion = SecondChanceConfig.CONFIG.secondChanceExplosions.get() && source.isExplosion();
        boolean activateForMob = SecondChanceConfig.CONFIG.secondChanceMobs.get() && source.getMsgId().equals("mob");
        boolean activateForFallDamage = SecondChanceConfig.CONFIG.secondChanceFalls.get() && source.getMsgId().equals("fall");
        boolean activateForAnvil = SecondChanceConfig.CONFIG.secondChanceAnvils.get() && source.getMsgId().equals("anvil");
        boolean activateForLightning = SecondChanceConfig.CONFIG.secondChanceLightning.get() && source.getMsgId().equals("lightningBolt");
        boolean activateForElytraCrash = SecondChanceConfig.CONFIG.secondChanceElytraCrash.get() && source.getMsgId().equals("flyIntoWall");
        boolean activateForFallingBlocks = SecondChanceConfig.CONFIG.secondChanceFallingBlocks.get() && source.getMsgId().equals("fallingBlock");
        boolean activateForMagic = SecondChanceConfig.CONFIG.secondChanceMagic.get() && source.isMagic();
        boolean activateForPlayer = SecondChanceConfig.CONFIG.secondChancePlayers.get() && source.getMsgId().equals("player");
        boolean activateForTrident = SecondChanceConfig.CONFIG.secondChanceTridents.get() && source.getMsgId().equals("trident");
        boolean activateForArrow = SecondChanceConfig.CONFIG.secondChanceArrows.get() && source.getMsgId().equals("arrow");
        boolean activateForFirework = SecondChanceConfig.CONFIG.secondChanceFireworks.get() && source.getMsgId().equals("fireworks");
        boolean activateForWitherSkull = SecondChanceConfig.CONFIG.secondChanceWitherSkulls.get() && source.getMsgId().equals("witherSkull");

        return activateForExplosion || activateForMob || activateForFallDamage || activateForAnvil || activateForLightning ||
                activateForElytraCrash || activateForFallingBlocks || activateForMagic || activateForPlayer || activateForTrident ||
                activateForArrow || activateForFirework || activateForWitherSkull;
    }

}
