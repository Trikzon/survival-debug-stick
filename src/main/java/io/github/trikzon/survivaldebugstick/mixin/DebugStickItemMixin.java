/* ============================================================================
 * Copyright 2020 Trikzon
 *
 * Survival-Debug-Stick is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 * File: DebugStickItemMixin.java
 * Date: 2020-01-25
 * Revision:
 * Author: Trikzon
 * ============================================================================ */
package io.github.trikzon.survivaldebugstick.mixin;

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
