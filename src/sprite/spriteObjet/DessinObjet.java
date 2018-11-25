/**
 * 
 */
package sprite.spriteObjet;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
	 * 
	 */
	public DessinObjet(Objet objet, Image dessin) {
		this.objet = objet;
		this.dessinObjet = dessin;
		
	}
	
	public void dessiner(Graphics2D crayon) {
		if(objet.isPasTrouve())
			crayon.drawImage(this.dessinObjet, this.objet.getX()
					* Bibliotheque.TAILLE_CASE, this.objet.getY()
					* Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE,
					Bibliotheque.TAILLE_CASE, null);

	}
	
	public void dessinerVision(Hero hero, Graphics2D crayon) {
		
		if (Math.sqrt((hero.getX()-objet.getX())*(hero.getX()-objet.getX())+(hero.getY()-objet.getY())*(hero.getY()-objet.getY())) <= hero.getVision() ){
			this.dessiner(crayon);
		}
	}
	
	
	
}
