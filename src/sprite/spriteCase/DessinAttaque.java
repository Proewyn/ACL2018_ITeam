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

	private AttaqueADistance attaque;
	protected Image dessinAttaque;
	/**
	 * 
	 */
	public DessinAttaque(AttaqueADistance attaque,Image dessinAttaque) {
		this.attaque = attaque;
		this.dessinAttaque = dessinAttaque;
		
	}
	

	
	public void dessiner(Hero hero, Graphics2D crayon) {

			crayon.drawImage(
					this.dessinAttaque, 
					(this.attaque.getX() - hero.getXVue()) * Bibliotheque.TAILLE_CASE,
					(this.attaque.getY() - hero.getYVue())* Bibliotheque.TAILLE_CASE, 
					Bibliotheque.TAILLE_CASE, 
					Bibliotheque.TAILLE_CASE,null);
			
	}
	public void dessinerVision(Hero hero, Graphics2D crayon) {
		if (Math.sqrt((hero.getX()-attaque.getX())*(hero.getX()-attaque.getX())+(hero.getY()-attaque.getY())*(hero.getY()-attaque.getY())) <= hero.getVision() ){
			
			this.dessiner(hero,crayon);
		}
		
	}


}
