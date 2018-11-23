/**
 * 
 */
package sprite.spriteCase;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import monJeu.Bibliotheque;
import plateau.Case;

/**
 * @author damien
 *
 */
public abstract class DessinCase {

	private Case c;
	protected Image dessinCase;
	
	/**
	 * 
	 */
	public DessinCase(Case c, File urlImage) {
		this.c = c;
		this.dessinCase = null;
		try {
			this.dessinCase = ImageIO.read(urlImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void dessiner(Graphics2D crayon) {
		
		
	}
	
	public void dessiner(int x, int y,Graphics2D crayon) {
		crayon.setColor(Color.green);
		crayon.fillRect(x * Bibliotheque.TAILLE_CASE, y * Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE);
		
	}
	

}
