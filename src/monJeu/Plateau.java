package monJeu;

import Generateur.Generateur;

public class Plateau {

	private Case[][] laby;
	
	public Plateau (int taillex,int tailley){
		initLaby(taillex,tailley);
	}
	
	private void initLaby(int taillex,int tailley) {
		
		Generateur gen = new Generateur(taillex, tailley);
		laby = gen.getLab();
		/*
		laby = new Case[taillex][tailley];
		for (int i=0;i<tailley;i++){
			laby[0][i]=new Mur(true);
			laby[taillex-1][i]=new Mur(true);
		}
		
		for (int i=1;i<taillex-1;i++){
			laby[i][0]=new Mur(true);
			for (int j=1;j<tailley-1;j++){
				laby[i][j]=new Sol();
			}
			laby[i][tailley-1]=new Mur(true);
		}
		laby[4][6]=new Mur();
		laby[5][5]=new Mur();
		laby[4][4]=new Mur();
		laby[3][5]=new Mur();*/
	}

	public Case[][] getLaby(){
		return laby;
	}
	
	public boolean collision(int x, int y) {
		if(x < 0 || y < 0)
			return false;
		return !laby[x][y].isTraversable();
	}

	public int taillePlateaux() {
		// TODO Auto-generated method stub
		return laby.length;
	}

	public int taillePlateauy() {
		// TODO Auto-generated method stub
		return laby[0].length;
	}

	public boolean isMur(int i, int j) {
		// TODO Auto-generated method stub
		return laby[i][j].getId() == Bibliotheque.MUR;
	}
	
	public void printLab(){
		for (int i = 0; i < laby.length; i++) {
			for (int j = 0; j < laby[0].length; j++) {
				System.out.print(laby[i][j].getId()+" ");
			}
			System.out.println();
		}
	}
	
}
