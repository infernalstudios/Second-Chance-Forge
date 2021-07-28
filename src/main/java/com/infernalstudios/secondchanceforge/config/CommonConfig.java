package com.infernalstudios.secondchanceforge.config;

import com.infernalstudios.secondchanceforge.SecondChanceForge;
import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig {
    final ForgeConfigSpec.BooleanValue coyoteTimeEnabled;
    final ForgeConfigSpec.BooleanValue secondChanceEnabled;

    CommonConfig(final ForgeConfigSpec.Builder builder) {
        builder.push("Second Chance Features");

        coyoteTimeEnabled = builder
                .comment("Determines if the 'Coyote Time' feature is enabled")
                .translation(SecondChanceForge.MOD_ID + ".config.tooltip.coyoteTimeEnabled")
                .define("coyoteTimeEnabled", true);

        secondChanceEnabled = builder
                .comment("Determines if the 'Second Chance' feature is enabled")
                .translation(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceEnabled")
                .define("secondChanceEnabled", true);

        builder.pop();
    }
}
