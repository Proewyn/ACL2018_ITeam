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
	public DessinObjet(Objet objet, File urlImage) {
		this.objet = objet;
		//this.dessinObjet = null;
		
		try {
			this.dessinObjet = ImageIO.read(urlImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void dessiner(Graphics2D crayon) {
		if(objet.isPasTrouve())
			crayon.drawImage(this.dessinObjet, this.objet.getX()
					* Bibliotheque.TAILLE_CASE, this.objet.getY()
					* Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE,
					Bibliotheque.TAILLE_CASE, null);

	}
	
}
