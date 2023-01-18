package com.kuolemax.obsidian.item

import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.sound.SoundEvents
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class ObsidianItem(settings: Settings) : Item(settings) {

    override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
        user.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_STRONG, 1.0F, 1.0F)
        return TypedActionResult.success(user.getStackInHand(hand))
    }

    override fun appendTooltip(
        stack: ItemStack,
        world: World?,
        tooltip: MutableList<Text>,
        context: TooltipContext,
    ) {
        // 默认为白色文本
        tooltip.add(Text.translatable("item.obsidian.obsidian_item.tooltip"))
        // 格式化为红色文本
        tooltip.add(Text.translatable("item.obsidian.obsidian_item.tooltip2").formatted(Formatting.RED))
    }
}