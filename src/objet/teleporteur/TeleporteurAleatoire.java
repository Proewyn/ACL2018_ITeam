package objet.teleporteur;

import java.util.List;
import java.util.Random;

import personnage.Hero;

import monJeu.MonJeu;

public class TeleporteurAleatoire extends Teleporteur {
	
	/**
	 * Cree un teleporteur non lie
	 * @param l liste des teleporteurs
	 * @param x position en X
	 * @param y position en Y
	 */
	public TeleporteurAleatoire(List<Teleporteur> l, int x, int y) {
		super(l, x, y);
	}

	@Override
	public void action(MonJeu mj) {
		Hero h= mj.getPj();
		Random r = new Random();
		int vers ;
		do{
			vers = r.nextInt(nombreTeleporteur);
		}while (vers==getNumeroDeTeleporteur());
		h.deplacer(listeTeleporteur.get(vers).getX(), listeTeleporteur.get(vers).getY());
		listeTeleporteur.get(vers).setVienDApparaitre(true);
	}

}
