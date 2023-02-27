package io.bluebeaker.nogravity.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.Entity;
import net.minecraft.world.WorldServer;

@Mixin(WorldServer.class)
public abstract class MixinServerWorld {
    // Apply NoGravity on entity spawn
    @Inject(method = "onEntityAdded(Lnet/minecraft/entity/Entity;)V",at = @At("RETURN"))
    private void onEntityAdded(Entity entity,CallbackInfo ci){
        entity.setNoGravity(true);
    }
    // Apply NoGravity on entity spawn
    // @Inject(method = "addPlayer(Lnet/minecraft/server/network/ServerPlayerEntity;)V",at = @At("RETURN"))
    // private void addPlayer(EntityPlayer entity,CallbackInfo ci){
    //     entity.setNoGravity(true);
    // }
}
