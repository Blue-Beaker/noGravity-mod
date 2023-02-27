package io.bluebeaker.nogravity.mixin;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import net.minecraft.entity.player.EntityPlayer;

@Mixin(EntityPlayer.class)
public abstract class MixinPlayerEntity {
    // Modify mining speed to negate 'not on ground' penalty
    @Redirect(method = "getDigSpeed(Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/util/math/BlockPos;)F", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/player/EntityPlayer;onGround:Z", opcode = Opcodes.GETFIELD))
    private boolean removeBreakingSpeedPenalty(EntityPlayer playerEntity) {
        if(((EntityPlayer)(Object)this).hasNoGravity())
        return true;
        else
        return ((EntityPlayer)(Object)this).onGround;
    }
}
