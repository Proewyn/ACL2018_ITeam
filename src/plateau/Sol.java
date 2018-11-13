package plateau;

import monJeu.Bibliotheque;

public class Sol implements Case{

	private boolean traversable;
	private boolean visible;
	
	public Sol(){
		this.traversable =true;
		this.visible =false;
	}
	
	public boolean isTraversable() {
		return traversable;
	}

	public int getId() {
		return Bibliotheque.SOL;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return visible;
	}

}
