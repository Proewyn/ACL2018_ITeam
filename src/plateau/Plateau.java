package plateau;

import generateur.*;

import java.awt.Point;
import javax.swing.JOptionPane;

import monJeu.Bibliotheque;

public class Plateau {

	private Case[][] laby;

	/**
	 * Constructeur par defaut
	 * Le labyrinthe se cree en fonction du choix de l'utilisateur
	 */
	public Plateau (){
		String[] choices = { "Labyrinthe parfait", "Labyrinthe imparfait"};
		String input = (String) JOptionPane.showInputDialog(null, "Choix du type de labyrinthe",
				"", JOptionPane.QUESTION_MESSAGE, null, 
				choices, // Array of choices
				choices[1]); // Initial choice
		int g = 2;
		switch(input) {
			case "Labyrinthe parfait":
				g = 1;
				break;
			case "Labyrinthe imparfait":
				g = 2;
				break;
			default :
				g = Bibliotheque.GENERATEUR;
		}
		initLabyGenerateur(g);
	}

	public Point getSpawn(){
		Point p = new Point(10,10);
		for (int i = 0; i < laby.length; i++) {
			for (int j = 0; j < laby[0].length; j++) {
				if(laby[i][j].getId() == Bibliotheque.SPAWN) {
					p = new Point(i,j);
				}
			}
		}
		return p;
	}

	public Case[][] getLaby(){
		return laby;
	}

	public void setLaby(Case[][] laby) {
		this.laby = laby;
	}

	/**
	 * Detecte s'il est possible d'aller sur un case
	 * @param x position en X
	 * @param y position en Y
	 * @return s'il y a colision ou non
	 */
	public boolean collision(int x, int y) {
		if(x < 0 || y < 0)
			return false;
		return !laby[x][y].isTraversable();
	}

	/**
	 * Regarde si la case est un mur
	 * @param i position en Y
	 * @param j position en X
	 * @return si la case est un mur ou non
	 */
	public boolean isMur(int i, int j) {
		return laby[i][j].getId() == Bibliotheque.MUR;
	}

	/**
	 * Initialise un labyrinthe a partir d'un generateur
	 */
	public void initLabyGenerateur(int i) {
		AbstractGenerateur gen;
		switch (i) {
		case 1:
			gen = new GenerateurWormHole();
			break;
		case 2:
			gen = new GenerateurWormHoleImparfait();
			break;
		default:
			gen = new GenerateurWormHole();
			break;
		}
		laby = gen.getLab();
	}

}
