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

package com.nekomaster1000.infernalexp.config;

import com.nekomaster1000.infernalexp.InfernalExpansion;

import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfig {

    final ForgeConfigSpec.IntValue luminousRefreshDelay;

    ClientConfig(final ForgeConfigSpec.Builder builder) {
        builder.push("general");

        // Luminous Effect
        luminousRefreshDelay = builder
            .comment("Determines how often (in ticks) the luminous effect should update")
            .translation(InfernalExpansion.MOD_ID + ".config.tooltip.luminousRefreshDelay")
            .defineInRange("luminousRefreshDelay", 2, 1, Integer.MAX_VALUE);

        builder.pop();
    }
}
