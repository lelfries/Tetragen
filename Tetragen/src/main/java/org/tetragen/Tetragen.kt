package org.tetragen

import org.bukkit.plugin.PluginDescriptionFile
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.plugin.java.JavaPluginLoader
import java.io.File

class Tetragen(loader: JavaPluginLoader, description: PluginDescriptionFile, dataFolder: File, file: File) :
    JavaPlugin(loader, description, dataFolder, file) {
    override fun onEnable() {

    }
}