package sprite.spriteCase;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import monJeu.Bibliotheque;
import personnage.Hero;
import plateau.Case;

/**
 * @author damien
 *
 */
public abstract class DessinCase {

	protected Image dessinCase;
	
	/**
	 * Constructeur pour dessiner une case
	 * @param c a dessiner
	 * @param dessinCase pour la case
	 */
	public DessinCase(Case c, Image dessinCase) {
		this.dessinCase = dessinCase;
	}
	
	/**
	 * Dessiner la case
	 * @param x position en X
	 * @param y position en Y
	 * @param crayon pour dessiner
	 */
	public void dessiner(int x, int y,Graphics2D crayon) {
		crayon.setColor(Color.green);
		crayon.fillRect(x * Bibliotheque.TAILLE_CASE, y * Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE);
	}

	/**
	 * Dessiner la case
	 * @param hero pour sa portee et vision
	 * @param i position en X
	 * @param j position en Y
	 * @param crayon pour dessiner
	 */
	public void dessinerVision(Hero hero, int i, int j, Graphics2D crayon) {
		if (Math.sqrt((hero.getX()-i)*(hero.getX()-i)+(hero.getY()-j)*(hero.getY()-j)) <= hero.getVision() ){
			this.dessiner(i-hero.getXVue(),j-hero.getYVue(),crayon);
		}
	}

}
