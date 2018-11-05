package Generateur;

import monJeu.Case;
import monJeu.Mur;

public abstract class AbstractGenerateur {

	
	protected Case[][] lab;
	protected int x = 10;
	protected int y = 10;
	
	public AbstractGenerateur(int sizeX, int sizeY) {
		lab = new Case[sizeX-2][sizeY-2];
	}
	
	public Case[][] getLab(){
		generer();
		addBordure();
		return lab;
	}
	
	public abstract void generer();
	
	public void addBordure(){
		Case[][] lab2 = new Case[lab.length+1][lab[0].length+1];
		for (int i = 0; i < lab.length; i++) {
			for (int j = 0; j < lab[0].length; j++) {
				lab2[i+1][j+1] = lab[i][j];
			}
		}
		for (int i = 0; i < lab2.length; i++) {
			lab2[i][0] = new Mur(true);
			lab2[i][lab2[0].length-1] = new Mur(true);
		}
		for (int i = 0; i < lab2[0].length; i++) {
			lab2[0][i] = new Mur(true);
			lab2[lab2.length-1][i] = new Mur(true);
		}
		lab = lab2;
	}
}
