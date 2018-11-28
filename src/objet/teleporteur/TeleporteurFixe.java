package objet.teleporteur;

import java.util.List;

import personnage.Hero;

import monJeu.MonJeu;

public class TeleporteurFixe extends Teleporteur {

	/**
	 * Cree un teleporteur lie
	 * @param l liste des teleporteurs
	 * @param x position en X
	 * @param y position en Y
	 */
	public TeleporteurFixe(List<Teleporteur> l, int x, int y) {
		super(l, x, y);
	}

	@Override
	public void action(MonJeu mj) {
		if (lien!=-1){
			Hero h= mj.getPj();
			h.deplacer(listeTeleporteur.get(lien).getX(), listeTeleporteur.get(lien).getY());
			listeTeleporteur.get(lien).setVienDApparaitre(true);
		}
	}

	



}
