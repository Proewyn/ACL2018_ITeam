/**
 * 
 */
package monJeu;

import java.awt.Point;
import java.util.Random;

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


	public Point deplacer(Monstre m) {
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
