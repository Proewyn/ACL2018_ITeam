package plateau;

import monJeu.Bibliotheque;

public class Mur implements Case{
	
	private boolean traversable = false;
	private int id = Bibliotheque.MUR;
	private boolean visible = false;
	
	public Mur() {
		
	}
	
	public Mur(boolean b) {
		visible = b;
	}

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