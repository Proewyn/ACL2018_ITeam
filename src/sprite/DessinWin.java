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
public class DessinWin {
	
	protected Image win;
	
	/**
	 * 
	 */
	public DessinWin(File urlImage) {
		this.win = null;
		try {
			this.win = ImageIO.read(urlImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void dessiner(BufferedImage im){
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.drawImage(this.win, 0, 0, im.getHeight(), im.getWidth(),null);
	}

}

