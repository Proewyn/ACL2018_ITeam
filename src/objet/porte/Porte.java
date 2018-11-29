package objet.porte;

import monJeu.Bibliotheque;
import monJeu.MonJeu;
import objet.Objet;
import objet.coffre.CoffreDeClef;

public abstract class Porte implements Objet {

	protected int x;
	protected int y;
	protected CoffreDeClef clef;
	
	public Porte(int x,int y, CoffreDeClef c) {
		this.x=x;
		this.y=y;
		this.clef=c;
	}
	
	@Override
	public void Collision(MonJeu mj, int x, int y) {
		if(!clef.isPasTrouve() && this.x==x && this.y==y)
			this.action(mj);
	}

	@Override
	public int getId() {
		return Bibliotheque.PORTE;
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
		return true;
	}

}
