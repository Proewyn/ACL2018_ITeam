/**
 * 
 */
package ia;

import java.awt.Point;

import personnage.Monstre;

import moteurJeu.Commande;

/**
 * @author damien
 *
 */
public interface DeplacementMonstre {
	
	public Point deplacer(Monstre m,Commande c);

}
