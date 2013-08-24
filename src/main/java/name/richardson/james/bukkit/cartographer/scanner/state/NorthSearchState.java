package name.richardson.james.bukkit.cartographer.scanner.state;

public class NorthSearchState implements SearchState {

	public int getXIncrement() {
		return 0;
	}

	public int getZIncrement() {
		return -1;
	}

	public SearchState previous() {
		return new NorthWestSearchState();
	}

	public SearchState next() {
		return new NorthEastSearchState();
	}

}
