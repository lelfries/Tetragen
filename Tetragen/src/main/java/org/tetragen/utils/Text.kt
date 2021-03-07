package org.tetragen.utils

import net.md_5.bungee.api.ChatColor as BukkitChatColor

/** An object that contains all the ColorModifiers. Slightly reduces boilerplate code.
 * @author croissant396*/
object Text {
    /** A ChatModifier representing the `AQUA` Color. */
    @JvmStatic
    val AQUA = ChatModifier(BukkitChatColor.AQUA)

    /** A [ChatModifier] representing the `BLUE` Color. */
    @JvmStatic
    val BLUE = ChatModifier(BukkitChatColor.BLUE)

    /** A [ChatModifier] representing the `BLACK` Color. */
    @JvmStatic
    val BLACK = ChatModifier(BukkitChatColor.BLACK)

    /** A [ChatModifier] representing the `GOLD` Color. */
    @JvmStatic
    val GOLD = ChatModifier(BukkitChatColor.GOLD)

    /** A [ChatModifier] representing the `GRAY` Color. */
    @JvmStatic
    val GRAY = ChatModifier(BukkitChatColor.GRAY)

    /** A [ChatModifier] representing the `GREEN` Color. */
    @JvmStatic
    val GREEN = ChatModifier(BukkitChatColor.GREEN)

    /** A [ChatModifier] representing the `RED` Color. */
    @JvmStatic
    val RED = ChatModifier(BukkitChatColor.RED)

    /** A [ChatModifier] representing the `WHITE` Color. */
    @JvmStatic
    val WHITE = ChatModifier(BukkitChatColor.WHITE)

    /** A [ChatModifier] representing the `YELLOW` Color. */
    @JvmStatic
    val YELLOW = ChatModifier(BukkitChatColor.YELLOW)

    /** A [ChatModifier] representing the `DARK AQUA` Color. */
    @JvmStatic
    val DARK_AQUA = ChatModifier(BukkitChatColor.DARK_AQUA)

    /** A [ChatModifier] representing the `DARK BLUE` Color. */
    @JvmStatic
    val DARK_BLUE = ChatModifier(BukkitChatColor.DARK_BLUE)

    /** A [ChatModifier] representing the `DARK GRAY Color`. */
    @JvmStatic
    val DARK_GRAY = ChatModifier(BukkitChatColor.DARK_GRAY)

    /** A [ChatModifier] representing the `DARK GREEN Color`. */
    @JvmStatic
    val DARK_GREEN = ChatModifier(BukkitChatColor.DARK_GREEN)

    /** A [ChatModifier] representing the `DARK PURPLE Color`. */
    @JvmStatic
    val DARK_PURPLE = ChatModifier(BukkitChatColor.DARK_PURPLE)

    /** A [ChatModifier] representing the `LIGHT PURPLE` Color. */
    @JvmStatic
    val LIGHT_PURPLE = ChatModifier(BukkitChatColor.LIGHT_PURPLE)

    /** A [ChatModifier] representing the `DARK RED` Color. */
    @JvmStatic
    val DARK_RED = ChatModifier(BukkitChatColor.DARK_PURPLE)

    /** A [ChatModifier] representing an `ITALIC` Modifier. */
    @JvmStatic
    val ITALIC = ChatModifier(BukkitChatColor.ITALIC)

    /** A [ChatModifier] representing an `CLEAR` Modifier. */
    @JvmStatic
    val CLEAR = ChatModifier(BukkitChatColor.RESET)

    /** A [ChatModifier] representing an `BOLD` Modifier. */
    @JvmStatic
    val BOLD = ChatModifier(BukkitChatColor.BOLD)

    /** A [ChatModifier] representing an `UNDERLINE` Modifier. */
    @JvmStatic
    val UNDERLINE = ChatModifier(BukkitChatColor.UNDERLINE)

    /** A [ChatModifier] representing an `MAGIC` Modifier. */
    @JvmStatic
    val MAGIC = ChatModifier(BukkitChatColor.MAGIC)
}

/** A class that represents a Chat Modification, such as Bold or ChatColors */
class ChatModifier internal constructor(private val modification: BukkitChatColor) {
    /** Returns the String version of this ChatModification; Allows for use with [StringBuilder].
     * @return The String version of this object, containing the char needed for ChatColors and modifications. */
    override fun toString(): String = modification.toString()
    /** Returns whether the object is the same as this Object.
     * @return whether the specified object is the same as this. */
    override fun equals(other: Any?): Boolean = if (other is ChatModifier) modification == other.modification else false
}
