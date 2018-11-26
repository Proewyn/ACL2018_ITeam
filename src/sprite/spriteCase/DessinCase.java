/**
 * 
 */
package sprite.spriteCase;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import monJeu.Bibliotheque;
import personnage.Hero;
import plateau.Case;

/**
 * @author damien
 *
 */
public abstract class DessinCase {

	private Case c;
	protected Image dessinCase;
	
	/**
	 * 
	 */
	public DessinCase(Case c, Image dessinCase) {
		this.c = c;
		this.dessinCase = dessinCase;

	}
	

	
	public void dessiner(int x, int y,Graphics2D crayon) {
		crayon.setColor(Color.green);
		crayon.fillRect(x * Bibliotheque.TAILLE_CASE, y * Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE);
		
	}

	


	public void dessinerVision(Hero hero, int i, int j, Graphics2D crayon) {
		
		if (Math.sqrt((hero.getX()-i)*(hero.getX()-i)+(hero.getY()-j)*(hero.getY()-j)) <= hero.getVision() ){
		
			this.dessiner(i-hero.getXVue(),j-hero.getYVue(),crayon);
		}
	}



	

}
