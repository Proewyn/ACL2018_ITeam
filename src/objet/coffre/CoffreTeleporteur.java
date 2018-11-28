package objet.coffre;

import java.util.Random;

import objet.Objets;
import plateau.Plateau;
import monJeu.Bibliotheque;
import monJeu.MonJeu;

public class CoffreTeleporteur extends Coffre {

	/**
	 * Crée un coffre piege qui teleporte le joueur
	 * @param x position en X
	 * @param y position en Y
	 */
	public CoffreTeleporteur(int x, int y) {
		super(x, y);
	}
	
	public void action(MonJeu mj){
		Plateau p = mj.getPlateau();
		Objets o = mj.getListeDObjets();
		Random r= new Random();
		int x,y;
		x=r.nextInt(Bibliotheque.TAILLE_TABLEAUX);
		y= r.nextInt(Bibliotheque.TAILLE_TABLEAUY);
		while (p.collision(x, y) || o.collision(x, y)) {
			x=r.nextInt(Bibliotheque.TAILLE_TABLEAUX);
			y= r.nextInt(Bibliotheque.TAILLE_TABLEAUY);
		}
		mj.getPj().deplacer(x, y);
		pasTrouve=false;
	}

}
