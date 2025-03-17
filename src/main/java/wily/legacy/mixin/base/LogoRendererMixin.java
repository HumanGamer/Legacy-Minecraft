package wily.legacy.mixin.base;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.LogoRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import wily.factoryapi.base.client.FactoryGuiGraphics;
import wily.legacy.client.ControlType;
import wily.legacy.util.ScreenUtil;

@Mixin(LogoRenderer.class)
public class LogoRendererMixin {
    @Inject(method = "renderLogo(Lnet/minecraft/client/gui/GuiGraphics;IFI)V", at = @At("HEAD"), cancellable = true)
    public void renderLogo(GuiGraphics guiGraphics, int i, float f, int j, CallbackInfo ci) {
        if (Minecraft.getInstance().getResourceManager().getResource(ControlType.getActiveType().getMinecraftLogo()).isPresent() || Minecraft.getInstance().getResourceManager().getResource(ScreenUtil.MINECRAFT).isPresent()){
            FactoryGuiGraphics.of(guiGraphics).setColor(1.0f, 1.0f, 1.0f, f, true);
            ScreenUtil.renderLegacyLogo(guiGraphics);
            FactoryGuiGraphics.of(guiGraphics).clearColor(true);
            ci.cancel();
        }
    }
}
