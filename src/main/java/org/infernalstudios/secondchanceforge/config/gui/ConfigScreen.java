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

        // Second Chance Falls
        optionsRowList.addBig(new BooleanOption(SecondChanceForge.MOD_ID + ".config.option.secondChanceFalls",
                new TranslationTextComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceFalls"),
                settings -> SecondChanceConfig.CONFIG.secondChanceFalls.get(), (settings, value) -> SecondChanceConfig.CONFIG.secondChanceFalls.set(value)
        ));

        // Second Chance Anvils
        optionsRowList.addBig(new BooleanOption(SecondChanceForge.MOD_ID + ".config.option.secondChanceAnvils",
                new TranslationTextComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceAnvils"),
                settings -> SecondChanceConfig.CONFIG.secondChanceAnvils.get(), (settings, value) -> SecondChanceConfig.CONFIG.secondChanceAnvils.set(value)
        ));

        // Second Chance Lightning
        optionsRowList.addBig(new BooleanOption(SecondChanceForge.MOD_ID + ".config.option.secondChanceLightning",
                new TranslationTextComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceLightning"),
                settings -> SecondChanceConfig.CONFIG.secondChanceLightning.get(), (settings, value) -> SecondChanceConfig.CONFIG.secondChanceLightning.set(value)
        ));

        // Second Chance Elytra Crash
        optionsRowList.addBig(new BooleanOption(SecondChanceForge.MOD_ID + ".config.option.secondChanceElytraCrash",
                new TranslationTextComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceElytraCrash"),
                settings -> SecondChanceConfig.CONFIG.secondChanceElytraCrash.get(), (settings, value) -> SecondChanceConfig.CONFIG.secondChanceElytraCrash.set(value)
        ));

        // Second Chance Falling Blocks
        optionsRowList.addBig(new BooleanOption(SecondChanceForge.MOD_ID + ".config.option.secondChanceFallingBlocks",
                new TranslationTextComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceFallingBlocks"),
                settings -> SecondChanceConfig.CONFIG.secondChanceFallingBlocks.get(), (settings, value) -> SecondChanceConfig.CONFIG.secondChanceFallingBlocks.set(value)
        ));

        // Second Chance Magic
        optionsRowList.addBig(new BooleanOption(SecondChanceForge.MOD_ID + ".config.option.secondChanceMagic",
                new TranslationTextComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceMagic"),
                settings -> SecondChanceConfig.CONFIG.secondChanceMagic.get(), (settings, value) -> SecondChanceConfig.CONFIG.secondChanceMagic.set(value)
        ));

        // Second Chance Players
        optionsRowList.addBig(new BooleanOption(SecondChanceForge.MOD_ID + ".config.option.secondChancePlayers",
                new TranslationTextComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChancePlayers"),
                settings -> SecondChanceConfig.CONFIG.secondChancePlayers.get(), (settings, value) -> SecondChanceConfig.CONFIG.secondChancePlayers.set(value)
        ));

        // Second Chance Tridents
        optionsRowList.addBig(new BooleanOption(SecondChanceForge.MOD_ID + ".config.option.secondChanceTridents",
                new TranslationTextComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceTridents"),
                settings -> SecondChanceConfig.CONFIG.secondChanceTridents.get(), (settings, value) -> SecondChanceConfig.CONFIG.secondChanceTridents.set(value)
        ));

        // Second Chance Arrows
        optionsRowList.addBig(new BooleanOption(SecondChanceForge.MOD_ID + ".config.option.secondChanceArrows",
                new TranslationTextComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceArrows"),
                settings -> SecondChanceConfig.CONFIG.secondChanceArrows.get(), (settings, value) -> SecondChanceConfig.CONFIG.secondChanceArrows.set(value)
        ));

        // Second Chance Fireworks
        optionsRowList.addBig(new BooleanOption(SecondChanceForge.MOD_ID + ".config.option.secondChanceFireworks",
                new TranslationTextComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceFireworks"),
                settings -> SecondChanceConfig.CONFIG.secondChanceFireworks.get(), (settings, value) -> SecondChanceConfig.CONFIG.secondChanceFireworks.set(value)
        ));

        // Second Chance Wither Skulls
        optionsRowList.addBig(new BooleanOption(SecondChanceForge.MOD_ID + ".config.option.secondChanceWitherSkulls",
                new TranslationTextComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceWitherSkulls"),
                settings -> SecondChanceConfig.CONFIG.secondChanceWitherSkulls.get(), (settings, value) -> SecondChanceConfig.CONFIG.secondChanceWitherSkulls.set(value)
        ));

        // Use Percent Config
        optionsRowList.addBig(new BooleanOption(SecondChanceForge.MOD_ID + ".config.option.usePercentConfig",
                new TranslationTextComponent(SecondChanceForge.MOD_ID + ".config.tooltip.usePercentConfig"),
                settings -> SecondChanceConfig.CONFIG.usePercentConfig.get(), (settings, value) -> SecondChanceConfig.CONFIG.usePercentConfig.set(value)
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

        // Second Chance Activation Percent
        optionsRowList.addBig(new SliderPercentageOption(SecondChanceForge.MOD_ID + ".config.option.secondChanceActivationPercent", 1.0D, 100.0D, 1.0F,
                        settings -> SecondChanceConfig.CONFIG.secondChanceActivationPercent.get(), (settings, value) -> SecondChanceConfig.CONFIG.secondChanceActivationPercent.set(value),
                        (settings, option) -> {
                            option.setTooltip(Minecraft.getInstance().font.split(
                                    new TranslationTextComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceActivationPercent"), 200));

                            return new TranslationTextComponent("options.generic_value", option.getCaption(), // getBaseMessageTranslation() is protected by default, use an access transformer to be able to use it
                                    new StringTextComponent(Double.toString((double) Math.round(option.get(settings) * 100) / 100)));
                        }
                )
        );

        // Second Chance Remainder Percent
        optionsRowList.addBig(new SliderPercentageOption(SecondChanceForge.MOD_ID + ".config.option.secondChanceRemainderPercent", 1.0D, 100.0D, 1.0F,
                        settings -> SecondChanceConfig.CONFIG.secondChanceRemainderPercent.get(), (settings, value) -> SecondChanceConfig.CONFIG.secondChanceRemainderPercent.set(value),
                        (settings, option) -> {
                            option.setTooltip(Minecraft.getInstance().font.split(
                                    new TranslationTextComponent(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceRemainderPercent"), 200));

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
