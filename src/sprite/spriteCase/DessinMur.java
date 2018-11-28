package sprite.spriteCase;

import java.awt.Graphics2D;
import java.awt.Image;
import monJeu.Bibliotheque;
import plateau.Case;

/**
 * @author damien
 *
 */
public class DessinMur extends DessinCase {

	/**
	 * Constructeur pour dessiner un mur
	 * @param c a dessiner
	 * @param dessinMur pour le mur
	 */
	public DessinMur(Case c, Image dessinMur) {
		super(c, dessinMur);
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
