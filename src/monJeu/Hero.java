package monJeu;

/**
 * la classe correspondant au Personnage
 */
public class Hero { 
	
	/**
	 * position en X et y
	 */
	private int x;
	private int y;

	/**
	 * constructeur vide
	 */
	public Hero() {
		this.x = 0;
		this.y = 0;
	}

	/**
	 * deplacer le personnage dans une direction
	 * 
	 * @param m
	 *            la chaine permettant de deplacer le personnage (N,S, E ou O)
	 */
	public void deplacer(int direction) {
		switch (direction){
			case MonJeu.HAUT:
				break;
			case MonJeu.DROITE:
				break;
			case MonJeu.BAS:
				break;
			case MonJeu.GAUCHE:
				break;
		}
	}

	public String toString() {
		return ("(" + this.x+","+this.y+")");
	}

}
