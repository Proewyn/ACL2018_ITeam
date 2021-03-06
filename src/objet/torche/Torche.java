package objet.torche;

import monJeu.Bibliotheque;
import monJeu.MonJeu;
import objet.Objet;

public abstract class Torche implements Objet {
	protected int x;
	protected int y;
	protected boolean pasTrouve;
	
	/**
	 * Cree une torche
	 * @param x position en X
	 * @param y position en Y
	 */
	public Torche(int x,int y) {
		this.x=x;
		this.y=y;
		this.pasTrouve=true;
	}

	@Override
	public void Collision(MonJeu mj, int x, int y) {
		if(pasTrouve && this.x==x && this.y==y)
			this.action(mj);
	}

	public boolean isPasTrouve() {
		return pasTrouve;
	}

	public int getId(){
		return Bibliotheque.TORCHE;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getX() {
		return x;
	}

}
