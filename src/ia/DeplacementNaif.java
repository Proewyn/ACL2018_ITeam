/**
 * 
 */
package ia;

import java.awt.Point;
import java.util.Random;

import personnage.Monstre;

import monJeu.MonJeu;
import moteurJeu.Commande;

/**
 * @author damien
 *
 */
public class DeplacementNaif implements DeplacementMonstre {

	/**
	 * 
	 */
	public DeplacementNaif() {
		
	}

	
	
	/**
	 * @param jeu : le jeu dans lequel on utilise le deplacement
	 * @param m : le monstre que l'on veut deplacer
	 * @param c : inutilise
	 * @return p : point ou l'on souhaite deplacer le monstre
	 */
	public Point deplacer(MonJeu jeu,Monstre m, Commande c) {
		Point p = new Point();
		Random r = new Random();
		int rand = r.nextInt(4);
		int x = m.getX();
		int y = m.getY();
		switch(rand) {
		case 0 :
			x--;
			break;
		case 1 :
			y--;
			break;
		case 2 :
			x++;
			break;
		case 3 :
			y++;
			break;
		}
		p.setLocation(x, y);
		return p;
	}

}
