package org.infernalstudios.secondchanceforge.config.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import org.infernalstudios.secondchanceforge.SecondChanceForge;
import org.infernalstudios.secondchanceforge.config.SecondChanceConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.SettingsScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.list.OptionsRowList;
import net.minecraft.client.settings.BooleanOption;
import net.minecraft.client.settings.SliderPercentageOption;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class ConfigScreen extends Screen {

	private OptionsRowList optionsRowList;

	public ConfigScreen() {
		super(new TranslationTextComponent(SecondChanceForge.MOD_ID + ".config.title"));
	}

	@Override
	public void init() {
		optionsRowList = new OptionsRowList(minecraft, width, height, 24, height - 32, 25);

		// Coyote Time Enabled
		optionsRowList.addBig(new BooleanOption(SecondChanceForge.MOD_ID + ".config.option.coyoteTimeEnabled",
				new TranslationTextComponent(SecondChanceForge.MOD_ID + ".config.tooltip.coyoteTimeEnabled"),
				settings -> SecondChanceConfig.CONFIG.coyoteTimeEnabled.get(), (settings, value) -> SecondChanceConfig.CONFIG.coyoteTimeEnabled.set(value)
		));

		// Coyote Time Ticks
		optionsRowList.addBig(new SliderPercentageOption(SecondChanceForge.MOD_ID + ".config.option.coyoteTimeTicks", 1, 100, 1,
				settings -> SecondChanceConfig.CONFIG.coyoteTimeTicks.get().doubleValue(), (settings, value) -> SecondChanceConfig.CONFIG.coyoteTimeTicks.set(value.intValue()),
				(settings, option) -> {
					option.setTooltip(Minecraft.getInstance().font.split(
							new TranslationTextComponent(SecondChanceForge.MOD_ID + ".config.tooltip.coyoteTimeTicks"), 200));

					return new TranslationTextComponent("options.generic_value", option.getCaption(), // getBaseMessageTranslation() is protected by default, use an access transformer to be able to use it
							new StringTextComponent(Double.toString((double) Math.round(option.get(settings) * 100) / 100)));
				}
			)
		);

		// Second Chance Enabled
		optionsRowList.addBig(new BooleanOption(SecondChanceForge.MOD_ID + ".config.option.secondChanceEnabled",
				new TranslationTextComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceEnabled"),
				settings -> SecondChanceConfig.CONFIG.secondChanceEnabled.get(), (settings, value) -> SecondChanceConfig.CONFIG.secondChanceEnabled.set(value)
		));

		// Second Chance Sound
		optionsRowList.addBig(new BooleanOption(SecondChanceForge.MOD_ID + ".config.option.secondChanceSound",
				new TranslationTextComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceSound"),
				settings -> SecondChanceConfig.CONFIG.secondChanceSound.get(), (settings, value) -> SecondChanceConfig.CONFIG.secondChanceSound.set(value)
		));

        // Second Chance Explosions
        optionsRowList.addBig(new BooleanOption(SecondChanceForge.MOD_ID + ".config.option.secondChanceExplosions",
                new TranslationTextComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceExplosions"),
                settings -> SecondChanceConfig.CONFIG.secondChanceExplosions.get(), (settings, value) -> SecondChanceConfig.CONFIG.secondChanceExplosions.set(value)
        ));

        // Second Chance Mobs
        optionsRowList.addBig(new BooleanOption(SecondChanceForge.MOD_ID + ".config.option.secondChanceMobs",
                new TranslationTextComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceMobs"),
                settings -> SecondChanceConfig.CONFIG.secondChanceMobs.get(), (settings, value) -> SecondChanceConfig.CONFIG.secondChanceMobs.set(value)
        ));

		// Second Chance Activation Health
		optionsRowList.addBig(new SliderPercentageOption(SecondChanceForge.MOD_ID + ".config.option.secondChanceActivationHealth", 0.5D, 100.0D, 0.5F,
						settings -> SecondChanceConfig.CONFIG.secondChanceActivationHealth.get(), (settings, value) -> SecondChanceConfig.CONFIG.secondChanceActivationHealth.set(value),
						(settings, option) -> {
							option.setTooltip(Minecraft.getInstance().font.split(
									new TranslationTextComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceActivationHealth"), 200));

							return new TranslationTextComponent("options.generic_value", option.getCaption(), // getBaseMessageTranslation() is protected by default, use an access transformer to be able to use it
									new StringTextComponent(Double.toString((double) Math.round(option.get(settings) * 100) / 100)));
						}
				)
		);

		// Second Chance Health Remainder
		optionsRowList.addBig(new SliderPercentageOption(SecondChanceForge.MOD_ID + ".config.option.secondChanceHealthRemainder", 0.5D, 100.0D, 0.5F,
						settings -> SecondChanceConfig.CONFIG.secondChanceHealthRemainder.get(), (settings, value) -> SecondChanceConfig.CONFIG.secondChanceHealthRemainder.set(value),
						(settings, option) -> {
							option.setTooltip(Minecraft.getInstance().font.split(
									new TranslationTextComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceHealthRemainder"), 200));

							return new TranslationTextComponent("options.generic_value", option.getCaption(), // getBaseMessageTranslation() is protected by default, use an access transformer to be able to use it
									new StringTextComponent(Double.toString((double) Math.round(option.get(settings) * 100) / 100)));
						}
				)
		);

		children.add(optionsRowList);

		addButton(new Button((width - 200) / 2, height - 26, 200, 20, new TranslationTextComponent("gui.done"), button -> onClose()));
	}

	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		renderBackground(matrixStack);

		optionsRowList.render(matrixStack, mouseX, mouseY, partialTicks);

		List<IReorderingProcessor> list = SettingsScreen.tooltipAt(optionsRowList, mouseX, mouseY);
		if (list != null) {
			this.renderTooltip(matrixStack, list, mouseX, mouseY);
		}

		// The parameter names for this function are wrong. The three integers at the end should be x, y, color
		drawCenteredString(matrixStack, font, title, width / 2, 8, 0xFFFFFF);

		super.render(matrixStack, mouseX, mouseY, partialTicks);
	}
}
