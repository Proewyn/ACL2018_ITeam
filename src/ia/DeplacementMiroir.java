package ia;

import java.awt.Point;

import personnage.Monstre;
import monJeu.MonJeu;
import moteurJeu.Commande;

/**
 * @author levy54u
 *
 */
public class DeplacementMiroir implements DeplacementMonstre {

	private DeplacementNaif d;
	/**
	 * 
	 */
	public DeplacementMiroir() {
		// TODO Auto-generated constructor stub
		d = new DeplacementNaif();
	}

	
	/**
	 * @param jeu : le jeu dans lequel on utilise le deplacement
	 * @param m : le monstre que l'on veut deplacer
	 * @param c : commande du monstre
	 * @return p : point ou l'on souhaite deplacer le monstre
	 */
	@Override
	public Point deplacer(MonJeu jeu, Monstre m, Commande commande) {
		Point p = new Point();
		int x = m.getX();
		int y = m.getY();
		if (commande.gauche) {
			x++;
		}
		else if (commande.droite) {
			x--;
		}
		else if(commande.haut) {
			y++;
		}
		else if(commande.bas) {
			y--;
		}
		else{
			x = (int)d.deplacer(jeu,m, commande).getX();
			y =(int) d.deplacer(jeu,m, commande).getY();
			
			
		}
		p.setLocation(x, y);
		return p;
	}



}
