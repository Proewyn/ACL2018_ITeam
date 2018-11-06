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
	public static int TAILLE_CASE = 10;
	public static int TAILLE_OBJET =  TAILLE_CASE/2 ;
	
	//donnée physique
	public static int TAILLE_TABLEAU = 51;	
	public static final int NBMONSTRE = 50;
}
