package ia;

import java.awt.Point;

import personnage.Monstre;

import monJeu.MonJeu;
import moteurJeu.Commande;

/**
 * @author damien
 *
 */
public interface DeplacementMonstre {
	
	/**
	 * Deplace les monstres dans le jeu
	 * @param jeu : le jeu dans lequel on utilise le deplacement
	 * @param m : le monstre que l'on veut deplacer
	 * @param c : commande du monstre
	 * @return point ou l'on souhaite deplacer le monstre
	 */
	public Point deplacer(MonJeu jeu, Monstre m, Commande c);
	

}
