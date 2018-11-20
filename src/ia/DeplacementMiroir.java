package ia;

import java.awt.Point;

import personnage.Monstre;
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

	/* (non-Javadoc)
	 * @see monJeu.DeplacementMonstre#deplacer(monJeu.Monstre, moteurJeu.Commande)
	 */
	@Override
	public Point deplacer(Monstre m, Commande commande) {
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
			x = (int)d.deplacer(m, commande).getX();
			y =(int) d.deplacer(m, commande).getY();
			
			
		}
		p.setLocation(x, y);
		return p;
	}

}
