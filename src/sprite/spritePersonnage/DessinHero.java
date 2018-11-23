/**
 * 
 */
package sprite.spritePersonnage;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import monJeu.Bibliotheque;
import personnage.Hero;

/**
 * @author damien
 *
 */
public class DessinHero { 
	private Hero hero;
	private Image imageHero;

	/**
	 * 
	 */
	public DessinHero(Hero hero, File urlImage) {
		
		this.hero = hero ;
		this.imageHero = null;
		
		try {
			this.imageHero= ImageIO.read(urlImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	public void dessiner(Graphics2D crayon) {
		crayon.drawImage(
				this.imageHero, 
				this.hero.getX() * Bibliotheque.TAILLE_CASE,
				this.hero.getY() * Bibliotheque.TAILLE_CASE, 
				Bibliotheque.TAILLE_CASE, 
				Bibliotheque.TAILLE_CASE,null);
	}
	

	
}
