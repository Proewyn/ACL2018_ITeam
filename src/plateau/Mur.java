package plateau;

import monJeu.Bibliotheque;

public class Mur implements Case {
	
	private boolean traversable;
	private boolean visible;
	
	/**
	 * Constructeur par defaut
	 */
	public Mur() {
		traversable = false;
		visible = false;
	}
	
	/**
	 * Cree un mur qui peut etre invisible
	 * @param b si le mur est visible ou non
	 */
	public Mur(boolean b) {
		visible = b;
		traversable = false;
	}

	@Override
	public boolean isTraversable() {
		return traversable;
	}

	@Override
	public int getId() {
		return Bibliotheque.MUR;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

}
