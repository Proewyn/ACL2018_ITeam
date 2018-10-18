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
	private int x;
	private int y;
	
	/**
	 * constructeur vide
	 */
	public Hero() {
		this.x = 1;
		this.y = 1;
		vision = 9;
	}
	public Hero(int x , int y){
		this.x = x;
		this.y = y;
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

	
	private void setX(int x){
		this.x = x;
	}
	private void setY(int y){
		this.y = y;
	}
	
	public void deplacer(int x2, int y2) {
		this.setX(x2);
		this.setY(y2);
		
	}
		
	public int getVision() {
		return vision;
	}
	public void setVision(int vision) {
		this.vision = vision;
	}

}
