package org.infernalstudios.secondchanceforge.config;

import org.infernalstudios.secondchanceforge.SecondChanceForge;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import org.apache.commons.lang3.tuple.Pair;

public class SecondChanceConfig {
    public static final ForgeConfigSpec CONFIG_SPEC;
    public static final SecondChanceConfig CONFIG;

    static {
        Pair<SecondChanceConfig, ForgeConfigSpec> specPair = new Builder().configure(SecondChanceConfig::new);

        CONFIG_SPEC = specPair.getRight();
        CONFIG = specPair.getLeft();
    }

    public final ForgeConfigSpec.BooleanValue coyoteTimeEnabled;
    public final ForgeConfigSpec.BooleanValue secondChanceEnabled;
    public final ForgeConfigSpec.BooleanValue secondChanceSound;
    public final ForgeConfigSpec.BooleanValue secondChanceExplosions;
    public final ForgeConfigSpec.BooleanValue secondChanceMobs;
    public final ForgeConfigSpec.IntValue coyoteTimeTicks;
    public final ForgeConfigSpec.BooleanValue usePercentConfig;
    public final ForgeConfigSpec.DoubleValue secondChanceActivationHealth;
    public final ForgeConfigSpec.DoubleValue secondChanceHealthRemainder;
    public final ForgeConfigSpec.DoubleValue secondChanceActivationPercent;
    public final ForgeConfigSpec.DoubleValue secondChanceRemainderPercent;

    public SecondChanceConfig(Builder builder) {
        coyoteTimeEnabled = builder
                .comment("Determines if the 'Coyote Time' feature is enabled.\n" +
                        "'Coyote Time' allows the player to jump for a second or two after falling off of a block in order to stop themselves from falling into a pit.\n" +
                        "This will not allow the player to double jump, only jump when walking off of a block.")
                .translation(SecondChanceForge.MOD_ID + ".config.tooltip.coyoteTimeEnabled")
                .define("coyoteTimeEnabled", true);

        coyoteTimeTicks = builder
                .comment("Determines how long (in ticks) the player has to jump with 'Coyote Time' after falling off a block.")
                .translation(SecondChanceForge.MOD_ID + ".config.tooltip.coyoteTimeTicks")
                .defineInRange("coyoteTimeTicks", 10, 1, Integer.MAX_VALUE);

        secondChanceEnabled = builder
                .comment("Determines if the 'Second Chance' feature is enabled.\n" +
                        "'Second Chance' leaves the player at half a heart after taking fatal damage from a mob or explosion while at or above 7 hearts.")
                .translation(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceEnabled")
                .define("secondChanceEnabled", true);

        secondChanceSound = builder
                .comment("Determines if the 'Second Chance' sound will play when the effect is activated.")
                .translation(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceSound")
                .define("secondChanceSound", true);

        secondChanceExplosions = builder
                .comment("Determines if the 'Second Chance' feature will be activated by explosions.")
                .translation(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceExplosions")
                .define("secondChanceExplosions", true);

        secondChanceMobs = builder
                .comment("Determines if the 'Second Chance' feature will be activated by mobs.")
                .translation(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceMobs")
                .define("secondChanceMobs", true);

        usePercentConfig = builder
                .comment("Determines if the 'percentage of health' config values will be used instead of exact values.")
                .translation(SecondChanceForge.MOD_ID + ".config.tooltip.usePercentConfig")
                .define("usePercentConfig", false);

        secondChanceActivationHealth = builder
                .comment("Determines how much health the player must start with for 'Second Chance' to activate.")
                .translation(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceActivationHealth")
                .defineInRange("secondChanceActivationHealth", 13.5D, 0.5D, Double.MAX_VALUE);

        secondChanceHealthRemainder = builder
                .comment("Determines how much health the player should be left with after 'Second Chance' activates.")
                .translation(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceHealthRemainder")
                .defineInRange("secondChanceHealthRemainder", 1.0D, 1.0D, Double.MAX_VALUE);

        secondChanceActivationPercent = builder
                .comment("Determines what percent of health the player must start with for 'Second Chance' to activate.")
                .translation(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceActivationPercent")
                .defineInRange("secondChanceActivationPercent", 65.0D, 0.01D, Double.MAX_VALUE);

        secondChanceRemainderPercent = builder
                .comment("Determines what percent health the player should be left with after 'Second Chance' activates.")
                .translation(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceRemainderPercent")
                .defineInRange("secondChanceHealthPercent", 5.0D, 0.01D, Double.MAX_VALUE);
    }
}
