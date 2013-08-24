package name.richardson.james.bukkit.cartographer.scanner;

import org.bukkit.block.Biome;

import com.sk89q.worldedit.BlockVector2D;

import name.richardson.james.bukkit.cartographer.scanner.provider.BiomeProvider;
import name.richardson.james.bukkit.cartographer.scanner.state.SearchState;

public class StrictScanner extends AbstractScanner {

	public StrictScanner(BiomeProvider provider, SearchState searchState, BlockVector2D current) {
		super(provider, searchState, current);
	}

	@Override
	protected boolean matches(Biome biome) {
		if (biome == null) return false;
		if (biome.equals(getBiome())) return true;
		return false;
	}

}
