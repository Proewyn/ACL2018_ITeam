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
	public DessinHero(Hero hero, Image dessinHero) {
		
		this.hero = hero ;
		this.imageHero = dessinHero;
		
	}

	
	public void dessiner(Graphics2D crayon) {
		
		crayon.drawImage(
				this.imageHero, 
				(this.hero.getX()-hero.getXVue()) * Bibliotheque.TAILLE_CASE,
				(this.hero.getY()- hero.getYVue()) * Bibliotheque.TAILLE_CASE, 
				Bibliotheque.TAILLE_CASE, 
				Bibliotheque.TAILLE_CASE,null);
	}
	

	
}
