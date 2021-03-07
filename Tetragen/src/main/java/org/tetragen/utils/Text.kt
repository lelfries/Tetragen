package org.tetragen.utils

import net.md_5.bungee.api.ChatColor as BukkitChatColor

object Text {

    val AQUA = ChatModifier(BukkitChatColor.AQUA)
    val BLUE = ChatModifier(BukkitChatColor.BLUE)
    val BLACK = ChatModifier(BukkitChatColor.BLACK)
    val GOLD = ChatModifier(BukkitChatColor.GOLD)
    val GRAY = ChatModifier(BukkitChatColor.GRAY)
    val GREEN = ChatModifier(BukkitChatColor.GREEN)
    val RED = ChatModifier(BukkitChatColor.RED)
    val WHITE= ChatModifier(BukkitChatColor.WHITE)
    val YELLOW = ChatModifier(BukkitChatColor.YELLOW)
    val DARK_AQUA = ChatModifier(BukkitChatColor.DARK_AQUA)
    val DARK_BLUE = ChatModifier(BukkitChatColor.DARK_BLUE)
    val DARK_GRAY = ChatModifier(BukkitChatColor.DARK_GRAY)
    val DARK_GREEN = ChatModifier(BukkitChatColor.DARK_GREEN)
    val DARK_PURPLE = ChatModifier(BukkitChatColor.DARK_PURPLE)
    val LIGHT_PURPLE = ChatModifier(BukkitChatColor.LIGHT_PURPLE)
    val DARK_RED = ChatModifier(BukkitChatColor.DARK_PURPLE)

    val ITALIC = ChatModifier(BukkitChatColor.ITALIC)
    val CLEAR = ChatModifier(BukkitChatColor.RESET)
    val BOLD = ChatModifier(BukkitChatColor.BOLD)
    val UNDERLINE = ChatModifier(BukkitChatColor.UNDERLINE)
    val MAGIC = ChatModifier(BukkitChatColor.MAGIC)
}

class ChatModifier internal constructor(private val modification: BukkitChatColor) {

    override fun toString(): String = modification.toString()

    override fun equals(other: Any?): Boolean = if (other is ChatModifier) modification == other.modification else false

}
