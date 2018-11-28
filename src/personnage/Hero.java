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
	 * constructeur par defaut
	 */
	public Hero() {
		this.x = 1;
		this.y = 1;
		this.x_vue = 0;
		this.y_vue = 0;
		this.hp = Bibliotheque.POINTDEVIEBASEHERO;
		this.vision = 5;
		
	}
	
	/**
	 * Cree un hero avec une certaine position
	 * @param x position en X
	 * @param y position en Y
	 */
	public Hero(int x , int y) {
		this.x = 0;
		this.y = 0;
		this.x_vue = 0;
		this.y_vue = 0;
		this.deplacer(x, y);
		this.hp = Bibliotheque.POINTDEVIEBASEHERO;
		this.vision = 5;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	/**
	 * Place le hero sur une colonne donnee
	 * @param x position en X
	 */
	private void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Place le hero sur une ligne donnee
	 * @param y position en Y
	 */
	private void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Recupere la valeur de x_vue
	 * @return la valeur de x_vue
	 */
	public int getXVue() {
		return x_vue;
	}

	/**
	 * Recupere la valeur de y_vue
	 * @return la valeur de y_vue
	 */
	public int getYVue() {
		return y_vue;
	}
	
	@Override
	public int getHp() {
		return hp;
	}
	
	@Override
	public void setHp(int hp) {
		this.hp = hp;
	}
		
	/**
	 * Recupere la valeur de vision
	 * @return la valeur de vision
	 */
	public int getVision() {
		return vision;
	}
	
	/**
	 * Donne a la vision une valeur
	 * @param vision nouvelle valeur de vision
	 */
	public void setVision(int vision) {
		this.vision = vision;
	}

	@Override
	public int getId() {
		return Bibliotheque.JOUEUR;
	}
	
	@Override
	public void deplacer(int x2, int y2) {
		this.setX(x2);
		this.setY(y2);
		deplacerVue(x2, y2);
	}
	
	/**
	 * Deplace la vision du personnage
	 * @param x2 X ou mettre la vision
	 * @param y2 Y ou mettre la vision
	 */
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
	
	@Override
	public String toString() {
		return ("(" + this.x+","+this.y+")");
	}

}
