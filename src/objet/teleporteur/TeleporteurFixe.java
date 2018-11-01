package objet.teleporteur;

import java.util.List;

import monJeu.Hero;
import monJeu.MonJeu;

public class TeleporteurFixe extends Teleporteur {

	public TeleporteurFixe(List<Teleporteur> l, int x, int y) {
		super(l, x, y);
		// TODO Auto-generated constructor stub
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
