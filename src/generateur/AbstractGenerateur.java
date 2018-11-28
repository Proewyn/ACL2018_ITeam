package generateur;

import plateau.Case;
import plateau.Mur;
import monJeu.Bibliotheque;

public abstract class AbstractGenerateur {

	/**
	 * lab : tableau de case correspondant au futur plateau de jeux
	 *  x  : coordonnee x du spawn
	 *  y  : coordonnee y du spawn 
	 */
	protected Case[][] lab;
	protected int x;
	protected int y;
	
	/**
	 * Constructeur par defaut initialise lab de la taille du plateau
	 */
	public AbstractGenerateur() {
		lab = new Case[Bibliotheque.TAILLE_TABLEAUX-2][Bibliotheque.TAILLE_TABLEAUY-2];
	}
	
	/**
	 * Genere et ajoute les bordure au plateau 
	 * @return un plateau generer aleatoirement
	 */
	public Case[][] getLab(){
		generer();
		addBordure();
		return lab;
	}
	
	/**
	 * Methode de generation du labyrinthe
	 */
	public abstract void generer();
	
	/**
	 * Ajoute les bordure au lab
	 */
	public void addBordure(){
		Case[][] lab2 = new Case[lab.length+2][lab[0].length+2];
		for (int i = 0; i < lab.length; i++) {
			for (int j = 0; j < lab[0].length; j++) {
				lab2[i+1][j+1] = lab[i][j];
			}
		}
		for (int i = 0; i < lab2.length; i++) {
			lab2[i][0] = new Mur(true);
			lab2[i][lab2[0].length-1] = new Mur(true);
		}
		for (int i = 0; i < lab2[0].length; i++) {
			lab2[0][i] = new Mur(true);
			lab2[lab2.length-1][i] = new Mur(true);
		}
		lab = lab2;
	}
}
