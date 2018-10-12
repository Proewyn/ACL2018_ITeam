package monJeu;

public class Mur implements Case{
	
	private boolean traversable = false;
	private int id = bibliotheque.MUR;
	
	
	public boolean isTraversable() {
		return false;
	}

	public int getId() {
		return id;
	}

	
}
