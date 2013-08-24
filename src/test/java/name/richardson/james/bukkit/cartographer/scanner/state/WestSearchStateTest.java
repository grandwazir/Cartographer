package name.richardson.james.bukkit.cartographer.scanner.state;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WestSearchStateTest {

	private WestSearchState state;

	@Test
	public void getX()
	throws Exception {
		Assert.assertEquals(state.getXIncrement(), -1);
	}

	@Test
	public void getZ()
	throws Exception {
		Assert.assertEquals(state.getZIncrement(), 0);
	}

	@Test
	public void next()
	throws Exception {
		Assert.assertTrue(state.next() instanceof NorthWestSearchState);
	}

	@Test
	public void previous()
	throws Exception {
		Assert.assertTrue(state.previous() instanceof SouthWestSearchState);
	}

	@Before
	public void setUp()
	throws Exception {
		state = new WestSearchState();
	}

}
