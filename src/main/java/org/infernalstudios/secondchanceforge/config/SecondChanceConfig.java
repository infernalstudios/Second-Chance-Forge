package org.infernalstudios.secondchanceforge.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;
import org.infernalstudios.secondchanceforge.SecondChanceForge;

public class SecondChanceConfig {
    public static final ModConfigSpec CONFIG_SPEC;
    public static final SecondChanceConfig CONFIG;

    static {
        Pair<SecondChanceConfig, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(SecondChanceConfig::new);

        CONFIG_SPEC = specPair.getRight();
        CONFIG = specPair.getLeft();
    }

    public final ModConfigSpec.BooleanValue coyoteTimeEnabled;
    public final ModConfigSpec.BooleanValue secondChanceEnabled;
    public final ModConfigSpec.BooleanValue secondChanceSound;
    public final ModConfigSpec.BooleanValue secondChanceExplosions;
    public final ModConfigSpec.BooleanValue secondChanceMobs;
    public final ModConfigSpec.BooleanValue secondChanceFalls;
    public final ModConfigSpec.BooleanValue secondChanceAnvils;
    public final ModConfigSpec.BooleanValue secondChanceLightning;
    public final ModConfigSpec.BooleanValue secondChanceElytraCrash;
    public final ModConfigSpec.BooleanValue secondChanceFallingBlocks;
    public final ModConfigSpec.BooleanValue secondChanceMagic;
    public final ModConfigSpec.BooleanValue secondChancePlayers;
    public final ModConfigSpec.BooleanValue secondChanceTridents;
    public final ModConfigSpec.BooleanValue secondChanceArrows;
    public final ModConfigSpec.BooleanValue secondChanceFireworks;
    public final ModConfigSpec.BooleanValue secondChanceWitherSkulls;
    public final ModConfigSpec.BooleanValue secondChanceStalactite;
    public final ModConfigSpec.BooleanValue secondChanceStalagmite;

    public final ModConfigSpec.IntValue coyoteTimeTicks;
    public final ModConfigSpec.BooleanValue usePercentConfig;
    public final ModConfigSpec.DoubleValue secondChanceActivationHealth;
    public final ModConfigSpec.DoubleValue secondChanceHealthRemainder;
    public final ModConfigSpec.DoubleValue secondChanceActivationPercent;
    public final ModConfigSpec.DoubleValue secondChanceRemainderPercent;

