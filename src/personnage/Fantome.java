package personnage;

import monJeu.Bibliotheque;

/**
 * @author damien
 *
 */
public class Fantome extends Monstre {

	/**
	 * Constructeur par defaut
	 */
	public Fantome() {
		super();
	}

	/**
	 * Constructeur avec position
	 * @param x position en X
	 * @param y psoition en Y
	 */
	public Fantome(int x, int y) {
		super(x, y);
	}

	@Override
	public int getId() {
		return Bibliotheque.FANTOME;
	}

}
