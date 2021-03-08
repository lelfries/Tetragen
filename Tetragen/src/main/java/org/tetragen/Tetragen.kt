package org.tetragen

import org.bukkit.Bukkit
import org.bukkit.Server
import org.bukkit.entity.Panda
import org.bukkit.generator.ChunkGenerator
import org.bukkit.plugin.PluginDescriptionFile
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.plugin.java.JavaPluginLoader
import org.jetbrains.annotations.NotNull
import org.tetragen.utils.Log
import org.tetragen.utils.Text
import java.io.File

class Tetragen(loader: JavaPluginLoader, description: PluginDescriptionFile, dataFolder: File, file: File) :
    JavaPlugin(loader, description, dataFolder, file) {

    companion object{
        /** Helps shorten (ever so slightly) the amount of boilerplate code needed.*/
        val server: Server = Bukkit.getServer()
        /** A list of worlds that this plugin will change. */
        val genWorlds = ArrayList<String>(5) // 5 at most...
    }
    @NotNull
    val worlds = ArrayList<String>()
    /** When this plugin is enabled.. */
    override fun onEnable() {
        Log.info("${Text.GREEN} Tetragen (version 1.0.0) is enabled!")
        Log.info("${Text.GREEN} Initializing variables... ")
        saveDefaultConfig()
        config.addDefault("generation.biome-size", 1.0)
        config.addDefault("generation.sea-level", 64)
        config.addDefault("generation.mountain-height", 128)
        Generator.biomeSize = config.getDouble("generation.biome-size")
        Generator.seaLevel = config.getInt("generation.sea-level")
        Generator.mountainHeight = config.getInt("generation.mountain-height")
        Log.info("${Text.GREEN} Scanning for previous worlds... ")

    }

    override fun getDefaultWorldGenerator(worldName: String, id: String?): ChunkGenerator {
        return TetraGenerator()
    }
}

object Generator {
    /** Double for size of biomes: 1.0 for default size. */
    var biomeSize = 1.0
    /** Height at which the oceans stop. Cannot be above 256. */
    var seaLevel = 64
    /** Height at which the mountains stop. Cannot be above 256 */
    var mountainHeight = 128
    /** Checks if any of the variables are `illegal`, ie. a value that cannot be fulfilled. */
    fun checkVariables(){
        if(biomeSize < 0.0){
            Log.message("${Text.RED}Variable \"biome-size\" in file ${Text.DARK_RED}\"config.yml\"${Text.RED} cannot be less than ${Text.DARK_RED}0${Text.RED}.")
            Log.message("${Text.RED}The value for \"biome-size\" will be restored to the default value of ${Text.DARK_RED}1.0${Text.RED}.")
            biomeSize = 1.0
        }
        if(seaLevel < 0){
            Log.message("${Text.RED}Variable \"sea-level\" in file ${Text.DARK_RED}\"config.yml\"${Text.RED} cannot be less than ${Text.DARK_RED}0${Text.RED}.")
            Log.message("${Text.RED}The value for \"sea-level\" will be restored to the default value of ${Text.DARK_RED}64${Text.RED}.")
            seaLevel = 64
        }else if(seaLevel > 256){
            Log.message("${Text.RED}Variable \"sea-level\" in file ${Text.DARK_RED}\"config.yml\"${Text.RED} cannot exceed ${Text.DARK_RED}256${Text.RED}.")
            Log.message("${Text.RED}The value for \"sea-level\" will be restored to the default value of ${Text.DARK_RED}64${Text.RED}.")
            seaLevel = 64
        }
        if(mountainHeight < 0){
            Log.message("${Text.RED}Variable \"mountain-height\" in file ${Text.DARK_RED}\"config.yml\"${Text.RED} cannot be less than ${Text.DARK_RED}0${Text.RED}.")
            Log.message("${Text.RED}The value for \"mountain-height\" will be restored to the default value of ${Text.DARK_RED}128${Text.RED}.")
            mountainHeight = 128
        }else if(mountainHeight > 256){
            Log.message("${Text.RED}Variable \"mountain-height\" in file ${Text.DARK_RED}\"config.yml\"${Text.RED} cannot exceed ${Text.DARK_RED}256${Text.RED}.")
            Log.message("${Text.RED}The value for \"mountain-height\" will be restored to the default value of ${Text.DARK_RED}128${Text.RED}.")
            mountainHeight = 128
        }
        return
    }
}
