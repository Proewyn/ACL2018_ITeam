/**
 * 
 */
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
	 * 
	 */
	public LesDessinsMonstres(List<DessinMonstre> dessinsMonstres) {
		this.dessinsMonstres = dessinsMonstres;
	}
	
	public void dessiner(Graphics2D crayon) {
		
		for(DessinMonstre dm : this.dessinsMonstres) {
			
			dm.dessiner(crayon);
		}
		
	}

	public void dessinerVision(Hero hero,Graphics2D crayon) {
		
		for(DessinMonstre dm : this.dessinsMonstres) {
			
			dm.dessinerVision(hero,crayon);
		}
	}

	public void dessinerPortee(Hero hero, Graphics2D crayon) {
		for(DessinMonstre dm : this.dessinsMonstres) {
			if (dm.getMonstre().getX() >= hero.getXVue() && dm.getMonstre().getX() < Bibliotheque.VUE_LARGEUR + hero.getXVue()) {
				if (dm.getMonstre().getY() >= hero.getYVue() && dm.getMonstre().getY() < Bibliotheque.VUE_HAUTEUR + hero.getYVue()) {
					dm.dessiner(hero, crayon);
				}
			}
		}
	}

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
