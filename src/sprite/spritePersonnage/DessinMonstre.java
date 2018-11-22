/**
 * 
 */
package sprite.spritePersonnage;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import monJeu.Bibliotheque;
import personnage.Monstre;

/**
 * @author damien
 *
 */
public abstract class DessinMonstre {
	
	protected Monstre m;
	protected Image imageMonstre;

	/**
	 * 
	 */
	public DessinMonstre(Monstre m ,File urlImage) {
		this.m = m;
		this.imageMonstre = null;
		try {
			this.imageMonstre = ImageIO.read(urlImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	public void dessiner(Graphics2D crayon) {
		crayon.drawImage(
				this.imageMonstre, 
				this.m.getX() * Bibliotheque.TAILLE_CASE,
				this.m.getY() * Bibliotheque.TAILLE_CASE, 
				Bibliotheque.TAILLE_CASE, 
				Bibliotheque.TAILLE_CASE,null);
	
		
		
	}

}
