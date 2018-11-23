/**
 * 
 */
package sprite;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author levy54u
 *
 */
public class DessinGameOver {
	protected Image gameOver;


	/**
	 * 
	 */
	public DessinGameOver(File urlImage) {
		this.gameOver = null;
		try {
			this.gameOver = ImageIO.read(urlImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void dessiner(BufferedImage im){
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		
		crayon.drawImage(this.gameOver, 0, 0, im.getHeight(), im.getWidth(),null);
		
	}


}
