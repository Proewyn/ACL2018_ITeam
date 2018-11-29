package sprite;

import java.awt.Graphics2D;
import java.util.List;

import monJeu.Bibliotheque;

import personnage.Hero;


import sprite.spritePersonnage.DessinMonstre;

/**
 * @author damien
 *
 */
public class LesDessinsMonstres{

	private List<DessinMonstre> dessinsMonstres;
	
	/**
	 * Constructeur pour dessiner les monstres
	 * @param dessinsMonstres dessin pour les monstres
	 */
	public LesDessinsMonstres(List<DessinMonstre> dessinsMonstres) {
		this.dessinsMonstres = dessinsMonstres;
	}
	
	/**
	 * Dessine les monstres dans toute la portee du hero
	 * @param hero avec sa portee
	 * @param crayon qui dessine
	 */
	public void dessinerPortee(Hero hero, Graphics2D crayon) {
		for(DessinMonstre dm : this.dessinsMonstres) {
			if (dm.getMonstre().getX() >= hero.getXVue() && dm.getMonstre().getX() < Bibliotheque.VUE_LARGEUR + hero.getXVue()) {
				if (dm.getMonstre().getY() >= hero.getYVue() && dm.getMonstre().getY() < Bibliotheque.VUE_HAUTEUR + hero.getYVue()) {
					dm.dessiner(hero, crayon);
				}
			}
		}
	}

	/**
	 * Dessine les monstres dans toute la portee du hero
	 * @param hero avec sa portee et vision
	 * @param crayon qui dessine
	 */
	public void dessinerPorteeVision(Hero hero, Graphics2D crayon) {
		for(DessinMonstre dm : this.dessinsMonstres) {
			if (dm.getMonstre().getX() >= hero.getXVue() && dm.getMonstre().getX() < Bibliotheque.VUE_LARGEUR + hero.getXVue()) {
				if (dm.getMonstre().getY() >= hero.getYVue() && dm.getMonstre().getY() < Bibliotheque.VUE_HAUTEUR + hero.getYVue()) {
					dm.dessinerVision(hero, crayon);
				}
			}
		}
	}
	
}
