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
	 * Constructeur par defaut
	 */
	public DeplacementMiroir() {
		d = new DeplacementNaif();
	}
	
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
