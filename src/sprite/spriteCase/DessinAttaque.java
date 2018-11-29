package sprite.spriteCase;

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
	 * Constructeur pour dessiner les attaques
	 * @param dessinAttaque pour les attaques
	 */
	public DessinAttaque(Image dessinAttaque) {
		this.dessinAttaque = dessinAttaque;
	}

	/**
	 * Dessine l'attaque
	 * @param hero pour sa portee
	 * @param crayon pour dessiner
	 * @param attaque pour la position de l'attaque a dessiner
	 */
	public void dessiner(Hero hero, Graphics2D crayon,AttaqueADistance attaque) {
		crayon.drawImage(this.dessinAttaque, (attaque.getX() - hero.getXVue())
				* Bibliotheque.TAILLE_CASE, (attaque.getY() - hero.getYVue())
				* Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE,
				Bibliotheque.TAILLE_CASE, null);
	}

	/**
	 * Dessine l'attaque
	 * @param hero pour sa vision
	 * @param crayon pour dessiner
	 * @param attaque pour la position de l'attaque a dessiner
	 */
	public void dessinerVision(Hero hero, Graphics2D crayon,AttaqueADistance attaque) {
		if (Math.sqrt((hero.getX()-attaque.getX())*(hero.getX()-attaque.getX())+(hero.getY()-attaque.getY())*(hero.getY()-attaque.getY())) <= hero.getVision() ){
			this.dessiner(hero,crayon,attaque);
		}
	}

	/**
	 * Dessiner l'attaque
	 * @param hero pour sa portee
	 * @param crayon pour dessiner
	 * @param a pour l'attaque a dessiner
	 */
	public void dessinerPortee(Hero hero, Graphics2D crayon, AttaqueADistance a) {
		if (a.getX() >= hero.getXVue() && a.getX() < Bibliotheque.VUE_LARGEUR + hero.getXVue()) {
			if (a.getY() >= hero.getYVue() && a.getY() < Bibliotheque.VUE_HAUTEUR + hero.getYVue()) {
				this.dessiner(hero , crayon , a);
			}
		}
	}

	/**
	 * Dessine l'attaque
	 * @param hero pour sa portee et vision
	 * @param crayon pour dessiner
	 * @param a pour l'attaque a dessiner
	 */
	public void dessinerPorteeVision(Hero hero, Graphics2D crayon, AttaqueADistance a) {
		if (a.getX() >= hero.getXVue() && a.getX() < Bibliotheque.VUE_LARGEUR + hero.getXVue()) {
			if (a.getY() >= hero.getYVue() && a.getY() < Bibliotheque.VUE_HAUTEUR + hero.getYVue()) {
				this.dessinerVision(hero , crayon , a);
			}
		}
	}

}
