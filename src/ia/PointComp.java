package ia;

import java.awt.Point;
import java.util.Comparator;

public class PointComp implements Comparator<Point> {


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
