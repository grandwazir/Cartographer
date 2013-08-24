package name.richardson.james.bukkit.cartographer.scanner;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.block.Biome;

import com.sk89q.worldedit.BlockVector2D;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Matchers;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import name.richardson.james.bukkit.cartographer.scanner.provider.BiomeProvider;
import name.richardson.james.bukkit.cartographer.scanner.state.NorthSearchState;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class PermissiveScannerTest extends AbstractScannerTest {

	@Before
	public void setUp()
	throws Exception {
		setScanner(new PermissiveScanner(getMockBiomeProvider(), new NorthSearchState(), new BlockVector2D(0,0)));
	}

	@Override
	protected BiomeProvider getMockBiomeProvider() {
		BiomeProvider provider = mock(BiomeProvider.class);
		when(provider.getBiome(Matchers.<BlockVector2D>anyObject())).thenAnswer(new Answer<Object>() {
			@Override
			public Object answer(InvocationOnMock invocation)
			throws Throwable {
				Object[] args = invocation.getArguments();
				BlockVector2D vector = (BlockVector2D) args[0];
				Map<BlockVector2D, Biome> biomes = new HashMap<BlockVector2D, Biome>();
				biomes.put(new BlockVector2D(0, -1), Biome.FOREST);
				biomes.put(new BlockVector2D(1, -1), Biome.FOREST_HILLS);
				biomes.put(new BlockVector2D(1, 0), Biome.RIVER);
				biomes.put(new BlockVector2D(0, 0), Biome.FOREST);
				if (biomes.containsKey(vector)) {
					return biomes.get(vector);
				} else {
					return Biome.DESERT;
				}
			}
		});
		return provider;
	}



}
