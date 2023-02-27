package io.bluebeaker.nogravity.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.block.BlockFalling;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(BlockFalling.class)
public abstract class MixinFallingBlock {
    //Remove blocks falling action
    @Inject(method = "checkFallable", at = @At("HEAD"), cancellable = true)
    private void checkFallable(World worldIn, BlockPos pos, CallbackInfo ci){
        ci.cancel();
    }
}
