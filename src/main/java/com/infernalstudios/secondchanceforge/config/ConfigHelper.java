package com.infernalstudios.secondchanceforge.config;

import com.infernalstudios.secondchanceforge.config.SecondChanceConfig.FeatureConfig;

import net.minecraftforge.fml.config.ModConfig;

import javax.annotation.Nullable;

public class ConfigHelper {

    //Common
    public static void bakeCommon(@Nullable final ModConfig config) {
        FeatureConfig.COYOTE_TIME_ENABLED.setBoolean(ConfigHolder.COMMON.coyoteTimeEnabled.get());
        FeatureConfig.SECOND_CHANCE_ENABLED.setBoolean(ConfigHolder.COMMON.secondChanceEnabled.get());
    }

    public static void saveToCommon() {
        ConfigHolder.COMMON.coyoteTimeEnabled.set(FeatureConfig.COYOTE_TIME_ENABLED.getBoolean());
        ConfigHolder.COMMON.secondChanceEnabled.set(FeatureConfig.SECOND_CHANCE_ENABLED.getBoolean());

        ConfigHolder.COMMON_SPEC.save();
    }
}
