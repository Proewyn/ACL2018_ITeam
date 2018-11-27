/**
 * 
 */
package sprite;

import java.awt.Graphics2D;
import java.util.List;

import monJeu.Bibliotheque;

import personnage.Hero;

import sprite.spriteObjet.DessinObjet;

/**
 * @author damien
 *
 */
public class LesDessinsObjets {
	private List<DessinObjet> dessinObjet;

	/**
	 * 
	 */
	public LesDessinsObjets(List<DessinObjet> dessinObjet) {
		this.dessinObjet = dessinObjet;
	}
	
	public void dessiner(Graphics2D crayon) {
		for(DessinObjet dObj : this.dessinObjet) {
			dObj.dessiner(crayon);
		}
		
	}

	public void dessinerVision(Hero hero, Graphics2D crayon) {
		for(DessinObjet dObj : this.dessinObjet) {
			dObj.dessinerVision(hero, crayon);
		}
		
	}

	public void dessinerPortee(Hero hero, Graphics2D crayon) {
		for(DessinObjet dObj : this.dessinObjet) {
			if (dObj.getObjet().getX() >= hero.getXVue() && dObj.getObjet().getX() < Bibliotheque.VUE_LARGEUR + hero.getXVue()) {
				if (dObj.getObjet().getY() >= hero.getYVue() && dObj.getObjet().getY() < Bibliotheque.VUE_HAUTEUR + hero.getYVue()) {
					dObj.dessiner(hero, crayon);
				}
			}
		}
	}

	public void dessinerPorteeVision(Hero hero, Graphics2D crayon) {
		
		for(DessinObjet dObj : this.dessinObjet) {
			if (dObj.getObjet().getX() >= hero.getXVue() && dObj.getObjet().getX() < Bibliotheque.VUE_LARGEUR + hero.getXVue()) {
				if (dObj.getObjet().getY() >= hero.getYVue() && dObj.getObjet().getY() < Bibliotheque.VUE_HAUTEUR + hero.getYVue()) {
					dObj.dessinerVision(hero, crayon);
				}
			}
		}
	}
	
	

}
