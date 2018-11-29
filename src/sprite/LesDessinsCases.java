package sprite;

import java.awt.Graphics2D;
import monJeu.Bibliotheque;

import personnage.Hero;
import sprite.spriteCase.DessinCase;

/**
 * @author damien
 *
 */
public class LesDessinsCases {
	
	private DessinCase[][] dc;

	/**
	 * Constructeur pour dessiner les cases
	 * @param dec dessin pour les cases
	 */
	public LesDessinsCases(DessinCase[][] dec) {
		this.dc = new DessinCase[dec.length][dec[0].length];
		for(int i = 0 ;i<dec.length;i++) {
			for(int j = 0 ;j<dec[0].length;j++) {
				this.dc[i][j] = dec[i][j];
			}
		}
	}

	/**
	 * Dessine les cases dans toute la portee du hero
	 * @param hero avec sa portee
	 * @param crayon qui dessine
	 */
	public void dessinerPortee(Hero hero, Graphics2D crayon) {
		for (int i = hero.getXVue() ; i < Bibliotheque.VUE_LARGEUR + hero.getXVue() ; i++) {
			for (int j = hero.getYVue() ; j < Bibliotheque.VUE_HAUTEUR+ hero.getYVue() ; j++) {
				this.dc[i][j].dessiner(i-hero.getXVue(),j-hero.getYVue(),crayon);
			}
		}
	}

	/**
	 * Dessine les cases dans toute la portee du hero
	 * @param hero avec sa portee et vision
	 * @param crayon qui dessine
	 */
	public void dessinerPorteeVision(Hero hero, Graphics2D crayon) {
		for (int i = hero.getXVue() ; i < Bibliotheque.VUE_LARGEUR + hero.getXVue() ; i++) {
			for (int j = hero.getYVue() ; j < Bibliotheque.VUE_HAUTEUR+ hero.getYVue() ; j++) {
				this.dc[i][j].dessinerVision(hero,i,j,crayon);
			}
		}
	}

}
