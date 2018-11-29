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
	 * Constructeur pour dessiner les objets
	 * @param dessinObjet dessin pour les objets
	 */
	public LesDessinsObjets(List<DessinObjet> dessinObjet) {
		this.dessinObjet = dessinObjet;
	}

	/**
	 * Dessine les objets dans toute la portee du hero
	 * @param hero avec sa portee
	 * @param crayon qui dessine
	 */
	public void dessinerPortee(Hero hero, Graphics2D crayon) {
		for(DessinObjet dObj : this.dessinObjet) {
			if (dObj.getObjet().getX() >= hero.getXVue() && dObj.getObjet().getX() < Bibliotheque.VUE_LARGEUR + hero.getXVue()) {
				if (dObj.getObjet().getY() >= hero.getYVue() && dObj.getObjet().getY() < Bibliotheque.VUE_HAUTEUR + hero.getYVue()) {
					dObj.dessiner(hero, crayon);
				}
			}
		}
	}

	/**
	 * Dessine les objets dans toute la portee du hero
	 * @param hero avec sa portee et vision
	 * @param crayon qui dessine
	 */
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
