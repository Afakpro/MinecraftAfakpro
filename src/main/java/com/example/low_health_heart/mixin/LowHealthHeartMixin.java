package com.example.low_health_heart.mixin;

import com.example.low_health_heart.LowHealthHeartClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(InGameHud.class)
public class LowHealthHeartMixin {
    @Inject(method = "render", at = @At("HEAD"))
    public void onRender(MatrixStack matrices, float tickDelta, CallbackInfo info) {
        LowHealthHeartClient.onHudRender(matrices, tickDelta);
    }
}