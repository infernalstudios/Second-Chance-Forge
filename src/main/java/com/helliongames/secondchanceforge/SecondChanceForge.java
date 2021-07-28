package com.helliongames.secondchanceforge;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SecondChanceForge.MOD_ID)
public class SecondChanceForge {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "secondchanceforge";

    public SecondChanceForge() {
        final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new SecondChanceEvents());

        SecondChanceSoundEvents.register(modEventBus);
    }
}
