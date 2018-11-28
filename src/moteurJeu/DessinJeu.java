package moteurJeu;

import java.awt.image.BufferedImage;

/**
 * une interface representant la maniere de dessiner sur un JPanel
 * @author vthomas
 */
public interface DessinJeu {

	/**
	 * Permet de dessiner le jeu
	 * @param image image sur laquelle dessiner
	 */
	public abstract void dessiner(BufferedImage image);

} 
