package name.richardson.james.bukkit.cartographer.scanner.state;


public interface SearchState {

	public int getZIncrement();

	public int getXIncrement();

	public SearchState next();

	public SearchState previous();


}
