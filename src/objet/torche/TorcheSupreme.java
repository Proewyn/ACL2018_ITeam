package objet.torche;

import monJeu.MonJeu;

public class TorcheSupreme extends Torche {

	public TorcheSupreme(int x, int y) {
		super(x, y);
	}
	public void action(MonJeu mj) {
		mj.setVoirPlateauEntier(true);
		pasTrouve=false;
	}


}
