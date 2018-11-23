package objet.porte;

import monJeu.MonJeu;
import objet.coffre.CoffreDeClef;

public class TrapeFinJeu extends Porte {

	public TrapeFinJeu(int x, int y, CoffreDeClef c) {
		super(x, y, c);
	}

	@Override
	public void action(MonJeu mj) {
		mj.setGagne(true);
	}

}
