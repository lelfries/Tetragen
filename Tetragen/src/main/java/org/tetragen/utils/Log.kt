package org.tetragen.utils

import org.bukkit.Bukkit
import java.util.logging.Level

/** An Object that contains methods to help deal with the [Bukkit Console](https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Bukkit.html#getLogger())
 * Meant to drastically reduce the amount of boilerplate code.
 * @author croissant396 */
object Log {
    /** Represents the console */
    private val console = Bukkit.getConsoleSender()

    /** Bukkit's server console. */
    private val logger = Bukkit.getLogger()

    /** Sends a message to the console without any [LogLevel] level.
     * @param message The message to be sent.  */
    @JvmStatic
    fun message(message: String) = console.sendMessage(message)

    /** Sends a message to the console with the specified [LogLevel].
     * @param message The message to be sent.
     * @param level A [LogLevel] denoting what level this will be for the logger */
    @JvmStatic
    fun message(message: String, level: LogLevel) = logger.log(level.getLoggingLevel(), message)

    /** Sends a message to the console with a [String] denoting the [LogLevel].
     * @param message The message to be sent.
     * @param level A [String] denoting what level this will be for the logger */
    @JvmStatic
    fun message(message: String, level: String) = message(message, LogLevel.getLevelByName(level))

    /** Sends a message to the console with an [LogLevel.INFO] level.
     * @param message The message to be sent.  */
    @JvmStatic
    fun info(message: String) = logger.info(message)

    /** Sends a message to the console with an [LogLevel.WARNING] level.
     * @param message The message to be sent.  */
    @JvmStatic
    fun warn(message: String) = logger.warning(message)

    /** Sends a message to the console with an [LogLevel.SEVERE] level.
     * @param message The message to be sent.  */
    @JvmStatic
    fun severe(message: String) = logger.severe(message)

    /** Sends a message to the console with an [LogLevel.CONFIG] level.
     * @param message The message to be sent.  */
    @JvmStatic
    fun config(message: String) = logger.config(message)

    /** Sends a message to the console with an [LogLevel.FINE] level.
     * @param message The message to be sent.  */
    @JvmStatic
    fun fine(message: String) = logger.fine(message)

    /** Sends a message to the console with an [LogLevel.FINER] level.
     * @param message The message to be sent.  */
    @JvmStatic
    fun finer(message: String) = logger.finer(message)

    /** Sends a message to the console with an [LogLevel.FINEST] level.
     * @param message The message to be sent.  */
    @JvmStatic
    fun finest(message: String) = logger.finest(message)
    
    @JvmStatic
    fun getLevelByName(level: String) = LogLevel.getLevelByName(level)

    /** A Class that represents Levels, which can be used in unison with [Log] */
    class LogLevel private constructor(private val level: Level) {
        companion object {
            /** A [LogLevel] object representing [Level.INFO]*/
            @JvmStatic
            val INFO = LogLevel(Level.INFO)

            /** A [LogLevel] object representing [Level.WARNING]*/
            @JvmStatic
            val WARNING = LogLevel(Level.WARNING)

            /** A [LogLevel] object representing [Level.SEVERE]*/
            @JvmStatic
            val SEVERE = LogLevel(Level.SEVERE)

            /** A [LogLevel] object representing [Level.CONFIG]*/
            @JvmStatic
            val CONFIG = LogLevel(Level.CONFIG)

            /** A [LogLevel] object representing [Level.FINE]*/
            @JvmStatic
            val FINE = LogLevel(Level.FINE)

            /** A [LogLevel] object representing [Level.FINER]*/
            @JvmStatic
            val FINER = LogLevel(Level.FINER)

            /** A [LogLevel] object representing [Level.FINEST]*/
            @JvmStatic
            val FINEST = LogLevel(Level.FINEST)

            /** Returns the [LogLevel] that has the name given.
             * @param level A [String] that represents a [LogLevel].
             * @return A [LogLevel] that has the same name as [level]. (Provided there is one.)
             * @exception IllegalLevelException If there is no such [LogLevel]. */
            @JvmStatic
            fun getLevelByName(level: String): LogLevel {
                return when (level.toLowerCase()) {
                    "info" -> INFO
                    "warn" -> WARNING
                    "warning" -> WARNING
                    "severe" -> SEVERE
                    "conf" -> CONFIG
                    "config" -> CONFIG
                    "fine" -> FINE
                    "finer" -> FINER
                    "finest" -> FINEST
                    else -> throw IllegalLevelException("$level is not a valid level!")
                }
            }
        }

        /** Returns the [Level] that this object represents.
         * @return The [Level] that this object represents. */
        internal fun getLoggingLevel() = level

        /** Returns the name of this LogLevel*/
        override fun toString(): String = "LogLevel: ${level.name.toLowerCase()}"
    }

    /** An Exception that is thrown when a specified [LogLevel] does not exist. */
    class IllegalLevelException // This syntax is pretty ... interesting.
    /** The constructor for this class (Provided that there is only one time when this class is used.)*/
        (message: String) : IllegalArgumentException(message)
}
