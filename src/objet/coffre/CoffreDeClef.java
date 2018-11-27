package objet.coffre;

import monJeu.Bibliotheque;
import monJeu.MonJeu;

public class CoffreDeClef extends Coffre {

	public CoffreDeClef(int x, int y) {
		super(x, y);
	}

	@Override
	public void action(MonJeu mj) {
		pasTrouve=false;

	}
	
	@Override
	public int getId() {
		return Bibliotheque.COFFRECLE;
	}

}