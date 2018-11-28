package sprite.spriteCase;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import monJeu.Bibliotheque;
import plateau.Case;

/**
 * @author damien
 *
 */
public class DessinSpawn extends DessinCase {

	/**
	 * Constructeur pour dessiner le spawn
	 * @param c a dessiner
	 * @param dessinMur pour le spawn
	 */
	public DessinSpawn(Case c, Image dessinMur) {
		super(c, dessinMur);
	}
	
	@Override
	public void dessiner(int x, int y,Graphics2D crayon) {
		crayon.setColor(Color.magenta);
		crayon.fillRect(x * Bibliotheque.TAILLE_CASE, y * Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE);
	}

}
