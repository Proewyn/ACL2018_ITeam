/**
 * 
 */
package sprite.spriteCase;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import personnage.Hero;

import attaque.aDistance.AttaqueADistance;

import monJeu.Bibliotheque;

/**
 * @author levy54u
 *
 */
public class DessinAttaque {


	protected Image dessinAttaque;
	/**
	 * 
	 */
	public DessinAttaque(Image dessinAttaque) {
		
		this.dessinAttaque = dessinAttaque;
		
	}
	

	
	public void dessiner(Hero hero, Graphics2D crayon,AttaqueADistance attaque) {
		crayon.drawImage(this.dessinAttaque, (attaque.getX() - hero.getXVue())
				* Bibliotheque.TAILLE_CASE, (attaque.getY() - hero.getYVue())
				* Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE,
				Bibliotheque.TAILLE_CASE, null);

	}
	
	public void dessinerVision(Hero hero, Graphics2D crayon,AttaqueADistance attaque) {
		if (Math.sqrt((hero.getX()-attaque.getX())*(hero.getX()-attaque.getX())+(hero.getY()-attaque.getY())*(hero.getY()-attaque.getY())) <= hero.getVision() ){
			this.dessiner(hero,crayon,attaque);
		}
		
	}



	public void dessinerPorteeVision(Hero hero, Graphics2D crayon, AttaqueADistance a) {
		
		if (a.getX() >= hero.getXVue() && a.getX() < Bibliotheque.VUE_LARGEUR + hero.getXVue()) {
			if (a.getY() >= hero.getYVue() && a.getY() < Bibliotheque.VUE_HAUTEUR + hero.getYVue()) {
				this.dessinerVision(hero , crayon , a);
			}
		}
		
	}



	public void dessinerPortee(Hero hero, Graphics2D crayon, AttaqueADistance a) {
		if (a.getX() >= hero.getXVue() && a.getX() < Bibliotheque.VUE_LARGEUR + hero.getXVue()) {
			if (a.getY() >= hero.getYVue() && a.getY() < Bibliotheque.VUE_HAUTEUR + hero.getYVue()) {
				this.dessiner(hero , crayon , a);
			}
		}
		
	}


}
