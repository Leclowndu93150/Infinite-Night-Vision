package com.leclowndu93150.infinitenightvision;

import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientTickEvent;

@Mod(Main.MODID)
public class Main
{
    public static final String MODID = "infinitenightvision";

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientTick(ClientTickEvent.Post event) {
            Minecraft minecraft = Minecraft.getInstance();
            if(minecraft.level != null){
                if (minecraft.player != null) {
                    if (!minecraft.player.hasEffect(MobEffects.NIGHT_VISION)) {
                        Minecraft.getInstance().player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION,-1,1));
                    }
                }
            }
        }
    }
}