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
 * File: SurvivalDebugStick.java
 * Date: 2020-01-25
 * Revision:
 * Author: Trikzon
 * ============================================================================ */
package io.github.trikzon.survivaldebugstick;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;

public class SurvivalDebugStick implements ModInitializer
{
    private static long lastTime = 0;

    @Override
    public void onInitialize()
    {
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            Item itemInHand = player.getStackInHand(hand).getItem();

            if (itemInHand != Items.DEBUG_STICK) return ActionResult.PASS;

            long currentTime = world.getTimeOfDay();
            if (lastTime == 0 || Math.abs(currentTime - lastTime) > 1)
            {
                itemInHand.canMine(world.getBlockState(pos), world, pos, player);
                lastTime = currentTime;
            }
            return ActionResult.PASS;
        });
    }
}
