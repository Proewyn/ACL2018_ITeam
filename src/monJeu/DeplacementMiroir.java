/**
 * 
 */ 
package monJeu;

import java.awt.Point;
import java.util.Random;

import moteurJeu.Commande;

/**
 * @author levy54u
 *
 */
public class DeplacementMiroir implements DeplacementMonstre {

	/**
	 * 
	 */
	public DeplacementMiroir() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see monJeu.DeplacementMonstre#deplacer(monJeu.Monstre, moteurJeu.Commande)
	 */
	@Override
	public Point deplacer(Monstre m, Commande commande) {
		Point p = new Point();
		int x = m.getX();
		int y = m.getY();
		if (commande.gauche){
			x++;
		}
		else if (commande.droite){
			x--;
		}
		else if(commande.haut){
			y++;
		}
		else if(commande.bas){
			y--;
		}
		else{
			/*Random r = new Random();
			int rand = r.nextInt(4);
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
			
			}*/
			DeplacementNaif d = new DeplacementNaif();
			x = (int)d.deplacer(m, commande).getX();
			y =(int) d.deplacer(m, commande).getY();
			
			
		}
		p.setLocation(x, y);
		return p;
	}

}
