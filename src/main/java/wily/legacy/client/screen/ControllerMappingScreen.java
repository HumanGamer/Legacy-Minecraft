package wily.legacy.client.screen;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.apache.commons.lang3.ArrayUtils;
import wily.factoryapi.base.ArbitrarySupplier;
import wily.factoryapi.base.client.SimpleLayoutRenderable;
import wily.legacy.Legacy4JClient;
import wily.legacy.client.CommonColor;
import wily.legacy.client.ControlType;
import wily.legacy.client.LegacyOptions;
import wily.legacy.client.controller.BindingState;
import wily.legacy.client.controller.ControllerBinding;
import wily.legacy.client.controller.LegacyKeyMapping;
import wily.legacy.util.LegacyComponents;

import java.util.Arrays;
import java.util.Objects;

public class ControllerMappingScreen extends LegacyKeyMappingScreen {
    public ControllerMappingScreen(Screen parent) {
        super(parent, Component.translatable("legacy.options.selectedController"));
    }

    @Override
    public void addButtons() {
        KeyMapping[] keyMappings = ArrayUtils.clone(Minecraft.getInstance().options.keyMappings);
        Arrays.sort(keyMappings);
        String lastCategory = null;
        renderableVList.addRenderable(Button.builder(Component.translatable("legacy.menu.reset_defaults"),button -> minecraft.setScreen(new ConfirmationScreen(this, Component.translatable("legacy.menu.reset_controls"),Component.translatable("legacy.menu.reset_controls_message"), b-> {
            for (KeyMapping keyMapping : keyMappings)
                LegacyKeyMapping.of(keyMapping).setBinding(LegacyKeyMapping.of(keyMapping).getDefaultBinding());
            LegacyOptions.CLIENT_STORAGE.save();
            minecraft.setScreen(this);
        }))).size(240,20).build());
        renderableVList.addOptions(LegacyOptions.controllerToggleCrouch,LegacyOptions.controllerToggleSprint,LegacyOptions.selectedController,LegacyOptions.selectedControllerHandler,LegacyOptions.invertControllerButtons,LegacyOptions.controllerSensitivity,LegacyOptions.leftStickDeadZone,LegacyOptions.rightStickDeadZone,LegacyOptions.leftTriggerDeadZone,LegacyOptions.rightTriggerDeadZone);
        for (KeyMapping keyMapping : keyMappings) {
            String category = keyMapping.getCategory();
            if (!Objects.equals(lastCategory, category)) {
                renderableVList.addRenderables(SimpleLayoutRenderable.createDrawString(Component.translatable(category), 1, 4, 240, 13, CommonColor.INVENTORY_GRAY_TEXT.get(), false));
                if (category.equals("key.categories.movement"))
                    renderableVList.addOptions(LegacyOptions.invertYController,LegacyOptions.smoothMovement,LegacyOptions.forceSmoothMovement,LegacyOptions.linearCameraMovement,LegacyOptions.controllerVirtualCursor);
            }
            lastCategory = keyMapping.getCategory();
            renderableVList.addRenderable(new MappingButton(0,0,240,20, LegacyKeyMapping.of(keyMapping)) {
                @Override
                public ControlTooltip.ComponentIcon getIcon() {
                    return mapping.getBinding().bindingState.getIcon();
                }

                @Override
                public boolean isNone() {
                    return mapping.getBinding() == null;
                }

                @Override
                public void onPress() {
                    ControllerBinding.DOWN_BUTTON.bindingState.block();
                    if (Screen.hasShiftDown() || ControllerBinding.LEFT_STICK_BUTTON.bindingState.pressed){
                        mapping.setBinding(mapping.getDefaultBinding());
                        LegacyOptions.CLIENT_STORAGE.save();
                        setAndUpdateMappingTooltip(ArbitrarySupplier.empty());
                    } else if (!ControlType.getActiveType().isKbm()) {
                        setSelectedMapping(mapping);
                        setAndUpdateMappingTooltip(ControllerMappingScreen.this::getCancelTooltip);
                    }
                }
            });
        }
    }

    @Override
    protected boolean areConflicting(LegacyKeyMapping keyMapping, LegacyKeyMapping comparison){
        return keyMapping.getBinding() == comparison.getBinding();
    }

    protected void setNone(LegacyKeyMapping keyMapping){
        keyMapping.setBinding(null);
        LegacyOptions.CLIENT_STORAGE.save();
    }

    @Override
    public boolean keyPressed(int i, int j, int k) {
        if (i == InputConstants.KEY_ESCAPE && selectedMapping != null) {
            setSelectedMapping(null);
            setAndUpdateMappingTooltip(ArbitrarySupplier.empty());
            return true;
        }
        if (selectedMapping != null) return false;
        return super.keyPressed(i, j, k);
    }

    @Override
    public boolean allowsKey() {
        return false;
    }

    @Override
    public Component getCancelTooltip() {
        return Component.translatable("legacy.options.controllerMappingTooltip", ControlTooltip.CANCEL_BINDING.get().getComponent());
    }

    @Override
    public Component getConflictingTooltip(){
        return LegacyComponents.CONFLICTING_BUTTONS;
    }

    @Override
    public void bindingStateTick(BindingState state) {
        if (selectedMapping != null) {
            if (!state.canClick() || !state.binding.isBindable) return;
            selectedMapping.setBinding(!state.is(ControllerBinding.BACK) || selectedMapping.self() == Legacy4JClient.keyHostOptions ? state.binding : null);
            LegacyOptions.CLIENT_STORAGE.save();
            setAndUpdateMappingTooltip(ArbitrarySupplier.empty());
            resolveConflictingMappings();
            setSelectedMapping(null);
            state.block();
        }
    }
}
