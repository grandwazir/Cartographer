package name.richardson.james.bukkit.cartographer.scanner.state;

public class EastSearchState implements SearchState {

	@Override
	public int getZIncrement() {
		return 0;
	}

	@Override
	public int getXIncrement() {
		return 1;
	}

	@Override
	public SearchState next() {
		return new SouthEastSearchState();  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public SearchState previous() {
		return new NorthEastSearchState();  //To change body of implemented methods use File | Settings | File Templates.
	}

}
