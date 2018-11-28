package sprite;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * @author levy54u
 *
 */
public class DessinWin {
	
	protected Image win;
	
	/**
	 * Constructeur pour dessiner la victoire
	 * @param dessinWin dessin de victoire
	 */
	public DessinWin(Image dessinWin) {
		this.win = dessinWin;
	}
	
	/**
	 * Dessine l'ecran de victoire
	 * @param im a dessiner
	 */
	public void dessiner(BufferedImage im){
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.drawImage(this.win, 0, 0, im.getHeight(), im.getWidth(),null);
	}

}

