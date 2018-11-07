package plateau;

import monJeu.Bibliotheque;

public class Sol implements Case{

	private boolean traversable = true;
	private int id = Bibliotheque.SOL;
	private boolean visible = false;
	
	public boolean isTraversable() {
		return traversable;
	}

	public int getId() {
		return id;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return visible;
	}

}
