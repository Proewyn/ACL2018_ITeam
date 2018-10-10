package monJeu;

public class Sol implements Case{

	private boolean traversable = true;
	private int id = SOL;
	
	public boolean isTraversable() {
		return true;
	}

	public int getId() {
		return 0;
	}

	@Override
	public boolean isMur() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
