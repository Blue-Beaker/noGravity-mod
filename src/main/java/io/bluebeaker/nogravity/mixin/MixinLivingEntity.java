package io.bluebeaker.nogravity.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.EntityLivingBase;

@Mixin(EntityLivingBase.class)
public abstract class MixinLivingEntity {
    @Inject(method = "fall",at = @At("HEAD"), cancellable = true)
    public void handleFallDamage(float distance, float damageMultiplier,CallbackInfo ci){
        if(((EntityLivingBase)(Object)this).hasNoGravity()){
            ci.cancel();
        }
    }
}
