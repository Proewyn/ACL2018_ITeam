package monJeu;

public class Spawn implements Case{

	private boolean traversable = true;
	private int id = Bibliotheque.SPAWN;
	private boolean visible = false;
	
	
	public boolean isTraversable() {
		return traversable;
	}

	public int getId() {
		return id;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

}
