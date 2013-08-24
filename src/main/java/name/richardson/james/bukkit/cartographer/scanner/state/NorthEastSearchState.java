package name.richardson.james.bukkit.cartographer.scanner.state;

public class NorthEastSearchState implements SearchState {

	@Override
	public int getXIncrement() {
		return 1;
	}

	@Override
	public SearchState next() {
		return new EastSearchState();
	}

	@Override
	public SearchState previous() {
		return new NorthSearchState();
	}

	@Override
	public int getZIncrement() {
		return -1;
	}



}
