package monJeu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import moteurJeu.DessinJeu;
import objet.Objet;
import objet.Objets;
import personnage.Hero;
import personnage.Monstre;
import plateau.Case;
import plateau.Plateau;
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
	 * 
	 * @param j
	 *            le jeutest a afficher
	 */
	public DessinMonJeu(MonJeu j) {
		this.jeu = j;
		this.dessins = new LesDessins(j.getListeDObjets(), j.getPlateau(), j.getPj(), j.getMonstre());
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
			crayon.fillOval(x * Bibliotheque.TAILLE_CASE, y * Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE);
			break;
		case Bibliotheque.MUR:
			crayon.setColor(Color.gray);
			crayon.fillRect(x * Bibliotheque.TAILLE_CASE, y * Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE);
			break;
		case Bibliotheque.SOL:
			crayon.setColor(Color.green);
			crayon.fillRect(x * Bibliotheque.TAILLE_CASE, y * Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE);
			break;
		case Bibliotheque.SPAWN:
			crayon.setColor(Color.magenta);
			crayon.fillRect(x * Bibliotheque.TAILLE_CASE, y * Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE);
			break;
		case Bibliotheque.ZOMBI:
			crayon.setColor(Color.YELLOW);
			crayon.fillOval(x * Bibliotheque.TAILLE_CASE, y * Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE);
			break;
		case Bibliotheque.TORCHE:
			crayon.setColor(Color.red);
			crayon.fillRect(x * Bibliotheque.TAILLE_CASE+Bibliotheque.TAILLE_OBJET/2, y * Bibliotheque.TAILLE_CASE+Bibliotheque.TAILLE_OBJET/2, Bibliotheque.TAILLE_OBJET, Bibliotheque.TAILLE_OBJET);
			break;
		case Bibliotheque.TELEPORTEUR:
			crayon.setColor(Color.cyan);
			crayon.fillRect(x * Bibliotheque.TAILLE_CASE, y * Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE);
			crayon.setColor(Color.yellow);
			crayon.fillRect(x * Bibliotheque.TAILLE_CASE+Bibliotheque.TAILLE_OBJET/2+1, y * Bibliotheque.TAILLE_CASE+Bibliotheque.TAILLE_OBJET/2+1, Bibliotheque.TAILLE_OBJET, Bibliotheque.TAILLE_OBJET);
			break;
		case Bibliotheque.COFFRE:
			crayon.setColor(new Color(165,42,42));
			crayon.fillRect(x * Bibliotheque.TAILLE_CASE, y * Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE, Bibliotheque.TAILLE_CASE);
			crayon.setColor(Color.yellow);
			crayon.fillRect(x * Bibliotheque.TAILLE_CASE+2, y * Bibliotheque.TAILLE_CASE+2, Bibliotheque.TAILLE_OBJET+2, Bibliotheque.TAILLE_OBJET+2);
			crayon.setColor(new Color(165,42,42));
			crayon.fillRect(x * Bibliotheque.TAILLE_CASE+Bibliotheque.TAILLE_OBJET/2+1, y * Bibliotheque.TAILLE_CASE+Bibliotheque.TAILLE_OBJET/2+1, Bibliotheque.TAILLE_OBJET, Bibliotheque.TAILLE_OBJET);
			break;
		default:
			throw new AssertionError("objet inexistant");
		}
	}

	/**
	 * methode dessiner redefinie de Afficheur retourne une image du jeu
	 */
	public void dessiner(BufferedImage im) {
		// no sait que c'est un jeuTest
		int vision,x,y;
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.setColor(Color.black);
		crayon.fillRect(0, 0, im.getHeight(), im.getWidth());
		MonJeu j      = (MonJeu) jeu;
		Hero pj       = j.getPj();
		ArrayList<Monstre> monstres = j.getMonstre();
		vision = pj.getVision();
		x = pj.getX();
		y = pj.getY();
		Plateau p	  = j.getPlateau();
		Case[][] laby = p.getLaby(); 
		if(j.getVoirPlateauEntier()) {
			/*for (int i = 0 ; i < p.taillePlateaux() ; i++) {
				for (int h = 0 ; h < p.taillePlateauy() ; h++) {
					this.dessinerObjet(laby[i][h].getId(), i, h, im);			
				}
			}
			Objets objets = j.getListeDObjets();
			for(Objet o : objets.getObjets()) {
				if(o.isPasTrouve()) {
					this.dessinerObjet(o.getId(),o.getX(),o.getY(),im);
				}
			}
			for (Monstre m : monstres) { //pour dessiner la liste de monstre
					this.dessinerObjet(m.getId(), m.getX(), m.getY(), im);			
			}*/
		
			
			this.dessins.dessiner(crayon);
		}else {
			for (int i=0;i<p.taillePlateaux();i++) {
				for (int h=0;h<p.taillePlateauy();h++) {
					if (Math.sqrt((x-i)*(x-i)+(y-h)*(y-h))<= vision ) {
						this.dessinerObjet(laby[i][h].getId(), i, h, im);
					}else {
						if(laby[i][h].isVisible()) {
							this.dessinerObjet(laby[i][h].getId(), i, h, im);
						}
					}
				}
			}
			Objets objets = j.getListeDObjets();
			for(Objet o : objets.getObjets()){
				if(o.isPasTrouve() && (Math.sqrt((x-o.getX())*(x-o.getX())+(y-o.getY())*(y-o.getY())) <= vision)){
					this.dessinerObjet(o.getId(),o.getX(),o.getY(),im);
				}
			}
			for (Monstre m : monstres) { //pour dessiner la liste de monstre
				if (Math.sqrt((x-m.getX())*(x-m.getX())+(y-m.getY())*(y-m.getY())) <= vision ){
					//pour qu'il ne soit visible que dans le champ de vision
					this.dessinerObjet(m.getId(), m.getX(), m.getY(), im);			
				}
			}
			this.dessinerObjet(pj.getId(), pj.getX(), pj.getY(), im);	
		}
		
	}

}
