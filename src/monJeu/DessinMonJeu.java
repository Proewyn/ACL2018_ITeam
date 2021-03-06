package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import moteurJeu.DessinJeu;
import personnage.Hero;
import sprite.LesDessins;

/**
 * un afficheur graphique associe au JeuTest fourni
 * 
 * @author vthomas
 */
public class DessinMonJeu implements DessinJeu {

	/**
	 * lien vers le jeu a afficher
	 */
	private MonJeu jeu;
	private LesDessins dessins;

	/**
	 * appelle constructeur parent
	 * @param j le jeutest a afficher
	 */
	public DessinMonJeu(MonJeu j) {
		this.jeu = j;
		this.dessins = new LesDessins(j.getListeDObjets(), j.getPlateau(), j.getPj(), j.getMonstre());
	}

	/**
	 * methode dessiner redefinie de Afficheur retourne une image du jeu
	 */
	public void dessiner(BufferedImage im) {
		
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.setColor(Color.black);
		crayon.fillRect(0, 0, im.getHeight(), im.getWidth());
		MonJeu j = (MonJeu) jeu;
		if (j.etreFini()) {
			dessins.dessinerWin(j.isGagne(), im);
		} else {
			Hero pj = j.getPj();
			if (j.getVoirPlateauEntier()) {
				dessins.dessinerPortee(pj, crayon,j.getAttaques());
			} else {
				dessins.dessinerPorteeVision(pj, crayon , j.getAttaques());
			}
		}
	}
}
