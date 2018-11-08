package plateau;

import monJeu.Bibliotheque;

public class Spawn implements Case{

	private boolean traversable;
	private boolean visible;

	public Spawn(){
		traversable = true;
		visible = false;
	}
	
	public boolean isTraversable() {
		return traversable;
	}

	public int getId() {
		return Bibliotheque.SPAWN;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

}
