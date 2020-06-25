/*
 * Copyright 2020 Trikzon
 *
 * Survival Debug Stick is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * https://www.gnu.org/licenses/
 */
package com.trikzon.survival_debug_stick.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DebugStickItem;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DebugStickItem.class)
public abstract class DebugStickItemMixin extends Item
{
    public DebugStickItemMixin(Settings item$Settings_1)
    {
        super(item$Settings_1);
    }

    @Redirect(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isCreativeLevelTwoOp()Z"))
    public boolean isCreativeLevelTwoOpProxy(PlayerEntity playerEntity_1)
    {
        return true;
    }
}
