package personnage;

import java.awt.Point;

import ia.DeplacementMonstre;
import monJeu.Bibliotheque;
import monJeu.MonJeu;
import moteurJeu.Commande;

/**
 * @author damien
 *
 */
public class Fantome extends Monstre {

	/**
	 * Constructeur par defaut
	 * @param ia IA pour le fantome cree
	 */
	public Fantome(DeplacementMonstre ia) {
		super(ia);
	}

	/**
	 * Constructeur avec position
	 * @param x position en X
	 * @param y psoition en Y
	 * @param ia IA pour le fantome cree
	 */
	public Fantome(int x, int y, DeplacementMonstre ia) {
		super(x, y, ia);
	}

	@Override
	public int getId() {
		return Bibliotheque.FANTOME;
	}

	@Override
	public Point deplacer(MonJeu m , Commande c) {
		return this.ia.deplacer(m, this, c);
	}

}
