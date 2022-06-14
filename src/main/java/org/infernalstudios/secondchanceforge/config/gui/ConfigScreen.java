package org.infernalstudios.secondchanceforge.config.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Codec;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import org.infernalstudios.secondchanceforge.SecondChanceForge;
import org.infernalstudios.secondchanceforge.config.SecondChanceConfig;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.OptionsSubScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.OptionsList;
import net.minecraft.util.FormattedCharSequence;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.awt.TextComponent;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class ConfigScreen extends Screen {

	private OptionsList optionsRowList;

	public ConfigScreen() {
		super(Component.translatable(SecondChanceForge.MOD_ID + ".config.title"));
	}

	@Override
	public void init() {
		optionsRowList = new OptionsList(minecraft, width, height, 24, height - 32, 25);

		// Coyote Time Enabled
		optionsRowList.addBig(OptionInstance.createBoolean(SecondChanceForge.MOD_ID + ".config.option.coyoteTimeEnabled",
                OptionInstance.cachedConstantTooltip(Component.translatable(SecondChanceForge.MOD_ID + ".config.tooltip.coyoteTimeEnabled")),
				SecondChanceConfig.CONFIG.coyoteTimeEnabled.get(), SecondChanceConfig.CONFIG.coyoteTimeEnabled::set
		));

		// Coyote Time Ticks
		optionsRowList.addBig(new OptionInstance<>(SecondChanceForge.MOD_ID + ".config.option.coyoteTimeTicks",
                OptionInstance.cachedConstantTooltip(Component.translatable(SecondChanceForge.MOD_ID + ".config.tooltip.coyoteTimeTicks")),
				Options::genericValueLabel, new OptionInstance.IntRange(1, 100),
                SecondChanceConfig.CONFIG.coyoteTimeTicks.get(), SecondChanceConfig.CONFIG.coyoteTimeTicks::set
			)
		);

		// Second Chance Enabled
		optionsRowList.addBig(OptionInstance.createBoolean(SecondChanceForge.MOD_ID + ".config.option.secondChanceEnabled",
				OptionInstance.cachedConstantTooltip(Component.translatable(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceEnabled")),
                SecondChanceConfig.CONFIG.secondChanceEnabled.get(), SecondChanceConfig.CONFIG.secondChanceEnabled::set
		));

		// Second Chance Sound
		optionsRowList.addBig(OptionInstance.createBoolean(SecondChanceForge.MOD_ID + ".config.option.secondChanceSound",
				OptionInstance.cachedConstantTooltip(Component.translatable(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceSound")),
				SecondChanceConfig.CONFIG.secondChanceSound.get(), SecondChanceConfig.CONFIG.secondChanceSound::set
		));

        // Second Chance Explosions
        optionsRowList.addBig(OptionInstance.createBoolean(SecondChanceForge.MOD_ID + ".config.option.secondChanceExplosions",
                OptionInstance.cachedConstantTooltip(Component.translatable(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceExplosions")),
                SecondChanceConfig.CONFIG.secondChanceExplosions.get(), SecondChanceConfig.CONFIG.secondChanceExplosions::set
        ));

        // Second Chance Mobs
        optionsRowList.addBig(OptionInstance.createBoolean(SecondChanceForge.MOD_ID + ".config.option.secondChanceMobs",
                OptionInstance.cachedConstantTooltip(Component.translatable(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceMobs")),
                SecondChanceConfig.CONFIG.secondChanceMobs.get(), SecondChanceConfig.CONFIG.secondChanceMobs::set
        ));

        // Second Chance Falls
        optionsRowList.addBig(OptionInstance.createBoolean(SecondChanceForge.MOD_ID + ".config.option.secondChanceFalls",
                OptionInstance.cachedConstantTooltip(Component.translatable(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceFalls")),
                SecondChanceConfig.CONFIG.secondChanceFalls.get(), SecondChanceConfig.CONFIG.secondChanceFalls::set
        ));

        // Second Chance Anvils
        optionsRowList.addBig(OptionInstance.createBoolean(SecondChanceForge.MOD_ID + ".config.option.secondChanceAnvils",
                OptionInstance.cachedConstantTooltip(Component.translatable(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceAnvils")),
                SecondChanceConfig.CONFIG.secondChanceAnvils.get(), SecondChanceConfig.CONFIG.secondChanceAnvils::set
        ));

        // Second Chance Lightning
        optionsRowList.addBig(OptionInstance.createBoolean(SecondChanceForge.MOD_ID + ".config.option.secondChanceLightning",
                OptionInstance.cachedConstantTooltip(Component.translatable(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceLightning")),
                SecondChanceConfig.CONFIG.secondChanceLightning.get(), SecondChanceConfig.CONFIG.secondChanceLightning::set
        ));

        // Second Chance Elytra Crash
        optionsRowList.addBig(OptionInstance.createBoolean(SecondChanceForge.MOD_ID + ".config.option.secondChanceElytraCrash",
                OptionInstance.cachedConstantTooltip(Component.translatable(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceElytraCrash")),
                SecondChanceConfig.CONFIG.secondChanceElytraCrash.get(), SecondChanceConfig.CONFIG.secondChanceElytraCrash::set
        ));

        // Second Chance Falling Blocks
        optionsRowList.addBig(OptionInstance.createBoolean(SecondChanceForge.MOD_ID + ".config.option.secondChanceFallingBlocks",
                OptionInstance.cachedConstantTooltip(Component.translatable(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceFallingBlocks")),
                SecondChanceConfig.CONFIG.secondChanceFallingBlocks.get(), SecondChanceConfig.CONFIG.secondChanceFallingBlocks::set
        ));

        // Second Chance Magic
        optionsRowList.addBig(OptionInstance.createBoolean(SecondChanceForge.MOD_ID + ".config.option.secondChanceMagic",
                OptionInstance.cachedConstantTooltip(Component.translatable(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceMagic")),
                SecondChanceConfig.CONFIG.secondChanceMagic.get(), SecondChanceConfig.CONFIG.secondChanceMagic::set
        ));

        // Second Chance Players
        optionsRowList.addBig(OptionInstance.createBoolean(SecondChanceForge.MOD_ID + ".config.option.secondChancePlayers",
                OptionInstance.cachedConstantTooltip(Component.translatable(SecondChanceForge.MOD_ID + ".config.tooltip.secondChancePlayers")),
                SecondChanceConfig.CONFIG.secondChancePlayers.get(), SecondChanceConfig.CONFIG.secondChancePlayers::set
        ));

        // Second Chance Tridents
        optionsRowList.addBig(OptionInstance.createBoolean(SecondChanceForge.MOD_ID + ".config.option.secondChanceTridents",
                OptionInstance.cachedConstantTooltip(Component.translatable(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceTridents")),
                SecondChanceConfig.CONFIG.secondChanceTridents.get(), SecondChanceConfig.CONFIG.secondChanceTridents::set
        ));

        // Second Chance Arrows
        optionsRowList.addBig(OptionInstance.createBoolean(SecondChanceForge.MOD_ID + ".config.option.secondChanceArrows",
                OptionInstance.cachedConstantTooltip(Component.translatable(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceArrows")),
                SecondChanceConfig.CONFIG.secondChanceArrows.get(), SecondChanceConfig.CONFIG.secondChanceArrows::set
        ));

        // Second Chance Fireworks
        optionsRowList.addBig(OptionInstance.createBoolean(SecondChanceForge.MOD_ID + ".config.option.secondChanceFireworks",
                OptionInstance.cachedConstantTooltip(Component.translatable(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceFireworks")),
                SecondChanceConfig.CONFIG.secondChanceFireworks.get(), SecondChanceConfig.CONFIG.secondChanceFireworks::set
        ));

        // Second Chance Wither Skulls
        optionsRowList.addBig(OptionInstance.createBoolean(SecondChanceForge.MOD_ID + ".config.option.secondChanceWitherSkulls",
                OptionInstance.cachedConstantTooltip(Component.translatable(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceWitherSkulls")),
                SecondChanceConfig.CONFIG.secondChanceWitherSkulls.get(), SecondChanceConfig.CONFIG.secondChanceWitherSkulls::set
        ));

        // Second Chance Stalactite
        optionsRowList.addBig(OptionInstance.createBoolean(SecondChanceForge.MOD_ID + ".config.option.secondChanceStalactite",
                OptionInstance.cachedConstantTooltip(Component.translatable(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceStalactite")),
                SecondChanceConfig.CONFIG.secondChanceStalactite.get(), SecondChanceConfig.CONFIG.secondChanceStalactite::set
        ));

        // Second Chance Stalagmite
        optionsRowList.addBig(OptionInstance.createBoolean(SecondChanceForge.MOD_ID + ".config.option.secondChanceStalagmite",
                OptionInstance.cachedConstantTooltip(Component.translatable(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceStalagmite")),
                SecondChanceConfig.CONFIG.secondChanceStalagmite.get(), SecondChanceConfig.CONFIG.secondChanceStalagmite::set
        ));

        // Use Percent Config
        optionsRowList.addBig(OptionInstance.createBoolean(SecondChanceForge.MOD_ID + ".config.option.usePercentConfig",
                OptionInstance.cachedConstantTooltip(Component.translatable(SecondChanceForge.MOD_ID + ".config.tooltip.usePercentConfig")),
                SecondChanceConfig.CONFIG.usePercentConfig.get(), SecondChanceConfig.CONFIG.usePercentConfig::set
        ));

		// Second Chance Activation Health
		optionsRowList.addBig(new OptionInstance<>(SecondChanceForge.MOD_ID + ".config.option.secondChanceActivationHealth",
                OptionInstance.cachedConstantTooltip(Component.translatable(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceActivationHealth")),
                (component, value) -> Options.genericValueLabel(component, Component.literal(value.toString())),
                OptionInstance.UnitDouble.INSTANCE.xmap((sliderValue) -> (int)((sliderValue*100)*2)/2.0D, (optionValue) -> optionValue/100), Codec.doubleRange(0.5D, 100.0D),
                SecondChanceConfig.CONFIG.secondChanceActivationHealth.get(), SecondChanceConfig.CONFIG.secondChanceActivationHealth::set
        ));

		// Second Chance Activation Health
		optionsRowList.addBig(new OptionInstance<>(SecondChanceForge.MOD_ID + ".config.option.secondChanceHealthRemainder",
                OptionInstance.cachedConstantTooltip(Component.translatable(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceHealthRemainder")),
                (component, value) -> Options.genericValueLabel(component, Component.literal(value.toString())),
                OptionInstance.UnitDouble.INSTANCE.xmap((sliderValue) -> (int)((sliderValue*100)*2)/2.0D, (optionValue) -> optionValue/100), Codec.doubleRange(0.5D, 100.0D),
                SecondChanceConfig.CONFIG.secondChanceHealthRemainder.get(), SecondChanceConfig.CONFIG.secondChanceHealthRemainder::set
        ));

        // Second Chance Activation Percent
        optionsRowList.addBig(new OptionInstance<>(SecondChanceForge.MOD_ID + ".config.option.secondChanceActivationPercent",
                OptionInstance.cachedConstantTooltip(Component.translatable(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceActivationPercent")),
                (component, value) -> Component.translatable("options.percent_value", component, (int)(value * 100.0D)),
                OptionInstance.UnitDouble.INSTANCE, Codec.doubleRange(0.01D, 1.0D),
                SecondChanceConfig.CONFIG.secondChanceActivationPercent.get(), SecondChanceConfig.CONFIG.secondChanceActivationPercent::set
        ));

        // Second Chance Remainder Percent
        optionsRowList.addBig(new OptionInstance<>(SecondChanceForge.MOD_ID + ".config.option.secondChanceRemainderPercent",
                OptionInstance.cachedConstantTooltip(Component.translatable(SecondChanceForge.MOD_ID + ".config.tooltip.secondChanceRemainderPercent")),
                (component, value) -> Component.translatable("options.percent_value", component, (int)(value * 100.0D)),
                OptionInstance.UnitDouble.INSTANCE, Codec.doubleRange(0.01D, 1.0D),
                SecondChanceConfig.CONFIG.secondChanceRemainderPercent.get(), SecondChanceConfig.CONFIG.secondChanceRemainderPercent::set
        ));

        addWidget(optionsRowList);

		addRenderableWidget(new Button((width - 200) / 2, height - 26, 200, 20, Component.translatable("gui.done"), button -> onClose()));
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
