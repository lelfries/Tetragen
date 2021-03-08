package org.tetragen

import org.bukkit.World
import org.bukkit.generator.BlockPopulator
import org.bukkit.generator.ChunkGenerator
import java.util.*

class TetraGenerator : ChunkGenerator() {
    override fun generateChunkData(world: World, random: Random, x: Int, z: Int, biome: BiomeGrid): ChunkData {
        return when(world.name){
            "world" -> TetraOverworldGenerator().generateChunkData(world, random, x, z, biome)
            "world_nether" -> TetraNetherGenerator().generateChunkData(world, random, x, z, biome)
            "world_end" -> TetraEndGenerator().generateChunkData(world, random, x, z, biome)
            else -> TetraOverworldGenerator().generateChunkData(world, random, x, z, biome)
        }
    }
}
class TetraOverworldGenerator: ChunkGenerator() {
    override fun generateChunkData(world: World, random: Random, x: Int, z: Int, biome: BiomeGrid): ChunkData {
        return createChunkData(world)
    }
}
class TetraNetherGenerator: ChunkGenerator(){
    override fun generateChunkData(world: World, random: Random, x: Int, z: Int, biome: BiomeGrid): ChunkData {
        return createChunkData(world)
    }
}
class TetraEndGenerator: ChunkGenerator(){
    override fun generateChunkData(world: World, random: Random, x: Int, z: Int, biome: BiomeGrid): ChunkData {
        return createChunkData(world)
    }
}