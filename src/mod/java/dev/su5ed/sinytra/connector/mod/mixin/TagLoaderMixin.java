package dev.su5ed.sinytra.connector.mod.mixin;

import dev.su5ed.sinytra.connector.mod.TagCompat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.tags.TagLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Map;

@Mixin(TagLoader.class)
public class TagLoaderMixin {

    @Inject(method = "load", at = @At("RETURN"))
    private void afterLoad(ResourceManager manager, CallbackInfoReturnable<Map<ResourceLocation, List<TagLoader.EntryWithSource>>> cir) {
        TagCompat.postProcessTags(cir.getReturnValue());
    }
}
