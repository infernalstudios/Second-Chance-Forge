package org.infernalstudios.secondchanceforge;

import net.minecraftforge.client.ConfigGuiHandler;
import org.infernalstudios.secondchanceforge.config.gui.ConfigScreen;
import net.minecraftforge.fml.ModLoadingContext;

public class SecondChanceClient {

	public static void init() {
		// Registering Config GUI Extension Point
        ModLoadingContext.get().registerExtensionPoint(ConfigGuiHandler.ConfigGuiFactory.class, () -> new ConfigGuiHandler.ConfigGuiFactory(((minecraft, screen) -> new ConfigScreen())));
	}

}
