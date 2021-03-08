package org.tetragen

import org.bukkit.Bukkit
import org.bukkit.Server
import org.bukkit.World
import org.bukkit.generator.ChunkGenerator
import org.bukkit.plugin.PluginDescriptionFile
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.plugin.java.JavaPluginLoader
import org.tetragen.utils.Log
import org.tetragen.utils.Text
import java.io.File

/** The class where the actual plugin is located:
 * @author croissant396*/
class Tetragen(loader: JavaPluginLoader, description: PluginDescriptionFile, dataFolder: File, file: File) :
    JavaPlugin(loader, description, dataFolder, file) {
    companion object{
        /** Helps shorten (ever so slightly) the amount of boilerplate code needed.*/
        val server: Server = Bukkit.getServer()
        /** A list of worlds that this plugin will not change. */
        var listOfWorlds: MutableList<World> = Bukkit.getWorlds()
        /** Whether nether is enabled; Consequently whether the nether generator will be used*/
        var netherEnabled = Bukkit.getAllowNether()
        /** Whether end is enabled; Consequently whether the end generator will be used*/
        var endEnabled = Bukkit.getAllowEnd()
    }
    /** When this plugin is enabled.. */
    override fun onEnable() {
        Log.info("${Text.GREEN} Tetragen (version 1.0.0) is enabled!")
        Log.info("${Text.GREEN} Initializing variables... ")
        saveDefaultConfig()
        config.addDefault("mechanics.default-generator-type", "overworld")
        config.addDefault("mechanics.worlds-exempt-list", "@Example: \"world_nether\",\"world_the_end\"")
        config.addDefault("mechanics.worlds-type-list", "@Example:(\"world\",\"overworld\")")
        config.addDefault("generation.biome-size", 1.0)
        config.addDefault("generation.sea-level", 64)
        config.addDefault("generation.mountain-height", 128)
        Generator.biomeSize = config.getDouble("generation.biome-size")
        Generator.seaLevel = config.getInt("generation.sea-level")
        Generator.mountainHeight = config.getInt("generation.mountain-height")
        //Add exempt worlds
        var exemptString = config.getString("mechanics.worlds-exempt-list")
        if(exemptString != "none" && !exemptString!!.startsWith("@Example")){
            var worlds = exemptString.split(",")
            for(index in worlds.indices){
                var world = worlds[index]
                world = world.removePrefix("\"").removeSuffix("\"")
                if(Bukkit.getWorld(world) != null) listOfWorlds.remove(Bukkit.getWorld(world)!!) else Log.severe("Variable \"worlds-exempt-list\"" +
                        " in file ${Text.DARK_RED}\"config.yml\"${Text.RED} contains illegal element $world")
            }
        }
        Log.info("${Text.GREEN} Scanning for previous worlds... ")
        var numberOfWorlds = Bukkit.getWorlds().size
        if(numberOfWorlds == 0){

        }
    }
    /** Checks what the default world generator type is and returns the complementary generator */
    override fun getDefaultWorldGenerator(worldName: String, id: String?): ChunkGenerator {
        var defaultGeneratorType = config.getString("default-generator-type")
        var additionalDefaultName = config.getString()
        if(defaultGeneratorType == "overworld"){
            if(worldName == "world_nether") return TetraNetherGenerator()
            else if(worldName == "world_the_end") return TetraEndGenerator()
            else return TetraOverworldGenerator()
        }
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
            Log.severe("${Text.RED}Variable \"biome-size\" in file ${Text.DARK_RED}\"config.yml\"${Text.RED} cannot be less than ${Text.DARK_RED}0${Text.RED}.")
            Log.severe("${Text.RED}The value for \"biome-size\" will be restored to the default value of ${Text.DARK_RED}1.0${Text.RED}.")
            biomeSize = 1.0
        }
        if(seaLevel < 0){
            Log.severe("${Text.RED}Variable \"sea-level\" in file ${Text.DARK_RED}\"config.yml\"${Text.RED} cannot be less than ${Text.DARK_RED}0${Text.RED}.")
            Log.severe("${Text.RED}The value for \"sea-level\" will be restored to the default value of ${Text.DARK_RED}64${Text.RED}.")
            seaLevel = 64
        }else if(seaLevel > 256){
            Log.severe("${Text.RED}Variable \"sea-level\" in file ${Text.DARK_RED}\"config.yml\"${Text.RED} cannot exceed ${Text.DARK_RED}256${Text.RED}.")
            Log.severe("${Text.RED}The value for \"sea-level\" will be restored to the default value of ${Text.DARK_RED}64${Text.RED}.")
            seaLevel = 64
        }
        if(mountainHeight < 0){
            Log.severe("${Text.RED}Variable \"mountain-height\" in file ${Text.DARK_RED}\"config.yml\"${Text.RED} cannot be less than ${Text.DARK_RED}0${Text.RED}.")
            Log.severe("${Text.RED}The value for \"mountain-height\" will be restored to the default value of ${Text.DARK_RED}128${Text.RED}.")
            mountainHeight = 128
        }else if(mountainHeight > 256){
            Log.severe("${Text.RED}Variable \"mountain-height\" in file ${Text.DARK_RED}\"config.yml\"${Text.RED} cannot exceed ${Text.DARK_RED}256${Text.RED}.")
            Log.severe("${Text.RED}The value for \"mountain-height\" will be restored to the default value of ${Text.DARK_RED}128${Text.RED}.")
            mountainHeight = 128
        }
        return
    }
}
