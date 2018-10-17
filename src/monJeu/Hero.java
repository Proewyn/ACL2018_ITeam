package monJeu;

import moteurJeu.Commande;

/**
 * la classe correspondant au Personnage
 */
public class Hero implements Personnage {

	private int vision; 
	

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
		vision = 10;
	}
	public Hero(int x , int y){
		this.x = x;
		this.y = y;
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public int getVision() {
		return vision;
	}
	public void setVision(int vision) {
		this.vision = vision;
	}

}
