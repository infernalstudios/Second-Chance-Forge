package org.infernalstudios.secondchanceforge.config.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.CycleOption;
import org.infernalstudios.secondchanceforge.SecondChanceForge;
import org.infernalstudios.secondchanceforge.config.SecondChanceConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.OptionsSubScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.OptionsList;
import net.minecraft.client.ProgressOption;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class ConfigScreen extends Screen {

	private OptionsList optionsRowList;

	public ConfigScreen() {
		super(new TranslatableComponent(SecondChanceForge.MOD_ID + ".config.title"));
	}

	@Override
	public void init() {
		optionsRowList = new OptionsList(minecraft, width, height, 24, height - 32, 25);

		// Coyote Time Enabled
		optionsRowList.addBig(CycleOption.createOnOff(SecondChanceForge.MOD_ID + ".config.option.coyoteTimeEnabled",
				new TranslatableComponent(SecondChanceForge.MOD_ID + ".config.tooltip.coyoteTimeEnabled"),
				settings -> SecondChanceConfig.CONFIG.coyoteTimeEnabled.get(), (settings, option, value) -> SecondChanceConfig.CONFIG.coyoteTimeEnabled.set(value)
		));

		// Coyote Time Ticks
		optionsRowList.addBig(new ProgressOption(SecondChanceForge.MOD_ID + ".config.option.coyoteTimeTicks", 1, 100, 1,
				settings -> SecondChanceConfig.CONFIG.coyoteTimeTicks.get().doubleValue(), (settings, value) -> SecondChanceConfig.CONFIG.coyoteTimeTicks.set(value.intValue()),
				(settings, option) -> new TranslatableComponent("options.generic_value", option.getCaption(), // getBaseMessageTranslation() is protected by default, use an access transformer to be able to use it
                        new TextComponent(Double.toString((double) Math.round(option.get(settings) * 100) / 100))),
                (minecraft) -> minecraft.font.split(
                        new TranslatableComponent(SecondChanceForge.MOD_ID + ".config.tooltip.coyoteTimeTicks"), 200)
			)
		);

		// Second Chance Enabled
		optionsRowList.addBig(CycleOption.createOnOff(SecondChanceForge.MOD_ID + ".config.option.secondChanceEnabled",
				new TranslatableComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceEnabled"),
                settings -> SecondChanceConfig.CONFIG.secondChanceEnabled.get(), (settings, option, value) -> SecondChanceConfig.CONFIG.secondChanceEnabled.set(value)
		));

		// Second Chance Sound
		optionsRowList.addBig(CycleOption.createOnOff(SecondChanceForge.MOD_ID + ".config.option.secondChanceSound",
				new TranslatableComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceSound"),
				settings -> SecondChanceConfig.CONFIG.secondChanceSound.get(), (settings, option, value) -> SecondChanceConfig.CONFIG.secondChanceSound.set(value)
		));

        // Second Chance Explosions
        optionsRowList.addBig(CycleOption.createOnOff(SecondChanceForge.MOD_ID + ".config.option.secondChanceExplosions",
                new TranslatableComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceExplosions"),
                settings -> SecondChanceConfig.CONFIG.secondChanceExplosions.get(), (settings, option, value) -> SecondChanceConfig.CONFIG.secondChanceExplosions.set(value)
        ));

        // Second Chance Mobs
        optionsRowList.addBig(CycleOption.createOnOff(SecondChanceForge.MOD_ID + ".config.option.secondChanceMobs",
                new TranslatableComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceMobs"),
                settings -> SecondChanceConfig.CONFIG.secondChanceMobs.get(), (settings, option, value) -> SecondChanceConfig.CONFIG.secondChanceMobs.set(value)
        ));

		// Second Chance Activation Health
		optionsRowList.addBig(new ProgressOption(SecondChanceForge.MOD_ID + ".config.option.secondChanceActivationHealth", 0.5D, 20.0D, 0.5F,
                settings -> SecondChanceConfig.CONFIG.secondChanceActivationHealth.get(), (settings, value) -> SecondChanceConfig.CONFIG.secondChanceActivationHealth.set(value),
                (settings, option) -> new TranslatableComponent("options.generic_value", option.getCaption(), // getBaseMessageTranslation() is protected by default, use an access transformer to be able to use it
                        new TextComponent(Double.toString((double) Math.round(option.get(settings) * 100) / 100))),
                (minecraft) -> minecraft.font.split(
                        new TranslatableComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceActivationHealth"), 200)
                )
        );

		// Second Chance Activation Health
		optionsRowList.addBig(new ProgressOption(SecondChanceForge.MOD_ID + ".config.option.secondChanceHealthRemainder", 0.5D, 20.0D, 0.5F,
                settings -> SecondChanceConfig.CONFIG.secondChanceHealthRemainder.get(), (settings, value) -> SecondChanceConfig.CONFIG.secondChanceHealthRemainder.set(value),
                (settings, option) -> new TranslatableComponent("options.generic_value", option.getCaption(), // getBaseMessageTranslation() is protected by default, use an access transformer to be able to use it
                        new TextComponent(Double.toString((double) Math.round(option.get(settings) * 100) / 100))),
                (minecraft) -> minecraft.font.split(
                        new TranslatableComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceHealthRemainder"), 200)
				)
		);

		children.add(optionsRowList); // children is private by default, use an access transformer to be able to use it

		addRenderableWidget(new Button((width - 200) / 2, height - 26, 200, 20, new TranslatableComponent("gui.done"), button -> onClose()));
	}

	@Override
	public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		renderBackground(matrixStack);

		optionsRowList.render(matrixStack, mouseX, mouseY, partialTicks);

		List<FormattedCharSequence> list = OptionsSubScreen.tooltipAt(optionsRowList, mouseX, mouseY);
		if (list != null) {
			this.renderTooltip(matrixStack, list, mouseX, mouseY);
		}

		// The parameter names for this function are wrong. The three integers at the end should be x, y, color
		drawCenteredString(matrixStack, font, title, width / 2, 8, 0xFFFFFF);

		super.render(matrixStack, mouseX, mouseY, partialTicks);
	}
}
