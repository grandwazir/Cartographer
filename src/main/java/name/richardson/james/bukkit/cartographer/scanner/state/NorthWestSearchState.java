package name.richardson.james.bukkit.cartographer.scanner.state;

/**
 * Created with IntelliJ IDEA. User: james Date: 18/08/13 Time: 13:48 To change this template use File | Settings | File Templates.
 */
public class NorthWestSearchState implements SearchState {

	@Override
	public int getXIncrement() {
		return -1;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public SearchState next() {
		return new NorthSearchState();
	}

	@Override
	public SearchState previous() {
		return new WestSearchState();
	}

	@Override
	public int getZIncrement() {
		return -1;  //To change body of implemented methods use File | Settings | File Templates.
	}

}
