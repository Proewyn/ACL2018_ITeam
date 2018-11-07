package generateur;

import java.util.Random;

import plateau.Sol;

import monJeu.Bibliotheque;

public class GenerateurWormHoleImparfait extends GenerateurWormHole{

	private int POURCENTNBTROU = 20;
	
	public GenerateurWormHoleImparfait() {
		super();
	}

	@Override
	public void generer() {
		super.generer();
		int nbtrou = (Bibliotheque.TAILLE_TABLEAUX*Bibliotheque.TAILLE_TABLEAUY)*POURCENTNBTROU/100;
		Random r = new Random();
		for (int i = 0; i < nbtrou; i++) {
			lab[r.nextInt(lab.length)][r.nextInt(lab[0].length)] = new Sol();
		}
	}

}
