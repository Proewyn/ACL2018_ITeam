package generateur;

import java.util.Random;

import plateau.Mur;
import plateau.Sol;
import plateau.Spawn;;

public class GenerateurFusion extends AbstractGenerateur{

	/**
	 * Constructeur : Initialise un plateau avec un mur toute les 2 cases;
	 */
	public GenerateurFusion() {
		super();
		for (int i = 0; i < lab.length; i++) {
			for (int j = 0; j < lab[0].length; j++) {
				if(i%2 ==0 && j%2 ==0) {
					lab[i][j] = new Mur();
				} else {
					lab[i][j] = new Sol();
				}
			}
		}
	}

	
	/*
	 *Fusionne aleatoirement 2 murs en ajoutant un mur au milieu
	 */
	@Override
	public void generer() {
		Random r = new Random();
		for (int i = 0; i < lab.length; i++) {
			for (int j = 0; j < lab[0].length; j++) {
				if(i%2 ==0 && j%2 ==0) {
					switch(r.nextInt(3)) {
						case 0:
							if(i-1 > 0 ) {
								lab[i-1][j] = new Mur(); 
							}
							break;
						case 1:
							if(j-1 > 0) {
								lab[i][j-1] = new Mur(); 
							}
							break;
						case 2:
							if(i+1 < lab.length ) {
								lab[i+1][j] = new Mur(); 
							}
							break;
						case 3:
							if(j+1 < lab[0].length) {
								lab[i][j+1] = new Mur(); 
							}
							break;
						default: break;
					}

				} 
			}
		}
		x = (r.nextInt(lab.length)/2)*2;
		y = (r.nextInt(lab[0].length)/2)*2;
		lab[x][y] = new Spawn();
	}

}
