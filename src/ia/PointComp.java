package ia;

import java.awt.Point;
import java.util.Comparator;

public class PointComp implements Comparator<Point> {

	Point arriver;
	
	public PointComp(Point arriver) {
		this.arriver = arriver; 
	}

	@Override
	public int compare(Point p1, Point p2) {
		if( Distance(p1, arriver) <  Distance(p2, arriver)){
			return -1;
		} else {
			return 1;
		}
	}

	/**
	 * Calcule la distance entre deux points
	 * @param p1 premier point
	 * @param p2 second point
	 * @return la distance entre les deux points
	 */
	public double Distance(Point p1, Point p2) { 
		return Math.sqrt(Math.pow(p2.y - p1.y, 2) + Math.pow(p2.x - p1.x, 2));
	} 
	
	/**
	 * @param depart
	 * @return
	 */
	public double DistanceArriver(Point depart) {   
		return Math.sqrt(Math.pow(arriver.y - depart.y, 2) + Math.pow(arriver.x - depart.x, 2));
	} 

}
