package name.richardson.james.bukkit.cartographer.scanner.state;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA. User: james Date: 20/08/13 Time: 14:37 To change this template use File | Settings | File Templates.
 */
public class NorthWestSearchStateTest {

	private NorthWestSearchState state;

	@Test
	public void getX()
	throws Exception {
		Assert.assertEquals(state.getXIncrement(), -1);
	}

	@Test
	public void getZ()
	throws Exception {
		Assert.assertEquals(state.getZIncrement(), -1);
	}

	@Test
	public void next()
	throws Exception {
		Assert.assertTrue(state.next() instanceof NorthSearchState);
	}

	@Test
	public void previous()
	throws Exception {
		Assert.assertTrue(state.previous() instanceof WestSearchState);
	}

	@Before
	public void setUp()
	throws Exception {
		state = new NorthWestSearchState();
	}

}
