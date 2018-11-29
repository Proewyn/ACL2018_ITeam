package objet.coffre;

import monJeu.Bibliotheque;
import monJeu.MonJeu;
import objet.Objet;

public abstract class Coffre implements Objet {
	protected int x;
	protected int y;
	protected boolean pasTrouve;
	
	/**
	 * Cree un coffre
	 * @param x position en X
	 * @param y position en Y
	 */
	public Coffre(int x,int y) {
		this.x=x;
		this.y=y;
		this.pasTrouve=true;
	}

	@Override
	public void Collision(MonJeu mj, int x, int y) {
		if(pasTrouve && this.x==x && this.y==y)
			this.action(mj);
	}

	@Override
	public int getId() {
		return Bibliotheque.COFFRE;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public boolean isPasTrouve() {
		return pasTrouve;
	}

}
