package moteurJeu;

import monJeu.Bibliotheque;
import monJeu.MonJeu;

/**
 * classe MoteurGraphique represente un moteur de jeu generique.
 * 
 * On lui passe un jeu et un afficheur et il permet d'executer un jeu.
 */
public class MoteurGraphique {

	/**
	 * le jeu a executer
	 */
	private MonJeu jeu;
	/**
	 * l'interface graphique
	 */
	private InterfaceGraphique gui;
	/**
	 * l'afficheur a utiliser pour le rendu
	 */
	private DessinJeu dessin;

	/**
	 * construit un moteur
	 * 
	 * @param pJeu
	 *            jeu a lancer
	 * @param pAffiche
	 *            afficheur a utiliser
	 */
	public MoteurGraphique(MonJeu pJeu, DessinJeu pAffiche) {
		// creation du jeu
		this.jeu = pJeu;
		this.dessin = pAffiche;
	}

	/**
	 * permet de lancer le jeu
	 */
	public void lancerJeu() throws InterruptedException {

		// creation de l'interface graphique
		this.gui = new InterfaceGraphique(this.dessin, Bibliotheque.TAILLE_CASE*Bibliotheque.VUE_LARGEUR, Bibliotheque.TAILLE_CASE*Bibliotheque.VUE_HAUTEUR, jeu);
		Controleur controle = this.gui.getControleur();

		// boucle de jeu
		while (!this.jeu.etreFini()) {
			// demande controle utilisateur
			Commande c = controle.getCommande();
			// fait evoluer le jeu
			this.jeu.evoluer(c);
			// affiche le jeu
			this.gui.dessiner();
			// met en attente
			Thread.sleep(200);
		}
	}

}
