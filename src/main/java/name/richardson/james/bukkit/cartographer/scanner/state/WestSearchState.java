package name.richardson.james.bukkit.cartographer.scanner.state;

public class WestSearchState implements SearchState {

	@Override
	public int getXIncrement() {
		return -1;
	}

	@Override
	public int getZIncrement() {
		return 0;
	}

	@Override
	public SearchState next() {
		return new NorthWestSearchState();
	}

	@Override
	public SearchState previous() {
		return new SouthWestSearchState();
	}

}
