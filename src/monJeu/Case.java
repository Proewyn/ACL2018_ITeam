package monJeu;

public interface Case {

	public static final int MUR = 0;
	public static final int SOL = 1;
	
	
	public boolean isTraversable();
	public int getId();
	public boolean isMur();
	
	
}
