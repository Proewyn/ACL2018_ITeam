package ia;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import monJeu.Bibliotheque;
import monJeu.MonJeu;
import moteurJeu.Commande;
import personnage.Hero;
import personnage.Monstre;
import plateau.Case;

public class DeplacementPathfinding implements DeplacementMonstre {

	/*
	 * Gere un deplacement avec pathfinding (Algorithme wA*) 
	 * Dans le cas ou le monstre est a une distance importante du joueur le deplacement est gerer par un deplacement naif 
	 * 
	 */
	@Override
	public Point deplacer(MonJeu jeu, Monstre m, Commande c) {
		Point retour = new Point(0,0);
		Case[][] plateau = jeu.getPlateau().getLaby();
		Hero pj = jeu.getPj();
		Point depart = new Point(m.getX(), m.getY());
		Point arriver = new Point(pj.getX(),pj.getY());
		if(Math.abs(depart.x - arriver.x) + Math.abs(depart.y - arriver.y)  > Bibliotheque.DISTANCEVUEMONSTRE){
			retour = new DeplacementNaif().deplacer(jeu, m, c);
		}
		else {
			int[][] poid = new int[plateau.length][plateau[0].length];
			for (int i = 0; i < poid.length; i++) {
				for (int j = 0; j < poid[0].length; j++) {
					poid[i][j] = Integer.MAX_VALUE;
				}
			}
			poid[depart.x][depart.y] = 0;
			poid = getPathFromTo(plateau, depart, arriver, poid);
			retour = getNextPointTo(arriver, poid);
		}
		return retour;
	}

	/**
	 * Permet de determiner quelle le prochaine point auquelle aller pour ce rapprocher du point arriver
	 * @param arriver point a atteindre
	 * @param poid Tableau de poid (le poid d'une case represente la nombre de case a parcourir)
	 * @return le prochaine point auquelle aller 
	 */
	public Point getNextPointTo(Point arriver, int[][] poid) {
		int poidMin = poid[arriver.x][arriver.y];
		Point pointMin = new Point(0,0);
		if(poid[arriver.x][arriver.y] == 1 || poid[arriver.x][arriver.y] == 0) {
			return arriver;
		}
		if(arriver.x-1 > 0 && poid[arriver.x-1][arriver.y] < poidMin) {
			pointMin.x = arriver.x-1;
			pointMin.y = arriver.y;
		}
		if(arriver.x+1 < poid.length && poid[arriver.x+1][arriver.y] < poidMin) {
			pointMin.x = arriver.x+1;
			pointMin.y = arriver.y;
		}
		if(arriver.y-1 > 0 && poid[arriver.x][arriver.y-1] < poidMin) {
			pointMin.x = arriver.x;
			pointMin.y = arriver.y-1;
		}
		if(arriver.y+1 < poid[0].length && poid[arriver.x][arriver.y+1] < poidMin) {
			pointMin.x = arriver.x;
			pointMin.y = arriver.y+1;
		}
		return getNextPointTo(pointMin, poid);
	}


	/**
	 * Determine un tableau avec la distance necessaire pour l'atteindre 
	 * @param plateau plateau de jeux 
	 * @param depart point de depart de la recherche
	 * @param arriver point d'arriver de la recherche
	 * @param poid Tableau de poid (le poid d'une case represente la nombre de case a parcourir)
	 * @return Le tableau de poid final 
	 */
	public int[][] getPathFromTo(Case[][] plateau, Point depart, Point arriver, int[][] poid) {
		ArrayList<Point> ptAccessible;
		ptAccessible = getPointAccessible(plateau, depart);
		if(depart.equals(arriver)){
			return poid;
		}
		Collections.sort(ptAccessible, new PointComp(arriver));
		for (Point p : ptAccessible) {
			if(poid[p.x][p.y] > poid[depart.x][depart.y]+1){
				poid[p.x][p.y]  = poid[depart.x][depart.y] + 1; 
				poid = getPathFromTo(plateau, p, arriver, poid);
				if(poid[arriver.x][arriver.y] != Integer.MAX_VALUE) {
					return poid;
				}
			}
		}
		return poid;
	}

	/**
	 * Retourne la liste des point accessible depuis un autre point
	 * @param plateau Plateau de jeu
	 * @param depart Point de depart de la recherche
	 * @return liste des point accessible depuis depart
	 */
	public ArrayList<Point> getPointAccessible(Case[][] plateau, Point depart) {
		ArrayList<Point> ptAccessible = new ArrayList<Point>();
		if(depart.x+1 < plateau.length && plateau[depart.x + 1][depart.y].isTraversable()) {
			ptAccessible.add(new Point(depart.x + 1,depart.y));
		}
		if(depart.x-1 > 0 && plateau[depart.x - 1][depart.y].isTraversable()) {
			ptAccessible.add(new Point(depart.x - 1,depart.y));
		}
		if(depart.y+1 < plateau[0].length && plateau[depart.x][depart.y + 1].isTraversable()) {
			ptAccessible.add(new Point(depart.x,depart.y + 1));
		}
		if(depart.y-1 > 0 && plateau[depart.x][depart.y - 1].isTraversable()) {
			ptAccessible.add(new Point(depart.x,depart.y - 1));
		}
		return ptAccessible;
	}

}
