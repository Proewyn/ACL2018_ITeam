package personnage;

import monJeu.Bibliotheque;

/**
 * la classe correspondant au Personnage
 */
public class Hero implements Personnage {

	private int x;
	private int y;
	private int x_vue;
	private int y_vue;
	private int hp;
	private int vision; 
	
	/**
	 * constructeur vide
	 */
	public Hero() {
		this.x = 1;
		this.y = 1;
		this.x_vue = 0;
		this.y_vue = 0;
		this.hp = 10;
		this.vision = 5;
		
	}
	
	public Hero(int x , int y) {
		this.x = 0;
		this.y = 0;
		this.x_vue = 0;
		this.y_vue = 0;
		this.deplacer(x, y);
		this.hp = 10;
		this.vision = 5;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	private void setX(int x) {
		this.x = x;
	}
	
	private void setY(int y) {
		this.y = y;
	}
	
	public int getXVue() {
		return x_vue;
	}

	public int getYVue() {
		return y_vue;
	}
	
	public int getHp() {
		return hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
		
	public int getVision() {
		return vision;
	}
	
	public void setVision(int vision) {
		this.vision = vision;
	}

	@Override
	public int getId() {
		return Bibliotheque.JOUEUR;
	}
	
	public void deplacer(int x2, int y2) {
		this.setX(x2);
		this.setY(y2);
		deplacerVue(x2, y2);
	}
	
	public void deplacerVue(int x2, int y2) {
		//Vers la gauche
		while 	((x - x_vue > (Bibliotheque.VUE_LARGEUR/2) && !(x_vue+Bibliotheque.VUE_LARGEUR == Bibliotheque.TAILLE_TABLEAUX)) ||
				(x < x_vue + Bibliotheque.VUE_LARGEUR/2 && !(x_vue<=0)) ||
				(y - y_vue > Bibliotheque.VUE_HAUTEUR/2 &&  y_vue+Bibliotheque.VUE_HAUTEUR < Bibliotheque.TAILLE_TABLEAUY) ||
				(y < y_vue +Bibliotheque.VUE_HAUTEUR/2 && !(y_vue<=0))) {
		if (x - x_vue < Bibliotheque.VUE_LARGEUR/2) {
			x_vue--;
			if (x_vue < 0) {
				x_vue = 0;
			}
		}
		//Vers le bas
		if (y - y_vue < Bibliotheque.VUE_HAUTEUR/2) {
			y_vue--;
			if (y_vue < 0) {
				y_vue = 0;
			}
		}
		//Vers la droite
		if (x_vue + Bibliotheque.VUE_LARGEUR - x <= Bibliotheque.VUE_LARGEUR/2) {
			x_vue++;
			if (x_vue + Bibliotheque.VUE_LARGEUR >= Bibliotheque.TAILLE_TABLEAUX) {
				x_vue = Bibliotheque.TAILLE_TABLEAUX - Bibliotheque.VUE_LARGEUR;
			}
		}
		//Vers le haut
		if (y_vue + Bibliotheque.VUE_HAUTEUR - y <= Bibliotheque.VUE_HAUTEUR/2) {
			y_vue++;
			if (y_vue + Bibliotheque.VUE_HAUTEUR >= Bibliotheque.TAILLE_TABLEAUY) {
				y_vue = Bibliotheque.TAILLE_TABLEAUY - Bibliotheque.VUE_HAUTEUR;
			}
		}
		}
	}
	
	public String toString() {
		return ("(" + this.x+","+this.y+")");
	}

}
