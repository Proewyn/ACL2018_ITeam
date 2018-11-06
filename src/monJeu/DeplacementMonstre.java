/**
 * 
 */
package monJeu;

import java.awt.Point;

import moteurJeu.Commande;

/**
 * @author damien
 *
 */
public interface DeplacementMonstre {
	
	
	
	public Point deplacer(Monstre m,Commande c);

}
