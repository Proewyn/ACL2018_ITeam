/**
 * 
 */
package monJeu;



/**
 * @author levy54u
 *
 */
public abstract class Monstre implements Personnage {
	private int x;
	private int y;
	

	public Monstre() {
		this.x = 0;
		this.y  = 0;
	}
	
	public Monstre(int x, int y){
		this.x = x;
		this.y = y;
	}


	public void deplacer(int x2, int y2){
		this.setX(x2);
		this.setY(y2);
	}

	
	private void setY(int y2) {
		// TODO Auto-generated method stub
		this.y = y2;
	}


	private void setX(int x2) {
		// TODO Auto-generated method stub
		this.x = x2;
	}


	@Override
	public int getX() {
		return this.x;
	}

		@Override
	public int getY() {
		return this.y;
	}

}
