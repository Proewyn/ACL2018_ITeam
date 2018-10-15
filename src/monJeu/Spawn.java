package monJeu;

public class Spawn implements Case{

	private boolean traversable = true;
	private int id = Bibliotheque.SPAWN;
	
	
	public boolean isTraversable() {
		return traversable;
	}

	public int getId() {
		return id;
	}

}
