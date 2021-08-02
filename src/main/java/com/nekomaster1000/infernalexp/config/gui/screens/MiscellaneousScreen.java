/*
 * Copyright 2021 Infernal Studios
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nekomaster1000.infernalexp.config.gui.screens;

import com.nekomaster1000.infernalexp.InfernalExpansion;
import com.nekomaster1000.infernalexp.config.InfernalExpansionConfig;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.settings.BooleanOption;
import net.minecraft.client.settings.SliderPercentageOption;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MiscellaneousScreen extends IESettingsScreen {

    public MiscellaneousScreen(Screen parentScreen) {
        super(parentScreen, new TranslationTextComponent(InfernalExpansion.MOD_ID + ".config.title.miscellaneous"));
    }

    @Override
    public void addSettings() {
        for (InfernalExpansionConfig.Miscellaneous miscellaneous : InfernalExpansionConfig.Miscellaneous.values()) {
            if (miscellaneous.isSlider()) {
                optionsRowList.addOption(new SliderPercentageOption(InfernalExpansion.MOD_ID + ".config.option." + miscellaneous.getTranslationName(), miscellaneous.getMinValue(), miscellaneous.getMaxValue(), miscellaneous.getStepSize(),
                    settings -> miscellaneous.getDouble(), (settings, value) -> miscellaneous.set(value),
                    (settings, option) -> {
                        option.setOptionValues(Minecraft.getInstance().fontRenderer.trimStringToWidth(
                            new TranslationTextComponent(InfernalExpansion.MOD_ID + ".config.tooltip." + miscellaneous.getTranslationName()), 200));

                        return new TranslationTextComponent("options.generic_value", option.getBaseMessageTranslation(),
                            new StringTextComponent(Double.toString((double) Math.round(option.get(settings) * 100) / 100)));
                    }));
            } else {
                optionsRowList.addOption(new BooleanOption(InfernalExpansion.MOD_ID + ".config.option." + miscellaneous.getTranslationName(),
                    new TranslationTextComponent(InfernalExpansion.MOD_ID + ".config.tooltip." + miscellaneous.getTranslationName()),
                    settings -> miscellaneous.getBool(), (settings, value) -> miscellaneous.set(value)));
            }
        }
    }
}
