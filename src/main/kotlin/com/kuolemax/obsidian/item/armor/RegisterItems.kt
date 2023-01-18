package com.kuolemax.obsidian.item.armor

import com.kuolemax.obsidian.MOD_ID
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier


class RegisterItems {

    companion object {

        val OBSIDIAN_ARMOR_MATERIAL: ArmorMaterial = ObsidianArmorMaterial()

        // 黑曜石锭
        val OBSIDIAN_INGOT: Item = Item(Item.Settings())

        // 黑曜石头盔, 黑曜石胸甲, 黑曜石护腿, 黑曜石靴子
        val OBSIDIAN_HELMET: Item = ArmorItem(OBSIDIAN_ARMOR_MATERIAL, EquipmentSlot.HEAD, Item.Settings())
        val OBSIDIAN_CHESTPLATE: Item = ArmorItem(OBSIDIAN_ARMOR_MATERIAL, EquipmentSlot.CHEST, Item.Settings())
        val OBSIDIAN_LEGGINGS: Item = ArmorItem(OBSIDIAN_ARMOR_MATERIAL, EquipmentSlot.LEGS, Item.Settings())
        val OBSIDIAN_BOOTS: Item = ArmorItem(OBSIDIAN_ARMOR_MATERIAL, EquipmentSlot.FEET, Item.Settings())

        fun register(): List<Item> {
            Registry.register(
                Registries.ITEM,
                Identifier(MOD_ID, "obsidian_ingot"),
                OBSIDIAN_INGOT
            )
            Registry.register(
                Registries.ITEM,
                Identifier(MOD_ID, "obsidian_helmet"),
                OBSIDIAN_HELMET
            )
            Registry.register(
                Registries.ITEM,
                Identifier(MOD_ID, "obsidian_chestplate"),
                OBSIDIAN_CHESTPLATE
            )
            Registry.register(
                Registries.ITEM,
                Identifier(MOD_ID, "obsidian_leggings"),
                OBSIDIAN_LEGGINGS
            )
            Registry.register(
                Registries.ITEM,
                Identifier(MOD_ID, "obsidian_boots"),
                OBSIDIAN_BOOTS
            )

            return listOf(OBSIDIAN_INGOT, OBSIDIAN_HELMET, OBSIDIAN_CHESTPLATE, OBSIDIAN_LEGGINGS, OBSIDIAN_BOOTS)
        }
    }

}
