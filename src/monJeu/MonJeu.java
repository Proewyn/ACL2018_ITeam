package monJeu;

import ia.*;

import java.awt.Point;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import attaque.LesAttaques;
import attaque.aDistance.AttaqueADistance;
import attaque.aDistance.Flamme;

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
	private LesAttaques attaques;
	private boolean voirPlateauEntier;
	private boolean gagne;
	private boolean newJeu;
	
	/**
	 * Constructeur par défaut 
	 */
	public MonJeu() {		
		this.plateau=new Plateau();
		this.monstres = new ArrayList<>(); //initialise la liste de monstre
		this.ajoutMonstre();
		Point p = plateau.getSpawn();
		this.pj = new Hero(p.x, p.y);
		voirPlateauEntier= false;
		this.listeDObjets= new Objets(new ArrayList<Objet>(), Bibliotheque.NBOBJET, plateau);
		gagne = false;
		newJeu = false;
		attaques = new LesAttaques(new ArrayList<AttaqueADistance>());
	}
	
	

	/**
	 * Constructeur avec un plateau donnée
	 * @param plateau donnée en entrée pour initialiser le labyrinthe
	 */
	public MonJeu(Plateau plateau) {	
		this.plateau=plateau;
		this.monstres = new ArrayList<>(); //initialise la liste de monstre
		this.ajoutMonstre();
		Point p = plateau.getSpawn();
		this.pj = new Hero(p.x, p.y);
		voirPlateauEntier= false;
		this.listeDObjets= new Objets(new ArrayList<Objet>(), Bibliotheque.NBOBJET, plateau);
		gagne = false;
	}

	/**
	 * Fait avancer le jeu, déplace les personnages, monstres
	 * @param commande chaine qui donne le déplacement du héro
	 */
	public void evoluer(Commande commande) {
		int x= pj.getX();
		int y= pj.getY();
		this.attaques.deplacement(this);
		if (commande.gauche) {
			x--;
			if(commande.attaque&& !plateau.collision(x, y)) {
				attaques.addAttaque(new Flamme(x-1, y, commande));
			}
		}
		if (commande.droite) {
			x++;
			if(commande.attaque && !plateau.collision(x, y)) {
				attaques.addAttaque(new Flamme(x+1, y, commande));
			}
		}
		if(commande.haut) {
			y--;
			if(commande.attaque && !plateau.collision(x, y)) {
				attaques.addAttaque(new Flamme(x, y-1, commande));
			}
		}
		if(commande.bas) {
			y++;
			if(commande.attaque&& !plateau.collision(x, y)) {
				attaques.addAttaque(new Flamme(x, y+1, commande));
			}
		}

		
		
		if ((commande.gauche||commande.droite||commande.haut||commande.bas)&&!plateau.collision(x, y)) {
			if(!this.collisionMonstre(x, y, false)) {
				this.getPj().deplacer(x,y);
			}
		}
		listeDObjets.collision(this, x, y);
		//fait deplacer les monstre
		for(Monstre m : this.getMonstre()) {
			this.deplacerMonstre(new DeplacementMiroir(), new DeplacementNaif(), m, commande);
		}
		
		this.cleanMonstre(this.getMonstre());
		this.maj();
	}
	
	/**
	 * Ajoute différent type de monstres
	 */
	private void ajoutMonstre() {
		Random r = new Random();
		double rand = r.nextDouble();
		double nbFantome = 0.4;
		
		for(int i = 0 ; i < Bibliotheque.NBMONSTRE ; i++) {
			rand = r.nextDouble();
			if(rand < (nbFantome)){
				this.addMonstreRand(new Fantome()); //ajout de fantome
			}else{
				this.addMonstreRand(new Zombi()); // ajout de zombi
			}
		}
		
	}
	
	/**
	 * Déplace les monstres en fonction d'une IA
	 * @param iaZombi générant le prochain déplacement des zombis
	 * @param iaFantome générant le prochain déplacement des fantomes
	 * @param m le monstre à déplacer
	 * @param c la dernière commande effectué par le héro
	 */
	public void deplacerMonstre(DeplacementMonstre iaZombi,
			DeplacementMonstre iaFantome, Monstre m, Commande c) {
		Point p = iaZombi.deplacer(this, m, c);
		int x = (int) p.getX();
		int y = (int) p.getY();
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
		return (this.getPj().getHp() <= 0) || gagne;
	}

	public Hero getPj() {
		return pj;
	}

	public ArrayList<Monstre> getMonstre() {
		return this.monstres;
	}
	

	//Si l'entité touche un monstre
	/**
	 * Détecte la colision entre l'entité et un monstre
	 * @param x coordonnée en X
	 * @param y coordonnée en Y
	 * @param estMonstre Si on teste la colision par un monstre
	 * @return s'il y a ou non colision
	 */
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
	
	/**
	 * Détecte la colision entre l'entité et un héro
	 * @param x coordonnée en X
	 * @param y coordonnée en Y
	 * @return s'il y a ou non colision
	 */
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

	/**
	 * Initialise un labyrinthe à partir d'un fichier
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
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

	/**
	 * Ajoute un monstre à la liste des monstre
	 * @param m monstre à ajouter
	 */
	public void addMonstres(Monstre m) {
		this.monstres.add(m);
	}

	/**
	 * Donne un point aléa dans le plateau
	 * @return un point aleatoire sur le plateau en dehors des murs
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

	/**
	 * Ajoute un monstre qui est placé aléatoirement sur le plateau
	 * @param m le monstre à placer
	 */
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
	
	/**
	 * Met à jour les vues
	 */
	public void maj()
	{
		setChanged();
		notifyObservers(true);
	}
	
	/**
	 * Inflige les dégats lié à la colision
	 * @param monster monstre ayant subi/provoqué la colision
	 */
	private void dommageCollision(Monstre monster) {
		monster.setHp(monster.getHp()-1);
		this.getPj().setHp(this.getPj().getHp()-1);
	}
	
	/**
	 * Efface les monstres morts de la liste des monstres
	 * @param lm liste contenant les monstres
	 */
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
	
	public LesAttaques getAttaques() {
		return attaques;
	}

	/**
	 * surcharge toString
	 */
	public String toString() {
		return ("" + this.getPj());
	}
}
