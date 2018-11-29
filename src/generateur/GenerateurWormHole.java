package generateur;

import java.util.ArrayList;
import java.util.Random;

import plateau.Mur;
import plateau.Sol;
import plateau.Spawn;

import monJeu.Bibliotheque;

public class GenerateurWormHole extends AbstractGenerateur {

	private boolean[][] traverser;

	/**
	 * Constructeur par defaut
	 */
	public GenerateurWormHole() {
		super();
		traverser = new boolean[Bibliotheque.TAILLE_TABLEAUX-2][Bibliotheque.TAILLE_TABLEAUY-2];
	}

	/**
	 * Genere un labyrinthe parfait (Algorithme Exhaustif)
	 */
	public void generer() {
		Random r = new Random();
		x = (r.nextInt(lab.length)/2)*2;
		y = (r.nextInt(lab[0].length)/2)*2;
		for (int e = 0; e < lab.length; e++) {
			for (int g = 0; g < lab[0].length; g++) {
				lab[e][g] 		= null;
				traverser[e][g] = false;
			}
		}
		lab[x][y] = new Spawn();
		do {
			genererRetour();	
		} while (traverser[x][y]);

		for (int e = 0; e < lab.length; e++) {
			for (int g = 0; g < lab[0].length; g++) {
				if (lab[e][g] == null) {
					lab[e][g] = new Mur();
				}
			}
		}
	}

	/**
	 * Genere un chemin dans le plateau
	 */
	public void genererRetour() {
		ArrayList<Integer> list = new ArrayList<>();
		Random rand = new Random();
		int randint = rand.nextInt(100);
		if (y - 2 >= 0 		   	  && lab[x][y - 2] 	== null)
			list.add(0);
		if (x + 2 < lab.length 	  && lab[x + 2][y]	== null )
			list.add(1);
		if (y + 2 < lab[0].length && lab[x][y + 2] 	== null )
			list.add(2);
		if (x - 2 >= 0 			   && lab[x - 2][y] == null)
			list.add(3);
		if (list.size() != 0) {
			randint = list.get(rand.nextInt(list.size()));
			switch (randint) {
			case 0:
				lab[x][y - 1] 		= new Sol();
				traverser[x][y - 1] = true;
				lab[x][y - 2] 		= new Sol();
				traverser[x][y - 2] = true;
				y -= 2;
				break;
			case 1:
				lab[x + 1][y] 		= new Sol();
				traverser[x + 1][y] = true;
				lab[x + 2][y]		= new Sol();
				traverser[x + 2][y] = true;
				x += 2;
				break;
			case 2:
				lab[x][y + 1]		= new Sol();
				traverser[x][y + 1] = true;
				lab[x][y + 2]		= new Sol();
				traverser[x][y + 2] = true;
				y += 2;
				break;
			case 3:
				lab[x - 1][y] 		= new Sol();
				traverser[x - 1][y] = true;
				lab[x - 2][y] 		= new Sol();
				traverser[x - 2][y] = true;
				x -= 2;
				break;
			default:
				break;
			}
		} else {
			list.clear();
			if (y - 1 >= 0 && lab[x][y - 1] 			!= null && traverser[x][y - 1])
				list.add(0);
			if (x + 1 < lab.length && lab[x + 1][y] 	!= null && traverser[x + 1][y])
				list.add(1);
			if (y + 1 < lab[0].length && lab[x][y + 1]  != null && traverser[x][y + 1])
				list.add(2);
			if (x - 1 >= 0 && lab[x - 1][y] 			!= null && traverser[x - 1][y])
				list.add(3);
			switch (list.get(0)) {
			case 0:
				traverser[x][y - 1] = false;
				traverser[x][y] 	= false ;
				y -= 2;
				break;
			case 1:
				traverser[x + 1][y] = false;
				traverser[x][y] 	= false;
				x += 2;
				break;
			case 2:
				traverser[x][y + 1] = false;
				traverser[x][y]	    = false;
				y += 2;
				break;
			case 3:
				traverser[x - 1][y] = false;
				traverser[x][y] 	= false;
				x -= 2;
				break;
			default:
				break;
			}
		}
	}

}
