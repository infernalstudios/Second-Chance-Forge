package com.infernalstudios.secondchanceforge;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SecondChanceSoundEvents {
    // SOUNDS
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SecondChanceForge.MOD_ID);

    public static final RegistryObject<SoundEvent> CLASSIC_HURT = add("player.classic_hurt");

    public static final RegistryObject<SoundEvent> add(String id) {
        ResourceLocation realId = new ResourceLocation(SecondChanceForge.MOD_ID, id);
        return SOUND_EVENTS.register(id, () -> new SoundEvent(realId));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
        SecondChanceForge.LOGGER.info("Second Chance: Sound Events Registered!");
    }
}
