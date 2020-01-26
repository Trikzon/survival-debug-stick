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
