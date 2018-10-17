package monJeu;

import moteurJeu.Commande;
import moteurJeu.Jeu;

/**
 * classe qui contient les donnees du jeu. Pour le moment, il ne possede qu'un
 * personnage
 *
 */
public class MonJeu implements Jeu {

	/**
	 * le personnage du jeu
	 */
	private Hero pj;
	
	/**
	 * le plateau de jeux
	 */
	private Plateau plateau;

	private Monstre zombi;
	/**
	 * constructeur de jeu avec un Personnage
	 */
	public MonJeu() {

		this.pj=new Hero();		
		this.zombi = new Zombi(10,12);
		this.plateau=new Plateau(80, 80);
	}

	/**
	 * surcharge toString
	 */
	public String toString() {
		return ("" + this.getPj());
	}

	/**
	 * demande a deplacer le personnage
	 * 
	 * @param commande
	 *            chaine qui donne ordre
	 */
	public void evoluer(Commande commande) {
		int x= pj.getX();
		int y= pj.getY();
		if (commande.gauche){
			x--;
		}
		if (commande.droite){
			x++;
		}
		if(commande.haut){
			y--;
		}
		if(commande.bas){
			y++;
		}
		if (!plateau.collision(x, y)){
			this.getPj().deplacer(x,y);
		}

	}

	@Override
	public boolean etreFini() {
		// le jeu n'est jamais fini
		return false;
	}

	/**
	 * getter pour l'affichage
	 * 
	 * @return personnage du jeu
	 */
	public Hero getPj() {
		return pj;
	}
	
	public Monstre getZombi(){
		return this.zombi;
	}

	public Plateau getPlateau() {
		// TODO Auto-generated method stub
		return plateau;
	}

}
