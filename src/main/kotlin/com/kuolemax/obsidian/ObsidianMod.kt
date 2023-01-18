@file:Suppress("UnstableApiUsage")

package com.kuolemax.obsidian

import com.kuolemax.obsidian.item.ObsidianItem
import com.kuolemax.obsidian.item.armor.RegisterItems
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry
import net.fabricmc.fabric.api.registry.FuelRegistry
import net.minecraft.item.*
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory

const val MOD_ID = "obsidian"

@Suppress("unused")
object ObsidianMod {
    val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)

    // 添加一个新物品 - 黑曜石剑
    // maxCount - 最大堆叠数量
    private val OBSIDIAN_ITEM: Item = ObsidianItem(FabricItemSettings().maxCount(4))

    // 创建物品组 - 创造物品栏标签
    private val ITEM_GROUP: ItemGroup = FabricItemGroup.builder(Identifier(MOD_ID, "obsidian_group"))
        .icon { ItemStack(OBSIDIAN_ITEM) }
        .build()


    fun init() {

        // 注册物品
        Registry.register(Registries.ITEM, Identifier(MOD_ID, "obsidian_item"), OBSIDIAN_ITEM)

        // 让物品可以用于燃烧
        FuelRegistry.INSTANCE.add(OBSIDIAN_ITEM, 3000)
        // 让物品可以用于堆肥
        CompostingChanceRegistry.INSTANCE.add(OBSIDIAN_ITEM, 8.0f)

        val items = RegisterItems.register()

        // 使用事件将物品添加进物品组
        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP)
            .register { content: FabricItemGroupEntries ->
                content.add(OBSIDIAN_ITEM)
                content.addAll(items.map { ItemStack(it) })
            }
    }
}