package monJeu;

import moteurJeu.Commande;

/**
 * la classe correspondant au Personnage
 */
public class Hero {

	
	/**
	 * position en X et y
	 */
	public int x;
	public int y;

	
	/**
	 * constructeur vide
	 */
	public Hero() {
		this.x = 1;
		this.y = 1;
		
	}

	/**
	 * deplacer le personnage dans une direction
	 * 
	 * @param m
	 *            la chaine permettant de deplacer le personnage (N,S, E ou O)
	 */
	public void deplacer(Commande c) {
		
		if (c.gauche)
		{
			this.x--;
			if (this.x < 0)
				this.x = 0;
		}

		if (c.droite)
		{
			this.x++;
			
		}
		if(c.haut){

			this.y--;
			if(this.y<0)
				this.y = 0;
		}
		if(c.bas){
			this.y++;
			
		}
	}

	public String toString() {
		return ("(" + this.x+","+this.y+")");
	}

	public int getx() {
		// TODO Auto-generated method stub
		return x;
	}

	public int gety() {
		// TODO Auto-generated method stub
		return y;
	}

}
