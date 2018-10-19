package monJeu;

public class Mur implements Case{
	
	private boolean traversable = false;
	private int id = Bibliotheque.MUR;
	
	
	public boolean isTraversable() {
		return traversable;
	}

	public int getId() {
		return id;
	}

	
}
