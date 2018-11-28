package moteurJeu;

/**
 * represente un jeu un jeu est caracterise par la methode evoluer a redefinir
 * 
 * @author Graou
 *
 */
public interface Jeu {

	/**
	 * Fait avancer le jeu, deplace les personnages, monstres
	 * @param commandeUser Donne le deplacement du héro
	 */
	public void evoluer(Commande commandeUser);
	
	/**
	 * @return true si et seulement si le jeu est fini
	 */
	public boolean etreFini();
	
}
