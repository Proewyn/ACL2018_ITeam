package monJeu;

public class Bibliotheque {
 
	public static final int JOUEUR  = 0;
	public static final int MUR 	= 1;
	public static final int SOL 	= 2;
	public static final int SPAWN 	= 4;
	public static final int ZOMBI   = 8;
	public static final int FANTOME = 16;
	
	//id des objets
	public static final int TORCHE      = 21;
	public static final int TELEPORTEUR = 22;
	public static final int COFFRE      = 23;
	public static final int PORTE = 24;
	public static final int TORCHESUPPREME = 25;
	public static final int COFFRECLE      = 26;
	
	//parametre graphique
	public static final int TAILLE_CASE  = 35;
	public static final int TAILLE_OBJET = TAILLE_CASE/2 ;
	
	//donnée physique
	public static int TAILLE_TABLEAUX = 51;	
	public static int TAILLE_TABLEAUY = 51;	
	public static final int NBMONSTRE = 30;
	public static final int NBOBJET   = 50;
	public static final int DISTANCEVUEMONSTRE = 10;
	public static int VUE_LARGEUR = 21;
	public static int VUE_HAUTEUR = 21;
	
	/**
	 * 1 : Generateur WormHole
	 * 2 : Generateur WormHoleImparfait
	 * 3 : Generateur Cancer
	 * 4 : Generateur Fusion
	 */
	public static final int GENERATEUR = 2;
	
}
