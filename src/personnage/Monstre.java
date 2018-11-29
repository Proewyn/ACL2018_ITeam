package personnage;

import java.awt.Point;

import monJeu.MonJeu;
import moteurJeu.Commande;

import ia.DeplacementMonstre;

/**
 * @author levy54u
 *
 */
public abstract class Monstre implements Personnage {
	
	private int x;
	private int y;
	private int Hp;
		
	protected DeplacementMonstre ia;
	
	/**
	 * Constructeur par defaut
	 * @param ia IA pour le monstre cree
	 */
	public Monstre(DeplacementMonstre ia) {
		this.ia = ia;
		this.x = 0;
		this.y  = 0;
		this.Hp = 1;
	}
	
	/**
	 * Cree un monstre avec une position
	 * @param x position en X
	 * @param y position en Y
	 * @param ia IA pour le monstre cree
	 */
	public Monstre(int x, int y, DeplacementMonstre ia){
		this.x = x;
		this.y = y;
		this.Hp = 1;
		this.ia = ia;
	}

	public abstract Point deplacer(MonJeu m , Commande c);
	
	@Override
	public void deplacer(int x2, int y2){
		this.setX(x2);
		this.setY(y2);
	}

	/**
	 * Place le monstre sur une ligne donnee
	 * @param y2 position en Y
	 */
	private void setY(int y2) {
		this.y = y2;
	}

	/**
	 * Place le monstre sur une colonne donnee
	 * @param x2 position en X
	 */
	private void setX(int x2) {
		this.x = x2;
	}
	
	@Override
	public void setHp(int hp) {
		this.Hp = hp;
	}
	
	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}
	
	@Override
	public int getHp() {
		return this.Hp;
	}

	public boolean collision(int x2, int y2) {
		return x==x2 && y==y2;
	}

}
