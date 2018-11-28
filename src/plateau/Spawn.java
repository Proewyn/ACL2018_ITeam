package plateau;

import monJeu.Bibliotheque;

public class Spawn implements Case {

	private boolean traversable;
	private boolean visible;

	/**
	 * Constructeur par defaut
	 */
	public Spawn(){
		traversable = true;
		visible = false;
	}
	
	@Override
	public boolean isTraversable() {
		return traversable;
	}

	@Override
	public int getId() {
		return Bibliotheque.SPAWN;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

}
