package personnage;

public interface Personnage {
	
	public void deplacer(int x2, int y2);
	public int getX();
	public int getY();
	public int getHp();
	public int getId();
	public void setHp(int hp);
	
}
