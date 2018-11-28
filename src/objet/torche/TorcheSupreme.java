package objet.torche;

import monJeu.Bibliotheque;
import monJeu.MonJeu;

public class TorcheSupreme extends Torche {

	/**
	 * Cree une torche qui revele le plateau en entier
	 * @param x position en X
	 * @param y position en Y
	 */
	public TorcheSupreme(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void action(MonJeu mj) {
		mj.setVoirPlateauEntier(true);
		pasTrouve=false;
	}

	@Override
	public int getId() {
		return Bibliotheque.TORCHESUPPREME;
	}

}
