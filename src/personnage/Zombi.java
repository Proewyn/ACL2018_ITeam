/**
 * 
 */
package personnage;

import monJeu.Bibliotheque;

/**
 * @author levy54u
 *
 */
public class Zombi extends Monstre {

	/**
	 * @param x
	 * @param y
	 */
	public Zombi(int x, int y) {
		super(x, y);
	}

	public Zombi() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return Bibliotheque.ZOMBI;
	}

}