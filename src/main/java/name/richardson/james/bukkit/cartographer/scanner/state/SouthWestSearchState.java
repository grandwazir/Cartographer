package name.richardson.james.bukkit.cartographer.scanner.state;

public class SouthWestSearchState implements SearchState {

	@Override
	public int getXIncrement() {
		return -1;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public SearchState next() {
		return new WestSearchState();  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public SearchState previous() {
		return new SouthSearchState();  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getZIncrement() {
		return 1;  //To change body of implemented methods use File | Settings | File Templates.
	}


}
