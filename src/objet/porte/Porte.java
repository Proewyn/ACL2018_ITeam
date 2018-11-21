package objet.porte;

import monJeu.MonJeu;
import objet.Objet;

public abstract class Porte implements Objet {

	protected int x;
	protected int y;
	@Override
	public void Collision(MonJeu mj, int x, int y) {
		// TODO Auto-generated method stub

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
