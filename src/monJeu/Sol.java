package monJeu;

public class Sol implements Case{

	private boolean traversable = true;
	private int id = SOL;
	
	public boolean isTraversable() {
		return false;
	}

	public int getId() {
		return 0;
	}
	
}
