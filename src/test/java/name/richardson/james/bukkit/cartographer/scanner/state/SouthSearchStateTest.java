package name.richardson.james.bukkit.cartographer.scanner.state;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SouthSearchStateTest {

	private SouthSearchState state;

	@Test
	public void getX()
	throws Exception {
		Assert.assertEquals(state.getXIncrement(), 0);
	}

	@Test
	public void getZ()
	throws Exception {
		Assert.assertEquals(state.getZIncrement(), 1);
	}

	@Test
	public void next()
	throws Exception {
		Assert.assertTrue(state.next() instanceof SouthWestSearchState);
	}

	@Test
	public void previous()
	throws Exception {
		Assert.assertTrue(state.previous() instanceof SouthEastSearchState);
	}

	@Before
	public void setUp()
	throws Exception {
		state = new SouthSearchState();
	}


}
