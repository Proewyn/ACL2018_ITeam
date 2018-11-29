package personnage;

import java.awt.Point;

import ia.DeplacementMonstre;
import monJeu.Bibliotheque;
import monJeu.MonJeu;
import moteurJeu.Commande;

/**
 * @author levy54u
 *
 */
public class Zombi extends Monstre {

	/**
	 * Constructeur par defaut
	 * @param ia IA pour le zombi cree
	 */
	public Zombi(DeplacementMonstre ia) {
		super(ia);		
	}
	
	/**
	 * Constructeur avec une position
	 * @param x position en X
	 * @param y position en Y
	 * @param ia IA pour le zombi cree
	 */
	public Zombi(int x, int y, DeplacementMonstre ia) {
		super(x, y, ia);
	}

	@Override
	public int getId() {
		return Bibliotheque.ZOMBI;
	}

	@Override
	public Point deplacer(MonJeu m , Commande c) {
		return this.ia.deplacer(m, this, c);
	}

}
