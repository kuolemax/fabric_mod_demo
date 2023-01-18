package com.kuolemax.obsidian.item.armor

import net.minecraft.block.Blocks
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ArmorMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents

class ObsidianArmorMaterial : ArmorMaterial {

    // 基础耐久 Leather uses 5, Diamond 33, Netherite 37
    private val BASE_DURABILITY = intArrayOf(13, 15, 16, 11)
    private val ENCHANTABILITY = 35

    // 护甲保护值 - 头盔, 胸甲, 护腿, 靴子
    private val PROTECTION_VALUES = intArrayOf(3, 6, 8, 3)

    override fun getDurability(slot: EquipmentSlot): Int = BASE_DURABILITY[slot.entitySlotId] * ENCHANTABILITY

    override fun getProtectionAmount(slot: EquipmentSlot): Int = PROTECTION_VALUES[slot.entitySlotId]

    override fun getEnchantability(): Int = ENCHANTABILITY

    override fun getEquipSound(): SoundEvent = SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND

    override fun getRepairIngredient(): Ingredient = Ingredient.ofItems(Blocks.OBSIDIAN)

    override fun getName(): String = "obsidian"

    override fun getToughness(): Float = 0.0F

    override fun getKnockbackResistance(): Float = 0.0F
}