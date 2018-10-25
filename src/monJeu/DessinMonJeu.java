package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import moteurJeu.DessinJeu;

/**
 * un afficheur graphique associe au JeuTest fourni
 * 
 * @author vthomas
 */
public class DessinMonJeu implements DessinJeu {

	/**
	 * constante pour gerer la taille des cases
	 */
	private static int TAILLE_CASE = 10;

	/**
	 * lien vers le jeu a afficher
	 */
	private MonJeu jeu;

	/**
	 * appelle constructeur parent
	 * 
	 * @param j
	 *            le jeutest a afficher
	 */
	public DessinMonJeu(MonJeu j) {
		this.jeu = j;
	}

	/**
	 * dessiner un objet consiste a dessiner sur l'image suivante methode
	 * redefinie de Affiheur
	 */
	private void dessinerObjet(int s, int x, int y, BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		switch (s) {
		case Bibliotheque.JOUEUR:
			crayon.setColor(Color.blue);
			crayon.fillOval(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
					TAILLE_CASE);
			break;
		case Bibliotheque.MUR:
			crayon.setColor(Color.gray);
			crayon.fillRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
					TAILLE_CASE);
			break;
		case Bibliotheque.SOL:
			crayon.setColor(Color.green);
			crayon.fillRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
					TAILLE_CASE);
			break;
		case Bibliotheque.SPAWN:
			crayon.setColor(Color.magenta);
			crayon.fillRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE);
		case Bibliotheque.ZOMBI:
			crayon.setColor(Color.YELLOW);
			crayon.fillOval(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
					TAILLE_CASE);
			break;
		default:
			throw new AssertionError("objet inexistant");
		}
	}

	/**crayon.setColor(Color.blue);
			crayon.fillOval(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
					TAILLE_CASE);
			break;
	 * methode dessiner redefinie de Afficheur retourne une image du jeu
	 */
	public void dessiner(BufferedImage im) {
		// no sait que c'est un jeuTest
		int vision,x,y;
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.setColor(Color.black);
		crayon.fillRect(0, 0, im.getHeight(),
				im.getWidth());
		MonJeu j      = (MonJeu) jeu;
		Hero pj       = j.getPj();
		ArrayList<Monstre> monstres = j.getMonstre();
		vision = pj.getVision();
		x=pj.getX();
		y=pj.getY();
		Plateau p	  = j.getPlateau();
		Case[][] laby = p.getLaby(); 
		for (int i=0;i<p.taillePlateaux();i++){
			for (int h=0;h<p.taillePlateauy();h++){
				if (Math.sqrt((x-i)*(x-i)+(y-h)*(y-h))<= vision ){
					this.dessinerObjet(laby[i][h].getId(), i, h, im);
				}else{
					if(laby[i][h].isVisible()){
						this.dessinerObjet(laby[i][h].getId(), i, h, im);
					}
				}
				
			}
		}

		this.dessinerObjet(Bibliotheque.JOUEUR, pj.getX(), pj.getY(), im);
		
		for (Monstre m : monstres) { //pour dessiner la liste de monstre
			if (Math.sqrt((x-m.getX())*(x-m.getX())+(y-m.getY())*(y-m.getY()))<= vision ){
				//pour qu'il ne soit visible que dans le champ de vision
				this.dessinerObjet(Bibliotheque.ZOMBI, m.getX(), m.getY(), im);			
			}
		}
		
	}

}
