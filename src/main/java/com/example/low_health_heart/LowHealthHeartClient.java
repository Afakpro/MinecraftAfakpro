package com.example.low_health_heart;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class LowHealthHeartClient implements ClientModInitializer {
    private static final Identifier HEART_TEXTURE = new Identifier("low_health_heart", "textures/gui/heart.png");

    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register(this::onHudRender);
        System.out.println("Low Health Heart Client has been initialized!");
    }

    private void onHudRender(MatrixStack matrixStack, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null && client.player.getHealth() < 7.0f) { // 7 health points = 3.5 hearts
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();
            int x = width / 2 - 8;
            int y = height / 2 - 8;

            // Render the heart texture
            RenderSystem.setShaderTexture(0, HEART_TEXTURE);
            DrawableHelper.drawTexture(matrixStack, x, y, 0, 0, 16, 16, 16, 16);
        }
    }
}