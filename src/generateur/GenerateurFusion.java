package generateur;

import java.util.Random;

import plateau.Mur;
import plateau.Sol;


public class GenerateurFusion extends AbstractGenerateur{

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
	}

}
