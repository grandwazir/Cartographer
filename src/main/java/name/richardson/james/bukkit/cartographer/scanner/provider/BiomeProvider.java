package name.richardson.james.bukkit.cartographer.scanner.provider;

import org.bukkit.block.Biome;

import com.sk89q.worldedit.BlockVector2D;
import com.sk89q.worldedit.BlockWorldVector2D;

/**
 * Provides Biome information on specific blocks. This is useful to abstract away the implementation of this function for later development in case we want to
 * develop a snapshot cache for example.
 */
public interface BiomeProvider {

	/**
	 * Returns the biome at a specific location.
	 *
	 * @param block
	 * @return the biome at this location.
	 */
	public Biome getBiome(BlockVector2D block);

}
