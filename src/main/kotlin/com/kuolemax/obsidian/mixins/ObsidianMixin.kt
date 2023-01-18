package com.kuolemax.obsidian.mixins

import com.kuolemax.obsidian.util.log
import net.minecraft.client.gui.screen.TitleScreen
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

@Suppress("unused")
@Mixin(TitleScreen::class)
class ObsidianMixin {

    @Inject(at = [At("HEAD")], method = ["init"])
    fun init(info: CallbackInfo) {
        "This line is printed by an example mod mixin!".log
    }
}