package io.bluebeaker.nogravity.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.bluebeaker.nogravity.ConfigRegistry;
import net.minecraft.entity.projectile.AbstractArrowEntity;

@Mixin(AbstractArrowEntity.class)
public abstract class MixinArrow {
    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/projectile/AbstractArrowEntity;checkInsideBlocks()V", shift = At.Shift.AFTER))
    public void despawnStoppedArrow(CallbackInfo ci){
        if (ConfigRegistry.DespawnStuckArrows.get()&& !((AbstractArrowEntity)(Object)this).level.isClientSide && ((AbstractArrowEntity)(Object)this).getDeltaMovement().length()<2.47e-321){
            ((AccessorArrow)this).invokeTickDespawn();
        }
    }
}
