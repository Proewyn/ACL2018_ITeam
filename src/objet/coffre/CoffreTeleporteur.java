package objet.coffre;

import java.util.Random;

import objet.Objets;
import plateau.Plateau;
import monJeu.MonJeu;

public class CoffreTeleporteur extends Coffre {

	public CoffreTeleporteur(int x, int y) {
		super(x, y);
	}
	
	public void action(MonJeu mj){
		
		Plateau p = mj.getPlateau();
		Objets o = mj.getListeDObjets();
		Random r= new Random();
		int x,y;
		x=r.nextInt(p.taillePlateaux());
		y= r.nextInt(p.taillePlateauy());
		while (p.collision(x, y) || o.collision(x, y)){
			x=r.nextInt(p.taillePlateaux());
			y= r.nextInt(p.taillePlateauy());
		}
		mj.getPj().deplacer(x, y);
		pasTrouve=false;
	}

}
