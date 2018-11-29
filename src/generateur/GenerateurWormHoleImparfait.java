package generateur;

import java.util.Random;

import plateau.Sol;

import monJeu.Bibliotheque;

public class GenerateurWormHoleImparfait extends GenerateurWormHole{

	private int POURCENTNBTROU = 20;

	/**
	 * Constructeur 
	 */
	public GenerateurWormHoleImparfait() {
		super();
	}

	@Override
	/**
	 * Utilise le generateur de labyrinthe parfait et creuse des trous aleatoirement 
	 */
	public void generer() {
		super.generer();
		int nbmur = 0;
		for (int i = 0; i < lab.length; i++) {
			for (int j = 0; j < lab[0].length; j++) {
				if(lab[i][j].getId() == Bibliotheque.MUR)
					nbmur ++;
			}
		}
		int nbtrou = nbmur*POURCENTNBTROU/100;
		Random r = new Random();
		int x, y;
		boolean valide;
		for (int i = 0; i < nbtrou; i++) {
			do{
				valide = false;
				x = r.nextInt(lab.length);
				y = r.nextInt(lab[0].length);
				if(x > 0 && !lab[x-1][y].isTraversable()
				   && x+1 < lab.length && !lab[x+1][y].isTraversable()
				   && y > 0 && !lab[x][y-1].isTraversable()
				   && y+1 < lab[0].length && !lab[x][y+1].isTraversable())
								valide = true;
			}while(valide || lab[x][y].getId() == Bibliotheque.SPAWN || lab[x][y].getId() != Bibliotheque.MUR);
			lab[x][y] = new Sol();
		}
	}

}
