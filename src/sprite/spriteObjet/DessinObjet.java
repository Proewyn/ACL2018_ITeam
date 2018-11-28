package sprite.spriteObjet;

import java.awt.Graphics2D;
import java.awt.Image;
import monJeu.Bibliotheque;
import objet.Objet;
import personnage.Hero;

/**
 * @author damien
 *
 */
public abstract class DessinObjet {
	protected Objet objet;
	protected Image dessinObjet;

	/**
	 * Constructeur pour dessiner un objet
	 * @param objet a dessiner
	 * @param dessin pour l'objet
	 */
	public DessinObjet(Objet objet, Image dessin) {
		this.objet = objet;
		this.dessinObjet = dessin;
	}
	
	/**
	 * Dessiner l'objet
	 * @param h pour sa portee
	 * @param crayon pour dessiner
	 */
	public void dessiner(Hero h , Graphics2D crayon) {
		if(objet.isPasTrouve())
			crayon.drawImage(this.dessinObjet, (this.objet.getX()- h.getXVue())
					* Bibliotheque.TAILLE_CASE, (this.objet.getY() - h.getYVue())
					* Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE,
					Bibliotheque.TAILLE_CASE, null);
	}
	
	/**
	 * Dessiner l'objet
	 * @param h pour sa portee et vision
	 * @param crayon pour dessiner
	 */
	public void dessinerVision(Hero hero, Graphics2D crayon) {
		if (Math.sqrt((hero.getX()-objet.getX())*(hero.getX()-objet.getX())+(hero.getY()-objet.getY())*(hero.getY()-objet.getY())) <= hero.getVision() ){
			this.dessiner(hero,crayon);
		}
	}

	/**
	 * Dessiner l'objet
	 * @param h pour sa portee
	 * @param crayon pour dessiner
	 */
	public void dessinerPortee(Hero hero, Graphics2D crayon) {
		this.dessiner(hero,crayon);
	}
	
	public Objet getObjet() {
		return this.objet;
	}
	
}
