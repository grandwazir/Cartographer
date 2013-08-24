package name.richardson.james.bukkit.cartographer.scanner;

import java.util.List;
import java.util.Set;

import com.sk89q.worldedit.BlockVector2D;

/**
 * Scans through the blocks in a Biome until it reaches an edge then follows the edge around the outside to create a new Biome. Scanners used with Matchers
 * enable to plugin to create regions based on biome locations.
 */
public interface Scanner {

	/**
	 * Returns all the block vectors that make up the edge of the biome that is being scanned.
	 * <p/>
	 * This should only be called once scanning is complete.
	 *
	 * @return the block vectors that create the edge of this shape.
	 */
	public Set<BlockVector2D> getEdge();

	/**
	 * Returns <code>true</code> if the scanner has followed a completed edge.
	 *
	 * @return Returns <code>true</code> if finished; <code>false</code> otherwise.
	 */
	public boolean isFinished();

	/**
	 * Returns the coordinates of the next block in the search sequence.
	 *
	 * @return the coordinate of the next block
	 */
	public BlockVector2D next();

	/**
	 * Returns the coordinates of the last block in the search sequence.
	 *
	 * @return the coordinate of the last block
	 */
	public BlockVector2D previous();

	/**
	 * Scan the next block in the region to see if it makes up part of this biome.
	 * <p/>
	 * If it does match this biome, then continue moving in the same direction. If it does not match this biome; stop, log the present position as part of the
	 * edge, move backwards to the previous position, add the previous location to the edge list and then change direction.
	 */
	public void scan();

	/**
	 * Returns all the block vectors of new biomes that were found while searching for this one.
	 *
	 * @return the block vectors of biomes found when following the edge.
	 */
	public Set<BlockVector2D> getBiomes();

}
