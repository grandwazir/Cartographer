package name.richardson.james.bukkit.cartographer.scanner.state;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class NorthSearchStateTest {

	private NorthSearchState state;

	@Test
	public void getX()
	throws Exception {
		Assert.assertEquals(state.getXIncrement(), 0);
	}

	@Test
	public void getZ()
	throws Exception {
		Assert.assertEquals(state.getZIncrement(), -1);
	}

	@Test
	public void next()
	throws Exception {
		Assert.assertTrue(state.next() instanceof NorthEastSearchState);
	}

	@Test
	public void previous()
	throws Exception {
		Assert.assertTrue(state.previous() instanceof NorthWestSearchState);
	}

	@Before
	public void setUp()
	throws Exception {
		state = new NorthSearchState();
	}

}
