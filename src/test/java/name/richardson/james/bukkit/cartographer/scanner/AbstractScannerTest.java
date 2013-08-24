package name.richardson.james.bukkit.cartographer.scanner;

import java.util.Arrays;
import java.util.List;

import org.bukkit.block.Biome;

import com.sk89q.worldedit.BlockVector2D;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import name.richardson.james.bukkit.cartographer.scanner.provider.BiomeProvider;
import name.richardson.james.bukkit.cartographer.scanner.state.SearchState;

import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.when;

public abstract class AbstractScannerTest extends TestCase {

	private AbstractScanner scanner;

	@Test
	public final void isFinished_WhenScannerInitalised_ReturnFalse() {
		assertFalse(getScanner().isFinished());
	}

	@Test
	public final void next_WhenNextRequested_ReturnCorrectBlock() {
		BlockVector2D current = scanner.getCurrent();
		BlockVector2D next = scanner.next();
		assertNotSame(current, next);
		assertEquals((current.getBlockX() + scanner.getSearchState().getXIncrement()), next.getBlockX());
		assertEquals((current.getBlockZ() + scanner.getSearchState().getZIncrement()), next.getBlockZ());
	}

	@Test
	public final void next_WhenPreviousRequested_ReturnCorrectBlock() {
		BlockVector2D current = scanner.getCurrent();
		BlockVector2D previous = scanner.previous();
		assertNotSame(current, previous);
		assertEquals((current.getBlockX() - scanner.getSearchState().getXIncrement()), previous.getBlockX());
		assertEquals((current.getBlockZ() - scanner.getSearchState().getZIncrement()), previous.getBlockZ());
	}

	@Test(timeout = 100)
	public void scan_WhenFinishedScanning_EdgeBiomesDetectedCorrectly() {
		while(!scanner.isFinished()) {
			scanner.scan();
		}
		assertEquals(1, scanner.getBiomes().size());
	}

	@Test(timeout = 100)
	public void scan_WhenScanningBasicSquare_BuildEdgeCorrectly() {
	  while(!scanner.isFinished()) {
			scanner.scan();
		}
		assertEquals(4, scanner.getEdge().size());
	}

	protected BiomeProvider getMockBiomeProvider() {
		BiomeProvider provider = mock(BiomeProvider.class);
		when(provider.getBiome(Matchers.<BlockVector2D>anyObject())).thenAnswer(new Answer<Object>() {
			@Override
			public Object answer(InvocationOnMock invocation)
			throws Throwable {
				Object[] args = invocation.getArguments();
				List<BlockVector2D> valid = Arrays.asList(
				new BlockVector2D(0, -1),
				new BlockVector2D(1, -1),
				new BlockVector2D(1, 0),
				new BlockVector2D(0,0)
				);
				BlockVector2D vector = (BlockVector2D) args[0];
				if (valid.contains(vector)) return Biome.FOREST;
				return Biome.DESERT;
			}
		});
		return provider;
	}

	protected final Scanner getScanner() {
		return scanner;
	}

	protected final void setScanner(Scanner scanner) {
		this.scanner = (AbstractScanner) scanner;
	}

}
