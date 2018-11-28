package plateau;

import monJeu.Bibliotheque;

public class Sol implements Case {

	private boolean traversable;
	private boolean visible;
	
	/**
	 * Constructeur par defaut
	 */
	public Sol(){
		this.traversable =true;
		this.visible =false;
	}
	
	@Override
	public boolean isTraversable() {
		return traversable;
	}

	@Override
	public int getId() {
		return Bibliotheque.SOL;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

}
