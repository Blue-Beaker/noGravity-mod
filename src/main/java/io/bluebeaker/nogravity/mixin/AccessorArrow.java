package io.bluebeaker.nogravity.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import net.minecraft.entity.projectile.AbstractArrowEntity;

@Mixin(AbstractArrowEntity.class)
public interface AccessorArrow {
    @Invoker("tickDespawn")
    public void invokeTickDespawn();
}
