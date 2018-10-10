package monJeu;

public class Plateau {

	private Case[][] laby;
	
	public Plateau (int taillex,int tailley){
		initLaby(taillex,tailley);
		
	}
	
	private void initLaby(int taillex,int tailley) {
		laby = new Case[taillex][tailley];
		for (int i=0;i<tailley;i++){
			laby[0][i]=new Mur();
			laby[taillex-1][i]=new Mur();
		}
		
		for (int i=1;i<taillex-1;i++){
			laby[i][0]=new Mur();
			for (int j=1;j<tailley-1;j++){
				laby[i][j]=new Sol();
			}
			laby[i][tailley-1]=new Mur();
		}
	}

	public Case[][] getLaby(){
		return laby;
	}
	
	public boolean collision(int x, int y) {
		return !laby[x][y].isTraversable();
	}
	
}
