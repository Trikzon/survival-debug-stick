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
