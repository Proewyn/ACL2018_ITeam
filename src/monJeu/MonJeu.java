package monJeu;

import java.awt.List;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;

import moteurJeu.Commande;
import moteurJeu.Jeu;

/**
 * classe qui contient les donnees du jeu. Pour le moment, il ne possede qu'un
 * personnage
 *
 */
public class MonJeu extends Observable implements Jeu {

	/**
	 * le personnage du jeu
	 */
	private Hero pj;
	
	/**
	 * le plateau de jeux
	 */
	private Plateau plateau;

	//private Monstre zombi;
	private ArrayList<Monstre> monstres;
	/**
	 * constructeur de jeu avec un Personnage
	 */
	public MonJeu() {
		this.pj=new Hero();		
		//this.zombi = new Zombi(10,12);
		this.plateau=new Plateau(21, 21);
		this.monstres = new ArrayList<>(); //initialise la liste de monstre
		this.addMonstres(new Zombi(10,25)); // ajout de monstre
		this.addMonstres(new Zombi(15, 30));
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
			if(!this.collisionMonstre(x, y)) {
				this.getPj().deplacer(x,y);
			}
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
	/*
	public Monstre getZombi(){
		return this.zombi;
	}*/

	public ArrayList<Monstre> getMonstre() {
		return this.monstres;
	}
	
	private boolean collisionMonstre(int x, int y) {
		boolean b = false;
		for (Monstre m : this.monstres) {
			if(m.getX()==x && m.getY()==y) {
				b = true;
			}
		}
		return b;
	}
	
	public Plateau getPlateau() {
		// TODO Auto-generated method stub
		return plateau;
	}

	public void initLabyFichier() throws FileNotFoundException {
		// TODO Auto-generated method stub
		plateau.initLabyFichier();
	}
	
	public void addMonstres(Monstre m) {
		this.monstres.add(m);
	}
	

}
