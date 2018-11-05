package objet;

import monJeu.MonJeu;

public interface Objet {
	public void Collision (MonJeu mj,int x, int y);
	public void action (MonJeu mj);
	public int getId();
	public int getY();
	public int getX();
	public boolean isPasTrouve();
	
}
