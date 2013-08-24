package name.richardson.james.bukkit.cartographer.scanner.state;

/**
 * Created with IntelliJ IDEA. User: james Date: 18/08/13 Time: 11:11 To change this template use File | Settings | File Templates.
 */
public class SouthSearchState implements SearchState {

	@Override
	public int getXIncrement() {
		return 0;
	}

	@Override
	public int getZIncrement() {
		return 1;
	}

	@Override
	public SearchState next() {
		return new SouthWestSearchState();
	}

	@Override
	public SearchState previous() {
		return new SouthEastSearchState();
	}

}
