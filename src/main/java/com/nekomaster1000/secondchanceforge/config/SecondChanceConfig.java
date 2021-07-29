package com.nekomaster1000.secondchanceforge.config;

import com.nekomaster1000.secondchanceforge.SecondChanceForge;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;

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

    public SecondChanceConfig(Builder builder) {
        coyoteTimeEnabled = builder
                .comment("Determines if the 'Coyote Time' feature is enabled\n" +
                        "'Coyote Time' allows the player to jump for a second or two after falling off of a block in order to stop themselves from falling into a pit\n" +
                        "This will not allow the player to double jump, only jump when walking off of a block")
                .define("coyoteTimeEnabled", true);

        secondChanceEnabled = builder
                .comment("Determines if the 'Second Chance' feature is enabled\n" +
                        "'Second Chance' leaves the player at half a heart after taking fatal damage from a mob or explosion while at or above 7 hearts")
                .define("secondChanceEnabled", true);

        secondChanceSound = builder
                .comment("Determines if the 'Second Chance' sound will play when the effect is activated")
                .define("secondChanceSound", true);
    }
}
