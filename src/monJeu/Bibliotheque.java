package monJeu;

public class Bibliotheque {
 
	public static final int JOUEUR  = 0;
	public static final int MUR 	= 1;
	public static final int SOL 	= 2;
	public static final int SPAWN 	= 4;
	public static final int ZOMBI   = 8;
	
	//id des objets
	public static final int TORCHE = 21;
	public static final int TELEPORTEUR = 22;
	public static final int COFFRE = 23;

	
	//parametre graphique
	public static final int TAILLE_CASE = 10;
	public static final int TAILLE_OBJET =  TAILLE_CASE/2 ;
	

	//donnée physique
	public static int TAILLE_TABLEAUX = 51;	
	public static int TAILLE_TABLEAUY = 51;	
	public static final int NBMONSTRE = 100;
	public static final int NBOBJET=20;
	
	/**
	 * 1 : Generateur wormhole
	 * 2 : Generateur wormholeImparfait
	 * 3 : Generateur Cancer
	 * 4 : Generateur Fusion
	 */
	public static final int GENERATEUR = 2;
}
