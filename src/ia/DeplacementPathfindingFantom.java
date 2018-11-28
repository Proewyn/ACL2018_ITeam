package ia;

import java.awt.Point;

import monJeu.Bibliotheque;
import monJeu.MonJeu;
import moteurJeu.Commande;
import personnage.Hero;
import personnage.Monstre;

public class DeplacementPathfindingFantom implements DeplacementMonstre{

	@Override
	public Point deplacer(MonJeu jeu, Monstre m, Commande c) {
		Hero pj = jeu.getPj();
		Point depart = new Point(m.getX(), m.getY());
		Point retour = depart;
		Point arriver = new Point(pj.getX(),pj.getY());
		Point p = depart;
		PointComp pc = new PointComp(arriver);
		if(pc.DistanceArriver(depart) < Bibliotheque.DISTANCEVUEMONSTRE) {
			double d = Double.MAX_VALUE;
			double dd = Double.MAX_VALUE;

			if(depart.x+1 < Bibliotheque.TAILLE_TABLEAUX) {
				dd = pc.DistanceArriver(p = new Point(depart.x+1, depart.y));
				if( dd  < d) {
					d = dd;
					retour = p;
				}
			}
			if(depart.x-1 > 0 ) {
				dd = pc.DistanceArriver(p = new Point(depart.x-1, depart.y));
				if(dd < d) {
					d = dd;
					retour = p;
				}
			}
			if(depart.y-1 > 0 ) {
				dd = pc.DistanceArriver(p = new Point(depart.x, depart.y-1));
				if(dd < d) {
					d = dd;
					retour = p;
				}
			}
			if(depart.y+1 < Bibliotheque.TAILLE_TABLEAUY) {
				dd = pc.DistanceArriver(p = new Point(depart.x, depart.y+1)); 
				if(dd < d) {
					d = dd;
					retour = p;
				}
			}
		} else {
			retour = new DeplacementNaif().deplacer(jeu, m, c);
		}
		return retour;
	}

}
