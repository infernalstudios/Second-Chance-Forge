package org.infernalstudios.secondchanceforge;

import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import org.infernalstudios.secondchanceforge.config.SecondChanceConfig;

@EventBusSubscriber(modid = SecondChanceForge.MOD_ID)
public class SecondChanceEvents {

    // Called when an entity takes damage
    @SubscribeEvent
    public static void onEntityDamage(LivingDamageEvent.Pre event) {
        LivingEntity entity = event.getEntity();
        DamageSource source = event.getSource();

        if (entity instanceof Player player) {
            double activationHealth = SecondChanceConfig.CONFIG.usePercentConfig.get() ? SecondChanceConfig.CONFIG.secondChanceActivationPercent.get() * player.getMaxHealth() : SecondChanceConfig.CONFIG.secondChanceActivationHealth.get();
            double remainderHealth = SecondChanceConfig.CONFIG.usePercentConfig.get() ? SecondChanceConfig.CONFIG.secondChanceRemainderPercent.get() * player.getMaxHealth() : SecondChanceConfig.CONFIG.secondChanceHealthRemainder.get();

            if (SecondChanceConfig.CONFIG.secondChanceEnabled.get() && player.getHealth() <= event.getOriginalDamage() && player.getHealth() >= activationHealth && canActivateSecondChance(source)) {
                if (SecondChanceConfig.CONFIG.secondChanceSound.get()) {
                    player.getCommandSenderWorld().playSound(null, player.getX(), player.getY(), player.getZ(), SecondChanceSoundEvents.CLASSIC_HURT, SoundSource.PLAYERS, 2.0F, 1.0F);
                }
                event.setNewDamage((float)(player.getHealth() - remainderHealth));
            }
        }
    }

    private static boolean canActivateSecondChance(DamageSource source) {
        boolean activateForExplosion = SecondChanceConfig.CONFIG.secondChanceExplosions.get() && source.is(DamageTypeTags.IS_EXPLOSION);
        boolean activateForMob = SecondChanceConfig.CONFIG.secondChanceMobs.get() && source.getMsgId().equals("mob");
        boolean activateForFallDamage = SecondChanceConfig.CONFIG.secondChanceFalls.get() && source.getMsgId().equals("fall");
        boolean activateForAnvil = SecondChanceConfig.CONFIG.secondChanceAnvils.get() && source.getMsgId().equals("anvil");
        boolean activateForLightning = SecondChanceConfig.CONFIG.secondChanceLightning.get() && source.is(DamageTypeTags.IS_LIGHTNING);
        boolean activateForElytraCrash = SecondChanceConfig.CONFIG.secondChanceElytraCrash.get() && source.getMsgId().equals("flyIntoWall");
        boolean activateForFallingBlocks = SecondChanceConfig.CONFIG.secondChanceFallingBlocks.get() && source.getMsgId().equals("fallingBlock");
        boolean activateForMagic = SecondChanceConfig.CONFIG.secondChanceMagic.get() && (source.getMsgId().equals("magic") || source.getMsgId().equals("indirect_magic"));
        boolean activateForPlayer = SecondChanceConfig.CONFIG.secondChancePlayers.get() && source.getMsgId().equals("player");
        boolean activateForTrident = SecondChanceConfig.CONFIG.secondChanceTridents.get() && source.getMsgId().equals("trident");
        boolean activateForArrow = SecondChanceConfig.CONFIG.secondChanceArrows.get() && source.getMsgId().equals("arrow");
        boolean activateForFirework = SecondChanceConfig.CONFIG.secondChanceFireworks.get() && source.getMsgId().equals("fireworks");
        boolean activateForWitherSkull = SecondChanceConfig.CONFIG.secondChanceWitherSkulls.get() && source.getMsgId().equals("witherSkull");
        boolean activateForStalactite = SecondChanceConfig.CONFIG.secondChanceStalactite.get() && source.getMsgId().equals("fallingStalactite");
        boolean activateForStalagmite = SecondChanceConfig.CONFIG.secondChanceStalagmite.get() && source.getMsgId().equals("stalagmite");

        return activateForExplosion || activateForMob || activateForFallDamage || activateForAnvil || activateForLightning ||
                activateForElytraCrash || activateForFallingBlocks || activateForMagic || activateForPlayer || activateForTrident ||
                activateForArrow || activateForFirework || activateForWitherSkull || activateForStalactite || activateForStalagmite;
    }

}
