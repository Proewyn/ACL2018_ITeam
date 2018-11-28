package objet;

import monJeu.MonJeu;

public interface Objet {
	
	/**
	 * Regarde pour l'objet s'il y a colision avec le hero, lance l'action de l'objet si c'est le cas
	 * @param mj jeu dans lequel
	 * @param x position en X
	 * @param y position en Y
	 */
	
	public void Collision (MonJeu mj,int x, int y);
	/**
	 * Effectue l'action de l'objet
	 * @param mj jeu permettant d'agir
	 */
	public void action (MonJeu mj);
	
	public int getId();
	
	public int getY();
	
	public int getX();
	
	public boolean isPasTrouve();
	
}
