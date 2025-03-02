//? if fabric && <1.21 {
/*package wily.legacy.mixin.base.compat.sodium;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import me.jellysquid.mods.sodium.client.render.chunk.compile.pipeline.BlockRenderContext;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import wily.legacy.Legacy4JClient;

@Mixin(BlockRenderContext.class)
public class BlockRenderContextMixin {
    @Inject(method = "update", at = @At("HEAD"))
    public void update(BlockPos pos, BlockPos origin, BlockState state, BakedModel model, long seed, CallbackInfo ci, @Local(argsOnly = true) LocalRef<BakedModel> bakedModelLocalRef) {
        bakedModelLocalRef.set(Legacy4JClient.getFastLeavesModelReplacement(Minecraft.getInstance().level, pos, state, model));
    }
}
*///?}
