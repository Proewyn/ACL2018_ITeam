package ia;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import monJeu.Bibliotheque;
import monJeu.MonJeu;
import moteurJeu.Commande;
import personnage.Hero;
import personnage.Monstre;
import plateau.Case;

public class DeplacementPathfinding implements DeplacementMonstre {

	@Override
	public Point deplacer(MonJeu jeu, Monstre m, Commande c) {
		Point retour = new Point(0,0);
		Case[][] plateau = jeu.getPlateau().getLaby();
		Hero pj = jeu.getPj();
		Point depart = new Point(m.getX(), m.getY());
		Point arriver = new Point(pj.getX(),pj.getY());
		if(Math.abs(depart.x - arriver.x) + Math.abs(depart.y - arriver.y)  > Bibliotheque.DISTANCEVUEMONSTRE)
		{
			retour = new DeplacementNaif().deplacer(jeu, m, c);
		}else {
			int[][] poid = new int[plateau.length][plateau[0].length];
			for (int i = 0; i < poid.length; i++) {
				for (int j = 0; j < poid[0].length; j++) {
					poid[i][j] = Integer.MAX_VALUE;
				}
			}

			poid[depart.x][depart.y] = 0;
			poid = getPathFromTo(plateau, depart, arriver, poid);
			/*
			for (int i = 0; i < poid.length; i++) {
				for (int j = 0; j < poid[0].length; j++) {
					System.out.print(poid[i][j] < 10 ? poid[i][j]+" ||" :( poid[i][j] == Integer.MAX_VALUE  ? "##||" : +poid[i][j]+"||"));
				}
				System.out.println();
			}
			System.out.println();*/
			retour = getNextPointTo(arriver, poid);

		}
		return retour;
	}

	public Point getNextPointTo(Point depart, int[][] poid) {
		int poidMin = poid[depart.x][depart.y];
		Point pointMin = new Point(0,0);
		if(poid[depart.x][depart.y] == 1 || poid[depart.x][depart.y] == 0) {
			return depart;
		}
		if(poid[depart.x-1][depart.y] < poidMin) {
			pointMin = new Point(depart.x-1, depart.y);
		}
		if(poid[depart.x+1][depart.y] < poidMin) {
			pointMin = new Point(depart.x+1, depart.y);
		}
		if(poid[depart.x][depart.y-1] < poidMin) {
			pointMin = new Point(depart.x, depart.y-1);
		}
		if(poid[depart.x][depart.y+1] < poidMin) {
			pointMin = new Point(depart.x, depart.y+1);
		}
		return getNextPointTo(pointMin, poid);
	}


	public int[][] getPathFromTo(Case[][] plateau, Point depart, Point arriver, int[][] poid) {
		ArrayList<Point> ptAccessible;
		ptAccessible = getPointAccessible(plateau, depart);
		if(depart.equals(arriver)){
			//poid[arriver.x][arriver.y] = 69;
			return poid;
		}

		Collections.sort(ptAccessible, new PointComp(arriver));
		/*for (Point point : ptAccessible) {
			System.out.println(point.x+ " "+point.y);
		}
		System.out.println("||||||||||||||||");
		 */
		for (Point p : ptAccessible) {
			if(poid[p.x][p.y] > poid[depart.x][depart.y]+1){
				poid[p.x][p.y]  = poid[depart.x][depart.y] + 1; 
				poid = getPathFromTo(plateau, p, arriver, poid);
			}
		}

		return poid;
	}

	class PointComp implements Comparator<Point>{

		Point arriver;
		public PointComp(Point arriver) {
			// TODO Auto-generated constructor stub
			this.arriver = arriver; 
		}

		@Override
		public int compare(Point p1, Point p2) {
			if( Distance(p1.x, p1.y, arriver.x, arriver.y) <  Distance(p2.x, p2.y, arriver.x, arriver.y)){
				return 1;
			} else {
				return -1;
			}
		}

		public double Distance(double x1, double y1, double x2, double y2) {
			return Math.abs(x1- x2) + Math.abs( y1- y2);    
			//return Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
		} 


	}

	public ArrayList<Point> getPointAccessible(Case[][] plateau, Point depart) {
		ArrayList<Point> ptAccessible = new ArrayList<Point>();
		if(plateau[depart.x + 1][depart.y].isTraversable()) {
			ptAccessible.add(new Point(depart.x + 1,depart.y));
		}
		if(plateau[depart.x - 1][depart.y].isTraversable()) {
			ptAccessible.add(new Point(depart.x - 1,depart.y));
		}
		if(plateau[depart.x][depart.y + 1].isTraversable()) {
			ptAccessible.add(new Point(depart.x,depart.y + 1));
		}
		if(plateau[depart.x][depart.y - 1].isTraversable()) {
			ptAccessible.add(new Point(depart.x,depart.y - 1));
		}

		return ptAccessible;
	}

}
