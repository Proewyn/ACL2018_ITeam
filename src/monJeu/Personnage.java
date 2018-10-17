package monJeu;

import moteurJeu.Commande;

public interface Personnage {
	
	public void deplacer(Commande c);
	public int getX();
	public int getY(); 
	

}
