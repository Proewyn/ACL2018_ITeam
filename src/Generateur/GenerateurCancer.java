package Generateur;

import java.util.Random;

import monJeu.Bibliotheque;
import monJeu.Case;
import monJeu.Mur;
import monJeu.Sol;

public class GenerateurCancer extends AbstractGenerateur{

	private int[][] proba;

	public GenerateurCancer(int sizeX, int sizeY) {
		super(sizeX, sizeY);
		proba = new int[sizeX-2][sizeY-2];
		for (int i = 0; i < lab.length; i++) {
			for (int j = 0; j < lab[0].length; j++) {
				lab[i][j]   = new Sol();
				proba[i][j] = 0;
			}
		}
	}

	@Override
	public void generer() {
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			lab[r.nextInt(lab.length)][r.nextInt(lab[0].length)] = new Mur();
		}
		for (int i = 0; i < 5; i++) {
			majProba();
			contaminer();
		}

	}

	public void majProba(){
		for (int i = 0; i < proba.length; i++) {
			for (int j = 0; j < proba[0].length; j++) {
				proba[i][j] = 0;
			}
		}
		for (int i = 0; i < proba.length; i++) {
			for (int j = 0; j < proba[0].length; j++) {
				if(i >0 && j>0 && lab[i-1][j-1].getId() == Bibliotheque.MUR) {
					proba[i][j] += 10;
				}
				if(i>0 && 									 lab[i-1][j].getId()    == Bibliotheque.MUR) {
					proba[i][j] += 30;
				}
				if(i>0 && j+1<lab[0].length &&				 lab[i-1][j+1].getId()  == Bibliotheque.MUR) {
					proba[i][j] += 10;
				}
				if(j+1<lab[0].length && 						 lab[i][j+1].getId()    == Bibliotheque.MUR) {
					proba[i][j] += 30;
				}
				if(j+1<lab[0].length && i+1 < lab[0].length && lab[i+1][j+1].getId()  == Bibliotheque.MUR) {
					proba[i][j] += 10;
				}
				if(i+1 < lab[0].length && 					  lab[i+1][j].getId()   == Bibliotheque.MUR) {
					proba[i][j] += 30;
				}
				if(j>0 && i+1 < lab[0].length && 			  lab[i+1][j-1].getId() == Bibliotheque.MUR) {
					proba[i][j] += 10;
				}
				if(j>0 && 									  lab[i][j-1].getId()   == Bibliotheque.MUR) {
					proba[i][j] += 30;
				}
			}
		}
	}
	
	public void contaminer(){
		Random r = new Random();
		for (int i = 0; i < proba.length; i++) {
			for (int j = 0; j < proba.length; j++) {
				if(r.nextInt(100)<= proba[i][j]) {
					lab[i][j] = new Mur();
				}
			}
		}
	}


}
