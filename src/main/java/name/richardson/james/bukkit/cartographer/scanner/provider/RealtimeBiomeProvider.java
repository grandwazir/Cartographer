package name.richardson.james.bukkit.cartographer.scanner.provider;

import org.bukkit.World;
import org.bukkit.block.Biome;

import com.sk89q.worldedit.BlockVector2D;

/**
 * Resolves the biome at a given BlockVector2d by passing the request through to a Bukkit World. This class should not be used in any asynchronous classes as it
 * the underlying call is not threadsafe.
 */
public class RealtimeBiomeProvider implements BiomeProvider {

	private final World world;

	public RealtimeBiomeProvider(World world) {
		this.world = world;
	}

	/**
	 * Returns the biome at a specific location.
	 *
	 * @param block
	 * @return the biome at this location.
	 */
	@Override
	public Biome getBiome(BlockVector2D block) {
		return world.getBiome(block.getBlockX(), block.getBlockZ());
	}
}
