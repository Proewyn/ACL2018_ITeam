/**
 * 
 */
package personnage;

import monJeu.Bibliotheque;

/**
 * @author damien
 *
 */
public class Fantome extends Monstre {

	/**
	 * 
	 */
	public Fantome() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param x
	 * @param y
	 */
	public Fantome(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see personnage.Personnage#getId()
	 */
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return Bibliotheque.FANTOME;
	}

}
