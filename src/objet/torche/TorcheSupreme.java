package objet.torche;

import monJeu.Bibliotheque;
import monJeu.MonJeu;

public class TorcheSupreme extends Torche {

	public TorcheSupreme(int x, int y) {
		super(x, y);
	}
	public void action(MonJeu mj) {
		mj.setVoirPlateauEntier(true);
		pasTrouve=false;
	}

	@Override
	public int getId() {
		return Bibliotheque.TORCHESUPPREME;
	}

}
