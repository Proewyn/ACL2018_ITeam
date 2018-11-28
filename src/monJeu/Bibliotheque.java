package monJeu;

public class Bibliotheque {
 
	public static final int JOUEUR  = 0;
	public static final int MUR 	= 1;
	public static final int SOL 	= 2;
	public static final int SPAWN 	= 4;
	public static final int ZOMBI   = 8;
	public static final int FANTOME = 16;
	
	//id des objets
	public static final int TORCHE = 21;
	public static final int TELEPORTEUR = 22;
	public static final int COFFRE = 23;
	public static final int PORTE = 24;
	public static final int TORCHESUPPREME = 25;
	public static final int COFFRECLE = 26;

	//id attaques
	public static final int ATTAQUE = 27;
	
	//parametre graphique
	public static final int TAILLE_CASE = 35;
	public static final int TAILLE_OBJET = TAILLE_CASE/2 ;
	public static boolean VUEPLATEAUENTIERDEFAULT = false;
	public static int TIMERRAFRAICHISSEMENTMS = 100;
	
	//donnée physique
	public static int TAILLE_TABLEAUX = 101;	
	public static int TAILLE_TABLEAUY = 101;	
	public static final int NBMONSTRE = 30;
	public static final int NBOBJET = 50;
	public static final int DISTANCEVUEMONSTRE = 10;
	public static int VUE_LARGEUR = 21;
	public static int VUE_HAUTEUR = 21;
	public static double POURCENTFANTOM  = 50;
	public static int POINTDEVIEBASEHERO = 10;
	
	/**
	 * 1 : Generateur WormHole
	 * 2 : Generateur WormHoleImparfait
	 * 3 : Generateur Cancer
	 * 4 : Generateur Fusion
	 */
	public static final int GENERATEUR = 2;
	
	public static void setTaillePlateauX (int x) {
		TAILLE_TABLEAUX = x;
	}
	
	public static void setTaillePlateauY (int y) {
		TAILLE_TABLEAUY = y ;
	}
	
}
