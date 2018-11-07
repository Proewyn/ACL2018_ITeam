package monJeu;
/**
 * la classe correspondant au Personnage
 */
public class Hero implements Personnage {

	private int x;
	private int y;
	private int hp;
	private int vision; 
	
	
	/**
	 * constructeur vide
	 */
	public Hero() {
		this.x = 1;
		this.y = 1;
		this.hp = 10;
		this.vision = 5;
		
	}
	
	public Hero(int x , int y) {
		this.x = x;
		this.y = y;
		this.hp = 10;
		this.vision = 5;
	}

	public String toString() {
		return ("(" + this.x+","+this.y+")");
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	private void setX(int x) {
		this.x = x;
	}
	
	private void setY(int y) {
		this.y = y;
	}
	
	public void deplacer(int x2, int y2) {
		this.setX(x2);
		this.setY(y2);
	}
	
	public int getHp() {
		return hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
		
	public int getVision() {
		return vision;
	}
	
	public void setVision(int vision) {
		this.vision = vision;
	}

	@Override
	public int getId() {
		return Bibliotheque.JOUEUR;
	}
}
