package monJeu;

public class Sol implements Case{

	private boolean traversable = true;
	private int id = bibliotheque.SOL;
	
	public boolean isTraversable() {
		return true;
	}

	public int getId() {
		return id;
	}


}
