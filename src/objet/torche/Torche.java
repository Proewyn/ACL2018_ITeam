package objet.torche;

import monJeu.Bibliotheque;
import monJeu.MonJeu;
import objet.Objet;

public abstract class Torche implements Objet {
	protected int x;
	protected int y;
	protected int id;
	protected boolean pasTrouve;
	public Torche(int x,int y) {
		this.x=x;
		this.y=y;
		this.pasTrouve=true;
		id = Bibliotheque.TORCHE;
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
		return id;
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
