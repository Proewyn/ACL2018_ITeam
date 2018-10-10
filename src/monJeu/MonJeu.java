package monJeu;

import moteurJeu.Commande;
import moteurJeu.Jeu;

/**
 * classe qui contient les donnees du jeu. Pour le moment, il ne possede qu'un
 * personnage
 *
 */
public class MonJeu implements Jeu {

	public static final int HAUT 	= 800;
	public static final int DROITE 	= 600;
	public static final int BAS 	= 200;
	public static final int GAUCHE 	= 400;
	/**
	 * le personnage du jeu
	 */
	private Hero pj;
	
	/**
	 * le plateau de jeux
	 */
	private Plateau plateau;

	/**
	 * constructeur de jeu avec un Personnage
	 */
	public MonJeu() {
		this.pj=new Hero();
	}

	/**
	 * surcharge toString
	 */
	public String toString() {
		return ("" + this.getPj());
	}

	/**
	 * demande a deplacer le personnage
	 * 
	 * @param commande
	 *            chaine qui donne ordre
	 */
	public void evoluer(Commande commande) {
		this.getPj().deplacer(commande);

	}

	@Override
	public boolean etreFini() {
		// le jeu n'est jamais fini
		return false;
	}

	/**
	 * getter pour l'affichage
	 * 
	 * @return personnage du jeu
	 */
	public Hero getPj() {
		return pj;
	}

}
