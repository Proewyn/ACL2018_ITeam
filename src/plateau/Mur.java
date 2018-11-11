package plateau;

import monJeu.Bibliotheque;

public class Mur implements Case{
	
	private boolean traversable;
	private boolean visible;
	
	public Mur() {
		traversable = false;
		visible = false;
	}
	
	public Mur(boolean b) {
		visible = b;
		traversable = false;
	}

	public boolean isTraversable() {
		return traversable;
	}

	public int getId() {
		return Bibliotheque.MUR;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return visible;
	}

}
