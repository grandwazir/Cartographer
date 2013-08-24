package name.richardson.james.bukkit.cartographer.scanner;

import org.bukkit.block.Biome;

import com.sk89q.worldedit.BlockVector2D;

import name.richardson.james.bukkit.cartographer.scanner.provider.BiomeProvider;
import name.richardson.james.bukkit.cartographer.scanner.state.SearchState;

public class PermissiveScanner extends AbstractScanner {

	public PermissiveScanner(BiomeProvider provider, SearchState searchState, BlockVector2D current) {
		super(provider, searchState, current);
	}

	@Override
	protected boolean matches(Biome biome) {
		if (biome == null) return false;
		if (getBiome() != Biome.OCEAN && biome == Biome.RIVER) return true;
		if (getBiome() != Biome.OCEAN && biome == Biome.FROZEN_RIVER) return true;
		if (getBiome().name().contains(biome.name()) || biome.name().contains(getBiome().name())) return true;
		if (getBiome().equals(biome)) return true;
		return false;
	}

}
