package org.infernalstudios.secondchanceforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.infernalstudios.secondchanceforge.config.SecondChanceConfig;

@Mod(SecondChanceForge.MOD_ID)
public class SecondChanceForge {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "secondchanceforge";

    public SecondChanceForge(IEventBus modBus, ModContainer container) {
        SecondChanceSoundEvents.SOUND_EVENTS.register(modBus);
        container.registerConfig(ModConfig.Type.COMMON, SecondChanceConfig.CONFIG_SPEC);
    }
}
