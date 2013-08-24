package name.richardson.james.bukkit.cartographer.scanner.provider;

import org.bukkit.World;
import org.bukkit.block.Biome;

import com.sk89q.worldedit.BlockVector2D;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RealtimeBiomeProviderTest extends TestCase {

	private BiomeProvider provider;

	@Test
	public void testGetBiome()
	throws Exception {
		assertEquals(Biome.BEACH, provider.getBiome(new BlockVector2D(0,0)));
	}

	@Before
	public void setUp()
	throws Exception {
		World world = mock(World.class);
		when(world.getBiome(0,0)).thenReturn(Biome.BEACH);
		provider = new RealtimeBiomeProvider(world);
	}
}
