package com.leclowndu93150.infinitenightvision.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class ExampleMixin {
	@Inject(method = "tick", at = @At("HEAD"))
	public void tickClient(CallbackInfo ci){
		MinecraftClient minecraft = MinecraftClient.getInstance();
		if (minecraft.player != null) {
			if (!minecraft.player.hasStatusEffect(StatusEffects.NIGHT_VISION)) {
				minecraft.player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,-1,1));
			}
		}
	}


}