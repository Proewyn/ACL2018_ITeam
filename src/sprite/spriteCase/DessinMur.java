/**
 * 
 */
package sprite.spriteCase;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;

import monJeu.Bibliotheque;
import plateau.Case;

/**
 * @author damien
 *
 */
public class DessinMur extends DessinCase {

	/**
	 * @param c
	 * @param dessinMur
	 */
	public DessinMur(Case c, Image dessinMur) {
		super(c, dessinMur);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void dessiner(int x, int y,Graphics2D crayon) {
		crayon.drawImage(this.dessinCase,
				x * Bibliotheque.TAILLE_CASE, 
				y * Bibliotheque.TAILLE_CASE, 
				Bibliotheque.TAILLE_CASE, 
				Bibliotheque.TAILLE_CASE,null);

	}

}