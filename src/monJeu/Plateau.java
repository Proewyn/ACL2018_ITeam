package monJeu;

public class Plateau {

	private Case[][] laby = {
				{new Mur(), new Mur(), new Mur(), new Mur(), new Mur()},
				{new Mur(), new Sol(), new Sol(), new Sol(), new Mur()},
				{new Mur(), new Sol(), new Sol(), new Sol(), new Mur()},
				{new Mur(), new Sol(), new Sol(), new Sol(), new Mur()},
				{new Mur(), new Mur(), new Mur(), new Mur(), new Mur()}
			};
	
	
	public Case[][] getLaby(){
		return laby;
	}
	
	public boolean collision(int x, int y) {
		return !laby[x][y].isTraversable();
	}
	
}
