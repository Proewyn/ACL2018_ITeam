package Generateur;

import java.util.Random;

import monJeu.Sol;

public class GenerateurWormHoleImparfait extends GenerateurWormHole{

	private static final int NBTROU = 150;
	
	public GenerateurWormHoleImparfait(int sizeX, int sizeY) {
		super(sizeX, sizeY);
	}

	@Override
	public void generer() {
		super.generer();
		Random r = new Random();
		for (int i = 0; i < NBTROU; i++) {
			lab[r.nextInt(lab.length)][r.nextInt(lab[0].length)] = new Sol();
		}
	}

}
