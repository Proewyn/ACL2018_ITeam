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
 * classe qui contient les donnees du jeu. Pour le moment, il ne possede qu'un personnage
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
	 * Constructeur par defaut 
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
	 * Constructeur avec un plateau donnee
	 * @param plateau donnee en entree pour initialiser le labyrinthe
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
	 * Fait avancer le jeu, deplace les personnages, monstres
	 * @param commande chaine qui donne le deplacement du hero
	 */
	public void evoluer(Commande commande) {
		int x= pj.getX();
		int y= pj.getY();
		this.attaques.deplacement(this);
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
			if (commande.gauche) {
				if(commande.attaque&& !plateau.collision(x-1, y)) {
					attaques.addAttaque(new Flamme(x-1, y, commande));
				}
			}
			if (commande.droite) {
				if(commande.attaque && !plateau.collision(x+1, y)) {
					attaques.addAttaque(new Flamme(x+1, y, commande));
				}
			}
			if(commande.haut) {
				if(commande.attaque && !plateau.collision(x, y-1)) {
					attaques.addAttaque(new Flamme(x, y-1, commande));
				}
			}
			if(commande.bas) {
				if(commande.attaque&& !plateau.collision(x, y+1)) {
					attaques.addAttaque(new Flamme(x, y+1, commande));
				}
			}
		}
		listeDObjets.collision(this, x, y);
		//fait deplacer les monstre
		for(Monstre m : this.getMonstre()) {
			this.deplacerMonstre(new DeplacementMiroir(), new DeplacementNaif(), m, commande);
		}
		if (!(commande.gauche||commande.droite||commande.haut||commande.bas)&& commande.attaque){
			Commande cg = new Commande();
			Commande cd = new Commande();
			Commande ch = new Commande();
			Commande cb = new Commande();
				if(!plateau.collision(x-1, y)) {
					cg.gauche=true;
					cg.droite=false;
					cg.haut=false;
					cg.bas=false;
					attaques.addAttaque(new Flamme(x-1, y,cg ));
				}
			
				if(!plateau.collision(x+1, y)) {
					cd.gauche=false;
					cd.droite=true;
					cd.haut=false;
					cd.bas=false;
					attaques.addAttaque(new Flamme(x+1, y, cd));
				}
			
				if( !plateau.collision(x, y-1)) {
					ch.gauche=false;
					ch.droite=false;
					ch.haut=true;
					ch.bas=false;
					attaques.addAttaque(new Flamme(x, y-1, ch));
				}
			
				if( !plateau.collision(x, y+1)) {
					cb.gauche=false;
					cb.droite=false;
					cb.haut=false;
					cb.bas=true;
					attaques.addAttaque(new Flamme(x, y+1, cb));
				}
			
		}
		
		this.cleanMonstre(this.getMonstre());
		this.maj();
	}
	
	/**
	 * Ajoute different type de monstres
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
	 * Deplace les monstres en fonction d'une IA
	 * @param iaZombi generant le prochain deplacement des zombis
	 * @param iaFantome generant le prochain deplacement des fantomes
	 * @param m le monstre a deplacer
	 * @param c la derniere commande effectue par le hero
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
			if ((!(x < 0 || y < 0 || x > Bibliotheque.TAILLE_TABLEAUX - 1 || y > Bibliotheque.TAILLE_TABLEAUY - 1))
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
	
	/**
	 * Detecte la colision entre l'entite et un monstre
	 * @param x coordonnee en X
	 * @param y coordonnee en Y
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
	 * Detecte la colision entre l'entite et un hero
	 * @param x coordonnee en X
	 * @param y coordonnee en Y
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
		return plateau;
	}

	/**
	 * Initialise un labyrinthe a partir d'un fichier
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	public void initLabyFichier() throws FileNotFoundException, InterruptedException {
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
	 * Ajoute un monstra a la liste des monstre
	 * @param m monstre a ajouter
	 */
	public void addMonstres(Monstre m) {
		this.monstres.add(m);
	}

	/**
	 * Donne un point alea dans le plateau
	 * @return un point aleatoire sur le plateau en dehors des murs
	 */
	private Point pointAlea() {
		Point alea = new Point();
		
		int xRand = (int) (Math.random() * Bibliotheque.TAILLE_TABLEAUX);
		int yRand = (int) (Math.random() * Bibliotheque.TAILLE_TABLEAUY);
		
		while(this.plateau.isMur(xRand, yRand)) {
			xRand = (int) (Math.random() * Bibliotheque.TAILLE_TABLEAUX);
			yRand = (int) (Math.random() * Bibliotheque.TAILLE_TABLEAUY);
		}
		alea.setLocation(xRand, yRand);
		return alea;
	}

	/**
	 * Ajoute un monstre qui est place aleatoirement sur le plateau
	 * @param m le monstre a placer
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
	 * Met a jour les vues
	 */
	public void maj()
	{
		setChanged();
		notifyObservers(true);
	}
	
	/**
	 * Inflige les degats lie a la colision
	 * @param monster monstre ayant subi/provoque la colision
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
