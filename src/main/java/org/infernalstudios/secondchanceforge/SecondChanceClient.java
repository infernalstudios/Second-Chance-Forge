package org.infernalstudios.secondchanceforge;

import org.infernalstudios.secondchanceforge.config.gui.ConfigScreen;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;

public class SecondChanceClient {

	public static void init() {
		// Registering Config GUI Extension Point
		ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.CONFIGGUIFACTORY, () -> (mc, screen) -> new ConfigScreen());
	}

}
