package sprite.spriteCase;

import java.awt.Graphics2D;
import java.awt.Image;
import monJeu.Bibliotheque;

import plateau.Case;

/**
 * @author damien
 *
 */
public class DessinSol extends DessinCase {

	/**
	 * Constructeur pour dessiner le sol
	 * @param c a dessiner
	 * @param dessinSol pour le sol
	 */
	public DessinSol(Case c,Image dessinSol) {
		super(c, dessinSol);
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
