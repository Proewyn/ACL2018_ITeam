package personnage;

public interface Personnage {
	
	/**
	 * Deplace un personnage
	 * @param x2 X ou mettre le personnage
	 * @param y2 Y ou mettre le personnage
	 */
	public void deplacer(int x2, int y2);
	
	public int getX();
	
	public int getY();
	
	public int getHp();
	
	public int getId();
	
	public void setHp(int hp);
	
}
