package monJeu;

import ia.DeplacementMiroir;
import ia.DeplacementMonstre;
import ia.DeplacementPathfinding;
import ia.DeplacementNaif;
import ia.DeplacementPathfindingFantom;

import java.awt.Point;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import moteurJeu.Commande;
import moteurJeu.Jeu;
import objet.Objet;
import objet.Objets;
import personnage.Fantome;
import personnage.Hero;
import personnage.Monstre;
import personnage.Zombi;
import plateau.Plateau;

/**
 * classe qui contient les donnees du jeu. Pour le moment, il ne possede qu'un
 * personnage
 *
 */
public class MonJeu extends Observable implements Jeu {

	private Hero pj;
	private Plateau plateau;
	private ArrayList<Monstre> monstres;
	private Objets listeDObjets;
	
	/**
	 * boolean pour savoir si on peut voir tout le pateau
	 */
	private boolean voirPlateauEntier;
	private boolean gagne;
	private boolean newJeu;
	
	public MonJeu() {		
		this.plateau=new Plateau();
		this.monstres = new ArrayList<>(); //initialise la liste de monstre
		this.ajoutMonstre();
		Point p = plateau.getSpawn();
		this.pj = new Hero(p.x, p.y);
		voirPlateauEntier= Bibliotheque.VUEPLATEAUENTIERDEFAULT;
		this.listeDObjets= new Objets(new ArrayList<Objet>(), Bibliotheque.NBOBJET, plateau);
		gagne = false;
		newJeu = false;
	}
	
	public MonJeu(Plateau plateau) {	
		this.plateau=plateau;
		this.monstres = new ArrayList<>(); //initialise la liste de monstre
		this.ajoutMonstre();
		Point p = plateau.getSpawn();
		this.pj = new Hero(p.x, p.y);
		voirPlateauEntier= Bibliotheque.VUEPLATEAUENTIERDEFAULT;
		this.listeDObjets= new Objets(new ArrayList<Objet>(), Bibliotheque.NBOBJET, plateau);
		gagne = false;
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
		if (commande.gauche) {
			x--;
		}
		if (commande.droite) {
			x++;
		}
		if(commande.haut) {
			y--;
		}
		if(commande.bas) {
			y++;
		}
		if ((commande.gauche||commande.droite||commande.haut||commande.bas)&&!plateau.collision(x, y)) {
			if(!this.collisionMonstre(x, y, false)) {
				this.getPj().deplacer(x,y);
			}
		}
		listeDObjets.collision(this, x, y);
		//fait deplacer les monstre
		for(Monstre m : this.getMonstre()) {
			this.deplacerMonstre(new DeplacementPathfinding(), new DeplacementPathfindingFantom(), m, commande);
		}
		this.cleanMonstre(this.getMonstre());
		this.maj();
	}
	
	private void ajoutMonstre() {
		Random r = new Random();
		int rand;
		for(int i = 0 ; i < Bibliotheque.NBMONSTRE ; i++) {
			rand = r.nextInt(100);
			if(rand < Bibliotheque.POURCENTFANTOM){
				this.addMonstreRand(new Fantome()); //ajout de fantome
			}else{
				this.addMonstreRand(new Zombi()); // ajout de zombi
			}
		}
		
	}
	
	public void deplacerMonstre(DeplacementMonstre iaZombi,
			DeplacementMonstre iaFantome, Monstre m, Commande c) {
		
		Point p;
		int x,y;
		if (m.getId() == Bibliotheque.FANTOME) {
			p = iaFantome.deplacer(this, m, c);
			x = (int) p.getX();
			y = (int) p.getY();
			if ((!(x < 0 || y < 0 || x > plateau.taillePlateaux() - 1 || y > plateau.taillePlateauy() - 1))
					&& (!this.collisionHero(x, y))
					&& (!this.collisionMonstre(x, y, true))) {
				m.deplacer(x, y);
			}
		} else {
			p = iaZombi.deplacer(this, m, c);
			x = (int) p.getX();
			y = (int) p.getY();
			if ((!plateau.collision(x, y)) && (!this.collisionHero(x, y))
					&& (!this.collisionMonstre(x, y, true))) {
				m.deplacer(x, y);
			}
		}
		if (this.collisionHero(x, y) && m.getHp() > 0) {
			this.dommageCollision(m);
		}
	}

	@Override
	public boolean etreFini() {
		return (this.getPj().getHp() <= 0)||gagne;
	}

	/**
	 * getter pour l'affichage
	 * 
	 * @return personnage du jeu
	 */
	public Hero getPj() {
		return pj;
	}

	public ArrayList<Monstre> getMonstre() {
		return this.monstres;
	}
	
	//Si l'entité touche un monstre
	private boolean collisionMonstre(int x, int y, boolean estMonstre) {
		boolean b = false;
		for (Monstre m : this.monstres) {
			if(m.getX() == x && m.getY() == y) {
				b = true;
				if (!estMonstre) {
					this.dommageCollision(m);
				}
			}
		}
		return b;
	}
	
	//Si l'entité touche un hero
	private boolean collisionHero(int x, int y) {
		boolean b = false;
		if(this.getPj().getX() == x && this.getPj().getY() == y) {
			b = true ;
		}
		return b;
	}
	
	public Plateau getPlateau() {
		// TODO Auto-generated method stub
		return plateau;
	}

	public void initLabyFichier() throws FileNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		plateau.initLabyFichier(this);
	}
	
	public boolean isGagne() {
		return gagne;
	}

	public void setGagne(boolean gagne) {
		this.gagne = gagne;
	}

	public boolean isNewJeu() {
		return newJeu;
	}

	public void setNewJeu(boolean newJeu) {
		this.newJeu = newJeu;
	}

	public void addMonstres(Monstre m) {
		this.monstres.add(m);
	}

	/**
	 * 
	 * @return un point aleatoire sur le plateau en dehors des murs
	 * 
	 */
	private Point pointAlea() {
		Point alea = new Point();
		
		int xRand = (int) (Math.random() * this.plateau.taillePlateaux());
		int yRand = (int) (Math.random() * this.plateau.taillePlateauy());
		
		while(this.plateau.isMur(xRand, yRand)) {
			xRand = (int) (Math.random() * this.plateau.taillePlateaux());
			yRand = (int) (Math.random() * this.plateau.taillePlateauy());
		}
		alea.setLocation(xRand, yRand);
		return alea;
	}

	public void addMonstreRand(Monstre m) {
		Point alea = pointAlea();
		m.deplacer((int)alea.getX(), (int)alea.getY());
		this.addMonstres(m);
	}
	
	public boolean getVoirPlateauEntier() {
		return voirPlateauEntier;
	}

	public void setVoirPlateauEntier(boolean voirPlateauEntier) {
		this.voirPlateauEntier = voirPlateauEntier;
	}
	
	public Objets getListeDObjets() {
		return listeDObjets;
	}
	
	public void maj()
	{
		setChanged();
		notifyObservers(true);
	}
	
	private void dommageCollision(Monstre monster) {
		monster.setHp(monster.getHp()-1);
		this.getPj().setHp(this.getPj().getHp()-1);
	}
	
	private void cleanMonstre(ArrayList<Monstre> lm) {
		int i = 0;
		while (i < lm.size()) {
			if (lm.get(i).getHp() <= 0) {
				lm.remove(i);
			}
			else {
				i++;
			}
		}
	}

}
