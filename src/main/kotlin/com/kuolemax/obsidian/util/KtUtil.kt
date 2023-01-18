@file:Suppress("unused")

package com.kuolemax.obsidian.util

import com.kuolemax.obsidian.ObsidianMod

/**
 * 输出任意元素
 */
val <T> T.log: T
    get() {
        ObsidianMod.LOGGER.info("{}", this)
        return this
    }

fun <T> T.log(message: String): T {
    if (message.isNotEmpty()) {
        ObsidianMod.LOGGER.info(message)
    } else {
        ObsidianMod.LOGGER.info("$this")
    }
    return this
}