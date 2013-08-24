package name.richardson.james.bukkit.cartographer.scanner;

import java.util.*;

import org.bukkit.block.Biome;

import com.sk89q.worldedit.BlockVector2D;

import name.richardson.james.bukkit.cartographer.scanner.provider.BiomeProvider;
import name.richardson.james.bukkit.cartographer.scanner.state.SearchState;

public abstract class AbstractScanner implements Scanner {

	private final Set<BlockVector2D> edge = new LinkedHashSet<BlockVector2D>();
	private final Set<BlockVector2D> biomes = new LinkedHashSet<BlockVector2D>();

	private Biome biome;
	private BiomeProvider biomeProvider;
	private BlockVector2D current;
	private boolean finished = false;
	private boolean initialSearch = true;
	private Biome lastBoundary;
	private SearchState searchState;

	public AbstractScanner(BiomeProvider provider, SearchState searchState, BlockVector2D current) {
		biomeProvider = provider;
		this.searchState = searchState;
		this.current = current;
	}

	/**
	 * Returns all the block vectors that make up the edge of the biome that is being scanned.
	 * <p/>
	 * This should only be called once scanning is complete.
	 *
	 * @return the block vectors that create the edge of this shape.
	 */
	@Override
	public final Set<BlockVector2D> getEdge() {
		return Collections.unmodifiableSet(edge);
	}

	/**
	 * Returns <code>true</code> if the scanner has followed a completed edge.
	 *
	 * @return Returns <code>true</code> if finished; <code>false</code> otherwise.
	 */
	@Override
	public final boolean isFinished() {
		return finished;
	}

	protected final void setFinished(boolean finished) {
		this.finished = finished;
	}

	public final Set<BlockVector2D> getBiomes() {
		return Collections.unmodifiableSet(biomes);
	}

	/**
	 * Returns the coordinates of the next block in the search sequence.
	 *
	 * @return the coordinate of the next block
	 */
	@Override
	public final BlockVector2D next() {
		int x = getCurrent().getBlockX() + getSearchState().getXIncrement();
		int z = getCurrent().getBlockZ() + getSearchState().getZIncrement();
		return new BlockVector2D(x, z);
	}

	/**
	 * Returns the coordinates of the last block in the search sequence.
	 *
	 * @return the coordinate of the last block
	 */
	@Override
	public final BlockVector2D previous() {
		int x = getCurrent().getBlockX() - getSearchState().getXIncrement();
		int z = getCurrent().getBlockZ() - getSearchState().getZIncrement();
		return new BlockVector2D(x, z);
	}

	public final void scan() {
		BlockVector2D block = next();

		// if the block we are handling is already known assume we have made our way around the edge
		if (edge.contains(block)) {
			setFinished(true);
			return;
		}

		Biome biome = getBiomeProvider().getBiome(block);
		// Set inital biome
		if (this.biome == null) {
			this.biome = biome;
			this.lastBoundary = biome;
		}

		// if we are in the initial search phase; i.e have not found the edge yet:
		// keep moving forward in one direction until we find it.
		if (initialSearch && matches(biome)) {
			this.setCurrent(block);
			return;
			// else enable edge detection
		} else {
			initialSearch = false;
		}

		// check to see if the current biome matches our search biome
		// we check for null here to handle cases when we get to the edge.
		if (!matches(biome)) {
			// in this case we have reached an edge:
			// we need to back up, record the previous location in the edge list and then set the search state for next time.
			this.edge.add(current());
			// check if we have seen this edge before, if we haven't add to the list of new biomes to search
			if (lastBoundary != biome) {
				lastBoundary = biome;
				biomes.add(next());
			}
			this.setSearchState(getSearchState().next());
		} else {
			// in the case we have lost the edge and need to try and find it again:
			// set the current block to the block we just scanned and change the search state
			this.setCurrent(block);
			this.setSearchState(getSearchState().previous());
		}
	}

	protected final BlockVector2D current() {
		return getCurrent();
	}

	protected Biome getBiome() {
		return biome;
	}

	protected final BiomeProvider getBiomeProvider() {
		return biomeProvider;
	}

	protected final BlockVector2D getCurrent() {
		return current;
	}

	protected final void setCurrent(BlockVector2D current) {
		this.current = current;
	}

	protected final SearchState getSearchState() {
		return searchState;
	}

	protected final void setSearchState(SearchState searchState) {
		this.searchState = searchState;
	}

	abstract protected boolean matches(Biome biome);

}
