package name.richardson.james.bukkit.cartographer.scanner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
public class StrictScannerTest extends AbstractScannerTest {

	@Before
	public void setUp()
	throws Exception {
		setScanner(new StrictScanner(getMockBiomeProvider(), new NorthSearchState(), new BlockVector2D(0,0)));
	}

}
