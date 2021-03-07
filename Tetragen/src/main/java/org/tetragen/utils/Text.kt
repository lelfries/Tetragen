package org.tetragen.utils

import net.md_5.bungee.api.ChatColor

open class ChatModifier() {

}

class ChatColor private constructor(val color: ChatColor) : ChatModifier() {

    override fun toString(): String = color.toString()

    override fun equals(other: Any?): Boolean = if (other is org.tetragen.utils.ChatColor) color == other.color else false
}