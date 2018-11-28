package personnage;

import monJeu.Bibliotheque;

/**
 * @author levy54u
 *
 */
public class Zombi extends Monstre {

	/**
	 * Constructeur par defaut
	 */
	public Zombi() {
		super();
	}
	
	/**
	 * Constructeur avec une position
	 * @param x position en X
	 * @param y position en Y
	 */
	public Zombi(int x, int y) {
		super(x, y);
	}

	@Override
	public int getId() {
		return Bibliotheque.ZOMBI;
	}

}
