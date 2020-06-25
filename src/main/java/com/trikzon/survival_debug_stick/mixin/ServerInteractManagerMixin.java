package com.trikzon.survival_debug_stick.mixin;

import net.minecraft.server.network.ServerPlayerInteractionManager;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ServerPlayerInteractionManager.class)
public interface ServerInteractManagerMixin
{
    @Accessor("miningPos")
    void setMiningPos(BlockPos pos);
}
