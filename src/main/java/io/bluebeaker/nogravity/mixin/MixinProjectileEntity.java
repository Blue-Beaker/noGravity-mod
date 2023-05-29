package io.bluebeaker.nogravity.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.bluebeaker.nogravity.ConfigRegistry;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.ResourceLocation;

@Mixin(ProjectileEntity.class)
public abstract class MixinProjectileEntity {
    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;tick()V", shift = At.Shift.BEFORE))
    public void checkDespawn(CallbackInfo ci){
        // if (((ProjectileEntity)(Object)this) instanceof ThrowableEntity || ((ProjectileEntity)(Object)this) instanceof LlamaSpitEntity){
            // if (((ProjectileEntity)(Object)this).getDeltaMovement().length()<2.47e-321){
            ResourceLocation id = ((ProjectileEntity)(Object)this).getType().getRegistryName();
            if (id!=null && ConfigRegistry.ProjectilesToClean.get().contains(id.toString())  && ((ProjectileEntity)(Object)this).getDeltaMovement().length()<2.47e-321){
                ((ProjectileEntity)(Object)this).kill();
            }
        // }
    }
}
