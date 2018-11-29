package sprite;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * @author levy54u
 *
 */
public class DessinGameOver {
	protected Image gameOver;


	/**
	 * Constructeur pour dessiner la defaite
	 * @param gameOver dessin de defaite
	 */
	public DessinGameOver(Image gameOver) {
		this.gameOver = gameOver;
		
	}
	
	/**
	 * Dessine l'ecran de defaite
	 * @param im a dessiner
	 */
	public void dessiner(BufferedImage im){
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.drawImage(this.gameOver, 0, 0, im.getHeight(), im.getWidth(),null);
	}

}
