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

    public SecondChanceConfig(Builder builder) {
        coyoteTimeEnabled = builder
                .comment("Determines if the 'Coyote Time' feature is enabled")
                .translation(SecondChanceForge.MOD_ID + ".config.tooltip.coyoteTimeEnabled")
                .define("coyoteTimeEnabled", true);

        secondChanceEnabled = builder
                .comment("Determines if the 'Second Chance' feature is enabled")
                .translation(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceEnabled")
                .define("secondChanceEnabled", true);
    }
}
