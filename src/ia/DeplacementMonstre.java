/**
 * 
 */
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
	
	public Point deplacer(MonJeu jeu, Monstre m, Commande c);
	

}
