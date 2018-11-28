package generateur;

import java.util.Random;

import plateau.Mur;
import plateau.Sol;
import plateau.Spawn;

import monJeu.Bibliotheque;
public class GenerateurCancer extends AbstractGenerateur{

	private int[][] proba;
	private static final int DIAG        = 5;
	private static final int DROIT       = 16; 
	private static final int NBITERATION = 10; 
	private static final int NBVIRUS     = 40; 

	/**
	 * Constructeur 
	 */
	public GenerateurCancer() {
		super();
		proba = new int[Bibliotheque.TAILLE_TABLEAUX-2][Bibliotheque.TAILLE_TABLEAUY-2];
		for (int i = 0; i < lab.length; i++) {
			for (int j = 0; j < lab[0].length; j++) {
				lab[i][j]   = new Sol();
				proba[i][j] = 0;
			}
		}
		Random r = new Random();
		do{
		x = (r.nextInt(lab.length)/2)*2;
		y = (r.nextInt(lab[0].length)/2)*2;
		}while(lab[x][y].getId() == Bibliotheque.SOL);
		lab[x][y] = new Spawn();
	}

	/*
	 * Generer un plateau avec un systeme de jeu de la vie
	 */
	@Override
	public void generer() {
		Random r = new Random();
		for (int i = 0; i < NBVIRUS; i++) {
			lab[r.nextInt(lab.length)][r.nextInt(lab[0].length)] = new Mur();
		}
		for (int i = 0; i < NBITERATION; i++) {
			majProba();
			contaminer();
		}

	}

	/**
	 * Met a jour le tableau des probabilite de propagation des murs
	 */
	public void majProba(){
		for (int i = 0; i < proba.length; i++) {
			for (int j = 0; j < proba[0].length; j++) {
				proba[i][j] = 0;
			}
		}
		for (int i = 0; i < proba.length; i++) {
			for (int j = 0; j < proba[0].length; j++) {
				if(i >0 && j>0 && lab[i-1][j-1].getId() == Bibliotheque.MUR) {
					proba[i][j] += DIAG;
				}
				if(i>0 && 									 lab[i-1][j].getId()    == Bibliotheque.MUR) {
					proba[i][j] += DROIT;
				}
				if(i>0 && j+1<lab[0].length &&				 lab[i-1][j+1].getId()  == Bibliotheque.MUR) {
					proba[i][j] += DIAG;
				}
				if(j+1<lab[0].length && 						 lab[i][j+1].getId()    == Bibliotheque.MUR) {
					proba[i][j] += DROIT;
				}
				if(j+1<lab[0].length && i+1 < lab[0].length && lab[i+1][j+1].getId()  == Bibliotheque.MUR) {
					proba[i][j] += DIAG;
				}
				if(i+1 < lab[0].length && 					  lab[i+1][j].getId()   == Bibliotheque.MUR) {
					proba[i][j] += DROIT;
				}
				if(j>0 && i+1 < lab[0].length && 			  lab[i+1][j-1].getId() == Bibliotheque.MUR) {
					proba[i][j] += DIAG;
				}
				if(j>0 && 									  lab[i][j-1].getId()   == Bibliotheque.MUR) {
					proba[i][j] += DROIT;
				}
			}
		}
	}

	/**
	 * Contamine le plateau de murs
	 */
	public void contaminer(){
		Random r = new Random();
		for (int i = 0; i < proba.length; i++) {
			for (int j = 0; j < proba.length; j++) {
				if(r.nextInt(100)< proba[i][j]) {
					lab[i][j] = new Mur();
				}
			}
		}
	}


}
