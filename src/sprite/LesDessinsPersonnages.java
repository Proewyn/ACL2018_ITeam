package sprite;

import java.awt.Graphics2D;

import personnage.Hero;

import sprite.spritePersonnage.DessinHero;

/**
 * @author damien
 *
 */
public class LesDessinsPersonnages {
	
	private LesDessinsMonstres dessinsMonstres;
	private DessinHero dessinHero;

	/**
	 * Constructeur pour dessiner les personnages
	 * @param dessinHero dessin pour les heros
	 * @param dessinsMonstres dessin pour les monstres
	 */
	public LesDessinsPersonnages(DessinHero dessinHero, LesDessinsMonstres dessinsMonstres) {
		this.dessinHero = dessinHero;
		this.dessinsMonstres = dessinsMonstres;
	}

	/**
	 * Dessine les personnages dans toute la portee du hero
	 * @param hero avec sa portee
	 * @param crayon qui dessine
	 */
	public void dessinerPortee(Hero hero, Graphics2D crayon) {
		this.dessinHero.dessiner(crayon);
		this.dessinsMonstres.dessinerPortee(hero,crayon);
	}

	/**
	 * Dessine les personnages dans toute la portee du hero
	 * @param hero avec sa portee et vision
	 * @param crayon qui dessine
	 */
	public void dessinerPorteeVision(Hero hero, Graphics2D crayon) {
		this.dessinHero.dessiner(crayon);
		this.dessinsMonstres.dessinerPorteeVision(hero,crayon);
	}

}