    private SecondChanceConfig(ModConfigSpec.Builder builder) {
        builder.push("coyoteTime");

        coyoteTimeEnabled = builder
                .comment("Determines if the 'Coyote Time' feature is enabled.\n" +
                        "'Coyote Time' allows the player to jump for a second or two after falling off of a block in order to stop themselves from falling into a pit.\n" +
                        "This will not allow the player to double jump, only jump when walking off of a block.")
                .translation(SecondChanceForge.MOD_ID + ".config.coyoteTimeEnabled")
                .define("coyoteTimeEnabled", true);

        coyoteTimeTicks = builder
                .comment("Determines how long (in ticks) the player has to jump with 'Coyote Time' after falling off a block.")
                .translation(SecondChanceForge.MOD_ID + ".config.coyoteTimeTicks")
                .defineInRange("coyoteTimeTicks", 10, 1, Integer.MAX_VALUE);

        builder.pop();

        builder.push("secondChance");

        secondChanceEnabled = builder
                .comment("Determines if the 'Second Chance' feature is enabled.\n" +
                        "'Second Chance' leaves the player at half a heart after taking fatal damage from a mob or explosion while at or above 7 hearts.")
                .translation(SecondChanceForge.MOD_ID + ".config.secondChanceEnabled")
                .define("secondChanceEnabled", true);

        secondChanceSound = builder
                .comment("Determines if the 'Second Chance' sound will play when the effect is activated.")
                .translation(SecondChanceForge.MOD_ID + ".config.secondChanceSound")
                .define("secondChanceSound", true);

        usePercentConfig = builder
                .comment("Determines if the 'percentage of health' config values will be used instead of exact values.")
                .translation(SecondChanceForge.MOD_ID + ".config.usePercentConfig")
                .define("usePercentConfig", false);

        secondChanceActivationHealth = builder
                .comment("Determines how much health the player must start with for 'Second Chance' to activate.")
                .translation(SecondChanceForge.MOD_ID + ".config.secondChanceActivationHealth")
                .defineInRange("secondChanceActivationHealth", 13.5D, 0.5D, Double.MAX_VALUE);

        secondChanceHealthRemainder = builder
                .comment("Determines how much health the player should be left with after 'Second Chance' activates.")
                .translation(SecondChanceForge.MOD_ID + ".config.secondChanceHealthRemainder")
                .defineInRange("secondChanceHealthRemainder", 1.0D, 1.0D, Double.MAX_VALUE);

        secondChanceActivationPercent = builder
                .comment("Determines what percent of health the player must start with for 'Second Chance' to activate.")
                .translation(SecondChanceForge.MOD_ID + ".config.secondChanceActivationPercent")
                .defineInRange("secondChanceActivationPercent", 0.65D, 0.01D, Double.MAX_VALUE);

        secondChanceRemainderPercent = builder
                .comment("Determines what percent health the player should be left with after 'Second Chance' activates.")
                .translation(SecondChanceForge.MOD_ID + ".config.secondChanceRemainderPercent")
                .defineInRange("secondChanceHealthPercent", 0.05D, 0.01D, Double.MAX_VALUE);

        builder.push("damageTypes");

        secondChanceExplosions = builder
                .comment("Determines if the 'Second Chance' feature will be activated by explosions.")
                .translation(SecondChanceForge.MOD_ID + ".config.secondChanceExplosions")
                .define("secondChanceExplosions", true);

        secondChanceMobs = builder
                .comment("Determines if the 'Second Chance' feature will be activated by mobs.")
                .translation(SecondChanceForge.MOD_ID + ".config.secondChanceMobs")
                .define("secondChanceMobs", true);

        secondChanceFalls = builder
                .comment("Determines if the 'Second Chance' feature will be activated by fall damage.")
                .translation(SecondChanceForge.MOD_ID + ".config.secondChanceFalls")
                .define("secondChanceFalls", false);

        secondChanceAnvils = builder
                .comment("Determines if the 'Second Chance' feature will be activated by falling anvils.")
                .translation(SecondChanceForge.MOD_ID + ".config.secondChanceAnvils")
                .define("secondChanceAnvils", false);

        secondChanceLightning = builder
                .comment("Determines if the 'Second Chance' feature will be activated by lightning.")
                .translation(SecondChanceForge.MOD_ID + ".config.secondChanceLightning")
                .define("secondChanceLightning", false);

        secondChanceElytraCrash = builder
                .comment("Determines if the 'Second Chance' feature will be activated by crashing into a wall.")
                .translation(SecondChanceForge.MOD_ID + ".config.secondChanceElytraCrash")
                .define("secondChanceElytraCrash", false);

        secondChanceFallingBlocks = builder
                .comment("Determines if the 'Second Chance' feature will be activated by falling blocks.")
                .translation(SecondChanceForge.MOD_ID + ".config.secondChanceFallingBlocks")
                .define("secondChanceFallingBlocks", false);

        secondChanceMagic = builder
                .comment("Determines if the 'Second Chance' feature will be activated by magic, such as potions.")
                .translation(SecondChanceForge.MOD_ID + ".config.secondChanceMagic")
                .define("secondChanceMagic", false);

        secondChancePlayers = builder
                .comment("Determines if the 'Second Chance' feature will be activated by players.")
                .translation(SecondChanceForge.MOD_ID + ".config.secondChancePlayers")
                .define("secondChancePlayers", false);

        secondChanceTridents = builder
                .comment("Determines if the 'Second Chance' feature will be activated by thrown tridents.")
                .translation(SecondChanceForge.MOD_ID + ".config.secondChanceTridents")
                .define("secondChanceTridents", false);

        secondChanceArrows = builder
                .comment("Determines if the 'Second Chance' feature will be activated by arrows.")
                .translation(SecondChanceForge.MOD_ID + ".config.secondChanceArrows")
                .define("secondChanceArrows", false);

        secondChanceFireworks = builder
                .comment("Determines if the 'Second Chance' feature will be activated by fireworks.")
                .translation(SecondChanceForge.MOD_ID + ".config.secondChanceFireworks")
                .define("secondChanceFireworks", false);

        secondChanceWitherSkulls = builder
                .comment("Determines if the 'Second Chance' feature will be activated by wither skulls.")
                .translation(SecondChanceForge.MOD_ID + ".config.secondChanceWitherSkulls")
                .define("secondChanceWitherSkulls", false);

        secondChanceStalactite = builder
                .comment("Determines if the 'Second Chance' feature will be activated by a falling stalactite.")
                .translation(SecondChanceForge.MOD_ID + ".config.secondChanceStalactite")
                .define("secondChanceStalactite", false);

        secondChanceStalagmite = builder
                .comment("Determines if the 'Second Chance' feature will be activated by falling on a stalagmite.")
                .translation(SecondChanceForge.MOD_ID + ".config.secondChanceStalagmite")
                .define("secondChanceStalagmite", false);

        builder.pop(2);
    }
}
