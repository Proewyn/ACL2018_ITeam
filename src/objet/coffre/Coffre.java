package objet.coffre;

import monJeu.Bibliotheque;
import monJeu.MonJeu;
import objet.Objet;

public abstract class Coffre implements Objet {
	protected int x;
	protected int y;
	protected int id;
	protected boolean pasTrouve;
	
	public Coffre(int x,int y) {
		this.x=x;
		this.y=y;
		this.pasTrouve=true;
		id = Bibliotheque.COFFRE;
	}

	@Override
	public void Collision(MonJeu mj, int x, int y) {
		if(pasTrouve && this.x==x && this.y==y)
			this.action(mj);

	}

	@Override
	public void action(MonJeu mj) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isPasTrouve() {
		// TODO Auto-generated method stub
		return false;
	}

}
