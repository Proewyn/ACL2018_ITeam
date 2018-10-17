/**
 * 
 */
package monJeu;

import moteurJeu.Commande;

/**
 * @author levy54u
 *
 */
public abstract class Monstre implements Personnage {
	private int x;
	private int y;
	
	public Monstre(int x, int y){
		this.x = x;
		this.y = y;
	}


	@Override
	public void deplacer(Commande c) {


	}

	
	@Override
	public int getX() {
		return this.x;
	}

		@Override
	public int getY() {
		return this.y;
	}

}
