package sprite.spritePersonnage;

import java.awt.Graphics2D;
import java.awt.Image;
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
	 * Constructeur pour dessiner le hero
	 * @param hero a dessiner
	 * @param dessinHero pour le hero
	 */
	public DessinHero(Hero hero, Image dessinHero) {
		this.hero = hero ;
		this.imageHero = dessinHero;
	}

	/**
	 * Dessine le hero
	 * @param crayon pour dessiner
	 */
	public void dessiner(Graphics2D crayon) {
		crayon.drawImage(
				this.imageHero, 
				(this.hero.getX()-hero.getXVue()) * Bibliotheque.TAILLE_CASE,
				(this.hero.getY()- hero.getYVue()) * Bibliotheque.TAILLE_CASE, 
				Bibliotheque.TAILLE_CASE, 
				Bibliotheque.TAILLE_CASE,null);
	}
	
}
