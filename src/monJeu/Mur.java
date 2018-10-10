package monJeu;

public class Mur implements Case{
	
	private boolean traversable = false;
	private int id = MUR;
	
	
	public boolean isTraversable() {
		return false;
	}

	public int getId() {
		return 0;
	}

	@Override
	public boolean isMur() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
