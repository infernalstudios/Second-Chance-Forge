package org.infernalstudios.secondchanceforge;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SecondChanceSoundEvents {
    // SOUNDS
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, SecondChanceForge.MOD_ID);

    public static final Holder<SoundEvent> CLASSIC_HURT = SOUND_EVENTS.register(
            "player.classic_hurt",
            SoundEvent::createVariableRangeEvent
    );
}
